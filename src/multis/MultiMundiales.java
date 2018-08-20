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
		sql = "SELECT * " + "FROM Mundiales " + "WHERE nombreMundial ='" + nombreMundial + "' ;";

		rs = Conector.getConector().ejecutarSQL(sql,true);
		
		LocalDate fechaInicio;
		
		if(rs.next()) {
			
			try {
				
				int agno = Integer.parseInt(rs.getString("fechaInicio").charAt(0)+""+ rs.getString("fechaInicio").charAt(1)+""
						+rs.getString("fechaInicio").charAt(2)+""+rs.getString("fechaInicio").charAt(3));
				int mes = Integer.parseInt(rs.getString("fechaInicio").charAt(5)+""+ rs.getString("fechaInicio").charAt(6));
				int dia = Integer.parseInt(rs.getString("fechaInicio").charAt(8)+""+ rs.getString("fechaInicio").charAt(9));

				fechaInicio = LocalDate.of(agno, mes, dia);
				mundialTemp = new Mundiales (rs.getString("nombreMundial"), fechaInicio,
						rs.getString("paisOrganizador"), rs.getBoolean("estado"));

			}catch(Exception e) {

				fechaInicio = LocalDate.now();
				mundialTemp = new Mundiales (rs.getString("nombreMundial"), fechaInicio,
						rs.getString("paisOrganizador"), rs.getBoolean("estado"));
				System.out.println(e.getMessage());

			}
			
		}

		rs.close();
		
		Resultados resultadosTemp = new Resultados();
		resultadosTemp.setPrimerCuadro(new MultiPrimeraFase().retornarCuadroPrimeraFase(mundialTemp.getNombreMundial(), 1));
		resultadosTemp.setSegundoCuadro(new MultiPrimeraFase().retornarCuadroPrimeraFase(mundialTemp.getNombreMundial(), 2));
		resultadosTemp.setTercerCuadro(new MultiPrimeraFase().retornarCuadroPrimeraFase(mundialTemp.getNombreMundial(), 3));
		resultadosTemp.setCuartoCuadro(new MultiPrimeraFase().retornarCuadroPrimeraFase(mundialTemp.getNombreMundial(), 4));
		resultadosTemp.setQuintoCuadro(new MultiPrimeraFase().retornarCuadroPrimeraFase(mundialTemp.getNombreMundial(), 5));
		resultadosTemp.setSextoCuadro(new MultiPrimeraFase().retornarCuadroPrimeraFase(mundialTemp.getNombreMundial(), 6));
		resultadosTemp.setSeptimoCuadro(new MultiPrimeraFase().retornarCuadroPrimeraFase(mundialTemp.getNombreMundial(), 7));
		resultadosTemp.setOctavoCuadro(new MultiPrimeraFase().retornarCuadroPrimeraFase(mundialTemp.getNombreMundial(), 8));
		 
		resultadosTemp.setPartidosPrimerCuadro(new MultiPrimeraFase().retornarPartidosCuadroPrimeraFase(mundialTemp.getNombreMundial(), 1));
		resultadosTemp.setPartidosSegundoCuadro(new MultiPrimeraFase().retornarPartidosCuadroPrimeraFase(mundialTemp.getNombreMundial(), 2));
		resultadosTemp.setPartidosTercerCuadro(new MultiPrimeraFase().retornarPartidosCuadroPrimeraFase(mundialTemp.getNombreMundial(), 3));
		resultadosTemp.setPartidosCuartoCuadro(new MultiPrimeraFase().retornarPartidosCuadroPrimeraFase(mundialTemp.getNombreMundial(), 4));
		resultadosTemp.setPartidosQuintoCuadro(new MultiPrimeraFase().retornarPartidosCuadroPrimeraFase(mundialTemp.getNombreMundial(), 5));
		resultadosTemp.setPartidosSextoCuadro(new MultiPrimeraFase().retornarPartidosCuadroPrimeraFase(mundialTemp.getNombreMundial(), 6));
		resultadosTemp.setPartidosSeptimoCuadro(new MultiPrimeraFase().retornarPartidosCuadroPrimeraFase(mundialTemp.getNombreMundial(), 7));
		resultadosTemp.setPartidosOctavoCuadro(new MultiPrimeraFase().retornarPartidosCuadroPrimeraFase(mundialTemp.getNombreMundial(), 8));
		 
		resultadosTemp.setGanadoresPrimerCuadro(new MultiPrimeraFase().retornarGanadoresCuadroPrimeraFase(mundialTemp.getNombreMundial(), 1));
		resultadosTemp.setGanadoresSegundoCuadro(new MultiPrimeraFase().retornarGanadoresCuadroPrimeraFase(mundialTemp.getNombreMundial(), 2));
		resultadosTemp.setGanadoresTercerCuadro(new MultiPrimeraFase().retornarGanadoresCuadroPrimeraFase(mundialTemp.getNombreMundial(), 3));
		resultadosTemp.setGanadoresCuartoCuadro(new MultiPrimeraFase().retornarGanadoresCuadroPrimeraFase(mundialTemp.getNombreMundial(), 4));
		resultadosTemp.setGanadoresQuintoCuadro(new MultiPrimeraFase().retornarGanadoresCuadroPrimeraFase(mundialTemp.getNombreMundial(), 5));
		resultadosTemp.setGanadoresSextoCuadro(new MultiPrimeraFase().retornarGanadoresCuadroPrimeraFase(mundialTemp.getNombreMundial(), 6));
		resultadosTemp.setGanadoresSeptimoCuadro(new MultiPrimeraFase().retornarGanadoresCuadroPrimeraFase(mundialTemp.getNombreMundial(), 7));
		resultadosTemp.setGanadoresOctavoCuadro(new MultiPrimeraFase().retornarGanadoresCuadroPrimeraFase(mundialTemp.getNombreMundial(), 8));
		
		resultadosTemp.setPartidosOctavosFinal(new MultiSegundaFase().retornarPartidosOctavos(mundialTemp.getNombreMundial()));
		resultadosTemp.setPartidosCuartosFinal(new MultiSegundaFase().retornarPartidosCuartos(mundialTemp.getNombreMundial()));
		resultadosTemp.setPartidosSemiFinal(new MultiSegundaFase().retornarPartidosFinales(mundialTemp.getNombreMundial(), 2));
		resultadosTemp.setJuegosFinales(new MultiSegundaFase().retornarPartidosFinales(mundialTemp.getNombreMundial(), 2));
		 
		resultadosTemp.setGanadoresPrimeraFase(new MultiPrimeraFase().retornarGanadoresPrimeraFase(mundialTemp.getNombreMundial()));
		resultadosTemp.setGanadoresOctavosFinal(new MultiSegundaFase().retornarGanadoresOctavosFinal(mundialTemp.getNombreMundial()));
		resultadosTemp.setGanadoresCuartosFinal(new MultiSegundaFase().retornarGanadoresCuartosFinal(mundialTemp.getNombreMundial()));
		
		mundialTemp.guardarEquipos(resultadosTemp.getPrimerCuadro(), resultadosTemp.getSegundoCuadro(), resultadosTemp.getTercerCuadro(),
				resultadosTemp.getCuartoCuadro(), resultadosTemp.getQuintoCuadro(), resultadosTemp.getSextoCuadro(), 
				resultadosTemp.getSeptimoCuadro(), resultadosTemp.getOctavoCuadro());
		 
		mundialTemp.setResultadosMundial(resultadosTemp);
		
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
