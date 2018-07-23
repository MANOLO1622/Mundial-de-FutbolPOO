package cl;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import gestor.*;

public class Login extends JPanel implements ActionListener, KeyListener{
	
	private static JLabel labelNomUsuario = new JLabel("Usuario");
	private static JTextField usuarioTXT = new JTextField(10);
	private static JLabel labelContrasenaUsuario = new JLabel("Contraseña");
	private static JPasswordField contrasenaTXT = new JPasswordField(10);
	private static JLabel labelMostrarContrasena = new JLabel();
	private static ImageIcon ojo = new ImageIcon("src\\graficos\\Ojo.png");
	private static JButton btnIngreso = new JButton("Iniciar Sesión");
	private static JButton btnRegistrarUsuario = new JButton("Registrarse");
    private static Image imagen;
    
    
	public Login () {
		
		this.setLayout(null);
		
		this.add(labelNomUsuario);
		labelNomUsuario.setForeground(Color.WHITE);
		labelNomUsuario.setBounds(250,110,150,40);
		this.add(usuarioTXT);
		usuarioTXT.setBounds(250, 140, 170, 25);
		
		this.add(labelContrasenaUsuario);
		labelContrasenaUsuario.setForeground(Color.WHITE);
		labelContrasenaUsuario.setBounds(250, 160, 150, 40);
		
		this.add(contrasenaTXT);
		contrasenaTXT.setBounds(250, 190, 170, 25);
		char valor = contrasenaTXT.getEchoChar();
		
		labelMostrarContrasena.setIcon(ojo);
		this.add(labelMostrarContrasena);
		labelMostrarContrasena.setBounds(430, 190, 170,25);
		
		this.add(btnIngreso);
		btnIngreso.setBounds(280, 240, 115, 25);
		
		this.add(btnRegistrarUsuario);
		btnRegistrarUsuario.setBounds(10, 310, 101, 25);
		
		btnRegistrarUsuario.addActionListener(this);
		btnIngreso.addActionListener(this);
		usuarioTXT.addKeyListener(this);
		contrasenaTXT.addKeyListener(this);
		
		
		
		//En el siguiente evento creo un adaptador para poder implementar la funcionalidad en el ojo de mostrar la contraseña.
		labelMostrarContrasena.addMouseListener(new MouseAdapter(){
			
			public void mouseEntered(MouseEvent e) {
				
				contrasenaTXT.setEchoChar((char)0); 
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				
				contrasenaTXT.setEchoChar(valor);
				
				
			}
			
		});
		
	}

	
	//-------------------------------------------------------------------------------------------------
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		int validacion=0;		
		String lecturaUsuario= usuarioTXT.getText();
		String lecturaContrasena = contrasenaTXT.getText();
		
		Object evento = e.getSource();
		
		if(evento == btnRegistrarUsuario) {
			
			Ventana ventanaRegistro = new Ventana();
			ventanaRegistro.ventanaRegistroUsuarios();
			ventanaRegistro.setExtendedState(Ventana.MAXIMIZED_BOTH);	
			
		}
		
		if(evento == btnIngreso) {
			
			if (lecturaUsuario.equals("") || lecturaContrasena.equals("")) {
				
				JOptionPane.showMessageDialog(null, "Por favor ingrese el usuario y la contraseña.");
				System.out.println("No se han ingresado datos en la pantalla de login.");
				usuarioTXT.setText("");
				contrasenaTXT.setText("");
				
			}
			
			else {
				
				Gestor controlador = new Gestor();
				validacion = controlador.validarUsuario(lecturaUsuario, lecturaContrasena,"", 0);
				
				if(validacion == 3) {
					
					JOptionPane.showMessageDialog(null, "Contraseña incorrecta.");
					
				}
				
				if (validacion == 2) {
					
					Perfiles perfil = controlador.retornarTipoUsuario(usuarioTXT.getText(), contrasenaTXT.getText());
					Ventana ventanaUsuario = new Ventana();
					Usuario UsuarioActual = controlador.retornarUsuario(usuarioTXT.getText());
					ventanaUsuario.setUsuarioActual(UsuarioActual);
					ventanaUsuario.ventanaMenuUsuarios(perfil, UsuarioActual, ventanaUsuario);
					ventanaUsuario.setExtendedState(Ventana.MAXIMIZED_BOTH);
					JOptionPane.showMessageDialog(null, "Bienvenido.");
					
					usuarioTXT.setText("");
					contrasenaTXT.setText("");
					
					
				}
				if (validacion == 1){
					
					usuarioTXT.setText("");
					contrasenaTXT.setText("");
					JOptionPane.showMessageDialog(null, "Porfavor registrese antes de ingresar.");
					
				}
				if (validacion == 0) {
					
					JOptionPane.showMessageDialog(null, "Porfavor ingrese el usuario y la contraseña.");
					
				}
			}
			
		}
				
	}
	
	//-------------------------------------------------------------------------------------------------    
    


	@Override
	public void keyPressed(KeyEvent e) {
		
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		
		int validacion=0;		
		String lecturaUsuario= usuarioTXT.getText();
		String lecturaContrasena = contrasenaTXT.getText();
		
		if(e.getSource() == usuarioTXT || e.getSource() == contrasenaTXT) {
			
			if(e.getKeyChar() == KeyEvent.VK_ENTER ) {
				
				
				if (lecturaUsuario.equals("") || lecturaContrasena.equals("")) {
					
					JOptionPane.showMessageDialog(null, "Por favor ingrese el usuario y la contraseña.");
					System.out.println("No se han ingresado datos en la pantalla de login.");
					usuarioTXT.setText("");
					contrasenaTXT.setText("");
					
				}
				
				else {
					
					Gestor controlador = new Gestor();
					validacion = controlador.validarUsuario(lecturaUsuario, lecturaContrasena,"", 0);
					
					if(validacion == 3) {
						
						JOptionPane.showMessageDialog(null, "Contraseña incorrecta.");
						
					}
					
					if (validacion == 2) {
						
						Perfiles perfil = controlador.retornarTipoUsuario(usuarioTXT.getText(), contrasenaTXT.getText());
						Ventana ventanaUsuario = new Ventana();
						Usuario UsuarioActual = controlador.retornarUsuario(usuarioTXT.getText());
						ventanaUsuario.setUsuarioActual(UsuarioActual);
						ventanaUsuario.ventanaMenuUsuarios(perfil, UsuarioActual, ventanaUsuario);
						ventanaUsuario.setExtendedState(Ventana.MAXIMIZED_BOTH);
						JOptionPane.showMessageDialog(null, "Bienvenido.");
						
						usuarioTXT.setText("");
						contrasenaTXT.setText("");
						
						
					}
					if (validacion == 1){
						
						usuarioTXT.setText("");
						contrasenaTXT.setText("");
						JOptionPane.showMessageDialog(null, "Porfavor registrese antes de ingresar.");
						
					}
					if (validacion == 0) {
						
						JOptionPane.showMessageDialog(null, "Porfavor ingrese el usuario y la contraseña.");
						
					}
				}
				
				
			}
	
		}
		
	}


	
	//-------------------------------------------------------------------------------------
	
    public void paintComponent(Graphics g) {
   	 
		int width = this.getSize().width;
		int height = this.getSize().height;
 
		this.setBackground("src\\graficos\\Login.jpg");
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

	
	//-------------------------------------------------------------------------------------
	
	

}
