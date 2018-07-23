package cl;

import java.time.LocalDate;

public class LigasPublicas extends Ligas {

	int puntos;
	int bono;
	

	final int unaConstante = 100;
	
	
	public LigasPublicas(String nombreLiga, String equipos, LocalDate fechaCreacion, boolean estado,int puntos, int bono) {
		
		super (nombreLiga, equipos, fechaCreacion, estado);
		this.puntos = puntos;
		this.bono = bono;
	}
	
	
	
	
}

