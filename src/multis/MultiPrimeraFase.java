package multis;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import accesoDatos.Conector;
import cl.Equipo;
import cl.ISOPaises;
import cl.Mundiales;
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
		
		JOptionPane.showMessageDialog(null, listaEquiposFIFA.size());
		
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
	
	
	
	
	
}
