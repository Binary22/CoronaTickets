package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import com.toedter.calendar.JCalendar;

import datatypes.DtFuncion;
import datatypes.DtRegistro;
import datatypes.DtUsuario;
import excepciones.fechaPosterior;
import excepciones.noSeleccionoTres;
import excepciones.usuarioNoExiste;
import excepciones.usuarioNoTieneRegsPrevios;
import logica.Fabrica;
import logica.IEspectaculo;
import logica.Usuario;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.swing.JRadioButton;
import javax.swing.JFormattedTextField;

public class RegistroAFuncionDeEspectaculo extends JInternalFrame {
	private JTextField textFieldFechaFun;
	private JTextField textFieldHoraFuncion;
	private JTextField textFieldFechaRegFuncion;
	private JComboBox<String> comboBoxPlataformas;
	private IEspectaculo ctrlEspect;
	private String nombrePlataforma;
	private JComboBox<String> comboBoxEspectPlat;
	private JComboBox<String> comboBoxEspectadores;
	private String nombreEspectador;
	private String nombreEspectaculo;
	private JComboBox<String> comboBoxFuncionesEspect;
	private String nombreFuncion;
	JList<String> listRegistros;
	private JFormattedTextField formattedTextField;
	private LocalDate fechaFuncion;
	private JButton btnVerFunciones;
	private JButton btnVerDatos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroAFuncionDeEspectaculo frame = new RegistroAFuncionDeEspectaculo();
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
	public RegistroAFuncionDeEspectaculo() {
		
		Fabrica fabrica = Fabrica.getInstance();
        ctrlEspect = fabrica.getIEspectaculo();
        
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Registro a funcion de espectaculo");
		setBounds(100, 100, 641, 640);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 274, 179, 59, 91, 128, 0, 0};
		gridBagLayout.rowHeights = new int[]{18, 27, 0, 0, 0, 0, 0, 0, 0, 0, 20, 0, 0, 0, 0, 107, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Plataformas:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
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
				
			}
		});
		
		GridBagConstraints gbc_comboBoxPlataformas = new GridBagConstraints();
		gbc_comboBoxPlataformas.gridwidth = 4;
		gbc_comboBoxPlataformas.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxPlataformas.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxPlataformas.gridx = 2;
		gbc_comboBoxPlataformas.gridy = 1;
		getContentPane().add(comboBoxPlataformas, gbc_comboBoxPlataformas);
		
		JButton btnVerEspectaculos = new JButton("Ver espectaculos");
		btnVerEspectaculos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cargarEspectaculos(nombrePlataforma);
				btnVerFunciones.setEnabled(true);
			}
		});
		
		GridBagConstraints gbc_btnVerEspectaculos = new GridBagConstraints();
		gbc_btnVerEspectaculos.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnVerEspectaculos.insets = new Insets(0, 0, 5, 0);
		gbc_btnVerEspectaculos.gridx = 6;
		gbc_btnVerEspectaculos.gridy = 1;
		getContentPane().add(btnVerEspectaculos, gbc_btnVerEspectaculos);
		
		JLabel lblNewLabel_1 = new JLabel("Espectaculos de la plataforma:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		comboBoxEspectPlat = new JComboBox<String>();
		comboBoxEspectPlat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nombreEspectaculo = (String) comboBoxEspectPlat.getSelectedItem();
				
				
			}
		});
		GridBagConstraints gbc_comboBoxEspectPlat = new GridBagConstraints();
		gbc_comboBoxEspectPlat.gridwidth = 4;
		gbc_comboBoxEspectPlat.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxEspectPlat.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxEspectPlat.gridx = 2;
		gbc_comboBoxEspectPlat.gridy = 2;
		getContentPane().add(comboBoxEspectPlat, gbc_comboBoxEspectPlat);
		
		btnVerFunciones = new JButton("Ver funciones");
		btnVerFunciones.setEnabled(false);
		btnVerFunciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cargarFuncionesEspectaculo(nombreEspectaculo);
				btnVerDatos.setEnabled(true);
			}
		});
		GridBagConstraints gbc_btnVerFunciones = new GridBagConstraints();
		gbc_btnVerFunciones.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnVerFunciones.insets = new Insets(0, 0, 5, 0);
		gbc_btnVerFunciones.gridx = 6;
		gbc_btnVerFunciones.gridy = 2;
		getContentPane().add(btnVerFunciones, gbc_btnVerFunciones);
		
		JLabel lblNewLabel_2 = new JLabel("Funciones del espectaculo:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 3;
		getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		
		
		
		
		textFieldFechaFun = new JTextField();
		textFieldFechaFun.setEditable(false);
		GridBagConstraints gbc_textFieldFechaFun = new GridBagConstraints();
		gbc_textFieldFechaFun.gridwidth = 3;
		gbc_textFieldFechaFun.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldFechaFun.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldFechaFun.gridx = 3;
		gbc_textFieldFechaFun.gridy = 4;
		getContentPane().add(textFieldFechaFun, gbc_textFieldFechaFun);
		textFieldFechaFun.setColumns(10);
		
		textFieldHoraFuncion = new JTextField();
		textFieldHoraFuncion.setEditable(false);
		GridBagConstraints gbc_textFieldHoraFuncion = new GridBagConstraints();
		gbc_textFieldHoraFuncion.gridwidth = 3;
		gbc_textFieldHoraFuncion.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldHoraFuncion.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldHoraFuncion.gridx = 3;
		gbc_textFieldHoraFuncion.gridy = 5;
		getContentPane().add(textFieldHoraFuncion, gbc_textFieldHoraFuncion);
		textFieldHoraFuncion.setColumns(10);
		
		textFieldFechaRegFuncion = new JTextField();
		textFieldFechaRegFuncion.setEditable(false);
		GridBagConstraints gbc_textFieldFechaRegFuncion = new GridBagConstraints();
		gbc_textFieldFechaRegFuncion.gridwidth = 3;
		gbc_textFieldFechaRegFuncion.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldFechaRegFuncion.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldFechaRegFuncion.gridx = 3;
		gbc_textFieldFechaRegFuncion.gridy = 6;
		getContentPane().add(textFieldFechaRegFuncion, gbc_textFieldFechaRegFuncion);
		textFieldFechaRegFuncion.setColumns(10);
		
		
		
		
		
		///////////////////////////////////////////////////////
		comboBoxFuncionesEspect = new JComboBox<String>();
		comboBoxFuncionesEspect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//String espec = (String) comboBoxEspectPlat.getSelectedItem();
				//ctrlEspect.elegirEspectaculo(espec);
				
				nombreFuncion = (String) comboBoxFuncionesEspect.getSelectedItem();
				ctrlEspect.ingresarNombreFuncion(nombreFuncion);
				
				
			}
		});
		
		btnVerDatos = new JButton("Ver datos");
		btnVerDatos.setEnabled(false);
		btnVerDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					DtFuncion infoFun = ctrlEspect.mostarFuncion(nombreFuncion);
					
					textFieldFechaFun.setText(null);
					textFieldFechaFun.setText(infoFun.getFecha().toString());
					
					textFieldHoraFuncion.setText(null);
					textFieldHoraFuncion.setText(infoFun.getHorainicio().toString());
					
					textFieldFechaRegFuncion.setText(null);
					textFieldFechaRegFuncion.setText(infoFun.getFechaReg().toString());
				
			}
		});
		GridBagConstraints gbc_btnVerDatos = new GridBagConstraints();
		gbc_btnVerDatos.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnVerDatos.insets = new Insets(0, 0, 5, 0);
		gbc_btnVerDatos.gridx = 6;
		gbc_btnVerDatos.gridy = 3;
		getContentPane().add(btnVerDatos, gbc_btnVerDatos);
		
		JButton btnVerEspectadores = new JButton("Ver espectadores");
		btnVerEspectadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cargarEspectadores();
			}
		});
		
		GridBagConstraints gbc_btnVerEspectadores = new GridBagConstraints();
		gbc_btnVerEspectadores.insets = new Insets(0, 0, 5, 0);
		gbc_btnVerEspectadores.gridx = 6;
		gbc_btnVerEspectadores.gridy = 7;
		getContentPane().add(btnVerEspectadores, gbc_btnVerEspectadores);
		
		comboBoxEspectadores = new JComboBox<String>();
		comboBoxEspectadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nombreEspectador = (String) comboBoxEspectadores.getSelectedItem();
				ctrlEspect.ingresarNombreEspectador(nombreEspectador);
				
				
			}
		});
		
		GridBagConstraints gbc_comboBoxEspectadores = new GridBagConstraints();
		gbc_comboBoxEspectadores.gridwidth = 4;
		gbc_comboBoxEspectadores.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxEspectadores.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxEspectadores.gridx = 2;
		gbc_comboBoxEspectadores.gridy = 7;
		getContentPane().add(comboBoxEspectadores, gbc_comboBoxEspectadores);
		
		
		
		GridBagConstraints gbc_comboBoxFuncionesEspect = new GridBagConstraints();
		gbc_comboBoxFuncionesEspect.gridwidth = 4;
		gbc_comboBoxFuncionesEspect.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxFuncionesEspect.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxFuncionesEspect.gridx = 2;
		gbc_comboBoxFuncionesEspect.gridy = 3;
		getContentPane().add(comboBoxFuncionesEspect, gbc_comboBoxFuncionesEspect);
		
		JLabel lblNewLabel_3 = new JLabel("Fecha:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 2;
		gbc_lblNewLabel_3.gridy = 4;
		getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		
		
		JLabel lblNewLabel_10 = new JLabel("Hora de inicio:");
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_10.gridx = 2;
		gbc_lblNewLabel_10.gridy = 5;
		getContentPane().add(lblNewLabel_10, gbc_lblNewLabel_10);
		
		
		
		JLabel lblNewLabel_11 = new JLabel("Fecha del registro:");
		GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
		gbc_lblNewLabel_11.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_11.gridx = 2;
		gbc_lblNewLabel_11.gridy = 6;
		getContentPane().add(lblNewLabel_11, gbc_lblNewLabel_11);
		
		
		
		JLabel lblNewLabel_12 = new JLabel("Espectadores:");
		GridBagConstraints gbc_lblNewLabel_12 = new GridBagConstraints();
		gbc_lblNewLabel_12.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_12.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_12.gridx = 1;
		gbc_lblNewLabel_12.gridy = 7;
		getContentPane().add(lblNewLabel_12, gbc_lblNewLabel_12);
		
		JLabel lblNewLabel_14 = new JLabel("Registros a canjear:");
		GridBagConstraints gbc_lblNewLabel_14 = new GridBagConstraints();
		gbc_lblNewLabel_14.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_14.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_14.gridx = 1;
		gbc_lblNewLabel_14.gridy = 9;
		getContentPane().add(lblNewLabel_14, gbc_lblNewLabel_14);
		
		listRegistros = new JList<String>();
		
		GridBagConstraints gbc_listRegistros = new GridBagConstraints();
		gbc_listRegistros.gridheight = 5;
		gbc_listRegistros.gridwidth = 3;
		gbc_listRegistros.insets = new Insets(0, 0, 5, 5);
		gbc_listRegistros.fill = GridBagConstraints.BOTH;
		gbc_listRegistros.gridx = 2;
		gbc_listRegistros.gridy = 9;
		getContentPane().add(listRegistros, gbc_listRegistros);
		
		JButton btnConsultarRegistros = new JButton("Consultar registros");
		btnConsultarRegistros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cargarRegistrosPrevios();
			}
		});
		GridBagConstraints gbc_btnConsultarRegistros = new GridBagConstraints();
		gbc_btnConsultarRegistros.insets = new Insets(0, 0, 5, 0);
		gbc_btnConsultarRegistros.gridx = 6;
		gbc_btnConsultarRegistros.gridy = 10;
		getContentPane().add(btnConsultarRegistros, gbc_btnConsultarRegistros);
		
		JButton btnCanjear = new JButton("Canjear");
		
		btnCanjear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				canjear();
				eliminarListaRegistro();
			}
		});
		
		GridBagConstraints gbc_btnCanjear = new GridBagConstraints();
		gbc_btnCanjear.gridwidth = 2;
		gbc_btnCanjear.insets = new Insets(0, 0, 5, 0);
		gbc_btnCanjear.gridx = 6;
		gbc_btnCanjear.gridy = 12;
		getContentPane().add(btnCanjear, gbc_btnCanjear);
		
		JLabel lblFecha = new JLabel("Fecha:");
		GridBagConstraints gbc_lblFecha = new GridBagConstraints();
		gbc_lblFecha.insets = new Insets(0, 0, 5, 5);
		gbc_lblFecha.anchor = GridBagConstraints.EAST;
		gbc_lblFecha.gridx = 1;
		gbc_lblFecha.gridy = 14;
		getContentPane().add(lblFecha, gbc_lblFecha);
		
		
		
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
		gbc_formattedTextField.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextField.gridx = 2;
		gbc_formattedTextField.gridy = 14;
		getContentPane().add(formattedTextField, gbc_formattedTextField);
		
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setForeground(Color.BLUE);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean confirmar = true;
				if(ctrlEspect.existeRegistroEspecAFun()) {
					JOptionPane.showMessageDialog(null, "El usuario ya esta registrado a la funcion seleccionada. Elija otro espectador", "Registro a funcion de espectaculo", JOptionPane.INFORMATION_MESSAGE);
					//comboBoxEspectadores.removeAllItems();
					confirmar = false;
					
					}
				
				if(ctrlEspect.funcionAlcanzoLimiteReg(nombreEspectaculo)) {
					JOptionPane.showMessageDialog(null, "La funcion seleccionada alcanzo el maximo de espectadores. Elige otra funcion", "Registro a funcion de espectaculo", JOptionPane.INFORMATION_MESSAGE);
					textFieldFechaFun.setText(null);
					textFieldHoraFuncion.setText(null);
					textFieldFechaRegFuncion.setText(null);
					confirmar = false;
				}
				//Recojo los datos de la fecha introducidos
				String fecha = formattedTextField.getText();
		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				fechaFuncion = null;
				try {
					fechaFuncion = LocalDate.parse(fecha, formatter);
				}
				catch(DateTimeParseException e1) {
					JOptionPane.showMessageDialog(null, "Fecha Invalida");
					System.out.print("Fallo el parseo de la fecha");
					return;
				}
				//chequeo que la fecha sea valida
				try {
					ctrlEspect.esFechaInvalida(nombreEspectaculo, fechaFuncion);
					if(confirmar) {
						int respuesta = JOptionPane.showConfirmDialog(null, "Confirmar los datos ingresados", "Confirmacion", JOptionPane.YES_NO_OPTION);
						if(respuesta == JOptionPane.YES_OPTION) {
							confirmarRegistro();
							dispose();
							}
						}
					
				}catch(fechaPosterior e){
					JOptionPane.showMessageDialog(null, e.getMessage(), "Registro a funcion de espectaculo", JOptionPane.INFORMATION_MESSAGE);
					
				}
				
				ctrlEspect.setRegistroFueCanjeado(false);
				
				
				//limpiarVentana();
			}
		});
		
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAceptar.gridx = 2;
		gbc_btnAceptar.gridy = 15;
		getContentPane().add(btnAceptar, gbc_btnAceptar);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//limpiarVentana();
				setVisible(false);
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton_1.gridwidth = 2;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 5;
		gbc_btnNewButton_1.gridy = 15;
		getContentPane().add(btnNewButton_1, gbc_btnNewButton_1);

	}
	
	///////END CONSTRUCTOR//////
	
	public void cargarPlataformas() {
		comboBoxPlataformas.removeAllItems();
        ArrayList<String> nombres = ctrlEspect.listarPlataformas(); 
        nombres.sort(String::compareToIgnoreCase);
        for(int i = 0; i < nombres.size(); i++) {
        	comboBoxPlataformas.addItem(nombres.get(i));
            	
            	}
        }
	
	public void cargarEspectaculos(String nomplat) {
		comboBoxEspectPlat.removeAllItems();
		ArrayList<String> nombres = ctrlEspect.listarEspectaculosPlataforma(nomplat);
		nombres.sort(String::compareToIgnoreCase);
		for(int i = 0; i < nombres.size(); i++) {
        	comboBoxEspectPlat.addItem(nombres.get(i));
        	
        	}
		}
	public void cargarEspectadores() {
		
		comboBoxEspectadores.removeAllItems();
		ArrayList<String> nombres = ctrlEspect.mostrarEspectadores();
		nombres.sort(String::compareToIgnoreCase);
		for(int i = 0; i < nombres.size(); i++) {
        	comboBoxEspectadores.addItem(nombres.get(i));
		}
		/*DefaultComboBoxModel<DtUsuario> model;
	      try {
	          model = new DefaultComboBoxModel<DtUsuario>(ctrlEspect.listarUsuarios());
	          comboBoxEspectadores.setModel(model);
	      } catch (usuarioNoExiste e) {
	          // No se imprime mensaje de error sino que simplemente no se muestra ningún elemento
	    	  JOptionPane.showMessageDialog(this, e.getMessage(), "Registro a funcion de espectaculo", JOptionPane.INFORMATION_MESSAGE);
				//return;
	      }*/
	}
	  
      
      
	
	public void cargarFuncionesEspectaculo(String nombreEspect) {
		comboBoxFuncionesEspect.removeAllItems();
		ArrayList<DtFuncion> funciones = ctrlEspect.mostrarFuncionesEspectaculo(nombreEspect);
		funciones.sort((DtFuncion f, DtFuncion g) -> {
			return f.getNombre().compareToIgnoreCase(g.getNombre());
		});
		for(int i = 0; i < funciones.size(); i++) {
			comboBoxFuncionesEspect.addItem(funciones.get(i).getNombre());
		}
	}
	
	public void cargarRegistrosPrevios() {
		//elimino lo anterior
		listRegistros.removeAll();
	
		ArrayList<DtRegistro> regs = ctrlEspect.obtenerRegistrosPrevios();
		
		if(!regs.isEmpty()) {
			
			DefaultListModel<String> listModel = new DefaultListModel<String>();
		
			for(int i=0; i<regs.size(); i++) {
				listModel.add(i,String.valueOf(regs.get(i).getId()));
			}
			//Asociar el modelo de lista al JList
			listRegistros.setModel(listModel);
			
		}else {
			JOptionPane.showMessageDialog(null, "El usuario no posee registros previos", "Registro a funcion de espectaculo", JOptionPane.INFORMATION_MESSAGE);
			
		}
		
	}
	
	public void canjear() {
		int[] selectedIx = listRegistros.getSelectedIndices();

	    // Get all the selected items using the indices
		int i;
		int[] regSelect = new int[3];
	    for (i = 0; i < selectedIx.length; i++) {
	      String sel = listRegistros.getModel().getElementAt(selectedIx[i]);
	      regSelect[i] = Integer.parseInt(sel);
	    }
	    
            try {
            	ctrlEspect.canjearRegistros(regSelect);

            } catch (noSeleccionoTres e) {
                // Muestro error de registro
            	JOptionPane.showMessageDialog(this, "Debe seleccionar 3 registros previos para poder canjear el registro", "Registro a funcion de espectaculo", JOptionPane.INFORMATION_MESSAGE);
            }
	}
	public void eliminarListaRegistro() {
		//for(int i = 0; i < listRegistros.getModel().getSize(); i++) {
			((DefaultListModel<String>) listRegistros.getModel()).clear();
		//}
	}
	
	
	
	public void limpiarVentana() {
		textFieldFechaFun.setText(null);
		textFieldHoraFuncion.setText(null);
		textFieldFechaRegFuncion.setText(null);
		comboBoxPlataformas.removeAllItems();
		comboBoxEspectPlat.removeAllItems();
		comboBoxEspectadores.removeAllItems();
		comboBoxFuncionesEspect.removeAllItems();
		listRegistros.removeAll();
		formattedTextField.setText(null);
	}
	
	public void confirmarRegistro() {
		ctrlEspect.confirmarRegistro(nombreEspectaculo, fechaFuncion);
	}
	

}
