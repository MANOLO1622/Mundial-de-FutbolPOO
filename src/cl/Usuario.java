package cl;

import java.util.*;

import javax.swing.JOptionPane;

public class Usuario {
	
	private String nombre;
	private String apellido;
	private String nombreUsuario;
	private String avatar;
	private String correoElectronico;
	private String contrasena;
	private Date fechaRegistro;
	private Perfiles tipoUsuario;
	private LigasPublicas miLigaPublica;
	private LigasPrivadas miLigaPrivada;
	
	private Equipo equipoLigaPublica;
	private Equipo equipoLigaPrivada;
	
	public Usuario (String nombre, String apellido, String nombreUsuario, String contrasena,String avatar, String correoElectronico, int tipoUsuario) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.nombreUsuario = nombreUsuario;
		this.fechaRegistro = new Date();
		this.avatar = avatar;
		this.correoElectronico = correoElectronico;
		this.contrasena = contrasena;
		this.tipoUsuario = getTipoUsuario(tipoUsuario);
		
	}
	
	
	//---------------------------------------------------------------------------------------------------------
	
	//Sets and Gets.
	

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
	public Date getFechaRegistro() {
		return fechaRegistro;
	}


	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(Date fechaRegistro) {
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

	
	
	//---------------------------------------------------------------------------------------------------------
	
	//Metodo toString.
	

	@Override
	public String toString() {
		return "Usuario: nombre=" + nombre + ", apellido=" + apellido + ", nombreUsuario=" + nombreUsuario + ", avatar="
				+ avatar + ", correoElectronico=" + correoElectronico + ", contrasena=" + contrasena
				+ ", fechaRegistro=" + fechaRegistro + ", tipoUsuario=" + tipoUsuario + ", miLigaPublica="
				+ miLigaPublica + ", miLigaPrivada=" + miLigaPrivada;
	}
	
	
}
