package rondasMundial;

import cl.*;

/**
 * Esta clase posee su constructor su get y set  y adicionalmente los atributos
 * y su variables de dfiferentes tipos para su ejecucion. 
 * @author DELL
 *
 */
public class Apuesta {
	
	
	private Partido partidoApuesta;
	private Equipo EquipoEscogido;
	private Usuario Jugador;
	private boolean acierto;
	private int ronda;
	
	//----------------------------------------------------------Constructor.
	
	
	public Apuesta(Partido partidoApuesta, Equipo equipoEscogido, Usuario jugador) {

		this.partidoApuesta = partidoApuesta;
		EquipoEscogido = equipoEscogido;
		Jugador = jugador;
		
		if(partidoApuesta.getEquipoGanador().getNombre().equals(equipoEscogido.getNombre())) {
			
			this.acierto = true;
			
		}else {
			
			this.acierto = false;
			
		}
		
	}
	

	//----------------------------------------------------------Gets y Sets.
	
	
	
	public Partido getPartidoApuesta() {
		return partidoApuesta;
	}

	public void setPartidoApuesta(Partido partidoApuesta) {
		this.partidoApuesta = partidoApuesta;
	}
	public Equipo getEquipoEscogido() {
		return EquipoEscogido;
	}
	public void setEquipoEscogido(Equipo equipoEscogido) {
		EquipoEscogido = equipoEscogido;
	}
	public Usuario getJugador() {
		return Jugador;
	}
	public void setJugador(Usuario jugador) {
		Jugador = jugador;
	}
	public boolean isAcierto() {
		return acierto;
	}
	public void setAcierto(boolean acierto) {
		this.acierto = acierto;
	}
	
	
	public int getRonda() {
		return ronda;
	}


	public void setRonda(int ronda) {
		this.ronda = ronda;
	}
	
	//----------------------------------------------------------Metodo toString.

	@Override
	public String toString() {
		return "Apuesta: partidoApuesta= " + partidoApuesta + ", EquipoEscogido= " + EquipoEscogido + ", Jugador= "
				+ Jugador + ", acierto= " + acierto + ", ronda= "+ ronda;
	}
	
	//----------------------------------------------------------Metodos propios de la clase.

	

}
