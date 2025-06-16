
package edu.jdc.clases;

import java.time.LocalDate;
import java.time.LocalTime;


public class Inventario {
    private int codInventario;
    private Usuario documentoUsuario;
    private LocalDate fechaInventario;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    
    private Galpon codGalpon;
    private Bodega codBodega;
    private int  tipoInventario;

    public Inventario() {
    }

    public Inventario(int codInventario, Usuario documentoUsuario, LocalDate fechaInventario, LocalTime horaInicio, LocalTime horaFin, Galpon codGalpon, Bodega codBodega, int tipoInventario) {
        this.codInventario = codInventario;
        this.documentoUsuario = documentoUsuario;
        this.fechaInventario = fechaInventario;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.codGalpon = codGalpon;
        this.codBodega = codBodega;
        this.tipoInventario = tipoInventario;
    }

    public int getCodInventario() {
        return codInventario;
    }

    public void setCodInventario(int codInventario) {
        this.codInventario = codInventario;
    }

    public Usuario getDocumentoUsuario() {
        return documentoUsuario;
    }

    public void setDocumentoUsuario(Usuario documentoUsuario) {
        this.documentoUsuario = documentoUsuario;
    }

    public LocalDate getFechaInventario() {
        return fechaInventario;
    }

    public void setFechaInventario(LocalDate fechaInventario) {
        this.fechaInventario = fechaInventario;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public Galpon getCodGalpon() {
        return codGalpon;
    }

    public void setCodGalpon(Galpon codGalpon) {
        this.codGalpon = codGalpon;
    }

    public Bodega getCodBodega() {
        return codBodega;
    }

    public void setCodBodega(Bodega codBodega) {
        this.codBodega = codBodega;
    }

    public int getTipoInventario() {
        return tipoInventario;
    }

    public void setTipoInventario(int tipoInventario) {
        this.tipoInventario = tipoInventario;
    }

    @Override
    public String toString() {
        return "Inventario{" + "codInventario=" + codInventario + ", documentoUsuario=" + documentoUsuario + ", fechaInventario=" + fechaInventario + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + ", codGalpon=" + codGalpon + ", codBodega=" + codBodega + ", tipoInventario=" + tipoInventario + '}';
    }

    

    

   
    
    
    
    
    
}
