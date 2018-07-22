
package cl;

import java.time.LocalDate;


public class Ligas {
    
    private String nombreLiga;
    private String equipos;
    private LocalDate fechaCreacion;
    private boolean estado;

    public Ligas() {
    }

    public Ligas(String nombreLiga, String equipos, LocalDate fechaCreacion, boolean estado) {
        this.nombreLiga = nombreLiga;
        this.equipos = equipos;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
    }

    public String getNombreLiga() {
        return nombreLiga;
    }

    public String getEquipos() {
        return equipos;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setNombreLiga(String nombreLiga) {
        this.nombreLiga = nombreLiga;
    }

    public void setEquipos(String equipos) {
        this.equipos= equipos;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Ligas{" + "nombreLiga=" + nombreLiga + ", participantes=" + equipos + ", fechaCreacion=" + fechaCreacion + ", estado=" + estado + '}';
    }
    
    
}
