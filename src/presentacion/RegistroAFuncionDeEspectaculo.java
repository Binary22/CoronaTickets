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
import com.toedter.calendar.JCalendar;

import datatypes.DtFuncion;
import datatypes.DtRegistro;
import datatypes.DtUsuario;
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
import javax.swing.JRadioButton;

public class RegistroAFuncionDeEspectaculo extends JInternalFrame {
	private JTextField textFieldFechaFun;
	private JTextField textFieldHoraFuncion;
	private JTextField textFieldFechaRegFuncion;
	private JComboBox<String> comboBoxPlataformas;
	private IEspectaculo ctrlEspect;
	private String nombrePlataforma;
	private JComboBox<String> comboBoxEspectPlat;
	private JComboBox<DtUsuario> comboBoxEspectadores;
	private String nombreEspectador;
	private String nombreEspectaculo;
	private JComboBox<String> comboBoxFuncionesEspect;
	private String nombreFuncion;
	JList<DtRegistro> listRegistros;

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
		gridBagLayout.columnWidths = new int[]{0, 159, 179, 126, 0, 128, 0, 0};
		gridBagLayout.rowHeights = new int[]{18, 27, 0, 0, 0, 0, 0, 0, 0, 0, 20, 0, 0, 0, 0, 107, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
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
			}
		});
		GridBagConstraints gbc_btnVerEspectaculos = new GridBagConstraints();
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
		
		JButton btnVerFunciones = new JButton("Ver funciones");
		btnVerFunciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cargarFuncionesEspectaculo(nombreEspectaculo);
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
				nombreFuncion = (String) comboBoxFuncionesEspect.getSelectedItem();
				
				ctrlEspect.ingresarNombreFuncion(nombreFuncion);
				
				
				if(!ctrlEspect.funcionAlcanzoLimiteReg(nombreEspectaculo)) {
					
					DtFuncion infoFun = ctrlEspect.mostarFuncion(nombreFuncion);
					textFieldFechaFun.setText(null);
					textFieldFechaFun.setText(infoFun.getFecha().toString());
					
					textFieldHoraFuncion.setText(null);
					textFieldHoraFuncion.setText(infoFun.getHorainicio().toString());
					
					textFieldFechaRegFuncion.setText(null);
					textFieldFechaRegFuncion.setText(infoFun.getFechaReg().toString());
				}else {
					JOptionPane.showMessageDialog(null, "La funcion seleccionada alcanzo el maximo de espectadores. Elige otra funcion", "Registro a funcion de espectaculo", JOptionPane.INFORMATION_MESSAGE);
					textFieldFechaFun.setText(null);
					textFieldHoraFuncion.setText(null);
					textFieldFechaRegFuncion.setText(null);
					
				}
			}
		});
		
comboBoxEspectadores = new JComboBox<DtUsuario>();
		
		comboBoxEspectadores.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				cargarEspectadores();
			}
		});
		
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
		
		
		
		JLabel lblObtenerRegistrosPrevios = new JLabel("Obtener registros previos:");
		GridBagConstraints gbc_lblObtenerRegistrosPrevios = new GridBagConstraints();
		gbc_lblObtenerRegistrosPrevios.anchor = GridBagConstraints.EAST;
		gbc_lblObtenerRegistrosPrevios.insets = new Insets(0, 0, 5, 5);
		gbc_lblObtenerRegistrosPrevios.gridx = 1;
		gbc_lblObtenerRegistrosPrevios.gridy = 8;
		getContentPane().add(lblObtenerRegistrosPrevios, gbc_lblObtenerRegistrosPrevios);
		
		JRadioButton radioButton = new JRadioButton("");
		radioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cargarRegistrosPrevios();
			}
		});
		
		GridBagConstraints gbc_radioButton = new GridBagConstraints();
		gbc_radioButton.anchor = GridBagConstraints.WEST;
		gbc_radioButton.insets = new Insets(0, 0, 5, 5);
		gbc_radioButton.gridx = 2;
		gbc_radioButton.gridy = 8;
		getContentPane().add(radioButton, gbc_radioButton);
		
		JLabel lblNewLabel_14 = new JLabel("Registros a canjear:");
		GridBagConstraints gbc_lblNewLabel_14 = new GridBagConstraints();
		gbc_lblNewLabel_14.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_14.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_14.gridx = 1;
		gbc_lblNewLabel_14.gridy = 9;
		getContentPane().add(lblNewLabel_14, gbc_lblNewLabel_14);
		
		listRegistros = new JList<DtRegistro>();
		
		GridBagConstraints gbc_listRegistros = new GridBagConstraints();
		gbc_listRegistros.gridheight = 3;
		gbc_listRegistros.gridwidth = 3;
		gbc_listRegistros.insets = new Insets(0, 0, 5, 5);
		gbc_listRegistros.fill = GridBagConstraints.BOTH;
		gbc_listRegistros.gridx = 2;
		gbc_listRegistros.gridy = 9;
		getContentPane().add(listRegistros, gbc_listRegistros);
		
		
		JButton btnCanjear = new JButton("Canjear");

		btnCanjear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!ctrlEspect.existeRegistroEspecAFun()) {
					canjear();
				}else {
					JOptionPane.showMessageDialog(null, "El usuario ya esta registrado a la funcion seleccionada. Elige otro espectador", "Registro a funcion de espectaculo", JOptionPane.INFORMATION_MESSAGE);
					
				}
			}
		});
		
			
		
		GridBagConstraints gbc_btnCanjear = new GridBagConstraints();
		gbc_btnCanjear.gridwidth = 2;
		gbc_btnCanjear.insets = new Insets(0, 0, 5, 0);
		gbc_btnCanjear.gridx = 5;
		gbc_btnCanjear.gridy = 10;
		getContentPane().add(btnCanjear, gbc_btnCanjear);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setForeground(Color.BLUE);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				confirmarRegistroFuncion();
			}
		});
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAceptar.gridx = 2;
		gbc_btnAceptar.gridy = 12;
		getContentPane().add(btnAceptar, gbc_btnAceptar);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarVentana();
				setVisible(false);
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.gridwidth = 2;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 3;
		gbc_btnNewButton_1.gridy = 12;
		getContentPane().add(btnNewButton_1, gbc_btnNewButton_1);

	}
	
	///////END CONSTRUCTOR//////
	
	public void cargarPlataformas() {
		comboBoxPlataformas.removeAllItems();
        ArrayList<String> nombres = ctrlEspect.listarPlataformas(); 
        for(int i = 0; i < nombres.size(); i++) {
        	comboBoxPlataformas.addItem(nombres.get(i));
            	
            	}
        }
	
	public void cargarEspectaculos(String nomplat) {
		comboBoxEspectPlat.removeAllItems();
		ArrayList<String> nombres = ctrlEspect.listarEspectaculosPlataforma(nomplat);
		for(int i = 0; i < nombres.size(); i++) {
        	comboBoxEspectPlat.addItem(nombres.get(i));
        	
        	}
		}
	public void cargarEspectadores() {
		
		DefaultComboBoxModel<DtUsuario> model;
	      try {
	          model = new DefaultComboBoxModel<DtUsuario>(ctrlEspect.listarUsuarios());
	          comboBoxEspectadores.setModel(model);
	      } catch (usuarioNoExiste e) {
	          // No se imprime mensaje de error sino que simplemente no se muestra ningún elemento
	    	  JOptionPane.showMessageDialog(this, e.getMessage(), "Registro a funcion de espectaculo", JOptionPane.INFORMATION_MESSAGE);
				//return;
	      }
	}
	  
      
      
	
	public void cargarFuncionesEspectaculo(String nombreEspect) {
		comboBoxFuncionesEspect.removeAllItems();
		ArrayList<DtFuncion> funciones = ctrlEspect.mostrarFuncionesEspectaculo(nombreEspect);
		for(int i = 0; i < funciones.size(); i++) {
			comboBoxFuncionesEspect.addItem(funciones.get(i).getNombre());
		}
	}
	
	public void cargarRegistrosPrevios() {
		//elimino lo anterior
		listRegistros.removeAll();
		//Crear un objeto DefaultListModel
		
		//Recorrer el contenido del ArrayList
		ArrayList<DtRegistro> regs = ctrlEspect.obtenerRegistrosPrevios();
		if(!regs.isEmpty()) {
			DefaultListModel<DtRegistro> listModel = new DefaultListModel<DtRegistro>();
		
			for(int i=0; i<regs.size(); i++) {
				//Añadir cada elemento del ArrayList en el modelo de la lista
				listModel.add(i, regs.get(i));
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
		DtRegistro[] regSelect = new DtRegistro[3];
	    for (i = 0; i < selectedIx.length; i++) {
	      DtRegistro sel = listRegistros.getModel().getElementAt(selectedIx[i]);
	      regSelect[i] = sel;
	    }
	    
            try {
            	ctrlEspect.canjearRegistros(regSelect);

            } catch (noSeleccionoTres e) {
                // Muestro error de registro
            	JOptionPane.showMessageDialog(this, "Debe seleccionar 3 registros previos para poder canjear el registro", "Registro a funcion de espectaculo", JOptionPane.INFORMATION_MESSAGE);
            }
	}
	
	public void confirmarRegistroFuncion() {
		ctrlEspect.confirmarRegistro(nombreEspectaculo);
	}
	
	public void limpiarVentana() {
		textFieldFechaFun.setText(null);
		textFieldHoraFuncion.setText(null);
		textFieldFechaRegFuncion.setText(null);
		//comboBoxPlataformas.removeAllItems();
		//comboBoxEspectPlat.removeAllItems();
		//comboBoxEspectadores.removeAllItems();
		//comboBoxFuncionesEspect.removeAllItems();
	}
	
	/*public DtRegistro[] cargarRegistrosPrevios(){
		 ArrayList<DtRegistro> regs = ctrlEspect.obtenerRegistrosPrevios();
	        if (regs!= null) {
	            DtRegistro[] regNuevos = new DtRegistro[regs.size()];
	            Iterator<DtRegistro> it = regs.iterator();
	            for (int i = 0; i < regs.size(); i++) {
	                regNuevos[i] = it.next();
	            }

	            return regNuevos;
	        
	        }else {
	        return null;
	        }
	        
	}*/
	
	
	
	        
	  
	

}
