package cl; /////////////////////  TENGO QUE TERMINARLO PORQUE HAY UNOS ERRORES QUE AUN FALTAN

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import gestor.Gestor;

/**Esta clase pose los compoentes de los equipos registrados en el menu del admin
 * ademas contiene sus mentodos respectivos para el registro del equipo aun mundial.
 * @author DELL
 *
 */
public class RegistroEquipos extends JPanel implements ActionListener {
	
	public Usuario miUsuario;
	private Gestor controlador = new Gestor();

	private JLabel labelNombre = new JLabel("Nombre del Pais:");
	private JTextField nombreTXT = new JTextField(10);
	

	private JLabel labelRanking = new JLabel("Ranking FIFA:");
	private JTextField rankingTXT = new JTextField(10);

	private JLabel labelBandera = new JLabel("Nombre Bandera: ");
	private JTextField banderaTXT = new JTextField(10);

	private JLabel labelISOPaises = new JLabel("Iso del Pais: ");
	//private JTextField ISOPaisesTXT = new JTextField(10);
	JComboBox ISO = new JComboBox();

	private JButton btnRegistro = new JButton("Registrar");
	private JButton btnSalir = new JButton("Salir");

	private static Image imagen;

	/**
	 * Metodo de registro de los equipos en el menu admin 
	 * @param miUsuario
	 */
	public RegistroEquipos(Usuario miUsuario) {
		
		this.miUsuario = miUsuario;
		this.ingresarIsos();
		
		this.setLayout(null);

		this.add(labelNombre);
		labelNombre.setForeground(Color.WHITE);
		labelNombre.setBounds(10, 70, 200, 30);

		this.add(nombreTXT);
		nombreTXT.setBounds(125, 70, 200, 20);

		this.add(labelRanking);
		labelRanking.setForeground(Color.WHITE);
		labelRanking.setBounds(10, 110, 200, 30);

		this.add(rankingTXT);
		rankingTXT.setBounds(125, 110, 200, 20);

		this.add(labelBandera);
		labelBandera.setForeground(Color.WHITE);
		labelBandera.setBounds(10, 150, 200, 30);

		this.add(banderaTXT);
		banderaTXT.setBounds(125, 150, 200, 20);

		this.add(labelISOPaises);
		labelISOPaises.setForeground(Color.WHITE);
		labelISOPaises.setBounds(10, 30, 200, 30);

		this.add(ISO);
		ISO.setBounds(125, 30, 200, 30);

		this.add(btnRegistro);
		btnRegistro.setBounds(10, 270, 100, 25);

		this.add(btnSalir);
		btnSalir.setBounds(120, 270, 100, 25);

		// -----------------------Eventos
		btnRegistro.addActionListener(this);
		btnSalir.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {// validaciones del registrar equipo
		// TODO Auto-generated method stub

		int validacionEquipo = 0;
		try {
			validacionEquipo = controlador.validarEquipo(nombreTXT.getText(), 0, banderaTXT.getText(),
					(String)ISO.getSelectedItem());
		} catch (Exception e2) {
			
			e2.printStackTrace();
		}

		if (e.getSource() == btnRegistro) {

			if (nombreTXT.getText().equals("") || rankingTXT.getText().equals("") || banderaTXT.getText().equals("")
					|| ISO.equals("")) {

				JOptionPane.showMessageDialog(null, "Hay campos vacios, debe llenar todos los campos.");

			}

			else {
				if (validacionEquipo == 1) {

					this.setBackground(Color.RED);
					JOptionPane.showMessageDialog(null, "Este Equipo ya se encuentra registrado.");

				}

				if (validacionEquipo == 0) {

					this.setBackground(Color.GREEN);
					controlador.registrarEquipos(nombreTXT.getText(), 0, banderaTXT.getText(), ISOPaises.retornarISOPais((String)ISO.getSelectedItem()));
					try {
						controlador.listarEquiposFIFA();
					} catch (Exception e1) {
						
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "Equipo registrado.");

					nombreTXT.setText("");
					rankingTXT.setText("");
					banderaTXT.setText("");

					SwingUtilities.getWindowAncestor(getRootPane()).dispose();

				}

			}

		}
		if (e.getSource() == btnSalir) {//boton de salir del registrar equipo
			
			Ventana ventanaUsuario = new Ventana(controlador.retornarUsuario(this.miUsuario.getNombreUsuario()));
			Usuario UsuarioActual = controlador.retornarUsuario(this.miUsuario.getNombreUsuario());
			ventanaUsuario.setUsuarioActual(UsuarioActual);
			try {
				ventanaUsuario.ventanaMenuUsuarios(Perfiles.ADMIN, ventanaUsuario);
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
			SwingUtilities.getWindowAncestor(getRootPane()).dispose();

		}
		
		
		
	}
//-------------------------------------------------------------------------------------------------
	/**
	 * metodo de ingresos de los isos de cada pais
	 */
	public void ingresarIsos() {
		
		ArrayList<String> listaIsos = ISOPaises.retornarIsos(); 
		
		for(String e : listaIsos) {
			
			ISO.addItem(e);
			
			
			
		}
	}
	
	
//-------------------------------------------------------------------------------------------------    

	public void paintComponent(Graphics g) {

		int width = this.getSize().width;
		int height = this.getSize().height;

		this.setBackground("src\\graficos\\ReEquipo.jpg");
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

	// ------------------------------------------------------------------------------------------------
}
