package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import javax.swing.JButton;

public class ConsultaFuncionEspectaculo extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaFuncionEspectaculo frame = new ConsultaFuncionEspectaculo();
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
	public ConsultaFuncionEspectaculo() {
		setBounds(100, 100, 450, 300);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblPlataformas = new JLabel("Plataformas:");
		GridBagConstraints gbc_lblPlataformas = new GridBagConstraints();
		gbc_lblPlataformas.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlataformas.anchor = GridBagConstraints.EAST;
		gbc_lblPlataformas.gridx = 0;
		gbc_lblPlataformas.gridy = 0;
		getContentPane().add(lblPlataformas, gbc_lblPlataformas);
		
		JComboBox comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 0;
		getContentPane().add(comboBox, gbc_comboBox);
		
		JButton btnVerFunciones = new JButton("Ver funciones");
		GridBagConstraints gbc_btnVerFunciones = new GridBagConstraints();
		gbc_btnVerFunciones.insets = new Insets(0, 0, 5, 0);
		gbc_btnVerFunciones.gridx = 1;
		gbc_btnVerFunciones.gridy = 1;
		getContentPane().add(btnVerFunciones, gbc_btnVerFunciones);
		
		JLabel lblFunciones = new JLabel("Funciones:");
		GridBagConstraints gbc_lblFunciones = new GridBagConstraints();
		gbc_lblFunciones.anchor = GridBagConstraints.EAST;
		gbc_lblFunciones.insets = new Insets(0, 0, 5, 5);
		gbc_lblFunciones.gridx = 0;
		gbc_lblFunciones.gridy = 2;
		getContentPane().add(lblFunciones, gbc_lblFunciones);
		
		JComboBox comboBox_1 = new JComboBox();
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 1;
		gbc_comboBox_1.gridy = 2;
		getContentPane().add(comboBox_1, gbc_comboBox_1);
		
		JButton btnConsultarFuncin = new JButton("Consultar función");
		GridBagConstraints gbc_btnConsultarFuncin = new GridBagConstraints();
		gbc_btnConsultarFuncin.gridx = 1;
		gbc_btnConsultarFuncin.gridy = 3;
		getContentPane().add(btnConsultarFuncin, gbc_btnConsultarFuncin);

	}

}
