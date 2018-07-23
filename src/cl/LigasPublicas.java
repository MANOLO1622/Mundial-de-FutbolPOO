package cl;

import java.time.LocalDate;

public class LigasPublicas extends Ligas {

	int puntos;
	int bono;
	
	

	final int unaConstante = 100;
	
	
	public LigasPublicas(String nombreLiga, LocalDate fechaCreacion, boolean estado,int puntos, int bono) {
		
		super (nombreLiga, fechaCreacion, estado);
		this.puntos = puntos;
		this.bono = bono;
	}


	public int getPuntos() {
		return puntos;
	}


	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}


	public int getBono() {
		return bono;
	}


	public void setBono(int bono) {
		this.bono = bono;
	}


	public int getUnaConstante() {
		return unaConstante;
	}


	@Override
	public String toString() {
		return "LigasPublicas: puntos=" + puntos + ", bono=" + bono + ", unaConstante=" + unaConstante;
	}
	
	
	
	
	
	
}

