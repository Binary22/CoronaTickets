package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logica.DataEspectaculo;
import logica.Publicador;
import logica.PublicadorService;
import logica.YaVotoException_Exception;

public class ValorarEspectaculo extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValorarEspectaculo() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession objSesion = req.getSession();
    	objSesion.setAttribute("errorValorar", null);
    	objSesion.setAttribute("exito", null);
    	if(objSesion.getAttribute("estado_sesion") == "LOGIN_CORRECTO") {
    	String nomEspect = req.getParameter("name");
    	PublicadorService service = new PublicadorService();
	    Publicador port = service.getPublicadorPort();
    	DataEspectaculo espect = port.getEspectaculo(nomEspect);
    	objSesion.setAttribute("nomEspec", nomEspect);
    	
    	objSesion.setAttribute("espectaculo", espect);
    	
		req.getRequestDispatcher("/WEB-INF/espectaculos/valorarEspectaculo.jsp").forward(req, resp);
    	} else {
			resp.sendRedirect("registro");
    	}
	}
    
    private void processResponse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession objSesion = req.getSession();
		String user = (String) objSesion.getAttribute("usuario_logueado");
		int puntaje = Integer.valueOf(req.getParameter("puntaje"));

    	PublicadorService service = new PublicadorService();
	    Publicador port = service.getPublicadorPort();
	    String espect= (String) objSesion.getAttribute("nomEspec");
	    try {
			port.valorarEspectaculo(espect, user, puntaje);
		} catch (YaVotoException_Exception e) {
			objSesion.setAttribute("errorValorar", e.getMessage());
		    req.getRequestDispatcher("/WEB-INF/espectaculos/valorarEspectaculo.jsp").forward(req, resp);
		    return;
		}
	    objSesion.setAttribute("exito", true);
	    req.getRequestDispatcher("/WEB-INF/espectaculos/valorarEspectaculo.jsp").forward(req, resp);
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
