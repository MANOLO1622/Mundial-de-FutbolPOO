package accesoDatos;

import java.util.ArrayList;

 
/**Esta clase posee el metodo del conector principal hacia la base de datos.
 * @author DELL
 *
 */
public class Conector{
		
	private static AccesoBD conectorBD = null;
	
	//--------------------------------------------------------------------------------
	
	/**
	 * Estes el metodo que se ejecuta para hacer conexion con el acceso y la base de datos
	 * @return
	 * @throws java.sql.SQLException
	 * @throws Exception
	 */
	public static AccesoBD getConector() throws java.sql.SQLException,Exception{
		if(conectorBD==null){
			
			TextFileIO lector = new TextFileIO("Datos Conexion.txt");
			ArrayList<String> valoresConexion = lector.getData();
			
			conectorBD = new AccesoBD(valoresConexion.get(0),valoresConexion.get(1));
		
		}
		
		return conectorBD;
	}
	
}