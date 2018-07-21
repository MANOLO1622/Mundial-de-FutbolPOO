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
		
		controlador.listarUsuarios();
		
		Ventana ventLogin = new Ventana();
		ventLogin.setResizable(false);
		ventLogin.ventanaLogin();
		
		
		
		
		
	}

}
