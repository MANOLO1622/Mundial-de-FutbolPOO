package cl;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;
import gestor.*;

public class MenuAdministrador extends JPanel{
	
	
	JButton boton1;
	JButton boton2;
	JButton boton3;
	JButton boton10;
	JButton boton11;
	JButton boton12;
	JButton boton13;

	
	
	public MenuAdministrador() {
		boton1 = new JButton("Usuarios");
		this.setLayout(null);
		boton1.setBounds(10, 50, 180, 50);
		this.add(boton1);
		
		
		boton2 = new JButton("Apuestas");
		this.setLayout(null);
		boton2.setBounds(10, 115, 180, 50);
		this.add(boton2);
		
		boton3 = new JButton("Crear competicion");
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
		
		boton12 = new JButton("Crear copas");
		this.setLayout(null);
		boton12.setBounds(10, 400, 180, 50);
		this.add(boton12);
		
		boton13 = new JButton("Crear ligas");
		this.setLayout(null);
		boton13.setBounds(10, 475, 180, 50);
		this.add(boton13);
		
	 
		
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
	

}