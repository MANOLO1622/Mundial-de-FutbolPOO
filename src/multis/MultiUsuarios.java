package multis;

import cl.*;

public class MultiUsuarios {

	public Usuario crear(String pnombre, String papellido, String pnombreUsuario, String pavatar, String pcorreoElectronico,
			String pcontrasena) {
		Usuario Usuario = null;
		String sql;
		sql = "INSERT INTO Usuario " + "(nombre, apellido,nombreUsuario, avatar, correoElectronico, contrasena ) " + "VALUES ('"
				+ pnombre + "', '" + papellido + "','" + pnombreUsuario + "','" + pavatar + "','" + pcorreoElectronico + "','"
				+ pcontrasena + "');";
		try {

			//Conector.getConector().ejecutarSQL(sql);

			//Usuario = new Usuario(pnombre, papellido, pnombreUsuario, pavatar, pcorreoElectronico, pcontrasena); Esta comentado porque tiene  un Bug pero hay que usarlo
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
					rs.getString("avatar"), rs.getString("correoElectronico"), rs.getString("contrasena"));Esta comentado porque tiene  un Bug pero hay que usarlo
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

	/*public String listarUsuario() throws java.sql.SQLException, Exception {
		String sql, lista = "";
		sql = "SELECT * FROM Usuario";
		try {
			ResultSet rs = null;
			rs = Conector.getConector().ejecutarSQL(sql, true);
			while (rs.next()) {
				lista += "Nombre: " + rs.getString("nombre") + ", Apellido: " + rs.getString("apellido") + ", NombreUsuario: "
						+ rs.getString("nombreUsuario") + ", Avatar: " + rs.getString("avatar") + ", CorreoElectronico: "
						+ rs.getString("correoElectronico") + ", Contrasena: " + rs.getString("contrasena");
			}
		} catch (Exception e) {
			System.out.println("ERROR NO ESTA LISTANDO " + e.toString());
		}
		return lista;
	}*/
}
