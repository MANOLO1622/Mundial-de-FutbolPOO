package cl;

import rondasMundial.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

import gestor.Gestor;

/**
 * Posee los metodos necesarios para la administracion del juego en si
 * 
 * @author DELL
 *
 */
public class Juego extends JPanel implements ActionListener, MouseListener {

	private Usuario miUsuario;
	private int tipoLiga;
	private int puntaje = 0;

	private JComboBox equipos = new JComboBox();
	private JLabel labelBanderaPaisEscogido = new JLabel();
	private ImageIcon imagenBanderaPaisEscogido;
	private JTextPane partidosPaisEscogido = new JTextPane();
	private JButton btnregistrarEquipoJugador = new JButton("Seleccionar");
	private JButton btnApostar = new JButton("Apostar");

	private JButton btnSalir = new JButton("Salir");

	private static Image imagen;

	/*
	 * 
	 * 
	 * Estos componentes se utilizaran para mostrar los banderas y componentes que
	 * ayudaran a hacer las apuestas.
	 * 
	 * 
	 */

	private JLabel labelEquipoSeleccionado = new JLabel();
	private JLabel labelEquipoContrincante = new JLabel();
	private ImageIcon imagenEquipoSeleccionado;
	private ImageIcon imagenEquipoContrincante;

	private JLabel equipo1 = new JLabel("Equipo 1");
	private JLabel equipo2 = new JLabel("Equipo 2");

	private JTextField marcadorEquipo1 = new JTextField(2);
	private JTextField marcadorEquipo2 = new JTextField(2);

	private JButton btnSegundaFase = new JButton("Octavos");

	private JLabel labelPuntaje = new JLabel("Puntaje: " + 0);

	/*
	 * 
	 * 
	 * Estos componentes se utilizaran para mostrar los partidos de cada cuadro de
	 * juego, en si la parte escencial del juego.
	 * 
	 * 
	 */

	private JLabel cuadro1 = new JLabel("   Cuadro A");
	private JLabel cuadro2 = new JLabel("   Cuadro B");
	private JLabel cuadro3 = new JLabel("   Cuadro C");
	private JLabel cuadro4 = new JLabel("   Cuadro D");
	private JLabel cuadro5 = new JLabel("   Cuadro E");
	private JLabel cuadro6 = new JLabel("   Cuadro F");
	private JLabel cuadro7 = new JLabel("   Cuadro G");
	private JLabel cuadro8 = new JLabel("   Cuadro H");

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

	// ----------------------------------------------------------------------------constructor
	// de la clase.

	/**
	 * Este es el constructo principal de la clase juego.
	 * 
	 * @param miUsuario
	 * @param tipoLiga
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public Juego(Usuario miUsuario, int tipoLiga) throws SQLException, Exception {

		this.miUsuario = Gestor.retornarUsuario(miUsuario.getNombreUsuario());
		this.tipoLiga = tipoLiga;
		this.setLayout(null);
		colocarComponentesJuego();

		if (this.tipoLiga == 0) {

			if (this.miUsuario.getValidacionPrimeraFasePublica() == 0
					&& this.miUsuario.getEquipoLigaPublica() != null) {

				this.add(btnApostar);
				btnApostar.setVisible(true);
				btnApostar.setBounds(1100, 350, 125, 30);

			}

			if (this.miUsuario.getValidacionPrimeraFasePublica() == 1
					&& this.miUsuario.getEquipoLigaPublica() != null) {

				this.add(btnApostar);
				btnApostar.setVisible(true);
				btnApostar.setBounds(1100, 350, 125, 30);

			}

			if (this.miUsuario.getValidacionPrimeraFasePublica() >= 2
					&& this.miUsuario.getEquipoLigaPublica() != null) {

				if (this.miUsuario.isValidacionOctavosPublica() == true) {

					this.btnSegundaFase.setVisible(true);

				} else {

					JOptionPane.showMessageDialog(null, "Lo lamentamos, tu equipo no ha clasificado.");

				}

			}

		} else if (tipoLiga == 1) {

			if (this.miUsuario.getValidacionPrimeraFasePrivada() == 0
					&& this.miUsuario.getEquipoLigaPrivada() != null) {

				this.add(btnApostar);
				btnApostar.setVisible(true);
				btnApostar.setBounds(1100, 350, 125, 30);

			}

			if (this.miUsuario.getValidacionPrimeraFasePrivada() == 1
					&& this.miUsuario.getEquipoLigaPrivada() != null) {

				this.add(btnApostar);
				btnApostar.setVisible(true);
				btnApostar.setBounds(1100, 350, 125, 30);

			}

			if (this.miUsuario.getValidacionPrimeraFasePrivada() >= 2
					&& this.miUsuario.getEquipoLigaPrivada() != null) {

				if (this.miUsuario.isValidacionOctavosPrivada() == true) {

					this.btnSegundaFase.setVisible(true);

				} else {

					JOptionPane.showMessageDialog(null, "Lo lamentamos, tu equipo no ha clasificado.");

				}

			}

		}

		// ----------------------------------Eventos

		btnSalir.addActionListener(this);
		equipos.addActionListener(this);
		btnregistrarEquipoJugador.addActionListener(this);
		btnApostar.addActionListener(this);
		btnSegundaFase.addActionListener(this);

		labelPartido1.addMouseListener(this);
		labelPartido2.addMouseListener(this);
		labelPartido3.addMouseListener(this);
		labelPartido4.addMouseListener(this);
		labelPartido5.addMouseListener(this);
		labelPartido6.addMouseListener(this);
		labelPartido7.addMouseListener(this);
		labelPartido8.addMouseListener(this);
		labelPartido9.addMouseListener(this);
		labelPartido10.addMouseListener(this);
		labelPartido11.addMouseListener(this);
		labelPartido12.addMouseListener(this);
		labelPartido13.addMouseListener(this);
		labelPartido14.addMouseListener(this);
		labelPartido15.addMouseListener(this);
		labelPartido16.addMouseListener(this);
		labelPartido17.addMouseListener(this);
		labelPartido18.addMouseListener(this);
		labelPartido19.addMouseListener(this);
		labelPartido20.addMouseListener(this);
		labelPartido21.addMouseListener(this);
		labelPartido22.addMouseListener(this);
		labelPartido23.addMouseListener(this);
		labelPartido24.addMouseListener(this);
		labelPartido25.addMouseListener(this);
		labelPartido26.addMouseListener(this);
		labelPartido27.addMouseListener(this);
		labelPartido28.addMouseListener(this);
		labelPartido29.addMouseListener(this);
		labelPartido30.addMouseListener(this);
		labelPartido31.addMouseListener(this);
		labelPartido32.addMouseListener(this);
		labelPartido33.addMouseListener(this);
		labelPartido34.addMouseListener(this);
		labelPartido35.addMouseListener(this);
		labelPartido36.addMouseListener(this);
	}

	/**
	 * Este metodo posee la altura y el ancho de los componentes ademas se encarga
	 * de validar los puntajes por cada liga por separado
	 * @throws Exception 
	 * @throws SQLException 
	 * 
	 */
	public void colocarComponentesJuego() throws SQLException, Exception {

		int alto = 48;
		int ancho = 72;

		this.add(labelPuntaje);

		if (this.tipoLiga == 0) {

			labelPuntaje.setText("Puntaje: " + this.miUsuario.getPuntajePublica());

		} else if (this.tipoLiga == 1) {

			labelPuntaje.setText("Puntaje: " + this.miUsuario.getPuntajePrivada());

		}

		labelPuntaje.setBounds(1065, 550, 194, 30);

		this.add(btnSegundaFase);// este es el boton de los octavos de final de la pantalla
		btnSegundaFase.setVisible(false);// Este boton posee un setVisible para que sea presentado en pantalla
		btnSegundaFase.setBounds(1150, 610, 100, 30);// Esta es la posicion que se muestra en la pantalla

		this.add(btnSalir);// Este es el boton de salir de la seccion de fase de juegos
		btnSalir.setBounds(1150, 650, 100, 30);// Esta es la posicion que se muestra en la pantalla

		// --------------------------------------------------------

		/**
		 * Estos son los componentes para la posicion de cada pais en su partido
		 * respectivo se encuentra en fases de eliminatoria donde se puede observar las
		 * posiciones de los octavos, cuartos, semis y final de la pantalla de juego
		 */
		this.add(cuadro1);
		cuadro1.setBounds(50, 25, 448, 20);
		cuadro1.setOpaque(true);
		cuadro1.setBackground(new Color(0, 153, 255));

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

		this.add(cuadro2);
		cuadro2.setBounds(50, 195, 448, 20);
		cuadro2.setOpaque(true);
		cuadro2.setBackground(new Color(0, 153, 255));

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

		this.add(cuadro3);
		cuadro3.setBounds(50, 365, 448, 20);
		cuadro3.setOpaque(true);
		cuadro3.setBackground(new Color(0, 153, 255));

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

		this.add(labelPartido33);
		labelPartido33.setBounds(350, 390, ancho, alto);

		this.add(labelPartido34);
		labelPartido34.setBounds(350, 460, ancho, alto);

		this.add(labelPartido35);
		labelPartido35.setBounds(425, 390, ancho, alto);

		this.add(labelPartido36);
		labelPartido36.setBounds(425, 460, ancho, alto);

		// ------------------------------------------------------Cuarto cuadro de juego

		this.add(cuadro4);
		cuadro4.setBounds(50, 535, 448, 20);
		cuadro4.setOpaque(true);
		cuadro4.setBackground(new Color(0, 153, 255));

		this.add(labelPartido37);
		labelPartido37.setBounds(50, 560, ancho, alto);

		this.add(labelPartido38);
		labelPartido38.setBounds(50, 630, ancho, alto);

		this.add(labelPartido39);
		labelPartido39.setBounds(125, 560, ancho, alto);

		this.add(labelPartido40);
		labelPartido40.setBounds(125, 630, ancho, alto);

		this.add(labelPartido41);
		labelPartido41.setBounds(200, 560, ancho, alto);

		this.add(labelPartido42);
		labelPartido42.setBounds(200, 630, ancho, alto);

		this.add(labelPartido43);
		labelPartido43.setBounds(275, 560, ancho, alto);

		this.add(labelPartido44);
		labelPartido44.setBounds(275, 630, ancho, alto);

		this.add(labelPartido45);
		labelPartido45.setBounds(350, 560, ancho, alto);

		this.add(labelPartido46);
		labelPartido46.setBounds(350, 630, ancho, alto);

		this.add(labelPartido47);
		labelPartido47.setBounds(425, 560, ancho, alto);

		this.add(labelPartido48);
		labelPartido48.setBounds(425, 630, ancho, alto);

		// ------------------------------------------------------Quinto cuadro de juego
		this.add(cuadro5);
		cuadro5.setBounds(600, 25, 448, 20);
		cuadro5.setOpaque(true);
		cuadro5.setBackground(new Color(0, 153, 255));

		this.add(labelPartido49);
		labelPartido49.setBounds(600, 50, ancho, alto);

		this.add(labelPartido50);
		labelPartido50.setBounds(600, 120, ancho, alto);

		this.add(labelPartido51);
		labelPartido51.setBounds(675, 50, ancho, alto);

		this.add(labelPartido52);
		labelPartido52.setBounds(675, 120, ancho, alto);

		this.add(labelPartido53);
		labelPartido53.setBounds(750, 50, ancho, alto);

		this.add(labelPartido54);
		labelPartido54.setBounds(750, 120, ancho, alto);

		this.add(labelPartido55);
		labelPartido55.setBounds(825, 50, ancho, alto);

		this.add(labelPartido56);
		labelPartido56.setBounds(825, 120, ancho, alto);

		this.add(labelPartido57);
		labelPartido57.setBounds(900, 50, ancho, alto);

		this.add(labelPartido58);
		labelPartido58.setBounds(900, 120, ancho, alto);

		this.add(labelPartido59);
		labelPartido59.setBounds(975, 50, ancho, alto);

		this.add(labelPartido60);
		labelPartido60.setBounds(975, 120, ancho, alto);

		// ------------------------------------------------------Sexto cuadro de juego

		this.add(cuadro6);
		cuadro6.setBounds(600, 195, 448, 20);
		cuadro6.setOpaque(true);
		cuadro6.setBackground(new Color(0, 153, 255));

		this.add(labelPartido61);
		labelPartido61.setBounds(600, 220, ancho, alto);

		this.add(labelPartido62);
		labelPartido62.setBounds(600, 290, ancho, alto);

		this.add(labelPartido63);
		labelPartido63.setBounds(675, 220, ancho, alto);

		this.add(labelPartido64);
		labelPartido64.setBounds(675, 290, ancho, alto);

		this.add(labelPartido65);
		labelPartido65.setBounds(750, 220, ancho, alto);

		this.add(labelPartido66);
		labelPartido66.setBounds(750, 290, ancho, alto);

		this.add(labelPartido67);
		labelPartido67.setBounds(825, 220, ancho, alto);

		this.add(labelPartido68);
		labelPartido68.setBounds(825, 290, ancho, alto);

		this.add(labelPartido69);
		labelPartido69.setBounds(900, 220, ancho, alto);

		this.add(labelPartido70);
		labelPartido70.setBounds(900, 290, ancho, alto);

		this.add(labelPartido71);
		labelPartido71.setBounds(975, 220, ancho, alto);

		this.add(labelPartido72);
		labelPartido72.setBounds(975, 290, ancho, alto);

		// ------------------------------------------------------Septimo cuadro de juego
		this.add(cuadro7);
		cuadro7.setBounds(600, 365, 448, 20);
		cuadro7.setOpaque(true);
		cuadro7.setBackground(new Color(0, 153, 255));

		this.add(labelPartido73);
		labelPartido73.setBounds(600, 390, ancho, alto);

		this.add(labelPartido74);
		labelPartido74.setBounds(600, 460, ancho, alto);

		this.add(labelPartido75);
		labelPartido75.setBounds(675, 390, ancho, alto);

		this.add(labelPartido76);
		labelPartido76.setBounds(675, 460, ancho, alto);

		this.add(labelPartido77);
		labelPartido77.setBounds(750, 390, ancho, alto);

		this.add(labelPartido78);
		labelPartido78.setBounds(750, 460, ancho, alto);

		this.add(labelPartido79);
		labelPartido79.setBounds(825, 390, ancho, alto);

		this.add(labelPartido80);
		labelPartido80.setBounds(825, 460, ancho, alto);

		this.add(labelPartido81);
		labelPartido81.setBounds(900, 390, ancho, alto);

		this.add(labelPartido82);
		labelPartido82.setBounds(900, 460, ancho, alto);

		this.add(labelPartido83);
		labelPartido83.setBounds(975, 390, ancho, alto);

		this.add(labelPartido84);
		labelPartido84.setBounds(975, 460, ancho, alto);

		// ------------------------------------------------------Octavo cuadro de juego
		this.add(cuadro8);
		cuadro8.setBounds(600, 535, 448, 20);
		cuadro8.setOpaque(true);
		cuadro8.setBackground(new Color(0, 153, 255));

		this.add(labelPartido85);
		labelPartido85.setBounds(600, 560, ancho, alto);

		this.add(labelPartido86);
		labelPartido86.setBounds(600, 630, ancho, alto);

		this.add(labelPartido87);
		labelPartido87.setBounds(675, 560, ancho, alto);

		this.add(labelPartido88);
		labelPartido88.setBounds(675, 630, ancho, alto);

		this.add(labelPartido89);
		labelPartido89.setBounds(750, 560, ancho, alto);

		this.add(labelPartido90);
		labelPartido90.setBounds(750, 630, ancho, alto);

		this.add(labelPartido91);
		labelPartido91.setBounds(825, 560, ancho, alto);

		this.add(labelPartido92);
		labelPartido92.setBounds(825, 630, ancho, alto);

		this.add(labelPartido93);
		labelPartido93.setBounds(900, 560, ancho, alto);

		this.add(labelPartido94);
		labelPartido94.setBounds(900, 630, ancho, alto);

		this.add(labelPartido95);
		labelPartido95.setBounds(975, 560, ancho, alto);

		this.add(labelPartido96);
		labelPartido96.setBounds(975, 630, ancho, alto);

		mostrarBanderas(ancho, alto);

	}

	/**
	 * Este metodo posee la altura y el ancho de la banderas en la pantalla de juego
	 * ademas posee los componentes que muestran la informacion del equipo y retorna
	 * el juego de cada partido.
	 * 
	 * @param ancho
	 * @param alto
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public void mostrarBanderas(int ancho, int alto) throws SQLException, Exception {

		Partido[] temp1 = null;
		Partido[] temp2 = null;
		Partido[] temp3 = null;
		Partido[] temp4 = null;
		Partido[] temp5 = null;
		Partido[] temp6 = null;
		Partido[] temp7 = null;
		Partido[] temp8 = null;

		if (tipoLiga == 0) {

			temp1 = this.miUsuario.getMiLigaPublica().getMundialAnfitrion().getResultadosMundial()
					.getPartidosPrimerCuadro();
			temp2 = this.miUsuario.getMiLigaPublica().getMundialAnfitrion().getResultadosMundial()
					.getPartidosSegundoCuadro();
			temp3 = this.miUsuario.getMiLigaPublica().getMundialAnfitrion().getResultadosMundial()
					.getPartidosTercerCuadro();
			temp4 = this.miUsuario.getMiLigaPublica().getMundialAnfitrion().getResultadosMundial()
					.getPartidosCuartoCuadro();
			temp5 = this.miUsuario.getMiLigaPublica().getMundialAnfitrion().getResultadosMundial()
					.getPartidosQuintoCuadro();
			temp6 = this.miUsuario.getMiLigaPublica().getMundialAnfitrion().getResultadosMundial()
					.getPartidosSextoCuadro();
			temp7 = this.miUsuario.getMiLigaPublica().getMundialAnfitrion().getResultadosMundial()
					.getPartidosSeptimoCuadro();
			temp8 = this.miUsuario.getMiLigaPublica().getMundialAnfitrion().getResultadosMundial()
					.getPartidosOctavoCuadro();

			if (this.miUsuario.getEquipoLigaPublica() == null) {

				equipos.removeAllItems();
				this.add(equipos);
				equipos.setBounds(1075, 25, 175, 30);

				for (Equipo e : Gestor.retornarLigaPublica(this.miUsuario.getMiLigaPublica().getNombreLiga())
						.getMundialAnfitrion().getEquiposMundial()) {

					equipos.addItem(e.getNombre());

				}

			} else {

				mostrarinformacionpaisEscogido(0);

			}

		} else if (tipoLiga == 1) {

			temp1 = this.miUsuario.getMiLigaPrivada().getMundialAnfitrion().getResultadosMundial()
					.getPartidosPrimerCuadro();
			temp2 = this.miUsuario.getMiLigaPrivada().getMundialAnfitrion().getResultadosMundial()
					.getPartidosSegundoCuadro();
			temp3 = this.miUsuario.getMiLigaPrivada().getMundialAnfitrion().getResultadosMundial()
					.getPartidosTercerCuadro();
			temp4 = this.miUsuario.getMiLigaPrivada().getMundialAnfitrion().getResultadosMundial()
					.getPartidosCuartoCuadro();
			temp5 = this.miUsuario.getMiLigaPrivada().getMundialAnfitrion().getResultadosMundial()
					.getPartidosQuintoCuadro();
			temp6 = this.miUsuario.getMiLigaPrivada().getMundialAnfitrion().getResultadosMundial()
					.getPartidosSextoCuadro();
			temp7 = this.miUsuario.getMiLigaPrivada().getMundialAnfitrion().getResultadosMundial()
					.getPartidosSeptimoCuadro();
			temp8 = this.miUsuario.getMiLigaPrivada().getMundialAnfitrion().getResultadosMundial()
					.getPartidosOctavoCuadro();

			if (this.miUsuario.getEquipoLigaPrivada() == null) {

				equipos.removeAllItems();
				
				this.add(equipos);
				equipos.setBounds(1075, 25, 175, 30);

				for (Equipo e : Gestor.retornarLigaPrivada(this.miUsuario.getMiLigaPrivada().getNombreLiga())
						.getMundialAnfitrion().getEquiposMundial()) {

					equipos.addItem(e.getNombre());

				}
			} else {

				mostrarinformacionpaisEscogido(1);

			}

		}

		/**
		 * Aqui se guardan las imagenes de las banderas de cada equipo.
		 */
		// ------------------------------------------------------------------------------------------Primer
		// cuadro de Juegos

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

		// ------------------------------------------------------------------------------------------Segundo
		// cuadro de Juegos

		imagenPartido13 = new ImageIcon(temp2[0].getEquipo1().getBandera());
		Icon icono13 = new ImageIcon(imagenPartido13.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido13.setIcon(icono13);

		imagenPartido14 = new ImageIcon(temp2[0].getEquipo2().getBandera());
		Icon icono14 = new ImageIcon(imagenPartido14.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido14.setIcon(icono14);

		imagenPartido15 = new ImageIcon(temp2[1].getEquipo1().getBandera());
		Icon icono15 = new ImageIcon(imagenPartido15.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido15.setIcon(icono15);

		imagenPartido16 = new ImageIcon(temp2[1].getEquipo2().getBandera());
		Icon icono16 = new ImageIcon(imagenPartido16.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido16.setIcon(icono16);

		imagenPartido17 = new ImageIcon(temp2[2].getEquipo1().getBandera());
		Icon icono17 = new ImageIcon(imagenPartido17.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido17.setIcon(icono17);

		imagenPartido18 = new ImageIcon(temp2[2].getEquipo2().getBandera());
		Icon icono18 = new ImageIcon(imagenPartido18.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido18.setIcon(icono18);

		imagenPartido19 = new ImageIcon(temp2[3].getEquipo1().getBandera());
		Icon icono19 = new ImageIcon(imagenPartido19.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido19.setIcon(icono19);

		imagenPartido20 = new ImageIcon(temp2[3].getEquipo2().getBandera());
		Icon icono20 = new ImageIcon(imagenPartido20.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido20.setIcon(icono20);

		imagenPartido21 = new ImageIcon(temp2[4].getEquipo1().getBandera());
		Icon icono21 = new ImageIcon(imagenPartido21.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido21.setIcon(icono21);

		imagenPartido22 = new ImageIcon(temp2[4].getEquipo2().getBandera());
		Icon icono22 = new ImageIcon(imagenPartido22.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido22.setIcon(icono22);

		imagenPartido23 = new ImageIcon(temp2[5].getEquipo1().getBandera());
		Icon icono23 = new ImageIcon(imagenPartido23.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido23.setIcon(icono23);

		imagenPartido24 = new ImageIcon(temp2[5].getEquipo2().getBandera());
		Icon icono24 = new ImageIcon(imagenPartido24.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido24.setIcon(icono24);

		// ------------------------------------------------------------------------------------------Tercer
		// cuadro de Juegos

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

		imagenPartido29 = new ImageIcon(temp3[2].getEquipo1().getBandera());
		Icon icono29 = new ImageIcon(imagenPartido29.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido29.setIcon(icono29);

		imagenPartido30 = new ImageIcon(temp3[2].getEquipo2().getBandera());
		Icon icono30 = new ImageIcon(imagenPartido30.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido30.setIcon(icono30);

		imagenPartido31 = new ImageIcon(temp3[3].getEquipo1().getBandera());
		Icon icono31 = new ImageIcon(imagenPartido31.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido31.setIcon(icono31);

		imagenPartido32 = new ImageIcon(temp3[3].getEquipo2().getBandera());
		Icon icono32 = new ImageIcon(imagenPartido32.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido32.setIcon(icono32);

		imagenPartido33 = new ImageIcon(temp3[4].getEquipo1().getBandera());
		Icon icono33 = new ImageIcon(imagenPartido33.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido33.setIcon(icono33);

		imagenPartido34 = new ImageIcon(temp3[4].getEquipo2().getBandera());
		Icon icono34 = new ImageIcon(imagenPartido34.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido34.setIcon(icono34);

		imagenPartido35 = new ImageIcon(temp3[5].getEquipo1().getBandera());
		Icon icono35 = new ImageIcon(imagenPartido35.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido35.setIcon(icono35);

		imagenPartido36 = new ImageIcon(temp3[5].getEquipo2().getBandera());
		Icon icono36 = new ImageIcon(imagenPartido36.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido36.setIcon(icono36);

		// ------------------------------------------------------------------------------------------Cuarto
		// cuadro de Juegos

		imagenPartido37 = new ImageIcon(temp4[0].getEquipo1().getBandera());
		Icon icono37 = new ImageIcon(imagenPartido37.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido37.setIcon(icono37);

		imagenPartido38 = new ImageIcon(temp4[0].getEquipo2().getBandera());
		Icon icono38 = new ImageIcon(imagenPartido38.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido38.setIcon(icono38);

		imagenPartido39 = new ImageIcon(temp4[1].getEquipo1().getBandera());
		Icon icono39 = new ImageIcon(imagenPartido39.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido39.setIcon(icono39);

		imagenPartido40 = new ImageIcon(temp4[1].getEquipo2().getBandera());
		Icon icono40 = new ImageIcon(imagenPartido40.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido40.setIcon(icono40);

		imagenPartido41 = new ImageIcon(temp4[2].getEquipo1().getBandera());
		Icon icono41 = new ImageIcon(imagenPartido41.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido41.setIcon(icono41);

		imagenPartido42 = new ImageIcon(temp4[2].getEquipo2().getBandera());
		Icon icono42 = new ImageIcon(imagenPartido42.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido42.setIcon(icono42);

		imagenPartido43 = new ImageIcon(temp4[3].getEquipo1().getBandera());
		Icon icono43 = new ImageIcon(imagenPartido43.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido43.setIcon(icono43);

		imagenPartido44 = new ImageIcon(temp4[3].getEquipo2().getBandera());
		Icon icono44 = new ImageIcon(imagenPartido44.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido44.setIcon(icono44);

		imagenPartido45 = new ImageIcon(temp4[4].getEquipo1().getBandera());
		Icon icono45 = new ImageIcon(imagenPartido45.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido45.setIcon(icono45);

		imagenPartido46 = new ImageIcon(temp4[4].getEquipo2().getBandera());
		Icon icono46 = new ImageIcon(imagenPartido46.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido46.setIcon(icono46);

		imagenPartido47 = new ImageIcon(temp4[5].getEquipo1().getBandera());
		Icon icono47 = new ImageIcon(imagenPartido47.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido47.setIcon(icono47);

		imagenPartido48 = new ImageIcon(temp4[5].getEquipo2().getBandera());
		Icon icono48 = new ImageIcon(imagenPartido48.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido48.setIcon(icono48);

		// ------------------------------------------------------------------------------------------Quinto
		// cuadro de Juegos

		imagenPartido49 = new ImageIcon(temp5[0].getEquipo1().getBandera());
		Icon icono49 = new ImageIcon(imagenPartido49.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido49.setIcon(icono49);

		imagenPartido50 = new ImageIcon(temp5[0].getEquipo2().getBandera());
		Icon icono50 = new ImageIcon(imagenPartido50.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido50.setIcon(icono50);

		imagenPartido51 = new ImageIcon(temp5[1].getEquipo1().getBandera());
		Icon icono51 = new ImageIcon(imagenPartido51.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido51.setIcon(icono51);

		imagenPartido52 = new ImageIcon(temp5[1].getEquipo2().getBandera());
		Icon icono52 = new ImageIcon(imagenPartido52.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido52.setIcon(icono52);

		imagenPartido53 = new ImageIcon(temp5[2].getEquipo1().getBandera());
		Icon icono53 = new ImageIcon(imagenPartido53.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido53.setIcon(icono53);

		imagenPartido54 = new ImageIcon(temp5[2].getEquipo2().getBandera());
		Icon icono54 = new ImageIcon(imagenPartido54.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido54.setIcon(icono54);

		imagenPartido55 = new ImageIcon(temp5[3].getEquipo1().getBandera());
		Icon icono55 = new ImageIcon(imagenPartido55.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido55.setIcon(icono55);

		imagenPartido56 = new ImageIcon(temp5[3].getEquipo2().getBandera());
		Icon icono56 = new ImageIcon(imagenPartido56.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido56.setIcon(icono56);

		imagenPartido57 = new ImageIcon(temp5[4].getEquipo1().getBandera());
		Icon icono57 = new ImageIcon(imagenPartido57.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido57.setIcon(icono57);

		imagenPartido58 = new ImageIcon(temp5[4].getEquipo2().getBandera());
		Icon icono58 = new ImageIcon(imagenPartido58.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido58.setIcon(icono58);

		imagenPartido59 = new ImageIcon(temp5[5].getEquipo1().getBandera());
		Icon icono59 = new ImageIcon(imagenPartido59.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido59.setIcon(icono59);

		imagenPartido60 = new ImageIcon(temp5[5].getEquipo2().getBandera());
		Icon icono60 = new ImageIcon(imagenPartido60.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido60.setIcon(icono60);

		// ------------------------------------------------------------------------------------------Sexto
		// cuadro de Juegos

		imagenPartido61 = new ImageIcon(temp6[0].getEquipo1().getBandera());
		Icon icono61 = new ImageIcon(imagenPartido61.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido61.setIcon(icono61);

		imagenPartido62 = new ImageIcon(temp6[0].getEquipo2().getBandera());
		Icon icono62 = new ImageIcon(imagenPartido62.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido62.setIcon(icono62);

		imagenPartido63 = new ImageIcon(temp6[1].getEquipo1().getBandera());
		Icon icono63 = new ImageIcon(imagenPartido63.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido63.setIcon(icono63);

		imagenPartido64 = new ImageIcon(temp6[1].getEquipo2().getBandera());
		Icon icono64 = new ImageIcon(imagenPartido64.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido64.setIcon(icono64);

		imagenPartido65 = new ImageIcon(temp6[2].getEquipo1().getBandera());
		Icon icono65 = new ImageIcon(imagenPartido65.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido65.setIcon(icono65);

		imagenPartido66 = new ImageIcon(temp6[2].getEquipo2().getBandera());
		Icon icono66 = new ImageIcon(imagenPartido66.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido66.setIcon(icono66);

		imagenPartido67 = new ImageIcon(temp6[3].getEquipo1().getBandera());
		Icon icono67 = new ImageIcon(imagenPartido67.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido67.setIcon(icono67);

		imagenPartido68 = new ImageIcon(temp6[3].getEquipo2().getBandera());
		Icon icono68 = new ImageIcon(imagenPartido68.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido68.setIcon(icono68);

		imagenPartido69 = new ImageIcon(temp6[4].getEquipo1().getBandera());
		Icon icono69 = new ImageIcon(imagenPartido69.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido69.setIcon(icono69);

		imagenPartido70 = new ImageIcon(temp6[4].getEquipo2().getBandera());
		Icon icono70 = new ImageIcon(imagenPartido70.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido70.setIcon(icono70);

		imagenPartido71 = new ImageIcon(temp6[5].getEquipo1().getBandera());
		Icon icono71 = new ImageIcon(imagenPartido71.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido71.setIcon(icono71);

		imagenPartido72 = new ImageIcon(temp6[5].getEquipo2().getBandera());
		Icon icono72 = new ImageIcon(imagenPartido72.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido72.setIcon(icono72);

		// ------------------------------------------------------------------------------------------Septimo
		// cuadro de Juegos

		imagenPartido73 = new ImageIcon(temp7[0].getEquipo1().getBandera());
		Icon icono73 = new ImageIcon(imagenPartido73.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido73.setIcon(icono73);

		imagenPartido74 = new ImageIcon(temp7[0].getEquipo2().getBandera());
		Icon icono74 = new ImageIcon(imagenPartido74.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido74.setIcon(icono74);

		imagenPartido75 = new ImageIcon(temp7[1].getEquipo1().getBandera());
		Icon icono75 = new ImageIcon(imagenPartido75.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido75.setIcon(icono75);

		imagenPartido76 = new ImageIcon(temp7[1].getEquipo2().getBandera());
		Icon icono76 = new ImageIcon(imagenPartido76.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido76.setIcon(icono76);

		imagenPartido77 = new ImageIcon(temp7[2].getEquipo1().getBandera());
		Icon icono77 = new ImageIcon(imagenPartido77.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido77.setIcon(icono77);

		imagenPartido78 = new ImageIcon(temp7[2].getEquipo2().getBandera());
		Icon icono78 = new ImageIcon(imagenPartido78.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido78.setIcon(icono78);

		imagenPartido79 = new ImageIcon(temp7[3].getEquipo1().getBandera());
		Icon icono79 = new ImageIcon(imagenPartido79.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido79.setIcon(icono79);

		imagenPartido80 = new ImageIcon(temp7[3].getEquipo2().getBandera());
		Icon icono80 = new ImageIcon(imagenPartido80.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido80.setIcon(icono80);

		imagenPartido81 = new ImageIcon(temp7[4].getEquipo1().getBandera());
		Icon icono81 = new ImageIcon(imagenPartido81.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido81.setIcon(icono81);

		imagenPartido82 = new ImageIcon(temp7[4].getEquipo2().getBandera());
		Icon icono82 = new ImageIcon(imagenPartido82.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido82.setIcon(icono82);

		imagenPartido83 = new ImageIcon(temp7[5].getEquipo1().getBandera());
		Icon icono83 = new ImageIcon(imagenPartido83.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido83.setIcon(icono83);

		imagenPartido84 = new ImageIcon(temp7[5].getEquipo2().getBandera());
		Icon icono84 = new ImageIcon(imagenPartido84.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido84.setIcon(icono84);

		// ------------------------------------------------------------------------------------------Octavo
		// cuadro de Juegos

		imagenPartido85 = new ImageIcon(temp8[0].getEquipo1().getBandera());
		Icon icono85 = new ImageIcon(imagenPartido85.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido85.setIcon(icono85);

		imagenPartido86 = new ImageIcon(temp8[0].getEquipo2().getBandera());
		Icon icono86 = new ImageIcon(imagenPartido86.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido86.setIcon(icono86);

		imagenPartido87 = new ImageIcon(temp8[1].getEquipo1().getBandera());
		Icon icono87 = new ImageIcon(imagenPartido87.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido87.setIcon(icono87);

		imagenPartido88 = new ImageIcon(temp8[1].getEquipo2().getBandera());
		Icon icono88 = new ImageIcon(imagenPartido88.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido88.setIcon(icono88);

		imagenPartido89 = new ImageIcon(temp8[2].getEquipo1().getBandera());
		Icon icono89 = new ImageIcon(imagenPartido89.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido89.setIcon(icono89);

		imagenPartido90 = new ImageIcon(temp8[2].getEquipo2().getBandera());
		Icon icono90 = new ImageIcon(imagenPartido90.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido90.setIcon(icono90);

		imagenPartido91 = new ImageIcon(temp8[3].getEquipo1().getBandera());
		Icon icono91 = new ImageIcon(imagenPartido91.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido91.setIcon(icono91);

		imagenPartido92 = new ImageIcon(temp8[3].getEquipo2().getBandera());
		Icon icono92 = new ImageIcon(imagenPartido92.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido92.setIcon(icono92);

		imagenPartido93 = new ImageIcon(temp8[4].getEquipo1().getBandera());
		Icon icono93 = new ImageIcon(imagenPartido93.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido93.setIcon(icono93);

		imagenPartido94 = new ImageIcon(temp8[4].getEquipo2().getBandera());
		Icon icono94 = new ImageIcon(imagenPartido94.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido94.setIcon(icono94);

		imagenPartido95 = new ImageIcon(temp8[5].getEquipo1().getBandera());
		Icon icono95 = new ImageIcon(imagenPartido95.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido95.setIcon(icono95);

		imagenPartido96 = new ImageIcon(temp8[5].getEquipo2().getBandera());
		Icon icono96 = new ImageIcon(imagenPartido96.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPartido96.setIcon(icono96);
	}

	// -----------------------------------------------FONDO DE JUEGO
	// LIGAS-----------------------------------------------------------

	/**
	 * Este es el metodo que guarda el fondo del juego de ligas
	 */
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

	/*
	 * -----------------------------------------------------------------------------
	 * --
	 * 
	 * 
	 * Acciones del juego
	 * 
	 * 
	 */

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnSalir) {

			SwingUtilities.getWindowAncestor(getRootPane()).dispose();
			Ventana ventMenuJugador = new Ventana(this.miUsuario);
			try {
				ventMenuJugador.ventanaMenuUsuarios(this.miUsuario.getTipoUsuario(2), ventMenuJugador);
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}

		}

		// --------------------------------------------------------------------------------------------------------------------------Otro
		// evento
		/**
		 * Esto es el evento del juego que posee los componentes que administran la
		 * pantalla donde se muestran el pais escogido el equipoy el usuario actual.
		 */
		if (e.getSource() == equipos) {

			String nombreLiga = "";

			this.add(labelBanderaPaisEscogido);
			labelBanderaPaisEscogido.setBounds(1075, 60, 175, 122);

			this.add(partidosPaisEscogido);
			partidosPaisEscogido.setBounds(1075, 190, 175, 150);

			this.add(btnregistrarEquipoJugador);
			btnregistrarEquipoJugador.setBounds(1100, 350, 125, 30);

			try {
				imagenBanderaPaisEscogido = new ImageIcon(Gestor.retornarBanderaEquipo((String) equipos.getSelectedItem()));
			} catch (Exception e1) {

				e1.printStackTrace();
			}
			Icon iconoPaisEScogido = new ImageIcon(imagenBanderaPaisEscogido.getImage().getScaledInstance(
					labelBanderaPaisEscogido.getWidth(), labelBanderaPaisEscogido.getHeight(), Image.SCALE_DEFAULT));
			labelBanderaPaisEscogido.setIcon(iconoPaisEScogido);

			if (this.tipoLiga == 0) {

				nombreLiga = this.miUsuario.getMiLigaPublica().getNombreLiga();

			} else if (this.tipoLiga == 1) {

				nombreLiga = this.miUsuario.getMiLigaPrivada().getNombreLiga();

			}

			partidosPaisEscogido.setEnabled(false);
			try {
				partidosPaisEscogido.setText(Gestor.retornarPartidosCuadro(nombreLiga, (String) equipos.getSelectedItem()));
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}

		}

		// --------------------------------------------------------------------------------------------------------------------------Otro
		// evento
		/**
		 * Este es el getSoure de los botones que administra la pantalla de juego
		 * mundiales, ademas es la que posee todos lo componentes de juego en la
		 * seleccionar de apostar por un equipo.
		 */

		if (e.getSource() == btnregistrarEquipoJugador) {

			this.add(btnApostar);
			btnApostar.setVisible(true);
			btnApostar.setBounds(1100, 350, 125, 30);

			this.add(labelEquipoSeleccionado);
			labelEquipoSeleccionado.setVisible(false);
			labelEquipoSeleccionado.setBounds(1065, 400, 97, 64);

			this.add(labelEquipoContrincante);
			labelEquipoContrincante.setVisible(false);
			labelEquipoContrincante.setBounds(1164, 400, 97, 64);

			this.add(equipo1);
			equipo1.setVisible(false);
			equipo1.setBounds(1065, 470, 97, 30);

			this.add(equipo2);
			equipo2.setVisible(false);
			equipo2.setBounds(1165, 470, 97, 30);

			this.add(marcadorEquipo1);
			marcadorEquipo1.setVisible(false);
			marcadorEquipo1.setText("");
			marcadorEquipo1.setBounds(1065, 510, 97, 30);

			this.add(marcadorEquipo2);
			marcadorEquipo2.setVisible(false);
			marcadorEquipo2.setText("");
			marcadorEquipo2.setBounds(1164, 510, 97, 30);

			if (this.tipoLiga == 0) {

				try {
					Gestor.asignarEquipoLigaPublicaUsuario(this.miUsuario.getNombreUsuario(),
							Gestor.retornarEquipo((String) equipos.getSelectedItem()));
				} catch (Exception e2) {
					
					e2.printStackTrace();
				}
				try {
					this.miUsuario = Gestor.retornarUsuario(this.miUsuario.getNombreUsuario());
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}

				try {
					mostrarinformacionpaisEscogido(0);
				} catch (Exception e2) {
					
					e2.printStackTrace();
				}

				Partido[] tempPublica = null;
				try {
					tempPublica = Gestor.retornarPartidosEquipoLiga(this.miUsuario.getEquipoLigaPublica(),
							this.miUsuario.getMiLigaPublica().getNombreLiga(), this.tipoLiga);
				} catch (Exception e2) {
					
					e2.printStackTrace();
				}
				Apuesta[] apuestasPrimerCuadroPublica = new Apuesta[3];
				apuestasPrimerCuadroPublica[0] = new Apuesta(tempPublica[0], this.miUsuario.getEquipoLigaPublica(),
						this.miUsuario);
				apuestasPrimerCuadroPublica[1] = new Apuesta(tempPublica[1], this.miUsuario.getEquipoLigaPublica(),
						this.miUsuario);
				apuestasPrimerCuadroPublica[2] = new Apuesta(tempPublica[2], this.miUsuario.getEquipoLigaPublica(),
						this.miUsuario);

				this.miUsuario.setPrimerCuadroPublica(apuestasPrimerCuadroPublica);
				try {
					Gestor.actualizarJugador(this.miUsuario);
				} catch (Exception e2) {
					
					e2.printStackTrace();
				}

				try {
					this.miUsuario = Gestor.retornarUsuario(this.miUsuario.getNombreUsuario());
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}

				imagenEquipoSeleccionado = new ImageIcon(
						this.miUsuario.getPrimerCuadroPublica()[0].getPartidoApuesta().getEquipo1().getBandera());
				ImageIcon iconoEquipoSeleccionado = new ImageIcon(imagenEquipoSeleccionado.getImage().getScaledInstance(
						labelEquipoSeleccionado.getWidth(), labelEquipoSeleccionado.getHeight(), Image.SCALE_DEFAULT));
				labelEquipoSeleccionado.setIcon(iconoEquipoSeleccionado);

				imagenEquipoContrincante = new ImageIcon(
						this.miUsuario.getPrimerCuadroPublica()[0].getPartidoApuesta().getEquipo2().getBandera());
				ImageIcon iconoEquipoContrincante = new ImageIcon(imagenEquipoContrincante.getImage().getScaledInstance(
						labelEquipoContrincante.getWidth(), labelEquipoContrincante.getHeight(), Image.SCALE_DEFAULT));
				labelEquipoContrincante.setIcon(iconoEquipoContrincante);

			} else if (this.tipoLiga == 1) {

				try {
					Gestor.asignarEquipoLigaPrivadaUsuario(this.miUsuario.getNombreUsuario(),
							Gestor.retornarEquipo((String) equipos.getSelectedItem()));
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				try {
					this.miUsuario = Gestor.retornarUsuario(this.miUsuario.getNombreUsuario());
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}

				try {
					mostrarinformacionpaisEscogido(1);
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}

				Partido[] tempPrivada = null;
				try {
					tempPrivada = Gestor.retornarPartidosEquipoLiga(this.miUsuario.getEquipoLigaPrivada(),
							this.miUsuario.getMiLigaPrivada().getNombreLiga(), this.tipoLiga);
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				Apuesta[] apuestasPrimerCuadroPrivada = new Apuesta[3];
				apuestasPrimerCuadroPrivada[0] = new Apuesta(tempPrivada[0], this.miUsuario.getEquipoLigaPrivada(),
						this.miUsuario);
				apuestasPrimerCuadroPrivada[1] = new Apuesta(tempPrivada[1], this.miUsuario.getEquipoLigaPrivada(),
						this.miUsuario);
				apuestasPrimerCuadroPrivada[2] = new Apuesta(tempPrivada[2], this.miUsuario.getEquipoLigaPrivada(),
						this.miUsuario);

				this.miUsuario.setPrimerCuadroPrivada(apuestasPrimerCuadroPrivada);
				try {
					Gestor.actualizarJugador(this.miUsuario);
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}

				imagenEquipoSeleccionado = new ImageIcon(
						this.miUsuario.getPrimerCuadroPrivada()[0].getPartidoApuesta().getEquipo1().getBandera());
				ImageIcon iconoEquipoSeleccionado = new ImageIcon(imagenEquipoSeleccionado.getImage().getScaledInstance(
						labelEquipoSeleccionado.getWidth(), labelEquipoSeleccionado.getHeight(), Image.SCALE_DEFAULT));
				labelEquipoSeleccionado.setIcon(iconoEquipoSeleccionado);

				imagenEquipoContrincante = new ImageIcon(
						this.miUsuario.getPrimerCuadroPrivada()[0].getPartidoApuesta().getEquipo2().getBandera());
				ImageIcon iconoEquipoContrincante = new ImageIcon(imagenEquipoContrincante.getImage().getScaledInstance(
						labelEquipoContrincante.getWidth(), labelEquipoContrincante.getHeight(), Image.SCALE_DEFAULT));
				labelEquipoContrincante.setIcon(iconoEquipoContrincante);

			}

			labelEquipoSeleccionado.setVisible(true);
			labelEquipoContrincante.setVisible(true);
			equipo1.setVisible(true);
			equipo2.setVisible(true);
			marcadorEquipo1.setVisible(true);
			marcadorEquipo1.setText("");
			marcadorEquipo2.setVisible(true);
			marcadorEquipo2.setText("");

		}

		// --------------------------------------------------------------------------------------------------------------------------Otro
		// evento
		/**
		 * Se comprueba la correcta funcionalidad del juego con las validaciones
		 * necesarias
		 */
		if (e.getSource() == btnApostar) {

			try {
				this.miUsuario = Gestor.retornarUsuario(this.miUsuario.getNombreUsuario());
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}

			if (marcadorEquipo1.getText().equals("") || marcadorEquipo2.getText().equals("")) {

				JOptionPane.showMessageDialog(null, "Por favor ingrese los marcadores", "NO ESTA JUGANDO COMO SE DEBE",
						JOptionPane.WARNING_MESSAGE);

			} else {

				if (this.tipoLiga == 0) {

					if (this.miUsuario.getValidacionPrimeraFasePublica() == 0) {

						imagenEquipoSeleccionado = new ImageIcon(this.miUsuario.getPrimerCuadroPublica()[1]
								.getPartidoApuesta().getEquipo1().getBandera());
						ImageIcon iconoEquipoSeleccionado = new ImageIcon(imagenEquipoSeleccionado.getImage()
								.getScaledInstance(labelEquipoSeleccionado.getWidth(),
										labelEquipoSeleccionado.getHeight(), Image.SCALE_DEFAULT));
						labelEquipoSeleccionado.setIcon(iconoEquipoSeleccionado);

						imagenEquipoContrincante = new ImageIcon(this.miUsuario.getPrimerCuadroPublica()[1]
								.getPartidoApuesta().getEquipo2().getBandera());
						ImageIcon iconoEquipoContrincante = new ImageIcon(imagenEquipoContrincante.getImage()
								.getScaledInstance(labelEquipoContrincante.getWidth(),
										labelEquipoContrincante.getHeight(), Image.SCALE_DEFAULT));
						labelEquipoContrincante.setIcon(iconoEquipoContrincante);

						this.miUsuario.sumarApuestaPublica();
						try {
							Gestor.actualizarJugador(this.miUsuario);
						} catch (Exception e1) {
							
							e1.printStackTrace();
						}

						btnSegundaFase.setVisible(false);

						try {
							sumarPuntajes(0, 0);
						} catch (Exception e1) {
							
							e1.printStackTrace();
						}

						/**
						 * Validacion de la primera fase del juego en una liga publica
						 */
					} else if (this.miUsuario.getValidacionPrimeraFasePublica() == 1) {

						imagenEquipoSeleccionado = new ImageIcon(this.miUsuario.getPrimerCuadroPublica()[2]
								.getPartidoApuesta().getEquipo1().getBandera());
						ImageIcon iconoEquipoSeleccionado = new ImageIcon(imagenEquipoSeleccionado.getImage()
								.getScaledInstance(labelEquipoSeleccionado.getWidth(),
										labelEquipoSeleccionado.getHeight(), Image.SCALE_DEFAULT));
						labelEquipoSeleccionado.setIcon(iconoEquipoSeleccionado);

						imagenEquipoContrincante = new ImageIcon(this.miUsuario.getPrimerCuadroPublica()[2]
								.getPartidoApuesta().getEquipo2().getBandera());
						ImageIcon iconoEquipoContrincante = new ImageIcon(imagenEquipoContrincante.getImage()
								.getScaledInstance(labelEquipoContrincante.getWidth(),
										labelEquipoContrincante.getHeight(), Image.SCALE_DEFAULT));
						labelEquipoContrincante.setIcon(iconoEquipoContrincante);

						this.miUsuario.sumarApuestaPublica();
						try {
							Gestor.actualizarJugador(this.miUsuario);
						} catch (Exception e1) {
							
							e1.printStackTrace();
						}

						btnSegundaFase.setVisible(false);

						try {
							sumarPuntajes(0, 1);
						} catch (Exception e1) {
							
							e1.printStackTrace();
						}

					} else if (this.miUsuario.getValidacionPrimeraFasePublica() >= 2) {

						this.remove(labelEquipoSeleccionado);
						this.remove(labelEquipoContrincante);
						this.remove(equipo1);
						this.remove(equipo2);
						this.remove(marcadorEquipo1);
						this.remove(marcadorEquipo2);
						this.remove(btnApostar);

						this.miUsuario.sumarApuestaPublica();
						try {
							Gestor.actualizarJugador(this.miUsuario);
						} catch (Exception e1) {
							
							e1.printStackTrace();
						}

						try {
							sumarPuntajes(0, 2);
						} catch (Exception e2) {
							
							e2.printStackTrace();
						}

						JOptionPane.showMessageDialog(null, "Ya haz completado todas la apuestas de la primera fase\n"
								+ "si tu equipo clasifico, podras pasar a la segunda fase.");

						Equipo[] temp = this.miUsuario.getMiLigaPublica().getMundialAnfitrion().getResultadosMundial()
								.getGanadoresPrimeraFase();
						int index = 0;

						for (Equipo a : temp) {

							if (this.miUsuario.getEquipoLigaPublica().getNombre().equals(temp[index].getNombre())) {

								btnSegundaFase.setVisible(true);
								this.miUsuario.setValidacionOctavosPublica(true);
								try {
									Gestor.actualizarJugador(this.miUsuario);
								} catch (Exception e1) {
									
									e1.printStackTrace();
								}
							}
							index++;
						}

					}

				} else if (this.tipoLiga == 1) {

					/**
					 * Validacion de la primera fase del juego en una liga privada
					 */
					if (this.miUsuario.getValidacionPrimeraFasePrivada() == 0) {

						imagenEquipoSeleccionado = new ImageIcon(this.miUsuario.getPrimerCuadroPrivada()[1]
								.getPartidoApuesta().getEquipo1().getBandera());
						ImageIcon iconoEquipoSeleccionado = new ImageIcon(imagenEquipoSeleccionado.getImage()
								.getScaledInstance(labelEquipoSeleccionado.getWidth(),
										labelEquipoSeleccionado.getHeight(), Image.SCALE_DEFAULT));
						labelEquipoSeleccionado.setIcon(iconoEquipoSeleccionado);

						imagenEquipoContrincante = new ImageIcon(this.miUsuario.getPrimerCuadroPrivada()[1]
								.getPartidoApuesta().getEquipo2().getBandera());
						ImageIcon iconoEquipoContrincante = new ImageIcon(imagenEquipoContrincante.getImage()
								.getScaledInstance(labelEquipoContrincante.getWidth(),
										labelEquipoContrincante.getHeight(), Image.SCALE_DEFAULT));
						labelEquipoContrincante.setIcon(iconoEquipoContrincante);

						this.miUsuario.sumarApuestaPrivada();
						try {
							Gestor.actualizarJugador(this.miUsuario);
						} catch (Exception e1) {
							
							e1.printStackTrace();
						}

						btnSegundaFase.setVisible(false);

						try {
							sumarPuntajes(1, 0);
						} catch (Exception e1) {
							
							e1.printStackTrace();
						}

					} else if (this.miUsuario.getValidacionPrimeraFasePrivada() == 1) {

						imagenEquipoSeleccionado = new ImageIcon(this.miUsuario.getPrimerCuadroPrivada()[2]
								.getPartidoApuesta().getEquipo1().getBandera());
						ImageIcon iconoEquipoSeleccionado = new ImageIcon(imagenEquipoSeleccionado.getImage()
								.getScaledInstance(labelEquipoSeleccionado.getWidth(),
										labelEquipoSeleccionado.getHeight(), Image.SCALE_DEFAULT));
						labelEquipoSeleccionado.setIcon(iconoEquipoSeleccionado);

						imagenEquipoContrincante = new ImageIcon(this.miUsuario.getPrimerCuadroPrivada()[2]
								.getPartidoApuesta().getEquipo2().getBandera());
						ImageIcon iconoEquipoContrincante = new ImageIcon(imagenEquipoContrincante.getImage()
								.getScaledInstance(labelEquipoContrincante.getWidth(),
										labelEquipoContrincante.getHeight(), Image.SCALE_DEFAULT));
						labelEquipoContrincante.setIcon(iconoEquipoContrincante);

						this.miUsuario.sumarApuestaPrivada();
						try {
							Gestor.actualizarJugador(this.miUsuario);
						} catch (Exception e1) {
							
							e1.printStackTrace();
						}

						btnSegundaFase.setVisible(false);

						try {
							sumarPuntajes(1, 1);
						} catch (Exception e1) {
							
							e1.printStackTrace();
						}

					} else if (this.miUsuario.getValidacionPrimeraFasePrivada() >= 2) {

						this.miUsuario.sumarApuestaPrivada();
						try {
							Gestor.actualizarJugador(this.miUsuario);
						} catch (Exception e1) {
						
							e1.printStackTrace();
						}

						btnSegundaFase.setVisible(false);

						try {
							sumarPuntajes(1, 2);
						} catch (Exception e2) {
							
							e2.printStackTrace();
						}

						this.remove(labelEquipoSeleccionado);
						this.remove(labelEquipoContrincante);
						this.remove(equipo1);
						this.remove(equipo2);
						this.remove(marcadorEquipo1);
						this.remove(marcadorEquipo2);
						this.remove(btnApostar);

						JOptionPane.showMessageDialog(null, "Ya haz completado todas la apuestas de la primera fase\n"
								+ "si tu equipo clasifico, podras pasar a la segunda fase.");

						Equipo[] temp = this.miUsuario.getMiLigaPrivada().getMundialAnfitrion().getResultadosMundial()
								.getGanadoresPrimeraFase();
						int index = 0;

						for (Equipo a : temp) {

							if (this.miUsuario.getEquipoLigaPrivada().getNombre().equals(temp[index].getNombre())) {

								btnSegundaFase.setVisible(true);
								this.miUsuario.setValidacionOctavosPrivada(true);
								try {
									Gestor.actualizarJugador(this.miUsuario);
								} catch (Exception e1) {
									
									e1.printStackTrace();
								}

							}
							index++;
						}

					}

				}

				marcadorEquipo1.setText("");
				marcadorEquipo2.setText("");

			}

		}

		// --------------------------------------------------------------------------------------------------------------------------Otro
		// evento
		/**
		 * Validacion de la segunda fase del juego en una liga publica
		 */
		if (e.getSource() == btnSegundaFase) {

			Ventana test = new Ventana(this.miUsuario);
			try {
				test.ventanaJuegoFase2(this.tipoLiga);
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
			SwingUtilities.getWindowAncestor(getRootPane()).dispose();

		}

	}

	/**
	 * Suma los puntajes obtenidos de la primera ronda de la fase de juegos
	 * mundiales, ademas almacena 2 variables de tipo int.
	 * 
	 * @param tipoLiga
	 * @param ronda
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public void sumarPuntajes(int tipoLiga, int ronda) throws SQLException, Exception {

		switch (tipoLiga) {

		case 0:

			if (this.miUsuario.getEquipoLigaPublica().getNombre().equals(this.miUsuario.getPrimerCuadroPublica()[ronda]
					.getPartidoApuesta().getEquipoGanador().getNombre())) {

				puntaje = this.miUsuario.getPuntajePublica() + LigasPublicas.puntos;
				this.miUsuario.setPuntajePublica(puntaje);

			}

			if (marcadorEquipo1.getText()
					.equals(Integer.toString(
							this.miUsuario.getPrimerCuadroPublica()[ronda].getPartidoApuesta().getPuntajeEquipo1()))
					|| marcadorEquipo2.getText().equals(Integer.toString(
							this.miUsuario.getPrimerCuadroPublica()[ronda].getPartidoApuesta().getPuntajeEquipo1()))) {

				puntaje = this.miUsuario.getPuntajePublica() + LigasPublicas.bono;
				this.miUsuario.setPuntajePublica(puntaje);

			}

			Gestor.actualizarJugador(this.miUsuario);
			labelPuntaje.setText("Puntaje: " + this.miUsuario.getPuntajePublica());

			break;

		case 1:

			if (this.miUsuario.getEquipoLigaPrivada().getNombre().equals(this.miUsuario.getPrimerCuadroPrivada()[ronda]
					.getPartidoApuesta().getEquipoGanador().getNombre())) {

				puntaje = this.miUsuario.getPuntajePrivada() + LigasPrivadas.puntos;
				this.miUsuario.setPuntajePrivada(puntaje);

			}

			if (marcadorEquipo1.getText()
					.equals(Integer.toString(
							this.miUsuario.getPrimerCuadroPrivada()[ronda].getPartidoApuesta().getPuntajeEquipo1()))
					|| marcadorEquipo2.getText().equals(Integer.toString(
							this.miUsuario.getPrimerCuadroPrivada()[ronda].getPartidoApuesta().getPuntajeEquipo1()))) {

				puntaje = this.miUsuario.getPuntajePrivada() + LigasPrivadas.bono;
				this.miUsuario.setPuntajePrivada(puntaje);

			}

			Gestor.actualizarJugador(this.miUsuario);
			labelPuntaje.setText("Puntaje: " + this.miUsuario.getPuntajePrivada());

			break;

		}

		Gestor.actualizarJugador(this.miUsuario);

	}
	/**
	 * Metodo que muestra la informacion de equipo escogido
	 * @param tipoLiga
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public void mostrarinformacionpaisEscogido(int tipoLiga) throws SQLException, Exception {

		Icon iconoPaisEScogido;

		switch (tipoLiga) {

		case 0:

			this.remove(equipos);
			this.remove(btnregistrarEquipoJugador);

			this.add(labelBanderaPaisEscogido);
			labelBanderaPaisEscogido.setBounds(1075, 60, 175, 122);

			this.add(partidosPaisEscogido);
			partidosPaisEscogido.setEnabled(false);
			partidosPaisEscogido.setBounds(1075, 190, 175, 150);
			partidosPaisEscogido
					.setText(Gestor.retornarPartidosCuadro(this.miUsuario.getMiLigaPublica().getNombreLiga(),
							this.miUsuario.getEquipoLigaPublica().getNombre()));

			imagenBanderaPaisEscogido = new ImageIcon(
					Gestor.retornarBanderaEquipo(this.miUsuario.getEquipoLigaPublica().getNombre()));
			iconoPaisEScogido = new ImageIcon(imagenBanderaPaisEscogido.getImage().getScaledInstance(
					labelBanderaPaisEscogido.getWidth(), labelBanderaPaisEscogido.getHeight(), Image.SCALE_DEFAULT));
			labelBanderaPaisEscogido.setIcon(iconoPaisEScogido);

			break;

		case 1:

			this.remove(equipos);
			this.remove(btnregistrarEquipoJugador);

			this.add(labelBanderaPaisEscogido);
			labelBanderaPaisEscogido.setBounds(1075, 60, 175, 122);

			this.add(partidosPaisEscogido);
			partidosPaisEscogido.setEnabled(false);
			partidosPaisEscogido.setBounds(1075, 190, 175, 150);
			
			partidosPaisEscogido.setText(Gestor.retornarPartidosCuadro(this.miUsuario.getMiLigaPrivada().getNombreLiga(),
							this.miUsuario.getEquipoLigaPrivada().getNombre()));

			imagenBanderaPaisEscogido = new ImageIcon(
					Gestor.retornarBanderaEquipo(this.miUsuario.getEquipoLigaPrivada().getNombre()));
			iconoPaisEScogido = new ImageIcon(imagenBanderaPaisEscogido.getImage().getScaledInstance(
					labelBanderaPaisEscogido.getWidth(), labelBanderaPaisEscogido.getHeight(), Image.SCALE_DEFAULT));
			labelBanderaPaisEscogido.setIcon(iconoPaisEScogido);

			break;

		default:

			this.remove(labelBanderaPaisEscogido);
			this.remove(partidosPaisEscogido);
			this.remove(btnApostar);

			break;
		}

	}

	// -------------------------------------------------------------------------------Solo
	// de vista e informacion
	

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

		if (e.getSource() == labelPartido1) {

			labelPartido1.setBounds(50, 50 + 5, 72, 48);

		}

		if (e.getSource() == labelPartido2) {

			labelPartido2.setBounds(50, 120 - 5, 72, 48);

		}

		if (e.getSource() == labelPartido3) {

			labelPartido3.setBounds(125, 50 + 5, 72, 48);

		}

		if (e.getSource() == labelPartido4) {

			labelPartido4.setBounds(125, 120 - 5, 72, 48);

		}

		if (e.getSource() == labelPartido5) {

			labelPartido5.setBounds(200, 50 + 5, 72, 48);

		}

		if (e.getSource() == labelPartido6) {

			labelPartido6.setBounds(200, 120 - 5, 72, 48);

		}

		if (e.getSource() == labelPartido7) {

			labelPartido7.setBounds(275, 50 + 5, 72, 48);

		}

		if (e.getSource() == labelPartido8) {

			labelPartido8.setBounds(275, 120 - 5, 72, 48);

		}

		if (e.getSource() == labelPartido9) {

			labelPartido9.setBounds(350, 50 + 5, 72, 48);

		}

		if (e.getSource() == labelPartido10) {

			labelPartido10.setBounds(350, 120 - 5, 72, 48);

		}

		if (e.getSource() == labelPartido11) {

			labelPartido11.setBounds(425, 50 + 5, 72, 48);

		}

		if (e.getSource() == labelPartido12) {

			labelPartido12.setBounds(425, 120 - 5, 72, 48);

		}

		if (e.getSource() == labelPartido13) {

			labelPartido13.setBounds(50, 220 + 5, 72, 48);

		}

		if (e.getSource() == labelPartido14) {

			labelPartido14.setBounds(50, 290 - 5, 72, 48);

		}

		if (e.getSource() == labelPartido15) {

			labelPartido15.setBounds(125, 220 + 5, 72, 48);

		}

		if (e.getSource() == labelPartido16) {

			labelPartido16.setBounds(125, 290 - 5, 72, 48);

		}

		if (e.getSource() == labelPartido17) {

			labelPartido17.setBounds(200, 220 + 5, 72, 48);

		}

		if (e.getSource() == labelPartido18) {

			labelPartido18.setBounds(200, 290 - 5, 72, 48);

		}

		if (e.getSource() == labelPartido19) {

			labelPartido19.setBounds(275, 220 + 5, 72, 48);

		}

		if (e.getSource() == labelPartido20) {

			labelPartido20.setBounds(275, 290 - 5, 72, 48);

		}

		if (e.getSource() == labelPartido21) {

			labelPartido21.setBounds(350, 220 + 5, 72, 48);

		}

		if (e.getSource() == labelPartido22) {

			labelPartido22.setBounds(350, 290 - 5, 72, 48);

		}

		if (e.getSource() == labelPartido23) {

			labelPartido23.setBounds(425, 220 + 5, 72, 48);

		}

		if (e.getSource() == labelPartido24) {

			labelPartido24.setBounds(425, 290 - 5, 72, 48);

		}

		if (e.getSource() == labelPartido25) {

			labelPartido25.setBounds(50, 390 + 5, 72, 48);

		}

		if (e.getSource() == labelPartido26) {

			labelPartido26.setBounds(50, 460 - 5, 72, 48);

		}

		if (e.getSource() == labelPartido27) {

			labelPartido27.setBounds(125, 390 + 5, 72, 48);

		}

		if (e.getSource() == labelPartido28) {

			labelPartido28.setBounds(125, 460 - 5, 72, 48);

		}

		if (e.getSource() == labelPartido29) {

			labelPartido29.setBounds(200, 390 + 5, 72, 48);

		}

		if (e.getSource() == labelPartido30) {

			labelPartido30.setBounds(200, 460 - 5, 72, 48);

		}

		if (e.getSource() == labelPartido31) {

			labelPartido31.setBounds(275, 390 + 5, 72, 48);

		}

		if (e.getSource() == labelPartido32) {

			labelPartido32.setBounds(275, 460 - 5, 72, 48);

		}

		if (e.getSource() == labelPartido33) {

			labelPartido33.setBounds(350, 390 + 5, 72, 48);

		}

		if (e.getSource() == labelPartido34) {

			labelPartido34.setBounds(350, 460 - 5, 72, 48);

		}

		if (e.getSource() == labelPartido35) {

			labelPartido35.setBounds(425, 390 + 5, 72, 48);

		}

		if (e.getSource() == labelPartido36) {

			labelPartido36.setBounds(425, 460 - 5, 72, 48);

		}

	}

	/// ----------------------------------------------------------------------------------------------------------------

	
	/**
	 * Esta es la funcionalidad de las banderas cuando se pasa el mouse por cada
	 * una de las banderas muestra esta animacion.
	 */
	
	
	@Override
	public void mouseExited(MouseEvent e) {

		if (e.getSource() == labelPartido1) {

			labelPartido1.setBounds(50, 50, 72, 48);

		}

		if (e.getSource() == labelPartido2) {

			labelPartido2.setBounds(50, 120, 72, 48);

		}

		if (e.getSource() == labelPartido3) {

			labelPartido3.setBounds(125, 50, 72, 48);

		}

		if (e.getSource() == labelPartido4) {

			labelPartido4.setBounds(125, 120, 72, 48);

		}

		if (e.getSource() == labelPartido5) {

			labelPartido5.setBounds(200, 50, 72, 48);

		}

		if (e.getSource() == labelPartido6) {

			labelPartido6.setBounds(200, 120, 72, 48);

		}

		if (e.getSource() == labelPartido7) {

			labelPartido7.setBounds(275, 50, 72, 48);

		}

		if (e.getSource() == labelPartido8) {

			labelPartido8.setBounds(275, 120, 72, 48);

		}

		if (e.getSource() == labelPartido9) {

			labelPartido9.setBounds(350, 50, 72, 48);

		}

		if (e.getSource() == labelPartido10) {

			labelPartido10.setBounds(350, 120, 72, 48);

		}

		if (e.getSource() == labelPartido11) {

			labelPartido11.setBounds(425, 50, 72, 48);

		}

		if (e.getSource() == labelPartido12) {

			labelPartido12.setBounds(425, 120, 72, 48);

		}

		if (e.getSource() == labelPartido13) {

			labelPartido13.setBounds(50, 220, 72, 48);

		}

		if (e.getSource() == labelPartido14) {

			labelPartido14.setBounds(50, 290, 72, 48);

		}

		if (e.getSource() == labelPartido15) {

			labelPartido15.setBounds(125, 220, 72, 48);

		}

		if (e.getSource() == labelPartido16) {

			labelPartido16.setBounds(125, 290, 72, 48);

		}

		if (e.getSource() == labelPartido17) {

			labelPartido17.setBounds(200, 220, 72, 48);

		}

		if (e.getSource() == labelPartido18) {

			labelPartido18.setBounds(200, 290, 72, 48);

		}

		if (e.getSource() == labelPartido19) {

			labelPartido19.setBounds(275, 220, 72, 48);

		}

		if (e.getSource() == labelPartido20) {

			labelPartido20.setBounds(275, 290, 72, 48);

		}

		if (e.getSource() == labelPartido21) {

			labelPartido21.setBounds(350, 220, 72, 48);

		}

		if (e.getSource() == labelPartido22) {

			labelPartido22.setBounds(350, 290, 72, 48);

		}

		if (e.getSource() == labelPartido23) {

			labelPartido23.setBounds(425, 220, 72, 48);

		}

		if (e.getSource() == labelPartido24) {

			labelPartido24.setBounds(425, 290, 72, 48);

		}

		if (e.getSource() == labelPartido25) {

			labelPartido25.setBounds(50, 390, 72, 48);

		}

		if (e.getSource() == labelPartido26) {

			labelPartido26.setBounds(50, 460, 72, 48);

		}

		if (e.getSource() == labelPartido27) {

			labelPartido27.setBounds(125, 390, 72, 48);

		}

		if (e.getSource() == labelPartido28) {

			labelPartido28.setBounds(125, 460, 72, 48);

		}

		if (e.getSource() == labelPartido29) {

			labelPartido29.setBounds(200, 390, 72, 48);

		}

		if (e.getSource() == labelPartido30) {

			labelPartido30.setBounds(200, 460, 72, 48);

		}

		if (e.getSource() == labelPartido31) {

			labelPartido31.setBounds(275, 390, 72, 48);

		}

		if (e.getSource() == labelPartido32) {

			labelPartido32.setBounds(275, 460, 72, 48);

		}

		if (e.getSource() == labelPartido33) {

			labelPartido33.setBounds(350, 390, 72, 48);

		}

		if (e.getSource() == labelPartido34) {

			labelPartido34.setBounds(350, 460, 72, 48);

		}

		if (e.getSource() == labelPartido35) {

			labelPartido35.setBounds(425, 390, 72, 48);

		}

		if (e.getSource() == labelPartido36) {

			labelPartido36.setBounds(425, 460, 72, 48);

		}

	}

}
