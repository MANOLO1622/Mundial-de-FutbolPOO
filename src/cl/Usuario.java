package cl;

import java.util.*;

import javax.swing.JOptionPane;

public class Usuario {
	
	private String nombre;
	private String apellido;
	private String nombreUsuario;
	private String contrasena;
	private Date fechaRegistro;
	private Perfiles tipoUsuario;
	
	public Usuario (String nombre, String apellido, String nombreUsuario, String contrasena, int tipoUsuario) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.nombreUsuario = nombreUsuario;
		this.fechaRegistro = new Date();
		this.contrasena = contrasena;
		this.tipoUsuario = setTipoUsuario(tipoUsuario);
		
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
	
	public Perfiles getTipoUsuario() {
		return this.tipoUsuario;
	}
	
	
	public Perfiles setTipoUsuario(int i) {
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


	
	//---------------------------------------------------------------------------------------------------------
	
	//Metodo toString.

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Usuario : nombre= " + nombre + ", apellido= " + apellido + ", nombreUsuario= " + nombreUsuario
				+ ", contrasena= " + contrasena + ", fechaRegistro= " + fechaRegistro + ", tipoUsuario= " + tipoUsuario;
	}
	
}
