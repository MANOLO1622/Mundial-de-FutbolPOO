package ui;
import java.awt.*;
//import java.awt.Toolkit;
//import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.*;
import cl.*;
import gestor.*;
import java.awt.*;
import java.awt.Toolkit;
import javax.swing.*;
import java.awt.*;
//import java.awt.Toolkit;
import javax.swing.*;

public class UI {
	
	public static void main (String[] args) {
		
		Gestor controlador = new Gestor();
		controlador.registrarUsuario("admin", "Proyecto", "q","q","Mr.Administrador","admin@POO.com", 1);
		controlador.registrarUsuario("Jugador","Proyecto","j","j","Mr.Jugador","player@POO.com",2);
		controlador.registrarUsuario("Viewer","Proyecto","v","v","Mr.Observador","viewer@POO.com",3);
		
		
		LocalDate fechaPrueba = null;
<<<<<<< HEAD
		controlador.registrarLigaPublicas("Liga Publica 1", fechaPrueba, true, 100, 100, "MundialAnfitrion");
		controlador.registrarLigaPublicas("Liga Publica 2", fechaPrueba, true, 100, 100,"MundialAnfitrion");
=======
//		controlador.registrarLigaPublicas("Quemada1", fechaPrueba, true, 100, 100);
//		controlador.registrarLigaPublicas("Quemada2", fechaPrueba, true, 100, 100);
>>>>>>> branch 'master' of https://github.com/MANOLO1622/Mundial-de-FutbolPOO.git
		
		registrarEquiposFIFA();
		controlador.listarEquiposFIFA();
		
		registrarAnfitrionesFIFA();
		controlador.listarAnfitrionesFIFA();
		
		controlador.listarUsuarios();
		
		Ventana ventLogin = new Ventana(new Usuario(null, null, null, null, null, null, 0));
		ventLogin.setResizable(false);
		ventLogin.ventanaLogin();
		
	}
	
	
	public static void registrarEquiposFIFA() {
		
		Gestor controlador = new Gestor();
		controlador.registrarEquipos("Alemania", 1, "src\\graficos\\Banderas\\Alemania.png", ISOPaises.DE);
		controlador.registrarEquipos("Brazil", 2, "src\\graficos\\Banderas\\Brazil.png", ISOPaises.BR);
		controlador.registrarEquipos("Belgica", 3, "src\\graficos\\\\Banderas\\Belgica.png", ISOPaises.BE);
		controlador.registrarEquipos("Portugal", 4, "src\\graficos\\\\Banderas\\Portugal.png", ISOPaises.PT);
		controlador.registrarEquipos("Argentina", 5, "src\\graficos\\\\Banderas\\Argentina.png", ISOPaises.AR);
		controlador.registrarEquipos("Suiza", 6, "src\\graficos\\\\Banderas\\Suiza.png", ISOPaises.CH);
		controlador.registrarEquipos("France", 7, "src\\graficos\\\\Banderas\\France.png", ISOPaises.FR);
		controlador.registrarEquipos("Polonia", 8, "src\\graficos\\\\Banderas\\Polonia.png", ISOPaises.PL);
		controlador.registrarEquipos("Chile", 9, "src\\graficos\\\\Banderas\\Chile.png", ISOPaises.CL);
		controlador.registrarEquipos("España", 10, "src\\graficos\\\\Banderas\\Espana.png", ISOPaises.ES);
		controlador.registrarEquipos("Peru", 11, "src\\graficos\\\\Banderas\\Peru.png", ISOPaises.PE);
		controlador.registrarEquipos("Dinamarca", 12, "src\\graficos\\Banderas\\Dinamarca.png", ISOPaises.DK);
		controlador.registrarEquipos("Inglaterra", 13, "src\\graficos\\Banderas\\Inglaterra.png", ISOPaises.DK);
		controlador.registrarEquipos("Uruguay", 14, "src\\graficos\\Banderas\\Uruguay.png", ISOPaises.DK);
		controlador.registrarEquipos("Mexico", 15, "src\\graficos\\Banderas\\Mexico.png", ISOPaises.DK);
		controlador.registrarEquipos("Colombia", 16, "src\\graficos\\Banderas\\Colombia.png", ISOPaises.DK);
		controlador.registrarEquipos("Paises Bajos", 17, "src\\graficos\\Banderas\\PaisesBajos.png", ISOPaises.DK);
		controlador.registrarEquipos("Gales", 18, "src\\graficos\\Banderas\\Gales.png", ISOPaises.DK);
		controlador.registrarEquipos("Italy", 19, "src\\graficos\\Banderas\\Italy.png", ISOPaises.DK);
		controlador.registrarEquipos("Croatia", 20, "src\\graficos\\Banderas\\Croatia.png", ISOPaises.DK);
		controlador.registrarEquipos("Tunez", 21, "src\\graficos\\Banderas\\Tunez.png", ISOPaises.DK);
		controlador.registrarEquipos("Islandia", 22, "src\\graficos\\Banderas\\Islandia.png", ISOPaises.DK);
		controlador.registrarEquipos("CostaRica", 23, "src\\graficos\\Banderas\\CostaRica.png", ISOPaises.DK);
		controlador.registrarEquipos("Suecia", 24, "src\\graficos\\Banderas\\Suecia.png", ISOPaises.DK);
		controlador.registrarEquipos("EEUU", 25, "src\\graficos\\Banderas\\EEUU.png", ISOPaises.DK);
		controlador.registrarEquipos("Austria", 26, "src\\graficos\\Banderas\\Austria.png", ISOPaises.DK);
		controlador.registrarEquipos("Senegal", 27, "src\\graficos\\Banderas\\Senegal.png", ISOPaises.DK);
		controlador.registrarEquipos("Eslovaquia", 28, "src\\graficos\\Banderas\\Eslovaquia.png", ISOPaises.DK);
		controlador.registrarEquipos("Irlanda Norte", 29, "src\\graficos\\Banderas\\IrlandaNorte.png", ISOPaises.DK);
		controlador.registrarEquipos("Rumania", 30, "src\\graficos\\Banderas\\Rumania.png", ISOPaises.DK);
		controlador.registrarEquipos("Republica Irlanda", 31, "src\\graficos\\Banderas\\RepublicaIrlanda.png", ISOPaises.DK);
		controlador.registrarEquipos("Paraguay", 32, "src\\graficos\\Banderas\\Paraguay.png", ISOPaises.DK);
		
	}
	
	
	


	public static void registrarAnfitrionesFIFA() {
		
		Gestor controlador = new Gestor();
		controlador.registrarAnfitriones("Costa Rica");
		
	}

}

	


















