package multis;

import java.sql.ResultSet;

import accesoDatos.Conector;
import cl.*;

public class MultiEquipos {

	
	
	
	public Equipo crear(String nombre, int ranking, String bandera, ISOPaises iso) {
		Equipo Equipo = null;
		String sql;
		sql = "INSERT INTO Equipos " + "( nombre, ranking, bandera, iso) " + "VALUES ('"
				+ nombre + "', " + ranking + ",'" + bandera + "','" + iso + "');";
		try {

			Conector.getConector().ejecutarSQL(sql);

			Equipo = new Equipo(nombre, ranking, bandera, iso);
		} catch (Exception e) {
			System.out.println("Exception " + e.toString());

		}
		return Equipo;
	}

	public Equipo buscar(String pnombre) throws java.sql.SQLException, Exception {
		Equipo Equipo = null;
		java.sql.ResultSet rs = null;
		String sql;
		sql = "SELECT nombre" + "FROM Equipo " + "WHERE nombre='" + pnombre + ";";



		/*if (rs.next()) {
			Equipo = new Equipo(rs.getString("isoPaises"), rs.getString("Nombre"), rs.getInt(0),
					rs.getString("bandera"));
		} else {
			throw new Exception("El Equipo no est� registrado.");Esta comentado porque tiene  un Bug pero hay que usarlo
		}*/
		rs.close();
		return Equipo;
	}

	public void actualizar(Equipo pEquipo) throws java.sql.SQLException, Exception {
		String sql;
		sql = "UPDATE Equipo " + "SET nombre='" + pEquipo.getNombre() + "';";
		try {
			

		} catch (Exception e) {
			throw new Exception("El Equipo no est� registrado.");
		}
	}

	public void borrar(Equipo pEquipo) throws java.sql.SQLException, Exception {
		String sql;
		sql = "DELETE FROM Equipo " + "WHERE nombre='" + pEquipo.getNombre() + "';";
		try {
		

		} catch (Exception e) {
			throw new Exception("El Equipo tiene cuentas.");
		}
	}

	/*public String listarEquipo() throws java.sql.SQLException, Exception {
		String sql, lista = "";
		sql = "SELECT * FROM Equipo";
		try {
			ResultSet rs = null;
			rs = Conector.getConector().ejecutarSQL(sql, true);
			while (rs.next()) {
				lista += "IsoPaises: " + rs.getString("isoPaises") + ", Nombre: " + rs.getString("nombre") + ", Ranking: "
						+ rs.getInt(0) + ", Bandera: " + rs.getString("bandera");
			}
		} catch (Exception e) {
			System.out.println("ERROR NO ESTA LISTANDO " + e.toString());  Esta comentado pero hay que usarlo
		}
		return lista;
	}*/
}
