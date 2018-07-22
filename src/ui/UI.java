package ui;

import java.awt.*;
import javax.swing.*;
import cl.*;
import gestor.*;



public class UI {
	
	public static void main (String[] args) {
		
		Gestor controlador = new Gestor();
		controlador.registrarUsuario("admin", "Proyecto", "Admin","adminPOO","Mr.Administrador","admin@POO.com", 1);
		controlador.registrarUsuario("Jugador","Proyecto","Player","playerPOO","Mr.Jugador","player@POO.com",2);
		controlador.registrarUsuario("Viewer","Proyecto","Viewer","viewerPOO","Mr.Observador","viewer@POO.com",3);
		
		
		registrarEquiposFIFA();
		controlador.listarEquiposFIFA();
		
		
		
		
		controlador.listarUsuarios();
		
		Ventana ventLogin = new Ventana();
		ventLogin.setResizable(false);
		ventLogin.ventanaLogin();
		
		
		
		
		
	}
	
	
	public static void registrarEquiposFIFA() {
		
		Gestor controlador = new Gestor();
		controlador.registrarEquipos("Alemania", 1, "Bandera", ISOPaises.DE);
		controlador.registrarEquipos("Brazil", 2, "Bandera", ISOPaises.BR);
		controlador.registrarEquipos("Belgica", 3, "Bandera", ISOPaises.BE);
		controlador.registrarEquipos("Portugal", 4, "Bandera", ISOPaises.PT);
		controlador.registrarEquipos("Argentina", 5, "Bandera", ISOPaises.AR);
		controlador.registrarEquipos("SUiza", 6, "Bandera", ISOPaises.CH);
		controlador.registrarEquipos("France", 7, "Bandera", ISOPaises.FR);
		controlador.registrarEquipos("Polonia", 8, "Bandera", ISOPaises.PL);
		controlador.registrarEquipos("Chile", 9, "Bandera", ISOPaises.CL);
		controlador.registrarEquipos("España", 10, "Bandera", ISOPaises.ES);
		controlador.registrarEquipos("Peru", 11, "Bandera", ISOPaises.PE);
		controlador.registrarEquipos("Dinamarca", 12, "Bandera", ISOPaises.DK);
		
		
	}

}
