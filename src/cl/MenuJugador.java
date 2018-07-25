package cl;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import gestor.Gestor;

public class MenuJugador extends JPanel implements ActionListener{
	
	private static Image imagen;
	public Usuario miUsuario = null;
	
	JButton boton4;
	JButton boton5;
	JButton boton6;
	JButton boton7;
	JButton boton8;
	
	JComboBox ligasRegistradas = new JComboBox();
	JButton btnUnirseLiga = new JButton("Unirse");
	JButton btncancelarInclusion = new JButton("Cancelar");
	
	JComboBox ligasRegistradaUsuario = new JComboBox();
	JButton btnRetirarseLiga = new JButton("Retirarse");
	JButton btnCancelarRetiro = new JButton("Cancelar");
	
	JLabel informacionLiga1 = new JLabel("Informacion de la Liga");
	JLabel informacionLiga2 = new JLabel("");
	JLabel informacionLiga3 = new JLabel("");
	JLabel informacionLiga4 = new JLabel("");
	JLabel informacionLiga5 = new JLabel("");
	JLabel informacionLiga6 = new JLabel("");

	
	

	public MenuJugador(Usuario miUsuario) {
		
		this.setLayout(null);
		
		this.miUsuario = miUsuario;
		
		boton4 = new JButton("Jugar");
		boton4.setBounds(10, 50, 180, 50);
		this.add(boton4);
		
		boton5 = new JButton("Unirse a liga Publica");
		boton5.setBounds(10, 120, 180, 50);
		this.add(boton5);
		
		boton6 = new JButton("Retirarse de Liga");
		boton6.setBounds(10, 190, 180, 50);
		this.add(boton6);
		
		boton7 = new JButton("Cronograma");
		boton7.setBounds(10, 260, 180, 50);
		this.add(boton7);
		
		boton8 = new JButton("Salir");
		boton8.setBounds(10, 330, 180, 50);
		this.add(boton8);
		
		
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
	

	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
		
		CL capaLogica = new CL();
		ArrayList<LigasPublicas> listaLigasPublicas = capaLogica.listaLigasPublicas();
		int contadorLigasPublicas=listaLigasPublicas.size();
		String estadoLigaPublica="";
		
		if(e.getSource() == boton5) {
			
			boton4.setEnabled(false);
			boton5.setEnabled(false);
			boton6.setEnabled(false);
			boton7.setEnabled(false);
			boton8.setEnabled(false);
			
			this.add(informacionLiga1);
			informacionLiga1.setBounds(950,90, 300,20);
			informacionLiga1.setForeground(Color.ORANGE);
			
			
			this.add(informacionLiga2);
			informacionLiga2.setBounds(950,120, 300,20);
			informacionLiga2.setForeground(Color.ORANGE);
			
			this.add(informacionLiga3);
			informacionLiga3.setBounds(950,150, 300,20);
			informacionLiga3.setForeground(Color.ORANGE);
			
			this.add(informacionLiga4);
			informacionLiga4.setBounds(950,180, 300,20);
			informacionLiga4.setForeground(Color.ORANGE);
			
			this.add(informacionLiga5);
			informacionLiga5.setBounds(950,210, 300,20);
			informacionLiga5.setForeground(Color.ORANGE);
			
			this.add(informacionLiga6);
			informacionLiga6.setBounds(950,240, 300,20);
			informacionLiga6.setForeground(Color.ORANGE);
						
			
			this.add(ligasRegistradas);
			
			for(LigasPublicas a: listaLigasPublicas) {
				
				ligasRegistradas.addItem(a.getNombreLiga());
				contadorLigasPublicas = capaLogica.listaLigasPublicas().size();
				
			}
			
			ligasRegistradas.setBounds(950, 50, 200, 30);
			
			this.add(btnUnirseLiga);
			btnUnirseLiga.setBounds(1160, 50, 100, 30);
			
			this.add(btncancelarInclusion);
			btncancelarInclusion.setBounds(1160, 90, 100, 30);
			
			
			
		}
		
		if (e.getSource() == ligasRegistradas) {
			
			if(contadorLigasPublicas == 0) {
				
				JOptionPane.showMessageDialog(null, "No hay ligas publicas para mostrar.");
				
			}
			else {				
				
				LigasPublicas ligaPublicaTemp = Gestor.retornarLigaPublica((String) ligasRegistradas.getSelectedItem());				
				
				if(ligaPublicaTemp.getEstado() == true) {
					
					estadoLigaPublica = "Activo";
					
				}
				else {
					
					estadoLigaPublica = "Inactivo";
					
				}
				
				informacionLiga2.setText("Nombre de la Liga: " + ligaPublicaTemp.getNombreLiga());
				informacionLiga3.setText("Fecha de creacion: " + ligaPublicaTemp.getFechaCreacion());
				informacionLiga4.setText("Estado: " + estadoLigaPublica);
				informacionLiga5.setText("Puntos: " + ligaPublicaTemp.getPuntos());
				informacionLiga6.setText("Bono: " + ligaPublicaTemp.getBono());

			}			
		}
		
		
		
		
		
		
		
		if(e.getSource() == btnUnirseLiga) {
			
			LigasPublicas ligaPublicaTemporal = Gestor.retornarLigaPublica((String) ligasRegistradas.getSelectedItem());
			
			String opcionEscogida = (String) ligasRegistradas.getSelectedItem();
			this.setMiUsuario(Gestor.retornarUsuario(this.miUsuario.getNombreUsuario()));
			
			if(this.miUsuario.getMiLigaPublica() == null) {
				
				this.miUsuario.setMiLigaPublica(ligaPublicaTemporal);
				Gestor.asignarLigaPublicaUsuario(this.miUsuario.getNombreUsuario(), ligaPublicaTemporal);
				JOptionPane.showMessageDialog(null,this.miUsuario.getAvatar() + " fue agregado a la liga Publica: " + this.miUsuario.getMiLigaPublica().getNombreLiga());
				
			}
			else {
				
				JOptionPane.showMessageDialog(null,this.miUsuario.getAvatar() + " ya te encuentras registrado en la liga Publica: " + this.miUsuario.getMiLigaPublica().getNombreLiga());
				
			}
			
			removerMenus();
	
		}
		
		if(e.getSource()==btncancelarInclusion) {
			
			removerMenus();		
			
			
		}
		
		//Apartir de aqui agregare los eventos de retiro de liga publica en un usuario.
		
		
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
			
			if(ligaPrivadaTemp == null) {
				
				JOptionPane.showMessageDialog(null, "No hay ligas Privadas");
				
			}else {
				ligasRegistradaUsuario.addItem(ligaPrivadaTemp.getNombreLiga());
			}
			
			if(ligaPublicaTemp == null) {
				
				JOptionPane.showMessageDialog(null, "No hay ligas Publicas");
				
			}else {
				ligasRegistradaUsuario.addItem(ligaPublicaTemp.getNombreLiga());
			}
			
			
		}
		if(e.getSource()==btnCancelarRetiro) {
			
			removerMenus();	
			
		}
		
		if(e.getSource() == btnRetirarseLiga) {
			
			/*
			
			this.miUsuario = Gestor.retornarUsuario(this.miUsuario.getNombreUsuario());
			LigasPrivadas ligaPrivadaTemp = this.miUsuario.getMiLigaPrivada();
			LigasPublicas ligaPublicaTemp = this.miUsuario.getMiLigaPublica();
			
			
			
			
			
			Gestor.removerLigaPublicaUsuario(this.miUsuario.getMiLigaPublica().getNombreLiga(), ligaPublicaTemp);
			Gestor.removerLigaPrivadaUsuario(this.miUsuario.getMiLigaPrivada().getNombreLiga(), ligaPrivadaTemp);
			
			
			*/
			
			
			removerMenus();
			
		}
		
		if(e.getSource() == ligasRegistradaUsuario) {
			
			this.miUsuario = Gestor.retornarUsuario(this.miUsuario.getNombreUsuario());
			
			this.add(informacionLiga1);
			informacionLiga1.setBounds(950,90, 300,20);
			informacionLiga1.setForeground(Color.ORANGE);
			
			
			this.add(informacionLiga2);
			informacionLiga2.setBounds(950,120, 300,20);
			informacionLiga2.setForeground(Color.ORANGE);
			
			this.add(informacionLiga3);
			informacionLiga3.setBounds(950,150, 300,20);
			informacionLiga3.setForeground(Color.ORANGE);
			
			this.add(informacionLiga4);
			informacionLiga4.setBounds(950,180, 300,20);
			informacionLiga4.setForeground(Color.ORANGE);
			
			this.add(informacionLiga5);
			informacionLiga5.setBounds(950,210, 300,20);
			informacionLiga5.setForeground(Color.ORANGE);
			
			this.add(informacionLiga6);
			informacionLiga6.setBounds(950,240, 300,20);
			informacionLiga6.setForeground(Color.ORANGE);
			
			
		}
		
		
		//Evento de boton 8: Salir de la ventana.
		
		if(e.getSource()==boton8) {
			
			
			
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
