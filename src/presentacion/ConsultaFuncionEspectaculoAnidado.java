package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class ConsultaFuncionEspectaculoAnidado extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaFuncionEspectaculoAnidado frame = new ConsultaFuncionEspectaculoAnidado();
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
	public ConsultaFuncionEspectaculoAnidado() {
		setClosable(true);
		setBounds(100, 100, 450, 300);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 0;
		getContentPane().add(lblNombre, gbc_lblNombre);
		
		JLabel lblName = new JLabel("name");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(0, 0, 5, 0);
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 0;
		getContentPane().add(lblName, gbc_lblName);
		
		JLabel lblFecha = new JLabel("Fecha:");
		GridBagConstraints gbc_lblFecha = new GridBagConstraints();
		gbc_lblFecha.insets = new Insets(0, 0, 5, 5);
		gbc_lblFecha.gridx = 0;
		gbc_lblFecha.gridy = 1;
		getContentPane().add(lblFecha, gbc_lblFecha);
		
		JLabel lblDate = new JLabel("date");
		GridBagConstraints gbc_lblDate = new GridBagConstraints();
		gbc_lblDate.insets = new Insets(0, 0, 5, 0);
		gbc_lblDate.gridx = 1;
		gbc_lblDate.gridy = 1;
		getContentPane().add(lblDate, gbc_lblDate);
		
		JLabel lblHoraInicio = new JLabel("Hora inicio:");
		GridBagConstraints gbc_lblHoraInicio = new GridBagConstraints();
		gbc_lblHoraInicio.insets = new Insets(0, 0, 5, 5);
		gbc_lblHoraInicio.gridx = 0;
		gbc_lblHoraInicio.gridy = 2;
		getContentPane().add(lblHoraInicio, gbc_lblHoraInicio);
		
		JLabel lblTimeini = new JLabel("timeini");
		GridBagConstraints gbc_lblTimeini = new GridBagConstraints();
		gbc_lblTimeini.insets = new Insets(0, 0, 5, 0);
		gbc_lblTimeini.gridx = 1;
		gbc_lblTimeini.gridy = 2;
		getContentPane().add(lblTimeini, gbc_lblTimeini);
		
		JLabel lblFechaDeRegistro = new JLabel("Fecha de registro en el sistema:");
		GridBagConstraints gbc_lblFechaDeRegistro = new GridBagConstraints();
		gbc_lblFechaDeRegistro.insets = new Insets(0, 0, 0, 5);
		gbc_lblFechaDeRegistro.gridx = 0;
		gbc_lblFechaDeRegistro.gridy = 3;
		getContentPane().add(lblFechaDeRegistro, gbc_lblFechaDeRegistro);
		
		JLabel lblDatereg = new JLabel("datereg");
		GridBagConstraints gbc_lblDatereg = new GridBagConstraints();
		gbc_lblDatereg.gridx = 1;
		gbc_lblDatereg.gridy = 3;
		getContentPane().add(lblDatereg, gbc_lblDatereg);

	}

}
