
package edu.jdc.clases;


public class Permiso {
    private int codPermiso;
    private String nombrePermiso;
    private String funcionalidadPermiso;
    private int cantidadPermisoRol ;
    
    public Permiso(){
        
    }

    public Permiso(int codPermiso, String nombrePermiso, String funcionalidadPermiso, int cantidadPermisoRol) {
        this.codPermiso = codPermiso;
        this.nombrePermiso = nombrePermiso;
        this.funcionalidadPermiso = funcionalidadPermiso;
        this.cantidadPermisoRol = cantidadPermisoRol;
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

    public int getCantidadPermisoRol() {
        return cantidadPermisoRol;
    }

    public void setCantidadPermisoRol(int cantidadPermisoRol) {
        this.cantidadPermisoRol = cantidadPermisoRol;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.codPermiso;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Permiso other = (Permiso) obj;
        return this.codPermiso == other.codPermiso;
    }
    

    @Override
    public String toString() {
        return "Permiso{" + "codPermiso=" + codPermiso + ", nombrePermiso=" + nombrePermiso + ", funcionalidadPermiso=" + funcionalidadPermiso + ", cantidadPermisoRol=" + cantidadPermisoRol + '}';
    }

    

    
    
    
}
