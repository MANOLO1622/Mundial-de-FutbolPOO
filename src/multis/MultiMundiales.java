package multis;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

import accesoDatos.Conector;
import cl.*;
import rondasMundial.Resultados;

/**
 * Este metodo posee todos los componente necesarios que son mandados a la base de datos
 * con sus variables solicitadas.
 * @author DELL
 *
 */
public class MultiMundiales {
	
	
	
	/**
	 * Este es el metodo de registrar Los Mundiales, donde se ejecuta cada variable para
	 * su almacenamiento en la base de datos.
	 * @param nombreMundial
	 * @param fechaInicio
	 * @param paisOrganizador
	 * @param estado
	 * @return
	 */
	public Mundiales crear(String nombreMundial, LocalDate fechaInicio, String paisOrganizador, Boolean estado) {
		Mundiales Mundiales = null;
		String sql;
		sql = "INSERT INTO Mundiales " + "(nombreMundial, fechaInicio , paisOrganizador, estado) " + "VALUES ('"
				+ nombreMundial + "', '" + fechaInicio + "','" + paisOrganizador + "','" + estado + "');";
		try {

			Conector.getConector().ejecutarSQL(sql);

			Mundiales = new Mundiales( nombreMundial, fechaInicio, paisOrganizador, estado);
			
		} catch (Exception e) {
			
			System.out.println("Exception " + e.toString());

		}
		return Mundiales;
	}
	
	/**
	 * Este es el metodo que se ejecuta para buscar el Mundial por el nombre del mundial
	 * @param pnombreMundial
	 * @return
	 * @throws java.sql.SQLException
	 * @throws Exception
	 */
	public Mundiales buscar(String pnombreMundial) throws java.sql.SQLException, Exception {
		Mundiales Mundiales = null;
		java.sql.ResultSet rs = null;
		String sql;
		sql = "SELECT nombreMundial" + "FROM Mundiales " + "WHERE nombreMundial ='" + pnombreMundial + ";";



		/*if (rs.next()) {
			Mundiales = new Mundiales(rs.getString("nombreMundial"), rs.getString("Ano"), rs.getString("paisOrganizador"),
					rs.getBoolean("estado");
		} else {
			throw new Exception("El Mundial no está registrado.");Esta comentado porque tiene  un Bug pero hay que usarlo
		}
		rs.close();*/
		return Mundiales;
	}
	
	/**
	 * Este es el metodo de modificar el Mundial por su nombre de mundial
	 * @param pMundiales
	 * @throws java.sql.SQLException
	 * @throws Exception
	 */
	public void actualizar(Mundiales pMundiales) throws java.sql.SQLException, Exception {
		String sql;
		sql = "UPDATE Mundiales " + "SET nombreMundial='" + pMundiales.getNombreMundial() + "';";
		try {
			

		} catch (Exception e) {
			throw new Exception("El Mundial no está registrado.");
		}
	}
	
	/**
	 * Este es el metodo que borra el mundial de la base de datos
	 * @param pMundiales
	 * @throws java.sql.SQLException
	 * @throws Exception
	 */
	public void borrar(Mundiales pMundiales) throws java.sql.SQLException, Exception {
		String sql;
		sql = "DELETE FROM Mundiales " + "WHERE nombre='" + pMundiales.getNombreMundial()+ "';";
		try {
		

		} catch (Exception e) {
			throw new Exception("El Mundial tiene cuentas.");
		}
	}

	

	/*public String listarMundiales() throws java.sql.SQLException, Exception {
		String sql, lista = "";
		sql = "SELECT * FROM Mundiales";
		try {
			ResultSet rs = null;
			rs = Conector.getConector().ejecutarSQL(sql, true);
			while (rs.next()) {
				lista += "NombreMundial: " + rs.getString("nombreMundial") + ", Ano: " + rs.getString("ano") + ", PaisOrganizador: "
						+ rs.getString("paisOrganizador") + ", Estado: " + rs.getBoolean("estado");
			}
		} catch (Exception e) {
			System.out.println("ERROR NO ESTA LISTANDO " + e.toString());  Esta comentado pero hay que usarlo
		}
		return lista;
	}*/
}
