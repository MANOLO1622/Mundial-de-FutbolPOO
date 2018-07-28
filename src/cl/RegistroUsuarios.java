package cl;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

import gestor.*;

public class RegistroUsuarios extends JPanel implements ActionListener{
	
	private  Gestor controlador = new Gestor(); 
	
	private JLabel labelNombre = new JLabel("Nombre: ");
	private JTextField nombreTXT = new JTextField(10);
	
	private JLabel labelApellido = new JLabel("Apellido:");
	private JTextField apellidoTXT = new JTextField(10);
	
	private JLabel labelAvatar = new JLabel("Avatar:");
	private JTextField avatarTXT = new JTextField(10);
	
	private JLabel labelNombreUsuario = new JLabel("Nombre de Usuario:");
	private JTextField nombreUsuarioTXT = new JTextField(10);
	
	private JLabel labelCorreo = new JLabel("Correo electronico:");
	private JTextField correoTXT = new JTextField(10);
	
	private JLabel labelContrasena = new JLabel("Contraseña:");
	private JTextField contrasenaTXT = new JTextField(10);
	
	private JButton btnRegistro = new JButton("Registrar");
	private JButton btnSalir = new JButton("Salir");
	
    private static Image imagen;
	
	
	public RegistroUsuarios () {
		
		this.setLayout(null);
		
		this.add(labelNombre);
		labelNombre.setForeground(Color.WHITE);
		labelNombre.setBounds(10,30,200,30);
		
		this.add(nombreTXT);
		nombreTXT.setBounds(125,30,200,20);
		
		this.add(labelApellido);
		labelApellido.setForeground(Color.WHITE);
		labelApellido.setBounds(10,70,200,30);
		
		this.add(apellidoTXT);
		apellidoTXT.setBounds(125,70,200,20);
		
		this.add(labelAvatar);
		labelAvatar.setForeground(Color.WHITE);
		labelAvatar.setBounds(10,110,200,30);
		
		this.add(avatarTXT);
		avatarTXT.setBounds(125,110,200,20);
		
		this.add(labelNombreUsuario);
		labelNombreUsuario.setForeground(Color.WHITE);
		labelNombreUsuario.setBounds(10,150,200,30);
		
		this.add(nombreUsuarioTXT);
		nombreUsuarioTXT.setBounds(125,150,200,20);
		
		this.add(labelCorreo);
		labelCorreo.setForeground(Color.WHITE);
		labelCorreo.setBounds(10,190,200,30);
		
		this.add(correoTXT);
		correoTXT.setBounds(125,190,200,20);
		
		this.add(labelContrasena);
		labelContrasena.setForeground(Color.WHITE);
		labelContrasena.setBounds(10,225,200,30);
		
		this.add(contrasenaTXT);
		contrasenaTXT.setBounds(125,225,200,20);
		
		this.add(btnRegistro);
		btnRegistro.setBounds(10, 270, 100, 25);
		
		this.add(btnSalir);
		btnSalir.setBounds(120, 270, 100, 25);
		
		//-----------------------Eventos
		btnRegistro.addActionListener(this);
		btnSalir.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		int validacion = controlador.validarUsuario(nombreUsuarioTXT.getText(), contrasenaTXT.getText(),avatarTXT.getText(), 1);
		
		
		if(e.getSource()==btnRegistro) {
			
			if(nombreTXT.getText().equals("") || apellidoTXT.getText().equals("") || 
					   nombreUsuarioTXT.getText().equals("") || contrasenaTXT.equals("") ||
					   avatarTXT.getText().equals("") || correoTXT.getText().equals("")) {
						
						JOptionPane.showMessageDialog(null, "Hay campos vacios, debe llenar todos los campos.");
						
					}
					else {
						
						if((contrasenaTXT.getText()).length()<6 || (contrasenaTXT.getText()).length()>8) {
							
							JOptionPane.showMessageDialog(null, "Por favor registrar una contraseña entre 6 y 8 caracteres.");
							
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
		
		
		if(e.getSource()==btnSalir) {
			
			SwingUtilities.getWindowAncestor(getRootPane()).dispose();
			
		}
				
	}
	
	//-------------------------------------------------------------------------------------------------    
    
    public void paintComponent(Graphics g) {
    	 
		int width = this.getSize().width;
		int height = this.getSize().height;
 
		this.setBackground("src\\graficos\\registro.jpg");
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
