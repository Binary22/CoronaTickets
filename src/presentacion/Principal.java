package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.lang.Integer;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.SplitPaneUI;

import excepciones.NombreEspectaculoExisteException;
import excepciones.NombreFuncionexisteException;
import excepciones.UsuarioConMismoMailException;
import excepciones.UsuarioConMismoNickException;
import logica.Artista;
import logica.Fabrica;
import logica.HandlerUsuarios;
import logica.IEspectaculo;
import logica.IPlataforma;
import logica.IUsuario;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.time.*;
import java.io.*;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JInternalFrame AltaUsuarioInternalFrame;
	private JInternalFrame ModificarDatosDeUsuarioInternalFrame;
	private JInternalFrame ConsultaDeUsuarioInternalFrame;
	private JInternalFrame ConsultaEspectaculoInternalFrame;
	private JInternalFrame AltaFuncionInternalFrame;
	private JInternalFrame AltaDeEspectaculoInternalFrame;
	private JInternalFrame ConsultaFuncionInternalFrame;
	private JInternalFrame RegistroFunEspectInternalFrame;
	

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
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JMenu mnPruebas = new JMenu("Pruebas");
		menuBar.add(mnPruebas);
		
		JMenuItem mntmCargarDatos = new JMenuItem("Cargar Datos");
		mntmCargarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cargarDatos();
				} catch (NombreEspectaculoExisteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UsuarioConMismoNickException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UsuarioConMismoMailException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NombreFuncionexisteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
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
        
        
        ModificarDatosDeUsuarioInternalFrame = new ModificarDatosDeUsuario();
        ModificarDatosDeUsuarioInternalFrame.setVisible(false);
        getContentPane().add(ModificarDatosDeUsuarioInternalFrame);
        
        ConsultaDeUsuarioInternalFrame = new ConsultaUsuario();
        ConsultaDeUsuarioInternalFrame.setVisible(false);
        getContentPane().add(ConsultaDeUsuarioInternalFrame);
        
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
           
	
	}

	public static void cargarDatos() throws UsuarioConMismoNickException, UsuarioConMismoMailException, NumberFormatException, NombreEspectaculoExisteException, NombreFuncionexisteException {
		// TODO Auto-generated method stub
		Fabrica f = Fabrica.getInstance();
		IPlataforma pc = f.getIPlataforma();
		
		IUsuario uc = f.getIUsuario();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fecha1 = LocalDate.parse("07/10/1999", formatter);
		uc.altaUsuario("eleven11","Eleven","Ten","eleven11@gmail.com",LocalDate.parse("31/12/1971",formatter));
		uc.confirmarAltaUsuario();
		uc.altaUsuario("costas","Gerardo","Costas","gcostas@gmail.com",LocalDate.parse("15/11/1983", formatter));
		uc.confirmarAltaUsuario();
		uc.altaUsuario("waston","Emma","Watson","e.watson@gmail.com",LocalDate.parse("15/04/1990", formatter));
		uc.confirmarAltaUsuario();
		uc.altaUsuario("house","Gregory","House", "greghouse@gmail.com",LocalDate.parse("15/05/1959", formatter));
		uc.confirmarAltaUsuario();
		uc.altaUsuario("sergiop", "Sergio","Puglia","puglia@alpanpan.com.uy",LocalDate.parse("28/01/1950", formatter));
		uc.confirmarAltaUsuario();
		uc.altaUsuario("chino","Alvaro","Recoba","chino@trico.org.uy", LocalDate.parse("17/03/1976", formatter));
		uc.confirmarAltaUsuario();
		uc.altaUsuario("tonyp","Antonio","Pacheco","eltony@manya.org.uy",LocalDate.parse("14/02/1955",formatter));
		uc.confirmarAltaUsuario();
		uc.altaUsuario("lachiqui","Mirtha","Legrand","lachiqui@hotmail.com.ar",LocalDate.parse("23/02/1927",formatter));
		uc.confirmarAltaUsuario();
		uc.altaUsuario("cbochinche","Cacho","Bochinche","cbochinche@vera.com.uy",LocalDate.parse("08/05/1937",formatter));
		
		
		//uc.altaUsuario("vpeople", "Village", "People", "vpeople@tuta.io", LocalDate.parse("01/01/1977",formatter));
		
		
		
		
		
		String line = "nl";
		String splitBy = ",";


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

		try {
			BufferedReader br = new BufferedReader(new FileReader("data/funciones.csv"));
			while ((line = br.readLine()) != null)
			{
				String[] funcion = line.split(splitBy);
				String[] artistax = funcion[5].split(",");
				ArrayList<String> artistas = new ArrayList<String>();
				for(String s:artistax) {
					if (s != ""){
						 artistas.add(s);
					}
				}
				ec.elegirEspectaculo(funcion[4]);
				ec.altaFuncion(funcion[0], LocalDate.parse(funcion[1], formatter), LocalTime.parse(funcion[2]), artistas.isEmpty()? artistas : null, LocalDate.parse(funcion[3], formatter));		
				ec.ConfirmarAltaFuncion();
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
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
		        ec.ingresarNombreEspectador("sergiop");
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
		        ec.confirmarRegistro("Memphis Blues World", LocalDate.parse("19/07/20",formatter));
		        //esto se hace solo si se canjean
		        ArrayList<DtRegistro> registros = ec.obtenerRegistrosPrevios();
		        DtRegistro[] registrosFiltrados = new DtRegistro[3];
		        for (int i = 0; i <= registros.size(); i++) {
		            if(i==6)
		                registrosFiltrados[i] = registros.get(i);
		            if(i==9)
		                registrosFiltrados[i] = registros.get(i);
		            if(i==16)
		                registrosFiltrados[i] = registros.get(i);
		        }
		        ec.canjearRegistros(registrosFiltrados);
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
		        ec.confirmarRegistro("Memphis Blues World", LocalDate.parse("15/08/20",formatter));
		        registros = ec.obtenerRegistrosPrevios();
		        for (int i = 0; i <= registros.size(); i++) {
		            if(i==0)
		                registrosFiltrados[i] = registros.get(i);
		            if(i==5)
		                registrosFiltrados[i] = registros.get(i);
		            if(i==8)
		                registrosFiltrados[i] = registros.get(i);
		        }
		        ec.canjearRegistros(registrosFiltrados);
		        //R26
		        ec.ingresarNombreFuncion("Memphis Blues World - C");
		        ec.ingresarNombreEspectador("eleven11");
		        ec.confirmarRegistro("Memphis Blues World", LocalDate.parse("26/08/20",formatter));
		        //R27
		        ec.ingresarNombreFuncion("Springsteen on Broadway - i");
		        ec.ingresarNombreEspectador("chino");
		        ec.confirmarRegistro("Springsteen on Broadway", LocalDate.parse("19/07/20",formatter));
		        registros = ec.obtenerRegistrosPrevios();
		        for (int i = 0; i <= registros.size(); i++) {
		            if(i==2)
		                registrosFiltrados[i] = registros.get(i);
		            if(i==3)
		                registrosFiltrados[i] = registros.get(i);
		            if(i==19)
		                registrosFiltrados[i] = registros.get(i);
		        }
		        ec.canjearRegistros(registrosFiltrados);
		        //R28
		        ec.ingresarNombreFuncion("Springsteen on Broadway - i");
		        ec.ingresarNombreEspectador("tonyp");
		        ec.confirmarRegistro("Springsteen on Broadway", LocalDate.parse("16/08/20",formatter));
		        //R29
		        ec.ingresarNombreFuncion("Springsteen on Broadway - i");
		        ec.ingresarNombreEspectador("lachiqui");
		        ec.confirmarRegistro("Springsteen on Broadway", LocalDate.parse("24/08/20",formatter));
		        //R28
		        ec.ingresarNombreFuncion("Springsteen on Broadway - i");
		        ec.ingresarNombreEspectador("chino");
		        ec.confirmarRegistro("Springsteen on Broadway", LocalDate.parse("17/08/20",formatter));
		        //R29
		        ec.ingresarNombreFuncion("Springsteen on Broadway - i");
		        ec.ingresarNombreEspectador("lachiqui");
		        ec.confirmarRegistro("Springsteen on Broadway", LocalDate.parse("24/08/20",formatter));
		        //R30
		        ec.ingresarNombreFuncion("Springsteen on Broadway - ii");
		        ec.ingresarNombreEspectador("sergiop");
		        ec.confirmarRegistro("Springsteen on Broadway", LocalDate.parse("01/08/20",formatter));
		        registros = ec.obtenerRegistrosPrevios();
		        for (int i = 0; i <= registros.size(); i++) {
		            if(i==1)
		                registrosFiltrados[i] = registros.get(i);
		            if(i==12)
		                registrosFiltrados[i] = registros.get(i);
		            if(i==18)
		                registrosFiltrados[i] = registros.get(i);
		        }
		        ec.canjearRegistros(registrosFiltrados);
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
		    }	
		
	}

	public static LocalTime String2LocalTime(String s){
		return LocalTime.of(Integer.parseInt(s) / 60, Integer.parseInt(s) % 60);
	}
}
