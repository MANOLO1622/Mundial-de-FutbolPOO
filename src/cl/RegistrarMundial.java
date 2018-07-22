package cl;

import java.awt.Color;
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
	
	private static JButton btnRegistrarMundial = new JButton("Registrar");
	
	
	
    private static Image imagen;
	
    
    public RegistrarMundial () {
    	
    	
    	this.setLayout(null);
		this.setBackground(Color.CYAN);
		
		this.add(labelAno);
		labelAno.setForeground(Color.WHITE);
		labelAno.setBounds(10,30,200,30);
		
		this.add(anoTXT);
		anoTXT.setBounds(125,30,200,20);
		
		this.add(labelPaisOrganizador);
		labelPaisOrganizador.setForeground(Color.WHITE);
		labelPaisOrganizador.setBounds(10,70,200,30);
		
		this.add(paisOrganizadorTXT);
		paisOrganizadorTXT.setBounds(125,70,200,20);
		
		this.add(labelEstado);
		labelEstado.setForeground(Color.WHITE);
		labelEstado.setBounds(10,110,200,30);
		
		this.add(estadoTXT);
		estadoTXT.setBounds(125,110,200,20);
		
		this.add(btnRegistrarMundial);
		btnRegistrarMundial.setBounds(10, 270, 100, 25);
		
		btnRegistrarMundial.addActionListener(this);
		
    }
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
				
			
		
		
		
	}

	
}
