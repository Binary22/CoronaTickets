package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class ModificarDatosDeUsuario extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarDatosDeUsuario frame = new ModificarDatosDeUsuario();
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
	public ModificarDatosDeUsuario() {
		setBounds(100, 100, 450, 300);

	}

}
