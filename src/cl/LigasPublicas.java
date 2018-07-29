package cl;

import java.time.LocalDate;

public class LigasPublicas extends Ligas {

	int puntos;
	int bono;
	private Mundiales mundialAnfitrion;
	
	
	

	final int unaConstante = 100;
	
	
	public LigasPublicas(String nombreLiga, LocalDate fechaCreacion, boolean estado,int puntos, int bono, Mundiales mundialAnfitrion) {
		
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
	
	public Mundiales getMundialAnfitrion() {
        return mundialAnfitrion;
    }

	public void setMundialAnfitrion(Mundiales MundialAnfitrion) {
        this.mundialAnfitrion = mundialAnfitrion;
    }
	
	public void setBono(int bono) {
		this.bono = bono;
	}

	public int getUnaConstante() {
		return unaConstante;
	}
	

	@Override
	public String toString() {
		return "LigasPublicas [puntos=" + puntos + ", bono=" + bono + ", mundialAnfitrion=" + mundialAnfitrion
				+ ", unaConstante=" + unaConstante + "]";
	}



	
	
	
	
	
	
}

