package multis;

import java.sql.ResultSet;
import cl.*;

public class MultiLigasPublicas {


	public LigasPublicas crear(int ppuntos, int pbono) {
		LigasPublicas LigasPublicas = null;
		String sql;
		sql = "INSERT INTO LigasPublicas " + "(puntos, bono) " + "VALUES ('"
				+ ppuntos + "', '" + pbono + "');";
		try {

			//Conector.getConector().ejecutarSQL(sql);

			//LigasPublicas = new LigasPublicas(ppuntos, pbono); Esta comentado porque tiene  un Bug pero hay que usarlo
		} catch (Exception e) {
			System.out.println("Exception " + e.toString());

		}
		return LigasPublicas;
	}

	public LigasPublicas buscar(int ppuntos) throws java.sql.SQLException, Exception {
		LigasPublicas LigasPublicas = null;
		java.sql.ResultSet rs = null;
		String sql;
		sql = "SELECT puntos" + "FROM LigasPublicas " + "WHERE puntos='" + ppuntos+ ";";



		/*if (rs.next()) {
			LigasPublicas = new LigasPublicas(rs.getInt(0), rs.getInt(1));
		} else {
			throw new Exception("La Liga no está registrado.");Esta comentado porque tiene  un Bug pero hay que usarlo
		}*/
		rs.close();
		return LigasPublicas;
	}

	public void actualizar(LigasPublicas pLigasPublicas) throws java.sql.SQLException, Exception {
		String sql;
		sql = "UPDATE LigasPublicas " + "SET nombreLiga='" + pLigasPublicas.getNombreLiga() + "';";
		try {
			

		} catch (Exception e) {
			throw new Exception("La Liga no está registrado.");
		}
	}

	public void borrar(LigasPublicas pLigasPublicas) throws java.sql.SQLException, Exception {
		String sql;
		sql = "DELETE FROM LigasPublicas " + "WHERE nombreLiga='" + pLigasPublicas.getNombreLiga() + "';";
		try {
		

		} catch (Exception e) {
			throw new Exception("La Liga tiene cuentas.");
		}
	}

	/*public String listarLigasPublicas() throws java.sql.SQLException, Exception {
		String sql, lista = "";
		sql = "SELECT * FROM LigasPublicas";
		try {
			ResultSet rs = null;
			rs = Conector.getConector().ejecutarSQL(sql, true);
			while (rs.next()) {
				lista += "Puntos: " + rs.getInt(0)+ ", Bono: " + rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("ERROR NO ESTA LISTANDO " + e.toString());  Esta comentado pero hay que usarlo
		}
		return lista;
	}*/
}
