package multis;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.ZoneId;
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
	public Mundiales buscar(String nombreMundial) throws java.sql.SQLException, Exception {
		Mundiales mundialTemp = null;
		java.sql.ResultSet rs = null;
		String sql;
		sql = "SELECT nombreMundial" + "FROM Mundiales " + "WHERE nombreMundial ='" + nombreMundial + ";";


		int agno = Integer.parseInt(rs.getString("fechaInicio").charAt(0)+""+ rs.getString("fechaInicio").charAt(1)+""
								   +rs.getString("fechaInicio").charAt(2)+""+rs.getString("fechaInicio").charAt(3));
		int mes = Integer.parseInt(rs.getString("fechaInicio").charAt(5)+""+ rs.getString("fechaInicio").charAt(6));
		int dia = Integer.parseInt(rs.getString("fechaInicio").charAt(8)+""+ rs.getString("fechaInicio").charAt(9));
				
		LocalDate fechaInicio;
				
		try {

			fechaInicio = LocalDate.of(agno, mes, dia);
			mundialTemp = new Mundiales (rs.getString("nombreMundial"), fechaInicio,
					rs.getString("paisOrganizador"), rs.getBoolean("estado"));

			Resultados resultadosTemp = null;
			resultadosTemp.setPrimerCuadro(new MultiPrimeraFase().retornarCuadroPrimeraFase(mundialTemp.getNombreMundial(), 1));


		}catch(Exception e) {

			fechaInicio = LocalDate.now();
			mundialTemp = new Mundiales (rs.getString("nombreMundial"), fechaInicio,
					rs.getString("paisOrganizador"), rs.getBoolean("estado"));
			System.out.println(e.getMessage());

		}

		return mundialTemp;
	}
	
	/**
	 * Este es el metodo de modificar el Mundial por su nombre de mundial
	 * @param pMundiales
	 * @throws java.sql.SQLException
	 * @throws Exception
	 */
	public void actualizar(Mundiales mundiales) throws java.sql.SQLException, Exception {
		String sql;
		sql = "UPDATE Mundiales " + "SET nombreMundial='" + mundiales.getNombreMundial() + "';";
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

	//-----------------------------------------------------------------------------------------------------

	public  ArrayList<Mundiales> retornarMundiales() throws java.sql.SQLException,Exception{
		
		Mundiales mundialTemp=null;
		ArrayList<Mundiales> listaMundiales = new ArrayList<>();
		
		
		java.sql.ResultSet rs;
		
		String sql;
		sql = "SELECT * "+
		"FROM Mundiales;";
		
		rs = Conector.getConector().ejecutarSQL(sql,true);
		
		if (rs.next() == true) {
			do {
				
				int agno = Integer.parseInt(rs.getString("fechaInicio").charAt(0)+""+ rs.getString("fechaInicio").charAt(1)+""
				+rs.getString("fechaInicio").charAt(2)+""+rs.getString("fechaInicio").charAt(3));
				int mes = Integer.parseInt(rs.getString("fechaInicio").charAt(5)+""+ rs.getString("fechaInicio").charAt(6));
				int dia = Integer.parseInt(rs.getString("fechaInicio").charAt(8)+""+ rs.getString("fechaInicio").charAt(9));
				
				LocalDate fechaInicio;
				
				try {

					fechaInicio = LocalDate.of(agno, mes, dia);
					mundialTemp = new Mundiales (rs.getString("nombreMundial"), fechaInicio,
							                     rs.getString("paisOrganizador"), rs.getBoolean("estado"));
					
					listaMundiales.add(mundialTemp);

				}catch(Exception e) {

					fechaInicio = LocalDate.now();
					mundialTemp = new Mundiales (rs.getString("nombreMundial"), fechaInicio,
							                     rs.getString("paisOrganizador"), rs.getBoolean("estado"));
					System.out.println(e.getMessage());

				}
				
			} while (rs.next());
			
		} else {
			
			System.out.println("No hay mundiales registrados.");
		}
		
		rs.close();
		
		return listaMundiales;
	}
	
	
}
