
package edu.jdc.clases;


public class Permiso {
    private int codPermiso;
    private String nombrePermiso;
    private String funcionalidadPermiso;
    
    public Permiso(){
        
    }

    public Permiso(int codPermiso, String nombrePermiso, String funcionalidadPermiso) {
        this.codPermiso = codPermiso;
        this.nombrePermiso = nombrePermiso;
        this.funcionalidadPermiso = funcionalidadPermiso;
    }

    public int getCodPermiso() {
        return codPermiso;
    }

    public void setCodPermiso(int codPermiso) {
        this.codPermiso = codPermiso;
    }

    public String getNombrePermiso() {
        return nombrePermiso;
    }

    public void setNombrePermiso(String nombrePermiso) {
        this.nombrePermiso = nombrePermiso;
    }

    public String getFuncionalidadPermiso() {
        return funcionalidadPermiso;
    }

    public void setFuncionalidadPermiso(String funcionalidadPermiso) {
        this.funcionalidadPermiso = funcionalidadPermiso;
    }

    @Override
    public String toString() {
        return "Permiso{" + "codPermiso=" + codPermiso + ", nombrePermiso=" + nombrePermiso + ", funcionalidadPermiso=" + funcionalidadPermiso + '}';
    }
    
    
}
