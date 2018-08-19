package multis;

import accesoDatos.Conector;

public class MultiPrimeraFase {
	
	public void crear(String nombre, int cuadro, String mundial) {
		
		String sql;
		
		sql = "INSERT INTO CuadrosPrimeraFase " + "(nombre, cuadro, mundial) " + "VALUES ('"
				+ nombre + "','" + cuadro + "','" + mundial + "');";
		try {

			Conector.getConector().ejecutarSQL(sql);
			
		} catch (Exception e) {
			
			System.out.println("Exception " + e.toString());

		}
		
	}

}
