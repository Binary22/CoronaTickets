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
import excepciones.NombreEspectaculoExisteException;
import excepciones.NombreFuncionexisteException;
import excepciones.UsuarioConMismoMailException;
import excepciones.UsuarioConMismoNickException;
import excepciones.noSeleccionoTres;
import logica.Fabrica;
import logica.IEspectaculo;
import logica.IPaquete;
import logica.IPlataforma;
import logica.IUsuario;

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
		
		JMenuItem mntmAcpetarrechazarEspectaculo = new JMenuItem("Acpetar/Rechazar espectaculo");
		mntmAcpetarrechazarEspectaculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AceptarRechazarEspectFrame = new AceptarRechazarEspect();
				AceptarRechazarEspectFrame.setClosable(true);
				AceptarRechazarEspectFrame.setVisible(true);
				getContentPane().add(AceptarRechazarEspectFrame,BorderLayout.CENTER);
				
			}
		});
		mnEspectaculos.add(mntmAcpetarrechazarEspectaculo);
		
		

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

	public static void cargarDatos() throws UsuarioConMismoNickException, UsuarioConMismoMailException, NumberFormatException, NombreEspectaculoExisteException, NombreFuncionexisteException, noSeleccionoTres {
		// TODO Auto-generated method stub
		Fabrica fab = Fabrica.getInstance();
		IPlataforma iPlat = fab.getIPlataforma();
		
		IUsuario iUser = fab.getIUsuario();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		
		String line = "nl";
		String splitBy = ";";
		try
		{
			BufferedReader bRead = new BufferedReader(new FileReader("data/usuarios.csv"));
			while ((line = bRead.readLine()) != null)
			{
				String[] usuario = line.split(splitBy);
				iUser.altaUsuario(usuario[0], usuario[1], usuario[2], usuario[3], LocalDate.parse(usuario[4], formatter));
				iUser.confirmarAltaUsuario();
			}
			bRead.close();
		} catch (IOException e) {
			e.printStackTrace();
		};

		//carga artistas.
		try   
		{  
		//parsing a CSV file into BufferedReader class constructor  
			BufferedReader bRead = new BufferedReader(new FileReader("data/artistas.csv"));  
			while ((line = bRead.readLine()) != null)   //returns a Boolean value  
			{  
			String[] artista = line.split(splitBy);    // use comma as separator  
			iUser.altaUsuario(artista[0], artista[2], artista[3], artista[1], LocalDate.parse(artista[4], formatter));
			iUser.altaArtista(artista[5], artista[6], artista[7]);
			iUser.confirmarAltaUsuario();
			} 
			bRead.close();
		} catch (IOException e) {  
			e.printStackTrace();  
		};

		IEspectaculo iEspect = fab.getIEspectaculo();
		try{
			BufferedReader bRead = new BufferedReader(new FileReader("data/plataformas.csv"));
			while ((line = bRead.readLine()) != null)
			{
				String[] plataforma = line.split(splitBy);
				iPlat.altaPlataforma(plataforma[0], plataforma[1], plataforma[2]);
				iPlat.confirmarAltaPlataforma();
			}
			bRead.close();
		} catch (IOException e) {
			e.printStackTrace();
		};

		splitBy = ";";
		try {
			BufferedReader bRead = new BufferedReader(new FileReader("data/espectaculos.csv"));
			while ((line = bRead.readLine()) != null)
			{
				String[] espectaculo = line.split(splitBy);
				iEspect.altaEspectaculo(espectaculo[1], espectaculo[0], espectaculo[2], espectaculo[3], String2LocalTime(espectaculo[4]), Integer.parseInt(espectaculo[5]), Integer.parseInt(espectaculo[6]), espectaculo[7], Float.parseFloat(espectaculo[8]), LocalDate.parse(espectaculo[9], formatter));
				iEspect.confirmarAltaEspectaculo();
			}
			bRead.close();
		} catch (IOException e) {
			e.printStackTrace();
		};

		try {
			BufferedReader bRead = new BufferedReader(new FileReader("data/funciones.csv"));
			while ((line = bRead.readLine()) != null)
			{
				String[] funcion = line.split(splitBy);
				String[] artistax = funcion[5].split(",");
				ArrayList<String> artistas = new ArrayList<String>();
				for(String s:artistax) {
					if (!s.equals("n/a")){
						 artistas.add(s);
					}
				}
				iEspect.elegirEspectaculo(funcion[4]);
				iEspect.altaFuncion(funcion[0], LocalDate.parse(funcion[1], formatter), LocalTime.parse(funcion[2]),artistas, LocalDate.parse(funcion[3], formatter));		
				iEspect.confirmarAltaFuncion();
			}
			bRead.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		IPaquete pqc = fab.getIPaquete();

		try {
			BufferedReader bRead = new BufferedReader(new FileReader("data/paquetes.csv"));
			while ((line = bRead.readLine()) != null)
			{
				String[] paquete = line.split(splitBy);
				try{
				pqc.crearPaquete(paquete[0], paquete[1], LocalDate.parse(paquete[3],formatter), LocalDate.parse(paquete[4],formatter), Integer.parseInt(paquete[2]), LocalDate.parse(paquete[5], formatter));
				} catch(Exception e) {
					System.out.print(e.getMessage());
					e.printStackTrace();
				}
				pqc.confirmarCrearPaquete();
			}
			bRead.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		//este es R1
		formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
		iEspect.ingresarNombreFuncion("Los Village Volvieron - 1");
		iEspect.ingresarNombreEspectador("costas");
		iEspect.confirmarRegistro("Los Village Volvieron", LocalDate.parse("09/04/20",formatter));
		//R2
		iEspect.ingresarNombreFuncion("Los Village Volvieron - 1");
		iEspect.ingresarNombreEspectador("sergiop");
		iEspect.confirmarRegistro("Los Village Volvieron", LocalDate.parse("10/04/20",formatter));
		//R3
		iEspect.ingresarNombreFuncion("Los Village Volvieron - 1");
		iEspect.ingresarNombreEspectador("chino");
		iEspect.confirmarRegistro("Los Village Volvieron", LocalDate.parse("12/04/20",formatter));
		//R4
		iEspect.ingresarNombreFuncion("Los Village Volvieron - 2");
		iEspect.ingresarNombreEspectador("chino");
		iEspect.confirmarRegistro("Los Village Volvieron", LocalDate.parse("15/04/20",formatter));
		//R5
		iEspect.ingresarNombreFuncion("Los Village Volvieron - 2");
		iEspect.ingresarNombreEspectador("tonyp");
		iEspect.confirmarRegistro("Los Village Volvieron", LocalDate.parse("20/04/20",formatter));
		//R6
		iEspect.ingresarNombreFuncion("Los Village Volvieron - 2");
		iEspect.ingresarNombreEspectador("costas");
		iEspect.confirmarRegistro("Los Village Volvieron", LocalDate.parse("25/04/20",formatter));
		//R7
		iEspect.ingresarNombreFuncion("Los Village Volvieron - 2");
		iEspect.ingresarNombreEspectador("lachiqui");
		iEspect.confirmarRegistro("Los Village Volvieron", LocalDate.parse("28/04/20",formatter));
		//R8
		iEspect.ingresarNombreFuncion("Los Village Volvieron - 3");
		iEspect.ingresarNombreEspectador("sergiop");
		iEspect.confirmarRegistro("Los Village Volvieron", LocalDate.parse("16/04/20",formatter));
		//R9
		iEspect.ingresarNombreFuncion("Los Village Volvieron - 3");
		iEspect.ingresarNombreEspectador("costas");
		iEspect.confirmarRegistro("Los Village Volvieron", LocalDate.parse("15/05/20",formatter));
		//R10
		iEspect.ingresarNombreFuncion("Los Village Volvieron - 3");
		iEspect.ingresarNombreEspectador("lachiqui");
		iEspect.confirmarRegistro("Los Village Volvieron", LocalDate.parse("20/05/20",formatter));
		//R11
		iEspect.ingresarNombreFuncion("Global Spirit (I)");
		iEspect.ingresarNombreEspectador("lachiqui");
		iEspect.confirmarRegistro("Global Spirit", LocalDate.parse("05/05/20",formatter));
		//R12
		iEspect.ingresarNombreFuncion("Global Spirit (I)");
		iEspect.ingresarNombreEspectador("waston");
		iEspect.confirmarRegistro("Global Spirit", LocalDate.parse("10/05/20",formatter));
		//R13
		iEspect.ingresarNombreFuncion("Global Spirit (I)");
		iEspect.ingresarNombreEspectador("sergiop");
		iEspect.confirmarRegistro("Global Spirit", LocalDate.parse("15/05/20",formatter));
		//R14
		iEspect.ingresarNombreFuncion("Global Spirit (I)");
		iEspect.ingresarNombreEspectador("tonyp");
		iEspect.confirmarRegistro("Global Spirit", LocalDate.parse("20/05/20",formatter));
		//R15
		iEspect.ingresarNombreFuncion("Global Spirit (II)");
		iEspect.ingresarNombreEspectador("house");
		iEspect.confirmarRegistro("Global Spirit", LocalDate.parse("08/06/20",formatter));
		//R16
		iEspect.ingresarNombreFuncion("Global Spirit (II)");
		iEspect.ingresarNombreEspectador("waston");
		iEspect.confirmarRegistro("Global Spirit", LocalDate.parse("13/06/20",formatter));
		//R17
		iEspect.ingresarNombreFuncion("Global Spirit (II)");
		iEspect.ingresarNombreEspectador("lachiqui");
		iEspect.confirmarRegistro("Global Spirit", LocalDate.parse("25/06/20",formatter));
		//R18
		iEspect.ingresarNombreFuncion("Global Spirit (III)");
		iEspect.ingresarNombreEspectador("cbochinche");
		iEspect.confirmarRegistro("Global Spirit", LocalDate.parse("05/07/20",formatter));
		//R19
		iEspect.ingresarNombreFuncion("Global Spirit (III)");
		iEspect.ingresarNombreEspectador("sergiop");
		iEspect.confirmarRegistro("Global Spirit", LocalDate.parse("11/07/20",formatter));
		//R20
		iEspect.ingresarNombreFuncion("Global Spirit (III)");
		iEspect.ingresarNombreEspectador("chino");
		iEspect.confirmarRegistro("Global Spirit", LocalDate.parse("18/07/20",formatter));
		//R21
		iEspect.ingresarNombreFuncion("Memphis Blues World - A");
		iEspect.ingresarNombreEspectador("lachiqui");
		List<DtRegistro> registros = iEspect.obtenerRegistrosPrevios();
		int[] registrosFiltrados = new int[3];
		for (int i = 0; i < registros.size(); i++) {
			if(registros.get(i).getId() == 7)
				registrosFiltrados[0] = registros.get(i).getId();
			if(registros.get(i).getId() == 10)
				registrosFiltrados[1] = registros.get(i).getId();
			if(registros.get(i).getId() == 17)
				registrosFiltrados[2] = registros.get(i).getId();
		}
		iEspect.canjearRegistros(registrosFiltrados);
		iEspect.confirmarRegistro("Memphis Blues World", LocalDate.parse("19/07/20",formatter));
		//esto se hace solo si se canjean
		
		//R22
		iEspect.ingresarNombreFuncion("Memphis Blues World - B");
		iEspect.ingresarNombreEspectador("eleven11");
		iEspect.confirmarRegistro("Memphis Blues World", LocalDate.parse("17/08/20",formatter));
		//R23
		iEspect.ingresarNombreFuncion("Memphis Blues World - B");
		iEspect.ingresarNombreEspectador("house");
		iEspect.confirmarRegistro("Memphis Blues World", LocalDate.parse("20/08/20",formatter));
		//R24
		iEspect.ingresarNombreFuncion("Memphis Blues World - B");
		iEspect.ingresarNombreEspectador("chino");
		iEspect.confirmarRegistro("Memphis Blues World", LocalDate.parse("23/08/20",formatter));
		//R25
		iEspect.ingresarNombreFuncion("Memphis Blues World - C");
		iEspect.ingresarNombreEspectador("costas");
		registros = iEspect.obtenerRegistrosPrevios();
		for (int i = 0; i < registros.size(); i++) {
			if(registros.get(i).getId() == 1)
				registrosFiltrados[0] = registros.get(i).getId();
			if(registros.get(i).getId() == 6)
				registrosFiltrados[1] = registros.get(i).getId();
			if(registros.get(i).getId() == 9)
				registrosFiltrados[2] = registros.get(i).getId();
		}
		iEspect.canjearRegistros(registrosFiltrados);
		iEspect.confirmarRegistro("Memphis Blues World", LocalDate.parse("15/08/20",formatter));
		
		//R26
		iEspect.ingresarNombreFuncion("Memphis Blues World - C");
		iEspect.ingresarNombreEspectador("eleven11");
		iEspect.confirmarRegistro("Memphis Blues World", LocalDate.parse("26/08/20",formatter));
		//R27
		iEspect.ingresarNombreFuncion("Springsteen on Broadway - i");
		iEspect.ingresarNombreEspectador("chino");
		registros = iEspect.obtenerRegistrosPrevios();
		for (int i = 0; i < registros.size(); i++) {
			if(registros.get(i).getId() == 3)
				registrosFiltrados[0] = registros.get(i).getId();
			if(registros.get(i).getId() == 4)
				registrosFiltrados[1] = registros.get(i).getId();
			if(registros.get(i).getId() == 20)
				registrosFiltrados[2] = registros.get(i).getId();
		}
		iEspect.canjearRegistros(registrosFiltrados);
		iEspect.confirmarRegistro("Springsteen on Broadway", LocalDate.parse("19/07/20",formatter));
		
		//R28
		iEspect.ingresarNombreFuncion("Springsteen on Broadway - i");
		iEspect.ingresarNombreEspectador("tonyp");
		iEspect.confirmarRegistro("Springsteen on Broadway", LocalDate.parse("16/08/20",formatter));
		//R29
		iEspect.ingresarNombreFuncion("Springsteen on Broadway - i");
		iEspect.ingresarNombreEspectador("lachiqui");
		iEspect.confirmarRegistro("Springsteen on Broadway", LocalDate.parse("24/08/20",formatter));
		
		
		//R30
		iEspect.ingresarNombreFuncion("Springsteen on Broadway - ii");
		iEspect.ingresarNombreEspectador("sergiop");
		registros = iEspect.obtenerRegistrosPrevios();
		for (int i = 0; i < registros.size(); i++) {
			if(registros.get(i).getId() == 2)
				registrosFiltrados[0] = registros.get(i).getId();
			if(registros.get(i).getId() == 13)
				registrosFiltrados[1] = registros.get(i).getId();
			if(registros.get(i).getId() == 19)
				registrosFiltrados[2] = registros.get(i).getId();
		}
		iEspect.canjearRegistros(registrosFiltrados);
		iEspect.confirmarRegistro("Springsteen on Broadway", LocalDate.parse("01/08/20",formatter));
		
		//R31
		iEspect.ingresarNombreFuncion("Springsteen on Broadway - ii");
		iEspect.ingresarNombreEspectador("house");
		iEspect.confirmarRegistro("Springsteen on Broadway", LocalDate.parse("30/08/20",formatter));
		//R32
		iEspect.ingresarNombreFuncion("Springsteen on Broadway - iii");
		iEspect.ingresarNombreEspectador("eleven11");
		iEspect.confirmarRegistro("Springsteen on Broadway", LocalDate.parse("16/08/20",formatter));
		//R33
		iEspect.ingresarNombreFuncion("Springsteen on Broadway - iii");
		iEspect.ingresarNombreEspectador("costas");
		iEspect.confirmarRegistro("Springsteen on Broadway", LocalDate.parse("16/08/20",formatter));
		//R34
		iEspect.ingresarNombreFuncion("Springsteen on Broadway - iii");
		iEspect.ingresarNombreEspectador("waston");
		iEspect.confirmarRegistro("Springsteen on Broadway", LocalDate.parse("01/09/20",formatter));
		//R35
		iEspect.ingresarNombreFuncion("Springsteen on Broadway - iii");
		iEspect.ingresarNombreEspectador("sergiop");
		iEspect.confirmarRegistro("Springsteen on Broadway", LocalDate.parse("05/09/20",formatter));
		//R36
		iEspect.ingresarNombreFuncion("Bien de Familia - A");
		iEspect.ingresarNombreEspectador("house");
		iEspect.confirmarRegistro("Bien de Familia", LocalDate.parse("16/08/20",formatter));
		//R37
		iEspect.ingresarNombreFuncion("Bien de Familia - A");
		iEspect.ingresarNombreEspectador("cbochinche");
		iEspect.confirmarRegistro("Bien de Familia", LocalDate.parse("03/09/20",formatter));
		//R38
		iEspect.ingresarNombreFuncion("Bien de Familia - B");
		iEspect.ingresarNombreEspectador("eleven11");
		iEspect.confirmarRegistro("Bien de Familia", LocalDate.parse("16/08/20",formatter));
		//R39
		iEspect.ingresarNombreFuncion("Bien de Familia - B");
		iEspect.ingresarNombreEspectador("cbochinche");
		iEspect.confirmarRegistro("Bien de Familia", LocalDate.parse("06/09/20",formatter));
		//R40
		iEspect.ingresarNombreFuncion("Bien de Familia - C");
		iEspect.ingresarNombreEspectador("costas");
		iEspect.confirmarRegistro("Bien de Familia", LocalDate.parse("01/09/20",formatter));
		//R41
		iEspect.ingresarNombreFuncion("30 años - 1");
		iEspect.ingresarNombreEspectador("sergiop");
		iEspect.confirmarRegistro("30 años", LocalDate.parse("16/08/20",formatter));
		//R42
		iEspect.ingresarNombreFuncion("30 años - 1");
		iEspect.ingresarNombreEspectador("eleven11");
		iEspect.confirmarRegistro("30 años", LocalDate.parse("20/08/20",formatter));
		//R43
		iEspect.ingresarNombreFuncion("30 años - 1");
		iEspect.ingresarNombreEspectador("tonyp");
		iEspect.confirmarRegistro("30 años", LocalDate.parse("31/08/20",formatter));
		//R44
		iEspect.ingresarNombreFuncion("30 años - 2");
		iEspect.ingresarNombreEspectador("chino");
		iEspect.confirmarRegistro("30 años", LocalDate.parse("16/08/20",formatter));
		//R45
		iEspect.ingresarNombreFuncion("30 años - 2");
		iEspect.ingresarNombreEspectador("tonyp");
		iEspect.confirmarRegistro("30 años", LocalDate.parse("20/08/20",formatter));
		//R46
		iEspect.ingresarNombreFuncion("30 años - 2");
		iEspect.ingresarNombreEspectador("costas");
		iEspect.confirmarRegistro("30 años", LocalDate.parse("02/09/20",formatter));
			
				
		try {
			BufferedReader bRead = new BufferedReader(new FileReader("data/espectaculoEnPaquete.csv"));
			while ((line = bRead.readLine()) != null)
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
			bRead.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		        JOptionPane.showMessageDialog(null, "Datos de prueba cargados con exito.");
	}
	

	public static LocalTime String2LocalTime(String str){
		return LocalTime.of(Integer.parseInt(str) / 60, Integer.parseInt(str) % 60);
	}
}
