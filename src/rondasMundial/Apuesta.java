package rondasMundial;

import cl.*;

public class Apuesta {
	
	
	private Partido partidoApuesta;
	private Equipo EquipoEscogido;
	private Usuario Jugador;
	private boolean acierto;
	
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

	
	//----------------------------------------------------------Metodo toString.
	
	
	@Override
	public String toString() {
		return "Apuesta: partidoApuesta=" + partidoApuesta + ", EquipoEscogido=" + EquipoEscogido + ", Jugador="
				+ Jugador + ", acierto=" + acierto;
	}
	
	//----------------------------------------------------------Metodos propios de la clase.

	

}
