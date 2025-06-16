package edu.jdc.daos;

import edu.jdc.clases.Bodega;
import edu.jdc.clases.Permiso;
import edu.jdc.clases.Ventas;
import edu.jdc.configuracion.Conexion;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import edu.jdc.interfaces.VentasFuncion;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.*;
import java.util.List;

public class DaoVentas extends Conexion implements VentasFuncion<Ventas> {

    @Override
    public Boolean registrar(Ventas objRegistrar) {
        textoConsulta = "INSERT INTO ventas (cod_bodega, cantidad_venta, fecha_venta) VALUES (?,?,?)";

        try {
            LocalDate fechaVenta = objRegistrar.getFechaVenta();
            java.sql.Date fechaVentaSQL = java.sql.Date.valueOf(fechaVenta);

            Bodega bodega = objRegistrar.getCodBodega();
            if (bodega != null) {
            int codBodega = bodega.getCodBodega();
            
            consulta = poolConexion.prepareStatement(textoConsulta);
            consulta.setInt(1, codBodega);
            consulta.setInt(2, objRegistrar.getCantidadVenta());
            consulta.setDate(3, fechaVentaSQL);

            cantidad = consulta.executeUpdate();
            poolConexion.close();
            return cantidad > 0;
        } else {
            throw new IllegalArgumentException("El objeto Bodega en la venta es nulo.");
        }

        } catch (SQLException ex) {
            Logger.getLogger(DaoVentas.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean actualizar(Ventas objActualizar) {
        try {
            textoConsulta = "UPDATE ventas SET cod_bodega = ?, cantidad_venta = ?, fecha_venta = ? WHERE cod_venta = ?";
            LocalDate fechaVenta = objActualizar.getFechaVenta();// convertimos localdate en date para la sentencia sql
            java.sql.Date fechaVentaSQL = java.sql.Date.valueOf(fechaVenta);

            consulta = poolConexion.prepareCall(textoConsulta);

            consulta.setObject(1, objActualizar.getCodBodega()); // pendiente
            consulta.setInt(2, objActualizar.getCantidadVenta());
            consulta.setDate(3, fechaVentaSQL);

            cantidad = consulta.executeUpdate();

            poolConexion.beginRequest();
            return cantidad > 0;

        } catch (SQLException ex) {
            Logger.getLogger(DaoVentas.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean eliminar(int llavePrimaria) {
        try {
            textoConsulta = "DELETE FROM ventas WHERE cod_venta=?";

            consulta = poolConexion.prepareCall(textoConsulta);
            consulta.setInt(1, llavePrimaria);
            cantidad = consulta.executeUpdate();
            poolConexion.beginRequest();
            return cantidad > 0;

        } catch (SQLException ex) {
            Logger.getLogger(DaoVentas.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    
    

    @Override
    public List<Ventas> consultar(String orden) {
        List<Ventas> arregloVentas = new ArrayList<>();
        try {
            if (orden.isEmpty()) {
            orden = "v.cod_venta";
        }

        textoConsulta = "SELECT v.cod_venta, v.cod_bodega, v.cantidad_venta, v.fecha_venta FROM ventas v ORDER BY " + orden;

        consulta = poolConexion.prepareStatement(textoConsulta);
        respuesta = consulta.executeQuery();

        // Verificar si la consulta SQL devuelve resultados
        while (respuesta.next()) {
            int codigoVenta = respuesta.getInt(1);
            int codBodega = respuesta.getInt(2); // Cambiado a int
            int cantidadVenta = respuesta.getInt(3);
            LocalDate fechaVentaLocalDate = respuesta.getDate(4).toLocalDate();

            // Aquí llamas al método de DaoBodega para obtener la Bodega
            Bodega bodega = obtenerBodegaPorCodigo(codBodega); // Necesitas implementar este método en DaoBodega

            // Luego, creas el objeto Ventas con los datos recuperados
            Ventas objVenta = new Ventas(codigoVenta, bodega, cantidadVenta, fechaVentaLocalDate);

            // Agregas el objeto Ventas a la lista
            arregloVentas.add(objVenta);
        }

        poolConexion.beginRequest();
        return arregloVentas;

        } catch (SQLException ex) {
            Logger.getLogger(DaoVentas.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        finally {
        // Asegúrate de cerrar el ResultSet y la conexión en el bloque finally
        if (respuesta != null) {
            try {
                respuesta.close();
            } catch (SQLException ex) {
                Logger.getLogger(DaoVentas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (poolConexion != null) {
            try {
                poolConexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(DaoVentas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    }

    @Override
    public Ventas buscar(Integer llavePrimaria) {
        try {
            textoConsulta = " SELECT  cod_venta , cod_bodega , cantidad_bodega, fecha_bodega "
                    + "FROM bodegas WHERE cod_bodega = ?";

            consulta = poolConexion.prepareCall(textoConsulta);
            consulta.setInt(1, llavePrimaria);

            respuesta = consulta.executeQuery();

            Ventas objEncontrado = null;

            if (respuesta.next()) {
                int codigoVenta = respuesta.getInt(1);
                Object codBodega = respuesta.getObject(2);
                int canttidadVenta = respuesta.getInt(3);
                LocalDate fechaVentaLocalDate = respuesta.getDate(4).toLocalDate();

                objEncontrado = new Ventas(codigoVenta, (Bodega) codBodega, canttidadVenta, fechaVentaLocalDate);
            }
            poolConexion.beginRequest();
            return objEncontrado;
        } catch (SQLException ex) {
            Logger.getLogger(DaoVentas.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public Bodega obtenerBodegaPorCodigo(int codigoBodega) {
    Bodega bodega = null;
    try {
        String textoConsulta = "SELECT cod_bodega, nombre_bodega, ancho_bodega, largo_bodega FROM bodegas WHERE cod_bodega = ?";
        consulta = poolConexion.prepareCall(textoConsulta);
        consulta.setInt(1, codigoBodega);
        respuesta = consulta.executeQuery();

        if (respuesta.next()) {
            int codigo = respuesta.getInt("cod_bodega");
            String nombre = respuesta.getString("nombre_bodega");
            double ancho = respuesta.getDouble("ancho_bodega");
            double largo = respuesta.getDouble("largo_bodega");
            bodega = new Bodega(codigo, nombre, ancho, largo);
        }

        // Cerrar recursos
        respuesta.close();
        
    } catch (SQLException e) {
        e.printStackTrace();
        // Manejar la excepción apropiadamente
    }

    return bodega;
}
    public int registrarVenta(Ventas objRegistrar) {
        try {
            textoConsulta = "INSERT INTO ventas (cod_bodega, cantidad_venta, fecha_venta) VALUES (?,?,?) returning cod_venta";

            LocalDate fechaVenta = objRegistrar.getFechaVenta();
            java.sql.Date fechaVentaSQL = java.sql.Date.valueOf(fechaVenta);
            

            int codVenta = 0;

            consulta = poolConexion.prepareStatement(textoConsulta);
            consulta.setInt(1, objRegistrar.getCodBodega().getCodBodega());
            consulta.setInt(2, objRegistrar.getCantidadVenta());
            consulta.setDate(3, fechaVentaSQL);

            ResultSet resultado = consulta.executeQuery();

            if (resultado.next()) {
                codVenta = resultado.getInt("cod_venta");
            }

            poolConexion.close();
            return codVenta;

        } catch (SQLException ex) {
            Logger.getLogger(DaoVentas.class.getName()).log(Level.SEVERE, null, ex);
            return 0; 
        }
    }

}
