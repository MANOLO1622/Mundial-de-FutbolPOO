package cl;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

import javax.swing.JOptionPane;


public class CL {
	
	private static ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
	private static ArrayList<Mundiales> listaMundiales = new ArrayList<Mundiales>();
	private static ArrayList<LigasPublicas> listaLigasPublicas = new ArrayList<LigasPublicas>();
	private static ArrayList<LigasPrivadas> listaLigasPrivadas = new ArrayList<LigasPrivadas>();
	private static TextFileIO UsuariosRegLog = new TextFileIO("logs//Login.txt");
	private static ArrayList<Equipo> listaEquiposFIFA = new ArrayList();
//	private static ArrayList<Anfitrion> listaAnfitrionesFIFA = new ArrayList();
	
	
	
	
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
	
	
	/*//---------------------------------------------------------------------------------------------------------------
	
	public static void registrarAnfitriones(String nombre) {
		
		Anfitrion anfitrionTemp = new Anfitrion(nombre);
		
		listaAnfitrionesFIFA.add(anfitrionTemp);
		
	}
	
	public static ArrayList<Anfitrion> listarAnfitrionesFIFA() {
		
		return listaAnfitrionesFIFA;
	}*/
	
	//---------------------------------------------------------------------------------------------------------------
	public static void registrarMundial(Mundiales registro) {
		
		listaMundiales.add(registro);
		
	}
	public static ArrayList<Mundiales> listaMundiales() {
		
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
	public static ArrayList<LigasPrivadas> listaLigasPrivadas() {
		
		return listaLigasPrivadas;
		
	}
	
	//-----------------------------------------------------------------------------------------------------------
	
	public static String retornarBanderaEquipo(String nombreEquipo) {
		String bandera="";
		for(Equipo e: listaEquiposFIFA) {
			
			if(nombreEquipo.equals(e.getNombre())) {
				
				bandera = e.getBandera();
				
			}
			
		}
		
		return bandera;
	}
	
	
	public static Usuario retornarUsuario(String nombreUsuario) {
		
		Usuario temp = new Usuario("Generico", "Generico", "Generico", "Generico", "Generico", "Generico", 0);
		
		for(Usuario e: listaUsuarios) {
			
			if(e.getNombreUsuario().equals(nombreUsuario)) {
				
				temp.setNombre(e.getNombre());
				temp.setApellido(e.getApellido());
				temp.setNombreUsuario(e.getNombreUsuario());
				temp.setContrasena(e.getContrasena());
				temp.setAvatar(e.getAvatar());
				temp.setCorreoElectronico(e.getCorreoElectronico());
				temp.setTipoUSuario(e.retornarTipoUsuario());
				temp.setMiLigaPrivada(e.getMiLigaPrivada());
				temp.setMiLigaPublica(e.getMiLigaPublica());
			}	
		}
		return temp;
	}
	
	
	public static LigasPublicas retornarLigaPublica(String nombreLiga) {
		
		LigasPublicas temp = new LigasPublicas("", null, false, 0, 0, "");
		
		for(LigasPublicas e: listaLigasPublicas) {
			
			if(e.getNombreLiga().equals(nombreLiga)) {
				
				temp.setNombreLiga(e.getNombreLiga());
				temp.setFechaCreacion(e.getFechaCreacion());
				temp.setFechaCreacion(e.getFechaCreacion());
				temp.setEstado(e.getEstado());
				temp.setPuntos(e.getPuntos());
				temp.setBono(e.getBono());
				temp.setMundialAnfitrion(e.getMundialAnfitrion());
						
			}	
		}
		
		return temp;
	}
	public static ArrayList<Mundiales> retornarMundialesRegistrados(){
		
		return listaMundiales;
		
	}
	
	public static LigasPrivadas retornarLigaPrivada(String nombreLiga) {
		
		LigasPrivadas temp = new LigasPrivadas("", null, false, 0, 0, "");
		
		for(LigasPrivadas e: listaLigasPrivadas) {
			
			if(e.getNombreLiga().equals(nombreLiga)) {
				
				temp.setNombreLiga(e.getNombreLiga());
				temp.setFechaCreacion(e.getFechaCreacion());
				temp.setFechaCreacion(e.getFechaCreacion());
				temp.setEstado(e.getEstado());
				temp.setPuntos(e.getPuntos());
				temp.setBono(e.getBono());
				temp.setMundialAnfitrion(e.getMundialAnfitrion());
			}	
		}
		
		return temp;
	}
	
	public static ArrayList<Equipo> retornarEquiposRegistrados(){
		
		return listaEquiposFIFA;		
		
	}
	
	public static Mundiales retornarMundial(String nombreMundial) {
		Mundiales mundialTemp=null;
		
		for(Mundiales e: listaMundiales) {
			
			if(nombreMundial.equals(e.getNombreMundial())) {
				
				mundialTemp = new Mundiales(e.getNombreMundial(),e.getAno(),e.getPaisOrganizador(),e.getEstado());
				
			}
			
		}
		
		return mundialTemp;
		
	}
	
	
	public static Equipo retornarEquipo(String nombreEquipo) {
		Equipo equipoTemp=null;
		
		for(Equipo e: listaEquiposFIFA) {
			
			if(nombreEquipo.equals(e.getNombre())) {
				
				equipoTemp = new Equipo(e.getNombre(),e.getRanking(), e.getBandera(), e.getIso());
				
			}
			
		}
		
		return equipoTemp;
		
	}
	
	//------------------------------------------------------------------------------------------------
	
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
	
	//---------------------------------------------------------------------------------------------------------------------------------------
	
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
	
	//-------------------------------------------------------------------------------------------------------------
	
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
		
		
		public static void sortearEquipoMundial(String nombreMundial) {
			int cupoEquipos = 0;
			boolean registroEstado = false;
			Mundiales mundialTemp = CL.retornarMundial(nombreMundial);
			
			while(cupoEquipos<32) {
				registroEstado = false;
				Random aleatorio = new Random();
				int valorAleatorio = aleatorio.nextInt(listaEquiposFIFA.size());
				
				
				for(Equipo e: mundialTemp.getEquiposMundial()) {
					System.out.println(e.getNombre()+ " lectura" + listaEquiposFIFA.get(valorAleatorio).getNombre());
					
					if(e==listaEquiposFIFA.get(valorAleatorio)){
						
						registroEstado = true;
						
					}
					
				}
				
				if(registroEstado == false) {
					
					mundialTemp.getEquiposMundial().add(listaEquiposFIFA.get(valorAleatorio));
					cupoEquipos++;
				}
				
			}
			for(Mundiales e: listaMundiales) {
				
				if(e.getNombreMundial().equals(mundialTemp.getNombreMundial())) {

					listaMundiales.set(listaMundiales.indexOf(e), mundialTemp);					
				}	
			}
			
		}

}





















