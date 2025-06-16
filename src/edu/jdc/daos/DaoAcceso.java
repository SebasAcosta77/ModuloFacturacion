
package edu.jdc.daos;

import edu.jdc.clases.Acceso;
import edu.jdc.clases.Rol;
import edu.jdc.clases.Usuario;
import edu.jdc.configuracion.Conexion;
import edu.jdc.interfaces.Sesion;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DaoAcceso extends Conexion implements Sesion<Acceso>{

    @Override
    public Usuario iniciosesion(Acceso objSesion) {
        try {
       textoConsulta = "SELECT u.documento_usuario, u.nombres_usuario, u.apellidos_usuario, "
               + "u.telefono_usuario, (SELECT nombre_rol FROM roles WHERE cod_rol=u.cod_rol) "
               + "as nombre_rol "
               + " FROM usuarios u INNER JOIN accesos a ON u.documento_usuario=a.documento_usuario "
               + "WHERE a.correo_acceso=? AND a.clave_acceso=?";
            consulta = poolConexion.prepareCall(textoConsulta);
            consulta.setString(1, objSesion.getCorreoAcceso());
            consulta.setString(2, objSesion.getClaveUsuario());
            
            respuesta = consulta.executeQuery();
            
            Usuario objusuario = null;
            
            if(respuesta.next()){
                String documento = respuesta.getString(1);
                String nombre = respuesta.getString(2);
                String apellidos = respuesta.getString(3);
                String telefono = respuesta.getString(4);
                String nombreRol = respuesta.getString(5);
                
                Rol objRol = new Rol();
                objusuario = new Usuario(documento, nombre, apellidos, telefono, objRol);
            }
            poolConexion.beginRequest();
            return objusuario;
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoAcceso.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
}
