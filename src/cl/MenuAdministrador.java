package cl;

import java.awt.*;
import java.awt.event.*;
import java.time.*;
import java.util.*;
import javax.swing.*;
import com.toedter.calendar.*;
import gestor.*;


public class MenuAdministrador extends JPanel implements ActionListener {

	
	
	public Usuario miUsuario;
	private static Image imagen;
	
	
	
	JButton boton1  = new JButton("Usuarios");
	JButton boton2 = new JButton("Apuestas");
	JButton boton3 = new JButton("Crear mundial");
	JButton boton10 = new JButton("Crear equipos");
	JButton boton11 = new JButton("Crear jugadores");
	JButton botonLigaPublica = new JButton("Crear liga publica");
	JButton btnEliminarLigaPublica = new JButton("Eliminar Liga Publica");
	JButton botonLigaPrivada = new JButton("Crear liga privada");
	JButton btnEliminarLigaPrivada = new JButton("Eliminar Liga Privada");
	JButton btnIncJugLigaPrivada = new JButton("Incluir en LigaPrivada");
	JButton botonSalir = new JButton("Salir");
	

	//----------------------------------------------------------------------
	
	Gestor controlador = new Gestor();
	JLabel labelNombreLiga = new JLabel("Nombre de la Liga: ");
	JTextField nombreLigaTXT = new JTextField(10);
	JLabel labelEquipos = new JLabel("Participante:");
	JTextField equiposTXT = new JTextField(10);
	JLabel labelEstado = new JLabel("Estado:");
	JTextField estadoTXT = new JTextField(10);
	
	JLabel labelNombreMundial = new JLabel("Nombre del Mundial:");
	JTextField nombreMundialTXT = new JTextField();
	
	JLabel labelAno = new JLabel("Fecha: ");	
	JCalendar fechaMundial = new JCalendar();	
	
	JLabel labelPaisOrganizador = new JLabel("Pais Organizador:");
	JComboBox paisesOrganizadores = new JComboBox();
	JLabel labelMundialAnfitrion = new JLabel("Pais Anfitrión:");
	JComboBox MundialAnfitrion = new JComboBox();
	JLabel labelEstados = new JLabel("Estado:");
	JTextField estadosTXT = new JTextField(10);
	
	JButton btnRegistrarLigaPublica = new JButton("Registrar");
	JButton btnRegistrarLigaPrivada = new JButton("");
	JButton btnCancelar = new JButton("Cancelar");
	JButton btnRegistrarMundial = new JButton("Registrar");
	JButton btnRegistroLigaPublica = new JButton("Registrar");
	JButton btnRegistroLigaPrivada = new JButton("Registrar");
	JButton btnSalir = new JButton("Salir");


	private static Image imagen2;

	
	//------------------------------------------------------------------------------
	
	
	public MenuAdministrador(Usuario miUsuario) {
		
		this.miUsuario = miUsuario;
		ingresarComboBox();
		this.setLayout(null);
		
		
		
		
		boton1.setBounds(10, 50, 180, 50);
		this.add(boton1);

		boton2.setBounds(10, 120, 180, 50);
		this.add(boton2);

		boton3.setBounds(10, 190, 180, 50);
		this.add(boton3);

		boton10.setBounds(10, 260, 180, 50);
		this.add(boton10);

		boton11.setBounds(10, 330, 180, 50);
		this.add(boton11);

		botonLigaPublica.setBounds(10, 400, 180, 50);
		this.add(botonLigaPublica);
		
		btnEliminarLigaPublica.setBounds(10, 470,  180, 50);
		this.add(btnEliminarLigaPublica);

		botonLigaPrivada.setBounds(10, 540, 180, 50);
		this.add(botonLigaPrivada);
		
		btnIncJugLigaPrivada.setBounds(10, 620, 180, 50);
		this.add(btnIncJugLigaPrivada);
		
		btnEliminarLigaPrivada.setBounds(210, 620,  180, 50);
		this.add(btnEliminarLigaPrivada);
			
		botonSalir.setBounds(1190, 650, 160, 50);
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
	}
	
	//------------------------------------------------------------------------------
	

	public void actionPerformed(ActionEvent e) {

	//--------------------------------------------------MUNDIAL------------------------------------------------	
		
		if (e.getSource() == boton1) {
			
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
			
			JOptionPane.showMessageDialog(null, "Arreglelo");

		}
		
		if(e.getSource()==boton11) {
			
			Ventana ventanaRegistro = new Ventana(new Usuario("", "", "", "", "", "", 0));
			ventanaRegistro.ventanaRegistroUsuarios();
			
		}

		if (e.getSource() == btnRegistrarMundial) {

			
			if ("".equals((String)paisesOrganizadores.getSelectedItem())
					|| nombreMundialTXT.getText().equals("")) {

				JOptionPane.showMessageDialog(null, "Hay campos vacios, debe llenar todos los campos.");

			}
			else {

				boolean b = controlador.validarLigaMundial((String)paisesOrganizadores.getSelectedItem());

				if (b == false) {

					JOptionPane.showMessageDialog(null, "Este Mundial ya se encuentra registrado.");

				}
				
				if (b == true) {

					Date fecha = fechaMundial.getDate();
					controlador.registrarMundial(nombreMundialTXT.getText(), fecha, (String)paisesOrganizadores.getSelectedItem(), true);

					JOptionPane.showMessageDialog(null, "¡Mundial registrada Exitosamente!.");
					
					

					removerMenus();
				}
			}
		}
			
		if (e.getSource() == btnCancelar) {

				removerMenus();
				
		}
			
		

	//----------------------------------------------PUBLICAS-----------------------------------------------------------
		
		if (e.getSource() == botonLigaPublica) {

				desabilitarMenu();
				registrarLigaPublicas();
				ingresarComboBox();

			
		}

		if (e.getSource() == btnRegistroLigaPublica) {
			
			if (nombreLigaTXT.getText().equals("") || equiposTXT.getText().equals("")
					|| "".equals((String)MundialAnfitrion.getSelectedItem())) {

				JOptionPane.showMessageDialog(null, "Hay campos vacios, debe llenar todos los campos.");

			}
		

			else {
				
				boolean b = controlador.validarMundial( Gestor.retornarMundial((String)MundialAnfitrion.getSelectedItem()));

				if (b == false) {

					JOptionPane.showMessageDialog(null, "Esta Liga ya se encuentra registrada.");

				}
			
		
				if (b == true) {
					
					Date fecha = new Date();
					LocalDate fechaRegistro = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
					controlador.registrarLigaPublicas(nombreLigaTXT.getText(),fechaRegistro, true,1,2,Gestor.retornarMundial((String)MundialAnfitrion.getSelectedItem()));
					JOptionPane.showMessageDialog(null, "¡Liga Publica registrada Exitosamente!.");

					removerMenus();


				}
			}

		}
		
		if(e.getSource() == btnEliminarLigaPublica) {
			
			Gestor.eliminarLigaPublica("a");
			
		}


		if (e.getSource() == btnCancelar) {
			
			removerMenus();
			
		}


		

		
		// ----------------------------------------------LIGA PRIVADA--------------------------------------------------

		
	  
		
		if (e.getSource() == botonLigaPrivada) {

			registrarLigaPrivadas();
			desabilitarMenu();
			ingresarComboBox();
		}
		
		
		if (e.getSource() == btnRegistroLigaPrivada) {

			if (nombreLigaTXT.getText().equals("") || equiposTXT.getText().equals("")
					|| "".equals((String)MundialAnfitrion.getSelectedItem())) {

				JOptionPane.showMessageDialog(null, "Hay campos vacios, debe llenar todos los campos.");

			}

			else {
				
				boolean b = controlador.validarMundial(Gestor.retornarMundial((String)MundialAnfitrion.getSelectedItem()));

				if (b == false) {

					JOptionPane.showMessageDialog(null, "Esta Liga ya se encuentra registrada.");

				}
				
				if (b == true) {

					Date fecha = new Date();
					LocalDate fechaRegistro = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
					controlador.registrarLigaPrivadas(nombreLigaTXT.getText(), fechaRegistro, true, 1, 2,Gestor.retornarMundial((String)MundialAnfitrion.getSelectedItem()));
					controlador.listarLigasPrivadas();

					JOptionPane.showMessageDialog(null, "¡Liga Privada registrada Exitosamente!.");
					
					removerMenus();

				}
			
			}
		 }
		
		
		if(e.getSource()==btnIncJugLigaPrivada) {
			

			Gestor.asignarLigaPrivadaUsuario("j",Gestor.retornarLigaPrivada("q"));
			JOptionPane.showMessageDialog(null, Gestor.retornarUsuario("j").toString());
			
		}
		
		
		
		if(e.getSource() == btnEliminarLigaPrivada) {
			
			
			
		}
		
		if(e.getSource() == botonSalir) {
			
			Ventana ventLogin = new Ventana(null);
			ventLogin.ventanaLogin();
			SwingUtilities.getWindowAncestor(getRootPane()).dispose();
			
		}
		
		
		

		
   }



	public void registrarLigaPublicas() {

		this.add(labelNombreLiga);
		labelNombreLiga.setForeground(Color.WHITE);
		labelNombreLiga.setBounds(950, 30, 200, 30);

		this.add(nombreLigaTXT);
		nombreLigaTXT.setBounds(1080, 30, 200, 20);

		this.add(labelEquipos);
		labelEquipos.setForeground(Color.WHITE);
		labelEquipos.setBounds(950, 70, 200, 30);

		this.add(equiposTXT);
		equiposTXT.setBounds(1080, 70, 200, 20);

		this.add(labelMundialAnfitrion);
		labelMundialAnfitrion.setForeground(Color.WHITE);
		labelMundialAnfitrion.setBounds(950, 110, 200, 30);
		
		this.add(MundialAnfitrion);
		MundialAnfitrion.setBounds(1080, 110, 200, 20);

		this.add(btnRegistroLigaPublica);
		btnRegistroLigaPublica.setBounds(950, 200, 120, 25);

		this.add(btnCancelar);
		btnCancelar.setBounds(1080, 200, 120, 25);

	}

	public void registrarLigaPrivadas() {

		this.add(labelNombreLiga);
		labelNombreLiga.setForeground(Color.WHITE);
		labelNombreLiga.setBounds(950, 30, 200, 30);

		this.add(nombreLigaTXT);
		nombreLigaTXT.setBounds(1080, 30, 200, 20);

		this.add(labelEquipos);
		labelEquipos.setForeground(Color.WHITE);
		labelEquipos.setBounds(950, 70, 200, 30);

		this.add(equiposTXT);
		equiposTXT.setBounds(1080, 70, 200, 20);

		this.add(labelMundialAnfitrion);
		labelMundialAnfitrion.setForeground(Color.WHITE);
		labelMundialAnfitrion.setBounds(950, 110, 200, 30);
		
		this.add(MundialAnfitrion);
		MundialAnfitrion.setBounds(1080, 110, 200, 20);

		this.add(btnRegistroLigaPrivada);
		btnRegistroLigaPrivada.setBounds(950, 200, 120, 25);

		this.add(btnCancelar);
		btnCancelar.setBounds(1080, 200, 120, 25);


	}
	
	//----------------------------------MUNDIALES-----------------------------------------------------------------


	public void registrarMundial() {
		
		this.add(labelNombreMundial);
		labelNombreMundial.setForeground(Color.WHITE);
		labelNombreMundial.setBounds(900, 30, 200, 30);
		
		this.add(nombreMundialTXT);
		nombreMundialTXT.setBounds(1050, 30, 300, 20);
		
		this.add(labelPaisOrganizador);
		labelPaisOrganizador.setForeground(Color.WHITE);
		labelPaisOrganizador.setBounds(900, 70, 200, 30);
		
		this.add(paisesOrganizadores);
		paisesOrganizadores.setBounds(1050, 70, 300, 20);
		
		this.add(labelAno);
		labelAno.setForeground(Color.WHITE);
		labelAno.setBounds(900, 175, 200, 30);
		
		fechaMundial.setBounds(1050, 110, 300, 300);
		fechaMundial.setVisible(true);

		this.add(btnRegistrarMundial);
		btnRegistrarMundial.setBounds(900, 420, 120, 25);
		
		this.add(btnCancelar);
		btnCancelar.setBounds(1050, 420, 120, 25);
			
    }
	
	
	//----------------------------------------------------------------------------
	
	public void removerMenus() {
		
		this.remove(labelNombreLiga);
		this.remove(nombreLigaTXT);
		this.remove(labelEquipos);
		this.remove(equiposTXT);
		this.remove(labelEstado);
		this.remove(estadoTXT);
		this.remove(btnRegistrarLigaPublica);
		this.remove(btnRegistrarLigaPrivada);
		this.remove(btnCancelar);
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
		
		this.remove(labelNombreMundial);
		this.remove(nombreMundialTXT);
		
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
		
	
	}
	
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
		equiposTXT.setText("");
		estadoTXT.setText("");
		estadosTXT.setText("");
		nombreMundialTXT.setText("");
		
	}
	

	
	// -------------------------------------------------------------------------------------------------
	
	
	public void ingresarComboBox() {
		
		ingresarPaises();
		ingresarMundiales();
		
	}
	
	public void ingresarPaises() {
		
		ArrayList<Equipo> listaTemporal = Gestor.retornarEquiposRegistrados();
		
		paisesOrganizadores.removeAllItems();
		
		for(Equipo e: listaTemporal) {
			
			paisesOrganizadores.addItem(e.getNombre());
			
		}
		
	}
	
	public void ingresarMundiales() {
		
		ArrayList<Mundiales> listaTemporal = Gestor.retornarMundialesRegistrados();
		
		MundialAnfitrion.removeAllItems();
		
		for(Mundiales e: listaTemporal) {	
			
			MundialAnfitrion.addItem(e.getNombreMundial());
			
		}
		
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
	

