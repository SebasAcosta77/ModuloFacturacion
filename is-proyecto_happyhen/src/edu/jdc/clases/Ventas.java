
package edu.jdc.clases;

import java.time.LocalDate;


public class Ventas {
    private int codVenta;
    private Bodega codBodega;
    private int cantidadVenta;
    private LocalDate fechaVenta;

    public Ventas() {
    }

    public Ventas(int codVenta, Bodega codBodega, int cantidadVenta, LocalDate fechaVenta) {
        this.codVenta = codVenta;
        this.codBodega = codBodega;
        this.cantidadVenta = cantidadVenta;
        this.fechaVenta = fechaVenta;
    }

    public int getCodVenta() {
        return codVenta;
    }

    public void setCodVenta(int codVenta) {
        this.codVenta = codVenta;
    }

    public Bodega getCodBodega() {
        return codBodega;
    }

    public void setCodBodega(Bodega codBodega) {
        this.codBodega = codBodega;
    }

    public int getCantidadVenta() {
        return cantidadVenta;
    }

    public void setCantidadVenta(int cantidadVenta) {
        this.cantidadVenta = cantidadVenta;
    }

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    @Override
    public String toString() {
        return "Ventas{" + "codVenta=" + codVenta + ", codBodega=" + codBodega + ", cantidadVenta=" + cantidadVenta + ", fechaVenta=" + fechaVenta + '}';
    }
    
    
    
}
