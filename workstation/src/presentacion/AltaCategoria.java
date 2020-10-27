package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import excepciones.NombreCategoriaExistente;
import logica.Fabrica;
import logica.IEspectaculo;

public class AltaCategoria extends JInternalFrame {
	private JTextField textField;
	private JComboBox<String> comboBoxCategorias;
	private IEspectaculo ctrlEspect;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaCategoria frame = new AltaCategoria();
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
	public AltaCategoria() {
		
		Fabrica fabrica = Fabrica.getInstance();
        ctrlEspect = fabrica.getIEspectaculo();
        
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Alta de categoria");
		setBounds(100, 100, 450, 300);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 180, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 25, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblCategorias = new JLabel("Categorias:");
		GridBagConstraints gbc_lblCategorias = new GridBagConstraints();
		gbc_lblCategorias.insets = new Insets(0, 0, 5, 5);
		gbc_lblCategorias.anchor = GridBagConstraints.EAST;
		gbc_lblCategorias.gridx = 1;
		gbc_lblCategorias.gridy = 1;
		getContentPane().add(lblCategorias, gbc_lblCategorias);
		
		comboBoxCategorias = new JComboBox<String>();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 1;
		getContentPane().add(comboBoxCategorias, gbc_comboBox);
		
		JButton btnV = new JButton("Ver categorias");
		btnV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cargarCategorias();
			}
		});
		GridBagConstraints gbc_btnV = new GridBagConstraints();
		gbc_btnV.insets = new Insets(0, 0, 5, 0);
		gbc_btnV.gridx = 3;
		gbc_btnV.gridy = 1;
		getContentPane().add(btnV, gbc_btnV);
		
		JLabel lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 3;
		getContentPane().add(lblNombre, gbc_lblNombre);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 3;
		getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombreCat = textField.getText();
				if(!textField.getText().equals("")) {
					try {
						ctrlEspect.ConfirmarCategoria(nombreCat);
						textField.setText(null);
						JOptionPane.showMessageDialog(null, "Categoria creada con exito");
						dispose();
					}catch(NombreCategoriaExistente ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage(), "Alta de categoria", JOptionPane.INFORMATION_MESSAGE);
					}
				}else {
						JOptionPane.showMessageDialog(null, "Por favor rellene todos los campos de texto.");
				}
				
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 6;
		getContentPane().add(btnNewButton, gbc_btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText(null);
				setVisible(false);
			}
		});
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.anchor = GridBagConstraints.WEST;
		gbc_btnCancelar.gridx = 3;
		gbc_btnCancelar.gridy = 6;
		getContentPane().add(btnCancelar, gbc_btnCancelar);

	}
	
	public void cargarCategorias() {
		comboBoxCategorias.removeAll();
		ArrayList<String> nombres = ctrlEspect.listarCategorias();
		nombres.sort(String::compareToIgnoreCase);
        for(int i = 0; i < nombres.size(); i++) {
        	comboBoxCategorias.addItem(nombres.get(i));
            	
            	}
		
	}

}
