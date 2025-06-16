
package edu.jdc.clases;


public class Usuario {
    
    private String documentoUsuario;
    private String nombreUsuario;
    private String apellidoUsuario;
    private String telefonoUsuario;
    private Rol codrol;

    public Usuario() {
    }

    public Usuario(String documentoUsuario, String nombreUsuario, String apellidoUsuario, String telefonoUsuario, Rol codrol) {
        this.documentoUsuario = documentoUsuario;
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.telefonoUsuario = telefonoUsuario;
        this.codrol = codrol;
    }

    public String getDocumentoUsuario() {
        return documentoUsuario;
    }

    public void setDocumentoUsuario(String documentoUsuario) {
        this.documentoUsuario = documentoUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getTelefonoUsuario() {
        return telefonoUsuario;
    }

    public void setTelefonoUsuario(String telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }

    public Rol getCodrol() {
        return codrol;
    }

    public void setCodrol(Rol codrol) {
        this.codrol = codrol;
    }

    @Override
    public String toString() {
        return "Usuario{" + "documentoUsuario=" + documentoUsuario + ", nombreUsuario=" + nombreUsuario + ", apellidoUsuario=" + apellidoUsuario + ", telefonoUsuario=" + telefonoUsuario + ", codrol=" + codrol + '}';
    }

    

    
    
    
    
}
