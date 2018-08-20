package multis;

import java.time.LocalDate;
import java.util.ArrayList;

import accesoDatos.Conector;
import cl.*;
import rondasMundial.*;

/**
 * Este metodo posee todos los componente necesarios que son mandados a la base de datos
 * con sus variables solicitadas.
 * @author DELL
 *
 */
public class MultiUsuarios {
	
	/**
	 * Este es el metodo de registrar Los Usuarios, donde se ejecuta cada variable para
	 * su almacenamiento en la base de datos.
	 * @param nombre
	 * @param apellido
	 * @param nombreUsuario
	 * @param contrasena
	 * @param avatar
	 * @param correoElectronico
	 * @param tipoUsuario
	 * @return
	 */
	public Usuario crear(String nombre, String apellido, String nombreUsuario, String contrasena,String avatar, String correoElectronico, Perfiles tipoUsuario) {
		
		Usuario Usuario = null;
		String sql;
		LocalDate fechaRegistro = LocalDate.now();
		
		sql = "INSERT INTO Usuarios " + "(nombre, apellido,nombreUsuario, avatar, correoElectronico,FechaRegistro, contrasena , Perfiles) " + "VALUES ('"
				+ nombre + "', '" + apellido + "','" + nombreUsuario + "','" + avatar + "','" + correoElectronico + "','"
				+fechaRegistro.getYear()+"-"+fechaRegistro.getMonthValue()+"-"+fechaRegistro.getDayOfMonth()+ "','"+ contrasena + "','"+tipoUsuario+ "');";
		try {

			Conector.getConector().ejecutarSQL(sql);

			Usuario = new Usuario(nombre, apellido, nombreUsuario, avatar, correoElectronico, contrasena, cl.Usuario.retornarTipoUsuarioNumerico(tipoUsuario));
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());

		}
		return Usuario;
	}
	
	//-------------------------------------------------------------------------------------------------
	
	/**
	 * Este es el metodo que se ejecuta para buscar el Usuario por el nombre del Usuario
	 * @param pnombre
	 * @return
	 * @throws java.sql.SQLException
	 * @throws Exception
	 */
	public Usuario buscar(String nombreUsuario) throws java.sql.SQLException, Exception {
		
		Usuario Usuario = null;
		java.sql.ResultSet rs = null;
		String sql;
		
		sql = "SELECT * " + " FROM Usuarios " + " WHERE nombreUsuario = '" + nombreUsuario + "';";
		
		rs = Conector.getConector().ejecutarSQL(sql,true);
		
		if (rs.next()) {
			
			Usuario = new Usuario(rs.getString("nombre"), rs.getString("apellido"), rs.getString("nombreUsuario"),rs.getString("contrasena"),
					rs.getString("avatar"), rs.getString("correoElectronico"),
					Perfiles.retornarTipoPerfilEntero(Perfiles.retornarTipoPerfil(rs.getString("Perfiles"))));
			
		} else {
			throw new Exception("El Usuario no está registrado - buscar");
		}
		rs.close();
		return Usuario;
	}
	
	//-------------------------------------------------------------------------------------------------
	
	/**
	 * Este es el metodo de modificar el Usuario por su nombre y apellido.
	 * @param pUsuario
	 * @throws java.sql.SQLException
	 * @throws Exception
	 */
	public void ingresarLigaPublicaUsuario(String nombreUsuario, String miLigaPublica) throws java.sql.SQLException, Exception {
		
		String sql;
		
		sql = "UPDATE Usuarios SET miLigaPublica = '" + miLigaPublica + "'  WHERE nombreUsuario='"
				+ nombreUsuario + "';";
		
		try {

			Conector.getConector().ejecutarSQL(sql,true);

		} catch (Exception e) {
			System.out.println(e.getMessage() + "aqui");
		}


	}
	
	//-------------------------------------------------------------------------------------------------
	
	/**
	 * Este es el metodo de modificar el Usuario por su nombre y apellido.
	 * @param pUsuario
	 * @throws java.sql.SQLException
	 * @throws Exception
	 */
	public void ingresarLigaPrivadaUsuario(String nombreUsuario, String miLigaPrivada) throws java.sql.SQLException, Exception {
		
		String sql;
		
		sql = "UPDATE Usuarios " + " SET miLigaPrivada = '" + miLigaPrivada + "' " + " WHERE nombreUsuario='"
				+ nombreUsuario + "';";
		
		try {
			
			Conector.getConector().ejecutarSQL(sql,true);
			
		}catch(Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
	}
	
	//-------------------------------------------------------------------------------------------------
	
	
	/**
	 * Este es el metodo que borra el Usuario de la base de datos
	 * @param pUsuario
	 * @throws java.sql.SQLException
	 * @throws Exception
	 */
	public void borrar(String nombreUsuario) throws java.sql.SQLException, Exception {
		
		String sql;
		sql = "DELETE FROM Usuario " + " WHERE nombreUsuario= '" + nombreUsuario + "';";
		try {
		
			Conector.getConector().ejecutarSQL(sql,true);

		} catch (Exception e) {
			throw new Exception("El Usuario no se puede borrar.");
		}
	}

//-------------------------------------------------------------------------------------------------
	
	/**
	 * Este metodo ejecuta una lista de Usuarios y los guarda en un ArrayList 
	 * @return
	 * @throws java.sql.SQLException
	 * @throws Exception
	 */
	public  ArrayList<Usuario> retornarUsuarios() throws java.sql.SQLException,Exception{
		
		Usuario usuarioTemp=null;
		ArrayList<Usuario> listaUsuarios = new ArrayList<>();

		java.sql.ResultSet rs = null;
		String sql;
		
		sql = "SELECT * "+
		"FROM Usuarios;";
		
		rs = Conector.getConector().ejecutarSQL(sql,true);
		
		if (rs.next() == true) {
			do {
				
				usuarioTemp = new Usuario (rs.getString("nombre"), rs.getString("apellido"),rs.getString("nombreUsuario"), 
						rs.getString("contrasena"), rs.getString("avatar"),rs.getString("correoElectronico"),
						Usuario.retornarTipoUsuarioNumerico(Perfiles.retornarTipoPerfil(rs.getString("Perfiles"))));
				
				listaUsuarios.add(usuarioTemp);
				
			} while (rs.next());
			
		} else {
			
			System.out.println("No hay Usuarios registrados. aqui2");
	
		}
		
		rs.close();
		return listaUsuarios;
	}
	
	//------------------------------------------------------------------------------------------------------------------------------------
	
	public static void actualizarUsuarioEquipoLigaPublica(String nombreUsuario, String equipoLigaPublica) {
		
		String sql;
		
		sql = "UPDATE Usuarios " + " SET equipoLigaPublica = '" + equipoLigaPublica + "' " + 
		" WHERE nombreUsuario='" + nombreUsuario + "';";

		try {
			
			Conector.getConector().ejecutarSQL(sql,true);
			
		}catch(Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
	}
	
	
	//------------------------------------------------------------------------------------------------------------------------------------
	
	public static void actualizarUsuarioEquipoLigaPrivada(String nombreUsuario, String equipoLigaPrivada) {
		
		String sql;
		
		sql = "UPDATE Usuarios " + " SET equipoLigaPrivada = '" + equipoLigaPrivada + "' " + 
		" WHERE nombreUsuario='" + nombreUsuario + "';";

		try {
			
			Conector.getConector().ejecutarSQL(sql,true);
			
		}catch(Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
	}
	
	//------------------------------------------------------------------------------------------------------------------------------------
	
	public static void actualizarUsuarioValidacionPrimeraFasePublica(String nombreUsuario, int validacionPrimeraFasePublica) {
		
		String sql;
		
		sql = "UPDATE Usuarios " + " SET validacionPrimeraFasePublica = " + validacionPrimeraFasePublica + " " + 
		" WHERE nombreUsuario= '" + nombreUsuario + "';";

		try {
			
			Conector.getConector().ejecutarSQL(sql,true);
			
		}catch(Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
	}
	
	//------------------------------------------------------------------------------------------------------------------------------------
	
	public static void actualizarUsuarioValidacionPrimeraFasePrivada(String nombreUsuario, int validacionPrimeraFasePrivada) {
		
		String sql;
		
		sql = "UPDATE Usuarios " + " SET validacionPrimeraFasePrivada = " + validacionPrimeraFasePrivada + " " + 
		" WHERE nombreUsuario= '" + nombreUsuario + "';";

		try {
			
			Conector.getConector().ejecutarSQL(sql,true);
			
		}catch(Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
	}
	
	
	//------------------------------------------------------------------------------------------------------------------------------------
	
	public static void actualizarUsuarioValidacionOctavosPublica(String nombreUsuario, String validacionOctavosPublica) {
		
		String sql;
		
		sql = "UPDATE Usuarios " + " SET validacionPrimeraFasePublica = '" + validacionOctavosPublica + "' " + 
		" WHERE nombreUsuario='" + nombreUsuario + "';";

		try {
			
			Conector.getConector().ejecutarSQL(sql,true);
			
		}catch(Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
	}
	
	
	//------------------------------------------------------------------------------------------------------------------------------------
	
	public static void actualizarUsuarioValidacionOctavosPrivada(String nombreUsuario, String validacionOctavosPrivada) {
		
		String sql;
		
		sql = "UPDATE Usuarios " + " SET validacionOctavosPrivada = '" + validacionOctavosPrivada + "' " + 
		" WHERE nombreUsuario='" + nombreUsuario + "';";

		try {
			
			Conector.getConector().ejecutarSQL(sql,true);
			
		}catch(Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
	}
	
	
	//------------------------------------------------------------------------------------------------------------------------------------
	
	public static void actualizarUsuarioValidacionCuartosPublica(String nombreUsuario, String validacionCuartosPublica) {
		
		String sql;
		
		sql = "UPDATE Usuarios " + " SET validacioncuartosPublica = '" + validacionCuartosPublica + "' " + 
		" WHERE nombreUsuario='" + nombreUsuario + "';";

		try {
			
			Conector.getConector().ejecutarSQL(sql,true);
			
		}catch(Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
	}
	
	//------------------------------------------------------------------------------------------------------------------------------------
	
	public static void actualizarUsuarioValidacionCuartosPrivada(String nombreUsuario, String validacionCuartosPrivada) {
		
		String sql;
		
		sql = "UPDATE Usuarios " + " SET validacioncuartosPrivada = '" + validacionCuartosPrivada + "' " + 
		" WHERE nombreUsuario='" + nombreUsuario + "';";

		try {
			
			Conector.getConector().ejecutarSQL(sql,true);
			
		}catch(Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
	}
	
	//------------------------------------------------------------------------------------------------------------------------------------
	
	public static void actualizarUsuarioValidacionSemifinalesPublica(String nombreUsuario, String validacionSemifinalesPublica) {
		
		String sql;
		
		sql = "UPDATE Usuarios " + " SET validacionSemifinalesPublica = '" + validacionSemifinalesPublica + "' " + 
		" WHERE nombreUsuario='" + nombreUsuario + "';";

		try {
			
			Conector.getConector().ejecutarSQL(sql,true);
			
		}catch(Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
	}
	
	//------------------------------------------------------------------------------------------------------------------------------------
	
	public static void actualizarUsuarioValidacionSemifinalesPrivada(String nombreUsuario, String validacionSemifinalesPrivada) {
		
		String sql;
		
		sql = "UPDATE Usuarios " + " SET validacionSemifinalesPrivada = '" + validacionSemifinalesPrivada + "' " + 
		" WHERE nombreUsuario='" + nombreUsuario + "';";

		try {
			
			Conector.getConector().ejecutarSQL(sql,true);
			
		}catch(Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
	}
	
	//------------------------------------------------------------------------------------------------------------------------------------
	
	public static void actualizarUsuarioValidacionFinalesPublica(String nombreUsuario, String validacionFinalesPublica) {
		
		String sql;
		
		sql = "UPDATE Usuarios " + " SET validacionfinalPublica = '" + validacionFinalesPublica + "' " + 
		" WHERE nombreUsuario='" + nombreUsuario + "';";

		try {
			
			Conector.getConector().ejecutarSQL(sql,true);
			
		}catch(Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
	}
	
	//------------------------------------------------------------------------------------------------------------------------------------
	
	public static void actualizarUsuarioValidacionFinalesPrivada(String nombreUsuario, String validacionFinalesPrivada) {
		
		String sql;
		
		sql = "UPDATE Usuarios " + " SET validacionfinalPrivada = '" + validacionFinalesPrivada + "' " + 
		" WHERE nombreUsuario='" + nombreUsuario + "';";

		try {
			
			Conector.getConector().ejecutarSQL(sql,true);
			
		}catch(Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
	}
	
	
	//------------------------------------------------------------------------------------------------------------------------------------
	
	
	public static void actualizarUsuarioPrimerCuadroPublica(String nombreUsuario, String primerCuadroPublica) {
		
		String sql;
		
		sql = "UPDATE Usuarios " + " SET primerCuadroPublica = '" + primerCuadroPublica + "' " + 
		" WHERE nombreUsuario='" + nombreUsuario + "';";

		try {
			
			Conector.getConector().ejecutarSQL(sql,true);
			
		}catch(Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
	}
	
	//------------------------------------------------------------------------------------------------------------------------------------


	public static void actualizarUsuarioPrimerCuadroPrivada(String nombreUsuario, String primerCuadroPrivada) {
		
		String sql;
		
		sql = "UPDATE Usuarios " + " SET primerCuadroPrivada = '" + primerCuadroPrivada + "' " + 
		" WHERE nombreUsuario='" + nombreUsuario + "';";

		try {
			
			Conector.getConector().ejecutarSQL(sql,true);
			
		}catch(Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
	}
	
	
	//-------------------------------------------------------------------------------------------------
	
	/**
	 * Este es el metodo retorna un valor en especifico del usuario.
	 * @param pnombre
	 * @return
	 * @throws java.sql.SQLException
	 * @throws Exception
	 */
	public String buscarLigaPublica(String nombreUsuario) throws java.sql.SQLException, Exception {
		
		String nombreLiga = "";
		java.sql.ResultSet rs = null;
		String sql;
		
		sql = "SELECT miLigaPublica FROM Usuarios " + " WHERE nombreUsuario = '" + nombreUsuario + "';";

		rs = Conector.getConector().ejecutarSQL(sql,true);
		
		if (rs.next()) {
			
			nombreLiga = rs.getString("miLigaPublica");
			
		} else {
			System.out.println("El Usuario no está registrado");
		}
		rs.close();
		return nombreLiga;
	}
	
	//-------------------------------------------------------------------------------------------------
	
	/**
	 * Este es el metodo retorna un valor en especifico del usuario.
	 * @param pnombre
	 * @return
	 * @throws java.sql.SQLException
	 * @throws Exception
	 */
	public String buscarLigaPrivada(String nombreUsuario) throws java.sql.SQLException, Exception {
		
		String nombreLiga = "";
		java.sql.ResultSet rs = null;
		String sql;
		
		sql = "SELECT miLigaPrivada FROM Usuarios " + " WHERE nombreUsuario = '" + nombreUsuario + "';";

		rs = Conector.getConector().ejecutarSQL(sql,true);
		
		if (rs.next()) {
			
			nombreLiga = rs.getString("miLigaPrivada");
			
		} else {
			throw new Exception("El Usuario no está registrado");
		}
		rs.close();
		return nombreLiga;
	}
	
}
