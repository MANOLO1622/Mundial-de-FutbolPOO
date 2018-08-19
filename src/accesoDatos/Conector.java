package accesoDatos;

import java.util.ArrayList;

 
public class Conector{
		
	private static AccesoBD conectorBD = null;
	
	//--------------------------------------------------------------------------------
	
	public static AccesoBD getConector() throws java.sql.SQLException,Exception{
		if(conectorBD==null){
			
			TextFileIO lector = new TextFileIO("Datos Conexion - Manuel.txt");
			ArrayList<String> valoresConexion = lector.getData();
			
			conectorBD = new AccesoBD(valoresConexion.get(0),valoresConexion.get(1));
		
		}
		
		return conectorBD;
	}
	
}