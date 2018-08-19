package cl;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

import javax.swing.JOptionPane;

import gestor.Gestor;
import multis.MultiEquipos;
import multis.MultiLigasPrivadas;
import multis.MultiLigasPublicas;
import multis.MultiMundiales;
import multis.MultiPrimeraFase;
import multis.MultiUsuarios;
import rondasMundial.Partido;
import rondasMundial.Resultados;


/**
 * Esta clase posee la logica principal de toda la app, adicionalmente se ejecutan
 * los metodos de todos lo registrar de listar y ademas los arrylits que ejecutan
 * la lista de las clases requeridas de toda la app en general.
 * @author DELL
 *
 */
public class CL {
	
	private static ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
	private static ArrayList<Mundiales> listaMundiales = new ArrayList<Mundiales>();
	private static ArrayList<LigasPublicas> listaLigasPublicas = new ArrayList<LigasPublicas>();
	private static ArrayList<LigasPrivadas> listaLigasPrivadas = new ArrayList<LigasPrivadas>();
	private static ArrayList<Equipo> listaEquiposFIFA = new ArrayList<Equipo>();

	//Inicializacion de los arrayList con la informacion de la base de datos.
	
	public static void ingresarUsuarioLista() throws SQLException, Exception {
		
		listaUsuarios = new MultiUsuarios().retornarUsuarios();

	}
	
	/**
	 * Este metodo ejecuta la lista de los equipos ingresados del registrar equipo
	 * @throws SQLException
	 * @throws Exception
	 */
	public static void ingresarEquiposLista() throws SQLException, Exception {
		
		listaEquiposFIFA = new MultiEquipos().retornarEquipos();

	}
	
	
	
	
	//-------------------------------------------------------------------------------------------------------------
	

	/**
	 * Este metodo ejecuta la lista de los Usuarios ingresados del registrar Usuarios
	 * @param registro
	 */
	public static void registrarUsuario(Usuario registro) throws SQLException, Exception {
		
//		listaUsuarios.add(registro);
		
		new MultiUsuarios().crear(registro.getNombre(), registro.getApellido(), registro.getNombreUsuario(), registro.getContrasena(), registro.getAvatar(),
				registro.getCorreoElectronico(),registro.retornarTipoUsuario());
		
		ingresarUsuarioLista();
		
	}
	
	/**
	 * Ejecuta la lista de los usuarios registrados
	 * @return
	 */
	public static ArrayList<Usuario> listarUsuarios() throws SQLException, Exception {
		
		ingresarUsuarioLista();
		return listaUsuarios;
	}
	
	//-------------------------------------------------------------------------------------------------------------
	
	/**
	 * Este metodo ejecuta las variables almacenadas que seran mostradas en la base de datos
	 * de forma de que el registrar equipos fue  exitoso.
	 * @param nombre
	 * @param ranking
	 * @param bandera
	 * @param iso
	 */
	public static void registrarEquipos(String nombre, int ranking, String bandera, ISOPaises iso) {
		
		Equipo equipoTemp = new Equipo(nombre, ranking, bandera, iso);
		
		listaEquiposFIFA.add(equipoTemp);
		new MultiEquipos().crearEquipoRegistro(equipoTemp.getNombre(), equipoTemp.getRanking(), equipoTemp.getBandera(), equipoTemp.getIso());
		
	}
	

	/**
	 * Retorna la lista de los equipos 
	 * @return
	 */
	public static ArrayList<Equipo> listarEquiposFIFA() throws SQLException, Exception {
		
		ingresarEquiposLista();
		return listaEquiposFIFA;
	}
	
	//---------------------------------------------------------------------------------------------------------------
	/**
	 * Este es el metodo del registrar mundial en general.
	 * se utiliza 3 tipos de variables para el registro principal
	 * int, y boolean
	 * @param registro
	 */
	public static void registrarMundial(Mundiales registro) {
		
		int cupoEquipos = 0;
		int indice=0;
		boolean registroEstado = false;
		
		while(cupoEquipos<32) {
			registroEstado = false;
			Random aleatorio = new Random();
			
			int valorAleatorio = aleatorio.nextInt(listaEquiposFIFA.size());
			
			
			for(Equipo e: registro.getEquiposMundial()) {
				
				if(e==listaEquiposFIFA.get(valorAleatorio)){
					
					registroEstado = true;
					
				}
				
			}
			
			if(registroEstado == false) {
				
				registro.getEquiposMundial().add(listaEquiposFIFA.get(valorAleatorio));
				cupoEquipos++;
			}	
		}
		registro.generarCuadrosJuego();
		listaMundiales.add(registro);
		
		new MultiMundiales().crear(registro.getNombreMundial(), registro.getAno(), registro.getPaisOrganizador(), registro.getEstado());
		
	}

	
	/**
	 * Retorna la lista de mundiales registrados.
	 * @return
	 */
	public static ArrayList<Mundiales> listaMundiales() throws SQLException, Exception {
	
		return new MultiMundiales().retornarMundiales();
//		return listaMundiales;
		
	}
	
	//----------------------------------------------------------------------------------------------------------------
	/**
	 * Este metodo es el registrar de las Ligas Publicas en general
	 * adicionalmente aqui es donde se ejecuta el multi de la liga.
	 * @param registro
	 */
	public static void registrarLigaPublicas(LigasPublicas registro) {
		
		listaLigasPublicas.add(registro);
		new MultiLigasPublicas().crear(registro.getNombreLiga(),registro.getFechaCreacion(),  registro.getEstado(), registro.getPuntos(),
				registro.getBono(), registro.getMundialAnfitrion());
		
	}

	
	//-----------------------------------------------------------------------------------------------------------
	/**
	 * Este metodo es el registrar de las Ligas Privadas en general
	 * dicionalmente aqui es donde se ejecuta el multi de la liga.
	 * @param registro
	 */
	public static void registrarLigaPrivadas(LigasPrivadas registro) {
		
		listaLigasPrivadas.add(registro);
		new MultiLigasPrivadas().crear(registro.getNombreLiga(),registro.getFechaCreacion(),  registro.getEstado(), registro.getPuntos(),
				registro.getBono(), registro.getMundialAnfitrion());
		
	}
	
	/**
	 * Retorna la lista de la Liga Privadas
	 * @return
	 */
	public static ArrayList<LigasPrivadas> listaLigasPrivadas() {
		
		return listaLigasPrivadas;
		
	}
	
	//-----------------------------------------------------------------------------------------------------------
	
	/**
	 * Este metodo ejecuta la bandera de cada equipo.
	 * @param nombreEquipo
	 * @return
	 */
	public static String retornarBanderaEquipo(String nombreEquipo) {
		String bandera="";
		for(Equipo e: listaEquiposFIFA) {
			
			if(nombreEquipo.equals(e.getNombre())) {
				
				bandera = e.getBandera();
				
			}
			
		}
		
		return bandera;
	}
	
	
	/**
	 * Este es el metodo de registrar de los usuarios que 
	 * son almacenados en la base de datos
	 * @param nombreUsuario
	 * @return
	 */
	public static Usuario retornarUsuario(String nombreUsuario) {
		
		Usuario temp = new Usuario("Generico", "Generico", "Generico", "Generico", "Generico", "Generico", 0);
		
		for(Usuario e: listaUsuarios) {
			
			if(e.getNombreUsuario().equals(nombreUsuario)) {
				
				temp = e;

			}	
		}
		return temp;
	}
	
	/**
	 * Metodo que ejecuta las ligas publicas registradas en el menu admin.
	 * @param nombreLiga
	 * @return
	 */
	public static LigasPublicas retornarLigaPublica(String nombreLiga) {
		
		LigasPublicas temp = new LigasPublicas("", null, false, 0, 0, null);
		
		for(LigasPublicas e: listaLigasPublicas) {
			
			if(e.getNombreLiga().equals(nombreLiga)) {
				
				temp = e;
				
			}	
		}
		return temp;
	}
	

	/**
	 * Metodo que ejecuta las ligas publicas registradas en el menu admin.
	 * @param nombreLiga
	 * @return
	 */
	public static LigasPrivadas retornarLigaPrivada(String nombreLiga) {
		
		LigasPrivadas temp = new LigasPrivadas("", null, false, 0, 0, null);
		
		for(LigasPrivadas e: listaLigasPrivadas) {
			
			if(e.getNombreLiga().equals(nombreLiga)) {
				
				temp = e;
				
			}	
		}
		
		return temp;
	}
	
	
	/**
	 * Retorna la lista de los mundiales que son almacenados en un arraylist
	 * @return
	 */
	public static ArrayList<Mundiales> retornarMundialesRegistrados() throws SQLException, Exception{
		
		 ArrayList<Mundiales> listaMundialesTemp = new MultiMundiales().retornarMundiales();
		 
		 for(Mundiales e : listaMundialesTemp) {
			 
			 Resultados resultadosTemp = new Resultados();
			 resultadosTemp.setPrimerCuadro(new MultiPrimeraFase().retornarCuadroPrimeraFase(e.getNombreMundial(), 1));
			 
			 
		 }
		 
//		Aqui se va a inicializar el objeto resultados de todos los campos.
		
		
		return listaMundialesTemp;
		
	}
	
	/**
	 * Retorna la lista de los equipos que son almacenados en un arraylist
	 * @return
	 */
	public static ArrayList<Equipo> retornarEquiposRegistrados(){
		
		return listaEquiposFIFA;		
		
	}
	
	/**
	 * Retorna la lista de las Ligas Publicas que son almacenados en un arraylist
	 * @return
	 */
	public static ArrayList<LigasPublicas> retornarLigasPublicasRegistrados(){
		
		return listaLigasPublicas;
		
	}
	
	/**
	 * Retorna la lista de las Ligas Privadas que son almacenados en un arraylist
	 * @return
	 */
	public static ArrayList<LigasPrivadas> retornarLigasPrivadasRegistrados(){
		
		return listaLigasPrivadas;
		
	}
	
	/**
	 * Retorna la lista de los Usuarios que son almacenados en un arraylist
	 * @return
	 */
	public static ArrayList<Usuario> retornarUsuariosRegistrados(){

		return listaUsuarios;
		
	}

	/**
	 * Retorna la lista de los mundiales y las posiciones de la fase de equipos.
	 * @param nombreMundial
	 * @return
	 */
	public static Mundiales retornarMundial(String nombreMundial) {
		Mundiales mundialTemp=null;
		
		for(Mundiales e: listaMundiales) {
			
			if(nombreMundial.equals(e.getNombreMundial())) {
				
				mundialTemp = new Mundiales(e.getNombreMundial(),e.getAno(),e.getPaisOrganizador(),e.getEstado());
				mundialTemp.setEquiposMundial(e.getEquiposMundial());
				mundialTemp.setEquipoPrimerLugar(e.getEquipoPrimerLugar());
				mundialTemp.setEquipoSegundoLugar(e.getEquipoSegundoLugar());
				mundialTemp.setEquipoTercerLugar(e.getEquipoTercerLugar());
				mundialTemp.setResultadosMundial(e.getResultadosMundial());
				
			}
			
		}
		
		return mundialTemp;
		
	}
	
	
	/**
	 * Retorna la lista de los Equipos y sus caracteristicas en pantalla.
	 * @param nombreEquipo
	 * @return
	 */
	public static Equipo retornarEquipo(String nombreEquipo) {
		Equipo equipoTemp=null;
		
		for(Equipo e: listaEquiposFIFA) {
			
			if(nombreEquipo.equals(e.getNombre())) {
				
				equipoTemp = new Equipo(e.getNombre(),e.getRanking(), e.getBandera(), e.getIso());
				
			}
			
		}
		
		return equipoTemp;
		
	}
	
	/**
	 * Retorna la lista de las Ligas Publicas que son almacenados en un arraylist
	 * @return
	 */
	public static ArrayList<LigasPublicas> retornarLigasPublicas() {
		
		return listaLigasPublicas;
		
	}
	
	
	/**
	 * Retorna los partidos en el cuadro del juego.
	 * @param nombreLiga
	 * @param nombreEquipo
	 * @return
	 */
	public static String retornarPartidosCuadro(String nombreLiga, String nombreEquipo) {
		
		int tipoLiga = -1;
		int index = -1;
		String partidos = "Agenda de Cuadro\n\n";
		
		for(LigasPublicas e: listaLigasPublicas) {
			
			if(nombreLiga.equals(e.getNombreLiga())) {
				
				tipoLiga = 0;
				index = listaLigasPublicas.indexOf(e);
				
			}
			
		}
		
		for(LigasPrivadas e: listaLigasPrivadas) {
			
			if(nombreLiga.equals(e.getNombreLiga())) {
				
				tipoLiga = 1;
				index = listaLigasPrivadas.indexOf(e);
				
			}
			
		}
		
		//Aqui se empieza a recorrer la liga escogida.
		
		
		if(tipoLiga == 0 && index != -1) {
			
			//--------------------------------------------------------------------------------------------------------Primer cuadro
			
			for(Partido e: listaLigasPublicas.get(index).getMundialAnfitrion().getResultadosMundial().getPartidosPrimerCuadro()) {
				
				if(e.getEquipo1().getNombre().equals(nombreEquipo) || e.getEquipo2().getNombre().equals(nombreEquipo)) {
					
					partidos = partidos + e.getEquipo1().getNombre() + " vs " + e.getEquipo2().getNombre() + "\n\n";
					
				}
				
			}
			
			//--------------------------------------------------------------------------------------------------------Segundo cuadro
			
			for(Partido e: listaLigasPublicas.get(index).getMundialAnfitrion().getResultadosMundial().getPartidosSegundoCuadro()) {
				
				if(e.getEquipo1().getNombre().equals(nombreEquipo) || e.getEquipo2().getNombre().equals(nombreEquipo)) {
					
					partidos = partidos + e.getEquipo1().getNombre() + " vs " + e.getEquipo2().getNombre() + "\n\n";
					
				}
				
			}
			
			//--------------------------------------------------------------------------------------------------------Tercer cuadro
			
			for(Partido e: listaLigasPublicas.get(index).getMundialAnfitrion().getResultadosMundial().getPartidosTercerCuadro()) {
				
				if(e.getEquipo1().getNombre().equals(nombreEquipo) || e.getEquipo2().getNombre().equals(nombreEquipo)) {
					
					partidos = partidos + e.getEquipo1().getNombre() + " vs " + e.getEquipo2().getNombre() + "\n\n";
					
				}
				
			}
			
			//--------------------------------------------------------------------------------------------------------Cuarto cuadro
			
			for(Partido e: listaLigasPublicas.get(index).getMundialAnfitrion().getResultadosMundial().getPartidosCuartoCuadro()) {
				
				if(e.getEquipo1().getNombre().equals(nombreEquipo) || e.getEquipo2().getNombre().equals(nombreEquipo)) {
					
					partidos = partidos + e.getEquipo1().getNombre() + " vs " + e.getEquipo2().getNombre() + "\n\n";
					
				}
				
			}
			
			//--------------------------------------------------------------------------------------------------------Quinto cuadro
			
			
			for(Partido e: listaLigasPublicas.get(index).getMundialAnfitrion().getResultadosMundial().getPartidosQuintoCuadro()) {
				
				if(e.getEquipo1().getNombre().equals(nombreEquipo) || e.getEquipo2().getNombre().equals(nombreEquipo)) {
					
					partidos = partidos + e.getEquipo1().getNombre() + " vs " + e.getEquipo2().getNombre() + "\n\n";
					
				}
				
			}
			
			//--------------------------------------------------------------------------------------------------------Sexto cuadro
			
			
			for(Partido e: listaLigasPublicas.get(index).getMundialAnfitrion().getResultadosMundial().getPartidosSextoCuadro()) {
				
				if(e.getEquipo1().getNombre().equals(nombreEquipo) || e.getEquipo2().getNombre().equals(nombreEquipo)) {
					
					partidos = partidos + e.getEquipo1().getNombre() + " vs " + e.getEquipo2().getNombre() + "\n\n";
					
				}
				
			}
			
			//--------------------------------------------------------------------------------------------------------Septimo cuadro
			
			
			for(Partido e: listaLigasPublicas.get(index).getMundialAnfitrion().getResultadosMundial().getPartidosSeptimoCuadro()) {
				
				if(e.getEquipo1().getNombre().equals(nombreEquipo) || e.getEquipo2().getNombre().equals(nombreEquipo)) {
					
					partidos = partidos + e.getEquipo1().getNombre() + " vs " + e.getEquipo2().getNombre() + "\n\n";
					
				}
				
			}
			
			//--------------------------------------------------------------------------------------------------------Octavo cuadro
			
			
			for(Partido e: listaLigasPublicas.get(index).getMundialAnfitrion().getResultadosMundial().getPartidosOctavoCuadro()) {
				
				if(e.getEquipo1().getNombre().equals(nombreEquipo) || e.getEquipo2().getNombre().equals(nombreEquipo)) {
					
					partidos = partidos + e.getEquipo1().getNombre() + " vs " + e.getEquipo2().getNombre() + "\n\n";
					
				}
				
			}
			
			
	
			
			
		} else if(tipoLiga == 1 && index != -1) {
			
			
			//--------------------------------------------------------------------------------------------------------Primer cuadro
			
			for(Partido e: listaLigasPrivadas.get(index).getMundialAnfitrion().getResultadosMundial().getPartidosPrimerCuadro()) {
				
				if(e.getEquipo1().getNombre().equals(nombreEquipo) || e.getEquipo2().getNombre().equals(nombreEquipo)) {
					
					partidos = partidos + e.getEquipo1().getNombre() + " vs " + e.getEquipo2().getNombre() + "\n\n";
					
				}
				
			}
			
			//--------------------------------------------------------------------------------------------------------Segundo cuadro
			
			for(Partido e: listaLigasPrivadas.get(index).getMundialAnfitrion().getResultadosMundial().getPartidosSegundoCuadro()) {
				
				if(e.getEquipo1().getNombre().equals(nombreEquipo) || e.getEquipo2().getNombre().equals(nombreEquipo)) {
					
					partidos = partidos + e.getEquipo1().getNombre() + " vs " + e.getEquipo2().getNombre() + "\n\n";
					
				}
				
			}
			
			//--------------------------------------------------------------------------------------------------------Tercer cuadro
			
			for(Partido e: listaLigasPrivadas.get(index).getMundialAnfitrion().getResultadosMundial().getPartidosTercerCuadro()) {
				
				if(e.getEquipo1().getNombre().equals(nombreEquipo) || e.getEquipo2().getNombre().equals(nombreEquipo)) {
					
					partidos = partidos + e.getEquipo1().getNombre() + " vs " + e.getEquipo2().getNombre() + "\n\n";
					
				}
				
			}
			
			//--------------------------------------------------------------------------------------------------------Cuarto cuadro
			
			for(Partido e: listaLigasPrivadas.get(index).getMundialAnfitrion().getResultadosMundial().getPartidosCuartoCuadro()) {
				
				if(e.getEquipo1().getNombre().equals(nombreEquipo) || e.getEquipo2().getNombre().equals(nombreEquipo)) {
					
					partidos = partidos + e.getEquipo1().getNombre() + " vs " + e.getEquipo2().getNombre() + "\n\n";
					
				}
				
			}
			
			//--------------------------------------------------------------------------------------------------------Quinto cuadro
			
			
			for(Partido e: listaLigasPrivadas.get(index).getMundialAnfitrion().getResultadosMundial().getPartidosQuintoCuadro()) {
				
				if(e.getEquipo1().getNombre().equals(nombreEquipo) || e.getEquipo2().getNombre().equals(nombreEquipo)) {
					
					partidos = partidos + e.getEquipo1().getNombre() + " vs " + e.getEquipo2().getNombre() + "\n\n";
					
				}
				
			}
			
			//--------------------------------------------------------------------------------------------------------Sexto cuadro
			
			
			for(Partido e: listaLigasPrivadas.get(index).getMundialAnfitrion().getResultadosMundial().getPartidosSextoCuadro()) {
				
				if(e.getEquipo1().getNombre().equals(nombreEquipo) || e.getEquipo2().getNombre().equals(nombreEquipo)) {
					
					partidos = partidos + e.getEquipo1().getNombre() + " vs " + e.getEquipo2().getNombre() + "\n\n";
					
				}
				
			}
			
			//--------------------------------------------------------------------------------------------------------Septimo cuadro
			
			
			for(Partido e: listaLigasPrivadas.get(index).getMundialAnfitrion().getResultadosMundial().getPartidosSeptimoCuadro()) {
				
				if(e.getEquipo1().getNombre().equals(nombreEquipo) || e.getEquipo2().getNombre().equals(nombreEquipo)) {
					
					partidos = partidos + e.getEquipo1().getNombre() + " vs " + e.getEquipo2().getNombre() + "\n\n";
					
				}
				
			}
			
			//--------------------------------------------------------------------------------------------------------Octavo cuadro
			
			
			for(Partido e: listaLigasPrivadas.get(index).getMundialAnfitrion().getResultadosMundial().getPartidosOctavoCuadro()) {
				
				if(e.getEquipo1().getNombre().equals(nombreEquipo) || e.getEquipo2().getNombre().equals(nombreEquipo)) {
					
					partidos = partidos + e.getEquipo1().getNombre() + " vs " + e.getEquipo2().getNombre() + "\n\n";
					
				}
				
			}
			
		}
		
		//--------------------------------------------------------------------------------------------------------Fin.
		
		else {
			JOptionPane.showMessageDialog(null, "index: " + "tipoLiga: " + tipoLiga);
			partidos = "Lo sentimos no hemos tenido un problema para mostrar los cuadros de juego del equipo seleccionado.";
			
		}
		
		
		
		
		
		return partidos;
	}
	
	
	/**
	 * Retorna la lista de los Partidos de la primera fase que son 
	 * almacenados en un arraylist
	 * @param equipoSeleccionado
	 * @param nombreLiga
	 * @param tipoLiga
	 * @return
	 */
	public static ArrayList<Partido> retornarPartidosEquipoLigaPrimeraFase(Equipo equipoSeleccionado, String nombreLiga, int tipoLiga){
		
		ArrayList<Partido> partidosRetorno = new ArrayList();
		LigasPublicas tempPublica = null;
		LigasPrivadas tempPrivada = null;
		
		switch(tipoLiga) {
		
		case 0: 
			
			for(LigasPublicas e: listaLigasPublicas) {
				
				if(nombreLiga.equals(e.getNombreLiga())) {
					
					tempPublica = Gestor.retornarLigaPublica(e.getNombreLiga());
					partidosRetorno = retornarPartidosEquipoMundialPrimeraFase(tempPublica.getMundialAnfitrion(), equipoSeleccionado);
					
				}
				
			}
			
			break;
			
		case 1:
			
			for(LigasPrivadas e: listaLigasPrivadas) {
				
				if(nombreLiga.equals(e.getNombreLiga())) {
					
					tempPrivada = Gestor.retornarLigaPrivada(e.getNombreLiga());
					partidosRetorno = retornarPartidosEquipoMundialPrimeraFase(tempPrivada.getMundialAnfitrion(), equipoSeleccionado);
					
				}
				
			}
			
			break;
		
		
		}		
	
		return partidosRetorno;
	}
	
	/**
	 * Retorna la lista de los Partidos el resultado y el quipo seleccionado
	 *  que son almacenados en un arraylist
	 * @param mundial
	 * @param equipoSeleccionado
	 * @return
	 */
	public static ArrayList<Partido> retornarPartidosEquipoMundialPrimeraFase(Mundiales mundial, Equipo equipoSeleccionado) {
		
		ArrayList<Partido> partidosRetorno = new ArrayList();
		
		for(Partido e: mundial.getResultadosMundial().getPartidosPrimerCuadro()){
			
			if(e.getEquipo1().getNombre().equals(equipoSeleccionado.getNombre()) || e.getEquipo2().getNombre().equals(equipoSeleccionado.getNombre())) {
				
				partidosRetorno.add(e);
				
			}
			
		}
		
		for(Partido e: mundial.getResultadosMundial().getPartidosSegundoCuadro()){
			
			if(e.getEquipo1().getNombre().equals(equipoSeleccionado.getNombre()) || e.getEquipo2().getNombre().equals(equipoSeleccionado.getNombre())) {
				
				partidosRetorno.add(e);
				
			}
			
		}
		
		for(Partido e: mundial.getResultadosMundial().getPartidosTercerCuadro()){
			
			if(e.getEquipo1().getNombre().equals(equipoSeleccionado.getNombre()) || e.getEquipo2().getNombre().equals(equipoSeleccionado.getNombre())) {
				
				partidosRetorno.add(e);
				
			}
			
		}
		
		for(Partido e: mundial.getResultadosMundial().getPartidosCuartoCuadro()){
			
			if(e.getEquipo1().getNombre().equals(equipoSeleccionado.getNombre()) || e.getEquipo2().getNombre().equals(equipoSeleccionado.getNombre())) {
				
				partidosRetorno.add(e);
				
			}
			
		}
		
		for(Partido e: mundial.getResultadosMundial().getPartidosQuintoCuadro()){
			
			if(e.getEquipo1().getNombre().equals(equipoSeleccionado.getNombre()) || e.getEquipo2().getNombre().equals(equipoSeleccionado.getNombre())) {
				
				partidosRetorno.add(e);
				
			}
			
		}
		
		for(Partido e: mundial.getResultadosMundial().getPartidosSextoCuadro()){
			
			if(e.getEquipo1().getNombre().equals(equipoSeleccionado.getNombre()) || e.getEquipo2().getNombre().equals(equipoSeleccionado.getNombre())) {
				
				partidosRetorno.add(e);
				
			}
			
		}
		
		for(Partido e: mundial.getResultadosMundial().getPartidosSeptimoCuadro()){
			
			if(e.getEquipo1().getNombre().equals(equipoSeleccionado.getNombre()) || e.getEquipo2().getNombre().equals(equipoSeleccionado.getNombre())) {
				
				partidosRetorno.add(e);
				
			}
			
		}
		
		for(Partido e: mundial.getResultadosMundial().getPartidosOctavoCuadro()){
			
			if(e.getEquipo1().getNombre().equals(equipoSeleccionado.getNombre()) || e.getEquipo2().getNombre().equals(equipoSeleccionado.getNombre())) {
				
				partidosRetorno.add(e);
				
			}
			
		}
		
		return partidosRetorno;
		
	}
	
	
	
	//------------------------------------------------------------------------------------------------
	
	/**
	 * Metodo que asigna un usuario a una liga Publica
	 * @param nombreUsuario
	 * @param liga
	 */
	public static void asignarLigaPublicaUsuario(String nombreUsuario, LigasPublicas liga) {
				
		int indice=0;
		
			for(Usuario e: listaUsuarios) {
				
				if(nombreUsuario.equals(e.getNombreUsuario())) {
					
					indice = listaUsuarios.indexOf(e);
					
				}
				
			}
			
			Usuario miUsuario = listaUsuarios.get(indice);
			miUsuario.setMiLigaPublica(liga);
			listaUsuarios.set(indice, miUsuario);
		
	}
	
	/**
	 * Metodo que asigna un usuario a una liga Privada
	 * @param nombreUsuario
	 * @param liga
	 */
	public static void asignarLigaPrivadaUsuario(String nombreUsuario, LigasPrivadas liga) {
		
		int indice=0;
		
			for(Usuario e: listaUsuarios) {
				
				if(nombreUsuario.equals(e.getNombreUsuario())) {
					
					indice = listaUsuarios.indexOf(e);
					
				}
				
			}
			
			Usuario miUsuario = listaUsuarios.get(indice);
			miUsuario.setMiLigaPrivada(liga);
			listaUsuarios.set(indice, miUsuario);
		
	}
	
	
	/**
	 * Metodo que asigna un equipo a una liga Publica
	 * @param nombreUsuario
	 * @param equipoSeleccionado
	 */
	public static void asignarEquipoLigaPublicaUsuario(String nombreUsuario, Equipo equipoSeleccionado) {
		
		int index = -1;
		Usuario temp = null;
		
		for(Usuario e: listaUsuarios) {
			
			if(nombreUsuario.equals(e.getNombreUsuario())) {
				
				index = listaUsuarios.indexOf(e);
				temp = e;
				temp.setEquipoLigaPublica(equipoSeleccionado);
				
			}
			
		}
		if(index != -1) {
			
			listaUsuarios.set(index, temp);
			
		}
		
	}
	
	/**
	 * Metodo que asigna un equipo a una liga Privada
	 * @param nombreUsuario
	 * @param equipoSeleccionado
	 */
	public static void asignarEquipoLigaPrivadaUsuario(String nombreUsuario, Equipo equipoSeleccionado) {
		int index = -1;
		Usuario temp = null;
		
		for(Usuario e: listaUsuarios) {
			
			if(nombreUsuario.equals(e.getNombreUsuario())) {
				
				index = listaUsuarios.indexOf(e);
				temp = e;
				temp.setEquipoLigaPrivada(equipoSeleccionado);

				
			}
			
		}
		
		if(index != -1) {
			
			listaUsuarios.set(index, temp);

		}
		
	}
	
	
	
	
	//---------------------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * Metodo que remueve la publica del usuario en general. 
	 * @param nombreUsuario
	 */
	public static void removerLigaPublicaUsuario(String nombreUsuario) {
		
		int indice=0;
		
		for(Usuario e: listaUsuarios) {
			
			if(nombreUsuario.equals(e.getNombreUsuario())) {
				
				indice = listaUsuarios.indexOf(e);
				
			}
			
		}
		
		Usuario miUsuario = listaUsuarios.get(indice);
		miUsuario.setMiLigaPublica(null);
		listaUsuarios.set(indice, miUsuario);
		
	}
	/**
	 *  Metodo que remueve la privada del usuario en general. 
	 * @param nombreUsuario
	 */
	public static void removerLigaPrivadaUsuario(String nombreUsuario) {
		
		int indice=0;
		
		for(Usuario e: listaUsuarios) {
			
			if(nombreUsuario.equals(e.getNombreUsuario())) {
				
				indice = listaUsuarios.indexOf(e);
				
			}
			
		}
		
		Usuario miUsuario = listaUsuarios.get(indice);
		miUsuario.setMiLigaPrivada(null);
		listaUsuarios.set(indice, miUsuario);
		
	}
	
	/**
	 *  Metodo que remueve los equipos de la liga publica del usuario en general. 
	 * @param nombreUsuario
	 */
	public static void removerEquipoLigaPublicaUsuario(String nombreUsuario) {
		
		int indice=0;
		
		for(Usuario e: listaUsuarios) {
			
			if(nombreUsuario.equals(e.getNombreUsuario())) {
				
				indice = listaUsuarios.indexOf(e);
				
			}
			
		}
		
		Usuario miUsuario = listaUsuarios.get(indice);
		miUsuario.setEquipoLigaPublica(null);
		listaUsuarios.set(indice, miUsuario);
		
	}
	
	/**
	 * Metodo que remueve los equipos de la liga privada del usuario en general. 
	 * @param nombreUsuario
	 */
	public static void removerEquipoLigaPrivadaUsuario(String nombreUsuario) {
		
		int indice=0;
		
		for(Usuario e: listaUsuarios) {
			
			if(nombreUsuario.equals(e.getNombreUsuario())) {
				
				indice = listaUsuarios.indexOf(e);
				
			}
			
		}
		
		Usuario miUsuario = listaUsuarios.get(indice);
		miUsuario.setEquipoLigaPrivada(null);
		listaUsuarios.set(indice, miUsuario);
		
	}
	
	
	//-------------------------------------------------------------------------------------------------------------
		
	/**
	 * Meotodo que comprueba el tipo de liga
	 * @param nombreLiga
	 * @return
	 */
		public static String comprobarTipoLiga(String nombreLiga) {
			String comprobante="";
			
			for(LigasPrivadas e: listaLigasPrivadas) {
				
				if(nombreLiga.equals(e.getNombreLiga())) {
					
					comprobante = "privada";
					
				}
				
			}
			
			for(LigasPublicas e: listaLigasPublicas) {
				
				if(nombreLiga.equals(e.getNombreLiga())) {
					
					comprobante = "publica";
					
				}
				
			}
			if(comprobante != "") {
				
				comprobante = "ninguno";
				
			}
			
			return comprobante;
		}
		
		//-------------------------------------------------------------------------------------------------------------
		
		/**
		 * Metodo que elimina la liga publica
		 * @param nombreLiga
		 */
		public static void eliminarLigaPublica(String nombreLiga) {
			
			int index=-1;
			
			for(LigasPublicas e: listaLigasPublicas) {
				
				if(e.getNombreLiga().equals(nombreLiga)) {
					
					index = listaLigasPublicas.indexOf(e);
					
				}
				
			}
			
			if(index != -1) {
				
				listaLigasPublicas.remove(index);
				//En este punto se realizara un ciclo for para analizar que usuarios tienen esta liga incluida y se les removera.
				
			}
			
		}
		
		/**
		 * Elimina la Liga Privada 
		 * @param nombreLiga
		 */
		public static void eliminarLigaPrivada(String nombreLiga) {
			
			int index=-1;
			
			for(LigasPrivadas e: listaLigasPrivadas) {
				
				if(e.getNombreLiga().equals(nombreLiga)) {
					
					index = listaLigasPrivadas.indexOf(e);

				}
				
			}
			
			if(index != -1) {

				listaLigasPrivadas.remove(index);
				//En este punto se realizara un ciclo for para analizar que usuarios tienen esta liga incluida y se les removera.
				
			}
	
		}

		
		//-------------------------------------------------------------------------------------------------------------
		
		/**
		 * Actualiza el  nombre del usuario actual
		 * @param usuarioActualizado
		 */
		public static void actualizarJugador(Usuario usuarioActualizado) {
			
			for(Usuario e: listaUsuarios) {
				
				if(e.getNombreUsuario().equals(usuarioActualizado.getNombreUsuario())) {
					
					listaUsuarios.set(listaUsuarios.indexOf(e), usuarioActualizado);
					
				}
				
			}
			
		}
		
		
		
		
		
		
		
		
		
		

}