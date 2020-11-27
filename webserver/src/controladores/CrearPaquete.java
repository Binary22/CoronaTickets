package controladores;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import excepciones.NoExistePaqueteException;
import excepciones.PaqueteConMismoNombreException;
import logica.Fabrica;
import logica.HandlerPaquetes;
import logica.IEspectaculo;
import logica.IPaquete;
import logica.NoExistePaqueteException_Exception;
import logica.PaqueteConMismoNombreException_Exception;
import logica.Publicador;
import logica.PublicadorService;

/**
 * Servlet implementation class CrearPaquete
 */
@WebServlet("/CrearPaquete")
public class CrearPaquete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearPaquete() {
        super();
        // TODO Auto-generated constructor stub
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	HashMap<String, String> form = new HashMap<String, String>();
		form.put("nombre", "");
		form.put("fechaIni", "");
		form.put("horaFin", "");
		form.put("descripcion", "");
		form.put("descuento", "");
		form.put("imagen", "");
		
		HttpSession objSesion = req.getSession();
		objSesion.setAttribute("form", form);
    	if((objSesion.getAttribute("estado_sesion") == "LOGIN_CORRECTO") && ((boolean) objSesion.getAttribute("esArtista"))) {
    		objSesion.setAttribute("fechaInvalida",false);
	    	objSesion.setAttribute("nombreexiste",false);
			req.getRequestDispatcher("/WEB-INF/paquetes/crearPaquete.jsp").forward(req, resp);
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
		String fechaini = req.getParameter("fechaini");
		String fechafin = req.getParameter("fechafin");
		String desc = req.getParameter("descripcion");
		String descuento = req.getParameter("descuento");
		String imagen = req.getParameter("imagen");
		boolean entro = false;
		
		HashMap<String, String> form = new HashMap<String, String>();
		form.put("nombre", nombre);
		form.put("fechaIni", fechaini);
		form.put("fechaFin", fechafin);
		form.put("descripcion", desc);
		form.put("descuento", descuento);
		form.put("imagen", imagen);
		
		int discount = Integer.parseInt(descuento); 
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dateini = LocalDate.parse(fechaini, formatter);
		LocalDate datefin = LocalDate.parse(fechafin, formatter);
		
		if( ( ( datefin.isAfter(dateini) ) || ( datefin.isEqual(dateini) ) ) && ( ( dateini.isAfter(LocalDate.now()) ) || ( dateini.isEqual(LocalDate.now()) ) ) ) {
	        try {
					port.crearPaquete(nombre,desc,fechaini,fechafin,discount,imagen);
				} catch (PaqueteConMismoNombreException_Exception | NoExistePaqueteException_Exception e) {
					objSesion.setAttribute("nombreexiste",true);
					objSesion.setAttribute("fechaInvalida",false);
					objSesion.setAttribute("form", form);
					entro = true;
					req.getRequestDispatcher("/WEB-INF/paquetes/crearPaquete.jsp").forward(req, resp);	
				}
	        if(!entro)
	        	resp.sendRedirect("home");
		}
		else {
			objSesion.setAttribute("fechaInvalida",true);
			objSesion.setAttribute("nombreexiste",false);
			objSesion.setAttribute("form", form);
			req.getRequestDispatcher("/WEB-INF/paquetes/crearPaquete.jsp").forward(req, resp);
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
