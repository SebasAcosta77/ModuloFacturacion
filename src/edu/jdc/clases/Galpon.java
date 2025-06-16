
package edu.jdc.clases;


public class Galpon {
    private int codGalpon;
    private int cantidadgallinas;
    private double ancho;
    private double largo;

    public Galpon() {
    }

    public Galpon(int codGalpon, int cantidadgallinas, double ancho, double largo) {
        this.codGalpon = codGalpon;
        this.cantidadgallinas = cantidadgallinas;
        this.ancho = ancho;
        this.largo = largo;
    }

    public int getCodGalpon() {
        return codGalpon;
    }

    public void setCodGalpon(int codGalpon) {
        this.codGalpon = codGalpon;
    }

    public int getCantidadgallinas() {
        return cantidadgallinas;
    }

    public void setCantidadgallinas(int cantidadgallinas) {
        this.cantidadgallinas = cantidadgallinas;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getLargo() {
        return largo;
    }

    public void setLargo(double largo) {
        this.largo = largo;
    }

    @Override
    public String toString() {
        return "Galpon{" + "codGalpon=" + codGalpon + ", cantidadgallinas=" + cantidadgallinas + ", ancho=" + ancho + ", largo=" + largo + '}';
    }
    
    
    
}
