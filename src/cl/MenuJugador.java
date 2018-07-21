package cl;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuJugador extends JPanel{
	
    
	
	
	JButton boton4;
	JButton boton5;
	JButton boton6;

	
	
	public MenuJugador() {
		boton4 = new JButton("Crear apuesta");
		this.setLayout(null);
		boton4.setBounds(10, 250, 180, 50);
		this.add(boton4);
		
		
		boton5 = new JButton("Seguir apuesta");
		this.setLayout(null);
		boton5.setBounds(10, 315, 180, 50);
		this.add(boton5);
		
		boton6 = new JButton("Cronograma");
		this.setLayout(null);
		boton6.setBounds(10, 385, 180, 50);
		this.add(boton6);
		
		
	
		
	}
	
	
	
	
	
	
    private static Image imagen;
    
   
    
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
	
	//-------------------------------------------------------------------------------------------------

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//private static Image imagen;
    
    
    
    
    
    
    
    
	/*//-------------------------------------------------------------------------------------------------    
    
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
	
	//-------------------------------------------------------------------------------------------------*/

}
