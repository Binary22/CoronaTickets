package controladores;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logica.DataListArtInvi;
import logica.DataListEspOrg;
import logica.NombreFuncionexisteException_Exception;
import logica.Publicador;
import logica.PublicadorService;

/**
 * Servlet implementation class Altafuncion
 */
public class Altafuncion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Altafuncion() {
        super();
        // TODO Auto-generated constructor stub
    }

	private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HashMap<String, String> form = new HashMap<String, String>();
		form.put("nombre", "");
		form.put("fecha", "");
		form.put("horaInicio", "");
		form.put("esp", "");
		form.put("invitados", "");
		
		HttpSession objSesion = req.getSession();
		objSesion.setAttribute("form", form);
		PublicadorService service = new PublicadorService();
	    Publicador port = service.getPublicadorPort();
	    
		if((objSesion.getAttribute("estado_sesion") == "LOGIN_CORRECTO") && ((boolean) objSesion.getAttribute("esArtista"))) {
			objSesion.setAttribute("escero",false);
			objSesion.setAttribute("nombreexiste",false);
			objSesion.setAttribute("fechaInvalida",false);
			String nickname = (String)objSesion.getAttribute("usuario_logueado");
			
			DataListArtInvi artistasInvi = port.getArtistas(nickname);
			List<String> artistasInviReal = artistasInvi.getArtistasInvi();
			artistasInviReal.sort(String::compareToIgnoreCase);
			objSesion.setAttribute("artistas", artistasInviReal);
			
			DataListEspOrg espectaculosOrg = port.getEspectaculos(nickname);
			List<String> espectaculosOrgReal = espectaculosOrg.getEspectaculosOrg();
			objSesion.setAttribute("espectaculos", espectaculosOrgReal);
			
			req.getRequestDispatcher("/WEB-INF/funciones/altafuncion.jsp").forward(req, resp);
		}
		else
			resp.sendRedirect("registro");
	}
	
	private void processResponse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession objSesion = req.getSession();
		req.setCharacterEncoding("UTF-8");
		PublicadorService service = new PublicadorService();
	    Publicador port = service.getPublicadorPort();
	    
		String nombre = req.getParameter("nombre");
		String fecha = req.getParameter("fecha");
		String horaInicio = req.getParameter("hora");
		String esp = req.getParameter("espectaculo");
		String[] invitados = req.getParameterValues("artistasinv");
		boolean entro = false;
		
		HashMap<String, String> form = new HashMap<String, String>();
		form.put("nombre", nombre);
		form.put("fecha", fecha);
		form.put("horaInicio", horaInicio);
		form.put("esp", esp);
		form.put("invitados", "");
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_TIME;
        LocalDate date = LocalDate.parse(fecha, formatter);
        LocalTime duracion = LocalTime.parse(horaInicio,dateTimeFormatter);
        LocalTime cero = LocalTime.of(00,00);
        
        DataListArtInvi invis = new DataListArtInvi();
        if(invitados != null) {
	        for (int i=0; i< invitados.length; i++) {
	        	invis.getArtistasInvi().add(invitados[i]);
	        }
        }        
        if( ( !duracion.equals(cero) ) && ( ( date.isEqual(LocalDate.now())) || ( date.isAfter(LocalDate.now()) ) ) ) {
				try {
					port.altaFuncion(esp, nombre, fecha, horaInicio, invis);
				} catch (NombreFuncionexisteException_Exception e) {
					// TODO Auto-generated catch block
					objSesion.setAttribute("nombreexiste",true);
					objSesion.setAttribute("escero",false);
					objSesion.setAttribute("fechaInvalida",false);
					objSesion.setAttribute("form", form);
					req.getRequestDispatcher("/WEB-INF/funciones/altafuncion.jsp").forward(req, resp);
					entro = true;
				}
				if(!entro)	
					resp.sendRedirect("home");
        }
        else {
        	if(duracion.equals(cero)) {
        		objSesion.setAttribute("escero",true);
        		objSesion.setAttribute("fechaInvalida",false);
        		objSesion.setAttribute("nombreexiste",false);
        		objSesion.setAttribute("form", form);
        	}else {
        		objSesion.setAttribute("form", form);
        		objSesion.setAttribute("fechaInvalida",true);
        		objSesion.setAttribute("escero",false);
        		objSesion.setAttribute("nombreexiste",false);
        	}
        	objSesion.setAttribute("form", form);
        	req.getRequestDispatcher("/WEB-INF/funciones/altafuncion.jsp").forward(req, resp);
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
		processResponse(request, response);
	}

}
