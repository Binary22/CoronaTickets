package presentacion;

import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;

public class ModificarUsuario extends JInternalFrame {

	public ModificarUsuario() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.insets = new Insets(0, 0, 0, 5);
		gbc_lblUsuario.gridx = 1;
		gbc_lblUsuario.gridy = 0;
		getContentPane().add(lblUsuario, gbc_lblUsuario);
		
		JComboBox comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 3;
		gbc_comboBox.gridy = 0;
		getContentPane().add(comboBox, gbc_comboBox);
		// TODO Auto-generated constructor stub
	}

	public ModificarUsuario(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public ModificarUsuario(String arg0, boolean arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public ModificarUsuario(String arg0, boolean arg1, boolean arg2) {
		super(arg0, arg1, arg2);
		// TODO Auto-generated constructor stub
	}

	public ModificarUsuario(String title, boolean resizable, boolean closable, boolean maximizable) {
		super(title, resizable, closable, maximizable);
		// TODO Auto-generated constructor stub
	}

	public ModificarUsuario(String title, boolean resizable, boolean closable, boolean maximizable,
			boolean iconifiable) {
		super(title, resizable, closable, maximizable, iconifiable);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
