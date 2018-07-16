package cl;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;
import gestor.*;

public class MenuAdministrador extends JPanel{
	
	    private static Image imagen;
	  
		//-------------------------------------------------------------------------------------------------    
	    
	    public void paintComponent(Graphics g) {
	    	 
			int width = this.getSize().width;
			int height = this.getSize().height;
	 
			this.setBackground("src\\graficos\\MenuAdministrador.jpg");
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
