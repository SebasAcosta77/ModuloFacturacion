
package edu.jdc.clases;


public class PermisoRol {
    
    
    private Permiso codPermiso;
    private Rol codRol;
    
    
    public PermisoRol(){
        
    }

    public PermisoRol(Permiso codPermiso, Rol codRol) {
        this.codPermiso = codPermiso;
        this.codRol = codRol;
    }

    public Permiso getCodPermiso() {
        return codPermiso;
    }

    public void setCodPermiso(Permiso codPermiso) {
        this.codPermiso = codPermiso;
    }

    public Rol getCodRol() {
        return codRol;
    }

    public void setCodRol(Rol codRol) {
        this.codRol = codRol;
    }

    @Override
    public String toString() {
        return "PermisoRol{" + "codPermiso=" + codPermiso + ", codRol=" + codRol + '}';
    }
    
    
}
