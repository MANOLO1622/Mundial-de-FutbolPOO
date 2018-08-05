package cl;

import rondasMundial.Partido;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;

public class Juego extends JPanel{
	
	private Usuario miUsuario;
	private int tipoLiga;
	
	
	private static Image imagen;

	/*
	 * 
	 * 
	 * Estos componentes se utilizaran para mostrar los partidos de cada cuadro de juego, en si la parte escencial del juego.
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
	private JLabel labelPartido33 = new JLabel();
	private JLabel labelPartido34 = new JLabel();
	private JLabel labelPartido35 = new JLabel();
	private JLabel labelPartido36 = new JLabel();
	private JLabel labelPartido37 = new JLabel();
	private JLabel labelPartido38 = new JLabel();
	private JLabel labelPartido39 = new JLabel();
	private JLabel labelPartido40 = new JLabel();
	private JLabel labelPartido41 = new JLabel();
	private JLabel labelPartido42 = new JLabel();
	private JLabel labelPartido43 = new JLabel();
	private JLabel labelPartido44 = new JLabel();
	private JLabel labelPartido45 = new JLabel();
	private JLabel labelPartido46 = new JLabel();
	private JLabel labelPartido47 = new JLabel();
	private JLabel labelPartido48 = new JLabel();
	private JLabel labelPartido49 = new JLabel();
	private JLabel labelPartido50 = new JLabel();
	private JLabel labelPartido51 = new JLabel();
	private JLabel labelPartido52 = new JLabel();
	private JLabel labelPartido53 = new JLabel();
	private JLabel labelPartido54 = new JLabel();
	private JLabel labelPartido55 = new JLabel();
	private JLabel labelPartido56 = new JLabel();
	private JLabel labelPartido57 = new JLabel();
	private JLabel labelPartido58 = new JLabel();
	private JLabel labelPartido59 = new JLabel();
	private JLabel labelPartido60 = new JLabel();
	private JLabel labelPartido61 = new JLabel();
	private JLabel labelPartido62 = new JLabel();
	private JLabel labelPartido63 = new JLabel();
	private JLabel labelPartido64 = new JLabel();
	private JLabel labelPartido65 = new JLabel();
	private JLabel labelPartido66 = new JLabel();
	private JLabel labelPartido67 = new JLabel();
	private JLabel labelPartido68 = new JLabel();
	private JLabel labelPartido69 = new JLabel();
	private JLabel labelPartido70 = new JLabel();
	private JLabel labelPartido71 = new JLabel();
	private JLabel labelPartido72 = new JLabel();
	private JLabel labelPartido73 = new JLabel();
	private JLabel labelPartido74 = new JLabel();
	private JLabel labelPartido75 = new JLabel();
	private JLabel labelPartido76 = new JLabel();
	private JLabel labelPartido77 = new JLabel();
	private JLabel labelPartido78 = new JLabel();
	private JLabel labelPartido79 = new JLabel();
	private JLabel labelPartido80 = new JLabel();
	private JLabel labelPartido81 = new JLabel();
	private JLabel labelPartido82 = new JLabel();
	private JLabel labelPartido83 = new JLabel();
	private JLabel labelPartido84 = new JLabel();
	private JLabel labelPartido85 = new JLabel();
	private JLabel labelPartido86 = new JLabel();
	private JLabel labelPartido87 = new JLabel();
	private JLabel labelPartido88 = new JLabel();
	private JLabel labelPartido89 = new JLabel();
	private JLabel labelPartido90 = new JLabel();
	private JLabel labelPartido91 = new JLabel();
	private JLabel labelPartido92 = new JLabel();
	private JLabel labelPartido93 = new JLabel();
	private JLabel labelPartido94 = new JLabel();
	private JLabel labelPartido95 = new JLabel();
	private JLabel labelPartido96 = new JLabel();

	
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
	private ImageIcon imagenPartido33;
	private ImageIcon imagenPartido34;
	private ImageIcon imagenPartido35;
	private ImageIcon imagenPartido36;
	private ImageIcon imagenPartido37;
	private ImageIcon imagenPartido38;
	private ImageIcon imagenPartido39;
	private ImageIcon imagenPartido40;
	private ImageIcon imagenPartido41;
	private ImageIcon imagenPartido42;
	private ImageIcon imagenPartido43;
	private ImageIcon imagenPartido44;
	private ImageIcon imagenPartido45;
	private ImageIcon imagenPartido46;
	private ImageIcon imagenPartido47;
	private ImageIcon imagenPartido48;
	private ImageIcon imagenPartido49;
	private ImageIcon imagenPartido50;
	private ImageIcon imagenPartido51;
	private ImageIcon imagenPartido52;
	private ImageIcon imagenPartido53;
	private ImageIcon imagenPartido54;
	private ImageIcon imagenPartido55;
	private ImageIcon imagenPartido56;
	private ImageIcon imagenPartido57;
	private ImageIcon imagenPartido58;
	private ImageIcon imagenPartido59;
	private ImageIcon imagenPartido60;
	private ImageIcon imagenPartido61;
	private ImageIcon imagenPartido62;
	private ImageIcon imagenPartido63;
	private ImageIcon imagenPartido64;
	private ImageIcon imagenPartido65;
	private ImageIcon imagenPartido66;
	private ImageIcon imagenPartido67;
	private ImageIcon imagenPartido68;
	private ImageIcon imagenPartido69;
	private ImageIcon imagenPartido70;
	private ImageIcon imagenPartido71;
	private ImageIcon imagenPartido72;
	private ImageIcon imagenPartido73;
	private ImageIcon imagenPartido74;
	private ImageIcon imagenPartido75;
	private ImageIcon imagenPartido76;
	private ImageIcon imagenPartido77;
	private ImageIcon imagenPartido78;
	private ImageIcon imagenPartido79;
	private ImageIcon imagenPartido80;
	private ImageIcon imagenPartido81;
	private ImageIcon imagenPartido82;
	private ImageIcon imagenPartido83;
	private ImageIcon imagenPartido84;
	private ImageIcon imagenPartido85;
	private ImageIcon imagenPartido86;
	private ImageIcon imagenPartido87;
	private ImageIcon imagenPartido88;
	private ImageIcon imagenPartido89;
	private ImageIcon imagenPartido90;
	private ImageIcon imagenPartido91;
	private ImageIcon imagenPartido92;
	private ImageIcon imagenPartido93;
	private ImageIcon imagenPartido94;
	private ImageIcon imagenPartido95;
	private ImageIcon imagenPartido96;
	
	//----------------------------------------------------------------------------constructor de la clase.
	
	public Juego(Usuario miUsuario,int tipoLiga) {
		
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
		
		/*
		this.add(labelPartido7);
		labelPartido7.setBounds();
		this.add(labelPartido8);
		labelPartido8.setBounds();
		this.add(labelPartido9);
		labelPartido9.setBounds();
		this.add(labelPartido10);
		labelPartido10.setBounds();
		this.add(labelPartido11);
		labelPartido11.setBounds();
		this.add(labelPartido12);
		labelPartido12.setBounds();
		
		*/
		
		this.add(labelPartido13);
		this.add(labelPartido14);
		this.add(labelPartido15);
		this.add(labelPartido16);
		this.add(labelPartido17);
		this.add(labelPartido18);
		this.add(labelPartido19);
		this.add(labelPartido20);
		this.add(labelPartido21);
		this.add(labelPartido22);
		this.add(labelPartido23);
		this.add(labelPartido24);
		this.add(labelPartido25);
		this.add(labelPartido26);
		this.add(labelPartido27);
		this.add(labelPartido28);
		this.add(labelPartido29);
		this.add(labelPartido30);
		this.add(labelPartido31);
		this.add(labelPartido32);
		this.add(labelPartido33);
		this.add(labelPartido34);
		this.add(labelPartido35);
		this.add(labelPartido36);
		this.add(labelPartido37);
		this.add(labelPartido38);
		this.add(labelPartido39);
		this.add(labelPartido40);
		this.add(labelPartido41);
		this.add(labelPartido42);
		this.add(labelPartido43);
		this.add(labelPartido44);
		this.add(labelPartido45);
		this.add(labelPartido46);
		this.add(labelPartido47);
		this.add(labelPartido48);
		this.add(labelPartido49);
		this.add(labelPartido50);
		this.add(labelPartido51);
		this.add(labelPartido52);
		this.add(labelPartido53);
		this.add(labelPartido54);
		this.add(labelPartido55);
		this.add(labelPartido56);
		this.add(labelPartido57);
		this.add(labelPartido58);
		this.add(labelPartido59);
		this.add(labelPartido60);
		this.add(labelPartido61);
		this.add(labelPartido62);
		this.add(labelPartido63);
		this.add(labelPartido64);
		this.add(labelPartido65);
		this.add(labelPartido66);
		this.add(labelPartido67);
		this.add(labelPartido68);
		this.add(labelPartido69);
		this.add(labelPartido70);
		this.add(labelPartido71);
		this.add(labelPartido72);
		this.add(labelPartido73);
		this.add(labelPartido74);
		this.add(labelPartido75);
		this.add(labelPartido76);
		this.add(labelPartido77);
		this.add(labelPartido78);
		this.add(labelPartido79);
		this.add(labelPartido80);
		this.add(labelPartido81);
		this.add(labelPartido82);
		this.add(labelPartido83);
		this.add(labelPartido84);
		this.add(labelPartido85);
		this.add(labelPartido86);
		this.add(labelPartido87);
		this.add(labelPartido88);
		this.add(labelPartido89);
		this.add(labelPartido90);
		this.add(labelPartido91);
		this.add(labelPartido92);
		this.add(labelPartido93);
		this.add(labelPartido94);
		this.add(labelPartido95);
		this.add(labelPartido96);
		
		mostrarBanderas( ancho,  alto);
		
	}
	
	public void mostrarBanderas(int ancho, int alto) {
		
		Partido[] temp1;
		
		if(tipoLiga == 0) {
			
			temp1 = this.miUsuario.getMiLigaPublica().getMundialAnfitrion().getRonda1().getPartidosPrimerCuadro();
			
			imagenPartido1 = new ImageIcon(temp1[0].getEquipo1().getBandera());
			Icon icono1 = new ImageIcon(imagenPartido1.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
			labelPartido1.setIcon(icono1);
			
			imagenPartido2 = new ImageIcon(temp1[0].getEquipo2().getBandera());
			Icon icono2 = new ImageIcon(imagenPartido2.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
			labelPartido2.setIcon(icono2);
			
			imagenPartido3 = new ImageIcon(temp1[1].getEquipo1().getBandera());
			Icon icono3 = new ImageIcon(imagenPartido3.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
			labelPartido3.setIcon(icono3);
			
			imagenPartido4 = new ImageIcon(temp1[1].getEquipo2().getBandera());
			Icon icono4 = new ImageIcon(imagenPartido4.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
			labelPartido4.setIcon(icono4);
			
		}else if(tipoLiga == 1) {
			
			temp1 = this.miUsuario.getMiLigaPrivada().getMundialAnfitrion().getRonda1().getPartidosPrimerCuadro();
			
			imagenPartido1 = new ImageIcon(temp1[0].getEquipo1().getBandera());
			Icon icono1 = new ImageIcon(imagenPartido1.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
			labelPartido1.setIcon(icono1);
			
			imagenPartido2 = new ImageIcon(temp1[0].getEquipo2().getBandera());
			Icon icono2 = new ImageIcon(imagenPartido2.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
			labelPartido2.setIcon(icono2);
			
			imagenPartido3 = new ImageIcon(temp1[1].getEquipo1().getBandera());
			Icon icono3 = new ImageIcon(imagenPartido3.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
			labelPartido3.setIcon(icono3);
			
			imagenPartido4 = new ImageIcon(temp1[1].getEquipo2().getBandera());
			Icon icono4 = new ImageIcon(imagenPartido4.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
			labelPartido4.setIcon(icono4);
			
			
		}
			

			
	}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//----------------------------------------------------------------------------------------------------------
	
		public void paintComponent(Graphics g) {
	   	 
			int width = this.getSize().width;
			int height = this.getSize().height;
	 
			this.setBackground("src\\graficos\\juegoLiga.jpg");
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
