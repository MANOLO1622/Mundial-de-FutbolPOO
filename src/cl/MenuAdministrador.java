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

public class MenuAdministrador extends JPanel implements ActionListener{
	
	
	JButton boton1;
	JButton boton2;
	JButton boton3;
	JButton boton10;
	JButton boton11;
	JButton boton12;
	JButton boton13;
	

	private static Gestor controlador = new Gestor(); 
	private static JLabel labelNombreLiga = new JLabel("Nombre de la Liga: ");
	private static JTextField nombreLigaTXT = new JTextField(10);
	private static JLabel labelEquipos = new JLabel("Participante:");
	private static JTextField equiposTXT = new JTextField(10);
	private static JLabel labelEstado = new JLabel("Estado:");
	private static JTextField estadoTXT = new JTextField(10);
	private static JButton btnRegistrarLiga = new JButton("Registrar Liga");
	private static JButton btnCancelar = new JButton("Cancelar.");
	
    private static Image imagen2;
	
	
	public MenuAdministrador() {
		boton1 = new JButton("Usuarios");
		this.setLayout(null);
		boton1.setBounds(10, 50, 180, 50);
		this.add(boton1);
		
		
		boton2 = new JButton("Apuestas");
		this.setLayout(null);
		boton2.setBounds(10, 115, 180, 50);
		this.add(boton2);
		
		boton3 = new JButton("Crear mundial");
		this.setLayout(null);
		boton3.setBounds(10, 185, 180, 50);
		this.add(boton3);
		
		boton10 = new JButton("Crear equipos");
		this.setLayout(null);
		boton10.setBounds(10, 255, 180, 50);
		this.add(boton10);
		
		boton11 = new JButton("Crear jugadores");
		this.setLayout(null);
		boton11.setBounds(10, 325, 180, 50);
		this.add(boton11);
		
		
		boton12 = new JButton("Crear liga publica");
		this.setLayout(null);
		boton12.setBounds(10, 400, 180, 50);
		this.add(boton12);
		
		boton13 = new JButton("Crear liga privada");
		this.setLayout(null);
		boton13.setBounds(10, 475, 180, 50);
		this.add(boton13);
		
		
		//-------Botones con los Accesos a vetanas
		boton3.addActionListener(this);
		boton12.addActionListener(this);
		btnRegistrarLiga.addActionListener(this);
		btnCancelar.addActionListener(this);
		
		
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==boton3) {
        
        	Ventana ventanaRegistro = new Ventana();
    		ventanaRegistro.ventanaRegistroMundiales();
    		ventanaRegistro.setExtendedState(Ventana.MAXIMIZED_BOTH);
            
		}
		
		if(e.getSource()==boton12) {
			
			registrarLigaPublicas();
			boton1.setEnabled(false);			
			boton2.setEnabled(false);			
			boton3.setEnabled(false);			
			boton10.setEnabled(false);			
			boton11.setEnabled(false);				
			boton12.setEnabled(false);			
			boton13.setEnabled(false); 
		}
		
		if(e.getSource()==btnRegistrarLiga) {
			
					
			if(nombreLigaTXT.getText().equals("") || equiposTXT.getText().equals("") || estadoTXT.getText().equals("")) {
				
				JOptionPane.showMessageDialog(null, "Hay campos vacios, debe llenar todos los campos.");
						
			}
			
			else {
				
				boolean b = controlador.validarLigaPublica(nombreLigaTXT.getText());
				
				if (b == false) {
					
					JOptionPane.showMessageDialog(null, "Esta Liga ya se encuentra registrada.");
					
				}
				
				if(b == true) {
				
					Date fecha = new Date();
					LocalDate fechaRegistro = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
					
					controlador.registrarLigaPublicas(nombreLigaTXT.getText(),fechaRegistro, true, 1, 2);
					controlador.listarLigasPublicas();
					
					JOptionPane.showMessageDialog(null, "¡Liga registrada Exitosamente!.");
					
					this.remove(labelNombreLiga);
					this.remove(nombreLigaTXT);
					this.remove(labelEquipos);
					this.remove(equiposTXT);
					this.remove(labelEstado);
					this.remove(estadoTXT);
					this.remove(btnRegistrarLiga);
					
					boton1.setEnabled(true);			
					boton2.setEnabled(true);			
					boton3.setEnabled(true);			
					boton10.setEnabled(true);			
					boton11.setEnabled(true);				
					boton12.setEnabled(true);			
					boton13.setEnabled(true); 
				
			
				}
			}
			
			
			
			
		}
		
		if(e.getSource()==btnCancelar) {
			
			this.remove(labelNombreLiga);
			this.remove(nombreLigaTXT);
			this.remove(labelEquipos);
			this.remove(equiposTXT);
			this.remove(labelEstado);
			this.remove(estadoTXT);
			this.remove(btnRegistrarLiga);
			this.remove(btnCancelar);
			
			boton1.setEnabled(true);			
			boton2.setEnabled(true);			
			boton3.setEnabled(true);			
			boton10.setEnabled(true);			
			boton11.setEnabled(true);				
			boton12.setEnabled(true);			
			boton13.setEnabled(true);
			
			
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
	

    
    public void registrarLigaPublicas(){
    	

    	this.setLayout(null);
		this.setBackground(Color.CYAN);
		
		this.add(labelNombreLiga);
		labelNombreLiga.setForeground(Color.WHITE);
		labelNombreLiga.setBounds(950,30,200,30);
		
		this.add(nombreLigaTXT);
		nombreLigaTXT.setBounds(1080,30,200,20);
		
		this.add(labelEquipos);
		labelEquipos.setForeground(Color.WHITE);
		labelEquipos.setBounds(950,70,200,30);
		
		this.add(equiposTXT);
		equiposTXT.setBounds(1080,70,200,20);

		
		this.add(labelEstado);
		labelEstado.setForeground(Color.WHITE);
		labelEstado.setBounds(950,110,200,30);
		
		this.add(estadoTXT);
		estadoTXT.setBounds(1080,110,200,20);
		
		this.add(btnRegistrarLiga);
		btnRegistrarLiga.setBounds(950, 200, 120, 25);
		
		this.add(btnCancelar);
		btnCancelar.setBounds(1080, 200, 120, 25);
		
		btnRegistrarLiga.addActionListener(this);
    	
    }
    
    
    
}












