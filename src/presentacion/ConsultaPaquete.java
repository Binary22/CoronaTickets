package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;

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

public class ConsultaPaquete extends JInternalFrame {

	JLabel lblNompaquete;
	JLabel gbc_lblFechai;
	JLabel gbc_lblFechaf;
	private JLabel lblOff;
	private JLabel lblFechaf;
	private JLabel lblFechai;
	private JLabel lblDesc;
	private ArrayList<String> paquetes;

	public ConsultaPaquete() {
		Fabrica f = Fabrica.getInstance();
		IConsulta cc = f.getIConsulta();
		paquetes = new ArrayList<String>();
		try {
			paquetes = cc.listarPaquetes();
		} catch (NoHayPaquetesException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		JLabel lblNewLabel = new JLabel("Paquete:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);

		JComboBox<String> comboBox = new JComboBox<String>();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 1;
		getContentPane().add(comboBox, gbc_comboBox);
		ConsultaEspectaculo.updateComboBox(paquetes, comboBox);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				cc.seleccionarPaquete((String)comboBox.getSelectedItem());
				updateDatos(cc.mostrarPaquete());
				} catch (NoExistePaqueteException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
					return;
				}
			}
		});
		GridBagConstraints gbc_btnConsultar = new GridBagConstraints();
		gbc_btnConsultar.insets = new Insets(0, 0, 5, 5);
		gbc_btnConsultar.gridx = 3;
		gbc_btnConsultar.gridy = 1;
		getContentPane().add(btnConsultar, gbc_btnConsultar);

		JLabel lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 2;
		getContentPane().add(lblNombre, gbc_lblNombre);

		lblNompaquete = new JLabel("");
		GridBagConstraints gbc_lblNompaquete = new GridBagConstraints();
		gbc_lblNompaquete.insets = new Insets(0, 0, 5, 5);
		gbc_lblNompaquete.gridx = 2;
		gbc_lblNompaquete.gridy = 2;
		getContentPane().add(lblNompaquete, gbc_lblNompaquete);

		JLabel lblFechaInicio = new JLabel("Fecha Inicio:");
		GridBagConstraints gbc_lblFechaInicio = new GridBagConstraints();
		gbc_lblFechaInicio.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaInicio.gridx = 1;
		gbc_lblFechaInicio.gridy = 3;
		getContentPane().add(lblFechaInicio, gbc_lblFechaInicio);

		lblFechai = new JLabel("");
		GridBagConstraints gbc_lblFechai = new GridBagConstraints();
		gbc_lblFechai.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechai.gridx = 2;
		gbc_lblFechai.gridy = 3;
		getContentPane().add(lblFechai, gbc_lblFechai);

		JLabel lblFechaFinal = new JLabel("Fecha Final:");
		GridBagConstraints gbc_lblFechaFinal = new GridBagConstraints();
		gbc_lblFechaFinal.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaFinal.gridx = 1;
		gbc_lblFechaFinal.gridy = 4;
		getContentPane().add(lblFechaFinal, gbc_lblFechaFinal);

		lblFechaf = new JLabel("");
		GridBagConstraints gbc_lblFechaf = new GridBagConstraints();
		gbc_lblFechaf.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaf.gridx = 2;
		gbc_lblFechaf.gridy = 4;
		getContentPane().add(lblFechaf, gbc_lblFechaf);

		JLabel lblDescuento = new JLabel("Descuento:");
		GridBagConstraints gbc_lblDescuento = new GridBagConstraints();
		gbc_lblDescuento.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescuento.gridx = 1;
		gbc_lblDescuento.gridy = 5;
		getContentPane().add(lblDescuento, gbc_lblDescuento);

		lblOff = new JLabel("");
		GridBagConstraints gbc_lblOff = new GridBagConstraints();
		gbc_lblOff.insets = new Insets(0, 0, 5, 5);
		gbc_lblOff.gridx = 2;
		gbc_lblOff.gridy = 5;
		getContentPane().add(lblOff, gbc_lblOff);

		JLabel lblDescripcion = new JLabel("Descripcion:");
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcion.gridx = 1;
		gbc_lblDescripcion.gridy = 6;
		getContentPane().add(lblDescripcion, gbc_lblDescripcion);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 6;
		getContentPane().add(panel, gbc_panel);

		lblDesc = new JLabel("");
		panel.add(lblDesc);
		
		JLabel lblEspectaculos = new JLabel("Espectaculos:");
		GridBagConstraints gbc_lblEspectaculos = new GridBagConstraints();
		gbc_lblEspectaculos.anchor = GridBagConstraints.EAST;
		gbc_lblEspectaculos.insets = new Insets(0, 0, 5, 5);
		gbc_lblEspectaculos.gridx = 1;
		gbc_lblEspectaculos.gridy = 7;
		getContentPane().add(lblEspectaculos, gbc_lblEspectaculos);
		
		JComboBox comboBox_1 = new JComboBox();
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 2;
		gbc_comboBox_1.gridy = 7;
		getContentPane().add(comboBox_1, gbc_comboBox_1);
		
		JButton btnConsultar_1 = new JButton("Consultar");
		GridBagConstraints gbc_btnConsultar_1 = new GridBagConstraints();
		gbc_btnConsultar_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnConsultar_1.gridx = 3;
		gbc_btnConsultar_1.gridy = 7;
		getContentPane().add(btnConsultar_1, gbc_btnConsultar_1);
	}

	protected void updateDatos(DtPaquete p) {
		lblNompaquete.setText(p.getNombre());
		lblFechai.setText(p.getFechaI().toString());
		lblFechaf.setText(p.getFechaF().toString());
		lblOff.setText(String.valueOf(p.getDescuento()));
		lblDesc.setText(p.getDescripcion());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
