package ui;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import cl.*;
import gestor.*;

public class UI {
	
	/**
	 * Esta clase Posee la funcion principal para que la app sea ejecutada
	 * de forma segura y correcta
	 * @param args
	 * @throws SQLException
	 * @throws Exception
	 */

	public static void main(String[] args) throws SQLException, Exception {

		CL.ingresarUsuarioLista();
		CL.ingresarEquiposLista();

		Ventana ventLogin = new Ventana(new Usuario(null, null, null, null, null, null, 0));
		ventLogin.setResizable(false);
		ventLogin.ventanaLogin();

	}

}
