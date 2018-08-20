package cl;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.*;
import gestor.Gestor;
import multis.MultiLigasPrivadas;
import multis.MultiLigasPublicas;
import multis.MultiUsuarios;

/**Esta clase tiene los componentes principales de la pantalla del jugador
 * ademas aqui es donde se muestra los botones principales de la pantalla
 * y su metodos respectivos para las apuestas del jugador la union de ligas 
 * y el cronograma de juego y mucho mas.
 * @author DELL
 *
 */
public class MenuJugador extends JPanel implements ActionListener{
	
	private static Image imagen;
	public Usuario miUsuario = null;
	
	JButton boton2 = new JButton("Jugar en Liga Publica");
	JButton boton3 = new JButton("Jugar en Liga Privada");
	JButton boton4 = new JButton("Mis Ligas");
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
	
	/**
	 * Este metodo muestra los botones principales de la pantalla del jugador
	 * @param miUsuario
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public MenuJugador(Usuario miUsuario) throws SQLException, Exception {
		
		this.setLayout(null);
		Gestor.inicializarArrayList();
		
		this.miUsuario = miUsuario;
		Usuario persona = Gestor.retornarUsuario(this.miUsuario.getNombreUsuario());
		this.miUsuario = persona;
		
		
		
		System.out.println(this.miUsuario.toString());
		
		evaluarCondicionJuego();
		
		this.add(boton2);
		boton2.setBounds(10, 50, 180, 50);
		boton2.setFont(new Font(boton2.getFont().getFontName(), Font.BOLD, 13));
		
		this.add(boton3);		
		boton3.setBounds(10, 120, 180, 50);
		boton3.setFont(new Font(boton3.getFont().getFontName(), Font.BOLD, 13));
		
		this.add(boton4);
		boton4.setBounds(10, 190, 180, 50);
		boton4.setFont(new Font(boton4.getFont().getFontName(), Font.BOLD, 13));
		
		this.add(boton5);
		boton5.setBounds(10, 260, 180, 50);
		boton5.setFont(new Font(boton5.getFont().getFontName(), Font.BOLD, 13));
		
		this.add(boton6);
		boton6.setBounds(10, 330, 180, 50);
		boton6.setFont(new Font(boton6.getFont().getFontName(), Font.BOLD, 13));
		
		this.add(boton7);
		boton7.setBounds(10, 400, 180, 50);
		boton7.setFont(new Font(boton7.getFont().getFontName(), Font.BOLD, 13));
		
		this.add(boton8);
		boton8.setBounds(10, 470, 180, 50);
		boton8.setFont(new Font(boton8.getFont().getFontName(), Font.BOLD, 13));
		

		ArrayList<LigasPublicas> listaLigasPublicasTemp = CL.retornarLigasPublicas();
		
		
		ligasRegistradas.removeAllItems();
		
		for(LigasPublicas a: listaLigasPublicasTemp) {
		
		ligasRegistradas.addItem(a.getNombreLiga());
		
		}
		
		
		if(ligasRegistradas.getItemCount()==0) {
			
			btnUnirseLiga.setEnabled(false);
			
		}else {
			
			btnUnirseLiga.setEnabled(true);
			
		}
		
		boton2.addActionListener(this);
		boton3.addActionListener(this);
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
		
		
		if(e.getSource()==boton2) {
			
			Ventana ventJuegoLigaPublica = null;
			try {
				ventJuegoLigaPublica = new Ventana(Gestor.retornarUsuario(this.miUsuario.getNombreUsuario()));
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
			try {
				ventJuegoLigaPublica.ventanaJuego(0);
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
			SwingUtilities.getWindowAncestor(getRootPane()).dispose();
			
		}
		
		if(e.getSource()==boton3) {
			
			Ventana ventJuegoLigaPrivada = null;
			try {
				ventJuegoLigaPrivada = new Ventana(Gestor.retornarUsuario(this.miUsuario.getNombreUsuario()));
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
			try {
				ventJuegoLigaPrivada.ventanaJuego(1);
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
			SwingUtilities.getWindowAncestor(getRootPane()).dispose();
		}	
		
		
		if(e.getSource()==boton4) {
			
			Ventana ventLigasJugador = null;
			try {
				ventLigasJugador = new Ventana(Gestor.retornarUsuario(this.miUsuario.getNombreUsuario()));
			} catch (Exception e2) {
				
				e2.printStackTrace();
			}
			try {
				ventLigasJugador.ventanaLigasJugador();
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
			
		}
		
		if(e.getSource() == boton5) {
			
			desabilitarMenuPrincipal();
			mostrarInformacionLiga();
			
			this.add(ligasRegistradas);
			ligasRegistradas.setBounds(550, 50, 200, 30);			
			
			
			this.add(btnUnirseLiga);
			btnUnirseLiga.setBounds(760, 50, 100, 30);
			
			this.add(btncancelarInclusion);
			btncancelarInclusion.setBounds(760, 90, 100, 30);
	
		}
		
		if(e.getSource() == boton6) {//aqui se ejecuta el componente para retirar se la liga
			
			ligasRegistradaUsuario.removeAllItems();
			
			this.add(ligasRegistradaUsuario);
			ligasRegistradaUsuario.setBounds(950, 50, 200, 30);
			
			this.add(btnRetirarseLiga);
			btnRetirarseLiga.setBounds(1160, 50, 100, 30);
			
			this.add(btnCancelarRetiro);
			btnCancelarRetiro.setBounds(1160, 90, 100, 30);
			
			try {
				this.miUsuario = Gestor.retornarUsuario(this.miUsuario.getNombreUsuario());
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
			
			LigasPrivadas ligaPrivadaTemp = null;
			LigasPublicas ligaPublicaTemp = null;
			
			
			try {
				ligaPrivadaTemp = new MultiLigasPrivadas().buscar(this.miUsuario.getMiLigaPrivada().getNombreLiga());
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
			
			
			
			try {
				ligaPublicaTemp = new MultiLigasPublicas().buscar(this.miUsuario.getMiLigaPublica().getNombreLiga());
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
			
			
			
			
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
		
		if (e.getSource() == ligasRegistradas) {// aqui se ejecuta el codigo para unirse a la liga respectiva
			
			btnUnirseLiga.setEnabled(true);
			
			LigasPublicas ligaPublicaTemp = null;
			try {
				ligaPublicaTemp = Gestor.retornarLigaPublica((String) ligasRegistradas.getSelectedItem());
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}				
			
			if(ligaPublicaTemp.getEstado() == true) {
				
				estadoLigaPublica = "Activo";
				
			}
			else {
				
				estadoLigaPublica = "Inactivo";
				
			}
			//estos componentes se mostraran una vez se halla unido a una liga publica.
			informacionLiga1.setText("Información de la liga.");
			informacionLiga2.setText("Nombre de la liga: " + ligaPublicaTemp.getNombreLiga());
			informacionLiga3.setText("Fecha de creación: " + ligaPublicaTemp.getFechaCreacion());
			informacionLiga4.setText("Estado: " + estadoLigaPublica);
			informacionLiga5.setText("Puntos: " + ligaPublicaTemp.getPuntos());
			informacionLiga6.setText("Bono: " + ligaPublicaTemp.getBono());
			
		}
		//se ejecuta el boton unirse a la liga
		if(e.getSource() == btnUnirseLiga) {
			
			LigasPublicas ligaPublicaTemporal = null;
			try {
				ligaPublicaTemporal = Gestor.retornarLigaPublica((String) ligasRegistradas.getSelectedItem());
			} catch (Exception e2) {
				
				e2.printStackTrace();
			}
			
			String opcionEscogida = (String) ligasRegistradas.getSelectedItem();
			try {
				this.setMiUsuario(Gestor.retornarUsuario(this.miUsuario.getNombreUsuario()));
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
			
			if(this.miUsuario.getMiLigaPublica() == null) {
				
				this.miUsuario.setMiLigaPublica(ligaPublicaTemporal);
				try {
					Gestor.asignarLigaPublicaUsuario(this.miUsuario.getNombreUsuario(), ligaPublicaTemporal);
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null,this.miUsuario.getAvatar() + " fue agregado a la liga Publica: " + this.miUsuario.getMiLigaPublica().getNombreLiga());
				ligasRegistradas.removeAll();
				
			}
			else {
				
				JOptionPane.showMessageDialog(null,this.miUsuario.getAvatar() + " ya te encuentras registrado en la liga Publica: " + this.miUsuario.getMiLigaPublica().getNombreLiga());
				
			}
			
			try {
				this.miUsuario = Gestor.retornarUsuario(this.miUsuario.getNombreUsuario());
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
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
				
				try {
					Gestor.removerLigaPublicaUsuario(this.miUsuario.getNombreUsuario());
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Liga publica " + (String)ligasRegistradaUsuario.getSelectedItem() + " removida.");
				ligasRegistradaUsuario.removeItem(ligasRegistradaUsuario.getSelectedItem());
				
				if(this.miUsuario.getEquipoLigaPublica() != null) {
					
					try {
						Gestor.removerEquipoLigaPublicaUsuario(this.miUsuario.getNombreUsuario());
					} catch (Exception e1) {
						
						e1.printStackTrace();
					}
					removerValidacionesLigas(0);
					
				}
				
				try {
					Gestor.actualizarJugador(this.miUsuario);
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				
			}else if(seleccion.equals(this.miUsuario.getMiLigaPrivada().getNombreLiga())) {
				
				try {
					Gestor.removerLigaPrivadaUsuario(this.miUsuario.getNombreUsuario());
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Liga privada " + (String)ligasRegistradaUsuario.getSelectedItem() + " removida.");
				ligasRegistradaUsuario.removeItem(ligasRegistradaUsuario.getSelectedItem());
				
				if(this.miUsuario.getEquipoLigaPrivada() != null) {
					
					try {
						Gestor.removerEquipoLigaPrivadaUsuario(this.miUsuario.getNombreUsuario());
					} catch (Exception e1) {
						
						e1.printStackTrace();
					}
					removerValidacionesLigas(1);
					
					
				}
				
				try {
					Gestor.actualizarJugador(this.miUsuario);
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				
			}

			try {
				this.miUsuario = Gestor.retornarUsuario(this.miUsuario.getNombreUsuario());
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
			removerMenus();
			
		}
		
		if(e.getSource() == ligasRegistradaUsuario) {
			
			try {
				this.miUsuario = Gestor.retornarUsuario(this.miUsuario.getNombreUsuario());
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
			
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
	/**
	 *Metodo principal del Get de miUsuario
	 * @return
	 */
	public Usuario getMiUsuario() {
		return miUsuario;
	}
/**
 * Metodo principal de Set de miUsuario
 * @param miUsuario
 */
	public void setMiUsuario(Usuario miUsuario) {
		this.miUsuario = miUsuario;
	}
	
	
	//-------------------------------------------------------------------------------------------------
	
	public void desabilitarMenuPrincipal() {// esto desabilita los botones del menu principal de la pantalla del jugador
		
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
		
		evaluarCondicionJuego();
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
	/**
	 * muestra la informacion de la liga un ves unida y creada la liga y el mundial
	 */
	public void mostrarInformacionLiga() {
		
		
		this.add(informacionLiga1);
		informacionLiga1.setBounds(550,140, 600,40);
		informacionLiga1.setForeground(Color.ORANGE);
		informacionLiga1.setFont(new Font(informacionLiga1.getFont().getFontName(), Font.PLAIN, 30));
		
		
		this.add(informacionLiga2);
		informacionLiga2.setBounds(550,200, 600,40);
		informacionLiga2.setForeground(Color.ORANGE);
		informacionLiga2.setFont(new Font(informacionLiga2.getFont().getFontName(), Font.PLAIN, 30));
		
		this.add(informacionLiga3);
		informacionLiga3.setBounds(550,240, 600,40);
		informacionLiga3.setForeground(Color.ORANGE);
		informacionLiga3.setFont(new Font(informacionLiga3.getFont().getFontName(), Font.PLAIN, 30));
		
		this.add(informacionLiga4);
		informacionLiga4.setBounds(550,280, 600,40);
		informacionLiga4.setForeground(Color.ORANGE);
		informacionLiga4.setFont(new Font(informacionLiga4.getFont().getFontName(), Font.PLAIN, 30));
		
		this.add(informacionLiga5);
		informacionLiga5.setBounds(550,320, 600,40);
		informacionLiga5.setForeground(Color.ORANGE);
		informacionLiga5.setFont(new Font(informacionLiga5.getFont().getFontName(), Font.PLAIN, 30));
		
		this.add(informacionLiga6);
		informacionLiga6.setBounds(550,360, 600,40);
		informacionLiga6.setForeground(Color.ORANGE);
		informacionLiga6.setFont(new Font(informacionLiga6.getFont().getFontName(), Font.PLAIN, 30));
		
	}
	/**
	 * Validaciones de condiciones del juego
	 */
	
	public void evaluarCondicionJuego(){
		
		if(this.miUsuario.getMiLigaPrivada() == null && this.miUsuario.getMiLigaPublica() == null) {
			
			boton4.setEnabled(false);
			
		}else {
			
			boton4.setEnabled(true);
			
		}
		
		if(this.miUsuario.getMiLigaPublica() == null) {
			
			boton2.setEnabled(false);
			
		}
		else {
			
			boton2.setEnabled(true);
			
		}
		
		if(this.miUsuario.getMiLigaPrivada() == null) {
			
			boton3.setEnabled(false);
			
		}else {
			
			boton3.setEnabled(true);
			
		}
		
	}
	/**
	 * Remueve la validaciones de las ligas y de las fase de grupos
	 * @param tipoLiga
	 */
	public void removerValidacionesLigas(int tipoLiga) {
		
		switch(tipoLiga) {
		
		case 0: 
			
			this.miUsuario.setValidacioncuartosPublica(false);
			this.miUsuario.setValidacionfinalPublica(false);
			this.miUsuario.setValidacionOctavosPublica(false);
			this.miUsuario.setValidacionPrimeraFasePublica(0);
			this.miUsuario.setValidacionSemifinalesPublica(false);
			
			break;
			
		case 1:
			
			this.miUsuario.setValidacioncuartosPrivada(false);
			this.miUsuario.setValidacionfinalPrivada(false);
			this.miUsuario.setValidacionOctavosPrivada(false);
			this.miUsuario.setValidacionPrimeraFasePrivada(0);
			this.miUsuario.setValidacionSemifinalesPrivada(false);
			
			break;
		
		}
		
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
