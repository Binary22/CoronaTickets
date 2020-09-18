package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import datatypes.DtArtista;
import datatypes.DtFuncion;
import datatypes.DtUsuario;
import logica.Fabrica;
import logica.IConsulta;

import javax.swing.JScrollPane;

public class ConsultaUsuarioFix extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNickname;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtMail;
	private JTextField textWebsite;
	private JTextField textFechaNac;
	private JTextPane textpDescripcion;
	private JTextPane textpBibliografia;
	private JComboBox<String> comboFuncionesReg;
	private JButton btnConsultarFun;
	private JButton btnConsultarEspectaculo;
	HashMap<String, DtFuncion> funciones;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaUsuarioFix frame = new ConsultaUsuarioFix();
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
	public ConsultaUsuarioFix() {
		setClosable(true);
		setResizable(true);
		setMaximizable(true);
		setIconifiable(true);
		setTitle("Consulta de usuario");
		setBounds(100, 100, 747, 627);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{117, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{33, 24, 32, 33, 33, 33, 0, 0, 0, 38, 30, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		Fabrica fabrica = Fabrica.getInstance();
		IConsulta icontrolador = fabrica.getIConsulta();
		funciones = new HashMap<String, DtFuncion>();
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		JComboBox<String> comboUsuario = new JComboBox<String>();
		comboUsuario.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				// esto es para que se actualize el combobox cuando se agregan usuarios, capaz es al pedo
				comboUsuario.removeAllItems();
				ArrayList<String > listanicknames = icontrolador.listarUsuarios();
				listanicknames.sort(String::compareToIgnoreCase);
				for (int i = 0; i < listanicknames.size(); i++) {
					comboUsuario.addItem(listanicknames.get(i));
				}
			}
		});
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 0;
		getContentPane().add(comboUsuario, gbc_comboBox);
		
		JCheckBox checkArtista = new JCheckBox("Artista");
		checkArtista.setEnabled(false);
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox.gridx = 0;
		gbc_chckbxNewCheckBox.gridy = 1;
		getContentPane().add(checkArtista, gbc_chckbxNewCheckBox);
		
		JButton btnConsultarUsuario = new JButton("Consultar Usuario");
		btnConsultarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// se apreta consultar:
				btnConsultarFun.setEnabled(false);
				btnConsultarEspectaculo.setEnabled(false);
				DtUsuario dtu = icontrolador.mostrarDatos((String)comboUsuario.getSelectedItem());
				txtNickname.setText(dtu.getNickname());
				txtNombre.setText(dtu.getNombre());
				txtApellido.setText(dtu.getApellido());
				txtMail.setText(dtu.getEmail());
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				textFechaNac.setText(dtu.getFechaNacimiento().format(formatter));
				if (icontrolador.esArtista(dtu.getNickname())) {
					checkArtista.setSelected(true);
					DtArtista dta = icontrolador.mostrarDatosArtista(dtu.getNickname());
					textpDescripcion.setText(dta.getDescripcion());
					textpBibliografia.setText(dta.getBiografia());
					textWebsite.setText(dta.getWebsite());
				} else {
					checkArtista.setSelected(true);
					textpDescripcion.setText("");
					textpBibliografia.setText("");
					textWebsite.setText("");
				}
				
				ArrayList<DtFuncion> listafun = icontrolador.listarFuncionesDtQueSeRegistro(dtu.getNickname());
				if (listafun != null) {
					comboFuncionesReg.removeAllItems();
					for (int i = 0; i < listafun.size(); i++) {
						funciones.put(listafun.get(i).getNombre(), listafun.get(i));
						ArrayList<String> funKeys = new ArrayList<String>(funciones.keySet());
						funKeys.sort(String::compareToIgnoreCase);
						comboFuncionesReg.addItem(funKeys.get(i));
					if (comboFuncionesReg.getItemCount() != 0) {
						btnConsultarFun.setEnabled(true);
						btnConsultarEspectaculo.setEnabled(true);
					}
					else {
						btnConsultarFun.setEnabled(false);
						btnConsultarEspectaculo.setEnabled(false);
					}
					}
				}
				
			}
		});
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 1;
		gbc_btnNewButton_3.gridy = 1;
		getContentPane().add(btnConsultarUsuario, gbc_btnNewButton_3);
		
		JLabel lblNewLabel_1 = new JLabel("Nickname:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		txtNickname = new JTextField();
		txtNickname.setEditable(false);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 2;
		getContentPane().add(txtNickname, gbc_textField);
		txtNickname.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 3;
		getContentPane().add(txtNombre, gbc_textField_1);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Apellido:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 4;
		getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		txtApellido = new JTextField();
		txtApellido.setEditable(false);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 4;
		getContentPane().add(txtApellido, gbc_textField_2);
		txtApellido.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("E-mail:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 5;
		getContentPane().add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		txtMail = new JTextField();
		txtMail.setEditable(false);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 5;
		getContentPane().add(txtMail, gbc_textField_3);
		txtMail.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Fecha de nacimiento:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 6;
		getContentPane().add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		textFechaNac = new JTextField();
		textFechaNac.setEditable(false);
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 6;
		getContentPane().add(textFechaNac, gbc_textField_4);
		textFechaNac.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Descripcion:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 7;
		getContentPane().add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 7;
		getContentPane().add(scrollPane, gbc_scrollPane);
		
		textpDescripcion = new JTextPane();
		textpDescripcion.setEditable(false);
		scrollPane.setViewportView(textpDescripcion);
		
		JLabel lblNewLabel_7 = new JLabel("Bibliografia:");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 8;
		getContentPane().add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_1.gridx = 1;
		gbc_scrollPane_1.gridy = 8;
		getContentPane().add(scrollPane_1, gbc_scrollPane_1);
		
		textpBibliografia = new JTextPane();
		textpBibliografia.setEditable(false);
		scrollPane_1.setViewportView(textpBibliografia);
		
		JLabel lblNewLabel_8 = new JLabel("Website:");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 9;
		getContentPane().add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		textWebsite = new JTextField();
		textWebsite.setEditable(false);
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.insets = new Insets(0, 0, 5, 5);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 1;
		gbc_textField_5.gridy = 9;
		getContentPane().add(textWebsite, gbc_textField_5);
		textWebsite.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Funciones a las que se registro:");
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_10.gridx = 1;
		gbc_lblNewLabel_10.gridy = 10;
		getContentPane().add(lblNewLabel_10, gbc_lblNewLabel_10);
		
		comboFuncionesReg = new JComboBox<String>();
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 1;
		gbc_comboBox_1.gridy = 11;
		getContentPane().add(comboFuncionesReg, gbc_comboBox_1);
		
		btnConsultarFun = new JButton("Consultar Funcion");
		btnConsultarFun.setEnabled(false);
		btnConsultarFun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				// aca se deberia llamar al caso de uso anidado consulta de funcion
				String sel = (String) comboFuncionesReg.getSelectedItem();
				icontrolador.elegirFuncion(funciones.get(sel).getEspectaculo(), sel);
				ConsultaFuncionEspectaculoAnidado cdea = new ConsultaFuncionEspectaculoAnidado(icontrolador);
				getParent().add(cdea);
				cdea.setVisible(true);
				cdea.setClosable(true);
				// para que se vaya la ventana de consultar funcion (no anidado)
				setVisible(false);
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 12;
		getContentPane().add(btnConsultarFun, gbc_btnNewButton);
		
		btnConsultarEspectaculo = new JButton("Consultar Espectaculo");
		btnConsultarEspectaculo.setEnabled(false);
		btnConsultarEspectaculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// aca se deberia llamar al caso de uso anidado consulta de espectaculo
				String sel = (String)comboFuncionesReg.getSelectedItem();
				icontrolador.elegirEspectaculo(funciones.get(sel).getEspectaculo());
				ConsultaEspectaculoAnidado cea = new ConsultaEspectaculoAnidado(icontrolador);
				getParent().add(cea);
				cea.setVisible(true);
				cea.setClosable(true);
				setVisible(false);
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 13;
		getContentPane().add(btnConsultarEspectaculo, gbc_btnNewButton_1);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 1;
		gbc_btnNewButton_2.gridy = 14;
		getContentPane().add(btnCancelar, gbc_btnNewButton_2);

	}

}
