package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class AltaUsuario extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaUsuario frame = new AltaUsuario();
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
	public AltaUsuario() {
		setBounds(100, 100, 450, 300);

	}

}
