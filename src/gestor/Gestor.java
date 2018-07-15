package gestor;


import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;

import cl.*;

public class Gestor {
	
	private static CL capaLogica = new CL();
	
	public void registrarUsuario(String nombre, String apellido, String nombreUsuario,String contrasena,String avatar,String correoElectronico, int tipoUsuario) {
		
		Usuario registro = new Usuario(nombre, apellido, nombreUsuario,contrasena, avatar, correoElectronico, tipoUsuario);
		capaLogica.registrarUsuario(registro);
		
	}
	
	
	public void listarUsuarios() {
		
		ArrayList<Usuario> listaImpresion = capaLogica.listarUsuarios();
		
		System.out.println("");
		
		for(Usuario e: listaImpresion) {
			
			System.out.println(e.toString());
			
		}
		
		System.out.println("");
		
		
	}
	
	
	public int validarUsuario(String nombreLectura, String contrasenaLectura,String avatarLectura, int eleccion) {
		int comprobante=0;
		int comprobanteNombreUsuario=0;
		int posicion=-1;
		String validador="";
		
		ArrayList<Usuario> listaComparacion = capaLogica.listarUsuarios();
		
		switch(eleccion) {
		
			case 0: 
				//Estas seran las evaluaciones a nivel de login.
				
				if(nombreLectura.equals("") || contrasenaLectura.equals("")) {
					
					comprobante = 0;
					
				}
				
				else {
					
					for(Usuario e: listaComparacion) {
						
						if(nombreLectura.equals(e.getNombreUsuario()) && contrasenaLectura.equals(e.getContrasena())) {
							
							comprobante = 2;
							posicion = listaComparacion.indexOf(e);
							
						}
						
					}
					
					if (posicion != -1) {
						
						if(contrasenaLectura.equals(listaComparacion.get(posicion).getContrasena())) {
	
						}
						else {
							
							comprobante = 3;
							
						}
						
					}
					
					if(posicion == -1) {
						
						comprobante = 1;
						
					}
						
				}
				
				break;
				
			case 1: 
				//Estas seran las evaluaciones a nivel de registro de usuarios.
				
				for(Usuario e: listaComparacion) {
					
					if(nombreLectura.equals(e.getNombreUsuario()) && avatarLectura.equals(e.getAvatar())) {
						
						comprobante = 1;
						
					}
					
				}
				
				if (comprobante != 1) {
					
					comprobante = 0;
					
				}
				
				break;
				
			default: 
				//Indefinido, sujeto a cambios y a ingresar mas opciones al switch.
				break;
			
			}
		return comprobante;
	}
	
	
	
	
	public Perfiles retornarTipoUsuario(String nombreUsuario, String contrasena) {
		
		Perfiles tipoPerfil = Perfiles.VIEWER;
		ArrayList<Usuario> listaUsuariosRegistrados = capaLogica.listarUsuarios();
		
		for(Usuario e: listaUsuariosRegistrados) {
			
			if(nombreUsuario.equals(e.getNombreUsuario()) && contrasena.equals(e.getContrasena())) {
				
				tipoPerfil = e.retornarTipoUsuario();
				
			}
			
		}
		
		return tipoPerfil;
	}
	

}
