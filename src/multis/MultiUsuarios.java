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
			
			System.out.println("Exception " + e.toString());

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
	public Usuario buscar(String pnombre) throws java.sql.SQLException, Exception {
		Usuario Usuario = null;
		java.sql.ResultSet rs = null;
		String sql;
		sql = "SELECT nombre" + "FROM Usuario " + "WHERE nombre='" + pnombre + "';";



		/*if (rs.next()) {
			Usuario = new Usuario(rs.getString("nombre"), rs.getString("apellido"), rs.getString("nombreUsuario"),
					rs.getString("avatar"), rs.getString("correoElectronico"), rs.getString("contrasena"));
		} else {
			throw new Exception("El Usuario no está registrado.");
		}*/
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
	public void actualizar(Usuario pUsuario) throws java.sql.SQLException, Exception {
		String sql;
		sql = "UPDATE Usuario " + "SET nombre='" + pUsuario.getNombre() + "' " + "WHERE apellido='"
				+ pUsuario.getApellido() + "';";
		try {
			

		} catch (Exception e) {
			throw new Exception("El Usuario no está registrado.");
		}
	}
	
	/**
	 * Este es el metodo que borra el Usuario de la base de datos
	 * @param pUsuario
	 * @throws java.sql.SQLException
	 * @throws Exception
	 */
	public void borrar(Usuario pUsuario) throws java.sql.SQLException, Exception {
		String sql;
		sql = "DELETE FROM Usuario " + "WHERE nombre='" + pUsuario.getNombre() + "';";
		try {
		

		} catch (Exception e) {
			throw new Exception("El Usuario tiene cuentas.");
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
		
		
		java.sql.ResultSet rs;
		
		String sql;
		sql = "SELECT * "+
		"FROM Usuarios;";
		
		rs = Conector.getConector().ejecutarSQL(sql,true);
		if (rs.next() == true) {
			do {

//				String nombre, String apellido, String nombreUsuario, String contrasena,String avatar, String correoElectronico, int tipoUsuario
				
				usuarioTemp = new Usuario (rs.getString("nombre"), rs.getString("apellido"),rs.getString("nombreUsuario"), rs.getString("contrasena"), 
				rs.getString("avatar"),rs.getString("correoElectronico"),
				Usuario.retornarTipoUsuarioNumerico(Perfiles.retornarTipoPerfil(rs.getString("Perfiles"))));
				
				listaUsuarios.add(usuarioTemp);
				
			} while (rs.next());
			
		} else {
			
			System.out.println("No hay Usuarios registrados.");
	
		}
		
		rs.close();
		return listaUsuarios;
	}
}
