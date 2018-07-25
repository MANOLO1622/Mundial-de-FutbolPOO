	package cl;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

import gestor.Gestor;

public class Juego extends JPanel implements ActionListener{
	
	public Usuario miUsuario;
	private static Image imagen;
	private static Gestor controlador = new Gestor();
	
	
	private JComboBox ligas = new JComboBox<Object>();
	private JComboBox equipos = new JComboBox<Object>();
	private JButton btnIngresoJuego = new JButton("Ingresar");
	private JLabel bandera = new JLabel();
	private ImageIcon banderaImagen;
	
	public Juego() {
		
		CL capaLogica = new CL();
		ArrayList<Equipo> listaEquipos = capaLogica.listarEquiposFIFA();
		
		this.setLayout(null);		
		
		this.add(ligas);
		ligas.setBounds(10, 10, 100, 25);
		ligas.addItem("Liga Publica");
		ligas.addItem("Liga Privada");
		
		this.add(equipos);
		equipos.setBounds(120, 10, 100, 25);
		
		this.add(bandera);
		bandera.setBounds(10, 45, 145, 87);
		
		

		for(Equipo e: listaEquipos) {
			
			equipos.addItem(e.getNombre());
			
		}
		
		
		equipos.addActionListener(this);
		
	}
		
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == equipos) {
			
			String b = controlador.retornarBanderaEquipo((String) equipos.getSelectedItem());
			System.out.println((String) equipos.getSelectedItem());
			banderaImagen = new ImageIcon(b);
			Icon icono = new ImageIcon(banderaImagen.getImage().getScaledInstance(bandera.getWidth(), bandera.getHeight(), Image.SCALE_DEFAULT));
			bandera.setIcon(icono);
			
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
