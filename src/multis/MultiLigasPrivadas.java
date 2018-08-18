package multis;

import java.sql.ResultSet;
import java.time.LocalDate;

import accesoDatos.Conector;
import cl.*;

public class MultiLigasPrivadas {


	public LigasPrivadas crear(String nombreLiga, LocalDate fechaCreacion, boolean estado,int puntos, int bono, Mundiales mundialAnfitrion) {
		
		LigasPrivadas LigaPrivada = null;
		
		String sql;
		sql = "INSERT INTO LigasPrivadas " + "(nombreLiga, fechaCreacion, estado, tipoLiga, puntos, bono, mundialAnfitrion) "
		    + "VALUES ('"
		    +nombreLiga+"', '"+fechaCreacion+"', '"+estado+"', '"+"Privada"+"', "+puntos+", "+bono+", '"+mundialAnfitrion.getNombreMundial()+"');";
		
		try {

			Conector.getConector().ejecutarSQL(sql);

			LigaPrivada = new LigasPrivadas(nombreLiga, fechaCreacion, estado, puntos, bono, mundialAnfitrion);
			
		} catch (Exception e) {
			
			System.out.println("Exception " + e.toString());

		}
		return LigaPrivada;
	}
	
	//----------------------------------------------------------------------------------------

	public LigasPrivadas buscar(int ppuntos) throws java.sql.SQLException, Exception {
		LigasPrivadas LigasPrivadas = null;
		java.sql.ResultSet rs = null;
		String sql;
		sql = "SELECT puntos" + "FROM LigasPrivadas " + "WHERE puntos='" + ppuntos+ ";";



		/*if (rs.next()) {
			LigasPrivadas = new LigasPrivadas(rs.getInt(0), rs.getInt(1));
		} else {
			throw new Exception("La Liga no está registrado.");Esta comentado porque tiene  un Bug pero hay que usarlo
		}*/
		rs.close();
		return LigasPrivadas;
	}

	public void actualizar(LigasPrivadas pLigasPrivadas) throws java.sql.SQLException, Exception {
		String sql;
		sql = "UPDATE LigasPrivadas " + "SET nombreLiga='" + pLigasPrivadas.getNombreLiga() + "';";
		try {
			

		} catch (Exception e) {
			throw new Exception("La Liga no está registrado.");
		}
	}

	public void borrar(LigasPrivadas pLigasPrivadas) throws java.sql.SQLException, Exception {
		String sql;
		sql = "DELETE FROM LigasPrivadas " + "WHERE nombreLiga='" + pLigasPrivadas.getNombreLiga() + "';";
		try {
		

		} catch (Exception e) {
			throw new Exception("La Liga tiene cuentas.");
		}
	}

	/*public String listarLigasPrivadas() throws java.sql.SQLException, Exception {
		String sql, lista = "";
		sql = "SELECT * FROM LigasPrivadas";
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