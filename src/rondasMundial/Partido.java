package rondasMundial;

import cl.*;

/**
 * Esta clase posee su constructor su get y set  y adicionalmente los atributos
 * y su variables de dfiferentes tipos para su ejecucion. 
 * @author DELL
 *
 */
public class Partido {
	
	private Equipo equipo1;
	private Equipo equipo2;
	private Equipo equipoGanador;
	private Equipo equipoPerdedor;
	private int puntajeEquipo1;
	private int puntajeEquipo2;
	
	
	
	public Partido(Equipo equipo1, Equipo equipo2) {//Construtor 

		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
		
		this.puntajeEquipo1 = (int) (Math.random()*10);
		this.puntajeEquipo2 = (int) (Math.random()*10);
		escogerGanador();
		
	}
	
	
	//---------------------------------------------------------------------------------------Gets y Sets.

	public Equipo getEquipo1() {
		return equipo1;
	}

	public void setEquipo1(Equipo equipo1) {
		this.equipo1 = equipo1;
	}

	public Equipo getEquipo2() {
		return equipo2;
	}

	public void setEquipo2(Equipo equipo2) {
		this.equipo2 = equipo2;
	}

	public Equipo getEquipoGanador() {
		return equipoGanador;
	}

	public void setEquipoGanador(Equipo equipoGanador) {
		this.equipoGanador = equipoGanador;
	}

	public int getPuntajeEquipo1() {
		return puntajeEquipo1;
	}

	public void setPuntajeEquipo1(int puntajeEquipo1) {
		this.puntajeEquipo1 = puntajeEquipo1;
	}

	public int getPuntajeEquipo2() {
		return puntajeEquipo2;
	}

	public void setPuntajeEquipo2(int puntajeEquipo2) {
		this.puntajeEquipo2 = puntajeEquipo2;
	}

	public Equipo getEquipoPerdedor() {
		return equipoPerdedor;
	}


	public void setEquipoPerdedor(Equipo equipoPerdedor) {
		this.equipoPerdedor = equipoPerdedor;
	}

	//---------------------------------------------------------------------------------------metodo to String
	

	@Override
	public String toString() {
		return "Partido [equipo1=" + equipo1 + ", equipo2=" + equipo2 + ", equipoGanador=" + equipoGanador
				+ ", equipoPerdedor=" + equipoPerdedor + ", puntajeEquipo1=" + puntajeEquipo1 + ", puntajeEquipo2="
				+ puntajeEquipo2 + "]";
	}
	
	//---------------------------------------------------------------------------------------Escoger ganador del partido
	
	public void escogerGanador() {
		
		
		if(puntajeEquipo1 >= puntajeEquipo2) {
			
			equipoGanador = equipo1;
			equipoPerdedor = equipo2;
			
		}
		else {
			
			equipoGanador = equipo2;
			equipoPerdedor = equipo1;
			
		}
		
	}

}
