package cl;

import java.awt.*;
import javax.swing.*;

public class Ventana extends JFrame{
	
	private static Toolkit miPantalla = Toolkit.getDefaultToolkit();
	private static Dimension dimenPantalla = miPantalla.getScreenSize();
	public static int ancho = dimenPantalla.width;
	public static int alto = dimenPantalla.height;
	public Usuario UsuarioActual;

	@SuppressWarnings("deprecation")
	public Ventana() {
		
		
		this.setVisible(true);
		this.setSize(683,384);
		this.setLocation(dimenPantalla.width/4, dimenPantalla.height/4);
		
		Image icono = miPantalla.getImage("src\\graficos\\Futbol.png");
		this.setIconImage(icono);
		
		
	}
	
	
	//--------------------------------------------------------------------------
	
	public Usuario getUsuarioActual() {
		return UsuarioActual;
	}

	public void setUsuarioActual(Usuario usuarioActual) {
		this.UsuarioActual = usuarioActual;
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
	
	public void ventanaMenuUsuarios(Perfiles perfil, /*String nombreUsuario*/ Usuario UsuarioActual, Ventana vent) {
		
		switch(perfil) {
		
		case ADMIN: 
			MenuAdministrador ma = new MenuAdministrador();
			this.add(ma);
			vent.setTitle("Administrador " + /*nombreUsuario*/UsuarioActual.getAvatar());
			vent.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			break;
			
		case PLAYER: 
			
			MenuJugador mj = new MenuJugador();
			this.add(mj);
			vent.setTitle("Jugador " + /*nombreUsuario*/UsuarioActual.getAvatar());
			vent.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			break;
			
		case VIEWER:
			MenuObservador mo = new MenuObservador();
			this.add(mo);
			vent.setTitle("Observador " + /*nombreUsuario*/UsuarioActual.getAvatar());
			vent.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			break;
		
		}
		
	}
	
	
	
	
		public void ventanaJuego() {
			
			Juego j = new Juego();
			this.setExtendedState(Ventana.MAXIMIZED_BOTH);
			this.add(j);	
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.setTitle("Juego Mundiales");
			this.show();
			
	
		}
		
	
	//--------------------------------------------------------------------------
	
	
	
	public void cambiarIConoVentana(String path) {
		
		Image icono = miPantalla.getImage(path);
		setIconImage(icono);
		
	}
	


}


