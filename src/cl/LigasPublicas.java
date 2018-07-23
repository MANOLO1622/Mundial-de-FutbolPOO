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
	
	
	
	
}

