package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class modificarDatosUsuario extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					modificarDatosUsuario frame = new modificarDatosUsuario();
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
	public modificarDatosUsuario() {
		setBounds(100, 100, 450, 300);
		
		

	}

}
