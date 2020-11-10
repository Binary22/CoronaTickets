package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTextField;

import logica.Fabrica;
import logica.IEspectaculo;

import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AceptarRechazarEspect extends JInternalFrame {
	private IEspectaculo ctrlEspect;
	private JComboBox<String> comboBoxEspectaculos; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AceptarRechazarEspect frame = new AceptarRechazarEspect();
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
	public AceptarRechazarEspect() {
		Fabrica fabrica = Fabrica.getInstance();
        ctrlEspect = fabrica.getIEspectaculo();
        
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Aceptar/Rechazar espectaculo");
		setBounds(100, 100, 559, 300);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 199, 198, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblEspectaculosIngresados = new JLabel("Espectaculos ingresados:");
		GridBagConstraints gbc_lblEspectaculosIngresados = new GridBagConstraints();
		gbc_lblEspectaculosIngresados.insets = new Insets(0, 0, 5, 5);
		gbc_lblEspectaculosIngresados.anchor = GridBagConstraints.EAST;
		gbc_lblEspectaculosIngresados.gridx = 1;
		gbc_lblEspectaculosIngresados.gridy = 1;
		getContentPane().add(lblEspectaculosIngresados, gbc_lblEspectaculosIngresados);
		
		comboBoxEspectaculos = new JComboBox<String>();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 1;
		getContentPane().add(comboBoxEspectaculos, gbc_comboBox);
		
		JButton btnVer = new JButton("Ver espectaculos");
		btnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cargarEspectaculosIngresados();
			}
		});
		GridBagConstraints gbc_btnVer = new GridBagConstraints();
		gbc_btnVer.insets = new Insets(0, 0, 5, 0);
		gbc_btnVer.gridx = 3;
		gbc_btnVer.gridy = 1;
		getContentPane().add(btnVer, gbc_btnVer);
		
		JRadioButton rdbtnAceptar = new JRadioButton("Aceptar");
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton.gridx = 2;
		gbc_rdbtnNewRadioButton.gridy = 3;
		getContentPane().add(rdbtnAceptar, gbc_rdbtnNewRadioButton);
		
		JRadioButton rdbtnRechazar = new JRadioButton("Rechazar");
		GridBagConstraints gbc_rdbtnRechazar = new GridBagConstraints();
		gbc_rdbtnRechazar.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnRechazar.gridx = 3;
		gbc_rdbtnRechazar.gridy = 3;
		getContentPane().add(rdbtnRechazar, gbc_rdbtnRechazar);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombre = (String) comboBoxEspectaculos.getSelectedItem();
				if(comboBoxEspectaculos.getSelectedIndex() != -1) {
					if(rdbtnAceptar.isSelected()==true && rdbtnRechazar.isSelected() == false) {
						ctrlEspect.aceptarRechazar(nombre, true);
						JOptionPane.showMessageDialog(null, "El espectaculo ha sido aceptado con exito", "Aceptar/Rechazar espectaculo", JOptionPane.INFORMATION_MESSAGE);
						dispose();
					}else if(rdbtnAceptar.isSelected()==false && rdbtnRechazar.isSelected() == true) {
							ctrlEspect.aceptarRechazar(nombre, false);
							JOptionPane.showMessageDialog(null, "El espectaculo ha sido rechazado con exito", "Aceptar/Rechazar espectaculo", JOptionPane.INFORMATION_MESSAGE);
							dispose();
						}
						else {
							JOptionPane.showMessageDialog(null, "Debe seleccionar solo una opcion", "Aceptar/Rechazar espectaculo", JOptionPane.INFORMATION_MESSAGE);
	
						}
						
					
				}else {
				JOptionPane.showMessageDialog(null, "Debe seleccionar un espectaculo", "Aceptar/Rechazar espectaculo", JOptionPane.INFORMATION_MESSAGE);

				}
			}
			
		});
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.insets = new Insets(0, 0, 0, 5);
		gbc_btnAceptar.gridx = 2;
		gbc_btnAceptar.gridy = 6;
		getContentPane().add(btnAceptar, gbc_btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.gridx = 3;
		gbc_btnCancelar.gridy = 6;
		getContentPane().add(btnCancelar, gbc_btnCancelar);

	}
	
	public void cargarEspectaculosIngresados() {
		comboBoxEspectaculos.removeAllItems();
		List<String> nombres = ctrlEspect.listarEspectaculosIngresados();
		nombres.sort(String::compareToIgnoreCase);
		for(int i = 0; i < nombres.size(); i++) {
        	comboBoxEspectaculos.addItem(nombres.get(i));
        	
        	}
		}
	

}
