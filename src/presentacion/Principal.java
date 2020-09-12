package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Fabrica;
import logica.IEspectaculo;
import logica.IPlataforma;
import logica.IUsuario;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JInternalFrame AltaUsuarioInternalFrame;
	private JInternalFrame ModificarDatosDeUsuarioInternalFrame;
	private JInternalFrame ConsultaDeUsuarioInternalFrame;
	private JInternalFrame AltaFuncionInternalFrame;
	private JInternalFrame AltaDeEspectaculoInternalFrame;
	

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
				AltaDeEspectaculoInternalFrame.setVisible(true);                             
				}         
			});
		
		//caso de uso alta de funcion de espectaculo
		//JMenuItem mntmNewMenuItem_3 = new JMenuItem("Alta de funcion de espectaculo");
		//JMenuItem mntmNewMenuItem_2 = new JMenuItem("Alta de función de espectáculo");

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
		
		JMenu mnPruebas = new JMenu("Pruebas");
		menuBar.add(mnPruebas);
		
		JMenuItem mntmCargarDatos = new JMenuItem("Cargar Datos");
		mntmCargarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarDatos();
			}
		});
		
		mnPruebas.add(mntmCargarDatos);
	
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
        
        AltaDeEspectaculoInternalFrame = new AltaDeEspectaculo();
        AltaDeEspectaculoInternalFrame.setVisible(false);
        getContentPane().add(AltaDeEspectaculoInternalFrame);
        
        Fabrica fab= Fabrica.getInstance();
        IPlataforma iplat= fab.getIPlataforma();
        iplat.altaPlataforma("Twitch", "Ni judas se atrevio a tanto", "https://www.twitch.tv/rubius");
        iplat.confirmarAltaPlataforma();
        iplat.altaPlataforma("Youtube", "Tema del anio", "https://youtu.be/Pu8LH6r-wOU?t=25");
        iplat.confirmarAltaPlataforma();
        iplat.altaPlataforma("Facebook", "Campeon del mundialito", "https://www.facebook.com/fingudelar/");
        iplat.confirmarAltaPlataforma();
        iplat.altaPlataforma("Instagram", "Gato maricon", "https://www.instagram.com/shadow_and_company/");
        iplat.confirmarAltaPlataforma();
        iplat.altaPlataforma("Openfing", "Bienvenides", "https://open.fing.edu.uy/courses/c2/9");
        iplat.confirmarAltaPlataforma();
        
	
	}

	protected void cargarDatos() {
		// TODO Auto-generated method stub
		Fabrica f = Fabrica.getInstance();
		IPlataforma pc = f.getIPlataforma();
		
		pc.altaPlataforma("FaceBook Live", "Servicio de streaming de FaceBook", "https://www.live.facebook.com");
		pc.confirmarAltaPlataforma();
		pc.altaPlataforma("YouTube", "Red Social de compartir videos", "https://www.youtube.com");
		pc.confirmarAltaPlataforma();
		pc.altaPlataforma("TwitchTv", "Servicio de streaming live de Gamers que nunca dicen n-word en vivo", "https://www.twitch.tv");
		pc.confirmarAltaPlataforma();
		
		IUsuario uc = f.getIUsuario();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fecha1 = LocalDate.parse("07/10/1999", formatter);
		uc.altaUsuario("santic", "Santiago", "Costa", "santicosta@fing.edu.uy", fecha1);
		uc.confirmarAltaUsuario();
		uc.altaUsuario("santia", "Santiago", "Acquarone", "santiacqua@fing.edu.uy", fecha1);
		uc.altaArtista("Reggeatonero profesional", "Cantante Uruguayo que canta sobre el open source", "www.opensanti.io");
		uc.confirmarAltaUsuario();
		
		IEspectaculo ec = f.getIEspectaculo();
		ec.altaEspectaculo("YouTube", "santia", "OpenSourceFEst", "Una celebracion del reggeton y el open source.", LocalTime.of(8, 30), 1, 5, "opensourcefest.io", 950, LocalDate.now());
		ec.confirmarAltaEspectaculo();
		ec.altaEspectaculo("TwitchTv", "santia", "GitKraken Corp Fest", "Una celebracion del capitalismo.", LocalTime.of(6, 06), 1, 12, "gitkrakenfest.com", 95000, LocalDate.now());
		ec.confirmarAltaEspectaculo();
	
		

	}

}
