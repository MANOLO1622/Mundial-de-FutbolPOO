package cl;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.*;
import gestor.Gestor;

public class MenuJugador extends JPanel implements ActionListener{
	
	private static Image imagen;
	public Usuario miUsuario = null;
	
	JButton boton4 = new JButton("Jugar");
	JButton boton5 = new JButton("Unirse a liga Publica");
	JButton boton6 = new JButton("Retirarse de Liga");
	JButton boton7 = new JButton("Cronograma");
	JButton boton8 = new JButton("Salir");
	
	JComboBox ligasRegistradas = new JComboBox();
	JButton btnUnirseLiga = new JButton("Unirse");
	JButton btncancelarInclusion = new JButton("Cancelar");
	
	JComboBox ligasRegistradaUsuario = new JComboBox();
	JButton btnRetirarseLiga = new JButton("Retirarse");
	JButton btnCancelarRetiro = new JButton("Cancelar");
	
	JLabel informacionLiga1 = new JLabel("");
	JLabel informacionLiga2 = new JLabel("");
	JLabel informacionLiga3 = new JLabel("");
	JLabel informacionLiga4 = new JLabel("");
	JLabel informacionLiga5 = new JLabel("");
	JLabel informacionLiga6 = new JLabel("");
	
	
	public MenuJugador(Usuario miUsuario) {
		
		this.setLayout(null);
		
		this.miUsuario = miUsuario;
		
		this.add(boton4);
		boton4.setBounds(10, 50, 180, 50);
		
		this.add(boton5);
		boton5.setBounds(10, 120, 180, 50);
		
		this.add(boton6);
		boton6.setBounds(10, 190, 180, 50);
		
		this.add(boton7);
		boton7.setBounds(10, 260, 180, 50);
		
		this.add(boton8);
		boton8.setBounds(10, 330, 180, 50);
		
		
		CL capaLogica = new CL();
		ArrayList<LigasPublicas> listaLigasPublicas = capaLogica.retornarLigasPublicas();
		int contadorLigasPublicas=listaLigasPublicas.size();
		
		ligasRegistradas.removeAllItems();
		
		for(LigasPublicas a: listaLigasPublicas) {
		
		ligasRegistradas.addItem(a.getNombreLiga());
		
		}
		
		
		if(ligasRegistradas.getItemCount()==0) {
			
			btnUnirseLiga.setEnabled(false);
			
		}else {
			
			btnUnirseLiga.setEnabled(true);
			
		}
		
		
		boton4.addActionListener(this);
		boton5.addActionListener(this);
		boton6.addActionListener(this);
		boton8.addActionListener(this);
		ligasRegistradas.addActionListener(this);
		btnUnirseLiga.addActionListener(this);
		btncancelarInclusion.addActionListener(this);
		btnCancelarRetiro.addActionListener(this);
		btnRetirarseLiga.addActionListener(this);
	}
	
	//------------------------------------------------------------------------------------------------- 
	


	public void actionPerformed(ActionEvent e) {	

		String estadoLigaPublica="";
		
		if(e.getSource()==boton4) {
			
			Ventana ventJuego = new Ventana(Gestor.retornarUsuario(this.miUsuario.getNombreUsuario()));
			ventJuego.ventanaJuego();
			
		}
		
		if(e.getSource() == boton5) {
			
			desabilitarMenuPrincipal();
			mostrarInformacionLiga();						
			
			this.add(ligasRegistradas);
			ligasRegistradas.setBounds(950, 50, 200, 30);			
			
			
			this.add(btnUnirseLiga);
			btnUnirseLiga.setBounds(1160, 50, 100, 30);
			
			this.add(btncancelarInclusion);
			btncancelarInclusion.setBounds(1160, 90, 100, 30);
			
			
			
		}
		
		if(e.getSource() == boton6) {
			
			
			this.add(ligasRegistradaUsuario);
			ligasRegistradaUsuario.setBounds(950, 50, 200, 30);
			
			this.add(btnRetirarseLiga);
			btnRetirarseLiga.setBounds(1160, 50, 100, 30);
			
			this.add(btnCancelarRetiro);
			btnCancelarRetiro.setBounds(1160, 90, 100, 30);
			
			this.miUsuario = Gestor.retornarUsuario(this.miUsuario.getNombreUsuario());
			
			LigasPrivadas ligaPrivadaTemp = this.miUsuario.getMiLigaPrivada();
			LigasPublicas ligaPublicaTemp = this.miUsuario.getMiLigaPublica();
			
			
			if(ligaPrivadaTemp == null && ligaPublicaTemp == null) {
				
				JOptionPane.showMessageDialog(null, "No hay ligas Privadas ni Publicas asociadas a " + this.miUsuario.getAvatar());
				
			}else {
				
				if(ligaPrivadaTemp == null) {
					
					JOptionPane.showMessageDialog(null, "No hay liga privada asociada a " + this.miUsuario.getAvatar());
					
					
				}else {
					ligasRegistradaUsuario.addItem(ligaPrivadaTemp.getNombreLiga());
				}
				
				if(ligaPublicaTemp == null) {
					
					JOptionPane.showMessageDialog(null, "No hay liga publica asociada a " + this.miUsuario.getAvatar());
					
				}else {
					ligasRegistradaUsuario.addItem(ligaPublicaTemp.getNombreLiga());
				}
					
			}

			if(ligaPrivadaTemp == null && ligaPublicaTemp == null) {
				
				btnRetirarseLiga.setEnabled(false);
				
			}else {
				
				btnRetirarseLiga.setEnabled(true);
				
			}
			
		}
		
		if (e.getSource() == ligasRegistradas) {
			
			btnUnirseLiga.setEnabled(true);
			
			LigasPublicas ligaPublicaTemp = Gestor.retornarLigaPublica((String) ligasRegistradas.getSelectedItem());				
			
			if(ligaPublicaTemp.getEstado() == true) {
				
				estadoLigaPublica = "Activo";
				
			}
			else {
				
				estadoLigaPublica = "Inactivo";
				
			}
			
			informacionLiga1.setText("Informacion de la Liga.");
			informacionLiga2.setText("Nombre de la Liga: " + ligaPublicaTemp.getNombreLiga());
			informacionLiga3.setText("Fecha de creacion: " + ligaPublicaTemp.getFechaCreacion());
			informacionLiga4.setText("Estado: " + estadoLigaPublica);
			informacionLiga5.setText("Puntos: " + ligaPublicaTemp.getPuntos());
			informacionLiga6.setText("Bono: " + ligaPublicaTemp.getBono());
			
		}
		
		if(e.getSource() == btnUnirseLiga) {
			
			LigasPublicas ligaPublicaTemporal = Gestor.retornarLigaPublica((String) ligasRegistradas.getSelectedItem());
			
			String opcionEscogida = (String) ligasRegistradas.getSelectedItem();
			this.setMiUsuario(Gestor.retornarUsuario(this.miUsuario.getNombreUsuario()));
			
			if(this.miUsuario.getMiLigaPublica() == null) {
				
				this.miUsuario.setMiLigaPublica(ligaPublicaTemporal);
				Gestor.asignarLigaPublicaUsuario(this.miUsuario.getNombreUsuario(), ligaPublicaTemporal);
				JOptionPane.showMessageDialog(null,this.miUsuario.getAvatar() + " fue agregado a la liga Publica: " + this.miUsuario.getMiLigaPublica().getNombreLiga());
				ligasRegistradas.removeAll();
				
			}
			else {
				
				JOptionPane.showMessageDialog(null,this.miUsuario.getAvatar() + " ya te encuentras registrado en la liga Publica: " + this.miUsuario.getMiLigaPublica().getNombreLiga());
				
			}
			
			this.miUsuario = Gestor.retornarUsuario(this.miUsuario.getNombreUsuario());
			removerMenus();
	
		}
		
		if(e.getSource()==btncancelarInclusion) {
			
			removerMenus();	
			ligasRegistradas.removeAll();
			
			
		}
		
		//Apartir de aqui agregare los eventos de retiro de liga publica en un usuario.
		
		

		if(e.getSource()==btnCancelarRetiro) {
			
			removerMenus();	
			
		}
		
		if(e.getSource() == btnRetirarseLiga) {
			
			String seleccion = (String)ligasRegistradaUsuario.getSelectedItem();

			
			
			if(seleccion.equals(this.miUsuario.getMiLigaPublica().getNombreLiga())) {
				JOptionPane.showMessageDialog(null, "Llego a publicas.");
				Gestor.removerLigaPublicaUsuario(this.miUsuario.getNombreUsuario());
				
			}else if(seleccion.equals(this.miUsuario.getMiLigaPrivada().getNombreLiga())) {
				
				JOptionPane.showMessageDialog(null, "Llego a privadas.");
				Gestor.removerLigaPrivadaUsuario(this.miUsuario.getNombreUsuario());
				
			}

			this.miUsuario = Gestor.retornarUsuario(this.miUsuario.getNombreUsuario());
			removerMenus();
			
		}
		
		if(e.getSource() == ligasRegistradaUsuario) {
			
			this.miUsuario = Gestor.retornarUsuario(this.miUsuario.getNombreUsuario());
			
			mostrarInformacionLiga();
					
		}
		
		
		//Evento de boton 8: Salir de la ventana.
		
		if(e.getSource()==boton8) {
			
			Ventana ventLogin = new Ventana(null);
			ventLogin.ventanaLogin();
			SwingUtilities.getWindowAncestor(getRootPane()).dispose();
			
		}
	}
	
	//-------------------------------------------------------------------------------------------------
	
	public Usuario getMiUsuario() {
		return miUsuario;
	}

	public void setMiUsuario(Usuario miUsuario) {
		this.miUsuario = miUsuario;
	}
	
	
	//-------------------------------------------------------------------------------------------------
	
	public void desabilitarMenuPrincipal() {
		
		boton4.setEnabled(false);
		boton5.setEnabled(false);
		boton6.setEnabled(false);
		boton7.setEnabled(false);
		boton8.setEnabled(false);
		btnUnirseLiga.setEnabled(false);
		
	}
	
	
	
	public void removerMenus() {
		
		informacionLiga1.setText("");
		informacionLiga2.setText("");
		informacionLiga3.setText("");
		informacionLiga4.setText("");
		informacionLiga5.setText("");
		informacionLiga6.setText("");
		
		boton4.setEnabled(true);
		boton5.setEnabled(true);
		boton6.setEnabled(true);
		boton7.setEnabled(true);
		boton8.setEnabled(true);
		
		this.remove(ligasRegistradas);
		this.remove(ligasRegistradaUsuario);
		
		this.remove(informacionLiga1);
		this.remove(informacionLiga2);
		this.remove(informacionLiga3);
		this.remove(informacionLiga4);
		this.remove(informacionLiga5);
		this.remove(informacionLiga6);
		
		this.remove(btnUnirseLiga);
		this.remove(btncancelarInclusion);
		this.remove(btnRetirarseLiga);
		this.remove(btnCancelarRetiro);
		
	}
	//-------------------------------------------------------------------------------------------------
	
	public void mostrarInformacionLiga() {
		
		
		this.add(informacionLiga1);
		informacionLiga1.setBounds(950,140, 600,40);
		informacionLiga1.setForeground(Color.ORANGE);
		informacionLiga1.setFont(new Font(informacionLiga1.getFont().getFontName(), Font.PLAIN, 30));
		
		
		this.add(informacionLiga2);
		informacionLiga2.setBounds(950,200, 600,40);
		informacionLiga2.setForeground(Color.ORANGE);
		informacionLiga2.setFont(new Font(informacionLiga2.getFont().getFontName(), Font.PLAIN, 30));
		
		this.add(informacionLiga3);
		informacionLiga3.setBounds(950,240, 600,40);
		informacionLiga3.setForeground(Color.ORANGE);
		informacionLiga3.setFont(new Font(informacionLiga3.getFont().getFontName(), Font.PLAIN, 30));
		
		this.add(informacionLiga4);
		informacionLiga4.setBounds(950,280, 600,40);
		informacionLiga4.setForeground(Color.ORANGE);
		informacionLiga4.setFont(new Font(informacionLiga4.getFont().getFontName(), Font.PLAIN, 30));
		
		this.add(informacionLiga5);
		informacionLiga5.setBounds(950,320, 600,40);
		informacionLiga5.setForeground(Color.ORANGE);
		informacionLiga5.setFont(new Font(informacionLiga5.getFont().getFontName(), Font.PLAIN, 30));
		
		this.add(informacionLiga6);
		informacionLiga6.setBounds(950,370, 600,40);
		informacionLiga6.setForeground(Color.ORANGE);
		informacionLiga6.setFont(new Font(informacionLiga6.getFont().getFontName(), Font.PLAIN, 30));
		
	}
	
	
	//-------------------------------------------------------------------------------------------------
	
    
    public void paintComponent(Graphics g) {
    	 
		int width = this.getSize().width;
		int height = this.getSize().height;
 
		this.setBackground("src\\graficos\\MenuJugador.jpg");
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
