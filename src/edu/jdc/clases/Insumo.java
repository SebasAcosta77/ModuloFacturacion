
package edu.jdc.clases;


public class Insumo {
    private int codInsumo;
    private Inventario codInventario;
    private double valorInsumo;
    private int cantidadInsumo;
    private int tipoInsumo;

    public Insumo() {
    }

    public Insumo(int codInsumo, Inventario codInventario, double valorInsumo, int cantidadInsumo, int tipoInsumo) {
        this.codInsumo = codInsumo;
        this.codInventario = codInventario;
        this.valorInsumo = valorInsumo;
        this.cantidadInsumo = cantidadInsumo;
        this.tipoInsumo = tipoInsumo;
    }

    public int getCodInsumo() {
        return codInsumo;
    }

    public void setCodInsumo(int codInsumo) {
        this.codInsumo = codInsumo;
    }

    public Inventario getCodInventario() {
        return codInventario;
    }

    public void setCodInventario(Inventario codInventario) {
        this.codInventario = codInventario;
    }

    public double getValorInsumo() {
        return valorInsumo;
    }

    public void setValorInsumo(double valorInsumo) {
        this.valorInsumo = valorInsumo;
    }

    public int getCantidadInsumo() {
        return cantidadInsumo;
    }

    public void setCantidadInsumo(int cantidadInsumo) {
        this.cantidadInsumo = cantidadInsumo;
    }

    public int getTipoInsumo() {
        return tipoInsumo;
    }

    public void setTipoInsumo(int tipoInsumo) {
        this.tipoInsumo = tipoInsumo;
    }

    @Override
    public String toString() {
        return "Insumo{" + "codInsumo=" + codInsumo + ", codInventario=" + codInventario + ", valorInsumo=" + valorInsumo + ", cantidadInsumo=" + cantidadInsumo + ", tipoInsumo=" + tipoInsumo + '}';
    }
    
    
            
    
}
