package cl;

import java.io.IOException;
import java.util.*;


public class CL {
	
	private static ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
	private static ArrayList<Mundiales> listaMundiales = new ArrayList<Mundiales>();
	private static ArrayList<Ligas> listaLigas = new ArrayList<Ligas>();
	private static TextFileIO UsuariosRegLog = new TextFileIO("logs//Login.txt");
	private static ArrayList<Equipo> listaEquiposFIFA = new ArrayList();
	
	
	
	
	//-------------------------------------------------------------------------------------------------------------
	
	public static void registrarUsuario(Usuario registro) {
		
		listaUsuarios.add(registro);
		
	}
	
	public static ArrayList<Usuario> listarUsuarios() {
		
		return listaUsuarios;
	}
	
	//-------------------------------------------------------------------------------------------------------------
	
	public static void registrarEquipos(String nombre, int ranking, String bandera, ISOPaises iso) {
		
		Equipo equipoTemp = new Equipo(nombre, ranking, bandera, iso);
		
		listaEquiposFIFA.add(equipoTemp);
		
	}
	
	public static ArrayList<Equipo> listarEquiposFIFA() {
		
		return listaEquiposFIFA;
	}
	
	//---------------------------------------------------------------------------------------------------------------
	public static void registrarMundial(Mundiales registro) {
		
		listaMundiales.add(registro);
		
	}
	public static ArrayList<Mundiales> listarMundiales() {
		
		return listaMundiales;
		
	}
	
	//----------------------------------------------------------------------------------------------------------------
	public static void registrarLigaPublicas(Ligas registro) {
		
		listaLigas.add(registro);
		
	}
	public static ArrayList<Ligas> listarLigasPublicas() {
		
		return listaLigas;
		
	}
	
	//-----------------------------------------------------------------------------------------------------------
	public static void registrarLigaPrivadas(Ligas registro) {
		
		listaLigas.add(registro);
		
	}
	public static ArrayList<Ligas> listarLigasPrivadas() {
		
		return listaLigas;
		
	}
	
	
	public static String retornarBanderaEquipo(String nombreEquipo) {
		String bandera="";
		for(Equipo e: listaEquiposFIFA) {
			
			if(nombreEquipo.equals(e.getNombre())) {
				
				bandera = e.getBandera();
				
			}
			
		}
		
		return bandera;
	}
	
	
	
	
}
