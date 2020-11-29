package presentacion;

import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import excepciones.NoHayPaquetesException;
import logica.Fabrica;
import logica.IConsulta;
import logica.IPaquete;

import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarEspectaculo extends JInternalFrame {
	private List<String> paquetes;
	private List<String> plataformas;
	private List<String> espectaculos;
	private JComboBox<String> comboBox_1;
	private JComboBox<String> comboBox;
	private JComboBox<String> comboBox_2;

	public AgregarEspectaculo() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblPaquete = new JLabel("Paquete:");
		GridBagConstraints gbc_lblPaquete = new GridBagConstraints();
		gbc_lblPaquete.insets = new Insets(0, 0, 5, 5);
		gbc_lblPaquete.anchor = GridBagConstraints.EAST;
		gbc_lblPaquete.gridx = 1;
		gbc_lblPaquete.gridy = 1;
		getContentPane().add(lblPaquete, gbc_lblPaquete);
		
		comboBox = new JComboBox<String>();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 1;
		getContentPane().add(comboBox, gbc_comboBox);

		Fabrica fab = Fabrica.getInstance();
		IConsulta iconsult = fab.getIConsulta();
		plataformas = iconsult.listarPlataformas();
		espectaculos = new ArrayList<String>();
		try {
			paquetes = iconsult.listarPaquetes();
		} catch (NoHayPaquetesException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		ConsultaEspectaculo.updateComboBox(paquetes, comboBox);
		
		JLabel lblPlataforma = new JLabel("Plataforma:");
		GridBagConstraints gbc_lblPlataforma = new GridBagConstraints();
		gbc_lblPlataforma.anchor = GridBagConstraints.EAST;
		gbc_lblPlataforma.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlataforma.gridx = 1;
		gbc_lblPlataforma.gridy = 3;
		getContentPane().add(lblPlataforma, gbc_lblPlataforma);
		
		comboBox_1 = new JComboBox<String>();
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 2;
		gbc_comboBox_1.gridy = 3;
		getContentPane().add(comboBox_1, gbc_comboBox_1);
		ConsultaEspectaculo.updateComboBox(plataformas, comboBox_1);
		
		IPaquete ipaq = fab.getIPaquete();


		JButton btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				espectaculos = iconsult.listarEspectaculosPlataforma((String)comboBox_1.getSelectedItem());
				try {
					iconsult.seleccionarPaquete((String)comboBox.getSelectedItem());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				espectaculos.removeAll(iconsult.mostrarPaquete().getEspectaculos());
				ConsultaEspectaculo.updateComboBox(espectaculos, comboBox_2);
			}
		});
		GridBagConstraints gbc_btnSeleccionar = new GridBagConstraints();
		gbc_btnSeleccionar.insets = new Insets(0, 0, 5, 5);
		gbc_btnSeleccionar.gridx = 4;
		gbc_btnSeleccionar.gridy = 3;
		getContentPane().add(btnSeleccionar, gbc_btnSeleccionar);
		
		JLabel lblEspectaculo = new JLabel("Espectaculo:");
		GridBagConstraints gbc_lblEspectaculo = new GridBagConstraints();
		gbc_lblEspectaculo.anchor = GridBagConstraints.EAST;
		gbc_lblEspectaculo.insets = new Insets(0, 0, 5, 5);
		gbc_lblEspectaculo.gridx = 1;
		gbc_lblEspectaculo.gridy = 5;
		getContentPane().add(lblEspectaculo, gbc_lblEspectaculo);
		
		comboBox_2 = new JComboBox<String>();
		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		gbc_comboBox_2.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_2.gridx = 2;
		gbc_comboBox_2.gridy = 5;
		getContentPane().add(comboBox_2, gbc_comboBox_2);

		
		JButton btnAgregarEspectaculo = new JButton("Agregar Espectaculo");
		btnAgregarEspectaculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				if (espectaculos.isEmpty()) {
					JOptionPane.showMessageDialog(null, "No hay espectaculos para ese paquete");
					return;
				}
				String espec = (String)comboBox_2.getSelectedItem();
				ipaq.elegirEspectaculo(espec);
				String paq = (String)comboBox.getSelectedItem();
				try {
					ipaq.seleccionarPaquete(paq);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				int input = JOptionPane.showConfirmDialog(null, "Desea confirmar la operación?");
					if (input == 0) {
						ipaq.confirmarAgregarEspectAPaquete();
						dispose();
					}
					if (input == 2) {
						comboBox.removeAllItems();
						comboBox_1.removeAllItems();
						comboBox_2.removeAllItems();
						dispose();
					}
			}
		});
		GridBagConstraints gbc_btnAgregarEspectaculo = new GridBagConstraints();
		gbc_btnAgregarEspectaculo.insets = new Insets(0, 0, 0, 5);
		gbc_btnAgregarEspectaculo.gridx = 2;
		gbc_btnAgregarEspectaculo.gridy = 7;
		getContentPane().add(btnAgregarEspectaculo, gbc_btnAgregarEspectaculo);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				dispose();
			}
		});
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelar.gridx = 4;
		gbc_btnCancelar.gridy = 7;
		getContentPane().add(btnCancelar, gbc_btnCancelar);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
