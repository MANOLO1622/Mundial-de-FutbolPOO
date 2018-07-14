
package cl;

import java.time.LocalDate;


public class Ligas {
    
    private String nombreLiga;
    private String participantes;
    private LocalDate fechaCreacion;
    private boolean estado;

    public Ligas() {
    }

    public Ligas(String nombreLiga, String participantes, LocalDate fechaCreacion, boolean estado) {
        this.nombreLiga = nombreLiga;
        this.participantes = participantes;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
    }

    public String getNombreLiga() {
        return nombreLiga;
    }

    public String getParticipantes() {
        return participantes;
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

    public void setParticipantes(String participantes) {
        this.participantes = participantes;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Ligas{" + "nombreLiga=" + nombreLiga + ", participantes=" + participantes + ", fechaCreacion=" + fechaCreacion + ", estado=" + estado + '}';
    }
    
    
}
