package ui;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import cl.*;
import gestor.*;

public class UI {
	
	public static void main (String[] args) throws SQLException, Exception {
		
		Gestor controlador = new Gestor();
		
		CL.ingresarUsuarioLista();
		
		/*
		controlador.registrarUsuario("admin", "Proyecto", "q","q","Mr.Administrador","admin@POO.com", 1);
		controlador.registrarUsuario("Dennis", "Ly", "Dennis","123456","Kenny","Dennis@POO.com", 1);
		controlador.registrarUsuario("Manuel", "Elizondo", "Manuel","123456","manolo","Manuel@POO.com", 1);
		controlador.registrarUsuario("Jugador","Proyecto","j","j","Mr.Jugador","player@POO.com",2);
		controlador.registrarUsuario("Viewer","Proyecto","v","v","Mr.Observador","viewer@POO.com",3);
		*/
		registrarEquiposFIFA();

		Ventana ventLogin = new Ventana(new Usuario(null, null, null, null, null, null, 0));
		ventLogin.setResizable(false);
		ventLogin.ventanaLogin();
		
		
		
	}
	
	
	public static void registrarEquiposFIFA() {
		
		/*
		Gestor.registrarEquipos("Alemania", 1, "src\\graficos\\Banderas\\Alemania.png", ISOPaises.DE);
		Gestor.registrarEquipos("Brazil", 2, "src\\graficos\\Banderas\\Brazil.png", ISOPaises.BR);
		Gestor.registrarEquipos("Belgica", 3, "src\\graficos\\\\Banderas\\Belgica.png", ISOPaises.BE);
		Gestor.registrarEquipos("Portugal", 4, "src\\graficos\\\\Banderas\\Portugal.png", ISOPaises.PT);
		Gestor.registrarEquipos("Argentina", 5, "src\\graficos\\\\Banderas\\Argentina.png", ISOPaises.AR);
		Gestor.registrarEquipos("Suiza", 6, "src\\graficos\\\\Banderas\\Suiza.png", ISOPaises.CH);
		Gestor.registrarEquipos("France", 7, "src\\graficos\\\\Banderas\\France.png", ISOPaises.FR);
		Gestor.registrarEquipos("Polonia", 8, "src\\graficos\\\\Banderas\\Polonia.png", ISOPaises.PL);
		Gestor.registrarEquipos("Chile", 9, "src\\graficos\\\\Banderas\\Chile.png", ISOPaises.CL);
		Gestor.registrarEquipos("España", 10, "src\\graficos\\\\Banderas\\Espana.png", ISOPaises.ES);
		Gestor.registrarEquipos("Peru", 11, "src\\graficos\\\\Banderas\\Peru.png", ISOPaises.PE);
		Gestor.registrarEquipos("Dinamarca", 12, "src\\graficos\\Banderas\\Dinamarca.png", ISOPaises.DK);
		Gestor.registrarEquipos("Inglaterra", 13, "src\\graficos\\Banderas\\Inglaterra.png", ISOPaises.DK);
		Gestor.registrarEquipos("Uruguay", 14, "src\\graficos\\Banderas\\Uruguay.png", ISOPaises.DK);
		Gestor.registrarEquipos("Mexico", 15, "src\\graficos\\Banderas\\Mexico.png", ISOPaises.DK);
		Gestor.registrarEquipos("Colombia", 16, "src\\graficos\\Banderas\\Colombia.png", ISOPaises.DK);
		Gestor.registrarEquipos("Paises Bajos", 17, "src\\graficos\\Banderas\\PaisesBajos.png", ISOPaises.DK);
		Gestor.registrarEquipos("Gales", 18, "src\\graficos\\Banderas\\Gales.png", ISOPaises.DK);
		Gestor.registrarEquipos("Italy", 19, "src\\graficos\\Banderas\\Italy.png", ISOPaises.DK);
		Gestor.registrarEquipos("Croatia", 20, "src\\graficos\\Banderas\\Croatia.png", ISOPaises.DK);
		Gestor.registrarEquipos("Tunez", 21, "src\\graficos\\Banderas\\Tunez.png", ISOPaises.DK);
		Gestor.registrarEquipos("Islandia", 22, "src\\graficos\\Banderas\\Islandia.png", ISOPaises.DK);
		Gestor.registrarEquipos("CostaRica", 23, "src\\graficos\\Banderas\\CostaRica.png", ISOPaises.DK);
		Gestor.registrarEquipos("Suecia", 24, "src\\graficos\\Banderas\\Suecia.png", ISOPaises.DK);
		Gestor.registrarEquipos("EEUU", 25, "src\\graficos\\Banderas\\EEUU.png", ISOPaises.DK);
		Gestor.registrarEquipos("Austria", 26, "src\\graficos\\Banderas\\Austria.png", ISOPaises.DK);
		Gestor.registrarEquipos("Senegal", 27, "src\\graficos\\Banderas\\Senegal.png", ISOPaises.DK);
		Gestor.registrarEquipos("Eslovaquia", 28, "src\\graficos\\Banderas\\Eslovaquia.png", ISOPaises.DK);
		Gestor.registrarEquipos("Irlanda Norte", 29, "src\\graficos\\Banderas\\IrlandaNorte.png", ISOPaises.DK);
		Gestor.registrarEquipos("Rumania", 30, "src\\graficos\\Banderas\\Rumania.png", ISOPaises.DK);
		Gestor.registrarEquipos("Republica Irlanda", 31, "src\\graficos\\Banderas\\RepublicaIrlanda.png", ISOPaises.DK);
		Gestor.registrarEquipos("Paraguay", 32, "src\\graficos\\Banderas\\Paraguay.png", ISOPaises.DK);	
		*/
	}

}

	


















