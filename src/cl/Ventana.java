package cl;

import java.awt.*;
import javax.swing.*;

public class Ventana extends JFrame{
	
	private static Toolkit miPantalla = Toolkit.getDefaultToolkit();
	private static Dimension dimenPantalla = miPantalla.getScreenSize();
	public static int ancho = dimenPantalla.width;
	public static int alto = dimenPantalla.height;
	
	@SuppressWarnings("deprecation")
	public Ventana() {
		
		
		this.setVisible(true);
		this.setSize(ancho/2, alto/2);
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
			MenuAdministrador ma = new MenuAdministrador();
			this.add(ma);
			vent.setTitle("Administrador " + nombreUsuario);
			vent.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
			break;
			
		case PLAYER: 
			
			MenuJugador mj = new MenuJugador();
			this.add(mj);
			vent.setTitle("Jugador " + nombreUsuario);
			vent.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			break;
			
		case VIEWER:
			MenuObservador mo = new MenuObservador();
			this.add(mo);
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
	
	//--------------------------------------------------------------------------

}


