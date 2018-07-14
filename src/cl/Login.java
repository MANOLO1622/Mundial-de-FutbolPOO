package cl;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import gestor.*;

public class Login extends JPanel implements ActionListener {
	
	private static JLabel labelNomUsuario = new JLabel("Nombre de usuario");
	private static JTextField usuarioTXT = new JTextField(10);
	private static JLabel labelContrasenaUsuario = new JLabel("Contraseña");
	private static JTextField contrasenaTXT = new JTextField(10);
	private static JButton btnIngreso = new JButton("Ingresar");
	
	public Login () {

		this.setLayout(null);
		
		this.add(labelNomUsuario);
		labelNomUsuario.setBounds(280,40,150,40);
		this.add(usuarioTXT);
		usuarioTXT.setBounds(230, 80, 210, 25);
		this.add(labelContrasenaUsuario);
		labelContrasenaUsuario.setBounds(300, 105, 150, 40);
		this.add(contrasenaTXT);
		contrasenaTXT.setBounds(250, 150, 170, 25);
		this.add(btnIngreso);
		btnIngreso.setBounds(285, 200, 100, 25);
		this.setBackground(Color.BLUE);
		
		btnIngreso.addActionListener(this);
		
	}

	
	//-------------------------------------------------------------------------------------------------
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		int validacion=0;		
		String lecturaUsuario= usuarioTXT.getText();
		String lecturaContrasena = contrasenaTXT.getText();
		
		if (lecturaUsuario.equals("") || lecturaContrasena.equals("")) {
			
			JOptionPane.showMessageDialog(null, "Por favor ingrese el Usuario y la contraseña.");
			System.out.println("No se han ingresado datos en la pantalla de login.");
			
		}
		
		else {
			
			Gestor controlador = new Gestor();
			validacion = controlador.validarUsuario(lecturaUsuario, lecturaContrasena);
			
			if (validacion==1) {
				
				this.setBackground(Color.GREEN);
				Perfiles perfil = controlador.retornarTipoUsuario(usuarioTXT.getText(), contrasenaTXT.getText());
				Ventana ventanaUsuario = new Ventana();
				ventanaUsuario.ventanaMenuUsuarios(perfil, usuarioTXT.getText(), ventanaUsuario);
				
				
			}
			else {
				
				this.setBackground(Color.RED);
				usuarioTXT.setText("");
				contrasenaTXT.setText("");
				Ventana ventanaRegistro = new Ventana();
				ventanaRegistro.ventanaRegistroUsuarios();
				
			}
			
		}
		
		
				
	}

}
