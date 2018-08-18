package ui;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import cl.*;
import gestor.*;

public class UI {
	
	/**
	 * esto es una prueba
	 * @param args
	 * @throws SQLException
	 * @throws Exception
	 */

	public static void main(String[] args) throws SQLException, Exception {

		Gestor controlador = new Gestor();

		CL.ingresarUsuarioLista();

		Ventana ventLogin = new Ventana(new Usuario(null, null, null, null, null, null, 0));
		ventLogin.setResizable(false);
		ventLogin.ventanaLogin();

	}

}
