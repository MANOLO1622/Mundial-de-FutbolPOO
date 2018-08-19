package cl;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import gestor.*;

/**esta clase tiene todos los componentes que hacen referencia al login principal
 * de la app
 * @author DELL
 *
 */
@SuppressWarnings("serial")
public class Login extends JPanel implements ActionListener, KeyListener{

	
    private Image imagen;
	private JLabel labelNomUsuario = new JLabel("Usuario");
	private JTextField usuarioTXT = new JTextField(10);
	private JLabel labelContrasenaUsuario = new JLabel("Contraseña");
	private JPasswordField contrasenaTXT = new JPasswordField(10);
	private JLabel labelMostrarContrasena = new JLabel();
	private ImageIcon ojo = new ImageIcon("src\\graficos\\ojo.png");
	private ImageIcon ojo2 = new ImageIcon("src\\graficos\\ojo2.png");
	private JButton btnIngreso = new JButton("Iniciar Sesión");
	private JButton btnRegistrarUsuario = new JButton("Registrarse");
	private JButton btnSalir = new JButton("Salir");

    
    /**
     * Aqui se muestra sus campos y sus labels respectivos para su posicion correcta.
     */
	public Login () {
		
		this.setLayout(null);
		
		darEstilosComponentes();
		
		this.add(labelNomUsuario);
		labelNomUsuario.setForeground(Color.BLACK);
		labelNomUsuario.setBounds(250,110,150,40);
		
		this.add(usuarioTXT);
		usuarioTXT.setBounds(250, 140, 170, 25);
		
		this.add(labelContrasenaUsuario);
		labelContrasenaUsuario.setForeground(Color.BLACK);
		labelContrasenaUsuario.setBounds(250, 160, 150, 40);
		
		this.add(contrasenaTXT);
		contrasenaTXT.setBounds(250, 190, 170, 25);
		char valor = contrasenaTXT.getEchoChar();
		
		labelMostrarContrasena.setIcon(ojo);
		this.add(labelMostrarContrasena);
		labelMostrarContrasena.setBounds(430, 185, 165,35);
		
		
		this.add(btnIngreso);
		btnIngreso.setBounds(280, 240, 115, 25);
		

		
		this.add(btnRegistrarUsuario);
		btnRegistrarUsuario.setBounds(30, 310, 101, 25);
		
		this.add(btnSalir);
		btnSalir.setBounds(550, 310, 101, 25);
		

		
		//------------Eventos
		
		btnRegistrarUsuario.addActionListener(this);
		btnIngreso.addActionListener(this);
		btnSalir.addActionListener(this);
		usuarioTXT.addKeyListener(this);
		contrasenaTXT.addKeyListener(this);
		
		
		
		//En el siguiente evento creo un adaptador para poder implementar la funcionalidad en el ojo de mostrar la contraseña.
		labelMostrarContrasena.addMouseListener(new MouseAdapter(){
			
			public void mouseEntered(MouseEvent e) {
				
				contrasenaTXT.setEchoChar((char)0);
				labelMostrarContrasena.setIcon(ojo2);
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				
				contrasenaTXT.setEchoChar(valor);
				labelMostrarContrasena.setIcon(ojo);
				
			}
			
		});
		
	}

	
	//-------------------------------------------------------------------------------------------------
	
	/**
	 * aqui se utiliza el actionPerformed para validar la ejecucion del boton rehgistrar
	 * y ademas se utiliza diferentes validaciones para su funcionalidad correcta.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		int validacion=0;		
		String lecturaUsuario= usuarioTXT.getText();
		String lecturaContrasena = contrasenaTXT.getText();
		
		Object evento = e.getSource();
		
		if(evento == btnRegistrarUsuario) {
			
			Ventana ventanaRegistro = new Ventana(new Usuario("", "", "", "", "", "", 0));
			ventanaRegistro.ventanaRegistroUsuarios();
			
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
					Ventana ventanaUsuario = new Ventana(Gestor.retornarUsuario(usuarioTXT.getText()));
					Usuario UsuarioActual = Gestor.retornarUsuario(usuarioTXT.getText());
					ventanaUsuario.setUsuarioActual(UsuarioActual);
					ventanaUsuario.ventanaMenuUsuarios(perfil, ventanaUsuario);
					
					SwingUtilities.getWindowAncestor(getRootPane()).dispose();
					
					
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
		if(e.getSource()==btnSalir) {
			
			JOptionPane.showMessageDialog(null, "Muchas Gracias por usar nuestra App", "Agradecimiento", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
			
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
						Ventana ventanaUsuario = new Ventana(controlador.retornarUsuario(usuarioTXT.getText()));
						Usuario UsuarioActual = controlador.retornarUsuario(usuarioTXT.getText());
						ventanaUsuario.setUsuarioActual(UsuarioActual);
						ventanaUsuario.ventanaMenuUsuarios(perfil, ventanaUsuario);
						
						SwingUtilities.getWindowAncestor(getRootPane()).dispose();
						
						
					}
					if (validacion == 1){
						
						usuarioTXT.setText("");
						contrasenaTXT.setText("");
						JOptionPane.showMessageDialog(null, "¡Usuario o Clave Incorrecta!.");
						JOptionPane.showMessageDialog(null, "Registrese antes de ingresar.");
						
					}
					if (validacion == 0) {
						
						JOptionPane.showMessageDialog(null, "Porfavor ingrese el usuario y la contraseña.");
						
					}
				}
				
				
			}
	
		}
		
	}


	
	//-------------------------------------------------------------------------------------
	/**
	 * esta es el metodo para ponerle de fondo una imagen con su alto y ancho solicitados
	 */
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
	
	/**
	 * Este metodo le da los estilos a los botones y componentes principales
	 * del login en general
	 */
	public void darEstilosComponentes(){
	
		
		
		try {
			
			btnRegistrarUsuario.setBackground(new Color(227, 242, 253));
			btnRegistrarUsuario.setForeground(Color.BLACK);
			btnIngreso.setBackground(new Color(227, 242, 253));
			btnIngreso.setForeground(Color.BLACK);
			btnSalir.setBackground(new Color(227, 242, 253));
			btnSalir.setForeground(Color.BLACK);
			
			
			
			labelNomUsuario.setForeground(Color.WHITE);
			usuarioTXT.setBackground(new Color(250, 250, 250));
			usuarioTXT.setForeground(new Color(0, 0, 0));
			usuarioTXT.setFont(new Font(usuarioTXT.getFont().getFontName(), Font.BOLD, 12));
			
			labelContrasenaUsuario.setForeground(Color.WHITE);
			contrasenaTXT.setBackground(new Color(250, 250, 250));
			contrasenaTXT.setForeground(new Color(0, 0, 0));
			contrasenaTXT.setFont(new Font(usuarioTXT.getFont().getFontName(), Font.BOLD, 12));
			
		}catch(Exception e) {
			
			
			
		}
		
	}
	
	

}
