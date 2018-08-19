package cl;

import java.time.LocalDate;

/**Esta clase muestra los componentes basicos con sus get y set respectivos y su topString
 * ademas almacena sus variables de puntos y bono en tipo int.
 * y tambien utiliza una variable tipo mundiales haciendo referencia al mundialAnfitrion
 * @author DELL
 *
 */
public class LigasPrivadas extends Ligas{
	
	public static final int puntos = 100;
	public static final int bono = 50;
	private Mundiales mundialAnfitrion;

	
	public LigasPrivadas(String nombreLiga, LocalDate fechaCreacion, boolean estado,int puntos, int bono,Mundiales mundialAnfitrion) {
		
		super (nombreLiga,fechaCreacion, estado);
		this.setTipoLiga("Privada");
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
