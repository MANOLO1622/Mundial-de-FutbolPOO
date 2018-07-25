	package cl;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

import gestor.Gestor;

public class Juego extends JPanel implements ActionListener{
	
	private Usuario miUsuarioActual;
	
	private static Image imagen;
	private static Gestor controlador = new Gestor();
	
	
	private JComboBox ligas = new JComboBox<Object>();
	private JComboBox equipos = new JComboBox<Object>();
	private JButton btnIngresoJuego = new JButton("Ingresar");
	private JLabel bandera = new JLabel();
	private ImageIcon banderaImagen;
	
	private JLabel informacionLiga1 = new JLabel("Informacion de la Liga");
	private JLabel informacionLiga2 = new JLabel("");
	private JLabel informacionLiga3 = new JLabel("");
	private JLabel informacionLiga4 = new JLabel("");
	private JLabel informacionLiga5 = new JLabel("");
	private JLabel informacionLiga6 = new JLabel("");
	
	
	
	
	public Juego(Usuario miUsuarioActual) {
		
		this.miUsuarioActual = miUsuarioActual;
		
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
		ligas.addActionListener(this);
		
	}
		
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == equipos) {
			
			String b = controlador.retornarBanderaEquipo((String) equipos.getSelectedItem());
			System.out.println((String) equipos.getSelectedItem());
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
		
	}
	
	
	
	
	
	public void mostrarInformacionLiga(int tipoLiga) {
		
		this.add(informacionLiga1);
		informacionLiga1.setBounds(10,110, 600,100);
		informacionLiga1.setForeground(Color.WHITE);
		informacionLiga1.setFont(new Font(informacionLiga1.getFont().getFontName(), Font.PLAIN, 30));
		
		this.add(informacionLiga2);
		informacionLiga2.setBounds(10,160, 600,100);
		informacionLiga2.setForeground(Color.WHITE);
		informacionLiga2.setFont(new Font(informacionLiga2.getFont().getFontName(), Font.PLAIN, 30));
		
		this.add(informacionLiga3);
		informacionLiga3.setBounds(10,190, 600,100);
		informacionLiga3.setForeground(Color.WHITE);
		informacionLiga3.setFont(new Font(informacionLiga3.getFont().getFontName(), Font.PLAIN, 30));
		
		this.add(informacionLiga4);
		informacionLiga4.setBounds(10,220, 600,100);
		informacionLiga4.setForeground(Color.WHITE);
		informacionLiga4.setFont(new Font(informacionLiga4.getFont().getFontName(), Font.PLAIN, 30));
		
		this.add(informacionLiga5);
		informacionLiga5.setBounds(10,250, 600,100);
		informacionLiga5.setForeground(Color.WHITE);
		informacionLiga5.setFont(new Font(informacionLiga5.getFont().getFontName(), Font.PLAIN, 30));
		
		this.add(informacionLiga6);
		informacionLiga6.setBounds(10,280, 600,100);
		informacionLiga6.setForeground(Color.WHITE);
		informacionLiga6.setFont(new Font(informacionLiga6.getFont().getFontName(), Font.PLAIN, 30));
		

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
