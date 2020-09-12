package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import javax.swing.JTree;

import datatypes.DtArtista;
import datatypes.DtFuncion;
import datatypes.DtUsuario;
import logica.Fabrica;
import logica.IConsulta;

import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JTable;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class ConsultaUsuario extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaUsuario frame = new ConsultaUsuario();
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
	public ConsultaUsuario() {
		Fabrica fabrica = Fabrica.getInstance();
		IConsulta icontrolador = fabrica.getIConsulta();
		
		setTitle("Consulta de usuario");
		setClosable(true);
		setBounds(100, 100, 450, 422);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 206, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.anchor = GridBagConstraints.WEST;
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 0;
		gbc_lblUsuario.gridy = 0;
		getContentPane().add(lblUsuario, gbc_lblUsuario);
		
		// aca trato de conseguir la lista para mostarla en el combobox
		//ArrayList<String > listanicknames = icontrolador.listarUsuarios();
		//String[] arraynicknames = new String[listanicknames.size()];
		//arraynicknames = listanicknames.toArray(arraynicknames);
		
		//String[] test = {"juan", "jose"};
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		comboBox.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				// esto es para que se actualize el combobox cuando se agregan usuarios, capaz es al pedo
				comboBox.removeAllItems();
				ArrayList<String > listanicknames = icontrolador.listarUsuarios();
				for (int i = 0; i < listanicknames.size(); i++) {
					comboBox.addItem(listanicknames.get(i));
				}
			}
		});
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 0;
		getContentPane().add(comboBox, gbc_comboBox);
		
		JLabel lblNickname = new JLabel("Nickname:");
		GridBagConstraints gbc_lblNickname = new GridBagConstraints();
		gbc_lblNickname.insets = new Insets(0, 0, 5, 0);
		gbc_lblNickname.anchor = GridBagConstraints.WEST;
		gbc_lblNickname.gridx = 1;
		gbc_lblNickname.gridy = 3;
		getContentPane().add(lblNickname, gbc_lblNickname);
		
		JLabel lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 0);
		gbc_lblNombre.anchor = GridBagConstraints.WEST;
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 4;
		getContentPane().add(lblNombre, gbc_lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		GridBagConstraints gbc_lblApellido = new GridBagConstraints();
		gbc_lblApellido.insets = new Insets(0, 0, 5, 0);
		gbc_lblApellido.anchor = GridBagConstraints.WEST;
		gbc_lblApellido.gridx = 1;
		gbc_lblApellido.gridy = 5;
		getContentPane().add(lblApellido, gbc_lblApellido);
		
		JLabel lblEmail = new JLabel("Email:");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.insets = new Insets(0, 0, 5, 0);
		gbc_lblEmail.anchor = GridBagConstraints.WEST;
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 6;
		getContentPane().add(lblEmail, gbc_lblEmail);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
		GridBagConstraints gbc_lblFechaDeNacimiento = new GridBagConstraints();
		gbc_lblFechaDeNacimiento.insets = new Insets(0, 0, 5, 0);
		gbc_lblFechaDeNacimiento.anchor = GridBagConstraints.WEST;
		gbc_lblFechaDeNacimiento.gridx = 1;
		gbc_lblFechaDeNacimiento.gridy = 7;
		getContentPane().add(lblFechaDeNacimiento, gbc_lblFechaDeNacimiento);
		
		JLabel lblDescripcion = new JLabel("");
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.insets = new Insets(0, 0, 5, 0);
		gbc_lblDescripcion.anchor = GridBagConstraints.WEST;
		gbc_lblDescripcion.gridx = 1;
		gbc_lblDescripcion.gridy = 8;
		getContentPane().add(lblDescripcion, gbc_lblDescripcion);
		
		JLabel lblBiografa = new JLabel("");
		GridBagConstraints gbc_lblBiografa = new GridBagConstraints();
		gbc_lblBiografa.insets = new Insets(0, 0, 5, 0);
		gbc_lblBiografa.anchor = GridBagConstraints.WEST;
		gbc_lblBiografa.gridx = 1;
		gbc_lblBiografa.gridy = 9;
		getContentPane().add(lblBiografa, gbc_lblBiografa);
		
		JLabel lblWebsite = new JLabel("");
		GridBagConstraints gbc_lblWebsite = new GridBagConstraints();
		gbc_lblWebsite.insets = new Insets(0, 0, 5, 0);
		gbc_lblWebsite.anchor = GridBagConstraints.WEST;
		gbc_lblWebsite.gridx = 1;
		gbc_lblWebsite.gridy = 10;
		getContentPane().add(lblWebsite, gbc_lblWebsite);
		
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// se apreta consultar:
				DtUsuario dtu = icontrolador.mostrarDatos((String)comboBox.getSelectedItem());
				lblNickname.setText("Nickname: " + dtu.getNickname());
				lblNombre.setText("Nombre: " + dtu.getNombre());
				lblApellido.setText("Apellido: " + dtu.getApellido());
				lblEmail.setText("Email: " + dtu.getEmail());
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
				lblFechaDeNacimiento.setText("Fecha de nacimiento: " + dtu.getFechaNacimiento().format(formatter));
					
				if (icontrolador.esArtista(dtu.getNickname())) {
					DtArtista dta = icontrolador.mostrarDatosArtista(dtu.getNickname());
					lblDescripcion.setText("Descripcion: " + dta.getDescripcion());
					lblBiografa.setText("Biografía: " + dta.getBiografia());
					lblWebsite.setText("Website: " + dta.getWebsite());
				} else {
					lblDescripcion.setText("");
					lblBiografa.setText("");
					lblWebsite.setText("");
				}
				
			}
		});
		GridBagConstraints gbc_btnConsultar = new GridBagConstraints();
		gbc_btnConsultar.insets = new Insets(0, 0, 5, 0);
		gbc_btnConsultar.gridx = 1;
		gbc_btnConsultar.gridy = 1;
		getContentPane().add(btnConsultar, gbc_btnConsultar);
		
		JLabel lblFuncionesALas = new JLabel("Funciones a las que se registro:");
		GridBagConstraints gbc_lblFuncionesALas = new GridBagConstraints();
		gbc_lblFuncionesALas.insets = new Insets(0, 0, 5, 0);
		gbc_lblFuncionesALas.gridx = 1;
		gbc_lblFuncionesALas.gridy = 11;
		getContentPane().add(lblFuncionesALas, gbc_lblFuncionesALas);
		
		JComboBox comboBox_1 = new JComboBox();
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 1;
		gbc_comboBox_1.gridy = 12;
		getContentPane().add(comboBox_1, gbc_comboBox_1);
		
		
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.gridx = 1;
		gbc_btnCancelar.gridy = 13;
		getContentPane().add(btnCancelar, gbc_btnCancelar);
		



	}

}
