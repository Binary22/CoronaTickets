package controladores;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datatypes.DtRegistro;
import excepciones.NombreEspectaculoExisteException;
import excepciones.NombreFuncionexisteException;
import excepciones.UsuarioConMismoMailException;
import excepciones.UsuarioConMismoNickException;
import excepciones.noSeleccionoTres;
import logica.Fabrica;
import logica.HandlerCategorias;
import logica.HandlerEspectaculos;
import logica.HandlerUsuarios;
import logica.IEspectaculo;
import logica.IPaquete;
import logica.IPlataforma;
import logica.IUsuario;
import logica.Usuario;

/**
 * Servlet implementation class CargarDatos
 */
@WebServlet("/CargarDatos")
public class CargarDatos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CargarDatos() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void cargarDatos() throws UsuarioConMismoNickException, UsuarioConMismoMailException, NumberFormatException, NombreEspectaculoExisteException, NombreFuncionexisteException, noSeleccionoTres {
		// TODO Auto-generated method stub
		Fabrica f = Fabrica.getInstance();
		IPlataforma pc = f.getIPlataforma();
		
		IUsuario uc = f.getIUsuario();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		String relPath = this.getServletContext().getRealPath("/resources/");
		
		
		String line = "nl";
		String splitBy = ";";
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(relPath + "data/usuarios.csv"));
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
			BufferedReader br = new BufferedReader(new FileReader(relPath + "data/artistas.csv"));  
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
			BufferedReader br = new BufferedReader(new FileReader(relPath + "data/plataformas.csv"));
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
			BufferedReader br = new BufferedReader(new FileReader(relPath + "data/espectaculos.csv"));
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
		ec.aceptarRechazar("Grandes Éxitos 2020", false);
		
		HandlerEspectaculos handlerE = HandlerEspectaculos.getInstance();

		try {
			BufferedReader br = new BufferedReader(new FileReader(relPath + "data/funciones.csv"));
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
				ec.ConfirmarAltaFuncion();
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		IPaquete pqc = f.getIPaquete();

		try {
			BufferedReader br = new BufferedReader(new FileReader(relPath + "data/paquetes.csv"));
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

		//este es R1
		formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
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
		ArrayList<DtRegistro> registros = ec.obtenerRegistrosPrevios();
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
			
				
		try {
			BufferedReader br = new BufferedReader(new FileReader(relPath + "data/espectaculoEnPaquete.csv"));
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
		// setear contraseñas a 1234
		HandlerUsuarios hu = HandlerUsuarios.getInstancia();
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
		
    // aca termina el cargar datos
    }
	
    
	public static LocalTime String2LocalTime(String s){
		return LocalTime.of(Integer.parseInt(s) / 60, Integer.parseInt(s) % 60);
	}
	
	private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			cargarDatos();
		} catch (NumberFormatException | UsuarioConMismoNickException | UsuarioConMismoMailException
				| NombreEspectaculoExisteException | NombreFuncionexisteException | noSeleccionoTres e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.getRequestDispatcher("/WEB-INF/home/home.jsp").forward(req, resp);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
