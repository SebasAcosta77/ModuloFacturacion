
package edu.jdc.clases;


public class Producto {
    private int codProducto;
    private int cantidadProducto;
    private Inventario codInventario;
    private CategoriaProducto codCategoria;

    public Producto() {
    }

    public Producto(int codProducto, int cantidadProducto, Inventario codInventario, CategoriaProducto codCategoria) {
        this.codProducto = codProducto;
        this.cantidadProducto = cantidadProducto;
        this.codInventario = codInventario;
        this.codCategoria = codCategoria;
    }

    public int getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(int codProducto) {
        this.codProducto = codProducto;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public Inventario getCodInventario() {
        return codInventario;
    }

    public void setCodInventario(Inventario codInventario) {
        this.codInventario = codInventario;
    }

    public CategoriaProducto getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(CategoriaProducto codCategoria) {
        this.codCategoria = codCategoria;
    }

    @Override
    public String toString() {
        return "Producto{" + "codProducto=" + codProducto + ", cantidadProducto=" + cantidadProducto + ", codInventario=" + codInventario + ", codCategoria=" + codCategoria + '}';
    }

    

   

    

    

    

    

    

    
    
    
    
}
