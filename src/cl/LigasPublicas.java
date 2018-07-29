package cl;

import java.time.LocalDate;

public class LigasPublicas extends Ligas {

	int puntos;
	int bono;
	private String mundialAnfitrion;
	
	
	

	final int unaConstante = 100;
	
	
	public LigasPublicas(String nombreLiga, LocalDate fechaCreacion, boolean estado,int puntos, int bono, String mundialAnfitrion) {
		
		super (nombreLiga, fechaCreacion, estado);
		this.puntos = puntos;
		this.bono = bono;
		this.mundialAnfitrion = mundialAnfitrion;
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
	
	public String getMundialAnfitrion() {
        return mundialAnfitrion;
    }

	public void setBono(int bono) {
		this.bono = bono;
	}


	public int getUnaConstante() {
		return unaConstante;
	}
	
	public void setMundialAnfitrion(String MundialAnfitrion) {
        this.mundialAnfitrion = mundialAnfitrion;
    }


	@Override
	public String toString() {
		return "LigasPublicas [puntos=" + puntos + ", bono=" + bono + ", mundialAnfitrion=" + mundialAnfitrion
				+ ", unaConstante=" + unaConstante + "]";
	}



	
	
	
	
	
	
}

