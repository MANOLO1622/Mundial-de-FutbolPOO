package cl;

import java.time.LocalDate;
import javax.swing.JOptionPane;

public class LigasPublicas extends Ligas {

	public static final int puntos = 50;
	public static final int bono = 25;
	private Mundiales mundialAnfitrion;
	
	public LigasPublicas(String nombreLiga, LocalDate fechaCreacion, boolean estado,int puntos, int bono, Mundiales mundialAnfitrion) {
		
		super (nombreLiga, fechaCreacion, estado);
		this.setTipoLiga("Publica");
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

