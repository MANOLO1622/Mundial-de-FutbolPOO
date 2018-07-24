package ui;

import java.awt.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.*;
import cl.*;
import gestor.*;



public class UI {
	
	public static void main (String[] args) {
		
		Gestor controlador = new Gestor();
		controlador.registrarUsuario("admin", "Proyecto", "q","q","Mr.Administrador","admin@POO.com", 1);
		controlador.registrarUsuario("Jugador","Proyecto","j","j","Mr.Jugador","player@POO.com",2);
		controlador.registrarUsuario("Viewer","Proyecto","Viewer","viewerPOO","Mr.Observador","viewer@POO.com",3);
		
		
		LocalDate fechaPrueba = null;
		controlador.registrarLigaPublicas("Liga Prueba", fechaPrueba, true, 100, 100);
		
		
		registrarEquiposFIFA();
		controlador.listarEquiposFIFA();
		
		
		
		
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
		
		
	}

}
