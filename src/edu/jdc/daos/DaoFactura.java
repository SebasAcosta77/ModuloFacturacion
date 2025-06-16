package edu.jdc.daos;

import edu.jdc.clases.Bodega;
import edu.jdc.clases.Facturas;
import edu.jdc.clases.Ventas;
import edu.jdc.configuracion.Conexion;
import edu.jdc.interfaces.Factura;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoFactura extends Conexion implements Factura<Facturas> {

    @Override
    public Boolean registrar(Facturas objRegistrar) {
        try {
            textoConsulta = "INSERT INTO factura (cod_venta, fecha_factura, valor_factura) VALUES (?,?,?)";
            LocalDate fechaFactura = objRegistrar.getFechaFactura();
            Date fechaFacturaSQL= java.sql.Date.valueOf(fechaFactura);

        
                consulta = poolConexion.prepareCall(textoConsulta);
                consulta.setInt(1, objRegistrar.getCodVenta().getCodVenta());
                consulta.setDate(2, (java.sql.Date) fechaFacturaSQL);
                consulta.setDouble(3, objRegistrar.getValorFactura());

                cantidad = consulta.executeUpdate();
                poolConexion.close();
                return cantidad > 0;
           

        } catch (SQLException ex) {
            Logger.getLogger(DaoFactura.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    @Override
    public List<Facturas> consultar(String orden) {
        try {
            if (orden.isEmpty()) {
                orden = "v.cod_factura";

            }
            textoConsulta = " SELECT f.cod_factura,  f.cod_venta,  f.fecha_factura, f.valor_factura " + "From factura f ORDER BY " + orden;

            consulta = poolConexion.prepareCall(textoConsulta);
            respuesta = consulta.executeQuery();
            List<Facturas> arregloFacturas = new ArrayList<>();

            while (respuesta.next()) {
                int codigoFactura = respuesta.getInt(1);
                Object codVenta = respuesta.getObject(2);
                LocalDate fechafacturaLocalDate = respuesta.getDate(3).toLocalDate();
                double valorFactura = respuesta.getDouble(4);

                Facturas objFactura = new Facturas(codigoFactura, (Ventas) codVenta, fechafacturaLocalDate, valorFactura);

            }
            poolConexion.beginRequest();
            return arregloFacturas;

        } catch (SQLException ex) {
            Logger.getLogger(DaoFactura.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Facturas buscar(Integer llavePrimaria) {
        try {
            textoConsulta = " SELECT  cod_factura , cod_venta , fecha_factura, valor_factura "
                    + "FROM factura WHERE cod_factura = ?";
            consulta = poolConexion.prepareCall(textoConsulta);
            consulta.setInt(1, llavePrimaria);

            respuesta = consulta.executeQuery();

            Facturas objEncontrado = null;

            if (respuesta.next()) {
                int codigoFactura = respuesta.getInt(1);
                Object codVenta = respuesta.getObject(2);
                LocalDate fechaFacturaLocalDate = respuesta.getDate(3).toLocalDate();
                double valorFactura = respuesta.getDouble(4);

                objEncontrado = new Facturas(codigoFactura, (Ventas) codVenta, fechaFacturaLocalDate, valorFactura);
            }
            poolConexion.beginRequest();
            return objEncontrado;

        } catch (SQLException ex) {
            Logger.getLogger(DaoFactura.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public boolean actualizar(Facturas objActualizar) {
        try {
            textoConsulta = "UPDATE factura SET cod_venta = ?, fecha_factura = ?, valor_factura = ? WHERE cod_factura = ?";
            LocalDate fechaFactura = objActualizar.getFechaFactura();// convertimos localdate en date para la sentencia sql
            java.sql.Date fechaFacturaSQL = java.sql.Date.valueOf(fechaFactura);

            consulta = poolConexion.prepareCall(textoConsulta);

            consulta.setObject(1, objActualizar.getCodVenta()); // pendient
            consulta.setDate(2, fechaFacturaSQL);
            consulta.setDouble(3, objActualizar.getValorFactura());

            cantidad = consulta.executeUpdate();

            poolConexion.beginRequest();
            return cantidad > 0;

        } catch (SQLException ex) {
            Logger.getLogger(DaoFactura.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean eliminar(int llavePrimaria) {
        try {
            textoConsulta = "DELETE FROM factura WHERE cod_factura=?";

            consulta = poolConexion.prepareCall(textoConsulta);

            consulta = poolConexion.prepareCall(textoConsulta);
            consulta.setInt(1, llavePrimaria);
            cantidad = consulta.executeUpdate();
            poolConexion.beginRequest();
            return cantidad > 0;

        } catch (SQLException ex) {
            Logger.getLogger(DaoFactura.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public Integer cantidadRegistros() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
