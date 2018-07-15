package cl;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import gestor.*;

public class RegistroUsuarios extends JPanel implements ActionListener{
	
	private static Gestor controlador = new Gestor();
	
	private static JLabel labelNombre = new JLabel("Nombre: ");
	private static JTextField nombreTXT = new JTextField(10);
	
	private static JLabel labelApellido = new JLabel("Apellido:");
	private static JTextField apellidoTXT = new JTextField(10);
	
	private static JLabel labelAvatar = new JLabel("Avatar:");
	private static JTextField avatarTXT = new JTextField(10);
	
	private static JLabel labelNombreUsuario = new JLabel("Nombre de Usuario:");
	private static JTextField nombreUsuarioTXT = new JTextField(10);
	
	private static JLabel labelCorreo = new JLabel("Correo electronico:");
	private static JTextField correoTXT = new JTextField(10);
	
	private static JLabel labelContrasena = new JLabel("Contrasena:");
	private static JTextField contrasenaTXT = new JTextField(10);
	
	private static JButton btnRegistro = new JButton("Registrar");
	
	
	public RegistroUsuarios () {
		
		this.setLayout(null);
		this.setBackground(Color.CYAN);
		
		this.add(labelNombre);
		labelNombre.setBounds(10,0,200,30);
		
		this.add(nombreTXT);
		nombreTXT.setBounds(125,6,200,20);
		
		this.add(labelApellido);
		labelApellido.setBounds(10,25,200,30);
		
		this.add(apellidoTXT);
		apellidoTXT.setBounds(125,31,200,20);
		
		this.add(labelAvatar);
		labelAvatar.setBounds(10,50,200,30);
		
		this.add(avatarTXT);
		avatarTXT.setBounds(125,56,200,20);
		
		this.add(labelNombreUsuario);
		labelNombreUsuario.setBounds(10,75,200,30);
		
		this.add(nombreUsuarioTXT);
		nombreUsuarioTXT.setBounds(125,81,200,20);
		
		this.add(labelCorreo);
		labelCorreo.setBounds(10,100,200,30);
		
		this.add(correoTXT);
		correoTXT.setBounds(125,106,200,20);
		
		this.add(labelContrasena);
		labelContrasena.setBounds(10,125,200,30);
		
		this.add(contrasenaTXT);
		contrasenaTXT.setBounds(125,131,200,20);
		
		this.add(btnRegistro);
		btnRegistro.setBounds(10, 160, 100, 25);
		
		btnRegistro.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		int validacion = controlador.validarUsuario(nombreUsuarioTXT.getText(), contrasenaTXT.getText(),avatarTXT.getText(), 1);
		
		
		if(nombreTXT.getText().equals("") || apellidoTXT.getText().equals("") || 
		   nombreUsuarioTXT.getText().equals("") || contrasenaTXT.equals("") ||
		   avatarTXT.getText().equals("") || correoTXT.getText().equals("")) {
			
			JOptionPane.showMessageDialog(null, "Por favor ingrese los datos del formulario.");
			
		}
		else {
			
			if (validacion == 1) {
				
				this.setBackground(Color.RED);
				JOptionPane.showMessageDialog(null, "Este usuario ya se encuentra registrado.");
				
			}
			
			if(validacion == 0) {
				
				this.setBackground(Color.GREEN);
				controlador.registrarUsuario(nombreTXT.getText(), apellidoTXT.getText(), nombreUsuarioTXT.getText(), contrasenaTXT.getText(),avatarTXT.getText() ,correoTXT.getText() , 2);
				controlador.listarUsuarios();
				JOptionPane.showMessageDialog(null, "Usuario registrado.");
				
				nombreTXT.setText("");
				apellidoTXT.setText("");
				nombreUsuarioTXT.setText("");
				avatarTXT.setText("");
				correoTXT.setText("");
				contrasenaTXT.setText("");
		
			}
			
		}
				
	}
	
	

}
