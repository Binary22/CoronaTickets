package controladores;

import logica.DataEspectaculo;
import logica.NombreEspectaculoExisteException_Exception;
import logica.Publicador;
import logica.PublicadorService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
		form.put("video", "");
		form.put("premio", "");
		form.put("cantPremios", "");
    	HttpSession session = req.getSession();
    	session.setAttribute("form", form);
    	session.setAttribute("error", "no");
    	if (session.getAttribute("estado_sesion") == "LOGIN_INCORRECTO") {
			resp.sendRedirect("home");
		};
		if (session.getAttribute("estado_sesion") == "") {
			resp.sendRedirect("home");
		};
    	
		PublicadorService service = new PublicadorService();
	    Publicador port = service.getPublicadorPort();
		;
		List<String> nombresPlat = new ArrayList<String>(port.listarPlataformas().getItem());
		nombresPlat.sort(String::compareToIgnoreCase);
		List<String> nombresCats = new ArrayList<String>(port.listarCategorias().getItem());
		nombresCats.sort(String::compareToIgnoreCase);
    	session.setAttribute("plataformas", nombresPlat);
    	session.setAttribute("categorias", nombresCats);
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
    	String video = req.getParameter("video");
    	String[] cats = req.getParameterValues("categoria");
    	String descripPremio = req.getParameter("descPremio");
    	String cantPremios = req.getParameter("cantPremios");
    	
    	
    	HashMap<String, String> form = new HashMap<String, String>();
		form.put("descripcion", descripcion);
		form.put("duracion", horas);
		form.put("minutos", minutos);
		form.put("maximo", maxEspectadores);
		form.put("minimo", minEspectadores);
		form.put("url", url);
		form.put("costo", costo);
		form.put("imagen", imagen);
		form.put("video", video);
		form.put("premio", descripPremio);
		form.put("cantPremios", cantPremios);
    	
		if (cantPremios == "") {
    		cantPremios = "0";
    	}
		
		
    	try {
    	
    	if (Integer.parseInt(minEspectadores) > Integer.parseInt(maxEspectadores) ) {
    		throw(new NombreEspectaculoExisteException("El mínimo debe ser menor al máximo de espectadores"));
    	}
    	
    	if((cantPremios == "" || (Integer.parseInt(cantPremios) == 0)) && !descripPremio.isEmpty()) {
    		throw (new NombreEspectaculoExisteException("La cantidad de premios debe ser mayor a 0 si desea agregar un premio."));
    	}
    	
    	
    	if(Integer.parseInt(cantPremios) > 0 && descripPremio.isEmpty()) {
    		throw (new NombreEspectaculoExisteException("La descripcion del premio no puede ser vacia si desea agregar "+ cantPremios +" premios"));
    	}
    	
    	
    	PublicadorService service = new PublicadorService();
	    Publicador port = service.getPublicadorPort();
    	
	    ArrayList<String> cats2 = new ArrayList<String>();
	    if (cats != null) {
    		for (String c : cats ) {
    			cats2.add(c);
    		}
    	}
	    
	    DataEspectaculo dataEsp = new DataEspectaculo();
	    dataEsp.setArtista(nick);
	    dataEsp.setPlataforma(nomPlataforma);
	    dataEsp.setNombre(nombre);
	    dataEsp.setDescripcion(descripcion);
	    dataEsp.setDuracion(horas);
	    dataEsp.setMinutos(minutos);
	    dataEsp.setMaxEspectadores(Integer.parseInt(maxEspectadores));
	    dataEsp.setMinEspectadores(Integer.parseInt(minEspectadores));
	    dataEsp.setUrl(url);
	    dataEsp.setCosto(Float.parseFloat(costo));
	    dataEsp.setVideo(video);
	    dataEsp.setDescPremio(descripPremio);
	    if(cantPremios != "" && cantPremios != null) {
	    	dataEsp.setCantPremios(Integer.parseInt(cantPremios));
	    }
	    if (imagen != "" && imagen != null) {
	    dataEsp.setImagen(imagen);	    
	    } else {
	    	dataEsp.setImagen("resources/media/espectaculos/rock.jpg");
	    }
	    if (cats != null) {
    		for (String c : cats ) {
    			dataEsp.getCategorias().add(c);
    		}
    	};
	    
	    
	    
	    
    	try {
			port.altaEspectaculoWeb(dataEsp);
			} catch (NumberFormatException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
    	resp.sendRedirect("home");

    	} catch(NombreEspectaculoExisteException | NombreEspectaculoExisteException_Exception e) {
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
