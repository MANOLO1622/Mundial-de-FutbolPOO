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
	private JEditorPane paisesIncluidos = new JEditorPane();
	
	private JLabel informacionLiga1 = new JLabel();
	private JLabel informacionLiga2 = new JLabel();
	private JLabel informacionLiga3 = new JLabel();
	private JLabel informacionLiga4 = new JLabel();
	private JLabel informacionLiga5 = new JLabel();
	private JLabel informacionLiga6 = new JLabel();
	
	
	
	
	
	
	
	public Juego(Usuario miUsuarioActual) {
		
		this.miUsuarioActual = Gestor.retornarUsuario(miUsuarioActual.getNombreUsuario());
		
//		this.setLayout(null);
		this.setLayout(new GridBagLayout());
		inicializarComponentes();
		
		CL capaLogica = new CL();
		ArrayList<Equipo> listaEquipos = capaLogica.listarEquiposFIFA();
		

//		this.add(btnSalir);
//		btnSalir.setBounds(230, 10, 100, 25);
		
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
		
		String paisesMundial="";
		GridBagConstraints gbc = new GridBagConstraints();
		
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(informacionLiga1, gbc);
//		informacionLiga1.setBounds(10,110, 600,100);
		informacionLiga1.setForeground(new Color(139,252,99));
		informacionLiga1.setFont(new Font(informacionLiga1.getFont().getFontName(), Font.PLAIN, 30));
		
		
		gbc.gridy++;
		this.add(informacionLiga2, gbc);
//		informacionLiga2.setBounds(10,160, 600,100);
		informacionLiga2.setForeground(new Color(139,252,99));
		informacionLiga2.setFont(new Font(informacionLiga2.getFont().getFontName(), Font.PLAIN, 30));
		
		gbc.gridy++;
		this.add(informacionLiga3, gbc);
//		informacionLiga3.setBounds(10,190, 600,100);
		informacionLiga3.setForeground(new Color(139,252,99));
		informacionLiga3.setFont(new Font(informacionLiga3.getFont().getFontName(), Font.PLAIN, 30));
		
		gbc.gridy++;
		this.add(informacionLiga4, gbc);
//		informacionLiga4.setBounds(10,220, 600,100);
		informacionLiga4.setForeground(new Color(139,252,99));
		informacionLiga4.setFont(new Font(informacionLiga4.getFont().getFontName(), Font.PLAIN, 30));
		
		gbc.gridy++;
		this.add(informacionLiga5, gbc);
//		informacionLiga5.setBounds(10,250, 600,100);
		informacionLiga5.setForeground(new Color(139,252,99));
		informacionLiga5.setFont(new Font(informacionLiga5.getFont().getFontName(), Font.PLAIN, 30));
		
		gbc.gridy++;
		this.add(informacionLiga6, gbc);
//		informacionLiga6.setBounds(10,280, 600,100);
		informacionLiga6.setForeground(new Color(139,252,99));
		informacionLiga6.setFont(new Font(informacionLiga6.getFont().getFontName(), Font.PLAIN, 30));
		

		switch(tipoLiga) {
		
		case 0:
			
			gbc.gridx = 1;
			gbc.gridy = 1;
			gbc.gridheight = 10;
			this.add(paisesIncluidos, gbc);
			paisesIncluidos.setEditable(false);
			paisesIncluidos.setFont(new Font(informacionLiga1.getFont().getFontName(), Font.PLAIN, 13));
//			paisesIncluidos.setBounds(500, 10, 300, 630);
			
			informacionLiga1.setText("Informacion de la Liga " + this.miUsuarioActual.getMiLigaPublica().getNombreLiga());
			informacionLiga2.setText("Nombre de la Liga: " + this.miUsuarioActual.getMiLigaPublica().getNombreLiga());
			informacionLiga3.setText("Fecha de creacion: " + this.miUsuarioActual.getMiLigaPublica().getFechaCreacion());
			informacionLiga4.setText("Estado: " + this.miUsuarioActual.getMiLigaPublica().getEstado());
			informacionLiga5.setText("Puntos: " + this.miUsuarioActual.getMiLigaPublica().getPuntos());
			informacionLiga6.setText("Bono: " + this.miUsuarioActual.getMiLigaPublica().getBono());
			
			paisesMundial = "Paises Registrados en Mundial: "+this.miUsuarioActual.getMiLigaPublica().getMundialAnfitrion().getNombreMundial()+"\n\n";
			
			for(Equipo e: this.miUsuarioActual.getMiLigaPublica().getMundialAnfitrion().getEquiposMundial()) {
				
				paisesMundial = paisesMundial + e.getNombre() +"\n";
				
			}
			System.out.println(paisesMundial);
			paisesIncluidos.setText(paisesMundial);
			
			break;
			
		case 1:
			
			this.add(paisesIncluidos);
			paisesIncluidos.setEditable(false);
			paisesIncluidos.setBackground(new Color(139,252,99));
			paisesIncluidos.setFont(new Font(informacionLiga1.getFont().getFontName(), Font.PLAIN, 13));
			paisesIncluidos.setBounds(500, 10, 300, 630);
			
			informacionLiga1.setText("Informacion de la Liga " + this.miUsuarioActual.getMiLigaPrivada().getNombreLiga());
			informacionLiga2.setText("Nombre de la Liga: " + this.miUsuarioActual.getMiLigaPrivada().getNombreLiga());
			informacionLiga3.setText("Fecha de creacion: " + this.miUsuarioActual.getMiLigaPrivada().getFechaCreacion());
			informacionLiga4.setText("Estado: " + this.miUsuarioActual.getMiLigaPrivada().getEstado());
			informacionLiga5.setText("Puntos: " + this.miUsuarioActual.getMiLigaPrivada().getPuntos());
			informacionLiga6.setText("Bono: " + this.miUsuarioActual.getMiLigaPrivada().getBono());
			paisesIncluidos.setText("Mundial "+this.miUsuarioActual.getMiLigaPublica().getMundialAnfitrion().getNombreMundial() +"\n"
					+ "Paises Registrados en Mundial:");
			
			break;
			
		case 2: 
			
			informacionLiga1.setText("");
			informacionLiga2.setText("");
			informacionLiga3.setText("");
			informacionLiga4.setText("");
			informacionLiga5.setText("");
			informacionLiga6.setText("");
			paisesIncluidos.setText("No hay informacion para mostrar.");
			
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
		this.remove(paisesIncluidos);
		
	}
	
	public void inicializarComponentes() {
		
		
		CL capaLogica = new CL();
		ArrayList<Equipo> listaEquipos = capaLogica.listarEquiposFIFA();
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
//		ligas.setSize(100, 25);
		this.add(ligas, gbc);
//		ligas.setBounds(10, 10, 100, 25);
		ligas.addItem("Liga Publica");
		ligas.addItem("Liga Privada");
		

		gbc.gridx++;
//		equipos.setSize(100, 25);
		this.add(equipos, gbc);
//		equipos.setBounds(120, 10, 100, 25);

		
		for(Equipo e: listaEquipos) {
			
			equipos.addItem(e.getNombre());
			
		}
		

		gbc.gridx++;
		gbc.gridwidth = 2;
		gbc.gridheight = 2;
		gbc.weighty = 1.0;
//		bandera.setSize(145, 87);
		this.add(bandera, gbc);
//		bandera.setBounds(10, 45, 145, 87);


		gbc.gridwidth = 1;
		gbc.gridheight = 1;
//		btnSalir.setSize(400, 60);
		this.add(btnSalir, gbc);
//		btnSalir.setBounds(1530, 830, 100, 60);

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
