package multis;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import accesoDatos.Conector;
import cl.Equipo;
import cl.ISOPaises;
import cl.Mundiales;
import rondasMundial.Partido;
import rondasMundial.Resultados;

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
	
	//----------------------------------------------------------------------------------------------------
	
	public ArrayList<Equipo> retornarEquipos(String mundial) throws SQLException, Exception {
		
		ArrayList<Equipo> listaEquiposFIFA = new MultiEquipos().retornarEquipos();
		
		return listaEquiposFIFA;	
		
	}
	
	//----------------------------------------------------------------------------------------------------
	
	public Equipo[] retornarCuadroPrimeraFase(String mundial, int cuadro) throws SQLException, Exception {

		Equipo[] arregloTemp = new Equipo[4];
		ArrayList<String> listaNombreEquipos = new ArrayList<>();
		ArrayList<Equipo> listaEquipos = new ArrayList<>();
		Equipo equipoTemp = null;
		
		java.sql.ResultSet rs = null;
		String sql;

		sql = "SELECT * FROM CuadrosPrimeraFase " + "WHERE mundial = '" + mundial + "' AND cuadro = "+ cuadro + ";";
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
	
	//----------------------------------------------------------------------------------------------------
	
	
	
	public Equipo[] retornarGanadoresCuadroPrimeraFase(String mundial, int cuadro) throws SQLException, Exception {

		Equipo[] arregloTemp = new Equipo[2];
		ArrayList<String> listaNombreEquipos = new ArrayList<>();
		ArrayList<Equipo> listaEquipos = new ArrayList<>();
		Equipo equipoTemp = null;
		
		java.sql.ResultSet rs = null;
		String sql;

		sql = "SELECT * FROM GanadoresPrimeraFase " + "WHERE mundial = '" + mundial + "' AND cuadro = "+ cuadro + ";";
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
		
		return arregloTemp;
	}
	
	
	//----------------------------------------------------------------------------------------------------
	
		public Partido[] retornarPartidosCuadroPrimeraFase(String mundial, int cuadro) throws SQLException, Exception {

			Partido[] arregloTemp = new Partido[6];
			
			ArrayList<String> listaEquipos1 = new ArrayList<>();
			ArrayList<String> listaEquipos2 = new ArrayList<>();
			ArrayList<String> listaEquiposGanadores = new ArrayList<>();
			ArrayList<String> listaEquiposPerdedores = new ArrayList<>();
			ArrayList<String> listaPuntajesEquipos1 = new ArrayList<>();
			ArrayList<String> listaPuntajesEquipos2 = new ArrayList<>();
			
			ArrayList<Partido> listaPartidos = new ArrayList<>();
			
			java.sql.ResultSet rs = null;
			String sql;

			sql = "SELECT * FROM PartidosPrimeraFase " + "WHERE mundial = '" + mundial + "' AND cuadro = "+ cuadro + ";";
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
			
			for(int i=0; i<6; i++) {
				
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
			
			return arregloTemp;
		}
	
	
	
		//-------------------------------------------------------------------------------------------------------------
		
		
		public Equipo[] retornarGanadoresPrimeraFase(String mundial) throws SQLException, Exception {

			Equipo[] arregloTemp = new Equipo[16];
			ArrayList<String> listaNombreEquipos = new ArrayList<>();
			ArrayList<Equipo> listaEquipos = new ArrayList<>();
			
			java.sql.ResultSet rs = null;
			String sql;

			sql = "SELECT * FROM GanadoresPrimeraFase " + "WHERE mundial = '" + mundial + "' ;";
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
			arregloTemp[8] = listaEquipos.get(8);
			arregloTemp[9] = listaEquipos.get(9);
			arregloTemp[10] = listaEquipos.get(10);
			arregloTemp[11] = listaEquipos.get(11);
			arregloTemp[12] = listaEquipos.get(12);
			arregloTemp[13] = listaEquipos.get(13);
			arregloTemp[14] = listaEquipos.get(14);
			arregloTemp[15] = listaEquipos.get(15);

			
			return arregloTemp;
		}
	
}
