package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import logica.Fabrica;
import logica.IEspectaculo;

import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

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
	private JTextField textElegirArtista;
	private ArrayList<String> artistas;
	private JDateChooser dateChooser;
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
	
		setTitle("Alta Funcion de Espectaculo");
		setIconifiable(true);
		setResizable(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 502, 337);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{15, 49, 68, 54, 40, 39, 50, -47, 0};
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
		comboBoxPlataformas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nombrePlataforma = (String) comboBoxPlataformas.getSelectedItem();
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
		gbc_lblFechaFuncion.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaFuncion.gridx = 1;
		gbc_lblFechaFuncion.gridy = 4;
		getContentPane().add(lblFechaFuncion, gbc_lblFechaFuncion);
		
		dateChooser = new JDateChooser();
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.gridwidth = 3;
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.gridx = 2;
		gbc_dateChooser.gridy = 4;
		getContentPane().add(dateChooser, gbc_dateChooser);
		
		JLabel lblNewLabel_3 = new JLabel("Hora inicio:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 5;
		getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		//SPINNER HORA
		spinnerHora = new JSpinner();
		GridBagConstraints gbc_spinnerHora = new GridBagConstraints();
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
		
		textElegirArtista = new JTextField();
		GridBagConstraints gbc_textElegirArtista = new GridBagConstraints();
		gbc_textElegirArtista.gridwidth = 3;
		gbc_textElegirArtista.insets = new Insets(0, 0, 5, 5);
		gbc_textElegirArtista.fill = GridBagConstraints.HORIZONTAL;
		gbc_textElegirArtista.gridx = 2;
		gbc_textElegirArtista.gridy = 6;
		getContentPane().add(textElegirArtista, gbc_textElegirArtista);
		textElegirArtista.setColumns(10);
		
		JButton btnElegirArtista = new JButton("Elegir");
		btnElegirArtista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombre = textElegirArtista.getText();
				artistas.add(nombre);
				textElegirArtista.setText(null);
			}
		});
		GridBagConstraints gbc_btnElegirArtista = new GridBagConstraints();
		gbc_btnElegirArtista.insets = new Insets(0, 0, 5, 5);
		gbc_btnElegirArtista.gridx = 5;
		gbc_btnElegirArtista.gridy = 6;
		getContentPane().add(btnElegirArtista, gbc_btnElegirArtista);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cmdAltaFuncion();
				ctrlEspect.ConfirmarAltaFuncion();
			}
		});
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.anchor = GridBagConstraints.WEST;
		gbc_btnAceptar.gridwidth = 2;
		gbc_btnAceptar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAceptar.gridx = 2;
		gbc_btnAceptar.gridy = 8;
		getContentPane().add(btnAceptar, gbc_btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiarVentana();
				setVisible(false);
			}
		});
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.gridwidth = 2;
		gbc_btnCancelar.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancelar.gridx = 4;
		gbc_btnCancelar.gridy = 8;
		getContentPane().add(btnCancelar, gbc_btnCancelar);

	}
	
	public void cargarPlataformas() {
		/* VERSION INCO
		 * DefaultComboBoxModel<DataUsuario> model;
        try {
            model = new DefaultComboBoxModel<DataUsuario>(controlUsr.getUsuarios());
            comboBoxUsuarios.setModel(model);
        } catch (UsuarioNoExisteException e) {
            // No se imprime mensaje de error sino que simplemente no se muestra ningún elemento
        }*/

      
            ArrayList<String> nombres = ctrlEspect.listarPlataformas(); 
            for(int i = 0; i < nombres.size(); i++) {
            	comboBoxPlataformas.addItem(nombres.get(i));
            	
            	}
        
		
	}
	
	public void cargarEspectaculos() {
		comboBoxEspectaculos.removeAllItems();
		ArrayList<String> nombres = ctrlEspect.listarEspectaculosPlataforma(nombrePlataforma);
		for(int i = 0; i < nombres.size(); i++) {
        	comboBoxEspectaculos.addItem(nombres.get(i));
        	
        	}
		
	}
	
	protected void cmdAltaFuncion() {
        // TODO Auto-generated method stub

        // Obtengo datos de los controles Swing
        String nombreFuncion = this.textFieldNomFuncion.getText();
        int hora = (int) this.spinnerHora.getValue();
        int minuto = (int) this.spinnerMinuto.getValue();
        LocalTime horaInicio = LocalTime.of(hora, minuto);
         
        Instant instant= dateChooser.getDate().toInstant();
        ZonedDateTime zdt= instant.atZone(ZoneId.systemDefault());
        LocalDate fecha = zdt.toLocalDate();
       
        
        LocalDate fechaHoy = LocalDate.now();
        ctrlEspect.altaFuncion(nombreFuncion, fecha, horaInicio, artistas, fechaHoy);
        
        
        
        

        /*if (checkFormulario()) {
            try {
                controlUsr.registrarUsuario(nombreU, apellidoU, ciU);

                // Muestro éxito de la operación
                JOptionPane.showMessageDialog(this, "El Usuario se ha creado con éxito", "Registrar Usuario",
                        JOptionPane.INFORMATION_MESSAGE);

            } catch (UsuarioRepetidoException e) {
                // Muestro error de registro
                JOptionPane.showMessageDialog(this, e.getMessage(), "Registrar Usuario", JOptionPane.ERROR_MESSAGE);
            }

            // Limpio el internal frame antes de cerrar la ventana
            limpiarFormulario();
            setVisible(false);
        }*/
        
    }
	
	
		
	
	
	private void limpiarVentana() {
		textFieldNomFuncion.setText(null);
		textElegirArtista.setText(null);
		spinnerHora.removeAll();
		spinnerMinuto.removeAll();
		comboBoxPlataformas.removeAll();
		comboBoxEspectaculos.removeAll();
		dateChooser.removeAll();
    }

}
