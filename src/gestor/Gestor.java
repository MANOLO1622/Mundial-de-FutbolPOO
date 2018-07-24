package gestor;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.*;

import cl.*;

public class Gestor {

	private static CL capaLogica = new CL();

	public void registrarUsuario(String nombre, String apellido, String nombreUsuario, String contrasena, String avatar,
			String correoElectronico, int tipoUsuario) {

		Usuario registro = new Usuario(nombre, apellido, nombreUsuario, contrasena, avatar, correoElectronico,
				tipoUsuario);
		capaLogica.registrarUsuario(registro);

	}

	public void registrarMundial(LocalDate ano, String paisOrganizador, boolean estado) {

		Mundiales registro = new Mundiales(ano, paisOrganizador, estado);
		capaLogica.registrarMundial(registro);

	}

	public static void registrarLigaPublicas(String nombreLiga, LocalDate fechaCreacion, boolean estado,
			int puntos, int bono) {
		LigasPublicas registro = new LigasPublicas(nombreLiga, fechaCreacion, estado, puntos, bono);
		capaLogica.registrarLigaPublicas(registro);

	}

	public static void registrarLigaPrivadas(String nombreLiga, LocalDate fechaCreacion, boolean estado,
			int puntos, int bono) {
		LigasPrivadas registro = new LigasPrivadas(nombreLiga, fechaCreacion, estado, puntos, bono);
		capaLogica.registrarLigaPrivadas(registro);

	}

	// ----------------------------------------------------------LISTAR-----------------------------------------------------------------------------

	public void listarUsuarios() {

		ArrayList<Usuario> listaImpresion = capaLogica.listarUsuarios();

		System.out.println("");

		for (Usuario e : listaImpresion) {

			System.out.println(e.toString());

		}

		System.out.println("");

	}
	
	public void listarMundiales() {

		ArrayList<Mundiales> listaImpresion = capaLogica.listaMundiales();

		System.out.println("");

		for (Mundiales e : listaImpresion) {

			System.out.println(e.toString());

		}

		System.out.println("");

	}

	public void listarLigasPublicas() {

		ArrayList<LigasPublicas> listaImpresion = capaLogica.listaLigasPublicas();

		System.out.println("");

		for (LigasPublicas e : listaImpresion) {

			System.out.println(e.toString());

		}

		System.out.println("");

	}
	
	public void listarLigasPrivadas() {

		ArrayList<LigasPrivadas> listaImpresion = capaLogica.listaLigasPrivadas();

		System.out.println("");

		for (LigasPrivadas e : listaImpresion) {

			System.out.println(e.toString());

		}

		System.out.println("");

	}

	// -----------------------------------------------------------------------------------------------------------------------------------------

	public int validarUsuario(String nombreLectura, String contrasenaLectura, String avatarLectura, int eleccion) {
		int comprobante = 0;
		int comprobanteNombreUsuario = 0;
		int posicion = -1;
		String validador = "";

		ArrayList<Usuario> listaComparacion = capaLogica.listarUsuarios();

		switch (eleccion) {

		case 0:
			// Estas seran las evaluaciones a nivel de login.

			if (nombreLectura.equals("") || contrasenaLectura.equals("")) {

				comprobante = 0;

			}

			else {

				for (Usuario e : listaComparacion) {

					if (nombreLectura.equals(e.getNombreUsuario()) && contrasenaLectura.equals(e.getContrasena())) {

						comprobante = 2;
						posicion = listaComparacion.indexOf(e);

					}

				}

				if (posicion != -1) {

					if (contrasenaLectura.equals(listaComparacion.get(posicion).getContrasena())) {

					} else {

						comprobante = 3;

					}

				}

				if (posicion == -1) {

					comprobante = 1;

				}

			}

			break;

		case 1:
			// Estas seran las evaluaciones a nivel de registro de usuarios.

			for (Usuario e : listaComparacion) {

				if (nombreLectura.equals(e.getNombreUsuario()) && avatarLectura.equals(e.getAvatar())) {

					comprobante = 1;

				}

			}

			if (comprobante != 1) {

				comprobante = 0;

			}

			break;

		default:
			// Indefinido, sujeto a cambios y a ingresar mas opciones al switch..
			break;

		}
		return comprobante;
	}

	public Perfiles retornarTipoUsuario(String nombreUsuario, String contrasena) {

		Perfiles tipoPerfil = Perfiles.VIEWER;
		ArrayList<Usuario> listaUsuariosRegistrados = capaLogica.listarUsuarios();

		for (Usuario e : listaUsuariosRegistrados) {

			if (nombreUsuario.equals(e.getNombreUsuario()) && contrasena.equals(e.getContrasena())) {

				tipoPerfil = e.retornarTipoUsuario();

			}

		}

		return tipoPerfil;
	}

	// -------------------------------------------------------------------------------------------------------------

	public static void registrarEquipos(String nombre, int ranking, String bandera, ISOPaises iso) {

		capaLogica.registrarEquipos(nombre, ranking, bandera, iso);

	}

	public static void listarEquiposFIFA() {

		ArrayList<Equipo> listaTemp = capaLogica.listarEquiposFIFA();

		for (Equipo e : listaTemp) {

			System.out.println(e.toString());

		}

	}

	
	
	//-------------------------------------------------------------------------------------------------------------
	
	
	public static String retornarBanderaEquipo(String nombreEquipo) {
		
		String bandera = capaLogica.retornarBanderaEquipo(nombreEquipo);
		return bandera;
	}
	
	public static Usuario retornarUsuario(String nombreUsuario) {
		
		Usuario temp = CL.retornarUsuario(nombreUsuario);
		return temp;
	}
	
	public static LigasPublicas retornarLigaPublica(String nombreLiga) {
		
		LigasPublicas temp = CL.retornarLigaPublica(nombreLiga);
		
		return temp;
	}
	
	public static LigasPrivadas retornarLigaPrivada(String nombreLiga) {
		
		LigasPrivadas temp = CL.retornarLigaPrivada(nombreLiga);
		
		return temp;
	}

	//-------------------------------------------------------------------------------------------------------------
	
	

	public boolean validarLigaPublica(String nombre) {
		
		ArrayList<LigasPublicas> listaLigasPublicas = capaLogica.listaLigasPublicas();

		boolean buscar = false;
		for (LigasPublicas LigasPublica : listaLigasPublicas) {
			if (LigasPublica.getNombreLiga().equals(nombre)) {
				buscar = true;
			}
		}

		return true;
	}
	
	public boolean validarLigaPrivada(String nombre) {
		
		ArrayList<LigasPrivadas> listaLigasPrivadas = capaLogica.listaLigasPrivadas();

		boolean buscar = false;
		for (LigasPrivadas LigasPriavada : listaLigasPrivadas) {
			if (LigasPriavada.getNombreLiga().equals(nombre)) {
				buscar = true;
			}
		}

		return true;
	}
	
	
	public boolean validarLigaMundial(String paisOrganizador) {
		
		ArrayList<Mundiales> listaMundiales = capaLogica.listaMundiales();

		boolean buscar = false;
		for (Mundiales Mundial : listaMundiales) {
			if (Mundial.getPaisOrganizador().equals(paisOrganizador)) {
				buscar = true;
			}
		}

		return true;
	}
	
	//-------------------------------------------------------------------------------------------------------------
	
	public static void asignarLigaPublicaUsuario(String nombreUsuario, LigasPublicas liga) {
		
		CL.asignarLigaPublicaUsuario( nombreUsuario, liga);
		
	}
	
	public static void asignarLigaPrivadaUsuario(String nombreUsuario, LigasPrivadas liga) {
		
		CL.asignarLigaPrivadaUsuario( nombreUsuario, liga);
		
	}
	
	//-------------------------------------------------------------------------------------------------------------
	
	
	public static void removerLigaPublicaUsuario(String nombreLiga, LigasPublicas liga) {
		
		CL.removerLigaPublicaUsuario( nombreLiga, liga);
		
	}
	
	public static void removerLigaPrivadaUsuario(String nombreLiga, LigasPrivadas liga) {
		
		CL.removerLigaPrivadaUsuario( nombreLiga, liga);
		
	}
	
	//-------------------------------------------------------------------------------------------------------------
	
	public static String comprobarTipoLiga(String nombreLiga) {
		String comprobante="";
		
		CL.comprobarTipoLiga(nombreLiga);
		
		return comprobante;
	}


}
