package gestor;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;

import cl.*;
import rondasMundial.Partido;

/**
 * Esta clase es la principal donde se ejecutan los metodos de los registrar de
 * parte de perfil admin, jugador y observado ademas posee lo componente que
 * ejecutan las listas de las clases mas principales
 * 
 * @author DELL
 *
 */
public class Gestor {

	/**
	 * Este metodo ejecuta el registrar usuario donde se representan los tipos de
	 * variables almacenados para la ejecucion del metodo solicitado
	 * 
	 * @param nombre
	 * @param apellido
	 * @param nombreUsuario
	 * @param contrasena
	 * @param avatar
	 * @param correoElectronico
	 * @param tipoUsuario
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public void registrarUsuario(String nombre, String apellido, String nombreUsuario, String contrasena, String avatar,
			String correoElectronico, int tipoUsuario) throws SQLException, Exception {

		Usuario registro = new Usuario(nombre, apellido, nombreUsuario, contrasena, avatar, correoElectronico,
				tipoUsuario);
		CL.registrarUsuario(registro);

	}

	/**
	 * Este metodo ejecuta el registrar mundial donde se representan los tipos de
	 * variables almacenados para la ejecucion del metodo solicitado
	 * 
	 * @param nombreMundial
	 * @param fechaInicio
	 * @param paisOrganizador
	 * @param estado
	 */
	public void registrarMundial(String nombreMundial, LocalDate fechaInicio, String paisOrganizador, boolean estado) {

		Mundiales registro = new Mundiales(nombreMundial, fechaInicio, paisOrganizador, estado);
		CL.registrarMundial(registro);

	}

	/**
	 * Este metodo ejecuta el registrar LigasPublica donde se representan los tipos
	 * de variables almacenados para la ejecucion del metodo solicitado
	 * 
	 * @param nombreLiga
	 * @param fechaCreacion
	 * @param estado
	 * @param puntos
	 * @param bono
	 * @param mundialAnfitrion
	 */
	public static void registrarLigaPublicas(String nombreLiga, LocalDate fechaCreacion, boolean estado, int puntos,
			int bono, Mundiales mundialAnfitrion) {

		LigasPublicas registro = new LigasPublicas(nombreLiga, fechaCreacion, estado, puntos, bono, mundialAnfitrion);
		CL.registrarLigaPublicas(registro);

	}

	/**
	 * Este metodo ejecuta el registrar LigasPrivadas donde se representan los tipos
	 * de variables almacenados para la ejecucion del metodo solicitado
	 * 
	 * @param nombreLiga
	 * @param fechaCreacion
	 * @param estado
	 * @param puntos
	 * @param bono
	 * @param mundialAnfitrion
	 */
	public static void registrarLigaPrivadas(String nombreLiga, LocalDate fechaCreacion, boolean estado, int puntos,
			int bono, Mundiales mundialAnfitrion) {

		LigasPrivadas registro = new LigasPrivadas(nombreLiga, fechaCreacion, estado, puntos, bono, mundialAnfitrion);
		CL.registrarLigaPrivadas(registro);

	}

	// ----------------------------------------------------------LISTAR-----------------------------------------------------------------------------
	/**
	 * Este es el metodo para listar los usuarios
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public void listarUsuarios() throws SQLException, Exception {

		ArrayList<Usuario> listaImpresion = CL.listarUsuarios();

		System.out.println("");

		for (Usuario e : listaImpresion) {

			System.out.println(e.toString());

		}

		System.out.println("");

	}

	/**
	 * Este es el metodo para listar los equiposFIFA
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public void listarEquiposFIFA() throws SQLException, Exception {
		// jue
		ArrayList<Equipo> listaImpresion = CL.listarEquiposFIFA();

		System.out.println("");

		for (Equipo e : listaImpresion) {

			System.out.println(e.toString());

		}

		System.out.println("");

	}
	
	/**
	 * Este es el metodo para listar los Mundiales
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public void listarMundiales() throws SQLException, Exception {

		ArrayList<Mundiales> listaImpresion = CL.listaMundiales();

		System.out.println("");

		for (Mundiales e : listaImpresion) {

			System.out.println(e.toString());

		}

		System.out.println("");

	}
	
	/**
	 * Este es el metodo para listar las LigasPublicas
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public void listarLigasPublicas() throws SQLException, Exception {

		ArrayList<LigasPublicas> listaImpresion = CL.retornarLigasPublicas();

		System.out.println("");

		for (LigasPublicas e : listaImpresion) {

			System.out.println(e.toString());

		}

		System.out.println("");

	}
	/**
	 * Este es el metodo para listar las LigasPrivadas
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public void listarLigasPrivadas() throws SQLException, Exception {

		ArrayList<LigasPrivadas> listaImpresion = CL.listaLigasPrivadas();

		System.out.println("");

		for (LigasPrivadas e : listaImpresion) {

			System.out.println(e.toString());

		}

		System.out.println("");

	}

	// -----------------------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * Este metodo valida las variables almacenadas para comprobar los campos del login
	 * la contraseña sea correcta y los caracteres requeridos
	 * @param nombreLectura
	 * @param contrasenaLectura
	 * @param avatarLectura
	 * @param eleccion
	 * @return
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public int validarUsuario(String nombreLectura, String contrasenaLectura, String avatarLectura, int eleccion) throws SQLException, Exception {
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
	
	/**
	 * Este metodo retorna los tipos de usuario que exiten en la app
	 * esto a base del perfil q se esta ejecutando se presentaran
	 * las validaciones segun el tipo de perfil
	 * @param nombreUsuario
	 * @param contrasena
	 * @return
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public Perfiles retornarTipoUsuario(String nombreUsuario, String contrasena) throws SQLException, Exception {

		Perfiles tipoPerfil = Perfiles.VIEWER;
		ArrayList<Usuario> listaUsuariosRegistrados = CL.listarUsuarios();

		for (Usuario e : listaUsuariosRegistrados) {

			if (nombreUsuario.equals(e.getNombreUsuario()) && contrasena.equals(e.getContrasena())) {

				tipoPerfil = e.retornarTipoUsuario();

			}

		}

		return tipoPerfil;
	}
	/**
	 * Guarda en arraylist los equipos registrados
	 * @return
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public static ArrayList<Equipo> retornarEquiposRegistrados() throws SQLException, Exception {

		ArrayList<Equipo> listaEquiposRegistrados = CL.retornarEquiposRegistrados();

		return listaEquiposRegistrados;
	}
	/**
	 * Guarda en arraylist los mundiales registrados
	 * @return
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public static ArrayList<Mundiales> retornarMundialesRegistrados() throws SQLException, Exception {

		ArrayList<Mundiales> listaMundialesRegistrados = CL.retornarMundialesRegistrados();

		return listaMundialesRegistrados;
	}
	/**
	 * Guarda en arraylist las LigasPublicas registradas
	 * @return
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public static ArrayList<LigasPublicas> retornarLigasPublicasRegistrados() throws SQLException, Exception {

		ArrayList<LigasPublicas> listaLigasPublicasRegistrados = CL.retornarLigasPublicasRegistrados();

		return listaLigasPublicasRegistrados;
	}
	/**
	 * Guarda en arraylist las LigasPrivadas registradas
	 * @return
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public static ArrayList<LigasPrivadas> retornarLigasPrivadasRegistrados() throws SQLException, Exception {

		ArrayList<LigasPrivadas> listaLigasPrivadasRegistrados = CL.retornarLigasPrivadasRegistrados();

		return listaLigasPrivadasRegistrados;
	}
	/**
	 * Guarda en arraylist los Usuarios registrados
	 * @return
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public static ArrayList<Usuario> retornarUsuariosRegistrados() throws SQLException, Exception {

		ArrayList<Usuario> listaUsuariosRegistrados = CL.retornarUsuariosRegistrados();

		return listaUsuariosRegistrados;
	}
	/**
	 * Este Metodo Retorna el nombre del mundial
	 * @param nombreMundial
	 * @return
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public static Mundiales retornarMundial(String nombreMundial) throws SQLException, Exception {

		Mundiales mundialTemp = CL.retornarMundial(nombreMundial);

		return mundialTemp;

	}
	/**
	 * Este metodo retorna los partidos de los equipos de la
	 * liga y la fases de los partidos
	 * @param equipoSeleccionado
	 * @param nombreLiga
	 * @param tipoLiga
	 * @return
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public static Partido[] retornarPartidosEquipoLiga(Equipo equipoSeleccionado, String nombreLiga, int tipoLiga) throws SQLException, Exception {

		ArrayList<Partido> partidosRegistrados = CL.retornarPartidosEquipoLigaPrimeraFase(equipoSeleccionado,
				nombreLiga, tipoLiga);
		Partido[] retorno = new Partido[3];
		retorno[0] = partidosRegistrados.get(0);
		retorno[1] = partidosRegistrados.get(1);
		retorno[2] = partidosRegistrados.get(2);

		return retorno;
	}

	// -------------------------------------------------------------------------------------------------------------

	/**
	 * Este metodo retorna el equipo que sera registrado en el registrar equipos
	 * dentro de la pantalla de admin 
	 * @param nombreLectura
	 * @param ranking
	 * @param banderaLectura
	 * @param ISOPaisesLectura
	 * @return
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public int validarEquipo(String nombreLectura, int ranking, String banderaLectura, String ISOPaisesLectura) throws SQLException, Exception {
		/*
		 * int comprobante = 0; int comprobanteNombreEquipo = 0; int posicion = -1;
		 * String validador = "";
		 */

		ArrayList<Equipo> listaComparacion = CL.listarEquiposFIFA();

		System.out.println(ranking);

		return ranking;

	}
	/**
	 * Metodo que retorna las variables almacenadas de los registrar equipos 
	 * @param nombre
	 * @param ranking
	 * @param bandera
	 * @param iso
	 */
	public static void registrarEquipos(String nombre, int ranking, String bandera, ISOPaises iso) {

		CL.registrarEquipos(nombre, ranking, bandera, iso);

	}

	/*
	 * public static void listarEquiposFIFA() {
	 * 
	 * ArrayList<Equipo> listaTemp = CL.listarEquiposFIFA();
	 * 
	 * for (Equipo e : listaTemp) {
	 * 
	 * System.out.println(e.toString());
	 * 
	 * 
	 * //prueba
	 * 
	 * }
	 * 
	 * 
	 * }
	 */

	// -------------------------------------------------------------------------------------------------------------
	/**
	 * Retorna la bandera de cada equipo
	 * @param nombreEquipo
	 * @return
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public static String retornarBanderaEquipo(String nombreEquipo) throws SQLException, Exception {

		String bandera = CL.retornarBanderaEquipo(nombreEquipo);
		return bandera;
	}

	/**
	 * Retorna el usuario solicitado, en caso de que se encuentre en la base de datos, comunmente se usa este metodo para actualizar.
	 * @param nombreUsuario
	 * @return
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public static Usuario retornarUsuario(String nombreUsuario) throws SQLException, Exception {

		Usuario temp = CL.retornarUsuario(nombreUsuario);
		return temp;
	}

	/**
	 * Retorna el nombre del equipo
	 * @param nombreEquipo
	 * @return
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public static Equipo retornarEquipo(String nombreEquipo) throws SQLException, Exception {

		Equipo temp = CL.retornarEquipo(nombreEquipo);
		return temp;
	}

	/**
	 * Retorna el nombre de la Liga Publica
	 * @param nombreLiga
	 * @return
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public static LigasPublicas retornarLigaPublica(String nombreLiga) throws SQLException, Exception {

		LigasPublicas temp = CL.retornarLigaPublica(nombreLiga);

		return temp;
	}
	
	/**
	 * Retorna el nombre de la Liga Privada
	 * @param nombreLiga
	 * @return
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public static LigasPrivadas retornarLigaPrivada(String nombreLiga) throws SQLException, Exception {

		LigasPrivadas temp = CL.retornarLigaPrivada(nombreLiga);

		return temp;
	}
	
	/**
	 * Retorna el nombre de la Liga y el nombre del equipo
	 * @param nombreLiga
	 * @param nombreEquipo
	 * @return
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public static String retornarPartidosCuadro(String nombreLiga, String nombreEquipo) throws SQLException, Exception {

		String partidos = CL.retornarPartidosCuadro(nombreLiga, nombreEquipo);

		return partidos;
	}

	// ---------------------------------------------------------------------------------------------------
	
	/**
	 * valida el nombre de la liga publica
	 * @param nombre
	 * @return
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public boolean validarLigaPublica(String nombre) throws SQLException, Exception {

		ArrayList<LigasPublicas> listaLigasPublicas = CL.retornarLigasPublicas();

		boolean buscar = false;
		for (LigasPublicas LigasPublica : listaLigasPublicas) {
			if (LigasPublica.getNombreLiga().equals(nombre)) {
				buscar = true;
			}
		}

		return true;
	}
	/**
	 * valida el nombre de la liga privada
	 * @param nombre
	 * @return
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public boolean validarLigaPrivada(String nombre) throws SQLException, Exception {

		ArrayList<LigasPrivadas> listaLigasPrivadas = CL.listaLigasPrivadas();

		boolean buscar = false;

		for (LigasPrivadas LigasPriavada : listaLigasPrivadas) {
			if (LigasPriavada.getNombreLiga().equals(nombre)) {
				buscar = true;
			}
		}

		return true;
	}
	
	/**
	 * valida el nombre del Pais Organizador
	 * @param paisOrganizador
	 * @return
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public boolean validarLigaMundial(String paisOrganizador) throws SQLException, Exception {

		ArrayList<Mundiales> listaMundiales = CL.listaMundiales();

		boolean buscar = false;
		for (Mundiales Mundial : listaMundiales) {
			if (Mundial.getPaisOrganizador().equals(paisOrganizador)) {
				buscar = true;
			}
		}

		return true;
	}

	/**
	 * valida el nombre del mundial anfitrion
	 * @param mundialAnfitrion
	 * @return
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public boolean validarMundial(Mundiales mundialAnfitrion) throws SQLException, Exception {

		ArrayList<Mundiales> listaMundiales = CL.retornarMundialesRegistrados();
		boolean buscar = false;

		for (Mundiales e : listaMundiales) {

			if (e.getNombreMundial().equals(mundialAnfitrion.getNombreMundial())) {
				buscar = true;
			}
		}

		return true;
	}

	// -------------------------------------------------------------------------------------------------------------
	/**
	 * Metodo de asignacion de usuario a una liga publica
	 * @param nombreUsuario
	 * @param liga
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public static void asignarLigaPublicaUsuario(String nombreUsuario, LigasPublicas liga) throws SQLException, Exception {

		CL.asignarLigaPublicaUsuario(nombreUsuario, liga);

	}
	/**
	 * Metodo de asignacion de usuario a una liga Privada
	 * @param nombreUsuario
	 * @param liga
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public static void asignarLigaPrivadaUsuario(String nombreUsuario, LigasPrivadas liga) throws SQLException, Exception {

		CL.asignarLigaPrivadaUsuario(nombreUsuario, liga);

	}
	
	/**
	 * Metodo de asignacion de una Liga Pubica a usuario con el Equipo escojido correspondiente
	 * @param nombreUsuario
	 * @param equipoSeleccionado
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public static void asignarEquipoLigaPublicaUsuario(String nombreUsuario, Equipo equipoSeleccionado) throws SQLException, Exception {

		CL.asignarEquipoLigaPublicaUsuario(nombreUsuario, equipoSeleccionado);

	}
	
	/**
	 *  Metodo de asignacion de una Liga Privada a usuario con el Equipo escojido correspondiente
	 * @param nombreUsuario
	 * @param equipoSeleccionado
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public static void asignarEquipoLigaPrivadaUsuario(String nombreUsuario, Equipo equipoSeleccionado) throws SQLException, Exception {

		CL.asignarEquipoLigaPrivadaUsuario(nombreUsuario, equipoSeleccionado);

	}

	// -------------------------------------------------------------------------------------------------------------

	/**
	 * Metodo que remueve la liga publica de usuario 
	 * @param nombreUsuario
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public static void removerLigaPublicaUsuario(String nombreUsuario) throws SQLException, Exception {

		CL.removerLigaPublicaUsuario(nombreUsuario);

	}
	
	/**
	 * Metodo que remueve la liga publica de usuario
	 * @param nombreUsuario
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public static void removerLigaPrivadaUsuario(String nombreUsuario) throws SQLException, Exception {

		CL.removerLigaPrivadaUsuario(nombreUsuario);

	}
	
	/**
	 * Metodo que remueve el Equipo de liga publica del usuario 
	 * @param nombreUsuario
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public static void removerEquipoLigaPublicaUsuario(String nombreUsuario) throws SQLException, Exception {

		CL.removerEquipoLigaPublicaUsuario(nombreUsuario);

	}
	/**
	 * Metodo que remueve el Equipor de liga privada del usuario
	 * @param nombreUsuario
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public static void removerEquipoLigaPrivadaUsuario(String nombreUsuario) throws SQLException, Exception {

		CL.removerEquipoLigaPublicaUsuario(nombreUsuario);

	}

	// -------------------------------------------------------------------------------------------------------------
	
	/**
	 * Metodo de eliminar una liga publica
	 * @param nombreLiga
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public static void eliminarLigaPublica(String nombreLiga) throws SQLException, Exception {

		CL.eliminarLigaPublica(nombreLiga);

	}
	
	/**
	 * Metodo de eliminar una liga privada
	 * @param nombreLiga
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public static void eliminarLigaPrivada(String nombreLiga) throws SQLException, Exception {

		CL.eliminarLigaPrivada(nombreLiga);

	}
	
	/**
	 * Metodo que actualiza el usuario actual y el jugador 
	 * @param usuarioActualizado
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public static void actualizarJugador(Usuario usuarioActualizado) throws SQLException, Exception {

		CL.actualizarJugador(usuarioActualizado);

	}

}
