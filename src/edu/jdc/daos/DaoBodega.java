
package edu.jdc.daos;

import edu.jdc.clases.Bodega;
import edu.jdc.clases.Permiso;
import edu.jdc.configuracion.Conexion;
import edu.jdc.interfaces.BodegaFun;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DaoBodega extends Conexion implements BodegaFun<Bodega>{

    @Override
    public Boolean registrar(Bodega objRegistrar) {
         textoConsulta = "INSERT INTO bodegas ( nombre_bodega, ancho_bodega, largo_bodega ) VALUES (?,?,?)";
         
         try{
             consulta = poolConexion.prepareCall(textoConsulta);
             consulta.setString(1, objRegistrar.getNombreBodega());
             consulta.setDouble(2, objRegistrar.getAnchoBodega());
             consulta.setDouble(3, objRegistrar.getLargoBodega());
             
            cantidad = consulta.executeUpdate();
            poolConexion.close();
            return cantidad > 0;
             
         } catch (SQLException ex) {
            Logger.getLogger(DaoBodega.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public List<Bodega> consultar(String orden) {
        try{
            if(orden.isEmpty()){
            orden = "b.cod_bodega";
            
        }
        textoConsulta = " SELECT b.cod_bodega,  b.nombre_bodega,  b.ancho_bodega, b.largo_bodega " + "From bodegas b ORDER BY "+ orden;
        
            consulta = poolConexion.prepareCall(textoConsulta);
            
            respuesta= consulta.executeQuery();
            List<Bodega> arregloBodegas = new ArrayList<>();
            
            while (respuesta.next()){
                int codigoBodega = respuesta.getInt(1);
                String nombreBodega = respuesta.getString(2);
                Double anchoBodega = respuesta.getDouble(3);
                Double largoBodega = respuesta.getDouble(4);
                
                Bodega ObjBodega = new Bodega(codigoBodega, nombreBodega, anchoBodega, largoBodega);
                arregloBodegas.add(ObjBodega);
                
            }
            poolConexion.beginRequest();
            return arregloBodegas;
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoBodega.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        
    }

    @Override
    public Bodega buscar(Integer llavePrimaria) {
       try{
           textoConsulta = " SELECT  cod_bodega , nombre_bodega , ancho_bodega, largo_bodega "
                      + "FROM bodegas WHERE cod_bodega = ?";
           consulta = poolConexion.prepareCall(textoConsulta);
           consulta.setInt(1, llavePrimaria);
           respuesta = consulta.executeQuery();
        
        Bodega objEncontrado = null;
        
        if(respuesta.next()){
            int codigoBodega = respuesta.getInt(1);
            String nombreBodega = respuesta.getString(2);
            Double anchoBodega = respuesta.getDouble(3);
            Double largoBodega = respuesta.getDouble(4);
            
           objEncontrado = new Bodega(codigoBodega, nombreBodega, anchoBodega, largoBodega);
        }
        poolConexion.beginRequest();
        return objEncontrado;
           
       } catch (SQLException ex) {
            Logger.getLogger(DaoBodega.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public boolean actualizar(Bodega objActualizar) {
         try{
             textoConsulta = "UPDATE bodegas SET nombre_bodega = ?, "
                    + " ancho_bodega=?,  largo_bodega=? WHERE cod_bodega=?";
             
            consulta = poolConexion.prepareCall(textoConsulta);
            consulta.setString(1, objActualizar.getNombreBodega());
            consulta.setDouble(2, objActualizar.getAnchoBodega());
            consulta.setDouble(3, objActualizar.getLargoBodega());
            consulta.setInt(4, objActualizar.getCodBodega());
            
            cantidad = consulta.executeUpdate();
            
            poolConexion.beginRequest();
            return cantidad > 0;
            
            
         } catch (SQLException ex) {
            Logger.getLogger(DaoBodega.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean eliminar(int llavePrimaria) {
        try{
            textoConsulta = "DELETE FROM bodegas WHERE cod_bodega=?";
            
            consulta = poolConexion.prepareCall(textoConsulta);
            consulta.setInt(1, llavePrimaria);
            cantidad = consulta.executeUpdate();
            poolConexion.beginRequest();
            return cantidad >0;
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoBodega.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public ArrayList<Bodega> obtenerBodegas() {
    ArrayList<Bodega> listaBodegas = new ArrayList<>();

    try {
        String textoConsulta = "SELECT cod_bodega, nombre_bodega FROM bodegas";
        consulta = poolConexion.prepareCall(textoConsulta);
        respuesta = consulta.executeQuery();

        while (respuesta.next()) {
            int codigoBodega = respuesta.getInt("cod_bodega");
            String nombreBodega = respuesta.getString("nombre_bodega");

            Bodega bodega = new Bodega(codigoBodega, nombreBodega, 0.0, 0.0);
            listaBodegas.add(bodega);
        }

        // Cerrar recursos
        respuesta.close();
        
    } catch (SQLException e) {
        e.printStackTrace();
        // Manejar la excepción apropiadamente
    }

    return listaBodegas;
}
    

    @Override
    public Integer cantidadRegistros() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
