
package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datatypes.DtRegistro;
import excepciones.NoExistePaqueteException;
import excepciones.NombreEspectaculoExisteException;
import excepciones.NombreFuncionexisteException;
import excepciones.UsuarioConMismoMailException;
import excepciones.UsuarioConMismoNickException;
import excepciones.UsuarioPaqueteComprado;
import excepciones.noSeleccionoTres;
import logica.Compra;
import logica.Espectaculo;
import logica.Fabrica;
import logica.Funcion;
import logica.HandlerCategorias;
import logica.HandlerEspectaculos;
import logica.HandlerPaquetes;
import logica.HandlerUsuarios;
import logica.IEspectaculo;
import logica.IPaquete;
import logica.IPlataforma;
import logica.IUsuario;
import logica.Premio;
import logica.Publicador;
import logica.Usuario;


public class Principal extends JFrame {

	//private JPanel contentPane;
	private JInternalFrame AltaUsuarioInternalFrame;
	private JInternalFrame modificarDatosDeUsuarioInternalFrame;
	private JInternalFrame ConsultaDeUsuarioInternalFrame;
	private JInternalFrame ConsultaUsuarioFixInternalFrame;
	private JInternalFrame ConsultaEspectaculoInternalFrame;
	private JInternalFrame AltaFuncionInternalFrame;
	private JInternalFrame AltaDeEspectaculoInternalFrame;
	private JInternalFrame ConsultaFuncionInternalFrame;
	private JInternalFrame RegistroFunEspectInternalFrame;
	private JInternalFrame CrearPaqueteInternalFrame;
	private JInternalFrame ConsultaPaqueteInternalFrame;
	private boolean datosyafueroncargados = false;
	private JInternalFrame AgregarEspectaculoInternalFrame;
	private JInternalFrame AltaCategoriaFrame;
	private JInternalFrame AceptarRechazarEspectFrame;
	private JInternalFrame ConsultarInfoFrame;
	

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
		Publicador p = new Publicador();
        p.publicar();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnUsuarios = new JMenu("Usuarios");
		menuBar.add(mnUsuarios);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Alta de Usuario");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				// aca hay que hacer visible la ventana del CU
				AltaUsuarioInternalFrame.setVisible(true);
			}
		});
		mnUsuarios.add(mntmNewMenuItem);

		JMenuItem mntmModUsuario = new JMenuItem("Modificar Usuario");
		mntmModUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				modificarDatosDeUsuarioInternalFrame = new modificarDatosUsuario();
				getContentPane().add(modificarDatosDeUsuarioInternalFrame);
				modificarDatosDeUsuarioInternalFrame.setResizable(true);
				modificarDatosDeUsuarioInternalFrame.setClosable(true);
				modificarDatosDeUsuarioInternalFrame.setMaximizable(true);
				modificarDatosDeUsuarioInternalFrame.setVisible(true);
			}
		});
		
		JMenuItem mntmConsultaDeDatosFix = new JMenuItem("Consulta de usuario");
		mntmConsultaDeDatosFix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConsultaUsuarioFixInternalFrame.setVisible(true);
			}
		});
		mnUsuarios.add(mntmConsultaDeDatosFix);
		
		mnUsuarios.add(mntmModUsuario);

		JMenu mnEspectaculos = new JMenu("Espectaculos");
		menuBar.add(mnEspectaculos);
		
		JMenuItem mntmAltaDeEspectaculo = new JMenuItem("Alta de espectaculo");
		mnEspectaculos.add(mntmAltaDeEspectaculo);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Alta de función de espectáculo");

		mntmAltaDeEspectaculo.addActionListener(new ActionListener() {             
			public void actionPerformed(ActionEvent evento) {                                 
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
		
		JMenuItem mntmRegistroAFuncion = new JMenuItem("Registro a funcion de espectaculo");
		mntmRegistroAFuncion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegistroFunEspectInternalFrame.setVisible(true);
			}
		});
		mnEspectaculos.add(mntmRegistroAFuncion);
		
		JMenuItem mntmConsultaFuncion = new JMenuItem("Consulta de función de espectaculo");
		mntmConsultaFuncion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConsultaFuncionInternalFrame.setVisible(true);
			}
		});
		mnEspectaculos.add(mntmConsultaFuncion);
		
		JMenuItem mntmConsultaDeEspectaculo = new JMenuItem("Consulta de espectaculo");
		mntmConsultaDeEspectaculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConsultaEspectaculoInternalFrame = new ConsultaEspectaculo();
		        ConsultaEspectaculoInternalFrame.setClosable(true);
				ConsultaEspectaculoInternalFrame.setVisible(true);
		        getContentPane().add(ConsultaEspectaculoInternalFrame, BorderLayout.CENTER);
			}
		});
		mnEspectaculos.add(mntmConsultaDeEspectaculo);
		
		
		
		JMenu mnPaquetes = new JMenu("Paquetes");
		menuBar.add(mnPaquetes);
		
		JMenuItem mntmCrearPaquete = new JMenuItem("Crear paquete");
		mnPaquetes.add(mntmCrearPaquete);
		
		mntmCrearPaquete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent aevent) {
				CrearPaqueteInternalFrame = new CrearPaquete();
				CrearPaqueteInternalFrame.setClosable(true);
				CrearPaqueteInternalFrame.setVisible(true);
				getContentPane().add(CrearPaqueteInternalFrame, BorderLayout.CENTER);
			}
		});

		JMenuItem mntmConsultaPaquete = new JMenuItem("Consultar Paquete");
		mnPaquetes.add(mntmConsultaPaquete);
		mntmConsultaPaquete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent aevent) {
				ConsultaPaqueteInternalFrame = new ConsultaPaquete();
				ConsultaPaqueteInternalFrame.setClosable(true);
				ConsultaPaqueteInternalFrame.setVisible(true);
				getContentPane().add(ConsultaPaqueteInternalFrame, BorderLayout.CENTER);
			}
		});

		JMenuItem mntmAgregarEspectaculo = new JMenuItem("Agregar Espectaculo a Paquete");
		mnPaquetes.add(mntmAgregarEspectaculo);
		mntmAgregarEspectaculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent aevent) {
				AgregarEspectaculoInternalFrame = new AgregarEspectaculo();
				AgregarEspectaculoInternalFrame.setClosable(true);
				AgregarEspectaculoInternalFrame.setVisible(true);
				getContentPane().add(AgregarEspectaculoInternalFrame, BorderLayout.CENTER);
			}
		});
		
		JMenuItem mntmAltaDeCategoria = new JMenuItem("Alta de categoria");
		mnEspectaculos.add(mntmAltaDeCategoria);
		
		
		mntmAltaDeCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AltaCategoriaFrame = new AltaCategoria();
				AltaCategoriaFrame.setClosable(true);
				AltaCategoriaFrame.setVisible(true);
				getContentPane().add(AltaCategoriaFrame, BorderLayout.CENTER);
				
			}
		});
		
		JMenuItem mntmAcpetarrechazarEspectaculo = new JMenuItem("Aceptar/Rechazar espectaculo");
		mntmAcpetarrechazarEspectaculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AceptarRechazarEspectFrame = new AceptarRechazarEspect();
				AceptarRechazarEspectFrame.setClosable(true);
				AceptarRechazarEspectFrame.setVisible(true);
				getContentPane().add(AceptarRechazarEspectFrame,BorderLayout.CENTER);
				
			}
		});
		mnEspectaculos.add(mntmAcpetarrechazarEspectaculo);
		
		JMenu mnAccesos = new JMenu("Accesos");
		menuBar.add(mnAccesos);
		
		JMenuItem mntmRegAccesos = new JMenuItem("Registro de Accesos al Sitio");
		mntmRegAccesos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				ConsultarInfoFrame = new ConsultarInfo();
				ConsultarInfoFrame.setClosable(true);
				ConsultarInfoFrame.setVisible(true);
				getContentPane().add(ConsultarInfoFrame,BorderLayout.CENTER);
				
			}
		
		});
		
		mnAccesos.add(mntmRegAccesos);
		
		////////

		JMenu mnPruebas = new JMenu("Pruebas");
		menuBar.add(mnPruebas);
		
		datosyafueroncargados = false;
		
		JMenuItem mntmCargarDatos = new JMenuItem("Cargar Datos");
		mntmCargarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				if (!datosyafueroncargados) {
				try {
					cargarDatos();
					datosyafueroncargados = true;
				} catch (NombreEspectaculoExisteException e1) {
					// TODO Auto-generated catch block
					System.out.print(e1.getMessage());
					e1.printStackTrace();
				} catch (UsuarioConMismoNickException e1) {
					// TODO Auto-generated catch block
					System.out.print(e1.getMessage());
					e1.printStackTrace();
				} catch (UsuarioConMismoMailException e1) {
					// TODO Auto-generated catch block
					System.out.print(e1.getMessage());
					e1.printStackTrace();
				} catch (NombreFuncionexisteException e1) {
					// TODO Auto-generated catch block
					System.out.print(e1.getMessage());
					e1.printStackTrace();
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					System.out.print(e1.getMessage());
					e1.printStackTrace();
				} catch (noSeleccionoTres e1) {
					// TODO Auto-generated catch block
					System.out.print(e1.getMessage());
					e1.printStackTrace();
				}
				} else {
					JOptionPane.showMessageDialog(null, "Los datos ya fueron cargados anteriormente.");
				}
			}
		});
		
		mnPruebas.add(mntmCargarDatos);
	
		//////////////////////////////////////////////////////////////////////////
		// EL CODIGO QUE SE AGREGA (SIN SER RESPUESTAS A EVENTOS) VA ACA ABAJO  //
        //////////////////////////////////////////////////////////////////////////
		
		ConsultarInfoFrame = new ConsultarInfo();
		ConsultarInfoFrame.setVisible(false);
        getContentPane().add(ConsultarInfoFrame);
        
        AltaUsuarioInternalFrame = new AltaUsuario();
        AltaUsuarioInternalFrame.setVisible(false);
        getContentPane().add(AltaUsuarioInternalFrame);
        
        
        ConsultaDeUsuarioInternalFrame = new ConsultaUsuario();
        ConsultaDeUsuarioInternalFrame.setVisible(false);
        getContentPane().add(ConsultaDeUsuarioInternalFrame);
        
        ConsultaUsuarioFixInternalFrame = new ConsultaUsuarioFix();
        ConsultaUsuarioFixInternalFrame.setVisible(false);
        getContentPane().add(ConsultaUsuarioFixInternalFrame);
        
        AltaFuncionInternalFrame = new AltaFuncionEspectaculo();
        AltaFuncionInternalFrame.setVisible(false);
        getContentPane().add(AltaFuncionInternalFrame);
        
        RegistroFunEspectInternalFrame = new RegistroAFuncionDeEspectaculo();
        RegistroFunEspectInternalFrame.setVisible(false);
        getContentPane().add(RegistroFunEspectInternalFrame);
        
        AltaDeEspectaculoInternalFrame = new AltaDeEspectaculo();
        AltaDeEspectaculoInternalFrame.setVisible(false);
        getContentPane().add(AltaDeEspectaculoInternalFrame);
        
        ConsultaFuncionInternalFrame = new ConsultaFuncionEspectaculo();
        ConsultaFuncionInternalFrame.setVisible(false);
        getContentPane().add(ConsultaFuncionInternalFrame);
        
        CrearPaqueteInternalFrame = new CrearPaquete();
        CrearPaqueteInternalFrame.setVisible(false);
        getContentPane().add(CrearPaqueteInternalFrame);

           
	
	}

	public void cargarDatos() throws UsuarioConMismoNickException, UsuarioConMismoMailException, NumberFormatException, NombreEspectaculoExisteException, NombreFuncionexisteException, noSeleccionoTres {
		// TODO Auto-generated method stub
		
		String EL = "eleven11";
		String CO = "costas";
		String EW = "waston";
		String GH = "house";
		String SP = "sergiop";
		String AR = "chino";
		String AP = "tonyp";
		String ML = "lachiqui";
		String CB = "cbochinche";
		
		String E1 = "Los Village Volvieron";
		String E2 = "Global Spirit";
		String E3 = "Memphis Blues World";
		String E4 = "Springsteen on Broadway";
		String E5 = "Bien de Familia";
		String E6 = "30 años";
		String E7 = "Grandes Éxitos 2020";
		String E8 = "Llega a Casa";
		String E9 = "Nochebuena con Alcides y amigos";
		String E10 = "Fin de Año con Alcides y amigos";
		
		
		
		Fabrica f = Fabrica.getInstance();
		IPlataforma pc = f.getIPlataforma();
		
		IUsuario uc = f.getIUsuario();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		
		
		String line = "nl";
		String splitBy = ";";
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("data/usuarios.csv"));
			while ((line = br.readLine()) != null)
			{
				String[] usuario = line.split(splitBy);
				uc.altaUsuario(usuario[0], usuario[1], usuario[2], usuario[3], LocalDate.parse(usuario[4], formatter));
				uc.confirmarAltaUsuario();
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		};

		//carga artistas.
		try   
		{  
		//parsing a CSV file into BufferedReader class constructor  
			BufferedReader br = new BufferedReader(new FileReader("data/artistas.csv"));  
			while ((line = br.readLine()) != null)   //returns a Boolean value  
			{  
			String[] artista = line.split(splitBy);    // use comma as separator  
			uc.altaUsuario(artista[0], artista[2], artista[3], artista[1], LocalDate.parse(artista[4], formatter));
			uc.altaArtista(artista[5], artista[6], artista[7]);
			uc.confirmarAltaUsuario();
			} 
			br.close();
		} catch (IOException e) {  
			e.printStackTrace();  
		};

		IEspectaculo ec = f.getIEspectaculo();
		try{
			BufferedReader br = new BufferedReader(new FileReader("data/plataformas.csv"));
			while ((line = br.readLine()) != null)
			{
				String[] plataforma = line.split(splitBy);
				pc.altaPlataforma(plataforma[0], plataforma[1], plataforma[2]);
				pc.confirmarAltaPlataforma();
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		};

		splitBy = ";";
		try {
			BufferedReader br = new BufferedReader(new FileReader("data/espectaculos.csv"));
			while ((line = br.readLine()) != null)
			{
				String[] espectaculo = line.split(splitBy);
				ec.altaEspectaculo(espectaculo[1], espectaculo[0], espectaculo[2], espectaculo[3], String2LocalTime(espectaculo[4]), Integer.parseInt(espectaculo[5]), Integer.parseInt(espectaculo[6]), espectaculo[7], Float.parseFloat(espectaculo[8]), LocalDate.parse(espectaculo[9], formatter));
				ec.confirmarAltaEspectaculo();
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		};
		
		ec.aceptarRechazar("Los Village Volvieron", true);
		ec.aceptarRechazar("Global Spirit", true);
		ec.aceptarRechazar("Memphis Blues World", true);
		ec.aceptarRechazar("Springsteen on Broadway", true);
		ec.aceptarRechazar("Bien de Familia", true);
		ec.aceptarRechazar("30 años", true);
		ec.aceptarRechazar("Grandes Éxitos 2020", true);
		ec.aceptarRechazar("Llega a Casa", true);
		ec.aceptarRechazar("Fin de Año con Alcides y amigos", false);
		
		HandlerEspectaculos handlerE = HandlerEspectaculos.getInstance();

		handlerE.getEspectaculo("Global Spirit").setFinalizado(true);
		handlerE.getEspectaculo("30 años").setFinalizado(true);
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("data/funciones.csv"));
			while ((line = br.readLine()) != null)
			{
				String[] funcion = line.split(splitBy);
				String[] artistax = funcion[5].split(",");
				ArrayList<String> artistas = new ArrayList<String>();
				for(String s:artistax) {
					if (!s.equals("n/a")){
						 artistas.add(s);
					}
				}
				ec.elegirEspectaculo(funcion[4]);
				ec.altaFuncion(funcion[0], LocalDate.parse(funcion[1], formatter), LocalTime.parse(funcion[2]),artistas, LocalDate.parse(funcion[3], formatter));		
				ec.confirmarAltaFuncion();
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		IPaquete pqc = f.getIPaquete();

		try {
			BufferedReader br = new BufferedReader(new FileReader("data/paquetes.csv"));
			while ((line = br.readLine()) != null)
			{
				String[] paquete = line.split(splitBy);
				try{
				pqc.crearPaqueteWeb(paquete[0], paquete[1], LocalDate.parse(paquete[3],formatter), LocalDate.parse(paquete[4],formatter), Integer.parseInt(paquete[2]), LocalDate.parse(paquete[5], formatter), paquete[6]);
				} catch(Exception e) {
					System.out.print(e.getMessage());
					e.printStackTrace();
				}
				pqc.confirmarCrearPaquete();
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Agrega Espectaculos a Paquete
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("data/espectaculoEnPaquete.csv"));
			while ((line = br.readLine()) != null)
			{
				String[] espac = line.split(splitBy);
				try{
					pqc.seleccionarPaquete(espac[0]);
					pqc.elegirEspectaculo(espac[1]);
					pqc.confirmarAgregarEspectAPaquete();;
				} catch(Exception e) {
					System.out.print(e.getMessage());
					e.printStackTrace();
				}
				pqc.confirmarCrearPaquete();
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		//Compras de paquete
		
		formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
		
		HandlerPaquetes hpaq = HandlerPaquetes.getInstance();
		HandlerUsuarios hu = HandlerUsuarios.getInstancia();
		
		try {
			hu.getUsuario("tonyp").agregarcompra(new Compra(LocalDate.parse("01/05/20",formatter), hpaq.getPaquete("Paquete de Bandas")));
			hu.getUsuario("lachiqui").agregarcompra(new Compra(LocalDate.parse("20/05/20",formatter), hpaq.getPaquete("Paquete de Bandas")));
			
			hu.getUsuario("costas").agregarcompra(new Compra(LocalDate.parse("08/09/20",formatter), hpaq.getPaquete("Paquete Latino")));

			hu.getUsuario("eleven11").agregarcompra(new Compra(LocalDate.parse("16/08/20",formatter), hpaq.getPaquete("Paquete Solistas")));
			hu.getUsuario("waston").agregarcompra(new Compra(LocalDate.parse("26/08/20",formatter), hpaq.getPaquete("Paquete Solistas")));

			
			
			hu.getUsuario("cbochinche").agregarcompra(new Compra(LocalDate.parse("25/11/20",formatter), hpaq.getPaquete("La Triple Dyango")));
			hu.getUsuario("lachiqui").agregarcompra(new Compra(LocalDate.parse("26/11/20",formatter), hpaq.getPaquete("La Triple Dyango")));
		} catch (UsuarioPaqueteComprado | NoExistePaqueteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//este es R1
		ec.ingresarNombreFuncion("Los Village Volvieron - 1");
		ec.ingresarNombreEspectador("costas");
		ec.confirmarRegistro("Los Village Volvieron", LocalDate.parse("09/04/20",formatter));
		//R2
		ec.ingresarNombreFuncion("Los Village Volvieron - 1");
		ec.ingresarNombreEspectador("sergiop");
		ec.confirmarRegistro("Los Village Volvieron", LocalDate.parse("10/04/20",formatter));
		//R3
		ec.ingresarNombreFuncion("Los Village Volvieron - 1");
		ec.ingresarNombreEspectador("chino");
		ec.confirmarRegistro("Los Village Volvieron", LocalDate.parse("12/04/20",formatter));
		//R4
		ec.ingresarNombreFuncion("Los Village Volvieron - 2");
		ec.ingresarNombreEspectador("chino");
		ec.confirmarRegistro("Los Village Volvieron", LocalDate.parse("15/04/20",formatter));
		//R5
		ec.ingresarNombreFuncion("Los Village Volvieron - 2");
		ec.ingresarNombreEspectador("tonyp");
		ec.confirmarRegistro("Los Village Volvieron", LocalDate.parse("20/04/20",formatter));
		//R6
		ec.ingresarNombreFuncion("Los Village Volvieron - 2");
		ec.ingresarNombreEspectador("costas");
		ec.confirmarRegistro("Los Village Volvieron", LocalDate.parse("25/04/20",formatter));
		//R7
		ec.ingresarNombreFuncion("Los Village Volvieron - 2");
		ec.ingresarNombreEspectador("lachiqui");
		ec.confirmarRegistro("Los Village Volvieron", LocalDate.parse("28/04/20",formatter));
		//R8
		ec.ingresarNombreFuncion("Los Village Volvieron - 3");
		ec.ingresarNombreEspectador("sergiop");
		ec.confirmarRegistro("Los Village Volvieron", LocalDate.parse("16/04/20",formatter));
		//R9
		ec.ingresarNombreFuncion("Los Village Volvieron - 3");
		ec.ingresarNombreEspectador("costas");
		ec.confirmarRegistro("Los Village Volvieron", LocalDate.parse("15/05/20",formatter));
		//R10
		ec.ingresarNombreFuncion("Los Village Volvieron - 3");
		ec.ingresarNombreEspectador("lachiqui");
		ec.confirmarRegistro("Los Village Volvieron", LocalDate.parse("20/05/20",formatter));
		//R11
		ec.ingresarNombreFuncion("Global Spirit (I)");
		ec.ingresarNombreEspectador("lachiqui");
		ec.confirmarRegistro("Global Spirit", LocalDate.parse("05/05/20",formatter));
		//R12
		ec.ingresarNombreFuncion("Global Spirit (I)");
		ec.ingresarNombreEspectador("waston");
		ec.confirmarRegistro("Global Spirit", LocalDate.parse("10/05/20",formatter));
		//R13
		ec.ingresarNombreFuncion("Global Spirit (I)");
		ec.ingresarNombreEspectador("sergiop");
		ec.confirmarRegistro("Global Spirit", LocalDate.parse("15/05/20",formatter));
		//R14
		ec.ingresarNombreFuncion("Global Spirit (I)");
		ec.ingresarNombreEspectador("tonyp");
		ec.confirmarRegistro("Global Spirit", LocalDate.parse("20/05/20",formatter));
		//R15
		ec.ingresarNombreFuncion("Global Spirit (II)");
		ec.ingresarNombreEspectador("house");
		ec.confirmarRegistro("Global Spirit", LocalDate.parse("08/06/20",formatter));
		//R16
		ec.ingresarNombreFuncion("Global Spirit (II)");
		ec.ingresarNombreEspectador("waston");
		ec.confirmarRegistro("Global Spirit", LocalDate.parse("13/06/20",formatter));
		//R17
		ec.ingresarNombreFuncion("Global Spirit (II)");
		ec.ingresarNombreEspectador("lachiqui");
		ec.confirmarRegistro("Global Spirit", LocalDate.parse("25/06/20",formatter));
		//R18
		ec.ingresarNombreFuncion("Global Spirit (III)");
		ec.ingresarNombreEspectador("cbochinche");
		ec.confirmarRegistro("Global Spirit", LocalDate.parse("05/07/20",formatter));
		//R19
		ec.ingresarNombreFuncion("Global Spirit (III)");
		ec.ingresarNombreEspectador("sergiop");
		ec.confirmarRegistro("Global Spirit", LocalDate.parse("11/07/20",formatter));
		//R20
		ec.ingresarNombreFuncion("Global Spirit (III)");
		ec.ingresarNombreEspectador("chino");
		ec.confirmarRegistro("Global Spirit", LocalDate.parse("18/07/20",formatter));
		//R21
		ec.ingresarNombreFuncion("Memphis Blues World - A");
		ec.ingresarNombreEspectador("lachiqui");
		List<DtRegistro> registros = ec.obtenerRegistrosPrevios();
		int[] registrosFiltrados = new int[3];
		for (int i = 0; i < registros.size(); i++) {
			if(registros.get(i).getId() == 7)
				registrosFiltrados[0] = registros.get(i).getId();
			if(registros.get(i).getId() == 10)
				registrosFiltrados[1] = registros.get(i).getId();
			if(registros.get(i).getId() == 17)
				registrosFiltrados[2] = registros.get(i).getId();
		}
		ec.canjearRegistros(registrosFiltrados);
		ec.confirmarRegistro("Memphis Blues World", LocalDate.parse("19/07/20",formatter));
		//esto se hace solo si se canjean
		
		//R22
		ec.ingresarNombreFuncion("Memphis Blues World - B");
		ec.ingresarNombreEspectador("eleven11");
		ec.confirmarRegistro("Memphis Blues World", LocalDate.parse("17/08/20",formatter));
		//R23
		ec.ingresarNombreFuncion("Memphis Blues World - B");
		ec.ingresarNombreEspectador("house");
		ec.confirmarRegistro("Memphis Blues World", LocalDate.parse("20/08/20",formatter));
		//R24
		ec.ingresarNombreFuncion("Memphis Blues World - B");
		ec.ingresarNombreEspectador("chino");
		ec.confirmarRegistro("Memphis Blues World", LocalDate.parse("23/08/20",formatter));
		//R25
		ec.ingresarNombreFuncion("Memphis Blues World - C");
		ec.ingresarNombreEspectador("costas");
		registros = ec.obtenerRegistrosPrevios();
		for (int i = 0; i < registros.size(); i++) {
			if(registros.get(i).getId() == 1)
				registrosFiltrados[0] = registros.get(i).getId();
			if(registros.get(i).getId() == 6)
				registrosFiltrados[1] = registros.get(i).getId();
			if(registros.get(i).getId() == 9)
				registrosFiltrados[2] = registros.get(i).getId();
		}
		ec.canjearRegistros(registrosFiltrados);
		ec.confirmarRegistro("Memphis Blues World", LocalDate.parse("15/08/20",formatter));
		
		//R26
		ec.ingresarNombreFuncion("Memphis Blues World - C");
		ec.ingresarNombreEspectador("eleven11");
		ec.confirmarRegistro("Memphis Blues World", LocalDate.parse("26/08/20",formatter));
		//R27
		ec.ingresarNombreFuncion("Springsteen on Broadway - i");
		ec.ingresarNombreEspectador("chino");
		registros = ec.obtenerRegistrosPrevios();
		for (int i = 0; i < registros.size(); i++) {
			if(registros.get(i).getId() == 3)
				registrosFiltrados[0] = registros.get(i).getId();
			if(registros.get(i).getId() == 4)
				registrosFiltrados[1] = registros.get(i).getId();
			if(registros.get(i).getId() == 20)
				registrosFiltrados[2] = registros.get(i).getId();
		}
		ec.canjearRegistros(registrosFiltrados);
		ec.confirmarRegistro("Springsteen on Broadway", LocalDate.parse("19/07/20",formatter));
		
		//R28
		ec.ingresarNombreFuncion("Springsteen on Broadway - i");
		ec.ingresarNombreEspectador("tonyp");
		ec.confirmarRegistro("Springsteen on Broadway", LocalDate.parse("16/08/20",formatter));
		//R29
		ec.ingresarNombreFuncion("Springsteen on Broadway - i");
		ec.ingresarNombreEspectador("lachiqui");
		ec.confirmarRegistro("Springsteen on Broadway", LocalDate.parse("24/08/20",formatter));
		
		
		//R30
		ec.ingresarNombreFuncion("Springsteen on Broadway - ii");
		ec.ingresarNombreEspectador("sergiop");
		registros = ec.obtenerRegistrosPrevios();
		for (int i = 0; i < registros.size(); i++) {
			if(registros.get(i).getId() == 2)
				registrosFiltrados[0] = registros.get(i).getId();
			if(registros.get(i).getId() == 13)
				registrosFiltrados[1] = registros.get(i).getId();
			if(registros.get(i).getId() == 19)
				registrosFiltrados[2] = registros.get(i).getId();
		}
		ec.canjearRegistros(registrosFiltrados);
		ec.confirmarRegistro("Springsteen on Broadway", LocalDate.parse("01/08/20",formatter));
		
		//R31
		ec.ingresarNombreFuncion("Springsteen on Broadway - ii");
		ec.ingresarNombreEspectador("house");
		ec.confirmarRegistro("Springsteen on Broadway", LocalDate.parse("30/08/20",formatter));
		//R32
		ec.ingresarNombreFuncion("Springsteen on Broadway - iii");
		ec.ingresarNombreEspectador("eleven11");
		ec.confirmarRegistro("Springsteen on Broadway", LocalDate.parse("16/08/20",formatter));
		//R33
		ec.ingresarNombreFuncion("Springsteen on Broadway - iii");
		ec.ingresarNombreEspectador("costas");
		ec.confirmarRegistro("Springsteen on Broadway", LocalDate.parse("16/08/20",formatter));
		//R34
		ec.ingresarNombreFuncion("Springsteen on Broadway - iii");
		ec.ingresarNombreEspectador("waston");
		ec.confirmarRegistro("Springsteen on Broadway", LocalDate.parse("01/09/20",formatter));
		//R35
		ec.ingresarNombreFuncion("Springsteen on Broadway - iii");
		ec.ingresarNombreEspectador("sergiop");
		ec.confirmarRegistro("Springsteen on Broadway", LocalDate.parse("05/09/20",formatter));
		//R36
		ec.ingresarNombreFuncion("Bien de Familia - A");
		ec.ingresarNombreEspectador("house");
		ec.confirmarRegistro("Bien de Familia", LocalDate.parse("16/08/20",formatter));
		//R37
		ec.ingresarNombreFuncion("Bien de Familia - A");
		ec.ingresarNombreEspectador("cbochinche");
		ec.confirmarRegistro("Bien de Familia", LocalDate.parse("03/09/20",formatter));
		//R38
		ec.ingresarNombreFuncion("Bien de Familia - B");
		ec.ingresarNombreEspectador("eleven11");
		ec.confirmarRegistro("Bien de Familia", LocalDate.parse("16/08/20",formatter));
		//R39
		ec.ingresarNombreFuncion("Bien de Familia - B");
		ec.ingresarNombreEspectador("cbochinche");
		ec.confirmarRegistro("Bien de Familia", LocalDate.parse("06/09/20",formatter));
		//R40
		ec.ingresarNombreFuncion("Bien de Familia - C");
		ec.ingresarNombreEspectador("costas");
		ec.confirmarRegistro("Bien de Familia", LocalDate.parse("01/09/20",formatter));
		//R41
		ec.ingresarNombreFuncion("30 años - 1");
		ec.ingresarNombreEspectador("sergiop");
		ec.confirmarRegistro("30 años", LocalDate.parse("16/08/20",formatter));
		//R42
		ec.ingresarNombreFuncion("30 años - 1");
		ec.ingresarNombreEspectador("eleven11");
		ec.confirmarRegistro("30 años", LocalDate.parse("20/08/20",formatter));
		//R43
		ec.ingresarNombreFuncion("30 años - 1");
		ec.ingresarNombreEspectador("tonyp");
		ec.confirmarRegistro("30 años", LocalDate.parse("31/08/20",formatter));
		//R44
		ec.ingresarNombreFuncion("30 años - 2");
		ec.ingresarNombreEspectador("chino");
		ec.confirmarRegistro("30 años", LocalDate.parse("16/08/20",formatter));
		//R45
		ec.ingresarNombreFuncion("30 años - 2");
		ec.ingresarNombreEspectador("tonyp");
		ec.confirmarRegistro("30 años", LocalDate.parse("20/08/20",formatter));
		//R46
		ec.ingresarNombreFuncion("30 años - 2");
		ec.ingresarNombreEspectador("costas");
		ec.confirmarRegistro("30 años", LocalDate.parse("02/09/20",formatter));
		//R47
		ec.ingresarNombreFuncion("Grandes Éxitos 2020 - Dia");
		ec.ingresarNombreEspectador("cbochinche");
		ec.ingresarNombrePaquete("Grandes Éxitos 2020");
		ec.canjePorVale();
		ec.confirmarRegistro("Grandes Éxitos 2020", LocalDate.parse("26/11/20",formatter));	
		//R48
		ec.ingresarNombreFuncion("Grandes Éxitos 2020 - Dia");
		ec.ingresarNombreEspectador("costas");
		ec.confirmarRegistro("Grandes Éxitos 2020", LocalDate.parse("27/11/20",formatter));
		//R49
		ec.ingresarNombreFuncion("Grandes Éxitos 2020 - Dia");
		ec.ingresarNombreEspectador("lachiqui");
		ec.ingresarNombrePaquete("Grandes Éxitos 2020");
		ec.canjePorVale();
		ec.confirmarRegistro("Grandes Éxitos 2020", LocalDate.parse("28/11/20",formatter));
		
		
		// setear contraseñas a 1234
		for (Usuario u : hu.getUsuarios().values()) {
			u.setPassword("1234");
		}
		// cargar imagenes custom a usuarios y artistas
		hu.getUsuario("waston").setImagen("resources/media/usuarios/Emma-Watson-1.jpg");
		hu.getUsuario("vpeople").setImagen("https://upload.wikimedia.org/wikipedia/commons/2/21/VillagePeople1978.jpg");
		hu.getUsuario("dmode").setImagen("https://bit.ly/2GB7vME");
		hu.getUsuario("house").setImagen("https://upload.wikimedia.org/wikipedia/en/1/14/HouseCastSeason1.jpg");
		hu.getUsuario("chino").setImagen("resources/media/usuarios/userdefault2.jpg");
		hu.getUsuario("lospimpi").setImagen("resources/media/usuarios/turbinela.jpg");
		// cargar imagenes custom a espectaculos
		HandlerEspectaculos he = HandlerEspectaculos.getInstance();
		he.getEspectaculo("Springsteen on Broadway").setImagen("resources/media/espectaculos/springsteen.jpg");
		he.getEspectaculo("Los Village Volvieron").setImagen("resources/media/espectaculos/villagetour.jpg");
		he.getEspectaculo("Bien de Familia").setImagen("resources/media/espectaculos/turbinela2.jpg");
		// cargar imagenes a paquetes
		HandlerPaquetes hp = HandlerPaquetes.getInstance();
		try {
			hp.getPaquete("Paquete de Bandas").setImagen("resources/media/paquetes/bandas.jpg");
		} catch (NoExistePaqueteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			hp.getPaquete("Paquete Solistas").setImagen("resources/media/paquetes/solistas.jpg");
		} catch (NoExistePaqueteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			hp.getPaquete("Paquete Latino").setImagen("resources/media/paquetes/latino.jpeg");
		} catch (NoExistePaqueteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			hp.getPaquete("La Triple Dyango").setImagen("resources/media/paquetes/triple.jpg");
		} catch (NoExistePaqueteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// crear categorias
		HandlerCategorias hc = HandlerCategorias.getInstance();
		hc.agregarCategoria("Bandas Latinas");
		hc.agregarCategoria("Solistas");
		hc.agregarCategoria("Rock en Ingles");
		hc.agregarCategoria("Musica Tropical");
		// setear categorias a espectaculos
		
		he.agregarCategoriaAEspectaculo("Los Village Volvieron","Rock en Ingles");
		he.agregarCategoriaAEspectaculo("Global Spirit","Rock en Ingles");
		he.agregarCategoriaAEspectaculo("Memphis Blues World","Solistas");
		he.agregarCategoriaAEspectaculo("Springsteen on Broadway","Rock en Ingles");
		he.agregarCategoriaAEspectaculo("Bien de Familia","Bandas Latinas");
		he.agregarCategoriaAEspectaculo("30 años","Musica Tropical");
		he.agregarCategoriaAEspectaculo("Grandes Éxitos 2020","Solistas");
		he.agregarCategoriaAEspectaculo("Llega a Casa","Bandas Latinas");
		he.agregarCategoriaAEspectaculo("Noche buena con Alcides y amigos", "Música Tropical");
		he.agregarCategoriaAEspectaculo("Fin de Año con Alcides y amigos", "Música Tropical");
		
		/* 	EL eleven11
			CO costas
			EW waston
			GH house
			SP sergiop
			AR chino
			AP tonyp
			ML lachiqui
			CB cbochinche
		
		*/
		try {
		he.getEspectaculo("Los Village Volvieron").agregarValoracion(5, "chino");
		he.getEspectaculo("Los Village Volvieron").agregarValoracion(2, "tonyp");
		he.getEspectaculo("Los Village Volvieron").agregarValoracion(3, "costas");
		he.getEspectaculo("Los Village Volvieron").agregarValoracion(4, "chiqui");
		
		
		he.getEspectaculo("Global Spirit").agregarValoracion(4, "eleven11");
		he.getEspectaculo("Global Spirit").agregarValoracion(1, "waston");
		he.getEspectaculo("Global Spirit").agregarValoracion(2, "sergiop");
		he.getEspectaculo("Global Spirit").agregarValoracion(2, "tonyp");
		he.getEspectaculo("Global Spirit").agregarValoracion(5, "cbochinche");
		
		he.getEspectaculo("Memphis Blues World").agregarValoracion(2, "eleven11");
		he.getEspectaculo("Memphis Blues World").agregarValoracion(4, "house");
		he.getEspectaculo("Memphis Blues World").agregarValoracion(2, "chino");
		/* 	EL eleven11
		CO costas
		EW waston
		GH house
		SP sergiop
		AR chino
		AP tonyp
		ML lachiqui
		CB cbochinche
	
	*/
		he.getEspectaculo("Springsteen on Broadway").agregarValoracion(3, "sergiop");
		he.getEspectaculo("Springsteen on Broadway").agregarValoracion(4, "house");
		he.getEspectaculo("Springsteen on Broadway").agregarValoracion(2, "eleven11");
		he.getEspectaculo("Springsteen on Broadway").agregarValoracion(1, "costas");
		he.getEspectaculo("Springsteen on Broadway").agregarValoracion(5, "waston");
		
		he.getEspectaculo("Bien de Familia").agregarValoracion(1, "house");
		he.getEspectaculo("Bien de Familia").agregarValoracion(4, "cbochinche");
		
		he.getEspectaculo("30 años").agregarValoracion(5, "chino");
		he.getEspectaculo("30 años").agregarValoracion(3, "tonyp");
		he.getEspectaculo("30 años").agregarValoracion(2, "costas");
		
		he.getEspectaculo("Los Village Volvieron").setDescPremio("Meet & greet (encuentro) virtual con integrantes de Village People y unaccesorio de indumentaria de la banda que será elegido por el ganador,como ser el penacho de plumas del jefe indio (sujeto a disponibilidad).Info: https://bit.ly/sorteovp");
		he.getEspectaculo("Los Village Volvieron").setCantPremios(2);
		he.getEspectaculo("Los Village Volvieron").setVideo("N8FxU1nmLWg");
		
		
		he.getEspectaculo("Global Spirit").setDescPremio("Box Set multimedia “Depeche Mode: SPIRITS in the Forest”, quesigue a la banda en su Global Spirit Tour 2017/2018, que vio aDepeche Mode tocar para más de 3 millones de fanáticos en 115shows en todo el mundo. El Box Set contiene 2 CDs y 2 DVDs o 2CDs y 1 Blu-ray (a elección). Info: https://bit.ly/sorteodm");
		he.getEspectaculo("Global Spirit").setCantPremios(3);
		he.getEspectaculo("Global Spirit").setVideo("2qxcr6T9pNM");

		he.getEspectaculo("Memphis Blues World").setDescPremio("Meet & greet (encuentro) virtual con la legendaria cantante e ícono del Pop, que inspiró a tantas otras cantante femeninas como Madonna y Lady Gaga (aunque ellas jamás lo admitirían).");
		he.getEspectaculo("Memphis Blues World").setCantPremios(2);
		he.getEspectaculo("Memphis Blues World").setVideo("ivHp3_gYXIc");
		
		he.getEspectaculo("Springsteen on Broadway").setDescPremio("Album completo “Springsteen On Broadway” en formato MP3 o CD (aelección). Info: https://bit.ly/sorteobs");
		he.getEspectaculo("Springsteen on Broadway").setCantPremios(2);
		he.getEspectaculo("Springsteen on Broadway").setVideo("M1xDzgob1JI");
		
		he.getEspectaculo("Bien de Familia").setDescPremio("¿Es cierto que son hermanos? ¿La voz de Lucía puede romper una copade cristal? ¿Joaquín quiere dejar Pimpinela y ser el vocalista de unabanda de heavy metal? Todas estas preguntas y muchas más podrás hacérselas  a  tus  ídolos  en  un  encuentro  on-line   exclusivo  para losganadores de este sorteo.");
		he.getEspectaculo("Bien de Familia").setCantPremios(1);
		he.getEspectaculo("Bien de Familia").setVideo("dPSlBRg0HeA");
		
		he.getEspectaculo("30 años").setDescPremio("Entrada en platea VIP para el primer show   presencial   que   realiceAlcides a partir de enero de 2021 (una vez que el artista haya recibidola vacuna contra el SARS-COV-2), más 1 litro de Fernet de marca aconfirmar.");
		he.getEspectaculo("30 años").setCantPremios(3);
		he.getEspectaculo("30 años").setVideo("65Pu6WP0bag");

		he.getEspectaculo("Grandes Éxitos 2020").setDescPremio("Album completo “Y Ahora Que” para descargar en formato FLAC (24bits, 44.1 kHz). Info: https://bit.ly/sorteody");
		he.getEspectaculo("Grandes Éxitos 2020").setCantPremios(2);
		he.getEspectaculo("Grandes Éxitos 2020").setVideo("NxFeibjFt3k");

		
		he.getEspectaculo("Llega a Casa").setDescPremio("Entrada doble para espectáculo “Mi Bien” a realizarse en el AuditorioNacional del SODRE.");
		he.getEspectaculo("Llega a Casa").setCantPremios(2);
		he.getEspectaculo("Llega a Casa").setVideo("m7r3YIFRI3k");
		
		he.getEspectaculo("Noche buena con Alcides y amigos").setVideo("65Pu6WP0bag");

		he.getEspectaculo("Fin de Año con Alcides y amigos").setVideo("65Pu6WP0bag");
		
		
		cargarGanador("Memphis Blues World", "eleven11","Memphis Blues World - B");
		cargarGanador("Memphis Blues World", "house","Memphis Blues World - B");
		
		cargarGanador("Memphis Blues World", "lachiqui","Memphis Blues World - A");

		
		cargarGanador("Memphis Blues World", "waston","Memphis Blues World - C");
		cargarGanador("Memphis Blues World", "eleven11","Memphis Blues World - C");
		
		
		cargarGanador("Grandes Éxitos 2020", "sergiop","Grandes Éxitos 2020 - Dia");
		cargarGanador("Grandes Éxitos 2020", "eleven11","Grandes Éxitos 2020 - Dia");
		cargarGanador("Grandes Éxitos 2020", "tonyp","Grandes Éxitos 2020 - Dia");

		cargarGanador("Grandes Éxitos 2020", "chino","Grandes Éxitos 2020 - Noche");
		cargarGanador("Grandes Éxitos 2020", "tonyp","Grandes Éxitos 2020 - Noche");
		cargarGanador("Grandes Éxitos 2020", "costas","Grandes Éxitos 2020 - Noche");
			
		agregarFav(EL, E2);
		agregarFav(EL, E6);
		agregarFav(CO, E1);
		agregarFav(CO, E2);
		agregarFav(CO, E3);
		agregarFav(EW, E4);
		agregarFav(GH, E3);
		agregarFav(GH, E4);
		agregarFav(SP, E4);
		agregarFav(SP, E6);
		agregarFav(AR, E1);
		agregarFav(AR, E2);
		agregarFav(AR, E6);
		agregarFav(AP, E5);
		agregarFav(ML, E1);
		agregarFav(CB, E2);
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Datos de prueba cargados con exito.");	
    // aca termina el cargar datos
    }
	
	private void agregarFav(String nomU, String nomE) {
		HandlerUsuarios hu = HandlerUsuarios.getInstancia();
		Espectaculo espec = HandlerEspectaculos.getInstance().getEspectaculo(nomE);
		hu.getUsuario(nomU).agregarFavorito(espec);
	}
	
	private void cargarGanador(String espec, String user, String nomFun) {
		HandlerEspectaculos he = HandlerEspectaculos.getInstance();
		HandlerUsuarios hu = HandlerUsuarios.getInstancia();
		
		Espectaculo esp = he.getEspectaculo(espec);
		Funcion fun = esp.getFuncion(nomFun);
		Premio p = new Premio(LocalDate.of(2020, 8, 17));
		p.setDescripcion(esp.getDescPremio());
		p.setFuncion(fun);
		
		fun.setPremio(p);
		fun.setFueSorteado(true);
		
		List<Usuario> ganadores = fun.getPremiados();
		ganadores.add(hu.getUsuario(user));
		
		fun.setPremiados(ganadores);
		hu.getUsuario(user).agregarPremio(p);
	}
	
	
	public static LocalTime String2LocalTime(String str){
		return LocalTime.of(Integer.parseInt(str) / 60, Integer.parseInt(str) % 60);
	}
}
