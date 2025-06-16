
package edu.jdc.clases;


public class Acceso {
    private Usuario documentoUsuario;
    private String correoAcceso;
    private String claveUsuario;

    public Acceso() {
    }

    public Acceso(Usuario documentoUsuario, String correoAcceso, String claveUsuario) {
        this.documentoUsuario = documentoUsuario;
        this.correoAcceso = correoAcceso;
        this.claveUsuario = claveUsuario;
    }

    public Usuario getDocumentoUsuario() {
        return documentoUsuario;
    }

    public void setDocumentoUsuario(Usuario documentoUsuario) {
        this.documentoUsuario = documentoUsuario;
    }

    public String getCorreoAcceso() {
        return correoAcceso;
    }

    public void setCorreoAcceso(String correoAcceso) {
        this.correoAcceso = correoAcceso;
    }

    public String getClaveUsuario() {
        return claveUsuario;
    }

    public void setClaveUsuario(String claveUsuario) {
        this.claveUsuario = claveUsuario;
    }

    @Override
    public String toString() {
        return "Acceso{" + "documentoUsuario=" + documentoUsuario + ", correoAcceso=" + correoAcceso + ", claveUsuario=" + claveUsuario + '}';
    }
    
    
    
}
