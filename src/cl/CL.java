package cl;

import java.io.IOException;
import java.util.*;


public class CL {
	
	private static ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
	private static ArrayList<Mundiales> listaMundiales = new ArrayList<Mundiales>();
	private static ArrayList<LigasPublicas> listaLigasPublicas = new ArrayList<LigasPublicas>();
	private static ArrayList<LigasPrivadas> listaLigasPrivadas = new ArrayList<LigasPrivadas>();
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
	public static void registrarLigaPublicas(LigasPublicas registro) {
		
		listaLigasPublicas.add(registro);
		
	}
	public static ArrayList<LigasPublicas> listaLigasPublicas() {
		
		return listaLigasPublicas;
		
	}
	
	//-----------------------------------------------------------------------------------------------------------
	public static void registrarLigaPrivadas(LigasPrivadas registro) {
		
		listaLigasPrivadas.add(registro);
		
	}
	public static ArrayList<LigasPrivadas> listarLigasPrivadas() {
		
		return listaLigasPrivadas;
		
	}
	
}
