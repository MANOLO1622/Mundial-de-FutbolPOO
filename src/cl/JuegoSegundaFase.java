package cl;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;

import rondasMundial.Partido;

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
	
	//--------------Titulos de Fase de eliminatorias--------------------
	
	JLabel labelNombreOctavos = new JLabel("Octavos de Final");
	JLabel labelNombreOctavos2 = new JLabel("Octavos de Final");
	JLabel labelNombreCuartos = new JLabel("Cuartos");
	JLabel labelNombreCuartos2 = new JLabel("Cuartos");
	JLabel labelNombreSemis = new JLabel("Semis");
	JLabel labelNombreSemis2 = new JLabel("Semis");
	JLabel labelNombreFinal = new JLabel("FINAL");
	JLabel labelNombreLugares = new JLabel("Tercer y Cuarto Lugar");
	
	
	
	
	//------------------------------------------------------------------

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
	
	
	
	public JuegoSegundaFase(Usuario miUsuario, int tipoLiga) {
		
		this.miUsuario = miUsuario;
		this.tipoLiga = tipoLiga;
		this.setLayout(null);
		colocarComponentesJuego();

	}
	
	
	public void colocarComponentesJuego() {
		
		int alto = 48;
		int ancho = 72;

		// ------------------------------------------------------Octavos de final.
		
		this.add(labelNombreOctavos);
		labelNombreOctavos.setForeground(Color.WHITE);
		labelNombreOctavos.setBounds(1110, 5, 200, 50);
		labelNombreOctavos.setFont(new Font(labelNombreOctavos.getFont().getFontName(), Font.BOLD, 17));
		
		this.add(labelNombreOctavos2);
		labelNombreOctavos2.setForeground(Color.WHITE);
		labelNombreOctavos2.setBounds(50, 5, 200, 50);
		labelNombreOctavos2.setFont(new Font(labelNombreOctavos2.getFont().getFontName(), Font.BOLD, 17));
		
		
		
		this.add(labelPartido1);
		labelPartido1.setBounds(50, 50, ancho, alto);

		this.add(labelPartido2);
		labelPartido2.setBounds(50, 120, ancho, alto);

		this.add(labelPartido3);
		labelPartido3.setBounds(50, 200, ancho, alto);

		this.add(labelPartido4);
		labelPartido4.setBounds(50, 270, ancho, alto);

		this.add(labelPartido5);
		labelPartido5.setBounds(50, 350, ancho, alto);

		this.add(labelPartido6);
		labelPartido6.setBounds(50, 420, ancho, alto);

		this.add(labelPartido7);
		labelPartido7.setBounds(50, 500, ancho, alto);

		this.add(labelPartido8);
		labelPartido8.setBounds(50, 570, ancho, alto);

		//----------Lado derecho------------------
		
		
		this.add(labelPartido9);
		labelPartido9.setBounds(1170, 50, ancho, alto);

		this.add(labelPartido10);
		labelPartido10.setBounds(1170, 120, ancho, alto);

		this.add(labelPartido11);
		labelPartido11.setBounds(1170, 200, ancho, alto);

		this.add(labelPartido12);
		labelPartido12.setBounds(1170, 270, ancho, alto);

		this.add(labelPartido13);
		labelPartido13.setBounds(1170, 350, ancho, alto);

		this.add(labelPartido14);
		labelPartido14.setBounds(1170, 420, ancho, alto);

		this.add(labelPartido15);
		labelPartido15.setBounds(1170, 500, ancho, alto);

		this.add(labelPartido16);
		labelPartido16.setBounds(1170, 570, ancho, alto);
		
		// ------------------------------------------------------Cuartos de final	

		
		this.add(labelNombreCuartos);
		labelNombreCuartos.setForeground(Color.WHITE);
		labelNombreCuartos.setBounds(1010, 40, 200, 50);
		labelNombreCuartos.setFont(new Font(labelNombreCuartos.getFont().getFontName(), Font.BOLD, 17));
		
		this.add(labelNombreCuartos2);
		labelNombreCuartos2.setForeground(Color.WHITE);
		labelNombreCuartos2.setBounds(200, 40, 200, 50);
		labelNombreCuartos2.setFont(new Font(labelNombreCuartos2.getFont().getFontName(), Font.BOLD, 17));
		
		
		this.add(labelPartido17);
		labelPartido17.setBounds(200, 88, ancho, alto);

		this.add(labelPartido18);
		labelPartido18.setBounds(200, 238, ancho, alto);

		this.add(labelPartido19);
		labelPartido19.setBounds(200, 388, ancho, alto);

		this.add(labelPartido20);
		labelPartido20.setBounds(200, 538, ancho, alto);
		
		this.add(labelPartido21);
		labelPartido21.setBounds(1010, 88, ancho, alto);

		this.add(labelPartido22);
		labelPartido22.setBounds(1010, 238, ancho, alto);

		this.add(labelPartido23);
		labelPartido23.setBounds(1010, 388, ancho, alto);

		this.add(labelPartido24);
		labelPartido24.setBounds(1010, 538, ancho, alto);
		 													
		// ------------------------------------------------------Semifinales

		
		this.add(labelNombreSemis);
		labelNombreSemis.setForeground(Color.WHITE);
		labelNombreSemis.setBounds(880, 195, 200, 50);
		labelNombreSemis.setFont(new Font(labelNombreSemis.getFont().getFontName(), Font.BOLD, 17));
		
		this.add(labelNombreSemis2);
		labelNombreSemis2.setForeground(Color.WHITE);
		labelNombreSemis2.setBounds(320, 195, 200, 50);
		labelNombreSemis2.setFont(new Font(labelNombreSemis2.getFont().getFontName(), Font.BOLD, 17));
		
		this.add(labelPartido25);
		labelPartido25.setBounds(320, 238, ancho, alto);

		this.add(labelPartido26);
		labelPartido26.setBounds(330, 388, ancho, alto);

		this.add(labelPartido27);
		labelPartido27.setBounds(880, 238, ancho, alto);

		this.add(labelPartido28);
		labelPartido28.setBounds(880, 388, ancho, alto);
		
		// ------------------------------------------------------Finales

		this.add(labelNombreFinal);
		labelNombreFinal.setForeground(Color.WHITE);
		labelNombreFinal.setBounds(595, 220, 200, 50);
		labelNombreFinal.setFont(new Font(labelNombreFinal.getFont().getFontName(), Font.BOLD, 25));
		
		this.add(labelNombreLugares);
		labelNombreLugares.setForeground(Color.WHITE);
		labelNombreLugares.setBounds(525, 290, 300, 350);
		labelNombreLugares.setFont(new Font(labelNombreLugares.getFont().getFontName(), Font.BOLD, 19));
		
		
		this.add(labelPartido29);
		labelPartido29.setBounds(470, 300, 140, 96);

		this.add(labelPartido30);
		labelPartido30.setBounds(660, 300, 140, 96);

		this.add(labelPartido31);
		labelPartido31.setBounds(470, 500, 190, 96);//izquierdo tercer lugar

		this.add(labelPartido32);
		labelPartido32.setBounds(660, 500, 190, 96);// derecho cuarto lugar
		
		mostrarBanderas( ancho,  alto, this.tipoLiga);
		
		
	}
	
	
	
	
	public void mostrarBanderas(int ancho, int alto, int tipoLiga) {
		
		Partido[] temp1 = null;
		
		Partido[] temp2 = null;
		
		Partido[] temp3 = null;
		
		Partido[] temp4 = null;
		
		if(tipoLiga == 0 ) {
			
			//-------------------------------------------------------------------------------------------------------------------Clasificadores a octavos de final.
			
			temp1 = this.miUsuario.getMiLigaPublica().getMundialAnfitrion().getRonda1().getPartidosOctavosFinal();
			
			//-------------------------------------------------------------------------------------------------------------------Clasificadores a cuartos de final.
			
			temp2 = this.miUsuario.getMiLigaPublica().getMundialAnfitrion().getRonda1().getPartidosCuartosFinal();
			
			//------------------------------------------------------------------------------------------------------------------- Posiciones de los Semifinales.

			temp3 = this.miUsuario.getMiLigaPublica().getMundialAnfitrion().getRonda1().getPartidosSemiFinal();
			
			//------------------------------------------------------------------------------------------------------------------- Finales
			
			temp4 = this.miUsuario.getMiLigaPublica().getMundialAnfitrion().getRonda1().getJuegosFinales();
			
		}else if(tipoLiga == 1 ) {
			
			//-------------------------------------------------------------------------------------------------------------------Clasificadores a octavos de final.
			
			temp1 = this.miUsuario.getMiLigaPrivada().getMundialAnfitrion().getRonda1().getPartidosOctavosFinal();
			
			//-------------------------------------------------------------------------------------------------------------------Clasificadores a cuartos de final.
			
			temp2 = this.miUsuario.getMiLigaPrivada().getMundialAnfitrion().getRonda1().getPartidosCuartosFinal();
			
			//------------------------------------------------------------------------------------------------------------------- Posiciones de los Semifinales.

			temp3 = this.miUsuario.getMiLigaPrivada().getMundialAnfitrion().getRonda1().getPartidosSemiFinal();
			
			//------------------------------------------------------------------------------------------------------------------- Finales
			
			temp4 = this.miUsuario.getMiLigaPrivada().getMundialAnfitrion().getRonda1().getJuegosFinales();
			
		}
		
		
		
		//-------------------------------------------------------------------------------------------------------------------
		
		
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
		
		imagenPartido5 = new ImageIcon(temp1[2].getEquipo1().getBandera());
		Icon icono5 = new ImageIcon(imagenPartido5.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido5.setIcon(icono5);
		
		imagenPartido6 = new ImageIcon(temp1[2].getEquipo2().getBandera());
		Icon icono6 = new ImageIcon(imagenPartido6.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido6.setIcon(icono6);
		
		imagenPartido7 = new ImageIcon(temp1[3].getEquipo1().getBandera());
		Icon icono7 = new ImageIcon(imagenPartido7.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido7.setIcon(icono7);
		
		imagenPartido8 = new ImageIcon(temp1[3].getEquipo2().getBandera());
		Icon icono8 = new ImageIcon(imagenPartido8.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido8.setIcon(icono8);

		imagenPartido9 = new ImageIcon(temp1[4].getEquipo1().getBandera());
		Icon icono9 = new ImageIcon(imagenPartido9.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido9.setIcon(icono9);
		
		imagenPartido10 = new ImageIcon(temp1[4].getEquipo2().getBandera());
		Icon icono10 = new ImageIcon(imagenPartido10.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido10.setIcon(icono10);
		
		imagenPartido11 = new ImageIcon(temp1[5].getEquipo1().getBandera());
		Icon icono11 = new ImageIcon(imagenPartido11.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido11.setIcon(icono11);
		
		imagenPartido12 = new ImageIcon(temp1[5].getEquipo2().getBandera());
		Icon icono12 = new ImageIcon(imagenPartido12.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido12.setIcon(icono12);

		imagenPartido13 = new ImageIcon(temp1[6].getEquipo1().getBandera());
		Icon icono13 = new ImageIcon(imagenPartido13.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido13.setIcon(icono13);
		
		imagenPartido14 = new ImageIcon(temp1[6].getEquipo2().getBandera());
		Icon icono14 = new ImageIcon(imagenPartido14.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido14.setIcon(icono14);
		
		imagenPartido15 = new ImageIcon(temp1[7].getEquipo1().getBandera());
		Icon icono15 = new ImageIcon(imagenPartido15.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido15.setIcon(icono15);
		
		imagenPartido16 = new ImageIcon(temp1[7].getEquipo2().getBandera());
		Icon icono16 = new ImageIcon(imagenPartido16.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido16.setIcon(icono16);
		
		//------------------------------------------------------------------------------------------------------------------- Posiciones de los cuartos de final.
		
		
		imagenPartido17 = new ImageIcon(temp2[0].getEquipo1().getBandera());
		Icon icono17 = new ImageIcon(imagenPartido17.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido17.setIcon(icono17);

		imagenPartido18 = new ImageIcon(temp2[0].getEquipo2().getBandera());
		Icon icono18 = new ImageIcon(imagenPartido18.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido18.setIcon(icono18);
		
		imagenPartido19 = new ImageIcon(temp2[1].getEquipo1().getBandera());
		Icon icono19 = new ImageIcon(imagenPartido19.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido19.setIcon(icono19);
		
		imagenPartido20 = new ImageIcon(temp2[1].getEquipo2().getBandera());
		Icon icono20 = new ImageIcon(imagenPartido20.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido20.setIcon(icono20);
		
		imagenPartido21 = new ImageIcon(temp2[2].getEquipo1().getBandera());
		Icon icono21 = new ImageIcon(imagenPartido21.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido21.setIcon(icono21);

		imagenPartido22 = new ImageIcon(temp2[2].getEquipo2().getBandera());
		Icon icono22 = new ImageIcon(imagenPartido22.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido22.setIcon(icono22);
		
		imagenPartido23 = new ImageIcon(temp2[3].getEquipo1().getBandera());
		Icon icono23 = new ImageIcon(imagenPartido23.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido23.setIcon(icono23);
		
		imagenPartido24 = new ImageIcon(temp2[3].getEquipo2().getBandera());
		Icon icono24 = new ImageIcon(imagenPartido24.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido24.setIcon(icono24);
		
		//------------------------------------------------------------------------------------------------------------------- Posiciones de los Semifinales
		
		imagenPartido25 = new ImageIcon(temp3[0].getEquipo1().getBandera());
		Icon icono25 = new ImageIcon(imagenPartido25.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido25.setIcon(icono25);
		
		imagenPartido26 = new ImageIcon(temp3[0].getEquipo2().getBandera());
		Icon icono26 = new ImageIcon(imagenPartido26.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido26.setIcon(icono26);
		
		imagenPartido27 = new ImageIcon(temp3[1].getEquipo1().getBandera());
		Icon icono27 = new ImageIcon(imagenPartido27.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido27.setIcon(icono27);
		
		imagenPartido28 = new ImageIcon(temp3[1].getEquipo2().getBandera());
		Icon icono28 = new ImageIcon(imagenPartido28.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido28.setIcon(icono28);
		
		
		//------------------------------------------------------------------------------------------------------------------- Finales
		
		imagenPartido29 = new ImageIcon(temp4[0].getEquipo1().getBandera());
		Icon icono29 = new ImageIcon(imagenPartido29.getImage().getScaledInstance(140, 96, Image.SCALE_DEFAULT));
		labelPartido29.setIcon(icono29);
		
		imagenPartido30 = new ImageIcon(temp4[0].getEquipo2().getBandera());
		Icon icono30 = new ImageIcon(imagenPartido30.getImage().getScaledInstance(140, 96, Image.SCALE_DEFAULT));
		labelPartido30.setIcon(icono30);
		
		imagenPartido31 = new ImageIcon(temp4[1].getEquipo1().getBandera());
		Icon icono31 = new ImageIcon(imagenPartido31.getImage().getScaledInstance(140, 96, Image.SCALE_DEFAULT));
		labelPartido31.setIcon(icono31);
		
		imagenPartido32 = new ImageIcon(temp4[1].getEquipo2().getBandera());
		Icon icono32 = new ImageIcon(imagenPartido32.getImage().getScaledInstance(140, 96, Image.SCALE_DEFAULT));
		labelPartido32.setIcon(icono32);
		
		
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





