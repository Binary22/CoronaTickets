package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Fabrica;
import logica.IEspectaculo;
import logica.IUsuario;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JInternalFrame AltaUsuarioInternalFrame;
	private JInternalFrame ModificarDatosDeUsuarioInternalFrame;
	private JInternalFrame ConsultaDeUsuarioInternalFrame;
	private JInternalFrame AltaFuncionInternalFrame;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 500, 1300, 900);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnUsuarios = new JMenu("Usuarios");
		menuBar.add(mnUsuarios);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Alta de Usuario");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// aca hay que hacer visible la ventana del CU
				AltaUsuarioInternalFrame.setVisible(true);
			}
		});
		mnUsuarios.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Modificar datos de usuario");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ModificarDatosDeUsuarioInternalFrame.setVisible(true);
			}
		});
		mnUsuarios.add(mntmNewMenuItem_1);
		
		JMenuItem mntmConsultaDeDatos = new JMenuItem("Consulta de usuario");
		mntmConsultaDeDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConsultaDeUsuarioInternalFrame.setVisible(true);
			}
		});
		mnUsuarios.add(mntmConsultaDeDatos);
		
		JMenu mnEspectaculos = new JMenu("Espectaculos");
		menuBar.add(mnEspectaculos);
		
		JMenuItem mntmAltaDeEspectaculo = new JMenuItem("Alta de espectaculo");
		mnEspectaculos.add(mntmAltaDeEspectaculo);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Alta de función de espectáculo");

		mntmAltaDeEspectaculo.addActionListener(new ActionListener() {             
			public void actionPerformed(ActionEvent e) {                 
				getContentPane().removeAll();                 
				contentPane.repaint();                 
				AltaDeEspectaculo intFrameAltaDeEspectaculo = new AltaDeEspectaculo();                 
				intFrameAltaDeEspectaculo.setLocation(0, 0);                 
				intFrameAltaDeEspectaculo.setBounds(48, 33, 570, 513);                 
				intFrameAltaDeEspectaculo.setVisible(true);                 
				getContentPane().add(intFrameAltaDeEspectaculo);             
				}         
			});
		
		//caso de uso alta de funcion de espectaculo
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Alta de funcion de espectaculo");
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Alta de función de espectáculo");

		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AltaFuncionInternalFrame.setVisible(true);
			}
		});
		mnEspectaculos.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	
		//////////////////////////////////////////////////////////////////////////
		// EL CODIGO QUE SE AGREGA (SIN SER RESPUESTAS A EVENTOS) VA ACA ABAJO  //
        //////////////////////////////////////////////////////////////////////////
		
		
        
        AltaUsuarioInternalFrame = new AltaUsuario();
        AltaUsuarioInternalFrame.setVisible(false);
        getContentPane().add(AltaUsuarioInternalFrame);
        
        ModificarDatosDeUsuarioInternalFrame = new ModificarDatosDeUsuario();
        ModificarDatosDeUsuarioInternalFrame.setVisible(false);
        getContentPane().add(ModificarDatosDeUsuarioInternalFrame);
        
        ConsultaDeUsuarioInternalFrame = new ConsultaUsuario();
        ConsultaDeUsuarioInternalFrame.setVisible(false);
        getContentPane().add(ConsultaDeUsuarioInternalFrame);
        
        AltaFuncionInternalFrame = new AltaFuncionEspectaculo();
        AltaFuncionInternalFrame.setVisible(false);
        getContentPane().add(AltaFuncionInternalFrame);
	
	}

}
