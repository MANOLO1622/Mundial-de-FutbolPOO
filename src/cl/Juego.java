package cl;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class Juego extends JPanel{
	
	private static Image imagen;
	
	
	JComboBox ligas = new JComboBox<Object>();
	JComboBox equipos = new JComboBox<Object>();
	
	public Juego() {
		
		this.add(ligas);
		ligas.addItem("Liga Publica");
		ligas.addItem("Liga Privada");
		
		this.add(equipos);
		
		
		CL capaLogica = new CL();
		ArrayList<Equipo> listaEquipos = capaLogica.listarEquiposFIFA();
		
		for(Equipo e: listaEquipos) {
			
			equipos.addItem(e.getNombre());
			
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	//----------------------------------------------------------------------------------------------------------
	
	public void paintComponent(Graphics g) {
   	 
		int width = this.getSize().width;
		int height = this.getSize().height;
 
		this.setBackground("src\\graficos\\juego.jpg");
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
