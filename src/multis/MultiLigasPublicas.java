package multis;

import java.sql.ResultSet;
import java.time.LocalDate;

import accesoDatos.Conector;
import cl.*;

/**
 * Este metodo posee todos los componente necesarios que son mandados a la base de datos
 *  con sus variables solicitadas.
 * @author DELL
 *
 */
public class MultiLigasPublicas {

	
	/**
	 * Este es el metodo de registrar del Prublicas Privada, donde se ejecuta cada variable para
	 * su almacenamiento en la base de datos.
	 * @param nombreLiga
	 * @param fechaCreacion
	 * @param estado
	 * @param puntos
	 * @param bono
	 * @param mundialAnfitrion
	 * @return
	 */
	public LigasPublicas crear(String nombreLiga, LocalDate fechaCreacion, boolean estado,int puntos, int bono, Mundiales mundialAnfitrion) {
		LigasPublicas LigasPublicas = null;
		String sql;
		sql = "INSERT INTO LigasPublicas " + "(nombreLiga, fechaCreacion, estado, tipoLiga, puntos, bono, mundialAnfitrion) "
		    + "VALUES ('"
		    +nombreLiga+"', '"+fechaCreacion+"', '"+estado+"', '"+"Publica"+"', "+puntos+", "+bono+", '"+mundialAnfitrion.getNombreMundial()+"');";
		
		try {

			Conector.getConector().ejecutarSQL(sql);

			LigasPublicas = new LigasPublicas(nombreLiga, fechaCreacion, estado, puntos, bono, mundialAnfitrion);
		} catch (Exception e) {
			
			System.out.println("Exception " + e.toString());

		}
		return LigasPublicas;
	}
	
	//-----------------------------------------------------------------------------------
	
	/**
	 * Este es el metodo que se ejecuta para buscar la Liga Publica por los puntos
	 * @param ppuntos
	 * @return
	 * @throws java.sql.SQLException
	 * @throws Exception
	 */
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
	/**
	 * Este es el metodo de modificar la Liga Publica por su nombre de Liga
	 * @param pLigasPublicas
	 * @throws java.sql.SQLException
	 * @throws Exception
	 */
	public void actualizar(LigasPublicas pLigasPublicas) throws java.sql.SQLException, Exception {
		String sql;
		sql = "UPDATE LigasPublicas " + "SET nombreLiga='" + pLigasPublicas.getNombreLiga() + "';";
		try {
			

		} catch (Exception e) {
			throw new Exception("La Liga no está registrado.");
		}
	}
	
	/**
	 * Este es el metodo que borra la Liga Publca de la base de datos
	 * @param pLigasPublicas
	 * @throws java.sql.SQLException
	 * @throws Exception
	 */
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
