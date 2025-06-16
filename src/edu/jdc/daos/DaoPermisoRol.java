package edu.jdc.daos;

import edu.jdc.clases.Permiso;
import edu.jdc.clases.PermisoRol;
import edu.jdc.clases.Rol;
import edu.jdc.configuracion.Conexion;
import edu.jdc.interfaces.Funcionalidad;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoPermisoRol extends Conexion implements Funcionalidad<PermisoRol> {

    @Override
    public Boolean registrar(PermisoRol objRegistrar) {
        try {
            textoConsulta = "INSERT INTO permiso_rol(cod_rol, cod_permiso) VALUES (?,?) ";

            consulta = poolConexion.prepareCall(textoConsulta);

            consulta.setInt(1, objRegistrar.getCodRol().getCodRol());
            consulta.setInt(2, objRegistrar.getCodPermiso().getCodPermiso());

            cantidad = consulta.executeUpdate();

            poolConexion.beginRequest();
            return cantidad > 0;

        } catch (SQLException ex) {
            Logger.getLogger(DaoPermisoRol.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public boolean VerificarPermisorol(PermisoRol objPermisorol) {
        try {
            boolean verificar = false;

            textoConsulta = " SELECT cod_permiso, cod_rol "
                    + " FROM permiso_rol WHERE cod_permiso =? AND cod_rol=? ";

            consulta = poolConexion.prepareCall(textoConsulta);
            consulta.setInt(1, objPermisorol.getCodPermiso().getCodPermiso());
            consulta.setInt(2, objPermisorol.getCodRol().getCodRol());

            respuesta = consulta.executeQuery();

            if (respuesta.next()) {
                verificar = true;
            }

            poolConexion.beginRequest();

            return verificar;
        } catch (SQLException ex) {
            Logger.getLogger(DaoPermisoRol.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public List<PermisoRol> consultar(String orden) {
        try {
            if (orden.isEmpty()) {
                orden = "p.cod_permiso";

            }
            textoConsulta = "SELECT p.cod_rol, p.cod_permiso, (SELECT nombre_rol FROM roles WHERE cod_rol=p.cod_rol) as nombre_rol, "
                    + "p.cod_permiso, (SELECT nombre_permiso FROM permisos WHERE cod_permiso=p.cod_permiso) "
                    + "as nombre_permiso FROM permiso_rol p ORDER BY " + orden;

            consulta = poolConexion.prepareCall(textoConsulta);
            respuesta = consulta.executeQuery();
            List<PermisoRol> arregloPermisoRol = new ArrayList<>();

            while (respuesta.next()) {
                int codigoRol = respuesta.getInt(1);
                int codigoPermiso = respuesta.getInt(2);

                String nombreRol = respuesta.getString(3);
                String nombrePermiso = respuesta.getString(4);

                Rol objRol = new Rol(codigoRol, nombreRol);
                Permiso objPermiso = new Permiso(codigoPermiso, nombrePermiso, "", 0);

                PermisoRol objPermisoRol = new PermisoRol(objPermiso, objRol);
                arregloPermisoRol.add(objPermisoRol);

            }

            return arregloPermisoRol;

        } catch (SQLException ex) {
            Logger.getLogger(DaoPermisoRol.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public Boolean verificarPermisoRol(PermisoRol objPermisoRol) {
        try {
            boolean verificar = false;

            textoConsulta = "SELECT cod_permiso, cod_rol "
                    + "FROM permiso_rol WHERE cod_permiso=?, AND cod_rol=?";

            consulta = poolConexion.prepareCall(textoConsulta);

            consulta.setInt(1, objPermisoRol.getCodPermiso().getCodPermiso());
            consulta.setInt(2, objPermisoRol.getCodRol().getCodRol());

            respuesta = consulta.executeQuery();

            if (respuesta.next()) {
                verificar = true;
            }
            poolConexion.beginRequest();

            return verificar;
        } catch (SQLException ex) {
            Logger.getLogger(DaoPermisoRol.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    @Override
    public PermisoRol buscar(Integer llavePrimaria) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean actualizar(PermisoRol objActualizar) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(int llavePrimaria) {
        try {
            textoConsulta = "DELETE FROM permiso_rol WHERE cod_permiso=?";

            consulta = poolConexion.prepareCall(textoConsulta);
            consulta.setInt(1, llavePrimaria);
            
            cantidad = consulta.executeUpdate();
            poolConexion.beginRequest();
            return cantidad > 0;

        } catch (SQLException ex) {
            Logger.getLogger(DaoPermisoRol.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean eliminar(int codRol, int codPermiso){

        try {
            textoConsulta = "DELETE FROM permiso_rol WHERE cod_rol=? AND cod_permiso=?";

            consulta = poolConexion.prepareCall(textoConsulta);
            consulta.setInt(1, codRol);
            consulta.setInt(2, codPermiso);
            cantidad = consulta.executeUpdate();
            poolConexion.beginRequest();
            return cantidad > 0;

        } catch (SQLException ex) {
            Logger.getLogger(DaoPermisoRol.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    @Override
    public Integer cantidadRegistros() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
