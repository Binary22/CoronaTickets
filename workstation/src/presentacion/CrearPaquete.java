package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JTextPane;
import javax.swing.text.MaskFormatter;

import excepciones.PaqueteConMismoNombreException;
import logica.Fabrica;
import logica.IPaquete;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;

public class CrearPaquete extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textNombre;
	private JTextField textFechaIni;
	private JTextField textFechaFin;
	private JTextField textFechaAlta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearPaquete frame = new CrearPaquete();
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
	public CrearPaquete() {
		setTitle("Crear paquete");
		setBounds(100, 100, 512, 297);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 122, 236, 170, 0, 0};
		gridBagLayout.rowHeights = new int[]{38, 120, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		getContentPane().add(lblNombre, gbc_lblNewLabel);
		
		textNombre = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 0;
		getContentPane().add(textNombre, gbc_textField);
		textNombre.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		getContentPane().add(lblDescripcion, gbc_lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 1;
		getContentPane().add(scrollPane, gbc_scrollPane);
		
		JTextPane textPaneDescripcion = new JTextPane();
		scrollPane.setViewportView(textPaneDescripcion);
		
		JLabel lblfechainici = new JLabel("Fecha de inicio:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 2;
		getContentPane().add(lblfechainici, gbc_lblNewLabel_2);
		
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
		
		textFechaIni = new JFormattedTextField(mask);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 2;
		getContentPane().add(textFechaIni, gbc_textField_1);
		textFechaIni.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Fecha de finalizacion:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 3;
		getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		textFechaFin = new JFormattedTextField(mask);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 2;
		gbc_textField_2.gridy = 3;
		getContentPane().add(textFechaFin, gbc_textField_2);
		textFechaFin.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Fecha de alta:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 4;
		getContentPane().add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		textFechaAlta = new JFormattedTextField(mask);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 2;
		gbc_textField_3.gridy = 4;
		getContentPane().add(textFechaAlta, gbc_textField_3);
		textFechaAlta.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Descuento:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 5;
		getContentPane().add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		JSpinner spnDescuento = new JSpinner();
		spnDescuento.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		GridBagConstraints gbc_spinner = new GridBagConstraints();
		gbc_spinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner.insets = new Insets(0, 0, 5, 5);
		gbc_spinner.gridx = 2;
		gbc_spinner.gridy = 5;
		getContentPane().add(spnDescuento, gbc_spinner);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//aca cargo las 3 fechas
				String fecha = textFechaIni.getText();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate fechaIni = null;
				try {
					fechaIni = LocalDate.parse(fecha, formatter);
				}
				catch(DateTimeParseException e1) {
					JOptionPane.showMessageDialog(null, "Fecha Invalida");
					System.out.print("Fallo el parseo de la fecha");
					return;
				}
				fecha = textFechaFin.getText();
				LocalDate fechaFin = null;
				try {
					fechaFin = LocalDate.parse(fecha, formatter);
				}
				catch(DateTimeParseException e1) {
					JOptionPane.showMessageDialog(null, "Fecha Invalida");
					System.out.print("Fallo el parseo de la fecha");
					return;
				}
				fecha = textFechaAlta.getText();
				LocalDate fechaAlta = null;
				try {
					fechaAlta = LocalDate.parse(fecha, formatter);
				}
				catch(DateTimeParseException e1) {
					JOptionPane.showMessageDialog(null, "Fecha Invalida");
					System.out.print("Fallo el parseo de la fecha");
					return;
				}
				//hasta aca cargo fechas
				
				String Nombre = textNombre.getText();
				String Descripcion = textPaneDescripcion.getText();
				int Descuento = (int) spnDescuento.getValue();
				LocalDate fechaActual = LocalDate.now();
				if (Descuento <= 0) {
					JOptionPane.showMessageDialog(null, "El descuento no puede ser 0");
				}
				else if (fechaAlta.isAfter(fechaFin) || fechaAlta.isAfter(fechaIni) || fechaAlta.isEqual(fechaFin))
					JOptionPane.showMessageDialog(null, "La fecha de alta no puede ser posterior a la fecha de inicio, ni posterior o igual a la de finalizacion.");
				else if (fechaFin.isBefore(fechaIni))
					JOptionPane.showMessageDialog(null, "La fecha de inicio no puede ser posterior a la de finalizacion.");

				else if (fechaAlta.isBefore(fechaActual) || fechaFin.isBefore(fechaActual) || fechaIni.isBefore(fechaActual))
					JOptionPane.showMessageDialog(null, "La fecha debe ser igual o posterior a la actual");
				
				else if ((int) spnDescuento.getValue() >= 100) {
					JOptionPane.showMessageDialog(null, "El descuento no puede ser mayor a 100%");
				}
				
				else if (Nombre.equals("") || Descripcion.equals("")) 
					JOptionPane.showMessageDialog(null, "Por favor rellene todos los campos de texto.");
				
					else {
						Fabrica fab = Fabrica.getInstance();
						IPaquete iPaq = fab.getIPaquete();
						try {
							iPaq.crearPaquete(Nombre, Descripcion, fechaIni, fechaFin, Descuento, fechaAlta);
							iPaq.confirmarCrearPaquete();
							JOptionPane.showMessageDialog(null, "Paquete: " + Nombre + " creado con exito!");
						} catch (PaqueteConMismoNombreException ex) {
							JOptionPane.showMessageDialog(null, ex.getMessage(), "Crear Paquete", JOptionPane.ERROR_MESSAGE);
						}		
				}
			}
		});
		btnNewButton.setForeground(Color.BLUE);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 7;
		getContentPane().add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton_1.setForeground(Color.RED);
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 3;
		gbc_btnNewButton_1.gridy = 7;
		getContentPane().add(btnNewButton_1, gbc_btnNewButton_1);

	}
	


}