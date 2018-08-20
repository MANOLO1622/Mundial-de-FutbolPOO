package cl;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**Esta clase posee los botones principales de la pantalla del observador
 * aca estas los componentes necesarios que el observador solo podra visualizar
 * @author DELL
 *
 */
public class MenuObservador extends JPanel implements ActionListener{
	
	public Usuario miUsuario;

	JButton boton7 = new JButton("Ver apuestas");
	JButton boton8 = new JButton("Ver apuestas");
	JButton boton9 = new JButton("Ver cronograma");
	JButton boton10 = new JButton("Salir");

    private static Image imagen;
	
	public MenuObservador(Usuario miUsuario) {
		
		this.miUsuario = miUsuario;
		this.setLayout(null);
		
		this.add(boton7);
		boton7.setBounds(10, 250, 180, 50);
		
		this.add(boton8);
		boton8.setBounds(10, 315, 180, 50);
		
		this.add(boton9);
		boton9.setBounds(10, 385, 180, 50);
		
		this.add(boton10);
		boton10.setBounds(10, 455, 180, 50);
		
		//----------------Eventos
		
		boton10.addActionListener(this);
		
	}
	
	//------------------------------------------------------------------------------------------------- 
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== boton10) {
			
			Ventana ventLogin = new Ventana(null);
			try {
				ventLogin.ventanaLogin();
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
			SwingUtilities.getWindowAncestor(getRootPane()).dispose();
			
		}
		
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
