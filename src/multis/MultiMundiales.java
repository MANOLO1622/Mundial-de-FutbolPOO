package multis;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;

import accesoDatos.Conector;
import cl.*;
import rondasMundial.Resultados;

public class MultiMundiales {
	
	
	
	
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

	public void actualizar(Mundiales Mundiales) throws java.sql.SQLException, Exception {
		String sql;
		sql = "UPDATE Mundiales " + "SET nombreMundial='" + Mundiales.getNombreMundial() + "';";
		try {
			

		} catch (Exception e) {
			throw new Exception("El Mundial no está registrado.");
		}
	}

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
				
				System.out.println(agno+"-"+mes+"-"+dia);
				System.out.println(rs.getString("fechaInicio"));
				
				LocalDate fechaInicio;
				
				try {
					
					fechaInicio = LocalDate.of(agno, mes, dia);
					
				}catch(Exception e) {
					
					fechaInicio = LocalDate.now();
					System.out.println(e.getMessage());
					
				}
				
				
				mundialTemp = new Mundiales (rs.getString("nombreMundial"), fechaInicio,
					                         rs.getString("paisOrganizador"), rs.getBoolean("estado"));
				    
				listaMundiales.add(mundialTemp);
				
			} while (rs.next());
			
		} else {
			
			System.out.println("No hay mundiales registrados.");
	
		}
		
		rs.close();
		
		return listaMundiales;
	}
	
	
}
