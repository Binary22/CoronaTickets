package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import logica.Artista;
import logica.Fabrica;
import logica.IEspectaculo;

import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.ParseException;

import javax.swing.JFormattedTextField;

public class AltaFuncionEspectaculo extends JInternalFrame {
	/**
	 * 
	 */


	private JTextField textFieldNomFuncion;
	
	private IEspectaculo ctrlEspect;
	
	private JComboBox<String> comboBoxPlataformas;
	private String nombrePlataforma;
	private JComboBox<String> comboBoxEspectaculos;
	private String nombreEspectaculo;
	private JSpinner spinnerHora;
	private JSpinner spinnerMinuto;
	private JComboBox<String> comboBoxArtistas;
	private ArrayList<String> artistas;
	private JButton btnCancelar;
	private JButton btnAceptar;
	private JFormattedTextField formattedTextField;
	private ArrayList<String> ArtistasElegidos = new ArrayList<String>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaFuncionEspectaculo frame = new AltaFuncionEspectaculo();
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
	public AltaFuncionEspectaculo() {
		Fabrica fabrica = Fabrica.getInstance();
        ctrlEspect = fabrica.getIEspectaculo();
        
        artistas = new ArrayList<String>();
	
		setTitle("Alta Funcion de Espectaculo");
		setIconifiable(true);
		setResizable(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 502, 337);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{15, 96, 88, 54, 87, 83, 50, -47, 0};
		gridBagLayout.rowHeights = new int[]{0, 32, 25, 0, 78, -10, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Plataformas:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		
		//LISTAR PLATAFORMAS
		comboBoxPlataformas = new JComboBox<String>();
		comboBoxPlataformas.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				cargarPlataformas();	
			}
		});
		comboBoxPlataformas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nombrePlataforma = (String) comboBoxPlataformas.getSelectedItem();
				cargarEspectaculos(nombrePlataforma);
			}
		});
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 3;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 1;
		getContentPane().add(comboBoxPlataformas, gbc_comboBox);
		
		JLabel lblEspectaculos = new JLabel("Espectaculos:");
		GridBagConstraints gbc_lblEspectaculos = new GridBagConstraints();
		gbc_lblEspectaculos.insets = new Insets(0, 0, 5, 5);
		gbc_lblEspectaculos.gridx = 1;
		gbc_lblEspectaculos.gridy = 2;
		getContentPane().add(lblEspectaculos, gbc_lblEspectaculos);
		
		//LISTAR ESPECTACULOS DE PLATAFORMA
		comboBoxEspectaculos = new JComboBox<String>();
		comboBoxEspectaculos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nombreEspectaculo = (String) comboBoxEspectaculos.getSelectedItem();
				ctrlEspect.elegirEspectaculo(nombreEspectaculo);
				
			}
		});
		GridBagConstraints gbc_comboBox1 = new GridBagConstraints();
		gbc_comboBox1.gridwidth = 3;
		gbc_comboBox1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox1.gridx = 2;
		gbc_comboBox1.gridy = 2;
		getContentPane().add(comboBoxEspectaculos, gbc_comboBox1);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre funcion:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 3;
		getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textFieldNomFuncion = new JTextField();
		GridBagConstraints gbc_textFieldNomFuncion = new GridBagConstraints();
		gbc_textFieldNomFuncion.gridwidth = 3;
		gbc_textFieldNomFuncion.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNomFuncion.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNomFuncion.gridx = 2;
		gbc_textFieldNomFuncion.gridy = 3;
		getContentPane().add(textFieldNomFuncion, gbc_textFieldNomFuncion);
		textFieldNomFuncion.setColumns(10);
		
		
		
		
		JLabel lblFechaFuncion = new JLabel("Fecha funcion:");
		GridBagConstraints gbc_lblFechaFuncion = new GridBagConstraints();
		gbc_lblFechaFuncion.anchor = GridBagConstraints.EAST;
		gbc_lblFechaFuncion.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaFuncion.gridx = 1;
		gbc_lblFechaFuncion.gridy = 4;
		getContentPane().add(lblFechaFuncion, gbc_lblFechaFuncion);
		
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

		
		formattedTextField = new JFormattedTextField(mask);
		GridBagConstraints gbc_formattedTextField = new GridBagConstraints();
		gbc_formattedTextField.gridwidth = 3;
		gbc_formattedTextField.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextField.gridx = 2;
		gbc_formattedTextField.gridy = 4;
		getContentPane().add(formattedTextField, gbc_formattedTextField);
		
		JLabel lblNewLabel_3 = new JLabel("Hora inicio:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 5;
		getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		//SPINNER HORA
		spinnerHora = new JSpinner();
		GridBagConstraints gbc_spinnerHora = new GridBagConstraints();
		gbc_spinnerHora.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinnerHora.insets = new Insets(0, 0, 5, 5);
		gbc_spinnerHora.gridx = 2;
		gbc_spinnerHora.gridy = 5;
		getContentPane().add(spinnerHora, gbc_spinnerHora);
		
		JLabel lblNewLabel_5 = new JLabel(":");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 3;
		gbc_lblNewLabel_5.gridy = 5;
		getContentPane().add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		//SPINER MINUTO
		spinnerMinuto = new JSpinner();
		GridBagConstraints gbc_spinnerMinuto = new GridBagConstraints();
		gbc_spinnerMinuto.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinnerMinuto.insets = new Insets(0, 0, 5, 5);
		gbc_spinnerMinuto.gridx = 4;
		gbc_spinnerMinuto.gridy = 5;
		getContentPane().add(spinnerMinuto, gbc_spinnerMinuto);
		
		JLabel lblNewLabel_6 = new JLabel("Artistas invitados:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 6;
		getContentPane().add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		comboBoxArtistas = new JComboBox<String>();
		comboBoxArtistas.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent arg0) {
				cargarArtistasSinInvitar(ArtistasElegidos);// Tengo que cargar el box pero sin el artista que fue seleccionado.
			}
		});
		GridBagConstraints gbc_comboBox2 = new GridBagConstraints();
		gbc_comboBox2.gridwidth = 3;
		gbc_comboBox2.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox2.gridx = 2;
		gbc_comboBox2.gridy = 6;
		getContentPane().add(comboBoxArtistas, gbc_comboBox2);
		
		
		
		JButton btnElegirArtista = new JButton("Elegir");
		btnElegirArtista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombre = (String) comboBoxArtistas.getSelectedItem();
				ArtistasElegidos.add(nombre);
				artistas.add(nombre);
				comboBoxArtistas.removeItem(comboBoxArtistas.getSelectedItem());
			}
		});
		GridBagConstraints gbc_btnElegirArtista = new GridBagConstraints();
		gbc_btnElegirArtista.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnElegirArtista.insets = new Insets(0, 0, 5, 5);
		gbc_btnElegirArtista.gridx = 5;
		gbc_btnElegirArtista.gridy = 6;
		getContentPane().add(btnElegirArtista, gbc_btnElegirArtista);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cmdAltaFuncion();
				ctrlEspect.ConfirmarAltaFuncion();
			}
		});
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAceptar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAceptar.gridx = 2;
		gbc_btnAceptar.gridy = 8;
		getContentPane().add(btnAceptar, gbc_btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiarVentana();
				setVisible(false);
			}
		});
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCancelar.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancelar.gridx = 4;
		gbc_btnCancelar.gridy = 8;
		getContentPane().add(btnCancelar, gbc_btnCancelar);

	}
	
	
	public void cargarPlataformas() {
		comboBoxPlataformas.removeAll();
        ArrayList<String> nombres = ctrlEspect.listarPlataformas(); 
            
        for(int i = 0; i < nombres.size(); i++) {
        	comboBoxPlataformas.addItem(nombres.get(i));
            	
            	}
        }
	
	public void cargarArtistas() {
		comboBoxArtistas.removeAll();
        ArrayList<String> nombres = ctrlEspect.listarArtistas(); 
        for(int i = 0; i < nombres.size(); i++) {
        		comboBoxArtistas.addItem(nombres.get(i));
        }
    }

	
	public void cargarArtistasSinInvitar(ArrayList<String> ArtistasElegidos) {
		comboBoxArtistas.removeAll();
        ArrayList<String> nombres = ctrlEspect.listarArtistas(); 
        for(int i = 0; i < nombres.size(); i++) {
        	if (!ArtistasElegidos.contains(nombres.get(i)))
        		comboBoxArtistas.addItem(nombres.get(i));
        }
    }
	
	public void cargarEspectaculos(String nomplat) {
		comboBoxEspectaculos.removeAllItems();
		if (ctrlEspect.listarEspectaculosPlataforma(nomplat) != null) {
			ArrayList<String> nombres = ctrlEspect.listarEspectaculosPlataforma(nomplat);
			for(int i = 0; i < nombres.size(); i++) {
				comboBoxEspectaculos.addItem(nombres.get(i));
        	}
		} else {
			JOptionPane.showMessageDialog(null, "Esta Plataforma no tiene Espectaculos");
		}
	}
	protected void cmdAltaFuncion() {
        // TODO Auto-generated method stub

        // Obtengo datos de los controles Swing
        String nombreFuncion = this.textFieldNomFuncion.getText();
        int hora = (int) this.spinnerHora.getValue();
        int minuto = (int) this.spinnerMinuto.getValue();
        LocalTime horaInicio = LocalTime.of(hora, minuto);
        LocalDate fechaHoy = LocalDate.now();
        
        String fecha = formattedTextField.getText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaFuncion = null;
		try {
			fechaFuncion = LocalDate.parse(fecha, formatter);
		}
		catch(DateTimeParseException e1) {
			JOptionPane.showMessageDialog(null, "Fecha Invalida");
			System.out.print("Fallo el parseo de la fecha");
			return;
		}

        ctrlEspect.altaFuncion(nombreFuncion, fechaFuncion, horaInicio, artistas, fechaHoy); 
    }
	
	private void limpiarVentana() {
		textFieldNomFuncion.setText(null);
		comboBoxArtistas.removeAll();
		//spinnerHora.removeAll();
		//spinnerMinuto.removeAll();
		comboBoxPlataformas.removeAll();
		comboBoxEspectaculos.removeAll();
		formattedTextField.removeAll();
		
    }

}
