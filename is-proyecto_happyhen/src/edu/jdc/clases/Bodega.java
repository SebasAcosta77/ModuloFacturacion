
package edu.jdc.clases;


public class Bodega {
    
    private int codBodega;
    private String nombreBodega;
    private double anchoBodega;
    private double largoBodega;

    public Bodega() {
    }

    public Bodega(int codBodega, String nombreBodega, double anchoBodega, double largoBodega) {
        this.codBodega = codBodega;
        this.nombreBodega = nombreBodega;
        this.anchoBodega = anchoBodega;
        this.largoBodega = largoBodega;
    }

    public int getCodBodega() {
        return codBodega;
    }

    public void setCodBodega(int codBodega) {
        this.codBodega = codBodega;
    }

    public String getNombreBodega() {
        return nombreBodega;
    }

    public void setNombreBodega(String nombreBodega) {
        this.nombreBodega = nombreBodega;
    }

    public double getAnchoBodega() {
        return anchoBodega;
    }

    public void setAnchoBodega(double anchoBodega) {
        this.anchoBodega = anchoBodega;
    }

    public double getLargoBodega() {
        return largoBodega;
    }

    public void setLargoBodega(double largoBodega) {
        this.largoBodega = largoBodega;
    }

    @Override
    public String toString() {
        return "Bodega{" + "codBodega=" + codBodega + ", nombreBodega=" + nombreBodega + ", anchoBodega=" + anchoBodega + ", largoBodega=" + largoBodega + '}';
    }
    
    
    
}
