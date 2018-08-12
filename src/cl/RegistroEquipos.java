package cl;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import gestor.Gestor;

public class RegistroEquipos extends JPanel implements ActionListener  {

	
private  Gestor controlador = new Gestor(); 
	
	private JLabel labelNombre = new JLabel("Nombre del Pais:");
	private JTextField nombreTXT = new JTextField(10);
	
	private JLabel labelRanking = new JLabel("Ranking FIFA:");
	private JTextField rankingTXT = new JTextField(10);

	private JLabel labelBandera = new JLabel("Nombre Bandera: ");
	private JTextField banderaTXT = new JTextField(10);
	
	private JLabel labelISOPaises = new JLabel("Iso del Pais: ");
	private JTextField ISOPaisesTXT = new JTextField(10);
	
	
	
	
	
	private JButton btnRegistro = new JButton("Registrar");
	private JButton btnSalir = new JButton("Salir");
	
	
	private static Image imagen;
	
	
	
	public RegistroEquipos () {
		
		this.setLayout(null);
		
		this.add(labelNombre);
		labelNombre.setForeground(Color.WHITE);
		labelNombre.setBounds(10,70,200,30);
		
		this.add(nombreTXT);
		nombreTXT.setBounds(125,70,200,20);
		
		this.add(labelRanking);
		labelRanking.setForeground(Color.WHITE);
		labelRanking.setBounds(10,110,200,30);
		
		this.add(rankingTXT);
		rankingTXT.setBounds(125,110,200,20);
		
		this.add(labelBandera);
		labelBandera.setForeground(Color.WHITE);
		labelBandera.setBounds(10,110,200,30);
		
		this.add(banderaTXT);
		banderaTXT.setBounds(125,110,200,20);
		
		this.add(labelISOPaises);
		labelISOPaises.setForeground(Color.WHITE);
		labelISOPaises.setBounds(10,30,200,30);
		
		this.add(ISOPaisesTXT);
		ISOPaisesTXT.setBounds(125,30,200,20);
		
		
		
		
		
		

		
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
		// TODO Auto-generated method stub
		
		/*int validacionEquipo = controlador.validarEquipo(nombreTXT.getText(), rankingTXT.getText(),banderaTXT.getText(),ISOPaisesTXT.getText());
		
		
		if(e.getSource()==btnRegistro) {
			
			if(nombreTXT.getText().equals("") || rankingTXT.getText().equals("") || 
					   banderaTXT.getText().equals("") || ISOPaisesTXT.equals("") {
						
						JOptionPane.showMessageDialog(null, "Hay campos vacios, debe llenar todos los campos.");
						
					}	
			
			if (validacionEquipo == 1) {
				
				this.setBackground(Color.RED);
				JOptionPane.showMessageDialog(null, "Este Equipo ya se encuentra registrado.");
				
			}
			
			if(validacionEquipo == 0) {
				
				this.setBackground(Color.GREEN);
				controlador.registrarEquipos(nombreTXT.getText(), rankingTXT.getText(), banderaTXT.getText(), ISOPaisesTXT.getText());
				controlador.listarEquiposFIFA();
				JOptionPane.showMessageDialog(null, "Equipo registrado.");
				
				
				nombreTXT.setText("");
				rankingTXT.setText("");
				banderaTXT.setText("");
				ISOPaisesTXT.setText("");
				
				SwingUtilities.getWindowAncestor(getRootPane()).dispose();
		
			}
		
	  }*/
	}
}
