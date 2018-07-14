package gestor;


import java.util.ArrayList;
import javax.swing.*;

import cl.*;

public class Gestor {
	
	private static CL capaLogica = new CL();
	
	public void registrarUsuario(String nombre, String apellido, String nombreUsuario,String contrasena, int tipoUsuario) {
		
		Usuario registro = new Usuario(nombre, apellido, nombreUsuario,contrasena, tipoUsuario);
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
	
	
	public int validarUsuario(String nombreLectura, String contrasenaLectura, int eleccion) {
		int comprobante=2;
		int comprobanteNombreUsuario=0;
		int posicion=0;
		String validador="";
		
		ArrayList<Usuario> listaComparacion = capaLogica.listarUsuarios();
		
		switch(eleccion) {
		
			case 0: 
				//Estas seran las evaluaciones a nivel de login.
				
				if(nombreLectura.equals("") || contrasenaLectura.equals("")) {
					
					comprobante = 3;
					
				}
				
				else {
					
					for(Usuario e: listaComparacion) {
						
						if(nombreLectura.equals(e.getNombreUsuario())) {
							
							comprobanteNombreUsuario = 1;
							posicion = listaComparacion.indexOf(e);
							
						}
						
					}
					
					if(comprobanteNombreUsuario == 1) {
						
						if(contrasenaLectura.equals(listaComparacion.get(posicion).getContrasena())) {
							
							comprobante = 0;
							
						}
						else {
							
							comprobante = 2;
							
						}
						
					}
					else {
						
						comprobante = 1;
						
					}
						
				}
				
				break;
				
			case 1: 
				//Estas seran las evaluaciones a nivel de registro de usuarios.
				
				
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
				
				tipoPerfil = e.getTipoUsuario();
				
			}
			
		}
		
		return tipoPerfil;
	}
	

}
