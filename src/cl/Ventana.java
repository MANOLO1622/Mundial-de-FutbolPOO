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
	public Ventana(Usuario usuarioActual) {
		
		this.UsuarioActual = usuarioActual;
		
		this.setVisible(true);
		this.setSize(683,384);
		this.setLocationRelativeTo(null);
//		this.setLocation(dimenPantalla.width/4, dimenPantalla.height/4);
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
	
	public void ventanaMenuUsuarios(Perfiles perfil , Ventana vent) {
		
		switch(perfil) {
		
		case ADMIN: 
			this.setUsuarioActual(this.UsuarioActual);
			MenuAdministrador ma = new MenuAdministrador(UsuarioActual);
			this.add(ma);
			vent.setTitle("Administrador " + UsuarioActual.getAvatar());
			vent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			vent.setSize(1060,640);
			vent.setExtendedState(Ventana.MAXIMIZED_BOTH);
			break;
			
		case PLAYER: 
			this.setUsuarioActual(this.UsuarioActual);
			MenuJugador mj = new MenuJugador(UsuarioActual);
			this.add(mj);
			vent.setTitle("Administrador " + UsuarioActual.getAvatar());
			vent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			vent.setSize(1060,640);
			vent.setExtendedState(Ventana.MAXIMIZED_BOTH);
			break;
			
		case VIEWER:
			this.setUsuarioActual(UsuarioActual);
			MenuObservador mo = new MenuObservador(this.UsuarioActual);
			this.add(mo);
			vent.setTitle("Observador " + UsuarioActual.getAvatar());
			vent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			vent.setSize(1060,640);
			vent.setExtendedState(Ventana.MAXIMIZED_BOTH);
			break;
		
		}
		
	}
	
	
	
	
		public void ventanaLigasJugador() {
			
			LigasJugador ligasJugador = new LigasJugador(UsuarioActual);
			this.setLocation(10, 10);//arreglar despues.
			this.setResizable(false);
			this.setSize(1260,690);
			this.add(ligasJugador);	
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.setTitle("Ligas registradas");
			this.setVisible(true);
			
	
		}
		
		
		public void ventanaJuego( int tipoLiga) {
			
			Juego j = new Juego(UsuarioActual, tipoLiga);
			this.setLocation(10, 10);//arreglar despues.
			this.setResizable(false);
			this.setSize(1260,690);
			this.add(j);	
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.setTitle("Juego Mundiales");
			this.setVisible(true);
			
	
		}
		
	
	//--------------------------------------------------------------------------
	
	
	
	public void cambiarIConoVentana(String path) {
		
		Image icono = miPantalla.getImage(path);
		setIconImage(icono);
		
	}
	


}


