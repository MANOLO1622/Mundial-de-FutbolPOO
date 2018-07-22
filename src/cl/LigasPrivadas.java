package cl;

import java.time.LocalDate;

public class LigasPrivadas extends Ligas{
	
	int puntos;
	int bono;
	

	final int unaConstante = 100;
	
public LigasPrivadas(String nombreLiga, String equipos, LocalDate fechaCreacion, boolean estado,int puntos, int bono) {
		
		super (nombreLiga, equipos, fechaCreacion, estado);
		this.puntos = puntos;
		this.bono = bono;
	}
	
}
