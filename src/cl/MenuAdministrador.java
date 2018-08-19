package cl;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.time.*;
import java.util.*;

import javax.print.attribute.standard.MediaSize.ISO;
import javax.swing.*;
import com.toedter.calendar.*;
import gestor.*;

/**Esta clase contiene los componentes principales que el administrador
 * que podra mostrar, ejecutar y organizar en su app, ademas posee todos
 * los botones generales con sus permisos y validaciones correctas para
 * crear, eliminar y registrar usuarios, equipos, mundiales o ligas a su disposicion 
 * y mucho mas.
 * @author DELL
 *
 */
public class MenuAdministrador extends JPanel implements ActionListener {

	public Usuario miUsuario;
	private static Image imagen;
	Gestor controlador = new Gestor();

	JButton boton1 = new JButton("Usuarios");
	JButton boton2 = new JButton("Apuestas");
	JButton boton3 = new JButton("Crear Mundial");
	JButton boton10 = new JButton("Crear Equipos");
	JButton boton11 = new JButton("Crear Jugadores");
	JButton botonLigaPublica = new JButton("Crear Liga Publica");
	JButton btnEliminarLigaPublica = new JButton("Eliminar Liga Publica");
	JButton botonLigaPrivada = new JButton("Crear Liga Privada");
	JButton btnEliminarLigaPrivada = new JButton("Eliminar Liga Privada");
	JButton btnIncJugLigaPrivada = new JButton("Incluir en LigaPrivada");
	JButton botonSalir = new JButton("Salir");
	JButton botonEliminarPublicaRegistro = new JButton("Eliminar");
	JButton botonEliminarPrivadaRegistro = new JButton("Eliminar");
	JButton CancelarEliminacionLiga = new JButton("Cancelar");

	// ----------------------------------------------------------------------

	JLabel labelNombreLiga = new JLabel("Nombre Liga:");
	JLabel labelTituloPrivada = new JLabel("Crear Liga Privada");
	JLabel labelTituloPublica = new JLabel("Crear Liga Publica");
	JLabel labelTituloMundial = new JLabel("Crear Mundial");
	JLabel labelTituloIncluir = new JLabel("Incluir Liga Privada a Usuario");
	JLabel labelTituloEliminarPrivada = new JLabel("Eliminar Liga Privada");
	JLabel labelTituloEliminarPublica = new JLabel("Eliminar Liga Publica");
	JTextField nombreLigaTXT = new JTextField(10);
	JLabel labelEstado = new JLabel("Estado:");
	JTextField estadoTXT = new JTextField(10);

	// ------------------------------------------------------------------------------

	JLabel labelNombreMundial = new JLabel("Nombre del Mundial:");
	JTextField nombreMundialTXT = new JTextField();
	JLabel labelAno = new JLabel("Fecha: ");
	JCalendar fechaMundial = new JCalendar();
	JLabel labelPaisOrganizador = new JLabel("Pais Organizador:");
	

	// ------------------------------------------------------------------------------

	JLabel labelMundialAnfitrion = new JLabel("Mundial:");
	JLabel labelEstados = new JLabel("Estado:");
	JTextField estadosTXT = new JTextField(10);

	// ---------------------------COMBO BOX---------------------------------------------------
	JComboBox paisesOrganizadores = new JComboBox();
	JComboBox MundialAnfitrion = new JComboBox();
	JComboBox LigasPublicas = new JComboBox();
	JComboBox LigasPrivadas = new JComboBox();
	JComboBox usuariosRegistrados = new JComboBox();
	JComboBox ligasPrivadasRegistradas = new JComboBox();
	

	// ------------------------------------------------------------------------------

	JButton btnRegistrarLigaPublica = new JButton("Registrar");
	JButton btnRegistrarLigaPrivada = new JButton("");
	JButton btnCancelar = new JButton("Cancelar");
	JButton btnRegistrarMundial = new JButton("Registrar");
	JButton btnRegistroLigaPublica = new JButton("Registrar");
	JButton btnRegistroLigaPrivada = new JButton("Registrar");
	JButton btnSalir = new JButton("Salir");
	JButton botonCancelarRegistroPublico = new JButton("Cancelar");

	// ---------------------Botones de Incluir una Liga Privada-----------------------

	JLabel labelNombreUsuario = new JLabel("Usuario:");
	JLabel labelNombreLigaPrivada = new JLabel("Liga:");
	JButton botonRegistrarPrivadaRegistro = new JButton("Incluir");

	// -------------------Boton de mostrar informacion de usuarios--------------------

	
	JLabel informacionUsuario1 = new JLabel("");
	JLabel informacionUsuario2 = new JLabel("");
	
	// ------------------------------------------------------------------------------
/**
 * Este metodo contiene los botones principales de la pantalla del Admin.
 * @param miUsuario
 * @throws Exception 
 * @throws SQLException 
 */
	public MenuAdministrador(Usuario miUsuario) throws SQLException, Exception {

		this.miUsuario = miUsuario;
		ingresarComboBox();
		this.setLayout(null);
		

		boton1.setBounds(10, 20, 180, 50);
		boton1.setFont(new Font(boton1.getFont().getFontName(), Font.BOLD, 13));
		this.add(boton1);

		boton2.setBounds(10, 80, 180, 50);
		boton2.setFont(new Font(boton2.getFont().getFontName(), Font.BOLD, 13));
		this.add(boton2);

		boton3.setBounds(10, 140, 180, 50);
		boton3.setFont(new Font(boton3.getFont().getFontName(), Font.BOLD, 13));
		this.add(boton3);

		boton10.setBounds(10, 200, 180, 50);
		boton10.setFont(new Font(boton10.getFont().getFontName(), Font.BOLD, 13));
		this.add(boton10);

		boton11.setBounds(10, 260, 180, 50);
		boton11.setFont(new Font(boton11.getFont().getFontName(), Font.BOLD, 13));
		this.add(boton11);

		botonLigaPublica.setBounds(10, 320, 180, 50);
		botonLigaPublica.setFont(new Font(botonLigaPublica.getFont().getFontName(), Font.BOLD, 13));
		this.add(botonLigaPublica);

		btnEliminarLigaPublica.setBounds(10, 380, 180, 50);
		btnEliminarLigaPublica.setFont(new Font(btnEliminarLigaPublica.getFont().getFontName(), Font.BOLD, 13));
		this.add(btnEliminarLigaPublica);

		botonLigaPrivada.setBounds(10, 440, 180, 50);
		botonLigaPrivada.setFont(new Font(botonLigaPrivada.getFont().getFontName(), Font.BOLD, 13));
		this.add(botonLigaPrivada);

		btnIncJugLigaPrivada.setBounds(10, 505, 180, 50);
		btnIncJugLigaPrivada.setFont(new Font(btnIncJugLigaPrivada.getFont().getFontName(), Font.BOLD, 13));
		this.add(btnIncJugLigaPrivada);

		btnEliminarLigaPrivada.setBounds(10, 570, 180, 50);
		btnEliminarLigaPrivada.setFont(new Font(btnEliminarLigaPrivada.getFont().getFontName(), Font.BOLD, 13));
		this.add(btnEliminarLigaPrivada);

		botonSalir.setBounds(1130, 600, 180, 50);
		botonSalir.setFont(new Font(botonSalir.getFont().getFontName(), Font.BOLD, 15));
		this.add(botonSalir);

		this.add(fechaMundial);
		fechaMundial.setVisible(false);
		fechaMundial.setDecorationBordersVisible(true);

		// -------Botones con los Accesos a ventanas

		boton1.addActionListener(this);
		boton2.addActionListener(this);
		boton3.addActionListener(this);
		boton10.addActionListener(this);
		boton11.addActionListener(this);
		botonLigaPublica.addActionListener(this);
		botonLigaPrivada.addActionListener(this);
		btnRegistrarLigaPublica.addActionListener(this);
		btnEliminarLigaPublica.addActionListener(this);
		btnRegistrarLigaPrivada.addActionListener(this);
		btnEliminarLigaPrivada.addActionListener(this);
		btnCancelar.addActionListener(this);
		btnRegistrarMundial.addActionListener(this);
		btnRegistroLigaPrivada.addActionListener(this);
		btnRegistroLigaPublica.addActionListener(this);
		btnIncJugLigaPrivada.addActionListener(this);
		botonSalir.addActionListener(this);
		botonEliminarPublicaRegistro.addActionListener(this);
		botonEliminarPrivadaRegistro.addActionListener(this);
		CancelarEliminacionLiga.addActionListener(this);
		botonRegistrarPrivadaRegistro.addActionListener(this);
		

	}

	// ------------------------------------------------------------------------------
/**
 * Metodo del registrar mundial
 */
	public void actionPerformed(ActionEvent e) {

		
		// --------------------------------------------------MUNDIAL------------------------------------------------

		if (e.getSource() == usuariosRegistrados) {

			

			Usuario UsuarioTemporal = Gestor.retornarUsuario((String) usuariosRegistrados.getSelectedItem());

			String opcionEscogida = (String) usuariosRegistrados.getSelectedItem();
			this.setMiUsuario(Gestor.retornarUsuario(this.miUsuario.getNombreUsuario()));
			
			if(this.miUsuario.getNombre() == null) {
				
				
			}
			
			informacionUsuario1.setText("Informacion de Usuario.");
			informacionUsuario2.setText("Nombre del Usuario " + UsuarioTemporal.getNombre());
		
			mostrarInformacionUsuario();
		}
		
		

		if (e.getSource() == boton1) {

			mostrarInformacionUsuario();

			this.add(usuariosRegistrados);
			usuariosRegistrados.setBounds(280, 250, 180, 30);

			this.add(btnCancelar);
			btnCancelar.setBounds(490, 250, 100, 30);

			desabilitarMenu();

		}
		
	

		if (e.getSource() == boton2) {

			desabilitarMenu();

		}

		if (e.getSource() == boton3) {

			registrarMundial();
			desabilitarMenu();

		}

		if (e.getSource() == boton10) {

			Ventana ventanaRegistro = new Ventana(this.miUsuario);

			ventanaRegistro.ventanaRegistroEquipo();

			ventanaRegistro.ventanaRegistroEquipo();
			SwingUtilities.getWindowAncestor(getRootPane()).dispose();



		}

		if (e.getSource() == boton11) {

			Ventana ventanaRegistro = new Ventana(new Usuario("", "", "", "", "", "", 0));
			ventanaRegistro.ventanaRegistroUsuarios();

		}
		
		

		if (e.getSource() == botonEliminarPublicaRegistro) {

			Gestor.eliminarLigaPublica((String) LigasPublicas.getSelectedItem());
			removerMenus();

		}

		if (e.getSource() == botonEliminarPrivadaRegistro) {

			Gestor.eliminarLigaPrivada((String) LigasPrivadas.getSelectedItem());
			removerMenus();

		}

		if (e.getSource() == btnRegistrarMundial) {

			if ("".equals((String) paisesOrganizadores.getSelectedItem()) || nombreMundialTXT.getText().equals("")) {

				JOptionPane.showMessageDialog(null, "Hay campos vacios, debe llenar todos los campos.");

			} else {

				boolean b = false;
				
				try {
					b = controlador.validarLigaMundial((String) paisesOrganizadores.getSelectedItem());
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}

				if (b == false) {

					JOptionPane.showMessageDialog(null, "Este Mundial ya se encuentra registrado.");

				}

				if (b == true) {

					Date fechaDate = fechaMundial.getDate();
					LocalDate fecha = fechaDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
					controlador.registrarMundial(nombreMundialTXT.getText(), fecha,
							(String) paisesOrganizadores.getSelectedItem(), true);

					JOptionPane.showMessageDialog(null, "¡Mundial registrada Exitosamente!.");

					removerMenus();
				}
			}
		}

		if (e.getSource() == btnCancelar) {

			removerMenus();

		}

		if (e.getSource() == CancelarEliminacionLiga) {

			removerMenus();

		}

		// ----------------------------------------------PUBLICAS-----------------------------------------------------------
		
		if (e.getSource() == botonLigaPublica) {

			desabilitarMenu();
			registrarLigaPublicas();
			try {
				ingresarComboBox();
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}

		}

		if (e.getSource() == btnRegistroLigaPublica) {

			if (nombreLigaTXT.getText().equals("") || "".equals((String) MundialAnfitrion.getSelectedItem())) {

				JOptionPane.showMessageDialog(null, "Hay campos vacios, debe llenar todos los campos.");

			}

			else {

				boolean b = false;
				try {
					b = controlador
							.validarMundial(Gestor.retornarMundial((String) MundialAnfitrion.getSelectedItem()));
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}

				if (b == false) {

					JOptionPane.showMessageDialog(null, "Esta Liga ya se encuentra registrada.");

				}

				if (b == true) {

					Date fecha = new Date();
					LocalDate fechaRegistro = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
					controlador.registrarLigaPublicas(nombreLigaTXT.getText(), fechaRegistro, true, 1, 2,
							Gestor.retornarMundial((String) MundialAnfitrion.getSelectedItem()));
					JOptionPane.showMessageDialog(null, "¡Liga Publica registrada Exitosamente!.");

					removerMenus();

				}
			}

		}

		if (e.getSource() == btnEliminarLigaPublica) {

			ingresarLigasPublicas();
			
			this.add(labelTituloEliminarPublica);
			labelTituloEliminarPublica.setForeground(Color.WHITE);
			labelTituloEliminarPublica.setBounds(230, 195, 500, 260);
			labelTituloEliminarPublica.setFont(new Font(labelTituloEliminarPublica.getFont().getFontName(), Font.BOLD, 30));


			this.add(LigasPublicas);
			LigasPublicas.setBounds(990, 300, 120, 30);
			

			botonEliminarPublicaRegistro.setBounds(1120, 300, 100, 30);
			this.add(botonEliminarPublicaRegistro);

			this.add(CancelarEliminacionLiga);
			CancelarEliminacionLiga.setBounds(1230, 300, 100, 30);

			desabilitarMenu();

		}

		// ----------------------------------------------LIGA PRIVADA--------------------------------------------------

		if (e.getSource() == botonLigaPrivada) {

			desabilitarMenu();
			registrarLigaPrivadas();
			try {
				ingresarComboBox();
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}

		}

		if (e.getSource() == btnRegistroLigaPrivada) {

			if (nombreLigaTXT.getText().equals("") || "".equals((String) MundialAnfitrion.getSelectedItem())) {

				JOptionPane.showMessageDialog(null, "Hay campos vacios, debe llenar todos los campos.");

			}

			else {

				boolean b = false;
				try {
					b = controlador
							.validarMundial(Gestor.retornarMundial((String) MundialAnfitrion.getSelectedItem()));
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}

				if (b == false) {

					JOptionPane.showMessageDialog(null, "Esta Liga ya se encuentra registrada.");

				}

				if (b == true) {

					Date fecha = new Date();
					LocalDate fechaRegistro = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
					controlador.registrarLigaPrivadas(nombreLigaTXT.getText(), fechaRegistro, true, 1, 2,
							Gestor.retornarMundial((String) MundialAnfitrion.getSelectedItem()));
					JOptionPane.showMessageDialog(null, "¡Liga Privada registrada Exitosamente!.");
					removerMenus();

				}

			}
		}

		if (e.getSource() == btnIncJugLigaPrivada) {

			try {
				ingresarComboBox();
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}

			this.add(labelNombreUsuario);
			labelNombreUsuario.setForeground(Color.WHITE);
			labelNombreUsuario.setBounds(997, 290, 200, 30);
			labelNombreUsuario.setFont(new Font(labelNombreUsuario.getFont().getFontName(), Font.BOLD, 17));

			this.add(labelNombreLigaPrivada);
			labelNombreLigaPrivada.setForeground(Color.WHITE);
			labelNombreLigaPrivada.setBounds(997, 250, 200, 30);
			labelNombreLigaPrivada.setFont(new Font(labelNombreLigaPrivada.getFont().getFontName(), Font.BOLD, 17));

			this.add(labelTituloIncluir);
			labelTituloIncluir.setForeground(Color.WHITE);
			labelTituloIncluir.setBounds(195, 125, 500, 260);
			labelTituloIncluir.setFont(new Font(labelTituloIncluir.getFont().getFontName(), Font.BOLD, 30));

			this.add(LigasPrivadas);
			LigasPrivadas.setBounds(1080, 250, 180, 22);

			botonRegistrarPrivadaRegistro.setBounds(1080, 330, 80, 25);
			this.add(botonRegistrarPrivadaRegistro);

			this.add(btnCancelar);
			btnCancelar.setBounds(1170, 330, 90, 25);

			this.add(usuariosRegistrados);
			usuariosRegistrados.setBounds(1080, 290, 180, 22);

			desabilitarMenu();

		}

		if (e.getSource() == botonRegistrarPrivadaRegistro) {

			Gestor.asignarLigaPrivadaUsuario((String) usuariosRegistrados.getSelectedItem(),
					Gestor.retornarLigaPrivada((String) LigasPrivadas.getSelectedItem()));
			removerMenus();
		}

		if (e.getSource() == btnEliminarLigaPrivada) {

			ingresarLigasPrivadas();
			
			this.add(labelTituloEliminarPrivada);
			labelTituloEliminarPrivada.setForeground(Color.WHITE);
			labelTituloEliminarPrivada.setBounds(230, 195, 500, 260);
			labelTituloEliminarPrivada.setFont(new Font(labelTituloEliminarPrivada.getFont().getFontName(), Font.BOLD, 30));

			this.add(LigasPrivadas);
			LigasPrivadas.setBounds(990, 300, 120, 30);

			botonEliminarPrivadaRegistro.setBounds(1120, 300, 100, 30);
			this.add(botonEliminarPrivadaRegistro);

			this.add(CancelarEliminacionLiga);
			CancelarEliminacionLiga.setBounds(1230, 300, 100, 30);

			desabilitarMenu();

		}

		if (e.getSource() == botonSalir) {

			Ventana ventLogin = new Ventana(null);
			ventLogin.ventanaLogin();
			SwingUtilities.getWindowAncestor(getRootPane()).dispose();

		}

	}
/**
 * Este metodo muestra los botones y los diferentes componentes
 * de las ligas publicas
 */
	public void registrarLigaPublicas() {

		this.add(labelNombreLiga);
		labelNombreLiga.setForeground(Color.WHITE);
		labelNombreLiga.setBounds(997, 290, 200, 30);
		labelNombreLiga.setFont(new Font(labelNombreLiga.getFont().getFontName(), Font.BOLD, 15));

		this.add(labelTituloPublica);
		labelTituloPublica.setForeground(Color.WHITE);
		labelTituloPublica.setBounds(250, 190, 500, 260);
		labelTituloPublica.setFont(new Font(labelTituloPublica.getFont().getFontName(), Font.BOLD, 30));

		this.add(nombreLigaTXT);
		nombreLigaTXT.setBounds(1100, 250, 160, 22);

		this.add(labelMundialAnfitrion);
		labelMundialAnfitrion.setForeground(Color.WHITE);
		labelMundialAnfitrion.setBounds(997, 250, 200, 30);
		labelMundialAnfitrion.setFont(new Font(labelMundialAnfitrion.getFont().getFontName(), Font.BOLD, 15));

		this.add(MundialAnfitrion);
		MundialAnfitrion.setBounds(1100, 290, 160, 22);

		this.add(btnRegistroLigaPublica);
		btnRegistroLigaPublica.setBounds(1070, 330, 90, 25);

		this.add(btnCancelar);
		btnCancelar.setBounds(1170, 330, 90, 25);

	}
	/**
	 * Este metodo muestra los botones y los diferentes componentes
	 * de las ligas privadas
	 */
	public void registrarLigaPrivadas() {

		this.add(labelNombreLiga);
		labelNombreLiga.setForeground(Color.WHITE);
		labelNombreLiga.setBounds(997, 290, 200, 30);
		labelNombreLiga.setFont(new Font(labelNombreLiga.getFont().getFontName(), Font.BOLD, 15));

		this.add(labelTituloPrivada);
		labelTituloPrivada.setForeground(Color.WHITE);
		labelTituloPrivada.setBounds(250, 190, 500, 260);
		labelTituloPrivada.setFont(new Font(labelTituloPrivada.getFont().getFontName(), Font.BOLD, 30));

		this.add(nombreLigaTXT);
		nombreLigaTXT.setBounds(1100, 250, 160, 22);

		this.add(labelMundialAnfitrion);
		labelMundialAnfitrion.setForeground(Color.WHITE);
		labelMundialAnfitrion.setBounds(997, 250, 200, 30);
		labelMundialAnfitrion.setFont(new Font(labelMundialAnfitrion.getFont().getFontName(), Font.BOLD, 15));

		this.add(MundialAnfitrion);
		MundialAnfitrion.setBounds(1100, 290, 160, 22);

		this.add(btnRegistroLigaPrivada);
		btnRegistroLigaPrivada.setBounds(1070, 330, 90, 25);

		this.add(btnCancelar);
		btnCancelar.setBounds(1170, 330, 90, 25);

	}

	// ----------------------------------MUNDIALES-----------------------------------------------------------------
	/**
	 * Este metodo muestra los botones y los diferentes componentes
	 * del mundial
	 */
	public void registrarMundial() {

		this.add(labelNombreMundial);
		labelNombreMundial.setForeground(Color.WHITE);
		labelNombreMundial.setBounds(810, 25, 200, 30);
		labelNombreMundial.setFont(new Font(labelNombreMundial.getFont().getFontName(), Font.PLAIN, 18));

		this.add(labelTituloMundial);
		labelTituloMundial.setForeground(Color.WHITE);
		labelTituloMundial.setBounds(220, 190, 500, 260);
		labelTituloMundial.setFont(new Font(labelTituloMundial.getFont().getFontName(), Font.BOLD, 30));

		this.add(nombreMundialTXT);
		nombreMundialTXT.setBounds(1000, 30, 300, 20);

		this.add(labelPaisOrganizador);
		labelPaisOrganizador.setForeground(Color.WHITE);
		labelPaisOrganizador.setBounds(810, 65, 200, 30);
		labelPaisOrganizador.setFont(new Font(labelPaisOrganizador.getFont().getFontName(), Font.PLAIN, 18));

		this.add(paisesOrganizadores);
		paisesOrganizadores.setBounds(1000, 70, 300, 20);

		this.add(labelAno);
		labelAno.setForeground(Color.WHITE);
		labelAno.setBounds(900, 185, 200, 30);
		labelAno.setFont(new Font(labelAno.getFont().getFontName(), Font.PLAIN, 20));

		fechaMundial.setBounds(1000, 110, 300, 200);
		fechaMundial.setVisible(true);

		this.add(btnRegistrarMundial);
		btnRegistrarMundial.setBounds(1000, 320, 100, 25);

		this.add(btnCancelar);
		btnCancelar.setBounds(1120, 320, 100, 25);

	}

	// ----------------------------------------------------------------------------

	public void removerMenus() {

		this.remove(labelNombreLiga);
		this.remove(labelTituloPrivada);
		this.remove(labelTituloPublica);
		this.remove(labelTituloMundial);
		this.remove(labelTituloIncluir);
		this.remove(nombreLigaTXT);
		this.remove(labelEstado);
		this.remove(estadoTXT);
		this.remove(btnRegistrarLigaPublica);
		this.remove(btnRegistrarLigaPrivada);
		this.remove(btnCancelar);
		this.remove(labelNombreUsuario);
		this.remove(labelNombreLigaPrivada);
		this.remove(labelTituloEliminarPrivada);
		this.remove(labelTituloEliminarPublica);
		this.remove(usuariosRegistrados);
		this.remove(ligasPrivadasRegistradas);
		this.remove(btnRegistroLigaPublica);
		this.remove(btnRegistrarMundial);
		

		this.remove(labelAno);
		fechaMundial.setVisible(false);
		this.remove(labelPaisOrganizador);
		this.remove(labelMundialAnfitrion);
		this.remove(paisesOrganizadores);
		this.remove(MundialAnfitrion);
		this.remove(labelEstados);
		this.remove(estadosTXT);
		this.remove(btnRegistroLigaPrivada);
		this.remove(LigasPublicas);
		this.remove(LigasPrivadas);
		this.remove(botonEliminarPublicaRegistro);
		this.remove(botonEliminarPrivadaRegistro);
		this.remove(botonRegistrarPrivadaRegistro);

		this.remove(labelNombreMundial);
		this.remove(nombreMundialTXT);
		this.remove(CancelarEliminacionLiga);

		boton1.setEnabled(true);
		boton2.setEnabled(true);
		boton3.setEnabled(true);
		boton10.setEnabled(true);
		boton11.setEnabled(true);
		botonLigaPrivada.setEnabled(true);
		btnEliminarLigaPrivada.setEnabled(true);
		btnIncJugLigaPrivada.setEnabled(true);
		botonLigaPublica.setEnabled(true);
		btnEliminarLigaPublica.setEnabled(true);
		btnRegistrarLigaPrivada.setEnabled(true);
		botonSalir.setEnabled(true);
		LigasPrivadas.setEnabled(true);

	}
/**
 * Este metodo desabilita los botones un vez se halla seleccionado una opcion 
 * en el menu del Admin
 */
	public void desabilitarMenu() {

		boton1.setEnabled(false);
		boton2.setEnabled(false);
		boton3.setEnabled(false);
		boton10.setEnabled(false);
		boton11.setEnabled(false);
		botonLigaPrivada.setEnabled(false);
		btnEliminarLigaPrivada.setEnabled(false);
		btnIncJugLigaPrivada.setEnabled(false);
		botonLigaPublica.setEnabled(false);
		btnEliminarLigaPublica.setEnabled(false);
		btnRegistrarLigaPrivada.setEnabled(false);
		botonSalir.setEnabled(false);

		nombreLigaTXT.setText("");
		estadoTXT.setText("");
		estadosTXT.setText("");
		nombreMundialTXT.setText("");

	}

	// -------------------------------------------------------------------------------------------------

	public void ingresarComboBox() throws SQLException, Exception {

		ingresarPaises();
		ingresarMundiales();
		ingresarLigasPublicas();
		ingresarLigasPrivadas();
		ingresarUsuarios();

	}

	public void ingresarPaises() {//ingreso de paises 

		ArrayList<Equipo> listaTemporal = Gestor.retornarEquiposRegistrados();

		paisesOrganizadores.removeAllItems();

		for (Equipo e : listaTemporal) {

			paisesOrganizadores.addItem(e.getNombre());

		}

	}

	public void ingresarUsuarios() {//Ingreso de usuarios

		ArrayList<Usuario> listaTemporal = Gestor.retornarUsuariosRegistrados();

		usuariosRegistrados.removeAllItems();

		for (Usuario e : listaTemporal) {

			if (e.retornarTipoUsuario() == Perfiles.PLAYER) {

				usuariosRegistrados.addItem(e.getNombreUsuario());

			}

		}

	}

	public void ingresarMundiales() throws SQLException, Exception {

		ArrayList<Mundiales> listaTemporal = Gestor.retornarMundialesRegistrados();

		MundialAnfitrion.removeAllItems();

		for (Mundiales e : listaTemporal) {

			MundialAnfitrion.addItem(e.getNombreMundial());

		}

	}

	public void ingresarLigasPublicas() {//ingreso de las ligas publicas

		ArrayList<LigasPublicas> listaTemporal = Gestor.retornarLigasPublicasRegistrados();

		LigasPublicas.removeAllItems();

		for (LigasPublicas e : listaTemporal) {

			LigasPublicas.addItem(e.getNombreLiga());

		}

	}

	public void ingresarLigasPrivadas() {//ingreso de las ligas privadas

		ArrayList<LigasPrivadas> listaTemporal = Gestor.retornarLigasPrivadasRegistrados();

		LigasPrivadas.removeAllItems();

		for (LigasPrivadas e : listaTemporal) {

			LigasPrivadas.addItem(e.getNombreLiga());

		}

	}
	
	//--------------------------------------------------------------------------------------------------
/**
 * Este metodo muestra la informacion al usuario una vez que se una a una liga en especial
 */
public void mostrarInformacionUsuario() {
		
		this.add(informacionUsuario1);
		informacionUsuario1.setBounds(900,140, 600,40);
		informacionUsuario1.setForeground(Color.ORANGE);
		informacionUsuario1.setFont(new Font(informacionUsuario1.getFont().getFontName(), Font.PLAIN, 30));
		

		this.add(informacionUsuario2);
		informacionUsuario2.setBounds(900,200, 600,40);
		informacionUsuario2.setForeground(Color.ORANGE);
		informacionUsuario2.setFont(new Font(informacionUsuario2.getFont().getFontName(), Font.PLAIN, 30));

}
	
public void setMiUsuario(Usuario miUsuario) {
	this.miUsuario = miUsuario;
}
	
	
	// -------------------------------------------------------------------------------------------------

	public void paintComponent(Graphics g) {

		int width = this.getSize().width;
		int height = this.getSize().height;

		this.setBackground("src\\graficos\\menuAdm.jpg");
		if (this.imagen != null) {
			g.drawImage(this.imagen, 0, 0, width, height, null);
		}

		super.paintComponent(g);
	}

	public void setBackground(String imagePath) {

		this.setOpaque(false);
		this.imagen = new ImageIcon(imagePath).getImage();
		repaint();

	}

	// -------------------------------------------------------------------------------------------------

}
