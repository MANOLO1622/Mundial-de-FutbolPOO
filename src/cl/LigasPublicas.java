package cl;

import java.time.LocalDate;
import javax.swing.JOptionPane;

public class LigasPublicas extends Ligas {

	int puntos = 50;
	int bono = 25;
	private Mundiales mundialAnfitrion;
	final int unaConstante = 100;
	
	public LigasPublicas(String nombreLiga, LocalDate fechaCreacion, boolean estado,int puntos, int bono, Mundiales mundialAnfitrion) {
		
		super (nombreLiga, fechaCreacion, estado);
		this.setTipoLiga(true);
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

	public void setMundialAnfitrion(Mundiales mundialAnfitrion) {
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
		return super.toString() + " puntos=" + puntos + ", bono=" + bono + ", mundialAnfitrion=" + mundialAnfitrion
				+ ", unaConstante=" + unaConstante;
	}
	

	//------------------------------------------------------------------------------------------------------------------
	
	public void sumarPuntaje() {
		
		this.puntos = puntos + 100;
		
	}
	
	public void sumarBono() {
		
		
		this.puntos = puntos + bono;
		
	}
	
}

