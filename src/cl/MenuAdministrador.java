package cl;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.swing.*;
import gestor.*;

public class MenuAdministrador extends JPanel implements ActionListener {

	public Usuario miUsuario;
	private static Image imagen;
	
	JButton boton1;
	JButton boton2;
	JButton boton3;
	JButton boton10;
	JButton boton11;
	JButton botonLigaPublica;
	JButton botonLigaPrivada;


	Gestor controlador = new Gestor();
	JLabel labelNombreLiga = new JLabel("Nombre de la Liga: ");
	JTextField nombreLigaTXT = new JTextField(10);
	JLabel labelEquipos = new JLabel("Participante:");
	JTextField equiposTXT = new JTextField(10);
	JLabel labelEstado = new JLabel("Estado:");
	JTextField estadoTXT = new JTextField(10);
	
	JLabel labelAno = new JLabel("Año: ");
	JTextField anoTXT = new JTextField(10);
	JLabel labelPaisOrganizador = new JLabel("Pais Organizador:");
	JTextField paisOrganizadorTXT = new JTextField(10);
	JLabel labelEstados = new JLabel("Estado:");
	JTextField estadosTXT = new JTextField(10);
	
	JButton btnRegistrarLigaPublica = new JButton("PRUEBA");
	JButton btnRegistrarLigaPrivada = new JButton("");
	JButton btnCancelar = new JButton("Cancelar");
	JButton btnRegistrarMundial = new JButton("Registrar");
	JButton btnRegistroLigaPublica = new JButton("Registrar");
	JButton btnRegistroLigaPrivada = new JButton("Registrar");

	private static Image imagen2;

	
	//------------------------------------------------------------------------------
	
	
	public MenuAdministrador(Usuario miUsuario) {
		
		this.miUsuario = miUsuario;
		
		
		boton1 = new JButton("Usuarios");
		this.setLayout(null);
		boton1.setBounds(10, 50, 180, 50);
		this.add(boton1);

		boton2 = new JButton("Apuestas");
		boton2.setBounds(10, 115, 180, 50);
		this.add(boton2);

		boton3 = new JButton("Crear mundial");
		boton3.setBounds(10, 185, 180, 50);
		this.add(boton3);

		boton10 = new JButton("Crear equipos");
		boton10.setBounds(10, 255, 180, 50);
		this.add(boton10);

		boton11 = new JButton("Crear jugadores");
		boton11.setBounds(10, 325, 180, 50);
		this.add(boton11);

		botonLigaPublica = new JButton("Crear liga publica");
		botonLigaPublica.setBounds(10, 400, 180, 50);
		this.add(botonLigaPublica);

		botonLigaPrivada = new JButton("Registrar liga privada");
		botonLigaPrivada.setBounds(10, 475, 180, 50);
		this.add(botonLigaPrivada);

		// -------Botones con los Accesos a ventanas
		boton3.addActionListener(this);
		botonLigaPublica.addActionListener(this);
		botonLigaPrivada.addActionListener(this);
		btnRegistrarLigaPublica.addActionListener(this);
		btnRegistrarLigaPrivada.addActionListener(this);
		btnCancelar.addActionListener(this);
		btnRegistrarMundial.addActionListener(this);
		btnRegistroLigaPrivada.addActionListener(this);
		btnRegistroLigaPublica.addActionListener(this);

	}
	
	//------------------------------------------------------------------------------
	

	public void actionPerformed(ActionEvent e) {

	//--------------------------------------------------MUNDIAL------------------------------------------------	
		
		if (e.getSource() == boton3) {
			
			registrarMundial();

		}

		if (e.getSource() == btnRegistrarMundial) {

			if (anoTXT.getText().equals("") || paisOrganizadorTXT.getText().equals("")
					|| estadosTXT.getText().equals("")) {

				JOptionPane.showMessageDialog(null, "Hay campos vacios, debe llenar todos los campos.");

			}
			else {

				boolean b = controlador.validarLigaMundial(paisOrganizadorTXT.getText());

				if (b == false) {

					JOptionPane.showMessageDialog(null, "Este Mundial ya se encuentra registrado.");

				}
				
				if (b == true) {

					Date fecha = new Date();
					LocalDate fechaRegistro = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

					controlador.registrarMundial(fechaRegistro, paisOrganizadorTXT.getText(), true);
					controlador.listarMundiales();

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
			
		}

		if (e.getSource() == btnRegistroLigaPublica) {

			
			if (nombreLigaTXT.getText().equals("") || equiposTXT.getText().equals("")
					|| estadoTXT.getText().equals("")) {

				JOptionPane.showMessageDialog(null, "Hay campos vacios, debe llenar todos los campos.");

			}
		

			else {

				boolean b = controlador.validarLigaPublica(nombreLigaTXT.getText());

				if (b == false) {

					JOptionPane.showMessageDialog(null, "Esta Liga ya se encuentra registrada.");

				}
			
		
				if (b == true) {

					Date fecha = new Date();
					LocalDate fechaRegistro = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

					controlador.registrarLigaPublicas( nombreLigaTXT.getText(),fechaRegistro, true,1,2);
					controlador.listarLigasPublicas();

					JOptionPane.showMessageDialog(null, "¡Liga Publica registrada Exitosamente!.");

<<<<<<< HEAD
					this.remove(labelNombreLiga);
					this.remove(nombreLigaTXT);
					this.remove(labelEquipos);
					this.remove(equiposTXT);
					this.remove(labelEstado);
					this.remove(estadoTXT);
					this.remove(btnCancelar);

					
					
					

					boton1.setEnabled(true);
					boton2.setEnabled(true);
					boton3.setEnabled(true);
					boton10.setEnabled(true);
					boton11.setEnabled(true);
					botonLigaPublica.setEnabled(true);
					btnRegistrarLigaPrivada.setEnabled(true);
=======
					removerMenus();
>>>>>>> refs/remotes/origin/master

				}
			}
		}
<<<<<<< HEAD

		if (e.getSource() == btnCancelar) {
			//--- REMUEVE LO BOTONES DEL FORMULARIO
			this.remove(labelNombreLiga);
			this.remove(nombreLigaTXT);
			this.remove(labelEquipos);
			this.remove(equiposTXT);
			this.remove(labelEstado);
			this.remove(estadoTXT);
			this.remove(btnCancelar);
			

			boton1.setEnabled(true);
			boton2.setEnabled(true);
			boton3.setEnabled(true);
			boton10.setEnabled(true);
			boton11.setEnabled(true);
			botonLigaPublica.setEnabled(true);
			btnRegistrarLigaPublica.setEnabled(true);

		}
=======
>>>>>>> refs/remotes/origin/master
		
		// ----------------------------------------------LIGA PRIVADA--------------------------------------------------

		
	  
		
		if (e.getSource() == botonLigaPrivada) {

			registrarLigaPrivadas();
			desabilitarMenu();
		}
		
		
		if (e.getSource() == btnRegistroLigaPrivada) {

			if (nombreLigaTXT.getText().equals("") || equiposTXT.getText().equals("")
					|| estadoTXT.getText().equals("")) {

				JOptionPane.showMessageDialog(null, "Hay campos vacios, debe llenar todos los campos.");

			}

			else {

				boolean b = controlador.validarLigaPrivada(nombreLigaTXT.getText());

				if (b == false) {

					JOptionPane.showMessageDialog(null, "Esta Liga ya se encuentra registrada.");

				}
				
				if (b == true) {

					Date fecha = new Date();
					LocalDate fechaRegistro = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

					controlador.registrarLigaPrivadas(nombreLigaTXT.getText(), fechaRegistro, true, 1, 2);
					controlador.listarLigasPrivadas();

					JOptionPane.showMessageDialog(null, "¡Liga Privada registrada Exitosamente!.");

					removerMenus();

				}
			
			}
		 }
   }//prueba



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

		this.add(labelEstado);
		labelEstado.setForeground(Color.WHITE);
		labelEstado.setBounds(950, 110, 200, 30);

		this.add(estadoTXT);
		estadoTXT.setBounds(1080, 110, 200, 20);

		this.add(btnRegistroLigaPublica);
		btnRegistroLigaPublica.setBounds(1000, 200, 190, 25);

		this.add(btnCancelar);
		btnCancelar.setBounds(1199, 200, 160, 25);

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

		this.add(labelEstado);
		labelEstado.setForeground(Color.WHITE);
		labelEstado.setBounds(950, 110, 200, 30);

		this.add(estadoTXT);
		estadoTXT.setBounds(1080, 110, 200, 20);

		this.add(btnRegistroLigaPrivada);
		btnRegistroLigaPrivada.setBounds(1000, 200, 190, 25);

		this.add(btnCancelar);
		btnCancelar.setBounds(1199, 200, 160, 25);


	}
	
	//----------------------------------MUNDIALES-----------------------------------------------------------------


	public void registrarMundial () {
    		
		this.add(labelAno);
		labelAno.setForeground(Color.WHITE);
		labelAno.setBounds(950, 30, 200, 30);
		
		this.add(anoTXT);
		anoTXT.setBounds(1080, 30, 200, 20);
		
		this.add(labelPaisOrganizador);
		labelPaisOrganizador.setForeground(Color.WHITE);
		labelPaisOrganizador.setBounds(950, 70, 200, 30);
		
		this.add(paisOrganizadorTXT);
		paisOrganizadorTXT.setBounds(1080, 70, 200, 20);
		
		this.add(labelEstados);
		labelEstados.setForeground(Color.WHITE);
		labelEstados.setBounds(950, 110, 200, 30);
		
		this.add(estadosTXT);
		estadosTXT.setBounds(1080, 110, 200, 20);
		
		this.add(btnRegistrarMundial);
		btnRegistrarMundial.setBounds(950, 200, 120, 25);
		
		this.add(btnCancelar);
		btnCancelar.setBounds(1080, 200, 120, 25);
		
			
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
		this.remove(anoTXT);
		this.remove(labelPaisOrganizador);
		this.remove(paisOrganizadorTXT);
		this.remove(labelEstados);
		this.remove(estadosTXT);
		this.remove(btnRegistroLigaPrivada);
		
		
		boton1.setEnabled(true);
		boton2.setEnabled(true);
		boton3.setEnabled(true);
		boton10.setEnabled(true);
		boton11.setEnabled(true);
		botonLigaPrivada.setEnabled(true);
		botonLigaPublica.setEnabled(true);
		btnRegistrarLigaPrivada.setEnabled(true);
		
		
	}
	
	public void desabilitarMenu() {
		
		boton1.setEnabled(false);
		boton2.setEnabled(false);
		boton3.setEnabled(false);
		boton10.setEnabled(false);
		boton11.setEnabled(false);
		botonLigaPublica.setEnabled(false);
		botonLigaPrivada.setEnabled(false);
		
		nombreLigaTXT.setText("");
		equiposTXT.setText("");
		estadoTXT.setText("");
		anoTXT.setText("");
		paisOrganizadorTXT.setText("");
		estadosTXT.setText("");
		
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
