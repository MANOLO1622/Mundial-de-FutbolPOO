package cl;

import java.time.LocalDate;
import java.util.*;
import javax.swing.JOptionPane;
import rondasMundial.*;

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

	
	public LigasPublicas getMiLigaPublica() {
		return miLigaPublica;
	}


	public void setMiLigaPublica(LigasPublicas miLigaPublica) {
		this.miLigaPublica = miLigaPublica;
	}


	public LigasPrivadas getMiLigaPrivada() {
		return this.miLigaPrivada;
	}


	public void setMiLigaPrivada(LigasPrivadas liga) {
		this.miLigaPrivada = liga;
	}
	
	
	
	
	public Equipo getEquipoLigaPublica() {
		return equipoLigaPublica;
	}


	public void setEquipoLigaPublica(Equipo equipoLigaPublica) {
		this.equipoLigaPublica = equipoLigaPublica;
	}


	public Equipo getEquipoLigaPrivada() {
		return equipoLigaPrivada;
	}


	public void setEquipoLigaPrivada(Equipo equipoLigaPrivada) {
		this.equipoLigaPrivada = equipoLigaPrivada;
	}
	

	public Apuesta[] getPrimerCuadroPublica() {
		return primerCuadroPublica;
	}


	public void setPrimerCuadroPublica(Apuesta[] primerCuadroPublica) {
		this.primerCuadroPublica = primerCuadroPublica;
	}


	public Apuesta[] getPrimerCuadroPrivada() {
		return primerCuadroPrivada;
	}


	public void setPrimerCuadroPrivada(Apuesta[] primerCuadroPrivada) {
		this.primerCuadroPrivada = primerCuadroPrivada;
	}
	
	public int getValidacionPrimeraFasePublica() {
		return validacionPrimeraFasePublica;
	}


	public void setValidacionPrimeraFasePublica(int validacionPrimeraFasePublica) {
		this.validacionPrimeraFasePublica = validacionPrimeraFasePublica;
	}


	public int getValidacionPrimeraFasePrivada() {
		return validacionPrimeraFasePrivada;
	}


	public void setValidacionPrimeraFasePrivada(int validacionPrimeraFasePrivada) {
		this.validacionPrimeraFasePrivada = validacionPrimeraFasePrivada;
	}
	
	public boolean isValidacionOctavosPublica() {
		return validacionOctavosPublica;
	}


	public void setValidacionOctavosPublica(boolean validacionOctavosPublica) {
		this.validacionOctavosPublica = validacionOctavosPublica;
	}


	public boolean isValidacioncuartosPublica() {
		return validacioncuartosPublica;
	}


	public void setValidacioncuartosPublica(boolean validacioncuartosPublica) {
		this.validacioncuartosPublica = validacioncuartosPublica;
	}


	public boolean isValidacionSemifinalesPublica() {
		return validacionSemifinalesPublica;
	}


	public void setValidacionSemifinalesPublica(boolean validacionSemifinalesPublica) {
		this.validacionSemifinalesPublica = validacionSemifinalesPublica;
	}


	public boolean isValidacionfinalPublica() {
		return validacionfinalPublica;
	}


	public void setValidacionfinalPublica(boolean validacionfinalPublica) {
		this.validacionfinalPublica = validacionfinalPublica;
	}


	public boolean isValidacionOctavosPrivada() {
		return validacionOctavosPrivada;
	}


	public void setValidacionOctavosPrivada(boolean validacionOctavosPrivada) {
		this.validacionOctavosPrivada = validacionOctavosPrivada;
	}


	public boolean isValidacioncuartosPrivada() {
		return validacioncuartosPrivada;
	}


	public void setValidacioncuartosPrivada(boolean validacioncuartosPrivada) {
		this.validacioncuartosPrivada = validacioncuartosPrivada;
	}


	public boolean isValidacionSemifinalesPrivada() {
		return validacionSemifinalesPrivada;
	}


	public void setValidacionSemifinalesPrivada(boolean validacionSemifinalesPrivada) {
		this.validacionSemifinalesPrivada = validacionSemifinalesPrivada;
	}


	public boolean isValidacionfinalPrivada() {
		return validacionfinalPrivada;
	}


	public void setValidacionfinalPrivada(boolean validacionfinalPrivada) {
		this.validacionfinalPrivada = validacionfinalPrivada;
	}


	public int getPuntajePublica() {
		return puntajePublica;
	}


	public void setPuntajePublica(int puntajePublica) {
		this.puntajePublica = puntajePublica;
	}


	public int getPuntajePrivada() {
		return puntajePrivada;
	}


	public void setPuntajePrivada(int puntajePrivada) {
		this.puntajePrivada = puntajePrivada;
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
	
	public void sumarApuestaPublica() {
		
		validacionPrimeraFasePublica++;
	}
	
	public void sumarApuestaPrivada() {
		
		validacionPrimeraFasePrivada++;
	}

}
