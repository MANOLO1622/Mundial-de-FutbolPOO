package cl;

import java.util.*;


public class CL {
	
	private static ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
	
	public static void registrarUsuario(Usuario registro) {
		
		listaUsuarios.add(registro);
		
	}
	
	public static ArrayList<Usuario> listarUsuarios() {
		
		return listaUsuarios;
		
	}
	
	
}
