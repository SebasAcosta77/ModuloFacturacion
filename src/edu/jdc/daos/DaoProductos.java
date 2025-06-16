
package edu.jdc.daos;
/*
import edu.jdc.clases.Bodega;
import edu.jdc.clases.CategoriaProducto;
import edu.jdc.clases.Inventario;
import edu.jdc.clases.Producto;
import edu.jdc.configuracion.Conexion;
import edu.jdc.interfaces.Funcionalidad;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DaoProductos extends Conexion implements Funcionalidad<Producto>{

    @Override
    public Boolean registrar(Producto objRegistrar) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Producto> consultar(String orden) {
        try {
            if (orden.isEmpty()) {
                orden = "p.cod_producto";

            }
            textoConsulta = "SELECT p.cod_producto, p.cod_inventario, cod_categoria, cantidad_producto, (SELECT cod_inventario FROM inventarios WHERE cod_inventario=p.cod_inventario) as codigo_inventario, "
                    + "p.cod_categoria, (SELECT nombre_categoria FROM categorias WHERE cod_categoria=p.cod_categoria) "
                    + "as nombre_categoria FROM productos p ORDER BY " + orden;

            consulta = poolConexion.prepareCall(textoConsulta);
            respuesta = consulta.executeQuery();
            List<Producto> arregloProducto = new ArrayList<>();

            while (respuesta.next()) {
                int codigoProducto = respuesta.getInt(1);
                int codigoInventario = respuesta.getInt(2);
                int codigoCategoria = respuesta.getInt(3);
                int cantidadProducto = respuesta.getInt(4);

                Date fechaInventario = respuesta.getDate(5);
                String nombreCategoria = respuesta.getString(6);
                
                

                Inventario objInventario = new Inventario(codigoInventario, 0,0,0, fechaInventario, LocalTime.MIN, LocalTime.MIN, "");
                CategoriaProducto objCategoria = new CategoriaProducto(codigoCategoria, nombreCategoria, 0, 0);

                PermisoRol objPermisoRol = new PermisoRol(objPermiso, objRol);
                arregloPermisoRol.add(objPermisoRol);

            }

            return arregloPermisoRol;
        } catch (SQLException ex) {
            Logger.getLogger(DaoProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

    @Override
    public Producto buscar(Integer llavePrimaria) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean actualizar(Producto objActualizar) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(int llavePrimaria) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer cantidadRegistros() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}*/
