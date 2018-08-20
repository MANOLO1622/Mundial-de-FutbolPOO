package multis;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

import accesoDatos.Conector;
import cl.*;

/**
 * Este metodo posee todos los componente necesarios que son mandados a la base de datos
 * con sus variables solicitadas.
 * @author DELL
 *
 */
public class MultiLigasPrivadas {

	/**
	 * Este es el metodo de registrar del Ligas Privada, donde se ejecuta cada variable para
	 * su almacenamiento en la base de datos.
	 * @param nombreLiga
	 * @param fechaCreacion
	 * @param estado
	 * @param puntos
	 * @param bono
	 * @param mundialAnfitrion
	 * @return
	 */
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
	
	/**
	 * Este es el metodo que se ejecuta para buscar la Liga Privada por los nombre
	 * @param ppuntos
	 * @return
	 * @throws java.sql.SQLException
	 * @throws Exception
	 */
	public LigasPrivadas buscar(String nombreLiga) throws java.sql.SQLException, Exception {
		
		LigasPrivadas LigaPrivada = null;
		java.sql.ResultSet rs = null;
		String sql;
		
		sql = "SELECT * " + "FROM LigasPrivadas " + "WHERE nombreLiga= '" + nombreLiga+ "' ;";

		rs = Conector.getConector().ejecutarSQL(sql,true);
		if (rs.next() == true) {

				int agno = Integer.parseInt(rs.getString("fechaCreacion").charAt(0) +"-"+ rs.getString("fechaCreacion").charAt(1) +"-"+ 
						rs.getString("fechaCreacion").charAt(2) +"-"+ rs.getString("fechaCreacion").charAt(3));
				int mes = Integer.parseInt(rs.getString("fechaCreacion").charAt(5) +"-"+ rs.getString("fechaCreacion").charAt(6));
				int dia = Integer.parseInt(rs.getString("fechaCreacion").charAt(8) +"-"+ rs.getString("fechaCreacion").charAt(9));

				LocalDate fecha = LocalDate.of(agno, mes, dia);

				LigaPrivada = new LigasPrivadas (rs.getString(""),fecha, rs.getBoolean("estado"), rs.getInt("puntos"), 
						rs.getInt("bono"), null);


		} else {

			System.out.println("No hay Usuarios registrados.");

		}
		
		
		rs.close();
		return LigaPrivada;
	}
	
	/**
	 * Este es el metodo de modificar la Liga Privada por su nombre de Liga
	 * @param pLigasPrivadas
	 * @throws java.sql.SQLException
	 * @throws Exception
	 */
	public void actualizar(LigasPrivadas pLigasPrivadas) throws java.sql.SQLException, Exception {
		String sql;
		sql = "UPDATE LigasPrivadas " + "SET nombreLiga='" + pLigasPrivadas.getNombreLiga() + "';";
		try {
			

		} catch (Exception e) {
			throw new Exception("La Liga no está registrado.");
		}
	}
	
	/**
	 * Este es el metodo que borra la Liga Privada de la base de datos
	 * @param pLigasPrivadas
	 * @throws java.sql.SQLException
	 * @throws Exception
	 */
	public void borrar(String nombreLiga) throws java.sql.SQLException, Exception {
		
		String sql;
		sql = "DELETE FROM LigasPrivadas " + "WHERE nombreLiga='" + nombreLiga + "';";
		
		try {
		
			Conector.getConector().ejecutarSQL(sql,true);

		} catch (Exception e) {
			System.out.println("No se ha podido eliminar la liga privada.");
		}
	}

	//-----------------------------------------------------------------------------------------------------

	/**
	 * Este metodo ejecuta una lista de equipos y los guarda en un ArrayList 
	 * @return
	 * @throws java.sql.SQLException
	 * @throws Exception
	 */
	public  ArrayList<LigasPrivadas> retornarLigasPrivadas() throws java.sql.SQLException,Exception{
		
		LigasPrivadas ligaPrivadaTemp=null;
		ArrayList<LigasPrivadas> listaLigas = new ArrayList<>();
		ArrayList<String> listaMundiales = new ArrayList<>();
		
		
		java.sql.ResultSet rs;
		
		String sql;
		sql = "SELECT * "+
		"FROM LigasPrivadas ;";
		
		rs = Conector.getConector().ejecutarSQL(sql,true);
		if (rs.next() == true) {
			do {

				int agno = Integer.parseInt(rs.getString("fechaCreacion").charAt(0) +""+ rs.getString("fechaCreacion").charAt(1) +""+ 
				                            rs.getString("fechaCreacion").charAt(2) +""+ rs.getString("fechaCreacion").charAt(3));
				int mes = Integer.parseInt(rs.getString("fechaCreacion").charAt(5) +""+ rs.getString("fechaCreacion").charAt(6));
				int dia = Integer.parseInt(rs.getString("fechaCreacion").charAt(8) +""+ rs.getString("fechaCreacion").charAt(9));
				
				LocalDate fecha = LocalDate.of(agno, mes, dia);
				

				ligaPrivadaTemp = new LigasPrivadas (rs.getString("nombreLiga"),fecha, rs.getBoolean("estado"), rs.getInt("puntos"), 
						rs.getInt("bono"), null);
				
				listaLigas.add(ligaPrivadaTemp);
				listaMundiales.add(rs.getString("mundialAnfitrion"));
				
			} while (rs.next());
			
		} else {
			
			System.out.println("No hay Usuarios registrados.");
	
		}
		
		rs.close();
		
		for(LigasPrivadas e: listaLigas) {
			
			e.setMundialAnfitrion(new MultiMundiales().buscar(listaMundiales.get(listaLigas.indexOf(e))));;
			
		}
		
		
		return listaLigas;
	}
}