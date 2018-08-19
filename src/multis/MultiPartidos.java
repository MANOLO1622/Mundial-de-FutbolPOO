package multis;

import java.time.LocalDate;

import accesoDatos.Conector;
import cl.Equipo;
import cl.Mundiales;

public class MultiPartidos {
	
	
	/*
	 * 
	private Equipo equipo1;
	private Equipo equipo2;
	private Equipo equipoGanador;
	private Equipo equipoPerdedor;
	private int puntajeEquipo1;
	private int puntajeEquipo2;
	 * 
	 */
	
	public void crearPrimeraFase(String equipo1,String equipo2,  String equipoGanador, String equipoPerdedor,
			int puntajeEquipo1, int puntajeEquipo2, int cuadro, String mundial) {

		String sql;
		sql = "INSERT INTO PartidosPrimeraFase " + "( equipo1, equipo2, equipoGanador, equipoPerdedor, puntajeEquipo1, puntajeEquipo2, cuadro, mundial) "
		    + "VALUES ('"
				+ equipo1 + "', '" + equipo2 + "','" + equipoGanador + "','" + equipoPerdedor + "','" +puntajeEquipo1
				 + "','" +puntajeEquipo2 + "'," +cuadro + ",'" +mundial+ "');";
		try {

			Conector.getConector().ejecutarSQL(sql);
			
		} catch (Exception e) {
			
			System.out.println("Exception " + e.toString());

		}

	}

}
