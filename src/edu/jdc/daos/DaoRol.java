
package edu.jdc.daos;

import com.sun.jdi.connect.spi.Connection;
import edu.jdc.clases.Rol;
import edu.jdc.configuracion.Conexion;
import edu.jdc.interfaces.Funcionalidad;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DaoRol extends Conexion implements  Funcionalidad<Rol>{

    @Override
    public Boolean registrar(Rol objRegistrar) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Rol> consultar(String orden) {
        try {
            if(orden.isEmpty()){
                orden = "r.cod_rol";
                
            }
            
            textoConsulta = " SELECT r.cod_rol, r.nombre_rol "
                    + "FROM roles r ORDER BY " + orden;
            
            consulta = poolConexion.prepareCall(textoConsulta);
            respuesta = consulta.executeQuery();
            
            List<Rol> arregloRoles = new ArrayList<>();
            
            while(respuesta.next()) {
                int codigo = respuesta.getInt(1);
                String nombre = respuesta.getString(2);
                
                Rol objRol = new Rol(codigo, nombre);
                arregloRoles.add(objRol);
                
                
            }
            poolConexion.beginRequest();
            
            return arregloRoles;
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoRol.class.getName()).log(Level.SEVERE, null, ex);
            return null;
    }
    }

    @Override
    public Rol buscar(Integer llavePrimaria) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean actualizar(Rol objActualizar) {
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

    
    
    
}
