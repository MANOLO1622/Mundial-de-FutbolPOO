package cl;

import java.time.LocalDate;
import java.util.*;
import javax.swing.JOptionPane;
import rondasMundial.*;

/**Esta clase contiene los componentes principales de todos los usuarios que se registran
 * en la app ademas posee validaciones y metodos que ejecutan cada fase de las variables
 * que se almacena como string locaDate etc. Ademas contiene su constructor su sets sus gets
 * y su toStringcorrespondientes
 * @author DELL
 */

public class Usuario {
	
	private String nombre;
	private String apellido;
	private String nombreUsuario;
	private String avatar;
	private String correoElectronico;
	private String contrasena;
	private LocalDate fechaRegistro;
	private Perfiles tipoUsuario;
	private LigasPublicas miLigaPublica;
	private LigasPrivadas miLigaPrivada;
	
	private int puntajePublica = 0;
	private int puntajePrivada = 0;
	
	private Equipo equipoLigaPublica;
	private Equipo equipoLigaPrivada;
	
	private Apuesta[] primerCuadroPublica = new Apuesta[3];
	private Apuesta[] primerCuadroPrivada = new Apuesta[3];
	
	private int validacionPrimeraFasePublica = 0;
	private int validacionPrimeraFasePrivada = 0;
	
	private boolean validacionOctavosPublica = false;
	private boolean validacioncuartosPublica = false;
	private boolean validacionSemifinalesPublica = false;
	private boolean validacionfinalPublica = false;
	
	private boolean validacionOctavosPrivada = false;
	private boolean validacioncuartosPrivada = false;
	private boolean validacionSemifinalesPrivada = false;
	private boolean validacionfinalPrivada = false;
	
	
	
	public Usuario (String nombre, String apellido, String nombreUsuario, String contrasena,String avatar, String correoElectronico, int tipoUsuario) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.nombreUsuario = nombreUsuario;
		this.fechaRegistro = LocalDate.now();
		this.avatar = avatar;
		this.correoElectronico = correoElectronico;
		this.contrasena = contrasena;
		this.tipoUsuario = getTipoUsuario(tipoUsuario);
		
	}
	
	
	//---------------------------------------------------------------------------------------------------------Sets and Gets.	

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}


	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}


	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	/**
	 * @return the nombreUsuario
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}


	/**
	 * @param nombreUsuario the nombreUsuario to set
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	
	
	
	/**
	 * @return the contrasena
	 */
	public String getContrasena() {
		return contrasena;
	}


	/**
	 * @param nombreUsuario the nombreUsuario to set
	 */
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}


	/**
	 * @return the fechaRegistro
	 */
	public LocalDate getFechaRegistro() {
		return fechaRegistro;
	}


	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(LocalDate fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
	public void setTipoUSuario(Perfiles perfil) {
		
		this.tipoUsuario = perfil;
		
	}
	/**
	 * Aqui se muestra los casos de los tipos de usuario que exiten
	 * @param i
	 * @return
	 */
	public Perfiles getTipoUsuario(int i) {
		
		Perfiles tipo;
		
		switch (i) {
		
		case 1:
			
			tipo = Perfiles.ADMIN;
			
			break;
			
		case 2:
			
			tipo = Perfiles.PLAYER;
			
			break;
			
		case 3:
			
			tipo = Perfiles.VIEWER;
			
			break;
			
		default:
			
			tipo = Perfiles.VIEWER;
			
			break;
			
		}
		
		return tipo;
	}
	/**
	 * Aqui se retorna el perfil del usuario correspondiente
	 * @return
	 */
	public Perfiles retornarTipoUsuario() {
		
		return tipoUsuario;
	}
	
	
	/**
	 * @return the avatar
	 */
	public String getAvatar() {
		return avatar;
	}


	/**
	 * @param avatar the avatar to set
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}


	/**
	 * @return the correoElectronico
	 */
	public String getCorreoElectronico() {
		return correoElectronico;
	}


	/**
	 * @param correoElectronico the correoElectronico to set
	 */
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	/**
	 * Get de Ligas publicas
	 * @return
	 */
	public LigasPublicas getMiLigaPublica() {
		return miLigaPublica;
	}

	/**
	 * Set de ligas publicas
	 * @param miLigaPublica
	 */
	public void setMiLigaPublica(LigasPublicas miLigaPublica) {
		this.miLigaPublica = miLigaPublica;
	}

	/**
	 * get de ligas privadas
	 * @return
	 */
	public LigasPrivadas getMiLigaPrivada() {
		return this.miLigaPrivada;
	}

	/**
	 * set de ligas privadas
	 * @param liga
	 */
	public void setMiLigaPrivada(LigasPrivadas liga) {
		this.miLigaPrivada = liga;
	}
	
	
	
	/**
	 * get de equipo por liga publica
	 * @return
	 */
	public Equipo getEquipoLigaPublica() {
		return equipoLigaPublica;
	}

	/**
	 * set de equipo por liga publica
	 * @param equipoLigaPublica
	 */
	public void setEquipoLigaPublica(Equipo equipoLigaPublica) {
		this.equipoLigaPublica = equipoLigaPublica;
	}

	/**
	 * get de equipo por liga privada
	 * @return
	 */
	public Equipo getEquipoLigaPrivada() {
		return equipoLigaPrivada;
	}

	/**
	 * set de equipo por liga privada
	 * @param equipoLigaPrivada
	 */
	public void setEquipoLigaPrivada(Equipo equipoLigaPrivada) {
		this.equipoLigaPrivada = equipoLigaPrivada;
	}
	
	/**
	 * get del cuadror por liga publica
	 * @return
	 */
	public Apuesta[] getPrimerCuadroPublica() {
		return primerCuadroPublica;
	}

	/**
	 * set del cuadro de la liga publica
	 * @param primerCuadroPublica
	 */
	public void setPrimerCuadroPublica(Apuesta[] primerCuadroPublica) {
		this.primerCuadroPublica = primerCuadroPublica;
	}

	/**
	 * Get de apuestas
	 * @return
	 */
	public Apuesta[] getPrimerCuadroPrivada() {
		return primerCuadroPrivada;
	}

	/**
	 * set de cuandor privada
	 * @param primerCuadroPrivada
	 */
	public void setPrimerCuadroPrivada(Apuesta[] primerCuadroPrivada) {
		this.primerCuadroPrivada = primerCuadroPrivada;
	}
	
	/**
	 * get validacion de la primera fase publica
	 * @return
	 */
	public int getValidacionPrimeraFasePublica() {
		return validacionPrimeraFasePublica;
	}

	/**
	 * set de la primera fase publica
	 * @param validacionPrimeraFasePublica
	 */
	public void setValidacionPrimeraFasePublica(int validacionPrimeraFasePublica) {
		this.validacionPrimeraFasePublica = validacionPrimeraFasePublica;
	}

	/**
	 * get de validacion de la primera fase pribada
	 * @return
	 */
	public int getValidacionPrimeraFasePrivada() {
		return validacionPrimeraFasePrivada;
	}

	/**
	 * set de la primera fase privada
	 * @param validacionPrimeraFasePrivada
	 */
	public void setValidacionPrimeraFasePrivada(int validacionPrimeraFasePrivada) {
		this.validacionPrimeraFasePrivada = validacionPrimeraFasePrivada;
	}
	
	/**
	 * Validacion de los octavos de liga publica
	 * @return
	 */
	public boolean isValidacionOctavosPublica() {
		return validacionOctavosPublica;
	}

	/**
	 * set de validacion de los octavos de la liga publica
	 * @param validacionOctavosPublica
	 */
	public void setValidacionOctavosPublica(boolean validacionOctavosPublica) {
		this.validacionOctavosPublica = validacionOctavosPublica;
	}

	/**
	 * Validacion de los cuartos de liga publica
	 * @return
	 */
	public boolean isValidacioncuartosPublica() {
		return validacioncuartosPublica;
	}

	/**
	 * set de validacion de los cuartos de la liga publica
	 * @param validacionOctavosPublica
	 */
	public void setValidacioncuartosPublica(boolean validacioncuartosPublica) {
		this.validacioncuartosPublica = validacioncuartosPublica;
	}

	/**
	 * Validacion de los semis de liga publica
	 * @return
	 */
	public boolean isValidacionSemifinalesPublica() {
		return validacionSemifinalesPublica;
	}

	/**
	 * set de validacion de los semis de la liga publica
	 * @param validacionOctavosPublica
	 */
	public void setValidacionSemifinalesPublica(boolean validacionSemifinalesPublica) {
		this.validacionSemifinalesPublica = validacionSemifinalesPublica;
	}

	/**
	 * Validacion de los final de liga publica
	 * @return
	 */
	public boolean isValidacionfinalPublica() {
		return validacionfinalPublica;
	}

	/**
	 * set de validacion de los final de la liga publica
	 * @param validacionOctavosPublica
	 */
	public void setValidacionfinalPublica(boolean validacionfinalPublica) {
		this.validacionfinalPublica = validacionfinalPublica;
	}

	/**
	 * Validacion de los Octavos de liga privada
	 * @return
	 */
	public boolean isValidacionOctavosPrivada() {
		return validacionOctavosPrivada;
	}

	/**
	 * set de validacion de los Octavos de la liga privada
	 * @param validacionOctavosPrivada
	 */
	public void setValidacionOctavosPrivada(boolean validacionOctavosPrivada) {
		this.validacionOctavosPrivada = validacionOctavosPrivada;
	}

	/**
	 * Validacion de los cuartos de liga privada
	 * @return
	 */
	public boolean isValidacioncuartosPrivada() {
		return validacioncuartosPrivada;
	}

	/**
	 * set de validacion de los Cuartosde la liga privada
	 * @param validacionCuartosPrivada
	 */
	public void setValidacioncuartosPrivada(boolean validacioncuartosPrivada) {
		this.validacioncuartosPrivada = validacioncuartosPrivada;
	}

	/**
	 * Validacion de los semis de liga privada
	 * @return
	 */
	public boolean isValidacionSemifinalesPrivada() {
		return validacionSemifinalesPrivada;
	}

	/**
	 * set de validacion de los semis de la liga privada
	 * @param validacionSemifinalesPrivada
	 */
	public void setValidacionSemifinalesPrivada(boolean validacionSemifinalesPrivada) {
		this.validacionSemifinalesPrivada = validacionSemifinalesPrivada;
	}

	/**
	 * Validacion de los final de liga privada
	 * @return
	 */
	public boolean isValidacionfinalPrivada() {
		return validacionfinalPrivada;
	}

	/**
	 * set de validacion de los final de la liga privada
	 * @param validacionSemifinalesPrivada
	 */
	public void setValidacionfinalPrivada(boolean validacionfinalPrivada) {
		this.validacionfinalPrivada = validacionfinalPrivada;
	}

	/**
	 * Get puntaje de la liga publica
	 * @return
	 */
	public int getPuntajePublica() {
		return puntajePublica;
	}

	/**
	 * Set del puntaje de la liga publica
	 * @param puntajePublica
	 */
	public void setPuntajePublica(int puntajePublica) {
		this.puntajePublica = puntajePublica;
	}

	/**
	 * Get del puntaje de la liga privada
	 * @return
	 */
	public int getPuntajePrivada() {
		return puntajePrivada;
	}

	/**
	 * Set del puntaje de la liga privada
	 * @param puntajePrivada
	 */
	public void setPuntajePrivada(int puntajePrivada) {
		this.puntajePrivada = puntajePrivada;
	}
	/**
	 * Metodo que retorna el tipo de usuario en la app
	 * @param perfilUsuario
	 * @return
	 */
	public static int retornarTipoUsuarioNumerico(Perfiles perfilUsuario) {
		
		int valorRetorno = 0;
		
		if(perfilUsuario == Perfiles.ADMIN) {
			
			valorRetorno = 1;
			
		} else if(perfilUsuario == Perfiles.PLAYER) {
			
			valorRetorno = 2;
			
		}else if(perfilUsuario == Perfiles.VIEWER) {
			
			valorRetorno = 3;
			
		}
		
		return valorRetorno;
	}

	//---------------------------------------------------------------------------------------------------------
	
	//Metodo toString.

	@Override
	public String toString() {
		return "Usuario: nombre=" + nombre + ", apellido=" + apellido + ", nombreUsuario=" + nombreUsuario + ", avatar="
				+ avatar + ", correoElectronico=" + correoElectronico + ", contrasena=" + contrasena
				+ ", fechaRegistro=" + fechaRegistro + ", tipoUsuario=" + tipoUsuario + ", miLigaPublica="
				+ miLigaPublica + ", miLigaPrivada=" + miLigaPrivada + ", puntajePublica=" + puntajePublica
				+ ", puntajePrivada=" + puntajePrivada + ", equipoLigaPublica=" + equipoLigaPublica
				+ ", equipoLigaPrivada=" + equipoLigaPrivada + ", primerCuadroPublica="
				+ Arrays.toString(primerCuadroPublica) + ", primerCuadroPrivada=" + Arrays.toString(primerCuadroPrivada)
				+ ", validacionPrimeraFasePublica=" + validacionPrimeraFasePublica + ", validacionPrimeraFasePrivada="
				+ validacionPrimeraFasePrivada + ", validacionOctavosPublica=" + validacionOctavosPublica
				+ ", validacioncuartosPublica=" + validacioncuartosPublica + ", validacionSemifinalesPublica="
				+ validacionSemifinalesPublica + ", validacionfinalPublica=" + validacionfinalPublica
				+ ", validacionOctavosPrivada=" + validacionOctavosPrivada + ", validacioncuartosPrivada="
				+ validacioncuartosPrivada + ", validacionSemifinalesPrivada=" + validacionSemifinalesPrivada
				+ ", validacionfinalPrivada=" + validacionfinalPrivada;
	}
	
	//--------------------------------------------------------------------------------------------------------- Metodos propios de la clase.
	/**
	 * Indica la suma de las apuestas de la liga publica
	 */
	public void sumarApuestaPublica() {
		
		validacionPrimeraFasePublica++;
	}
	/**
	 * Indica la suma de las apuestas de la liga privada
	 */
	public void sumarApuestaPrivada() {
		
		validacionPrimeraFasePrivada++;
	}

}
