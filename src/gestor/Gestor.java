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
	
	
	public int validarUsuario(String nombreLectura,String contrasenaLectura) {
		int comprobante=0;
		String validador="";
		
		ArrayList<Usuario> listaComparacion = capaLogica.listarUsuarios();
		
		for(Usuario e: listaComparacion) {
			
			if(nombreLectura.equals("") && contrasenaLectura.equals("")) {
				
				validador = "EL usuario no ha ingresado datos en los campos de texto";
			
			}
			else {
				
				if(e.getNombreUsuario().equals(nombreLectura) && e.getContrasena().equals(contrasenaLectura)) {
					comprobante = 1;
				}
				
			}				
				
		}
		

		if(comprobante == 1) {	
			JOptionPane.showMessageDialog(null, "Este Usuario se encuentra registrado en el sistema.");	
		}
		else {
			JOptionPane.showMessageDialog(null, "Usuario no se encuentra registrado en el sistema.");
		}
		
		
		
		if(validador.equals("")) {
			
			System.out.println("El usuario no ha ingresado datos en los campos de texto.");
			
		}
		else {
			System.out.println(validador);
			
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
