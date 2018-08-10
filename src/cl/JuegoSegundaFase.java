package cl;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;

public class JuegoSegundaFase extends JPanel{
	
	private Usuario miUsuario;
	private int tipoLiga;
	
	private static Image imagen;
	
	/*
	 * 
	 * 
	 * Estos componentes se utilizaran para mostrar los partidos de cada cuadro de
	 * juego, en si la parte escencial del juego.
	 * 
	 * 
	 */

	private JLabel labelPartido1 = new JLabel();
	private JLabel labelPartido2 = new JLabel();
	private JLabel labelPartido3 = new JLabel();
	private JLabel labelPartido4 = new JLabel();
	private JLabel labelPartido5 = new JLabel();
	private JLabel labelPartido6 = new JLabel();
	private JLabel labelPartido7 = new JLabel();
	private JLabel labelPartido8 = new JLabel();
	private JLabel labelPartido9 = new JLabel();
	private JLabel labelPartido10 = new JLabel();
	private JLabel labelPartido11 = new JLabel();
	private JLabel labelPartido12 = new JLabel();
	private JLabel labelPartido13 = new JLabel();
	private JLabel labelPartido14 = new JLabel();
	private JLabel labelPartido15 = new JLabel();
	private JLabel labelPartido16 = new JLabel();
	private JLabel labelPartido17 = new JLabel();
	private JLabel labelPartido18 = new JLabel();
	private JLabel labelPartido19 = new JLabel();
	private JLabel labelPartido20 = new JLabel();
	private JLabel labelPartido21 = new JLabel();
	private JLabel labelPartido22 = new JLabel();
	private JLabel labelPartido23 = new JLabel();
	private JLabel labelPartido24 = new JLabel();
	private JLabel labelPartido25 = new JLabel();
	private JLabel labelPartido26 = new JLabel();
	private JLabel labelPartido27 = new JLabel();
	private JLabel labelPartido28 = new JLabel();
	private JLabel labelPartido29 = new JLabel();
	private JLabel labelPartido30 = new JLabel();
	private JLabel labelPartido31 = new JLabel();
	private JLabel labelPartido32 = new JLabel();
	
	private ImageIcon imagenPartido1;
	private ImageIcon imagenPartido2;
	private ImageIcon imagenPartido3;
	private ImageIcon imagenPartido4;
	private ImageIcon imagenPartido5;
	private ImageIcon imagenPartido6;
	private ImageIcon imagenPartido7;
	private ImageIcon imagenPartido8;
	private ImageIcon imagenPartido9;
	private ImageIcon imagenPartido10;
	private ImageIcon imagenPartido11;
	private ImageIcon imagenPartido12;
	private ImageIcon imagenPartido13;
	private ImageIcon imagenPartido14;
	private ImageIcon imagenPartido15;
	private ImageIcon imagenPartido16;
	private ImageIcon imagenPartido17;
	private ImageIcon imagenPartido18;
	private ImageIcon imagenPartido19;
	private ImageIcon imagenPartido20;
	private ImageIcon imagenPartido21;
	private ImageIcon imagenPartido22;
	private ImageIcon imagenPartido23;
	private ImageIcon imagenPartido24;
	private ImageIcon imagenPartido25;
	private ImageIcon imagenPartido26;
	private ImageIcon imagenPartido27;
	private ImageIcon imagenPartido28;
	private ImageIcon imagenPartido29;
	private ImageIcon imagenPartido30;
	private ImageIcon imagenPartido31;
	private ImageIcon imagenPartido32;
	
	
	
	public JuegoSegundaFase(Usuario miUsuario) {
		
		this.miUsuario = miUsuario;
		this.tipoLiga = tipoLiga;
		this.setLayout(null);
		colocarComponentesJuego();

	}
	
	
	public void colocarComponentesJuego() {
		
		int alto = 48;
		int ancho = 72;

		this.add(labelPartido1);
		labelPartido1.setBounds(50, 50, ancho, alto);

		this.add(labelPartido2);
		labelPartido2.setBounds(50, 120, ancho, alto);

		this.add(labelPartido3);
		labelPartido3.setBounds(125, 50, ancho, alto);

		this.add(labelPartido4);
		labelPartido4.setBounds(125, 120, ancho, alto);

		this.add(labelPartido5);
		labelPartido5.setBounds(200, 50, ancho, alto);

		this.add(labelPartido6);
		labelPartido6.setBounds(200, 120, ancho, alto);

		this.add(labelPartido7);
		labelPartido7.setBounds(275, 50, ancho, alto);

		this.add(labelPartido8);
		labelPartido8.setBounds(275, 120, ancho, alto);

		this.add(labelPartido9);
		labelPartido9.setBounds(350, 50, ancho, alto);

		this.add(labelPartido10);
		labelPartido10.setBounds(350, 120, ancho, alto);

		this.add(labelPartido11);
		labelPartido11.setBounds(425, 50, ancho, alto);

		this.add(labelPartido12);
		labelPartido12.setBounds(425, 120, ancho, alto);

		// ------------------------------------------------------Segundo cuadro de juego

		this.add(labelPartido13);
		labelPartido13.setBounds(50, 220, ancho, alto);

		this.add(labelPartido14);
		labelPartido14.setBounds(50, 290, ancho, alto);

		this.add(labelPartido15);
		labelPartido15.setBounds(125, 220, ancho, alto);

		this.add(labelPartido16);
		labelPartido16.setBounds(125, 290, ancho, alto);

		this.add(labelPartido17);
		labelPartido17.setBounds(200, 220, ancho, alto);

		this.add(labelPartido18);
		labelPartido18.setBounds(200, 290, ancho, alto);

		this.add(labelPartido19);
		labelPartido19.setBounds(275, 220, ancho, alto);

		this.add(labelPartido20);
		labelPartido20.setBounds(275, 290, ancho, alto);

		this.add(labelPartido21);
		labelPartido21.setBounds(350, 220, ancho, alto);

		this.add(labelPartido22);
		labelPartido22.setBounds(350, 290, ancho, alto);

		this.add(labelPartido23);
		labelPartido23.setBounds(425, 220, ancho, alto);

		this.add(labelPartido24);
		labelPartido24.setBounds(425, 290, ancho, alto);

		// ------------------------------------------------------Tercer cuadro de juego

		this.add(labelPartido25);
		labelPartido25.setBounds(50, 390, ancho, alto);

		this.add(labelPartido26);
		labelPartido26.setBounds(50, 460, ancho, alto);

		this.add(labelPartido27);
		labelPartido27.setBounds(125, 390, ancho, alto);

		this.add(labelPartido28);
		labelPartido28.setBounds(125, 460, ancho, alto);

		this.add(labelPartido29);
		labelPartido29.setBounds(200, 390, ancho, alto);

		this.add(labelPartido30);
		labelPartido30.setBounds(200, 460, ancho, alto);

		this.add(labelPartido31);
		labelPartido31.setBounds(275, 390, ancho, alto);

		this.add(labelPartido32);
		labelPartido32.setBounds(275, 460, ancho, alto);
		
		mostrarBanderas( ancho,  alto);
		
	}
	
	
	
	
	public void mostrarBanderas(int ancho, int alto) {
		
		Equipo[] temp1 = this.miUsuario.getMiLigaPublica().getMundialAnfitrion().getRonda1().getGanadoresPrimerCuadro();
		
		
		imagenPartido1 = new ImageIcon(temp1[0].getBandera());
		Icon icono1 = new ImageIcon(imagenPartido1.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido1.setIcon(icono1);
		
	}
	
	
	
	
	
	public void paintComponent(Graphics g) {

		int width = this.getSize().width;
		int height = this.getSize().height;

		this.setBackground("src\\graficos\\juegoligafase2.jpg");
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





