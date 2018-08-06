
package cl;

import java.time.*;
import java.util.*;
import rondasMundial.*;


public class Ligas {
    
    private String nombreLiga;
    private LocalDate fechaCreacion;
    private boolean estado;
    private boolean tipoLiga;
    private ArrayList<Apuesta> listaApuestas= new ArrayList();
    
    

	//----------------------------------------------------------Constructor.
    
    
    public Ligas() {
    }
    
    public Ligas(String nombreLiga, LocalDate fechaCreacion, boolean estado) {
        this.nombreLiga = nombreLiga;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
    }
    
	//----------------------------------------------------------Gets y Sets.

    
	public String getNombreLiga() {
		return nombreLiga;
	}

	public void setNombreLiga(String nombreLiga) {
		this.nombreLiga = nombreLiga;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public boolean isTipoLiga() {
		return tipoLiga;
	}

	public void setTipoLiga(boolean tipoLiga) {
		this.tipoLiga = tipoLiga;
	}

	public ArrayList<Apuesta> getListaApuestas() {
		return listaApuestas;
	}

	public void setListaApuestas(ArrayList<Apuesta> listaApuestas) {
		this.listaApuestas = listaApuestas;
	}

	
	//----------------------------------------------------------Metodo toString.
	
	
	@Override
	public String toString() {
		return "Ligas: nombreLiga=" + nombreLiga + ", fechaCreacion=" + fechaCreacion + ", estado=" + estado
				+ ", tipoLiga=" + tipoLiga + ", listaApuestas=" + listaApuestas;
	}


	
	
	
	
    
    
}
