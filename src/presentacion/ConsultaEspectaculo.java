package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import java.awt.Insets;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import logica.ConsultaController;
import logica.EspectaculoController;
import logica.Fabrica;
import logica.IConsulta;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ConsultaEspectaculo extends JInternalFrame {
	
	/**
	 * Launch the application.
	 */
	
	private ArrayList<String> plataformas;
	private ArrayList<String> espectaculos;
	private JComboBox<String> comboBox_1;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaEspectaculo frame = new ConsultaEspectaculo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConsultaEspectaculo() {
		
		Fabrica f = Fabrica.getInstance();
		IConsulta ic = f.getIConsulta();
		plataformas = ic.listarPlataformas();
		
		if (plataformas == null) {
			plataformas = new ArrayList<String>(4);
			for(int i=1;i <4; i++) {
				plataformas.add("hola");
			}
			plataformas.add("chau");
		}
		
		setBounds(300, 300, 900, 350);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JLabel lblPlataforma = new JLabel("Plataforma");
		springLayout.putConstraint(SpringLayout.NORTH, lblPlataforma, 60, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblPlataforma, 140, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblPlataforma);
		
		JComboBox<String> comboBox = new JComboBox<String>(plataformas.toArray(new String[plataformas.size()]));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String plataforma = (String) comboBox.getSelectedItem();
				espectaculos = ic.listarEspectaculosPlataforma(plataforma);
				if (espectaculos == null) {
					//System.out.print("No hay espectaculos en esa plataforma");
					//Tirar un dialogo que avise esto.
					if (plataforma == "hola") {
						espectaculos = new ArrayList<String>(2);
							espectaculos.add("Maluma");
							espectaculos.add("Ozuna");
							updateComboBox(espectaculos);
					} else {
						espectaculos = new ArrayList<String>(2);
						espectaculos.add("La Vela Puerca");
						espectaculos.add("NTVG");
						updateComboBox(espectaculos);
					}
				} else {
					updateComboBox(espectaculos);
				}
			}
		});
		
		
		springLayout.putConstraint(SpringLayout.NORTH, comboBox, 60, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, comboBox, 117, SpringLayout.EAST, lblPlataforma);
		springLayout.putConstraint(SpringLayout.EAST, comboBox, 421, SpringLayout.EAST, lblPlataforma);
		getContentPane().add(comboBox);
		
		JLabel lblEspectaculo = new JLabel("Espectaculo");
		springLayout.putConstraint(SpringLayout.NORTH, lblEspectaculo, 41, SpringLayout.SOUTH, lblPlataforma);
		springLayout.putConstraint(SpringLayout.EAST, lblEspectaculo, 0, SpringLayout.EAST, lblPlataforma);
		getContentPane().add(lblEspectaculo);
		
		comboBox_1 = new JComboBox<String>();
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, comboBox_1, 32, SpringLayout.SOUTH, comboBox);
		springLayout.putConstraint(SpringLayout.WEST, comboBox_1, 117, SpringLayout.EAST, lblEspectaculo);
		springLayout.putConstraint(SpringLayout.SOUTH, comboBox_1, 56, SpringLayout.SOUTH, comboBox);
		springLayout.putConstraint(SpringLayout.EAST, comboBox_1, 0, SpringLayout.EAST, comboBox);
		getContentPane().add(comboBox_1);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Abre el caso de uso anidado
				dispose();
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnConsultar, 248, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnConsultar, -76, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(btnConsultar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnCancelar, 0, SpringLayout.NORTH, btnConsultar);
		springLayout.putConstraint(SpringLayout.WEST, btnCancelar, 151, SpringLayout.EAST, btnConsultar);
		getContentPane().add(btnCancelar);
		
	}
	
	private void updateComboBox(ArrayList<String> lista) {
		comboBox_1.removeAllItems();
		lista.forEach(el -> comboBox_1.addItem(el));
	}
}
