package cl;

import java.awt.*;
import javax.swing.*;

public class MenuObservador extends JPanel{

    private static Image imagen;
    
    
    
    
    
    
    
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
