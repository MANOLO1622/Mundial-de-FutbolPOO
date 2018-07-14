package cl;

import java.awt.*;
import javax.swing.*;

public class Ventana extends JFrame{
	
	private static Toolkit miPantalla = Toolkit.getDefaultToolkit();
	
	@SuppressWarnings("deprecation")
	public Ventana() {
		
		
		Dimension dimenPantalla = miPantalla.getScreenSize();		
		
		this.setVisible(true);
		this.setSize(dimenPantalla.width/2, dimenPantalla.height/2);
		this.setLocation(dimenPantalla.width/4, dimenPantalla.height/4);
		
		Image icono = miPantalla.getImage("src\\graficos\\Futbol.png");
		this.setIconImage(icono);
		
		
	}
	
	//--------------------------------------------------------------------------
	
	public void ventanaLogin() {
		
		Login l = new Login();
		this.add(l);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Login");
		this.show();	
		
	}
	
	
	
	public void ventanaRegistroUsuarios() {
		
		
		RegistroUsuarios regUsu = new RegistroUsuarios();
		this.add(regUsu);
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Registro de Usuario");
		this.show();	
		
	}
	
	public void ventanaMenuUsuarios(Perfiles perfil, String nombreUsuario, Ventana vent) {
		
switch(perfil) {
		
		case ADMIN: 
			
//			Ventana menuAdministrador = new Ventana();
			vent.setTitle("Administrador " + nombreUsuario);
			vent.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
			break;
			
		case PLAYER: 
//			Ventana menuJugador = new Ventana();
			vent.setTitle("Jugador " + nombreUsuario);
			vent.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			break;
			
		case VIEWER:
//			Ventana menuObservador = new Ventana();
			vent.setTitle("Observador " + nombreUsuario);
			vent.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			break;
		
		}
		
	}
	
	
	//--------------------------------------------------------------------------
	
	
	
	public void cambiarIConoVentana(String path) {
		
		Image icono = miPantalla.getImage(path);
		setIconImage(icono);
		
	}
	

}


