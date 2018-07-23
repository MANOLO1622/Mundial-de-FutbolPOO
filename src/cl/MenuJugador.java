package cl;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class MenuJugador extends JPanel implements ActionListener{
	
	private static Image imagen;
	
	JButton boton4;
	JButton boton5;
	JButton boton6;
	JButton boton7;
	JButton boton8;
	
	JComboBox ligasRegistradas = new JComboBox();
	JButton UnirseLiga = new JButton("Unirse");
	
	JLabel informacionLiga = new JLabel("Informacion de la Liga\n");
	
	
	
    

	public MenuJugador() {
		
		this.setLayout(null);
		
		boton4 = new JButton("Jugar");
		boton4.setBounds(10, 50, 180, 50);
		this.add(boton4);
		
		boton5 = new JButton("Unirse a liga Publica");
		boton5.setBounds(10, 120, 180, 50);
		this.add(boton5);
		
		boton6 = new JButton("Retirarse de Liga");
		boton6.setBounds(10, 190, 180, 50);
		this.add(boton6);
		
		boton7 = new JButton("Cronograma");
		boton7.setBounds(10, 260, 180, 50);
		this.add(boton7);
		
		boton8 = new JButton("Salir");
		boton8.setBounds(10, 330, 180, 50);
		this.add(boton8);
		
		
		boton5.addActionListener(this);
		ligasRegistradas.addActionListener(this);
		UnirseLiga.addActionListener(this);
	}
	
	//------------------------------------------------------------------------------------------------- 
	

	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
		
		CL capaLogica = new CL();
		ArrayList<LigasPublicas> listaLigasPublicas = capaLogica.listaLigasPublicas();
		int contadorLigasPublicas=listaLigasPublicas.size();
		
		if(e.getSource() == boton5) {
			
			boton4.setEnabled(false);
			boton5.setEnabled(false);
			boton6.setEnabled(false);
			boton7.setEnabled(false);
			boton8.setEnabled(false);
						
			
			this.add(ligasRegistradas);
			
			for(LigasPublicas a: listaLigasPublicas) {
				
				ligasRegistradas.addItem(a.getNombreLiga());
				contadorLigasPublicas = capaLogica.listaLigasPublicas().size();
				
			}
			
			ligasRegistradas.setBounds(950, 50, 200, 30);
			
			this.add(UnirseLiga);
			UnirseLiga.setBounds(1160, 50, 100, 30);
			
		}
		
		if (e.getSource() == ligasRegistradas) {
			
			if(contadorLigasPublicas == 0) {
				
				JOptionPane.showMessageDialog(null, "No hay ligas publicas para mostrar.");
				
			}
			else {
				
				this.add(informacionLiga);
				informacionLiga.setBounds(950,10, 300,300);
				informacionLiga.setForeground(Color.ORANGE);
				informacionLiga.setAutoscrolls(true);

			}
			
			
		}
		
		if(e.getSource() == UnirseLiga) {
			
			//Pendiente, el  registrar la liga hasta que logre agarrar la informacion del usuario dentro del menu del jugador.
			
		}
		
		
	}
	
	//-------------------------------------------------------------------------------------------------
	
	
	
	
	//-------------------------------------------------------------------------------------------------
	
	
   
    
    public void paintComponent(Graphics g) {
    	 
		int width = this.getSize().width;
		int height = this.getSize().height;
 
		this.setBackground("src\\graficos\\MenuJugador.jpg");
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

}
