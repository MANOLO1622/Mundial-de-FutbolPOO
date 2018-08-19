package multis;

import java.time.LocalDate;

import accesoDatos.Conector;
import cl.Equipo;
import cl.Mundiales;

public class MultiPartidos {
	
	
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
	
	public void crearSegundaFase(String equipo1,String equipo2,  String equipoGanador, String equipoPerdedor,
			int puntajeEquipo1, int puntajeEquipo2, int fase, String mundial) {

		String sql;
		sql = "INSERT INTO PartidosSegudaFase " + "( equipo1, equipo2, equipoGanador, equipoPerdedor, puntajeEquipo1, puntajeEquipo2, fase, mundial) "
		    + "VALUES ('"
				+ equipo1 + "', '" + equipo2 + "','" + equipoGanador + "','" + equipoPerdedor + "','" +puntajeEquipo1
				 + "','" +puntajeEquipo2 + "'," +fase + ",'" +mundial+ "');";
		try {

			Conector.getConector().ejecutarSQL(sql);
			
		} catch (Exception e) {
			
			System.out.println("Exception " + e.toString());

		}
		
	}

}
