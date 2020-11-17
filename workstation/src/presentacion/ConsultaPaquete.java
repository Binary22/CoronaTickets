package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPanel;

import datatypes.DtPaquete;
import excepciones.NoExistePaqueteException;
import excepciones.NoHayPaquetesException;
import logica.Fabrica;
import logica.IConsulta;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;

public class ConsultaPaquete extends JInternalFrame {

	JLabel lblNompaquete;
	JLabel gbc_lblFechai;
	JLabel gbc_lblFechaf;
	private JLabel lblOff;
	private JLabel lblFechaf;
	private JLabel lblFechai;
	private List<String> paquetes;
	private JComboBox<String> comboBox_1;
	private IConsulta iConsult;
	private JTextPane textpDescripcion;


	public ConsultaPaquete() {
		Fabrica fab = Fabrica.getInstance();
		iConsult = fab.getIConsulta();
		paquetes = new ArrayList<String>();
		try {
			paquetes = iConsult.listarPaquetes();
		} catch (NoHayPaquetesException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 82, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 42, 47, 39, 44, 35, 53, 26, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		JLabel lblNewLabel = new JLabel("Paquete:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);

		JComboBox<String> comboBox = new JComboBox<String>();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 0;
		getContentPane().add(comboBox, gbc_comboBox);
		ConsultaEspectaculo.updateComboBox(paquetes, comboBox);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				iConsult.seleccionarPaquete((String)comboBox.getSelectedItem());
				updateDatos(iConsult.mostrarPaquete());
				} catch (NoExistePaqueteException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
					return;
				}
			}
		});
		GridBagConstraints gbc_btnConsultar = new GridBagConstraints();
		gbc_btnConsultar.insets = new Insets(0, 0, 5, 0);
		gbc_btnConsultar.gridx = 2;
		gbc_btnConsultar.gridy = 0;
		getContentPane().add(btnConsultar, gbc_btnConsultar);

		JLabel lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 1;
		getContentPane().add(lblNombre, gbc_lblNombre);

		lblNompaquete = new JLabel("");
		GridBagConstraints gbc_lblNompaquete = new GridBagConstraints();
		gbc_lblNompaquete.insets = new Insets(0, 0, 5, 5);
		gbc_lblNompaquete.gridx = 1;
		gbc_lblNompaquete.gridy = 1;
		getContentPane().add(lblNompaquete, gbc_lblNompaquete);

		JLabel lblFechaInicio = new JLabel("Fecha Inicio:");
		GridBagConstraints gbc_lblFechaInicio = new GridBagConstraints();
		gbc_lblFechaInicio.anchor = GridBagConstraints.EAST;
		gbc_lblFechaInicio.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaInicio.gridx = 0;
		gbc_lblFechaInicio.gridy = 2;
		getContentPane().add(lblFechaInicio, gbc_lblFechaInicio);

		lblFechai = new JLabel("");
		GridBagConstraints gbc_lblFechai = new GridBagConstraints();
		gbc_lblFechai.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechai.gridx = 1;
		gbc_lblFechai.gridy = 2;
		getContentPane().add(lblFechai, gbc_lblFechai);

		JLabel lblFechaFinal = new JLabel("Fecha Final:");
		GridBagConstraints gbc_lblFechaFinal = new GridBagConstraints();
		gbc_lblFechaFinal.anchor = GridBagConstraints.EAST;
		gbc_lblFechaFinal.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaFinal.gridx = 0;
		gbc_lblFechaFinal.gridy = 3;
		getContentPane().add(lblFechaFinal, gbc_lblFechaFinal);

		lblFechaf = new JLabel("");
		GridBagConstraints gbc_lblFechaf = new GridBagConstraints();
		gbc_lblFechaf.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaf.gridx = 1;
		gbc_lblFechaf.gridy = 3;
		getContentPane().add(lblFechaf, gbc_lblFechaf);

		JLabel lblDescuento = new JLabel("Descuento:");
		GridBagConstraints gbc_lblDescuento = new GridBagConstraints();
		gbc_lblDescuento.anchor = GridBagConstraints.EAST;
		gbc_lblDescuento.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescuento.gridx = 0;
		gbc_lblDescuento.gridy = 4;
		getContentPane().add(lblDescuento, gbc_lblDescuento);

		lblOff = new JLabel("");
		GridBagConstraints gbc_lblOff = new GridBagConstraints();
		gbc_lblOff.insets = new Insets(0, 0, 5, 5);
		gbc_lblOff.gridx = 1;
		gbc_lblOff.gridy = 4;
		getContentPane().add(lblOff, gbc_lblOff);

		JLabel lblDescripcion = new JLabel("Descripcion:");
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.anchor = GridBagConstraints.EAST;
		gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcion.gridx = 0;
		gbc_lblDescripcion.gridy = 5;
		getContentPane().add(lblDescripcion, gbc_lblDescripcion);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 5;
		getContentPane().add(scrollPane, gbc_scrollPane);
		
		textpDescripcion = new JTextPane();
		textpDescripcion.setEditable(false);
		scrollPane.setViewportView(textpDescripcion);
		
		JLabel lblEspectaculos = new JLabel("Espectaculos:");
		GridBagConstraints gbc_lblEspectaculos = new GridBagConstraints();
		gbc_lblEspectaculos.anchor = GridBagConstraints.EAST;
		gbc_lblEspectaculos.insets = new Insets(0, 0, 5, 5);
		gbc_lblEspectaculos.gridx = 0;
		gbc_lblEspectaculos.gridy = 6;
		getContentPane().add(lblEspectaculos, gbc_lblEspectaculos);
		
		comboBox_1 = new JComboBox<String>();
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 1;
		gbc_comboBox_1.gridy = 6;
		getContentPane().add(comboBox_1, gbc_comboBox_1);
		
		JButton btnConsultar_1 = new JButton("Consultar");
		GridBagConstraints gbc_btnConsultar_1 = new GridBagConstraints();
		gbc_btnConsultar_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnConsultar_1.gridx = 2;
		gbc_btnConsultar_1.gridy = 6;
		getContentPane().add(btnConsultar_1, gbc_btnConsultar_1);

		btnConsultar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				iConsult.elegirEspectaculo((String)comboBox_1.getSelectedItem());
				ConsultaEspectaculoAnidado cea = new ConsultaEspectaculoAnidado(iConsult);
				getParent().add(cea);
				cea.setVisible(true);
				cea.setClosable(true);
				dispose();
			}
		});
	}

	protected void updateDatos(DtPaquete dpaq) {
		lblNompaquete.setText(dpaq.getNombre());
		lblFechai.setText(dpaq.getFechaI().toString());
		lblFechaf.setText(dpaq.getFechaF().toString());
		lblOff.setText(String.valueOf(dpaq.getDescuento()));
		textpDescripcion.setText(dpaq.getDescripcion());
		ConsultaEspectaculo.updateComboBox(dpaq.getEspectaculos(), comboBox_1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void PasarPaquete(String paq) throws NoExistePaqueteException {
		iConsult.seleccionarPaquete(paq);
		updateDatos(iConsult.mostrarPaquete());
	}
		
}
