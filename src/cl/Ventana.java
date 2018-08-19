package cl;

import java.awt.*;
import java.sql.SQLException;

import javax.swing.*;

/**Esta clase posee los componentes de las ventanas principales de la app
 * ademas de su metodos se almacena en diferentes tipo para su validacion correcta.
 * @author DELL
 *
 */
public class Ventana extends JFrame{
	
	private static Toolkit miPantalla = Toolkit.getDefaultToolkit();
	private static Dimension dimenPantalla = miPantalla.getScreenSize();
	public static int ancho = dimenPantalla.width;
	public static int alto = dimenPantalla.height;
	public Usuario UsuarioActual;
	public Equipo EquipoActual;

	/**
	 * Ventana principal del usuario actual
	 * @param usuarioActual
	 */
	public Ventana(Usuario usuarioActual) {
		
		this.UsuarioActual = usuarioActual;
		
		this.setVisible(true);
		this.setSize(683,384);
		this.setLocationRelativeTo(null);
		Image icono = miPantalla.getImage("src\\graficos\\Futbol.png");
		this.setIconImage(icono);
		
	}


	//--------------------------------------------------------------------------
	/**
	 * Get del usuario actual
	 * @return
	 */
	public Usuario getUsuarioActual() {
		return UsuarioActual;
	}
	/**
	 * Set del usuario actual
	 * @param usuarioActual
	 */
	public void setUsuarioActual(Usuario usuarioActual) {
		this.UsuarioActual = usuarioActual;
	}
	
	//--------------------------------------------------------------------------
	/**
	 * este metodo cierra la ventana del login principal
	 */
	public void ventanaLogin() {
		
		Login l = new Login();
		this.add(l);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Login");
		this.setVisible(true);
		

	}
	
	/**
	 * Este metodo ejecuta el cierre de la ventana del registrar usuarios
	 */
	public void ventanaRegistroUsuarios() {
		
		RegistroUsuarios regUsu = new RegistroUsuarios();
		this.add(regUsu);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Registro de Usuario");
		this.setVisible(true);	
		
	}
	/**
	 * Este metodo ejecuta el cierre de la ventana del registrar equipos
	 */
	public void ventanaRegistroEquipo() {
		
		RegistroEquipos regEqui = new RegistroEquipos(this.UsuarioActual);
		this.add(regEqui);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Registro de Equipos");
		this.setVisible(true);	
		
	}
	
	/**
	 * Este metodo ejecuta el cierre de la ventana del registrar Perfiles
	 * @param perfil
	 * @param vent
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public void ventanaMenuUsuarios(Perfiles perfil , Ventana vent) throws SQLException, Exception {
		
		switch(perfil) {
		
		case ADMIN: 
			this.setUsuarioActual(this.UsuarioActual);
			MenuAdministrador ma = new MenuAdministrador(UsuarioActual);
			this.add(ma);
			vent.setTitle("Administrador " + UsuarioActual.getAvatar());
			vent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			vent.setBounds(5,15,1330,700);
			vent.setResizable(false);
			break;
			
		case PLAYER: 
			this.setUsuarioActual(this.UsuarioActual);
			MenuJugador mj = new MenuJugador(UsuarioActual);
			this.add(mj);
			vent.setTitle("Administrador " + UsuarioActual.getAvatar());
			vent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			vent.setBounds(5,15,1330,700);
			vent.setResizable(false);
			break;
			
		case VIEWER:
			this.setUsuarioActual(UsuarioActual);
			MenuObservador mo = new MenuObservador(this.UsuarioActual);
			this.add(mo);
			vent.setTitle("Observador " + UsuarioActual.getAvatar());
			vent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			vent.setBounds(5,15,1330,700);
			vent.setResizable(false);
			break;
		
		}
		
	}
	
	
	
	/**
	 * Este metodo ejecuta el cierre de la ventana del jugador.
	 * @throws Exception 
	 * @throws SQLException 
	 */
		public void ventanaLigasJugador() throws SQLException, Exception {
			
			LigasJugador ligasJugador = new LigasJugador(UsuarioActual);
			this.setLocation(10, 10);//arreglar despues.
			this.setResizable(false);
			this.setSize(1260,690);
			this.add(ligasJugador);	
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.setTitle("Ligas registradas");
			this.setVisible(true);
			
	
		}
		
		/**
		 * Este metodo ejecuta el cierre de la ventana del jugador.
		 * @param tipoLiga
		 */
		public void ventanaJuego( int tipoLiga) {
			
			Juego j = new Juego(UsuarioActual, tipoLiga);
			this.setLocation(0, 0);//arreglar despues.
			this.setResizable(false);
			this.setSize(1300,730);
			this.add(j);	
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.setTitle("Juego Mundiales");
			this.setVisible(true);
			
	
		}
		
		/**
		 * Este metodo ejecuta el cierre de la ventana del juego fase 2
		 * @param tipoLiga
		 */
		public void ventanaJuegoFase2( int tipoLiga) {
			
			JuegoSegundaFase j = new JuegoSegundaFase(UsuarioActual, tipoLiga);
			this.setLocation(0, 0);//arreglar despues.
			this.setResizable(false);
			this.setSize(1300,730);
			this.add(j);	
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.setTitle("Juego Mundiales - Segunda Fase");
			this.setVisible(true);
			
	
		}
		
	
	//--------------------------------------------------------------------------
	
	
	/**
	 * Este metodo ejecuta el icono por ventana
	 * @param path
	 */
	public void cambiarIConoVentana(String path) {
		
		Image icono = miPantalla.getImage(path);
		setIconImage(icono);
		
	}
	


}


