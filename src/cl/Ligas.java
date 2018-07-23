
package cl;

import java.time.LocalDate;


public class Ligas {
    
    private String nombreLiga;
    private LocalDate fechaCreacion;
    private boolean estado;

    public Ligas() {
    }

    public Ligas(String nombreLiga, LocalDate fechaCreacion, boolean estado) {
        this.nombreLiga = nombreLiga;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
    }

    public String getNombreLiga() {
        return nombreLiga;
    }


    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setNombreLiga(String nombreLiga) {
        this.nombreLiga = nombreLiga;
    }


    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Ligas{" + "nombreLiga=" + nombreLiga + ", fechaCreacion=" + fechaCreacion + ", estado=" + estado + '}';
    }
    
    
}
