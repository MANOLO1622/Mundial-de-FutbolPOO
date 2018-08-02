package cl;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

import gestor.Gestor;

public class Juego extends JPanel implements ActionListener{
	
	public Usuario miUsuarioActual;
	private static Image imagen;
	private static Gestor controlador = new Gestor();
	
	
	private JComboBox ligas = new JComboBox<Object>();
	private JComboBox equipos = new JComboBox<Object>();
	private JButton btnIngresoJuego = new JButton("Ingresar");
	private JButton btnSalir = new JButton("Salir");
	private JLabel bandera = new JLabel();
	private ImageIcon banderaImagen;

	//Estos componentes se utilizaran para poder mostrar la informacion de la liga.
	
	private JLabel informacionLiga1 = new JLabel();
	private JLabel informacionLiga2 = new JLabel();
	private JLabel informacionLiga3 = new JLabel();
	private JLabel informacionLiga4 = new JLabel();
	private JLabel informacionLiga5 = new JLabel();
	private JLabel informacionLiga6 = new JLabel();
	
	//Estos componentes se utilizaran para poder mostrar las bandera de los paises dentro de los cuadros de juego.
	
	private JLabel labelPais1 = new JLabel();
	private JLabel labelPais2 = new JLabel();
	private JLabel labelPais3 = new JLabel();
	private JLabel labelPais4 = new JLabel();
	private JLabel labelPais5 = new JLabel();
	private JLabel labelPais6 = new JLabel();
	private JLabel labelPais7 = new JLabel();
	private JLabel labelPais8 = new JLabel();
	private JLabel labelPais9 = new JLabel();
	private JLabel labelPais10 = new JLabel();
	private JLabel labelPais11 = new JLabel();
	private JLabel labelPais12 = new JLabel();
	private JLabel labelPais13 = new JLabel();
	private JLabel labelPais14 = new JLabel();
	private JLabel labelPais15 = new JLabel();
	private JLabel labelPais16 = new JLabel();
	private JLabel labelPais17 = new JLabel();
	private JLabel labelPais18 = new JLabel();
	private JLabel labelPais19 = new JLabel();
	private JLabel labelPais20 = new JLabel();
	private JLabel labelPais21 = new JLabel();
	private JLabel labelPais22 = new JLabel();
	private JLabel labelPais23 = new JLabel();
	private JLabel labelPais24 = new JLabel();
	private JLabel labelPais25 = new JLabel();
	private JLabel labelPais26 = new JLabel();
	private JLabel labelPais27 = new JLabel();
	private JLabel labelPais28 = new JLabel();
	private JLabel labelPais29 = new JLabel();
	private JLabel labelPais30 = new JLabel();
	private JLabel labelPais31 = new JLabel();
	private JLabel labelPais32 = new JLabel();
	
	
	private ImageIcon imagenPais1;
	private ImageIcon imagenPais2;
	private ImageIcon imagenPais3;
	private ImageIcon imagenPais4;
	private ImageIcon imagenPais5;
	private ImageIcon imagenPais6;
	private ImageIcon imagenPais7;
	private ImageIcon imagenPais8;
	private ImageIcon imagenPais9;
	private ImageIcon imagenPais10;
	private ImageIcon imagenPais11;
	private ImageIcon imagenPais12;
	private ImageIcon imagenPais13;
	private ImageIcon imagenPais14;
	private ImageIcon imagenPais15;
	private ImageIcon imagenPais16;
	private ImageIcon imagenPais17;
	private ImageIcon imagenPais18;
	private ImageIcon imagenPais19;
	private ImageIcon imagenPais20;
	private ImageIcon imagenPais21;
	private ImageIcon imagenPais22;
	private ImageIcon imagenPais23;
	private ImageIcon imagenPais24;
	private ImageIcon imagenPais25;
	private ImageIcon imagenPais26;
	private ImageIcon imagenPais27;
	private ImageIcon imagenPais28;
	private ImageIcon imagenPais29;
	private ImageIcon imagenPais30;
	private ImageIcon imagenPais31;
	private ImageIcon imagenPais32;
	
	

	
	
	public Juego(Usuario miUsuarioActual) {
		
		this.miUsuarioActual = Gestor.retornarUsuario(miUsuarioActual.getNombreUsuario());
		
		this.setLayout(null);
		inicializarComponentes();
		
		CL capaLogica = new CL();
		ArrayList<Equipo> listaEquipos = capaLogica.listarEquiposFIFA();
		

		this.add(btnSalir);
		btnSalir.setBounds(230, 10, 100, 25);
		
		//-----------Eventos.
		
		

		equipos.addActionListener(this);
		ligas.addActionListener(this);
		btnSalir.addActionListener(this);
	}
		
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == equipos) {
			
			String b = controlador.retornarBanderaEquipo((String) equipos.getSelectedItem());
			banderaImagen = new ImageIcon(b);
			Icon icono = new ImageIcon(banderaImagen.getImage().getScaledInstance(bandera.getWidth(), bandera.getHeight(), Image.SCALE_DEFAULT));
			bandera.setIcon(icono);
			
			
		}
		

		if(e.getSource()==ligas) {
			
			if(ligas.getSelectedIndex() == 0 ) {
				
				if(this.miUsuarioActual.getMiLigaPublica() == null) {
					
					mostrarInformacionLiga(2);
					JOptionPane.showMessageDialog(null, "No hay liga Publica asociada al Jugador " + this.miUsuarioActual.getAvatar());
					
					
				}else {
					
					mostrarInformacionLiga(0);
					mostrarCuadros();
					
				}
				
			}
			else if(ligas.getSelectedIndex() == 1) {
				
				if(this.miUsuarioActual.getMiLigaPrivada() == null) {
					
					mostrarInformacionLiga(2);
					JOptionPane.showMessageDialog(null, "No hay liga Privada asociada al Jugador " + this.miUsuarioActual.getAvatar());
					
				}else {
					
					mostrarInformacionLiga(1);
					
				}
				
			}
			
		}
		if(e.getSource()==btnSalir) {
			
			SwingUtilities.getWindowAncestor(getRootPane()).dispose();
			
		}
		
	}
	


	public void mostrarInformacionLiga(int tipoLiga) {
	
		informacionLiga1.setBounds(10,110, 600,100);
		informacionLiga1.setForeground(new Color(139,252,99));
		informacionLiga1.setFont(new Font(informacionLiga1.getFont().getFontName(), Font.PLAIN, 15));
		
		
		this.add(informacionLiga2);
		informacionLiga2.setBounds(10,160, 600,100);
		informacionLiga2.setForeground(new Color(139,252,99));
		informacionLiga2.setFont(new Font(informacionLiga2.getFont().getFontName(), Font.PLAIN, 15));
		
		this.add(informacionLiga3);
		informacionLiga3.setBounds(10,190, 600,100);
		informacionLiga3.setForeground(new Color(139,252,99));
		informacionLiga3.setFont(new Font(informacionLiga3.getFont().getFontName(), Font.PLAIN, 15));
		
		this.add(informacionLiga4);
		informacionLiga4.setBounds(10,220, 600,100);
		informacionLiga4.setForeground(new Color(139,252,99));
		informacionLiga4.setFont(new Font(informacionLiga4.getFont().getFontName(), Font.PLAIN, 15));
		
		this.add(informacionLiga5);
		informacionLiga5.setBounds(10,250, 600,100);
		informacionLiga5.setForeground(new Color(139,252,99));
		informacionLiga5.setFont(new Font(informacionLiga5.getFont().getFontName(), Font.PLAIN, 15));
		
		this.add(informacionLiga6);
		informacionLiga6.setBounds(10,280, 600,100);
		informacionLiga6.setForeground(new Color(139,252,99));
		informacionLiga6.setFont(new Font(informacionLiga6.getFont().getFontName(), Font.PLAIN, 15));
		

		switch(tipoLiga) {
		
		case 0:
			
			informacionLiga1.setText("Informacion de la Liga " + this.miUsuarioActual.getMiLigaPublica().getNombreLiga());
			informacionLiga2.setText("Nombre de la Liga: " + this.miUsuarioActual.getMiLigaPublica().getNombreLiga());
			informacionLiga3.setText("Fecha de creacion: " + this.miUsuarioActual.getMiLigaPublica().getFechaCreacion());
			informacionLiga4.setText("Estado: " + this.miUsuarioActual.getMiLigaPublica().getEstado());
			informacionLiga5.setText("Puntos: " + this.miUsuarioActual.getMiLigaPublica().getPuntos());
			informacionLiga6.setText("Bono: " + this.miUsuarioActual.getMiLigaPublica().getBono());
			
			break;
			
		case 1:
			
			informacionLiga1.setText("Informacion de la Liga " + this.miUsuarioActual.getMiLigaPrivada().getNombreLiga());
			informacionLiga2.setText("Nombre de la Liga: " + this.miUsuarioActual.getMiLigaPrivada().getNombreLiga());
			informacionLiga3.setText("Fecha de creacion: " + this.miUsuarioActual.getMiLigaPrivada().getFechaCreacion());
			informacionLiga4.setText("Estado: " + this.miUsuarioActual.getMiLigaPrivada().getEstado());
			informacionLiga5.setText("Puntos: " + this.miUsuarioActual.getMiLigaPrivada().getPuntos());
			informacionLiga6.setText("Bono: " + this.miUsuarioActual.getMiLigaPrivada().getBono());
			
			break;
			
		case 2: 
			
			informacionLiga1.setText("");
			informacionLiga2.setText("");
			informacionLiga3.setText("");
			informacionLiga4.setText("");
			informacionLiga5.setText("");
			informacionLiga6.setText("");
			
			break;
			
		default:
			
			JOptionPane.showMessageDialog(null, "Valor invalido\n1 para liga privada.\n0 para liga publica.");
			
			break;
		
		
		}
		
		
	}
	
	
	public void removerComponentes() {
		
		this.remove(ligas);
		this.remove(equipos);
		this.remove(btnIngresoJuego);
		this.remove(btnSalir);
		this.remove(bandera);
		
		this.remove(informacionLiga1);
		this.remove(informacionLiga2);
		this.remove(informacionLiga3);
		this.remove(informacionLiga4);
		this.remove(informacionLiga5);
		this.remove(informacionLiga6);
		this.remove(btnSalir);
		
	}
	
	public void inicializarComponentes() {
		
		
		CL capaLogica = new CL();
		ArrayList<Equipo> listaEquipos = capaLogica.listarEquiposFIFA();
		

		this.add(ligas);
		ligas.setBounds(10, 10, 100, 25);
		ligas.addItem("Liga Publica");
		ligas.addItem("Liga Privada");
		


		this.add(equipos);
		equipos.setBounds(120, 10, 100, 25);

		
		for(Equipo e: listaEquipos) {
			
			equipos.addItem(e.getNombre());
			
		}
		
		this.add(bandera);
		bandera.setBounds(10, 45, 145, 87);

		this.add(btnSalir);
		btnSalir.setBounds(1530, 830, 100, 60);

	}
	
	//----------------------------------------------------------------------------------------------------------
	
	public void mostrarCuadros() {
		
		
		int ancho = 97;
		int alto = 64; 
		
		//-----------------------------------------------Primer Cuadro
		
		this.add(labelPais1);
		labelPais1.setBounds(335, 40, ancho, alto);

		this.add(labelPais2);
		labelPais2.setBounds(435, 40, ancho, alto);
		
		this.add(labelPais3);
		labelPais3.setBounds(335, 107, ancho, alto);

		this.add(labelPais4);
		labelPais4.setBounds(435, 107, ancho, alto);
		
		//-----------------------------------------------Segundo Cuadro
		
		this.add(labelPais5);
		labelPais5.setBounds(552, 40, ancho, alto);

		this.add(labelPais6);
		labelPais6.setBounds(652, 40, ancho, alto);

		this.add(labelPais7);
		labelPais7.setBounds(552, 107, ancho, alto);
		
		this.add(labelPais8);
		labelPais8.setBounds(652, 107, ancho, alto);
		
		//----------------------------------------------Tercer Cuadro

		this.add(labelPais9);
		labelPais9.setBounds(769, 40, ancho, alto);
		
		this.add(labelPais10);
		labelPais10.setBounds(869, 40, ancho, alto);
		
		this.add(labelPais11);
		labelPais11.setBounds(769, 107, ancho, alto);

		this.add(labelPais12);
		labelPais12.setBounds(869, 107, ancho, alto);
		
		//-----------------------------------------------Cuarto Cuadro
		
		this.add(labelPais13);
		labelPais13.setBounds(986, 40, ancho, alto);

		this.add(labelPais14);
		labelPais14.setBounds(1086, 40, ancho, alto);
		
		this.add(labelPais15);
		labelPais15.setBounds(986, 107, ancho, alto);

		this.add(labelPais16);
		labelPais16.setBounds(1086, 107, ancho, alto);
		
		//----------------------------------------------Quinto Cuadro
		
		this.add(labelPais17);
		labelPais17.setBounds(335, 191, ancho, alto);

		this.add(labelPais18);
		labelPais18.setBounds(435, 191, ancho, alto);
		
		this.add(labelPais19);
		labelPais19.setBounds(335, 258, ancho, alto);

		this.add(labelPais20);
		labelPais20.setBounds(435, 258, ancho, alto);
		
		//-----------------------------------------------Sexto Cuadro
		
		this.add(labelPais21);
		labelPais21.setBounds(552, 191, ancho, alto);

		this.add(labelPais22);
		labelPais22.setBounds(652, 191, ancho, alto);
		
		this.add(labelPais23);
		labelPais23.setBounds(552, 258, ancho, alto);

		this.add(labelPais24);
		labelPais24.setBounds(652, 258, ancho, alto);
		
		//----------------------------------------------Septimo Cuadro
		
		this.add(labelPais25);
		labelPais25.setBounds(769, 191, ancho, alto);

		this.add(labelPais26);
		labelPais26.setBounds(869, 191, ancho, alto);
		
		this.add(labelPais27);
		labelPais27.setBounds(769, 258, ancho, alto);

		this.add(labelPais28);
		labelPais28.setBounds(869, 258, ancho, alto);
		
		//----------------------------------------------Octavo Cuadro
		
		this.add(labelPais29);
		labelPais29.setBounds(986, 191, ancho, alto);

		this.add(labelPais30);
		labelPais30.setBounds(1086, 191, ancho, alto);
		
		this.add(labelPais31);
		labelPais31.setBounds(986, 258, ancho, alto);

		this.add(labelPais32);
		labelPais32.setBounds(1086, 258, ancho, alto);
		

		//----------------------------------------------
		
		mostrarBanderas( ancho,  alto);
		
	}
	
	
	public void mostrarBanderas(int ancho, int alto) {
		
		
		Equipo[] temp1= this.miUsuarioActual.getMiLigaPublica().getMundialAnfitrion().getRonda1().getPrimerCuadro();
		Equipo[] temp2= this.miUsuarioActual.getMiLigaPublica().getMundialAnfitrion().getRonda1().getSegundoCuadro();
		Equipo[] temp3= this.miUsuarioActual.getMiLigaPublica().getMundialAnfitrion().getRonda1().getTercerCuadro();
		Equipo[] temp4= this.miUsuarioActual.getMiLigaPublica().getMundialAnfitrion().getRonda1().getCuartoCuadro();
		Equipo[] temp5= this.miUsuarioActual.getMiLigaPublica().getMundialAnfitrion().getRonda1().getQuintoCuadro();
		Equipo[] temp6= this.miUsuarioActual.getMiLigaPublica().getMundialAnfitrion().getRonda1().getSextoCuadro();
		Equipo[] temp7= this.miUsuarioActual.getMiLigaPublica().getMundialAnfitrion().getRonda1().getSeptimoCuadro();
		Equipo[] temp8= this.miUsuarioActual.getMiLigaPublica().getMundialAnfitrion().getRonda1().getOctavoCuadro();
		
		//-----------------------------------------------------------------Primer cuadro
		
		imagenPais1 = new ImageIcon(temp1[0].getBandera());
		Icon icono1 = new ImageIcon(imagenPais1.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPais1.setIcon(icono1);
		
		imagenPais2 = new ImageIcon(temp1[1].getBandera());
		Icon icono2 = new ImageIcon(imagenPais2.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPais2.setIcon(icono2);
		
		imagenPais3 = new ImageIcon(temp1[2].getBandera());
		Icon icono3 = new ImageIcon(imagenPais3.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPais3.setIcon(icono3);
		
		imagenPais4 = new ImageIcon(temp1[3].getBandera());
		Icon icono4 = new ImageIcon(imagenPais4.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPais4.setIcon(icono4);
		
		//-----------------------------------------------Segundo Cuadro
		
		imagenPais5 = new ImageIcon(temp2[0].getBandera());
		Icon icono5 = new ImageIcon(imagenPais5.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPais5.setIcon(icono5);
		
		imagenPais6 = new ImageIcon(temp2[1].getBandera());
		Icon icono6 = new ImageIcon(imagenPais6.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPais6.setIcon(icono6);
		
		imagenPais7 = new ImageIcon(temp2[2].getBandera());
		Icon icono7 = new ImageIcon(imagenPais7.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPais7.setIcon(icono7);
		
		imagenPais8 = new ImageIcon(temp2[3].getBandera());
		Icon icono8 = new ImageIcon(imagenPais8.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPais8.setIcon(icono8);
				
		//----------------------------------------------Tercer Cuadro

		imagenPais9 = new ImageIcon(temp3[0].getBandera());
		Icon icono9 = new ImageIcon(imagenPais9.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPais9.setIcon(icono9);
		
		imagenPais10 = new ImageIcon(temp3[1].getBandera());
		Icon icono10 = new ImageIcon(imagenPais10.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPais10.setIcon(icono10);
		
		imagenPais11 = new ImageIcon(temp3[2].getBandera());
		Icon icono11 = new ImageIcon(imagenPais11.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPais11.setIcon(icono11);
		
		imagenPais12 = new ImageIcon(temp3[3].getBandera());
		Icon icono12 = new ImageIcon(imagenPais12.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPais12.setIcon(icono12);		
		
		//-----------------------------------------------Cuarto Cuadro
			
		imagenPais13 = new ImageIcon(temp4[0].getBandera());
		Icon icono13 = new ImageIcon(imagenPais13.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPais13.setIcon(icono13);
		
		imagenPais14 = new ImageIcon(temp4[1].getBandera());
		Icon icono14 = new ImageIcon(imagenPais14.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPais14.setIcon(icono14);
		
		imagenPais15 = new ImageIcon(temp4[2].getBandera());
		Icon icono15 = new ImageIcon(imagenPais15.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPais15.setIcon(icono15);
		
		imagenPais16 = new ImageIcon(temp4[3].getBandera());
		Icon icono16 = new ImageIcon(imagenPais16.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPais16.setIcon(icono16);	
				
		//----------------------------------------------Quinto Cuadro
			
		imagenPais17 = new ImageIcon(temp5[0].getBandera());
		Icon icono17 = new ImageIcon(imagenPais17.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPais17.setIcon(icono17);
		
		imagenPais18 = new ImageIcon(temp5[1].getBandera());
		Icon icono18 = new ImageIcon(imagenPais18.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPais18.setIcon(icono18);
		
		imagenPais19 = new ImageIcon(temp5[2].getBandera());
		Icon icono19 = new ImageIcon(imagenPais19.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPais19.setIcon(icono19);
		
		imagenPais20 = new ImageIcon(temp5[3].getBandera());
		Icon icono20 = new ImageIcon(imagenPais20.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPais20.setIcon(icono20);
				
		//-----------------------------------------------Sexto Cuadro
			
		imagenPais21 = new ImageIcon(temp6[0].getBandera());
		Icon icono21 = new ImageIcon(imagenPais21.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPais21.setIcon(icono21);
		
		imagenPais22 = new ImageIcon(temp6[1].getBandera());
		Icon icono22 = new ImageIcon(imagenPais22.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPais22.setIcon(icono22);
		
		imagenPais23 = new ImageIcon(temp6[2].getBandera());
		Icon icono23 = new ImageIcon(imagenPais23.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPais23.setIcon(icono23);
		
		imagenPais24 = new ImageIcon(temp6[3].getBandera());
		Icon icono24 = new ImageIcon(imagenPais24.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPais24.setIcon(icono24);
				
		//----------------------------------------------Septimo Cuadro
				
		imagenPais25 = new ImageIcon(temp7[0].getBandera());
		Icon icono25 = new ImageIcon(imagenPais25.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPais25.setIcon(icono25);
		
		imagenPais26 = new ImageIcon(temp7[1].getBandera());
		Icon icono26 = new ImageIcon(imagenPais26.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPais26.setIcon(icono26);
		
		imagenPais27 = new ImageIcon(temp7[3].getBandera());
		Icon icono27 = new ImageIcon(imagenPais27.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPais27.setIcon(icono27);
		
		imagenPais28 = new ImageIcon(temp7[2].getBandera());
		Icon icono28 = new ImageIcon(imagenPais28.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPais28.setIcon(icono28);
		
		//----------------------------------------------Octavo Cuadro
		
		imagenPais29 = new ImageIcon(temp7[3].getBandera());
		Icon icono29 = new ImageIcon(imagenPais29.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPais29.setIcon(icono29);
	
		imagenPais30 = new ImageIcon(temp8[0].getBandera());
		Icon icono30 = new ImageIcon(imagenPais30.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPais30.setIcon(icono30);
		
		imagenPais31 = new ImageIcon(temp8[1].getBandera());
		Icon icono31 = new ImageIcon(imagenPais31.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPais31.setIcon(icono31);
		
		imagenPais32 = new ImageIcon(temp8[2].getBandera());
		Icon icono32 = new ImageIcon(imagenPais32.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		labelPais32.setIcon(icono32);
				
		
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
