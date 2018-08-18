package gestor;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;

import cl.*;
import rondasMundial.Partido;

public class Gestor {

	
	public void registrarUsuario(String nombre, String apellido, String nombreUsuario, String contrasena, String avatar,
			String correoElectronico, int tipoUsuario) {

		Usuario registro = new Usuario(nombre, apellido, nombreUsuario, contrasena, avatar, correoElectronico,
				tipoUsuario);
		CL.registrarUsuario(registro);
		

	}

	public void registrarMundial(String nombreMundial, LocalDate fechaInicio, String paisOrganizador, boolean estado) {

		Mundiales registro = new Mundiales(nombreMundial, fechaInicio, paisOrganizador,  estado);
		CL.registrarMundial(registro);

	}

	public static void registrarLigaPublicas(String nombreLiga, LocalDate fechaCreacion, boolean estado, int puntos,
			int bono,Mundiales mundialAnfitrion) {
		
		LigasPublicas registro = new LigasPublicas(nombreLiga, fechaCreacion, estado, puntos, bono, mundialAnfitrion);
		CL.registrarLigaPublicas(registro);

	}

	public static void registrarLigaPrivadas(String nombreLiga, LocalDate fechaCreacion, boolean estado, int puntos,
			int bono,Mundiales mundialAnfitrion) {
		
		LigasPrivadas registro = new LigasPrivadas(nombreLiga, fechaCreacion, estado, puntos, bono,mundialAnfitrion);
		CL.registrarLigaPrivadas(registro);

	}

	// ----------------------------------------------------------LISTAR-----------------------------------------------------------------------------

	public void listarUsuarios() {

		ArrayList<Usuario> listaImpresion = CL.listarUsuarios();

		System.out.println("");

		for (Usuario e : listaImpresion) {

			System.out.println(e.toString());

		}

		System.out.println("");

	}

	public void listarMundiales() {

		ArrayList<Mundiales> listaImpresion = CL.listaMundiales();

		System.out.println("");

		for (Mundiales e : listaImpresion) {

			System.out.println(e.toString());

		}

		System.out.println("");

	}

	public void listarLigasPublicas() {

		ArrayList<LigasPublicas> listaImpresion = CL.retornarLigasPublicas();

		System.out.println("");

		for (LigasPublicas e : listaImpresion) {

			System.out.println(e.toString());

		}

		System.out.println("");

	}

	public void listarLigasPrivadas() {

		ArrayList<LigasPrivadas> listaImpresion = CL.listaLigasPrivadas();

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

		ArrayList<Usuario> listaComparacion = CL.listarUsuarios();
		
		

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

	// --------------------------------------------------------------------------------------------------

	public Perfiles retornarTipoUsuario(String nombreUsuario, String contrasena) {

		Perfiles tipoPerfil = Perfiles.VIEWER;
		ArrayList<Usuario> listaUsuariosRegistrados = CL.listarUsuarios();

		for (Usuario e : listaUsuariosRegistrados) {

			if (nombreUsuario.equals(e.getNombreUsuario()) && contrasena.equals(e.getContrasena())) {

				tipoPerfil = e.retornarTipoUsuario();

			}

		}

		return tipoPerfil;
	}

	public static ArrayList<Equipo> retornarEquiposRegistrados() {

		ArrayList<Equipo> listaEquiposRegistrados = CL.retornarEquiposRegistrados();

		return listaEquiposRegistrados;
	}
	
	public static ArrayList<Mundiales> retornarMundialesRegistrados() {

		ArrayList<Mundiales> listaMundialesRegistrados = CL.retornarMundialesRegistrados();

		return listaMundialesRegistrados;
	}
	
	public static ArrayList<LigasPublicas> retornarLigasPublicasRegistrados() {

		ArrayList<LigasPublicas> listaLigasPublicasRegistrados = CL.retornarLigasPublicasRegistrados();

		return listaLigasPublicasRegistrados;
	}
	
	public static ArrayList<LigasPrivadas> retornarLigasPrivadasRegistrados() {

		ArrayList<LigasPrivadas> listaLigasPrivadasRegistrados = CL.retornarLigasPrivadasRegistrados();

		return listaLigasPrivadasRegistrados;
	}
	
	public static ArrayList<Usuario> retornarUsuariosRegistrados() {

		ArrayList<Usuario> listaUsuariosRegistrados = CL.retornarUsuariosRegistrados();
		
		return listaUsuariosRegistrados;
	}	
	
	public static Mundiales retornarMundial(String nombreMundial) {
		
		Mundiales mundialTemp = CL.retornarMundial(nombreMundial);
		
		return mundialTemp;
		
	}
	
	public static Partido[] retornarPartidosEquipoLiga(Equipo equipoSeleccionado, String nombreLiga, int tipoLiga){
		
		ArrayList<Partido> partidosRegistrados = CL.retornarPartidosEquipoLigaPrimeraFase( equipoSeleccionado, nombreLiga, tipoLiga);
		Partido [] retorno = new Partido[3];
		retorno[0] = partidosRegistrados.get(0);
		retorno[1] = partidosRegistrados.get(1);
		retorno[2] = partidosRegistrados.get(2);
		
		return retorno;
	}

	// -------------------------------------------------------------------------------------------------------------

	public int validarEquipo(String nombreLectura, int ranking, String banderaLectura, String ISOPaisesLectura) {
		int comprobante = 0;
		int comprobanteNombreEquipo = 0;
		int posicion = -1;
		String validador = "";

		ArrayList<Equipo> listaComparacion = CL.listarEquiposFIFA();

		return ranking;
	}
	

	
	
	public static void registrarEquipos(String nombre, int ranking, String bandera, ISOPaises iso) {

		CL.registrarEquipos(nombre, ranking, bandera, iso);
		
		
		
		

	}

	public static void listarEquiposFIFA() {

		ArrayList<Equipo> listaTemp = CL.listarEquiposFIFA();

		for (Equipo e : listaTemp) {

			System.out.println(e.toString());
			
			
			

		}
		

	}
	

	// -------------------------------------------------------------------------------------------------------------

	public static String retornarBanderaEquipo(String nombreEquipo) {

		String bandera = CL.retornarBanderaEquipo(nombreEquipo);
		return bandera;
	}

	public static Usuario retornarUsuario(String nombreUsuario) {///ESTO ME SIRVE

		Usuario temp = CL.retornarUsuario(nombreUsuario);
		return temp;
	}
	
	public static Equipo retornarEquipo(String nombreEquipo) {

		Equipo temp = CL.retornarEquipo(nombreEquipo);
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
	
	public static String retornarPartidosCuadro(String nombreLiga, String nombreEquipo){
		
		String partidos = CL.retornarPartidosCuadro(nombreLiga, nombreEquipo);
		
		return partidos;
	}
	
	//---------------------------------------------------------------------------------------------------

	public boolean validarLigaPublica(String nombre) {

		ArrayList<LigasPublicas> listaLigasPublicas = CL.retornarLigasPublicas();

		boolean buscar = false;
		for (LigasPublicas LigasPublica : listaLigasPublicas) {
			if (LigasPublica.getNombreLiga().equals(nombre)) {
				buscar = true;
			}
		}

		return true;
	}

	public boolean validarLigaPrivada(String nombre) {

		ArrayList<LigasPrivadas> listaLigasPrivadas = CL.listaLigasPrivadas();

		boolean buscar = false;
		
		for (LigasPrivadas LigasPriavada : listaLigasPrivadas) {
			if (LigasPriavada.getNombreLiga().equals(nombre)) {
				buscar = true;
			}
		}

		return true;
	}

	public boolean validarLigaMundial(String paisOrganizador) {
		
		ArrayList<Mundiales> listaMundiales = CL.listaMundiales();

		boolean buscar = false;
		for (Mundiales Mundial : listaMundiales) {
			if (Mundial.getPaisOrganizador().equals(paisOrganizador)) {
				buscar = true;
			}
		}

		return true;
	}

	public boolean validarMundial(Mundiales mundialAnfitrion) {

		ArrayList<Mundiales> listaMundiales = CL.retornarMundialesRegistrados();
		boolean buscar = false;
		
		for (Mundiales e: listaMundiales) {
			
			if (e.getNombreMundial().equals(mundialAnfitrion.getNombreMundial())) {
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
	
	
	public static void asignarEquipoLigaPublicaUsuario(String nombreUsuario, Equipo equipoSeleccionado) {
		
		CL.asignarEquipoLigaPublicaUsuario( nombreUsuario,  equipoSeleccionado);
		
	}
	
	
	public static void asignarEquipoLigaPrivadaUsuario(String nombreUsuario, Equipo equipoSeleccionado) {
		
		CL.asignarEquipoLigaPrivadaUsuario(nombreUsuario,  equipoSeleccionado);
		
	}
	
	
	
	
	
	
	//-------------------------------------------------------------------------------------------------------------
	
	
	public static void removerLigaPublicaUsuario(String nombreUsuario) {
		
		CL.removerLigaPublicaUsuario(nombreUsuario);
		
	}
	
	public static void removerLigaPrivadaUsuario(String nombreUsuario) {
		
		CL.removerLigaPrivadaUsuario( nombreUsuario);
		
	}
	
	public static void removerEquipoLigaPublicaUsuario(String nombreUsuario) {
		
		CL.removerEquipoLigaPublicaUsuario(nombreUsuario);
		
	}
	
	public static void removerEquipoLigaPrivadaUsuario(String nombreUsuario) {
		
		CL.removerEquipoLigaPublicaUsuario(nombreUsuario);
		
	}
	
	//-------------------------------------------------------------------------------------------------------------
	
	
	public static void eliminarLigaPublica(String nombreLiga) {
		
		CL.eliminarLigaPublica(nombreLiga);
		
		
	}
	
	
	public static void eliminarLigaPrivada(String nombreLiga) {
		
		CL.eliminarLigaPrivada(nombreLiga);
		
		
	}
	
	public static void actualizarJugador(Usuario usuarioActualizado) {
		
		CL.actualizarJugador(usuarioActualizado);
		
	}
	
}
