package ui;

import java.awt.*;
import javax.swing.*;
import cl.*;
import gestor.*;



public class UI {
	
	public static void main (String[] args) {
		
		Gestor controlador = new Gestor();
		controlador.registrarUsuario("admin", "Proyecto", "Admin","adminPOO", 1);
		controlador.registrarUsuario("Jugador","Proyecto","Player","playerPOO",2);
		controlador.registrarUsuario("Viewer","Proyecto","Viewer","viewerPOO",3);
		
		controlador.listarUsuarios();
		
		Ventana ventLogin = new Ventana();
		ventLogin.ventanaLogin();
		
		
		
		
	}

}
