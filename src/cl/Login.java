package cl;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import gestor.*;

public class Login extends JPanel implements ActionListener{
	
	private static JLabel labelNomUsuario = new JLabel("Nombre de usuario");
	private static JTextField usuarioTXT = new JTextField(10);
	private static JLabel labelContrasenaUsuario = new JLabel("Contraseņa");
	private static JPasswordField contrasenaTXT = new JPasswordField(10);
	private static JLabel labelMostrarContrasena = new JLabel();
	private static ImageIcon ojo = new ImageIcon("src\\graficos\\Ojo.png");
	private static JButton btnIngreso = new JButton("Ingresar");
	private static JButton btnRegistrarUsuario = new JButton("Registrate con nosotros");
	
    private static Image imagen;
    


	public Login () {
		
		this.setLayout(null);
		
		this.add(labelNomUsuario);
		labelNomUsuario.setForeground(Color.WHITE);
		labelNomUsuario.setBounds(280,40,150,40);
		this.add(usuarioTXT);
		usuarioTXT.setBounds(230, 80, 210, 25);
		
		this.add(labelContrasenaUsuario);
		labelContrasenaUsuario.setForeground(Color.WHITE);
		labelContrasenaUsuario.setBounds(300, 105, 150, 40);
		
		this.add(contrasenaTXT);
		contrasenaTXT.setBounds(250, 150, 170, 25);
		char valor = contrasenaTXT.getEchoChar();
		
		labelMostrarContrasena.setIcon(ojo);
		this.add(labelMostrarContrasena);
		labelMostrarContrasena.setBounds(430, 150, 170,25);
		
		this.add(btnIngreso);
		btnIngreso.setBounds(285, 200, 100, 25);

		
		this.add(btnRegistrarUsuario);
		btnRegistrarUsuario.setBounds(10, 310, 200, 25);
		
		btnRegistrarUsuario.addActionListener(this);
		btnIngreso.addActionListener(this);
		
		
		//En el siguiente evento creo un adaptador para poder implementar la funcionalidad en el ojo de mostrar la contraseņa.
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
				
				JOptionPane.showMessageDialog(null, "Por favor ingrese el Usuario y la contraseņa.");
				System.out.println("No se han ingresado datos en la pantalla de login.");
				usuarioTXT.setText("");
				contrasenaTXT.setText("");
				
			}
			
			else {
				
				Gestor controlador = new Gestor();
				validacion = controlador.validarUsuario(lecturaUsuario, lecturaContrasena,"", 0);
				
				if(validacion == 3) {
					
					JOptionPane.showMessageDialog(null, "Contraseņa incorrecta.");
					
				}
				
				if (validacion == 2) {
					
					Perfiles perfil = controlador.retornarTipoUsuario(usuarioTXT.getText(), contrasenaTXT.getText());
					Ventana ventanaUsuario = new Ventana();
					ventanaUsuario.ventanaMenuUsuarios(perfil, usuarioTXT.getText(), ventanaUsuario);
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
					
					JOptionPane.showMessageDialog(null, "Porfavor ingrese el usuario y la contraseņa.");
					
				}
			}
			
		}
				
	}
	
	//-------------------------------------------------------------------------------------------------    
    
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
	
	//-------------------------------------------------------------------------------------------------


}
