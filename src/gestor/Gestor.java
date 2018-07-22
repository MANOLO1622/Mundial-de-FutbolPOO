package gestor;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.*;

import cl.*;

public class Gestor {
	
	private static CL capaLogica = new CL();
	
	public void registrarUsuario(String nombre, String apellido, String nombreUsuario,String contrasena,String avatar,String correoElectronico, int tipoUsuario) {
		
		Usuario registro = new Usuario(nombre, apellido, nombreUsuario,contrasena, avatar, correoElectronico, tipoUsuario);
		capaLogica.registrarUsuario(registro);
		
	}
	public void registrarMundial(int ano, String paisOrganizador, boolean estado) {
			
			Mundiales registro = new Mundiales(ano, paisOrganizador, estado);
			capaLogica.registrarMundial(registro);
		
	}
	public static void registrarLigaPublicas(String nombreLiga, String equipos, LocalDate fechaCreacion, boolean estado, int puntos, int bono) {
		LigasPublicas registro = new LigasPublicas(nombreLiga, equipos, fechaCreacion, estado, puntos, bono);
		CL.registrarLigaPublicas(registro);
	
	}
	public static void registrarLigaPrivadas(String nombreLiga, String equipos, LocalDate fechaCreacion, boolean estado, int puntos, int bono) {
		LigasPrivadas registro = new LigasPrivadas(nombreLiga, equipos, fechaCreacion, estado, puntos, bono);
		CL.registrarLigaPrivadas(registro);
	
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
	
	//-------------------------------------------------------------------------------------------------------------
	
	public static void registrarEquipos(String nombre, int ranking, String bandera, ISOPaises iso) {
		
		capaLogica.registrarEquipos( nombre, ranking, bandera, iso);
		
	}
	
	
	public static void listarEquiposFIFA() {
		
		ArrayList<Equipo> listaTemp= capaLogica.listarEquiposFIFA();
		
		for(Equipo e: listaTemp) {
			
			System.out.println(e.toString());
			
		}
		
	}
	

}
