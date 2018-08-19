package multis;

import java.sql.ResultSet;
import java.util.ArrayList;

import accesoDatos.Conector;
import cl.*;

/**
 * Este metodo posee todos los componente necesarios que son mandados a la base de datos
 * con sus variables solicitadas.
 * @author DELL
 *
 */
public class MultiEquipos {

	
	
	/**
	 * Este es el metodo de registrar del equipo, donde se ejecuta cada variable para
	 * su almacenamiento en la base de datos.
	 * @param nombre
	 * @param ranking
	 * @param bandera
	 * @param iso
	 * @return
	 */
	public Equipo crearEquipoRegistro(String nombre, int ranking, String bandera, ISOPaises iso) {
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
	
	
	public void registrarEquipoGanadorPrimeraFase(String nombre, String mundial, int cuadro) {

		String sql;
		sql = "INSERT INTO GanadoresPrimeraFase " + "( nombre, mundial, cuadro) "
		    + "VALUES ('"
				+ nombre + "', '" + mundial + "', " + cuadro + ");";
		try {

			Conector.getConector().ejecutarSQL(sql);

			
		} catch (Exception e) {
			System.out.println("Exception " + e.toString());

		}

	}
	
	
	public void registrarEquipoGanadorSegundaFase(String nombre, String mundial, int fase) {

		String sql;
		sql = "INSERT INTO GanadoresSegundaFase " + "( nombre, mundial, fase) "
		    + "VALUES ('"
				+ nombre + "', '" + mundial + "', " + fase+ ");";
		try {

			Conector.getConector().ejecutarSQL(sql);

			
		} catch (Exception e) {
			System.out.println("Exception " + e.toString());

		}

	}
	
	
	/**
	 * Este es el metodo que se ejecuta para buscar el equipo por el nombre
	 * @param nombre
	 * @return
	 * @throws java.sql.SQLException
	 * @throws Exception
	 */
	public Equipo buscar(String nombre) throws java.sql.SQLException, Exception {
		
		Equipo equipo = null;
		java.sql.ResultSet rs = null;
		String sql;
		
		sql = "SELECT * " + " FROM Equipos " + " WHERE nombre= '" + nombre + "' ;";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		
		if (rs.next()) {
			
			equipo = new Equipo(rs.getString("nombre"), rs.getInt("ranking"), rs.getString("bandera"), ISOPaises.retornarISOPais(rs.getString("iso")));
			
		} else {
			System.out.println(" El Equipo no está registrado.");
		}
		rs.close();
		return equipo;
	}

	/**
	 * Este es el metodo de modificar un equipo por su nombre
	 * @param pEquipo
	 * @throws java.sql.SQLException
	 * @throws Exception
	 */
	public void actualizar(Equipo pEquipo) throws java.sql.SQLException, Exception {
		String sql;
		sql = "UPDATE Equipo " + "SET nombre='" + pEquipo.getNombre() + "';";
		try {
			

		} catch (Exception e) {
			throw new Exception("El Equipo no está registrado.");
		}
	}
	
	/**
	 * Este es el metodo que borra los equipos de la base de datos
	 * @param pEquipo
	 * @throws java.sql.SQLException
	 * @throws Exception
	 */
	public void borrar(Equipo pEquipo) throws java.sql.SQLException, Exception {
		String sql;
		sql = "DELETE FROM Equipo " + "WHERE nombre='" + pEquipo.getNombre() + "';";
		try {
		

		} catch (Exception e) {
			throw new Exception("El Equipo tiene cuentas.");
		}
	}
	
	//-----------------------------------------------------------------------------------------------------

	/**
	 * Este metodo ejecuta una lista de equipos y los guarda en un ArrayList 
	 * @return
	 * @throws java.sql.SQLException
	 * @throws Exception
	 */
	public  ArrayList<Equipo> retornarEquipos() throws java.sql.SQLException,Exception{
		
		Equipo equipoTemp=null;
		ArrayList<Equipo> listaEquipos = new ArrayList<>();
		
		
		java.sql.ResultSet rs;
		
		String sql;
		sql = "SELECT * "+
		"FROM Equipos;";
		
		rs = Conector.getConector().ejecutarSQL(sql,true);
		if (rs.next() == true) {
			do {
				
				equipoTemp = new Equipo (rs.getString("nombre"), rs.getInt("ranking"), rs.getString("bandera"), ISOPaises.retornarISOPais(rs.getString("iso")));
				
				listaEquipos.add(equipoTemp);
				
			} while (rs.next());
			
		} else {
			
			System.out.println("No hay Usuarios registrados.");
	
		}
		
		rs.close();
		return listaEquipos;
	}
}
