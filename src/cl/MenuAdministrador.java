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
	
	
	JButton boton1;
	JButton boton2;
	JButton boton3;
	JButton boton10;
	JButton boton11;
	JButton botonLigaPublica;
	JButton botonLigaPrivada;


	private static Gestor controlador = new Gestor();
	private static JLabel labelNombreLiga = new JLabel("Nombre de la Liga: ");
	private static JTextField nombreLigaTXT = new JTextField(10);
	private static JLabel labelEquipos = new JLabel("Participante:");
	private static JTextField equiposTXT = new JTextField(10);
	private static JLabel labelEstado = new JLabel("Estado:");
	private static JTextField estadoTXT = new JTextField(10);
	private static JButton btnRegistrarLigaPublica = new JButton("PRUEBA");
	private static JButton btnRegistrarLigaPrivada = new JButton("");
	private static JButton btnCancelar = new JButton("Cancelar");

	private static Image imagen2;

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

		// -------Botones con los Accesos a vetanas
		boton3.addActionListener(this);
		botonLigaPublica.addActionListener(this);
		botonLigaPrivada.addActionListener(this);
		btnRegistrarLigaPublica.addActionListener(this);
		btnRegistrarLigaPrivada.addActionListener(this);
		btnCancelar.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {

	//--------------------------------------------------MUNDIAL------------------------------------------------	
		
		if (e.getSource() == boton3) {
			//--- esta hace que se queden bloqueados
			registrarMundial();
			boton1.setEnabled(false);
			boton2.setEnabled(false);
			boton3.setEnabled(false);
			boton10.setEnabled(false);
			boton11.setEnabled(false);
			botonLigaPublica.setEnabled(false);
			botonLigaPrivada.setEnabled(false);

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

					this.remove(labelAno);
					this.remove(anoTXT);
					this.remove(labelPaisOrganizador);
					this.remove(paisOrganizadorTXT);
					this.remove(labelEstados);
					this.remove(estadosTXT);
					this.remove(btnRegistrarMundial);
					this.remove(btnCancelar);

					boton1.setEnabled(true);
					boton2.setEnabled(true);
					boton3.setEnabled(true);
					boton10.setEnabled(true);
					boton11.setEnabled(true);
					botonLigaPublica.setEnabled(true);
					

				}
			}
		}
			
			if (e.getSource() == btnCancelar) {

				this.remove(labelAno);
				this.remove(anoTXT);
				this.remove(labelPaisOrganizador);
				this.remove(paisOrganizadorTXT);
				this.remove(labelEstados);
				this.remove(estadosTXT);
				this.remove(btnRegistrarMundial);
				this.remove(btnCancelar);

				boton1.setEnabled(true);
				boton2.setEnabled(true);
				boton3.setEnabled(true);
				boton10.setEnabled(true);
				boton11.setEnabled(true);
				btnRegistrarLigaPublica.setEnabled(true);
				botonLigaPublica.setEnabled(true);
				

				
			}
			
		

	//----------------------------------------------PUBLICAS-----------------------------------------------------------
		
			if (e.getSource() == botonLigaPublica) {

			registrarLigaPublicas();
			boton1.setEnabled(false);
			boton2.setEnabled(false);
			boton3.setEnabled(false);
			boton10.setEnabled(false);
			boton11.setEnabled(false);
			btnRegistrarLigaPublica.setEnabled(false);//-- esto hace que aparesca habilitado en el formulario
			
		}

		if (e.getSource() == btnRegistrarLigaPublica) {

			
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
					//botonLigaPublica.setEnabled(true);
					//btnRegistrarLigaPrivada.setEnabled(true);

				}
			}
		}

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
			//botonLigaPublica.setEnabled(true);
			//btnRegistrarLigaPublica.setEnabled(true);

		}
		
		// ----------------------------------------------LIGA PRIVADA--------------------------------------------------

		
	  
		
		if (e.getSource() == botonLigaPrivada) {

			registrarLigaPrivadas();
			boton1.setEnabled(false);
			boton2.setEnabled(false);
			boton3.setEnabled(false);
			boton10.setEnabled(false);
			boton11.setEnabled(false);
			btnRegistrarLigaPrivada.setEnabled(false);
		}
		
		
		if (e.getSource() == btnRegistrarLigaPrivada) {

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
					botonLigaPrivada.setEnabled(true);
					btnRegistrarLigaPrivada.setEnabled(true);

				}
			
			}
		 }
		if (e.getSource() == btnCancelar) {

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
			botonLigaPrivada.setEnabled(true);
			btnRegistrarLigaPrivada.setEnabled(true);

		}
   }
	

	private static Image imagen;

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

	public void registrarLigaPublicas() {

		
		this.setBackground(Color.CYAN);

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

		this.add(botonLigaPublica);
		botonLigaPublica.setBounds(1000, 200, 190, 25);

		this.add(btnCancelar);
		btnCancelar.setBounds(1199, 200, 160, 25);

		botonLigaPublica.addActionListener(this);

	}

	public void registrarLigaPrivadas() {

		
		this.setBackground(Color.CYAN);

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

		this.add(botonLigaPrivada);
		botonLigaPrivada.setBounds(1000, 200, 190, 25);

		this.add(btnCancelar);
		btnCancelar.setBounds(1199, 200, 160, 25);

		botonLigaPrivada.addActionListener(this);

	}
	
	//----------------------------------MUNDIALES-----------------------------------------------------------------

	 
	
	private static JLabel labelAno = new JLabel("Año: ");
	private static JTextField anoTXT = new JTextField(10);
	
	private static JLabel labelPaisOrganizador = new JLabel("Pais Organizador:");
	private static JTextField paisOrganizadorTXT = new JTextField(10);
	
	private static JLabel labelEstados = new JLabel("Estado:");
	private static JTextField estadosTXT = new JTextField(10);
	
	private static JButton btnRegistrarMundial = new JButton("Registrar");
	
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
		
		btnRegistrarMundial.addActionListener(this);
		
		
		
		
		
    }
	
	

	
	
	
	
}
