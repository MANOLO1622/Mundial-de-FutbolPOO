package multis;

import java.sql.SQLException;
import java.util.ArrayList;

import accesoDatos.Conector;
import cl.Equipo;
import rondasMundial.Partido;

public class MultiSegundaFase {

	
	//----------------------------------------------------------------------------------------------------
	
	public Partido[] retornarPartidosOctavos(String mundial) throws SQLException, Exception {

		Partido[] arregloTemp = new Partido[8];
		
		ArrayList<String> listaEquipos1 = new ArrayList<>();
		ArrayList<String> listaEquipos2 = new ArrayList<>();
		ArrayList<String> listaEquiposGanadores = new ArrayList<>();
		ArrayList<String> listaEquiposPerdedores = new ArrayList<>();
		ArrayList<String> listaPuntajesEquipos1 = new ArrayList<>();
		ArrayList<String> listaPuntajesEquipos2 = new ArrayList<>();
		
		ArrayList<Partido> listaPartidos = new ArrayList<>();
		
		java.sql.ResultSet rs = null;
		String sql;

		sql = "SELECT * FROM PartidosSegudaFase " + "WHERE mundial = '" + mundial + "' AND fase = "+ 8 + ";";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		
		if (rs.next() == true) {
			do {

				try {

					listaEquipos1.add(rs.getString("equipo1"));
					listaEquipos2.add(rs.getString("equipo2"));
					listaEquiposGanadores.add(rs.getString("equipoGanador"));
					listaEquiposPerdedores.add(rs.getString("equipoPerdedor"));
					listaPuntajesEquipos1.add(rs.getString("puntajeEquipo1"));
					listaPuntajesEquipos2.add(rs.getString("puntajeEquipo2"));

				}catch(Exception e) {

					System.out.println(e.getMessage());

				}

			} while (rs.next());

		}
		rs.close();
		
		for(int i=0; i<8; i++) {
			
			Partido partidoTemp = new Partido(new MultiEquipos().buscar(listaEquipos1.get(i)), new MultiEquipos().buscar(listaEquipos2.get(i)));
			partidoTemp.setEquipoGanador(new MultiEquipos().buscar(listaEquiposGanadores.get(i)));
			partidoTemp.setEquipoPerdedor(new MultiEquipos().buscar(listaEquiposPerdedores.get(i)));
			partidoTemp.setPuntajeEquipo1(Integer.parseInt(listaPuntajesEquipos1.get(i)));
			partidoTemp.setPuntajeEquipo2(Integer.parseInt(listaPuntajesEquipos2.get(i)));
			
			listaPartidos.add(partidoTemp);
			
		}
		
		arregloTemp[0] = listaPartidos.get(0);
		arregloTemp[1] = listaPartidos.get(1);
		arregloTemp[2] = listaPartidos.get(2);
		arregloTemp[3] = listaPartidos.get(3);
		arregloTemp[4] = listaPartidos.get(4);
		arregloTemp[5] = listaPartidos.get(5);
		arregloTemp[6] = listaPartidos.get(6);
		arregloTemp[7] = listaPartidos.get(7);
		
		return arregloTemp;
	}
	
	
	//----------------------------------------------------------------------------------------------------
	
	public Partido[] retornarPartidosCuartos(String mundial) throws SQLException, Exception {

		Partido[] arregloTemp = new Partido[4];
		
		ArrayList<String> listaEquipos1 = new ArrayList<>();
		ArrayList<String> listaEquipos2 = new ArrayList<>();
		ArrayList<String> listaEquiposGanadores = new ArrayList<>();
		ArrayList<String> listaEquiposPerdedores = new ArrayList<>();
		ArrayList<String> listaPuntajesEquipos1 = new ArrayList<>();
		ArrayList<String> listaPuntajesEquipos2 = new ArrayList<>();
		
		ArrayList<Partido> listaPartidos = new ArrayList<>();
		
		java.sql.ResultSet rs = null;
		String sql;

		sql = "SELECT * FROM PartidosSegudaFase " + "WHERE mundial = '" + mundial + "' AND fase = "+ 4 + ";";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		
		if (rs.next() == true) {
			do {

				try {

					listaEquipos1.add(rs.getString("equipo1"));
					listaEquipos2.add(rs.getString("equipo2"));
					listaEquiposGanadores.add(rs.getString("equipoGanador"));
					listaEquiposPerdedores.add(rs.getString("equipoPerdedor"));
					listaPuntajesEquipos1.add(rs.getString("puntajeEquipo1"));
					listaPuntajesEquipos2.add(rs.getString("puntajeEquipo2"));

				}catch(Exception e) {

					System.out.println(e.getMessage());

				}

			} while (rs.next());

		}
		rs.close();
		
		for(int i=0; i<4; i++) {
			
			Partido partidoTemp = new Partido(new MultiEquipos().buscar(listaEquipos1.get(i)), new MultiEquipos().buscar(listaEquipos2.get(i)));
			partidoTemp.setEquipoGanador(new MultiEquipos().buscar(listaEquiposGanadores.get(i)));
			partidoTemp.setEquipoPerdedor(new MultiEquipos().buscar(listaEquiposPerdedores.get(i)));
			partidoTemp.setPuntajeEquipo1(Integer.parseInt(listaPuntajesEquipos1.get(i)));
			partidoTemp.setPuntajeEquipo2(Integer.parseInt(listaPuntajesEquipos2.get(i)));
			
			listaPartidos.add(partidoTemp);
			
		}
		
		arregloTemp[0] = listaPartidos.get(0);
		arregloTemp[1] = listaPartidos.get(1);
		arregloTemp[2] = listaPartidos.get(2);
		arregloTemp[3] = listaPartidos.get(3);
		
		return arregloTemp;
	}
	
	
	
	//----------------------------------------------------------------------------------------------------
	
	public Partido[] retornarPartidosFinales(String mundial,int fase) throws SQLException, Exception {

		Partido[] arregloTemp = new Partido[2];
		
		ArrayList<String> listaEquipos1 = new ArrayList<>();
		ArrayList<String> listaEquipos2 = new ArrayList<>();
		ArrayList<String> listaEquiposGanadores = new ArrayList<>();
		ArrayList<String> listaEquiposPerdedores = new ArrayList<>();
		ArrayList<String> listaPuntajesEquipos1 = new ArrayList<>();
		ArrayList<String> listaPuntajesEquipos2 = new ArrayList<>();
		
		ArrayList<Partido> listaPartidos = new ArrayList<>();
		
		java.sql.ResultSet rs = null;
		String sql;

		sql = "SELECT * FROM PartidosSegudaFase " + "WHERE mundial = '" + mundial + "' AND fase = "+ fase + ";";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		
		if (rs.next() == true) {
			do {

				try {

					listaEquipos1.add(rs.getString("equipo1"));
					listaEquipos2.add(rs.getString("equipo2"));
					listaEquiposGanadores.add(rs.getString("equipoGanador"));
					listaEquiposPerdedores.add(rs.getString("equipoPerdedor"));
					listaPuntajesEquipos1.add(rs.getString("puntajeEquipo1"));
					listaPuntajesEquipos2.add(rs.getString("puntajeEquipo2"));

				}catch(Exception e) {

					System.out.println(e.getMessage());

				}

			} while (rs.next());

		}
		rs.close();
		
		for(int i=0; i<2; i++) {
			
			Partido partidoTemp = new Partido(new MultiEquipos().buscar(listaEquipos1.get(i)), new MultiEquipos().buscar(listaEquipos2.get(i)));
			partidoTemp.setEquipoGanador(new MultiEquipos().buscar(listaEquiposGanadores.get(i)));
			partidoTemp.setEquipoPerdedor(new MultiEquipos().buscar(listaEquiposPerdedores.get(i)));
			partidoTemp.setPuntajeEquipo1(Integer.parseInt(listaPuntajesEquipos1.get(i)));
			partidoTemp.setPuntajeEquipo2(Integer.parseInt(listaPuntajesEquipos2.get(i)));
			
			listaPartidos.add(partidoTemp);
			
		}
		
		arregloTemp[0] = listaPartidos.get(0);
		arregloTemp[1] = listaPartidos.get(1);
		
		return arregloTemp;
	}
	
	//-------------------------------------------------------------------------------------------------------------
	
	
	public Equipo[] retornarGanadoresOctavosFinal(String mundial) throws SQLException, Exception {

		Equipo[] arregloTemp = new Equipo[8];
		ArrayList<String> listaNombreEquipos = new ArrayList<>();
		ArrayList<Equipo> listaEquipos = new ArrayList<>();
		
		java.sql.ResultSet rs = null;
		String sql;

		sql = "SELECT * FROM GanadoresSegundaFase " + "WHERE mundial = '" + mundial + "' AND fase = '" + 8 +"' ;";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		
		if (rs.next() == true) {
			do {

				try {

					listaNombreEquipos.add(rs.getString("nombre"));

				}catch(Exception e) {

					System.out.println(e.getMessage());

				}

			} while (rs.next());

		}
		rs.close();
		
		for(String e: listaNombreEquipos) {
			
			listaEquipos.add(new MultiEquipos().buscar(e));
			
		}
		
		arregloTemp[0] = listaEquipos.get(0);
		arregloTemp[1] = listaEquipos.get(1);
		arregloTemp[2] = listaEquipos.get(2);
		arregloTemp[3] = listaEquipos.get(3);
		arregloTemp[4] = listaEquipos.get(4);
		arregloTemp[5] = listaEquipos.get(5);
		arregloTemp[6] = listaEquipos.get(6);
		arregloTemp[7] = listaEquipos.get(7);
		
		return arregloTemp;
	}
	
	//-----------------------------------------------------------------------------------------------
	
	
	public Equipo[] retornarGanadoresCuartosFinal(String mundial) throws SQLException, Exception {

		Equipo[] arregloTemp = new Equipo[4];
		ArrayList<String> listaNombreEquipos = new ArrayList<>();
		ArrayList<Equipo> listaEquipos = new ArrayList<>();
		
		java.sql.ResultSet rs = null;
		String sql;

		sql = "SELECT * FROM GanadoresSegundaFase " + "WHERE mundial = '" + mundial + "' AND fase = '" + 4 +"';";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		
		if (rs.next() == true) {
			do {

				try {

					listaNombreEquipos.add(rs.getString("nombre"));

				}catch(Exception e) {

					System.out.println(e.getMessage());

				}

			} while (rs.next());

		}
		rs.close();
		
		for(String e: listaNombreEquipos) {
			
			listaEquipos.add(new MultiEquipos().buscar(e));
			
		}
		
		arregloTemp[0] = listaEquipos.get(0);
		arregloTemp[1] = listaEquipos.get(1);
		arregloTemp[2] = listaEquipos.get(2);
		arregloTemp[3] = listaEquipos.get(3);
		
		return arregloTemp;
	}
	
}
