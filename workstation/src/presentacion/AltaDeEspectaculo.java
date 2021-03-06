package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import com.toedter.calendar.JCalendar;

import excepciones.NombreEspectaculoExisteException;
import logica.Fabrica;
import logica.IEspectaculo;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.JTextPane;
import javax.swing.SpinnerNumberModel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class AltaDeEspectaculo extends JInternalFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblPlataforma;
    private JComboBox<String> comboBoxPlataformas;
    private JLabel lblArtista;
    private JComboBox<String> comboBoxArtistas;
    private JLabel lblNombre;
    private JTextField textFieldNombre;
    private JLabel lblDescripcion;
    private JLabel lblDuracion;
    private JSpinner spnDuracionhs;
    private JSpinner spnDuracionmin;
    private JLabel lblMaxEsp;
    private JLabel lblMinEsp;
    private JSpinner spnMaxEsp;
    private JSpinner spnMinEsp;
    private JLabel lblURL;
    private JTextField textFieldURL;
    private JLabel lblCosto;
    private JSpinner spnCosto;
    private JLabel lblFecha;
    private JCalendar calFecha;
    private List<String> plataformas;
    private List<String> artistas;
    private JTextArea txtaDescripcion;
    private JScrollPane scrollPane;

    
    

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaDeEspectaculo frame = new AltaDeEspectaculo();
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
	public AltaDeEspectaculo() {
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
		setTitle("Alta de espectaculo");
		setBounds(100, 100, 543, 495);
		Fabrica fab = Fabrica.getInstance();
		IEspectaculo iesp= fab.getIEspectaculo();
		
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{177, 26, 150, 35, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 99, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		lblPlataforma = new JLabel("Plataforma:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		getContentPane().add(lblPlataforma, gbc_lblNewLabel);
		
		
		comboBoxPlataformas = new JComboBox<String>();
		comboBoxPlataformas.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				plataformas= iesp.listarPlataformas();
				updateComboBox(plataformas, comboBoxPlataformas);
			}
		});
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 2;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 0;
		getContentPane().add(comboBoxPlataformas, gbc_comboBox);
		
		
		lblArtista = new JLabel("Artista:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.ABOVE_BASELINE_TRAILING;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		getContentPane().add(lblArtista, gbc_lblNewLabel_1);
		
		
		comboBoxArtistas = new JComboBox<String>();
		comboBoxArtistas.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent evento) {
				artistas= iesp.listarArtistas();
				updateComboBox(artistas, comboBoxArtistas);
			}
		});
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.gridwidth = 2;
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 1;
		gbc_comboBox_1.gridy = 1;
		getContentPane().add(comboBoxArtistas, gbc_comboBox_1);
		
		lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		getContentPane().add(lblNombre, gbc_lblNewLabel_2);
		
		textFieldNombre = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 2;
		getContentPane().add(textFieldNombre, gbc_textField);
		textFieldNombre.setColumns(10);

		
		lblDescripcion = new JLabel("Descripcion:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		getContentPane().add(lblDescripcion, gbc_lblNewLabel_3);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 3;
		getContentPane().add(scrollPane, gbc_scrollPane);
		
		txtaDescripcion = new JTextArea();
		scrollPane.setViewportView(txtaDescripcion);
		
		lblDuracion = new JLabel("Duracion:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		getContentPane().add(lblDuracion, gbc_lblNewLabel_4);
		
		spnDuracionhs = new JSpinner();
		spnDuracionhs.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		GridBagConstraints gbc_spinner_1 = new GridBagConstraints();
		gbc_spinner_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_1.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_1.gridx = 1;
		gbc_spinner_1.gridy = 4;
		getContentPane().add(spnDuracionhs, gbc_spinner_1);
		
		spnDuracionmin = new JSpinner();
		spnDuracionmin.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		GridBagConstraints gbc_spinner_2 = new GridBagConstraints();
		gbc_spinner_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_2.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_2.gridx = 2;
		gbc_spinner_2.gridy = 4;
		getContentPane().add(spnDuracionmin, gbc_spinner_2);
		
		lblMaxEsp = new JLabel("Maximo de espectadores:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 5;
		getContentPane().add(lblMaxEsp, gbc_lblNewLabel_5);
		
		spnMaxEsp = new JSpinner();
		spnMaxEsp.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		GridBagConstraints gbc_spinner3 = new GridBagConstraints();
		gbc_spinner3.fill = GridBagConstraints.BOTH;
		gbc_spinner3.insets = new Insets(0, 0, 5, 5);
		gbc_spinner3.gridx = 1;
		gbc_spinner3.gridy = 5;
		getContentPane().add(spnMaxEsp, gbc_spinner3);
		
		lblMinEsp = new JLabel("Minimo de espectadores:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 6;
		getContentPane().add(lblMinEsp, gbc_lblNewLabel_6);
		
		spnMinEsp = new JSpinner();
		spnMinEsp.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		GridBagConstraints gbc_MinEsp = new GridBagConstraints();
		gbc_MinEsp.fill = GridBagConstraints.BOTH;
		gbc_MinEsp.insets = new Insets(0, 0, 5, 5);
		gbc_MinEsp.gridx = 1;
		gbc_MinEsp.gridy = 6;
		getContentPane().add(spnMinEsp, gbc_MinEsp);
		
		lblURL = new JLabel("URL:");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 7;
		getContentPane().add(lblURL, gbc_lblNewLabel_7);
		
		textFieldURL = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.gridwidth = 2;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 7;
		getContentPane().add(textFieldURL, gbc_textField_2);
		textFieldURL.setColumns(10);
		
		lblCosto = new JLabel("Costo:");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 8;
		getContentPane().add(lblCosto, gbc_lblNewLabel_8);
		
		spnCosto = new JSpinner();
		spnCosto.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
		GridBagConstraints gbc_spinner = new GridBagConstraints();
		gbc_spinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner.gridwidth = 2;
		gbc_spinner.insets = new Insets(0, 0, 5, 5);
		gbc_spinner.gridx = 1;
		gbc_spinner.gridy = 8;
		getContentPane().add(spnCosto, gbc_spinner);
		
		lblFecha = new JLabel("Fecha:");
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.gridx = 0;
		gbc_lblNewLabel_9.gridy = 9;
		getContentPane().add(lblFecha, gbc_lblNewLabel_9);
		
		calFecha = new JCalendar();
		Date datem = new Date();  
		Date dateM = new GregorianCalendar(2030, Calendar.DECEMBER, 31).getTime();
		calFecha.setMinSelectableDate(datem);
		calFecha.setMaxSelectableDate(dateM);
		calFecha.getDayChooser().getDayPanel().setBackground(Color.WHITE);
		calFecha.getDayChooser().getDayPanel().setForeground(Color.WHITE);
		GridBagConstraints gbc_calendar = new GridBagConstraints();
		gbc_calendar.gridwidth = 2;
		gbc_calendar.insets = new Insets(0, 0, 5, 5);
		gbc_calendar.fill = GridBagConstraints.BOTH;
		gbc_calendar.gridx = 1;
		gbc_calendar.gridy = 9;
		getContentPane().add(calFecha, gbc_calendar);
		
		JButton btnNewButton_1 = new JButton("Aceptar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				String plataforma= (String) comboBoxPlataformas.getSelectedItem();
				String artista= (String) comboBoxArtistas.getSelectedItem();
				String nombre= textFieldNombre.getText();
				String descripcion= txtaDescripcion.getText();
				String URL = textFieldURL.getText();
				int hora= (int) spnDuracionhs.getValue();
				int min= (int) spnDuracionmin.getValue();
				LocalTime Duracion= LocalTime.of(hora, min);
				int maxEsp= (int) spnMaxEsp.getValue();
				int minEsp= (int) spnMinEsp.getValue();
				float costo= (float) spnCosto.getValue();
				Instant instant= calFecha.getDate().toInstant();
				ZonedDateTime zdt= instant.atZone(ZoneId.systemDefault());
				LocalDate altaFecha= zdt.toLocalDate(); //esto es un asco pero se hace asi, salvo que cambiemos a date.
				if (maxEsp < minEsp) {
					spnMaxEsp.setValue(0);
					spnMinEsp.setValue(0);
					JOptionPane.showMessageDialog(null, "El maximo de espectadores debe ser menor al minimo.");
				}
				else if (maxEsp==0) {
					JOptionPane.showMessageDialog(null, "El maximo de espectadores debe ser mayor a 0");
				}
				else if ((hora == 0) && (min < 10)) {
					spnDuracionhs.setValue(0);
					spnDuracionmin.setValue(0);
					JOptionPane.showMessageDialog(null, "La duracion no puede ser menor a 10 minutos.");
				}
				else if (textFieldNombre.getText().equals("") || textFieldURL.getText().equals("")|| txtaDescripcion.getText().equals("") || textFieldURL.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Por favor rellene todos los campos de texto.");
				}
				else {
					try {	
					iesp.altaEspectaculo(plataforma, artista, nombre, descripcion, Duracion, minEsp, maxEsp, URL, costo, altaFecha);
					iesp.confirmarAltaEspectaculo();
					JOptionPane.showMessageDialog(null, "Espectaculo creado con exito!");
					}catch(NombreEspectaculoExisteException ex) {
						 JOptionPane.showMessageDialog(null, ex.getMessage(), "Registrar espectaculo", JOptionPane.ERROR_MESSAGE);
					}
					
				}
				
			}
		});
		btnNewButton_1.setForeground(Color.BLUE);
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 10;
		getContentPane().add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.setForeground(Color.RED);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				//limpiarFormulario(); creo que esto no es necesario, ademas me genera problemas
				dispose();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 10;
		getContentPane().add(btnNewButton, gbc_btnNewButton);

	}
	private void updateComboBox(List<String> lista, JComboBox<String> cbvar) {
		cbvar.removeAllItems();
		lista.sort(String::compareToIgnoreCase);
	    lista.forEach(el -> cbvar.addItem(el));
	}
}



/*private void limpiarFormulario() {
	comboBoxPlataformas.removeAllItems();
	comboBoxArtistas.removeAllItems();
	textFieldNombre.setText("");
	textFieldDescripcion.setText("");
	spnDuracionhs.setValue(0);
    spnDuracionmin.setValue(0);
    spnMaxEsp.setValue(0);
    spnMinEsp.setValue(0);
    textFieldURL.setText("");
    spnCosto.setValue(0);
    calFecha.setDate(null);
	}
}*/
	

