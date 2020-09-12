package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import logica.Fabrica;
import logica.HandlerUsuarios;
import logica.IUsuario;
import logica.UsuarioController;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Insets;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JCheckBox;

public class AltaUsuario extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JFormattedTextField textField_4;
	private JLabel lblNewLabel;
	private JTextField textField_5;
	private JLabel lblDescripcion;
	private JTextField textField_6;
	private JLabel lblWebsite;
	private JTextField textField_7;
	private JCheckBox checkEsArtista;
	private JButton btnNewButton;
	private JButton btnCancelar;
	private ArrayList<JTextField> textfieldSet;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaUsuario frame = new AltaUsuario();
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
	public AltaUsuario() {
		setBounds(100, 100, 450, 300);
		setClosable(true);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 162, 186, 28, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 35, 32, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 4.9E-324, 0.0, 0.0, 0.0};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNickname = new JLabel("Nickname*");
		GridBagConstraints gbc_lblNickname = new GridBagConstraints();
		gbc_lblNickname.anchor = GridBagConstraints.EAST;
		gbc_lblNickname.insets = new Insets(0, 0, 5, 5);
		gbc_lblNickname.gridx = 1;
		gbc_lblNickname.gridy = 0;
		getContentPane().add(lblNickname, gbc_lblNickname);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 0;
		getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre*");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 1;
		getContentPane().add(lblNombre, gbc_lblNombre);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 1;
		getContentPane().add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido*");
		GridBagConstraints gbc_lblApellido = new GridBagConstraints();
		gbc_lblApellido.anchor = GridBagConstraints.EAST;
		gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido.gridx = 1;
		gbc_lblApellido.gridy = 2;
		getContentPane().add(lblApellido, gbc_lblApellido);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 2;
		gbc_textField_2.gridy = 2;
		getContentPane().add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JLabel lblMail = new JLabel("Mail*");
		GridBagConstraints gbc_lblMail = new GridBagConstraints();
		gbc_lblMail.insets = new Insets(0, 0, 5, 5);
		gbc_lblMail.gridx = 1;
		gbc_lblMail.gridy = 3;
		getContentPane().add(lblMail, gbc_lblMail);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 2;
		gbc_textField_3.gridy = 3;
		getContentPane().add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento*");
		GridBagConstraints gbc_lblFechaDeNacimiento = new GridBagConstraints();
		gbc_lblFechaDeNacimiento.anchor = GridBagConstraints.EAST;
		gbc_lblFechaDeNacimiento.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaDeNacimiento.gridx = 1;
		gbc_lblFechaDeNacimiento.gridy = 4;
		getContentPane().add(lblFechaDeNacimiento, gbc_lblFechaDeNacimiento);
		
		MaskFormatter mask = null;
        try {
            // Create a MaskFormatter for accepting phone number, the # symbol accept
            // only a number. We can also set the empty value with a place holder
            // character.
            mask = new MaskFormatter("##/##/####");
            mask.setPlaceholderCharacter('_');
        } catch (ParseException e) {
            e.printStackTrace();
        }
		textField_4 = new JFormattedTextField(mask);
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 2;
		gbc_textField_4.gridy = 4;
		getContentPane().add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		checkEsArtista = new JCheckBox("Es Artista");
		GridBagConstraints gbc_rdbtnEsArtista = new GridBagConstraints();
		gbc_rdbtnEsArtista.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnEsArtista.gridx = 1;
		gbc_rdbtnEsArtista.gridy = 5;
		getContentPane().add(checkEsArtista, gbc_rdbtnEsArtista);
		
		lblDescripcion = new JLabel("Descripcion");
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.anchor = GridBagConstraints.EAST;
		gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcion.gridx = 1;
		gbc_lblDescripcion.gridy = 6;
		getContentPane().add(lblDescripcion, gbc_lblDescripcion);
		
		textField_6 = new JTextField();
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.insets = new Insets(0, 0, 5, 5);
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.gridx = 2;
		gbc_textField_6.gridy = 6;
		getContentPane().add(textField_6, gbc_textField_6);
		textField_6.setColumns(10);
		
		lblNewLabel = new JLabel("bio");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 7;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		textField_5 = new JTextField();
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.insets = new Insets(0, 0, 5, 5);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 2;
		gbc_textField_5.gridy = 7;
		getContentPane().add(textField_5, gbc_textField_5);
		textField_5.setColumns(10);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 9;
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 2;
		gbc_textField_5.gridy = 9;
		textField_5.setColumns(10);
		
		lblWebsite = new JLabel("website");
		GridBagConstraints gbc_lblWebsite = new GridBagConstraints();
		gbc_lblWebsite.anchor = GridBagConstraints.EAST;
		gbc_lblWebsite.insets = new Insets(0, 0, 5, 5);
		gbc_lblWebsite.gridx = 1;
		gbc_lblWebsite.gridy = 8;
		getContentPane().add(lblWebsite, gbc_lblWebsite);
		
		textField_7 = new JTextField();
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.insets = new Insets(0, 0, 5, 5);
		gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_7.gridx = 2;
		gbc_textField_7.gridy = 8;
		getContentPane().add(textField_7, gbc_textField_7);
		textField_7.setColumns(10);
		
		
		textfieldSet = new ArrayList<JTextField>();
		this.textfieldSet.add(textField);
		this.textfieldSet.add(textField_1);
		this.textfieldSet.add(textField_2);
		this.textfieldSet.add(textField_3);
		this.textfieldSet.add(textField_4);
		this.textfieldSet.add(textField_5);
		this.textfieldSet.add(textField_6);
		this.textfieldSet.add(textField_7);
		
		btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!checkEsArtista.isSelected()) {
					for(int i = 1; i < 5; i++) {
						if (textfieldSet.get(i).getText().trim().length() == 0) {
							JOptionPane.showMessageDialog(null, "Para dar de alta un usuario debe rellenar todos los campos indicados con *");
							return;
						}
					}
				} else {
					for(int i = 1; i < 8; i++) {
						if (textfieldSet.get(i).getText().trim().length() == 0) {
							JOptionPane.showMessageDialog(null, "Para dar de alta un artista debe rellenar todos los campos.");
							return;
						}
					}
				}
				String nickname = textField.getText();
				String nombre = textField_1.getText();
				String apellido = textField_2.getText();
				String mail = textField_3.getText();
				String fecha = textField_4.getText();

				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate fechanac = null;
				try {
					fechanac = LocalDate.parse(fecha, formatter);
				}
				catch(DateTimeParseException e1) {
					JOptionPane.showMessageDialog(null, "Fecha Invalida");
					System.out.print("Fallo el parseo de la fecha");
					return;
				}
				
				Fabrica f = Fabrica.getInstance();
				IUsuario UC = f.getIUsuario();
				
				System.out.print("nickname: " + nickname + "\n");
				System.out.print("nombre: " + nombre + "\n");
				System.out.print("apellido: " + apellido + "\n");
				System.out.print("mail: " + mail + "\n");
				System.out.print("fecha: " + fechanac.toString() + "\n");
				Boolean esArtista = checkEsArtista.isSelected();
				
				//Checkeo si existe el usuario:
				
				HandlerUsuarios hu = HandlerUsuarios.getInstancia();
				if (hu.existeUsuario(nickname)) {
					JOptionPane.showMessageDialog(null, "Ya existe un usuario con ese Nickname");
				} else {
					if (!esArtista) {
						UC.altaUsuario(nickname, nombre, apellido, mail, fechanac);
					} else {
						String descripcion = textField_5.getText();
						String bio = textField_6.getText();
						String website = textField_7.getText();
						UC.altaUsuario(nickname, nombre, apellido, mail, fechanac);
						UC.altaArtista(descripcion, bio, website);
					}
					int input = JOptionPane.showConfirmDialog(null, "Desea confirmar el usuario?");
					if (input == 0) {
						UC.confirmarAltaUsuario();
						textfieldSet.forEach(textfield -> textfield.setText(""));
						dispose();
					}
					if (input == 2) {
						textfieldSet.forEach(textfield -> textfield.setText(""));
						dispose();
					}
				}
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 9;
		getContentPane().add(btnNewButton, gbc_btnNewButton);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelar.gridx = 2;
		gbc_btnCancelar.gridy = 9;
		getContentPane().add(btnCancelar, gbc_btnCancelar);
	}

}
