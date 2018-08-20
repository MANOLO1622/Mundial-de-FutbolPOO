package multis;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

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
	public LigasPublicas buscar(String nombreLiga) throws java.sql.SQLException, Exception {

		String mundial="";
		
		LigasPublicas LigaPublica = null;
		java.sql.ResultSet rs = null;
		String sql;
		
		sql = "SELECT * FROM LigasPublicas " + " WHERE nombreLiga= '" + nombreLiga+ "' ;";

		rs = Conector.getConector().ejecutarSQL(sql,true);
		if (rs.next() == true) {

				int agno = Integer.parseInt(rs.getString("fechaCreacion").charAt(0) +""+ rs.getString("fechaCreacion").charAt(1) +""+ 
						rs.getString("fechaCreacion").charAt(2) +""+ rs.getString("fechaCreacion").charAt(3));
				int mes = Integer.parseInt(rs.getString("fechaCreacion").charAt(5) +""+ rs.getString("fechaCreacion").charAt(6));
				int dia = Integer.parseInt(rs.getString("fechaCreacion").charAt(8) +""+ rs.getString("fechaCreacion").charAt(9));

				LocalDate fecha = LocalDate.of(agno, mes, dia);

				LigaPublica = new LigasPublicas (rs.getString("nombreLiga"),fecha, rs.getBoolean("estado"), rs.getInt("puntos"), 
						rs.getInt("bono"), null);

				mundial = rs.getString("mundialAnfitrion");

		} else {

			System.out.println("No hay ligas publicas registradas.");

		}
		
		
		rs.close();
		LigaPublica.setMundialAnfitrion(new MultiMundiales().buscar(mundial));

		return LigaPublica;
	}
	
	/**
	 * Este es el metodo que borra la Liga Publca de la base de datos
	 * @param pLigasPublicas
	 * @throws java.sql.SQLException
	 * @throws Exception
	 */
	public void borrar(String nombreLiga) throws java.sql.SQLException, Exception {
		
		String sql;
		sql = "DELETE FROM LigasPublicas " + "WHERE nombreLiga='" + nombreLiga + "';";
		
		try {
		
			Conector.getConector().ejecutarSQL(sql,true);

		} catch (Exception e) {
			System.out.println("No se ha podido eliminar la liga privada.");
		}
	}
	/**
	 * Este metodo ejecuta una lista de equipos y los guarda en un ArrayList 
	 * @return
	 * @throws java.sql.SQLException
	 * @throws Exception
	 */
	public  ArrayList<LigasPublicas> retornarLigasPublicas() throws java.sql.SQLException,Exception{
		
		LigasPublicas ligaPublicaTemp=null;
		ArrayList<LigasPublicas> listaLigas = new ArrayList<>();
		ArrayList<String> listaMundiales = new ArrayList<>();
		
		
		java.sql.ResultSet rs;
		
		String sql;
		sql = "SELECT * "+
		"FROM LigasPublicas ;";
		
		rs = Conector.getConector().ejecutarSQL(sql,true);
		if (rs.next() == true) {
			do {

				int agno = Integer.parseInt(rs.getString("fechaCreacion").charAt(0) +""+ rs.getString("fechaCreacion").charAt(1) +""+ 
				                            rs.getString("fechaCreacion").charAt(2) +""+ rs.getString("fechaCreacion").charAt(3));
				int mes = Integer.parseInt(rs.getString("fechaCreacion").charAt(5) +""+ rs.getString("fechaCreacion").charAt(6));
				int dia = Integer.parseInt(rs.getString("fechaCreacion").charAt(8) +""+ rs.getString("fechaCreacion").charAt(9));
				
				LocalDate fecha = LocalDate.of(agno, mes, dia);
				

				ligaPublicaTemp = new LigasPublicas (rs.getString("nombreLiga"),fecha, rs.getBoolean("estado"), rs.getInt("puntos"), 
						rs.getInt("bono"), null);
				
				listaLigas.add(ligaPublicaTemp);
				listaMundiales.add(rs.getString("mundialAnfitrion"));
				
			} while (rs.next());
			
		} else {
			
			System.out.println("No hay Usuarios registrados.");
	
		}
		
		rs.close();
		
		int index = 0;
		
		for(LigasPublicas e: listaLigas) {
			
			index = listaLigas.indexOf(e);
			
			e.setMundialAnfitrion(new MultiMundiales().buscar(listaMundiales.get(listaLigas.indexOf(e))));
			listaLigas.set(index, e);
			 
		}
		
		return listaLigas;
	}
	
	//-------------------------------------------------------------------------------------------------
	
	/**
	 * Este es el metodo retorna un valor en especifico del usuario.
	 * @param pnombre
	 * @return
	 * @throws java.sql.SQLException
	 * @throws Exception
	 */
	public String buscarMundialPublicas(String nombreLiga) throws java.sql.SQLException, Exception {
		
		String nombreMundial = "";
		java.sql.ResultSet rs = null;
		String sql;
		
		sql = "SELECT mundial FROM LigasPublicas " + " WHERE nombreLiga = '" + nombreLiga + "';";

		rs = Conector.getConector().ejecutarSQL(sql,true);
		
		if (rs.next()) {
			
			nombreMundial = rs.getString("mundial");
			
		} else {
			throw new Exception("El Usuario no está registrado");
		}
		rs.close();
		return nombreMundial;
	}
}
