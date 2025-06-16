
package edu.jdc.clases;


public class CategoriaProducto {
    private int codCategoria;
    private String nombreCategori;
    private double valorInicial;
    private double valorFinal;

    public CategoriaProducto() {
    }

    public CategoriaProducto(int codCategoria, String nombreCategori, double valorInicial, double valorFinal) {
        this.codCategoria = codCategoria;
        this.nombreCategori = nombreCategori;
        this.valorInicial = valorInicial;
        this.valorFinal = valorFinal;
    }

    public int getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(int codCategoria) {
        this.codCategoria = codCategoria;
    }

    public String getNombreCategori() {
        return nombreCategori;
    }

    public void setNombreCategori(String nombreCategori) {
        this.nombreCategori = nombreCategori;
    }

    public double getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(double valorInicial) {
        this.valorInicial = valorInicial;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }

    @Override
    public String toString() {
        return "CategoriaProducto{" + "codCategoria=" + codCategoria + ", nombreCategori=" + nombreCategori + ", valorInicial=" + valorInicial + ", valorFinal=" + valorFinal + '}';
    }
    
    
    
    
    
}
