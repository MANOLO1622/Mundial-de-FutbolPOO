package cl;

import java.time.LocalDate;

public class LigasPrivadas extends Ligas{
	
	int puntos;
	int bono;
	

	final int unaConstante = 100;
	
	public LigasPrivadas(String nombreLiga, LocalDate fechaCreacion, boolean estado,int puntos, int bono) {
		
		super (nombreLiga,fechaCreacion, estado);
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
	
	
	
}
