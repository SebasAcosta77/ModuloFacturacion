package edu.jdc.daos;

import edu.jdc.clases.Permiso;
import edu.jdc.configuracion.Conexion;
import edu.jdc.interfaces.Funcionalidad;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
// Un DAO es una clase que proporciona métodos para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar)

public class DaoPermiso extends Conexion implements Funcionalidad<Permiso> {
//Este método se encarga de insertar un nuevo permiso en la base de datos. Toma un objeto Permiso como parámetro y utiliza una 
//consulta preparada para realizar la inserción. Devuelve un booleano indicando si la operación tuvo éxito.

    @Override
    public Boolean registrar(Permiso objRegistrar) {
        textoConsulta = "INSERT INTO permisos ( nombre_permiso, funcionalidad_permiso ) VALUES (?,?)";

        try {
            consulta = poolConexion.prepareCall(textoConsulta);
            consulta.setString(1, objRegistrar.getNombrePermiso());
            consulta.setString(2, objRegistrar.getFuncionalidadPermiso());

            cantidad = consulta.executeUpdate();
            poolConexion.close();
            return cantidad > 0;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DaoPermiso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            return false;
        }

    }
    // Consulta todos los permisos de la base de datos, ordenados según el parámetro proporcionado (orden). Si no se proporciona un orden, 
    //se ordenan por el código del permiso por defecto creo no se . Devuelve una lista de objetos Permiso.

    @Override
    public List<Permiso> consultar(String orden) {
        try {
            if (orden.isEmpty()) {
                orden = "p.cod_permiso";

            }
            textoConsulta = " SELECT p.cod_permiso,  p.nombre_permiso,  p.funcionalidad_permiso,"
                    + " (SELECT COUNT(cod_permiso) FROM permiso_rol WHERE cod_permiso = p.cod_permiso) AS cantRol  "
                    + "From permisos p ORDER BY " + orden;

            consulta = poolConexion.prepareCall(textoConsulta);
            respuesta = consulta.executeQuery();
            List<Permiso> arregloPermisos = new ArrayList<>();

            while (respuesta.next()) {
                int codigo = respuesta.getInt(1);
                String nombre = respuesta.getString(2);
                String Funcionalidad = respuesta.getString(3);
                int cant = respuesta.getInt(4);

                Permiso ObjPermiso = new Permiso(codigo, nombre, Funcionalidad, cant);
                arregloPermisos.add(ObjPermiso);

            }
            poolConexion.beginRequest();
            return arregloPermisos;

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DaoPermiso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            return null;
        }
    }
    //Busca un permiso en la base de datos según su llave primaria (código del permiso). 
    //Devuelve un objeto Permiso si se encuentra, o null si no existe.   

    @Override
    public Permiso buscar(Integer llavePrimaria) {
        try {
            textoConsulta = " SELECT  p.cod_permiso , p.nombre_permiso , p.funcionalidad_permiso,"
                    + "(SELECT COUNT(cod_permiso) FROM permiso_rol WHERE cod_permiso = p.cod_permiso) as cantRol "
                    + "FROM permisos p WHERE p.cod_permiso =?";

            consulta = poolConexion.prepareCall(textoConsulta);
            consulta.setInt(1, llavePrimaria);

            respuesta = consulta.executeQuery();

            Permiso objEncontrado = null;

            if (respuesta.next()) {
                int codigo = respuesta.getInt(1);
                String nombre = respuesta.getString(2);
                String funcionalidad = respuesta.getString(3);
                int cant = respuesta.getInt(4);

                objEncontrado = new Permiso(codigo, nombre, funcionalidad, cant);
            }
            poolConexion.beginRequest();
            return objEncontrado;

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DaoPermiso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            return null;
        }

    }

//Actualiza la información de un permiso en la base de datos. Toma un objeto Permiso como parámetro y utiliza una consulta preparada para realizar la actualización. 
//Devuelve un booleano indicando si la operación tuvo éxito.    
    @Override
    public boolean actualizar(Permiso objActualizar) {
        try {
            textoConsulta = "UPDATE permisos SET nombre_permiso = ?, "
                    + " funcionalidad_permiso =? WHERE cod_permiso=?";

            consulta = poolConexion.prepareCall(textoConsulta);

            consulta.setString(1, objActualizar.getNombrePermiso());
            consulta.setString(2, objActualizar.getFuncionalidadPermiso());
            consulta.setInt(3, objActualizar.getCodPermiso());

            cantidad = consulta.executeUpdate();

            poolConexion.beginRequest();
            return cantidad > 0;

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DaoPermiso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            return false;

        }

    }
//Elimina un permiso de la base de datos según su llave primaria (código del permiso). 
//Devuelve un booleano indicando si la operación tuvo éxito.

    @Override
    public boolean eliminar(int llavePrimaria) {
        try {
            textoConsulta = "DELETE FROM permisos WHERE cod_permiso=?";

            consulta = poolConexion.prepareCall(textoConsulta);
            consulta.setInt(1, llavePrimaria);
            cantidad = consulta.executeUpdate();
            poolConexion.beginRequest();
            return cantidad > 0;

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DaoPermiso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            return false;
        }

    }

    @Override
    public Integer cantidadRegistros() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
