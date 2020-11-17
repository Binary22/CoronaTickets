package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.MaskFormatter;

import datatypes.DtArtista;
import datatypes.DtUsuario;
import logica.Fabrica;
import logica.IConsulta;
import logica.IUsuario;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class modificarDatosUsuario extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextPane textField_5;
	private JTextPane textField_6;
	private JTextField textField_7;
	private List<String> usuarios;
	private JComboBox<String> comboBox;
	protected DtUsuario dtu;
	private List<JTextField> textfields;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					modificarDatosUsuario frame = new modificarDatosUsuario();
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
	public modificarDatosUsuario() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 534, 441);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 267, 65, 243, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 24, 0, 0, 22, 0, 0, 76, 43, 27, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);

		Fabrica fabrica = Fabrica.getInstance();
		IConsulta icontrolador = fabrica.getIConsulta();
		usuarios = icontrolador.listarUsuarios();
		
		JLabel lblUsuarios = new JLabel("Usuarios:");
		GridBagConstraints gbc_lblUsuarios = new GridBagConstraints();
		gbc_lblUsuarios.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuarios.anchor = GridBagConstraints.EAST;
		gbc_lblUsuarios.gridx = 1;
		gbc_lblUsuarios.gridy = 1;
		getContentPane().add(lblUsuarios, gbc_lblUsuarios);

		
		
		comboBox = new JComboBox<String>();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 2;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 1;
		getContentPane().add(comboBox, gbc_comboBox);

		ConsultaEspectaculo.updateComboBox(usuarios, comboBox);
		
		JButton btnVerDatos = new JButton("Ver datos");
		btnVerDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				String nick = (String)comboBox.getSelectedItem();
				dtu = icontrolador.mostrarDatos(nick);
				updateData();
			}
		});
		GridBagConstraints gbc_btnVerDatos = new GridBagConstraints();
		gbc_btnVerDatos.insets = new Insets(0, 0, 5, 5);
		gbc_btnVerDatos.gridx = 4;
		gbc_btnVerDatos.gridy = 1;
		getContentPane().add(btnVerDatos, gbc_btnVerDatos);
		
		JLabel lblNombre = new JLabel("Nickname:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 2;
		getContentPane().add(lblNombre, gbc_lblNombre);
		
		textField = new JTextField();
		textField.setEditable(false);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 2;
		getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblNombre_1 = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre_1 = new GridBagConstraints();
		gbc_lblNombre_1.anchor = GridBagConstraints.EAST;
		gbc_lblNombre_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre_1.gridx = 1;
		gbc_lblNombre_1.gridy = 3;
		getContentPane().add(lblNombre_1, gbc_lblNombre_1);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 2;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.BOTH;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 3;
		getContentPane().add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido:");
		GridBagConstraints gbc_lblApellido = new GridBagConstraints();
		gbc_lblApellido.anchor = GridBagConstraints.EAST;
		gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido.gridx = 1;
		gbc_lblApellido.gridy = 4;
		getContentPane().add(lblApellido, gbc_lblApellido);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.gridwidth = 2;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.BOTH;
		gbc_textField_2.gridx = 2;
		gbc_textField_2.gridy = 4;
		getContentPane().add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("e-mail:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 5;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.gridwidth = 2;
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.BOTH;
		gbc_textField_3.gridx = 2;
		gbc_textField_3.gridy = 5;
		getContentPane().add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha nacimiento:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 6;
		getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		MaskFormatter mask = null;
        try {
            mask = new MaskFormatter("##/##/####");
            mask.setPlaceholderCharacter('_');
        } catch (ParseException e) {
            e.printStackTrace();
        }
		textField_4 = new JFormattedTextField(mask);
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.gridwidth = 2;
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.BOTH;
		gbc_textField_4.gridx = 2;
		gbc_textField_4.gridy = 6;
		getContentPane().add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.anchor = GridBagConstraints.EAST;
		gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcion.gridx = 1;
		gbc_lblDescripcion.gridy = 8;
		getContentPane().add(lblDescripcion, gbc_lblDescripcion);
		
		textField_5 = new JTextPane();
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.insets = new Insets(0, 0, 5, 5);
		gbc_textField_5.gridwidth = 3;
		gbc_textField_5.fill = GridBagConstraints.BOTH;
		gbc_textField_5.gridx = 2;
		gbc_textField_5.gridy = 8;
		getContentPane().add(textField_5, gbc_textField_5);
		
		JLabel lblNewLabel_2 = new JLabel("Biografia:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 9;
		getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textField_6 = new JTextPane();
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.insets = new Insets(0, 0, 5, 5);
		gbc_textField_6.gridwidth = 3;
		gbc_textField_6.fill = GridBagConstraints.BOTH;
		gbc_textField_6.gridx = 2;
		gbc_textField_6.gridy = 9;
		getContentPane().add(textField_6, gbc_textField_6);
		
		JLabel lblWebsite = new JLabel("Website:");
		GridBagConstraints gbc_lblWebsite = new GridBagConstraints();
		gbc_lblWebsite.anchor = GridBagConstraints.EAST;
		gbc_lblWebsite.insets = new Insets(0, 0, 5, 5);
		gbc_lblWebsite.gridx = 1;
		gbc_lblWebsite.gridy = 10;
		getContentPane().add(lblWebsite, gbc_lblWebsite);
		
		textField_7 = new JTextField();
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.insets = new Insets(0, 0, 5, 5);
		gbc_textField_7.gridwidth = 3;
		gbc_textField_7.fill = GridBagConstraints.BOTH;
		gbc_textField_7.gridx = 2;
		gbc_textField_7.gridy = 10;
		getContentPane().add(textField_7, gbc_textField_7);
		textField_7.setColumns(10);

		IUsuario iUser = fabrica.getIUsuario();
		
		JButton btnAceptar = new JButton("Aceptar");

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nick = textField.getText();
				String nombre = textField_1.getText();
				String apellido = textField_2.getText();
				String mail = textField_3.getText();
				LocalDate fechanac = LocalDate.parse(textField_4.getText(),formatter);
				iUser.updateUsuario(nick, nombre, apellido,mail, fechanac);
				if (icontrolador.esArtista(nick)) {
					String desc = textField_5.getText();
					String bio = textField_6.getText();
					String web = textField_7.getText();
					iUser.updateArtista(desc, bio, web);
				}
				int input = JOptionPane.showConfirmDialog(null, "Desea actualizar el usuario?");
					if (input == 0) {
						iUser.confirmarUpdateUsuario();
						clearData();
						dispose();
					}
					if (input == 2) {
						clearData();
						dispose();
					}
			}
		});
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAceptar.gridx = 1;
		gbc_btnAceptar.gridy = 12;
		getContentPane().add(btnAceptar, gbc_btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				clearData();
				dispose();
			}
		});
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancelar.gridx = 4;
		gbc_btnCancelar.gridy = 12;
		getContentPane().add(btnCancelar, gbc_btnCancelar);

		textfields = new ArrayList<JTextField>();
		textfields.add(textField);
		textfields.add(textField_1);
		textfields.add(textField_2);
		textfields.add(textField_3);
		textfields.add(textField_4);
		textfields.add(textField_7);

		textfields.forEach((t) -> t.setEnabled(false));
		textField_5.setEnabled(false);
		textField_6.setEnabled(false);

	}

	protected void updateData() {
		clearData();
		textfields.forEach((t) -> t.setEnabled(true));
		Fabrica fab = Fabrica.getInstance();
		IConsulta icontrolador = fab.getIConsulta();
		textField.setText(dtu.getNickname());
		textField_1.setText(dtu.getNombre());
		textField_2.setText(dtu.getApellido());
		textField_3.setText(dtu.getEmail());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String str = dtu.getFechaNacimiento().format(formatter);
		textField_4.setText(str);
		textField_5.setEnabled(false);
		textField_6.setEnabled(false);
		textField_7.setEnabled(false);
		if (icontrolador.esArtista(dtu.getNickname()))
		{
			DtArtista dta = icontrolador.mostrarDatosArtista(dtu.getNickname());
			textField_5.setEnabled(true);
			textField_5.setText(dta.getDescripcion());
			textField_6.setEnabled(true);
			textField_6.setText(dta.getBiografia());
			textField_7.setEnabled(true);
			textField_7.setText(dta.getWebsite());
		}
	}

	protected void clearData() {
		for (JTextField t : textfields) {
			t.setText("");
		}
		textField_5.setText("");
		textField_6.setText("");
	}

}
