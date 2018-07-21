package cl;

import java.awt.*;
import javax.swing.*;

public class MenuObservador extends JPanel{

	JButton boton7;
	JButton boton8;
	JButton boton9;

    private static Image imagen;
	
	public MenuObservador() {
		boton7 = new JButton("Ver apuestas");
		this.setLayout(null);
		boton7.setBounds(10, 250, 180, 50);
		this.add(boton7);
		
		
		boton8 = new JButton("Ver cronograma");
		this.setLayout(null);
		boton8.setBounds(10, 315, 180, 50);
		this.add(boton8);
		
		boton9 = new JButton("Ver Competiciones");
		this.setLayout(null);
		boton9.setBounds(10, 385, 180, 50);
		this.add(boton9);
			
	}
	

//-------------------------------------------------------------------------------------------------    
    
    public void paintComponent(Graphics g) {
    	 
		int width = this.getSize().width;
		int height = this.getSize().height;
 
		this.setBackground("src\\graficos\\MenuObservador.jpg");
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
	
}
