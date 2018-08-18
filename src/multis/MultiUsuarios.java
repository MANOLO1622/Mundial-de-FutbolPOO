package multis;

import java.time.LocalDate;
import java.util.ArrayList;

import accesoDatos.Conector;
import cl.*;
import rondasMundial.*;

public class MultiUsuarios {
	
	
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

	public void actualizar(Usuario pUsuario) throws java.sql.SQLException, Exception {
		String sql;
		sql = "UPDATE Usuario " + "SET nombre='" + pUsuario.getNombre() + "' " + "WHERE apellido='"
				+ pUsuario.getApellido() + "';";
		try {
			

		} catch (Exception e) {
			throw new Exception("El Usuario no está registrado.");
		}
	}

	public void borrar(Usuario pUsuario) throws java.sql.SQLException, Exception {
		String sql;
		sql = "DELETE FROM Usuario " + "WHERE nombre='" + pUsuario.getNombre() + "';";
		try {
		

		} catch (Exception e) {
			throw new Exception("El Usuario tiene cuentas.");
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
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
