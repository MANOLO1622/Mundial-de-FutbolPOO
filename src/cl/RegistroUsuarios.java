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
	
	private static JLabel labelNombreUsuario = new JLabel("Nombre de Usuario:");
	private static JTextField nombreUsuarioTXT = new JTextField(10);
	
	private static JLabel labelContrasena = new JLabel("Contrasena:");
	private static JTextField contrasenaTXT = new JTextField(10);
	private static JButton btnRegistro = new JButton("Registrar");
	
	
	public RegistroUsuarios () {
		
		this.setLayout(null);
		this.setBackground(Color.CYAN);
		
		this.add(labelNombre);
		labelNombre.setBounds(10,0,200,30);
		
		this.add(nombreTXT);
		nombreTXT.setBounds(125,5,200,20);
		
		this.add(labelApellido);
		labelApellido.setBounds(10,25,200,30);
		
		this.add(apellidoTXT);
		apellidoTXT.setBounds(125,30,200,20);
		
		this.add(labelNombreUsuario);
		labelNombreUsuario.setBounds(10,50,200,30);
		
		this.add(nombreUsuarioTXT);
		nombreUsuarioTXT.setBounds(125,55,200,20);
		
		this.add(labelContrasena);
		labelContrasena.setBounds(10,75,200,30);
		
		this.add(contrasenaTXT);
		contrasenaTXT.setBounds(125,80,200,20);
		
		this.add(btnRegistro);
		btnRegistro.setBounds(10, 110, 100, 25);
		
		btnRegistro.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		int validacion = controlador.validarUsuario(nombreUsuarioTXT.getText(), contrasenaTXT.getText(), 1);
		
		if (validacion==1) {
			
			this.setBackground(Color.RED);
			
		}
		else {
			
			if(nombreTXT.getText().equals("") || apellidoTXT.getText().equals("") || nombreUsuarioTXT.getText().equals("") || contrasenaTXT.equals("")) {
				
				JOptionPane.showMessageDialog(null, "Por favor ingrese los datos del formulario.");
				
			}
			else {
				
				this.setBackground(Color.GREEN);
				controlador.registrarUsuario(nombreTXT.getText(), apellidoTXT.getText(), nombreUsuarioTXT.getText(), contrasenaTXT.getText(), 2);
				controlador.listarUsuarios();
				JOptionPane.showMessageDialog(null, "Usuario registrado.");				
								
				Ventana menuJugador = new Ventana();
				menuJugador.setTitle("Jugador " + nombreUsuarioTXT.getText());
				menuJugador.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				nombreTXT.setText("");
				apellidoTXT.setText("");
				nombreUsuarioTXT.setText("");
				contrasenaTXT.setText("");
				
			}
				
		}
				
	}
	
	

}
