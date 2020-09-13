package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;

import logica.Fabrica;
import logica.IConsulta;
import logica.IEspectaculo;

import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaFuncionEspectaculo extends JInternalFrame {
	private String espec;

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
		setClosable(true);
		Fabrica f = Fabrica.getInstance();
		IConsulta icontrolador= f.getIConsulta();
		
		setBounds(100, 100, 450, 300);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblPlataformas = new JLabel("Plataformas:");
		GridBagConstraints gbc_lblPlataformas = new GridBagConstraints();
		gbc_lblPlataformas.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlataformas.anchor = GridBagConstraints.EAST;
		gbc_lblPlataformas.gridx = 0;
		gbc_lblPlataformas.gridy = 0;
		getContentPane().add(lblPlataformas, gbc_lblPlataformas);
		
		JComboBox comboBox_1 = new JComboBox();
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 1;
		gbc_comboBox_1.gridy = 2;
		getContentPane().add(comboBox_1, gbc_comboBox_1);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				comboBox.removeAllItems();
				ArrayList<String > listap = icontrolador.listarPlataformas();
				for (int i = 0; i < listap.size(); i++) {
					comboBox.addItem(listap.get(i));
				}
			}
		});
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 0;
		getContentPane().add(comboBox, gbc_comboBox);
		
		JButton btnVerEspectaculos = new JButton("Ver espectaculos");
		btnVerEspectaculos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String plat = (String)comboBox.getSelectedItem();
				ArrayList<String> especs = icontrolador.listarEspectaculosPlataforma(plat);
				comboBox_1.removeAllItems();
				for (int i = 0; i < especs.size(); i++) {
					comboBox_1.addItem(especs.get(i));
				}
				
			}
		});
		GridBagConstraints gbc_btnVerEspectaculos = new GridBagConstraints();
		gbc_btnVerEspectaculos.insets = new Insets(0, 0, 5, 0);
		gbc_btnVerEspectaculos.gridx = 1;
		gbc_btnVerEspectaculos.gridy = 1;
		getContentPane().add(btnVerEspectaculos, gbc_btnVerEspectaculos);
		
		JLabel lblEspectaculos = new JLabel("Espectaculos:");
		GridBagConstraints gbc_lblEspectaculos = new GridBagConstraints();
		gbc_lblEspectaculos.anchor = GridBagConstraints.EAST;
		gbc_lblEspectaculos.insets = new Insets(0, 0, 5, 5);
		gbc_lblEspectaculos.gridx = 0;
		gbc_lblEspectaculos.gridy = 2;
		getContentPane().add(lblEspectaculos, gbc_lblEspectaculos);
		
		JComboBox comboBox_2 = new JComboBox();
		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		gbc_comboBox_2.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_2.gridx = 1;
		gbc_comboBox_2.gridy = 4;
		getContentPane().add(comboBox_2, gbc_comboBox_2);

		JButton btnVerFunciones = new JButton("Ver funciones");
		btnVerFunciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				espec = (String)comboBox_1.getSelectedItem();
				ArrayList<String> funcs = icontrolador.listarFuncionesEspect(espec);
				//System.out.print("DEBUG" + funcs.size());
				comboBox_2.removeAllItems();
				for (int i = 0; i < funcs.size(); i++) {
					comboBox_2.addItem(funcs.get(i));
				}
			}
		});
		GridBagConstraints gbc_btnVerFunciones = new GridBagConstraints();
		gbc_btnVerFunciones.insets = new Insets(0, 0, 5, 0);
		gbc_btnVerFunciones.gridx = 1;
		gbc_btnVerFunciones.gridy = 3;
		getContentPane().add(btnVerFunciones, gbc_btnVerFunciones);
		
		JLabel lblFunciones = new JLabel("Funciones:");
		GridBagConstraints gbc_lblFunciones = new GridBagConstraints();
		gbc_lblFunciones.anchor = GridBagConstraints.EAST;
		gbc_lblFunciones.insets = new Insets(0, 0, 5, 5);
		gbc_lblFunciones.gridx = 0;
		gbc_lblFunciones.gridy = 4;
		getContentPane().add(lblFunciones, gbc_lblFunciones);
		
		
		JButton btnConsultarFuncin = new JButton("Consultar función");
		btnConsultarFuncin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// ACA TENGO QUE ABRIR EL CASO DE USO ANIDADO
				// codigo de otro CU
				icontrolador.elegirFuncion(espec, (String)comboBox_2.getSelectedItem());
				ConsultaFuncionEspectaculoAnidado cdea = new ConsultaFuncionEspectaculoAnidado(icontrolador);
				getParent().add(cdea);
				cdea.setVisible(true);
				cdea.setClosable(true);
				
				// para que se vaya la ventana de consultar funcion (no anidado)
				setVisible(false);
			}
		});
		GridBagConstraints gbc_btnConsultarFuncin = new GridBagConstraints();
		gbc_btnConsultarFuncin.gridx = 1;
		gbc_btnConsultarFuncin.gridy = 5;
		getContentPane().add(btnConsultarFuncin, gbc_btnConsultarFuncin);

	}

}
