package cl;

import java.io.IOException;
import java.util.*;


public class CL {
	
	private static ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
	private static ArrayList<Mundiales> listaMundiales = new ArrayList<Mundiales>();
	private static TextFileIO UsuariosRegLog = new TextFileIO("logs//Login.txt");
	
	public static void registrarUsuario(Usuario registro) {
		
		listaUsuarios.add(registro);
		
	}
	public static void registrarMundial(Mundiales registro) {
		
		listaMundiales.add(registro);
		
	}
	
	public static ArrayList<Usuario> listarUsuarios() {
		
		return listaUsuarios;
		
	}
	public static ArrayList<Mundiales> listarMundiales() {
		
		return listaMundiales;
		
	}
	
	
	
}
