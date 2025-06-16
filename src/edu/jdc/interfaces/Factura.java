
package edu.jdc.interfaces;

import java.util.List;


public interface Factura <T> {
    public Boolean registrar(T objRegistrar);
    
    public List<T> consultar(String orden);
    
    public T buscar(Integer llavePrimaria);
    
    public boolean actualizar(T objActualizar);
    
    public boolean eliminar(int llavePrimaria);
    
    public Integer cantidadRegistros();
    
}
