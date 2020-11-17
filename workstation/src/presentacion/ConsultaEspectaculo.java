package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class ConsultaEspectaculo extends JInternalFrame {
	
	/**
	 * Launch the application.
	 */
	
	private List<String> plataformas;
	private List<String> espectaculos;
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
		setTitle("Consulta de Espectaculo");
		
		Fabrica fab = Fabrica.getInstance();
		IConsulta iconsult = fab.getIConsulta();
		plataformas = iconsult.listarPlataformas();
		
		setBounds(300, 300, 900, 350);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JLabel lblPlataforma = new JLabel("Plataforma");
		springLayout.putConstraint(SpringLayout.NORTH, lblPlataforma, 60, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblPlataforma, 140, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblPlataforma);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		updateComboBox(plataformas, comboBox);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				String plataforma = (String) comboBox.getSelectedItem();
				espectaculos = iconsult.listarEspectaculosPlataforma(plataforma);
				if (espectaculos != null) {
					updateComboBox(espectaculos, comboBox_1);
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
			public void actionPerformed(ActionEvent evento) {
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
				iconsult.elegirEspectaculo((String)comboBox_1.getSelectedItem());
				ConsultaEspectaculoAnidado cea = new ConsultaEspectaculoAnidado(iconsult);
				getParent().add(cea);
				cea.setVisible(true);
				cea.setClosable(true);
				dispose();
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnConsultar, 248, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnConsultar, -76, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(btnConsultar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				dispose();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnCancelar, 0, SpringLayout.NORTH, btnConsultar);
		springLayout.putConstraint(SpringLayout.WEST, btnCancelar, 151, SpringLayout.EAST, btnConsultar);
		getContentPane().add(btnCancelar);
		
	}
	
	static void updateComboBox(List<String> lista, JComboBox<String> cbvar) {
		cbvar.removeAllItems();
		lista.sort(String::compareToIgnoreCase);
		lista.forEach(el -> cbvar.addItem(el));
	}
}
