package cl;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import gestor.Gestor;

public class MenuJugador extends JPanel implements ActionListener{
	
	private static Image imagen;
	public Usuario miUsuario;
	
	JButton boton4;
	JButton boton5;
	JButton boton6;
	JButton boton7;
	JButton boton8;
	
	JComboBox ligasRegistradas = new JComboBox();
	JButton UnirseLiga = new JButton("Unirse");
	
	JLabel informacionLiga1 = new JLabel("Informacion de la Liga");
	JLabel informacionLiga2 = new JLabel("");
	JLabel informacionLiga3 = new JLabel("");
	JLabel informacionLiga4 = new JLabel("");
	JLabel informacionLiga5 = new JLabel("");
	JLabel informacionLiga6 = new JLabel("");

	
	

	public MenuJugador(Usuario miUsuario) {
		
		this.setLayout(null);
		
		this.miUsuario = miUsuario;
		
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
		String estadoLigaPublica="";
		
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
				
				this.add(informacionLiga1);
				informacionLiga1.setBounds(950,90, 300,20);
				informacionLiga1.setForeground(Color.ORANGE);
				
				
				this.add(informacionLiga2);
				informacionLiga2.setBounds(950,120, 300,20);
				informacionLiga2.setForeground(Color.ORANGE);
				
				this.add(informacionLiga3);
				informacionLiga3.setBounds(950,150, 300,20);
				informacionLiga3.setForeground(Color.ORANGE);
				
				this.add(informacionLiga4);
				informacionLiga4.setBounds(950,180, 300,20);
				informacionLiga4.setForeground(Color.ORANGE);
				
				this.add(informacionLiga5);
				informacionLiga5.setBounds(950,210, 300,20);
				informacionLiga5.setForeground(Color.ORANGE);
				
				this.add(informacionLiga6);
				informacionLiga6.setBounds(950,240, 300,20);
				informacionLiga6.setForeground(Color.ORANGE);
				
				
				LigasPublicas ligaPublicaTemp = Gestor.retornarLigaPublica((String) ligasRegistradas.getSelectedItem());
				System.out.println(ligaPublicaTemp.getNombreLiga());
				
				
				if(ligaPublicaTemp.getEstado() == true) {
					
					estadoLigaPublica = "Activo";
					
				}
				else {
					
					estadoLigaPublica = "Inactivo";
					
				}
				
				informacionLiga2.setText("Nombre de la Liga: " + ligaPublicaTemp.getNombreLiga());
				informacionLiga3.setText("Fecha de creacion: " + ligaPublicaTemp.getFechaCreacion());
				informacionLiga4.setText("Estado: " + estadoLigaPublica);
				informacionLiga5.setText("Puntos: " + ligaPublicaTemp.getPuntos());
				informacionLiga6.setText("Bono: " + ligaPublicaTemp.getBono());

			}			
		}
		
		
		
		
		
		
		
		if(e.getSource() == UnirseLiga) {
			
			LigasPublicas ligaPublicaTemporal = Gestor.retornarLigaPublica((String) ligasRegistradas.getSelectedItem());
			
			System.out.println("Lo que recoge del combobox es: " + (String) ligasRegistradas.getSelectedItem());
			String opcionEscogida = (String) ligasRegistradas.getSelectedItem();
			this.setMiUsuario(Gestor.retornarUsuario(opcionEscogida));
			
			System.out.println("Funciono "+ this.miUsuario.getMiLigaPublica().getNombreLiga());
			
			/*if(this.miUsuario.getMiLigaPublica() == null) {
				
				System.out.println(this.miUsuario.getMiLigaPublica().getNombreLiga());
				
				this.miUsuario.setMiLigaPublica(ligaPublicaTemporal);
				Gestor.asignarLigaPublicaUsuario(this.miUsuario.getNombreUsuario(),this.miUsuario.getMiLigaPublica());
				
			}
			else {
				
				JOptionPane.showMessageDialog(null, "El usuario ya se encuentra en una liga publica.");
				
			}*/
			
			
			
			
			
		}
		
		
	}
	
	//-------------------------------------------------------------------------------------------------
	
	public Usuario getMiUsuario() {
		return miUsuario;
	}

	public void setMiUsuario(Usuario miUsuario) {
		this.miUsuario = miUsuario;
	}
	
	
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
