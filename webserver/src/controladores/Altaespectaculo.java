package controladores;

import logica.Fabrica;
import logica.HandlerCategorias;
import logica.HandlerEspectaculos;
import logica.HandlerPlataforma;
import logica.IEspectaculo;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import excepciones.NombreEspectaculoExisteException;

/**
 * Servlet implementation class Altaespectaculo
 */
public class Altaespectaculo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Altaespectaculo() {
        super();
        // TODO Auto-generated constructor stub
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	HashMap<String, String> form = new HashMap<String, String>();
		form.put("descripcion", "");
		form.put("duracion", "");
		form.put("minutos", "");
		form.put("maximo", "");
		form.put("minimo", "");
		form.put("url", "");
		form.put("categorias", "");
		form.put("costo", "");
		form.put("imagen", "");
    	HttpSession session = req.getSession();
    	session.setAttribute("form", form);
    	session.setAttribute("error", "no");
    	if (session.getAttribute("estado_sesion") == "LOGIN_INCORRECTO") {
			resp.sendRedirect("home");
		};
		if (session.getAttribute("estado_sesion") == "") {
			resp.sendRedirect("home");
		};
    	
    	HandlerCategorias hc = HandlerCategorias.getInstance();
    	HandlerPlataforma hp = HandlerPlataforma.getInstance();
    	session.setAttribute("plataformas", hp.getNombres());
    	session.setAttribute("categorias", hc.getCategorias().keySet());
		req.getRequestDispatcher("/WEB-INF/espectaculos/altaespectaculo.jsp").forward(req, resp);
	}
    
    private void processSubmit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		req.setCharacterEncoding("UTF-8");
		session.setAttribute("error", "no");
		String nick = (String) session.getAttribute("usuario_logueado");
    	String nomPlataforma = req.getParameter("nomPlataforma");
    	String nombre = req.getParameter("nombre");
    	String descripcion = req.getParameter("descripcion");
    	String horas = req.getParameter("horas");
    	String minutos = req.getParameter("minutos");
    	String maxEspectadores = req.getParameter("max");
    	String minEspectadores = req.getParameter("min");
    	String url = req.getParameter("url");
    	String costo = req.getParameter("costo");
    	String imagen = req.getParameter("imagen");
    	String[] cats = req.getParameterValues("categoria");
    	
    	System.out.print(nomPlataforma);
    	
    	LocalTime duracion = LocalTime.of(Integer.parseInt(horas), Integer.parseInt(minutos));
    	
    	LocalDate hoy = LocalDate.now();
    	
    	Fabrica fabrica = Fabrica.getInstance();
    	IEspectaculo ctrlE = fabrica.getIEspectaculo();
    	
    	ArrayList<String> cats2 = new ArrayList<String>();
    	
    	if (cats != null) {
    		for (String c : cats ) {
    			cats2.add(c);
    		}
    	}
    	
    	HashMap<String, String> form = new HashMap<String, String>();
		form.put("descripcion", descripcion);
		form.put("duracion", horas);
		form.put("minutos", minutos);
		form.put("maximo", maxEspectadores);
		form.put("minimo", minEspectadores);
		form.put("url", url);
		form.put("costo", costo);
		form.put("imagen", imagen);
    	
    	try {
    	
    	if (Integer.parseInt(minEspectadores) > Integer.parseInt(maxEspectadores) ) {
    		throw(new NombreEspectaculoExisteException("El mínimo debe ser menor al máximo de espectadores"));
    	}
    	ctrlE.altaEspectaculoWeb(nomPlataforma, nick, nombre, descripcion, duracion, 
    							Integer.parseInt(minEspectadores), Integer.parseInt(maxEspectadores),
    							url, Float.parseFloat(costo), hoy, cats2, imagen);
    	
    	//ctrlE.confirmarAltaEspectaculo(); esto lo saque porque altaespectaculoweb contiene todo lo que hace esta, entonces quedaban datos repetidos
    	// aca NO se estan guardando las imagenes y categorias, porque el confirmarAltaEspec no guarda 
    	// ni usuarios ni categorias, por eso es necesario esto 
    	HandlerEspectaculos he = HandlerEspectaculos.getInstance();
    	if (imagen != "") {
    		he.getEspectaculo(nombre).setImagen(imagen);
    	}
    	if (cats != null) {
    		for (String c : cats ) {
    			he.getEspectaculo(nombre).addCategoria(c);
    		}
    	}
    	resp.sendRedirect("home");

    	} catch(NombreEspectaculoExisteException e) {
    		e.printStackTrace();
    		session.setAttribute("error", e.getMessage());

    		
    		session.setAttribute("form", form);
    		req.getRequestDispatcher("/WEB-INF/espectaculos/altaespectaculo.jsp").forward(req, resp);
    		//devolver algo al usuario de la web !!
    	}

    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processSubmit(request, response);
	}

}
