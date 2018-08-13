package cl;

import java.time.LocalDate;

public class LigasPrivadas extends Ligas{
	
	public static final int puntos = 100;
	public static final int bono = 50;
	private Mundiales mundialAnfitrion;

	
	public LigasPrivadas(String nombreLiga, LocalDate fechaCreacion, boolean estado,int puntos, int bono,Mundiales mundialAnfitrion) {
		
		super (nombreLiga,fechaCreacion, estado);
		this.setTipoLiga(false);
		this.mundialAnfitrion = mundialAnfitrion;
	}

	public int getPuntos() {
		return puntos;
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
	
	
	@Override
	public String toString() {
		return super.toString() + " puntos=" + puntos + ", bono=" + bono + ", mundialAnfitrion=" + mundialAnfitrion;
	}
	
	//------------------------------------------------------------------------------------------------------------------
	
	
}
