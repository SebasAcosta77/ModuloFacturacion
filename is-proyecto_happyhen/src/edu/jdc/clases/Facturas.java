
package edu.jdc.clases;

import java.time.LocalDate;


public class Facturas {
    private int codFactura;
    private Ventas codVenta;
    private LocalDate fechaFactura;
    private double valorFactura;

    public Facturas() {
    }

    public Facturas(int codFactura, Ventas codVenta, LocalDate fechaFactura, double valorFactura) {
        this.codFactura = codFactura;
        this.codVenta = codVenta;
        this.fechaFactura = fechaFactura;
        this.valorFactura = valorFactura;
    }

    public int getCodFactura() {
        return codFactura;
    }

    public void setCodFactura(int codFactura) {
        this.codFactura = codFactura;
    }

    public Ventas getCodVenta() {
        return codVenta;
    }

    public void setCodVenta(Ventas codVenta) {
        this.codVenta = codVenta;
    }

    public LocalDate getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(LocalDate fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public double getValorFactura() {
        return valorFactura;
    }

    public void setValorFactura(double valorFactura) {
        this.valorFactura = valorFactura;
    }

    @Override
    public String toString() {
        return "Facturas{" + "codFactura=" + codFactura + ", codVenta=" + codVenta + ", fechaFactura=" + fechaFactura + ", valorFactura=" + valorFactura + '}';
    }
    
    
    
}
