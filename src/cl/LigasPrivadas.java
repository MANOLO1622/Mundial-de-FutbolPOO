package cl;

import java.time.LocalDate;

public class LigasPrivadas extends Ligas{
	
	int puntos;
	int bono;
	private Mundiales mundialAnfitrion;
	final int unaConstante = 100;
	
	public LigasPrivadas(String nombreLiga, LocalDate fechaCreacion, boolean estado,int puntos, int bono,Mundiales mundialAnfitrion) {
		
		super (nombreLiga,fechaCreacion, estado);
		this.setTipoLiga(false);
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

	public void setBono(int bono) {
		this.bono = bono;
	}

	public int getUnaConstante() {
		return unaConstante;
	}
	
	public Mundiales getMundialAnfitrion() {
        return mundialAnfitrion;
    }

	public void setMundialAnfitrion(Mundiales mundialAnfitrion) {
        this.mundialAnfitrion = mundialAnfitrion;
    }
	
	
	@Override
	public String toString() {
		return super.toString() + " puntos=" + puntos + ", bono=" + bono + ", mundialAnfitrion=" + mundialAnfitrion
				+ ", unaConstante=" + unaConstante + "]";
	}
	
}
