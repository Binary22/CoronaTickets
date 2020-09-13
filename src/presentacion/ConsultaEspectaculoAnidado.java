package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import logica.IConsulta;
import java.awt.GridBagLayout;
import javax.swing.JLabel;

import datatypes.DtEspectaculo;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ConsultaEspectaculoAnidado extends JInternalFrame {
	
	private IConsulta ic;
	private ArrayList<String> funciones;
	private ArrayList<String> paquetes;
	private DtEspectaculo espectaculo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaEspectaculoAnidado frame = new ConsultaEspectaculoAnidado();
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
	public ConsultaEspectaculoAnidado(IConsulta ic) {
		this.ic = ic;
		DtEspectaculo dte = ic.mostrarEspectaculo();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel jlbNombre = new JLabel("New label");
		GridBagConstraints gbc_jlbNombre = new GridBagConstraints();
		gbc_jlbNombre.insets = new Insets(0, 0, 5, 5);
		gbc_jlbNombre.gridx = 3;
		gbc_jlbNombre.gridy = 1;
		getContentPane().add(jlbNombre, gbc_jlbNombre);
		jlbNombre.setText(dte.getNombre());
		
		JLabel lblNewLabel_1 = new JLabel("Duracion:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblDuracion = new JLabel("duracion");
		GridBagConstraints gbc_lblDuracion = new GridBagConstraints();
		gbc_lblDuracion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDuracion.gridx = 3;
		gbc_lblDuracion.gridy = 2;
		getContentPane().add(lblDuracion, gbc_lblDuracion);
		lblDuracion.setText(dte.getDuracion().toString());
		
		JLabel lblNewLabel_2 = new JLabel("Descripcion:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 3;
		getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		lblNewLabel_2.setText(dte.getDescripcion());
		
		JLabel lblDesc = new JLabel("desc");
		GridBagConstraints gbc_lblDesc = new GridBagConstraints();
		gbc_lblDesc.insets = new Insets(0, 0, 5, 5);
		gbc_lblDesc.gridx = 3;
		gbc_lblDesc.gridy = 3;
		getContentPane().add(lblDesc, gbc_lblDesc);
		lblDesc.setText(dte.getDescripcion());
		
		JLabel lblEspectadores = new JLabel("Espectadores:");
		GridBagConstraints gbc_lblEspectadores = new GridBagConstraints();
		gbc_lblEspectadores.insets = new Insets(0, 0, 5, 5);
		gbc_lblEspectadores.gridx = 1;
		gbc_lblEspectadores.gridy = 4;
		getContentPane().add(lblEspectadores, gbc_lblEspectadores);
		
		JLabel lblMinToMax = new JLabel("min to max esp");
		GridBagConstraints gbc_lblMinToMax = new GridBagConstraints();
		gbc_lblMinToMax.insets = new Insets(0, 0, 5, 5);
		gbc_lblMinToMax.gridx = 3;
		gbc_lblMinToMax.gridy = 4;
		getContentPane().add(lblMinToMax, gbc_lblMinToMax);
		String min2max = dte.getMinEspectadores() + " hasta " + dte.getMaxEspectadores();
		lblMinToMax.setText(min2max);
		
		JLabel lblUrl = new JLabel("URL:");
		GridBagConstraints gbc_lblUrl = new GridBagConstraints();
		gbc_lblUrl.insets = new Insets(0, 0, 5, 5);
		gbc_lblUrl.gridx = 1;
		gbc_lblUrl.gridy = 5;
		getContentPane().add(lblUrl, gbc_lblUrl);
		
		JLabel lblUrl_1 = new JLabel("url");
		GridBagConstraints gbc_lblUrl_1 = new GridBagConstraints();
		gbc_lblUrl_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblUrl_1.gridx = 3;
		gbc_lblUrl_1.gridy = 5;
		getContentPane().add(lblUrl_1, gbc_lblUrl_1);
		lblUrl_1.setText(dte.getUrl());
		
		JLabel lblCosto = new JLabel("Costo:");
		GridBagConstraints gbc_lblCosto = new GridBagConstraints();
		gbc_lblCosto.insets = new Insets(0, 0, 5, 5);
		gbc_lblCosto.gridx = 1;
		gbc_lblCosto.gridy = 6;
		getContentPane().add(lblCosto, gbc_lblCosto);
		
		JLabel lblCost = new JLabel("cost");
		GridBagConstraints gbc_lblCost = new GridBagConstraints();
		gbc_lblCost.insets = new Insets(0, 0, 5, 5);
		gbc_lblCost.gridx = 3;
		gbc_lblCost.gridy = 6;
		getContentPane().add(lblCost, gbc_lblCost);
		lblCost.setText(String.valueOf(dte.getCosto()));
		
		JLabel lblFunciones = new JLabel("Funciones:");
		GridBagConstraints gbc_lblFunciones = new GridBagConstraints();
		gbc_lblFunciones.insets = new Insets(0, 0, 5, 5);
		gbc_lblFunciones.gridx = 1;
		gbc_lblFunciones.gridy = 7;
		getContentPane().add(lblFunciones, gbc_lblFunciones);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 3;
		gbc_comboBox.gridy = 7;
		getContentPane().add(comboBox, gbc_comboBox);
		
		funciones = ic.listarFuncionesEspect(dte.getNombre());
		ConsultaEspectaculo.updateComboBox(funciones, comboBox);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_btnConsultar = new GridBagConstraints();
		gbc_btnConsultar.insets = new Insets(0, 0, 5, 5);
		gbc_btnConsultar.gridx = 4;
		gbc_btnConsultar.gridy = 7;
		getContentPane().add(btnConsultar, gbc_btnConsultar);
		
		JLabel lblPaquetes = new JLabel("Paquetes:");
		GridBagConstraints gbc_lblPaquetes = new GridBagConstraints();
		gbc_lblPaquetes.insets = new Insets(0, 0, 5, 5);
		gbc_lblPaquetes.gridx = 1;
		gbc_lblPaquetes.gridy = 8;
		getContentPane().add(lblPaquetes, gbc_lblPaquetes);
		
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 3;
		gbc_comboBox_1.gridy = 8;
		getContentPane().add(comboBox_1, gbc_comboBox_1);
		
		paquetes = ic.listarPaquetes();
		ConsultaEspectaculo.updateComboBox(paquetes, comboBox_1);
		
		JButton btnConsultar_1 = new JButton("Consultar");
		btnConsultar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnConsultar_1 = new GridBagConstraints();
		gbc_btnConsultar_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnConsultar_1.gridx = 4;
		gbc_btnConsultar_1.gridy = 8;
		getContentPane().add(btnConsultar_1, gbc_btnConsultar_1);
		
		JButton btnTerminar = new JButton("Terminar");
		btnTerminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		GridBagConstraints gbc_btnTerminar = new GridBagConstraints();
		gbc_btnTerminar.insets = new Insets(0, 0, 0, 5);
		gbc_btnTerminar.gridx = 3;
		gbc_btnTerminar.gridy = 10;
		getContentPane().add(btnTerminar, gbc_btnTerminar);
		
	}
	
	public ConsultaEspectaculoAnidado() {
		setBounds(300, 300, 900, 350);

	}

}
