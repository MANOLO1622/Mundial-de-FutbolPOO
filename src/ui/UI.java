package ui;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import cl.*;
import gestor.*;

public class UI {

	public static void main(String[] args) throws SQLException, Exception {

		CL.ingresarUsuarioLista();
		CL.ingresarEquiposLista();

		Ventana ventLogin = new Ventana(new Usuario(null, null, null, null, null, null, 0));
		ventLogin.setResizable(false);
		ventLogin.ventanaLogin();

	}

}
