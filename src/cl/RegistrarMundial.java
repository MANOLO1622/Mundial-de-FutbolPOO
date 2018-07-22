package cl;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gestor.Gestor;

public class RegistrarMundial extends JPanel  implements ActionListener{

private static Gestor controlador = new Gestor(); 
	
	private static JLabel labelAno = new JLabel("Año: ");
	private static JTextField anoTXT = new JTextField(10);
	
	private static JLabel labelPaisOrganizador = new JLabel("Pais Organizador:");
	private static JTextField paisOrganizadorTXT = new JTextField(10);
	
	private static JLabel labelEstado = new JLabel("Estado:");
	private static JTextField estadoTXT = new JTextField(10);
	
	
	
    private static Image imagen;
	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
	}

	
}
