package controladores;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logica.DataListPaquetes;
import logica.DataListPlataformas;
import logica.Publicador;
import logica.PublicadorService;

/**
 * Servlet implementation class AgregarEspectaculoaPaquete
 */
@WebServlet("/AgregarEspectaculoaPaquete")
public class AgregarEspectaculoaPaquete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarEspectaculoaPaquete() {
        super();
        // TODO Auto-generated constructor stub
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	HttpSession objSesion = req.getSession();
    	req.setCharacterEncoding("UTF-8");
    	PublicadorService service = new PublicadorService();
	    Publicador port = service.getPublicadorPort();
	    
    	if((objSesion.getAttribute("estado_sesion") == "LOGIN_CORRECTO") && ((boolean) objSesion.getAttribute("esArtista"))) {
	    
	    	DataListPaquetes paquetes = port.getPaquetes();
	    	List<String> paquetesList = paquetes.getPaquetes();
	    	paquetesList.sort(String::compareToIgnoreCase);
			objSesion.setAttribute("paquetes",paquetesList);	
	
			DataListPlataformas plataformas = port.getPlataformas();
	    	List<String> plataformasList = plataformas.getPlataformas();
	    	plataformasList.sort(String::compareToIgnoreCase);
			objSesion.setAttribute("plataformas",plataformasList);
			
			req.getRequestDispatcher("/WEB-INF/espectaculos/agregarEspectaculoaPaquete.jsp").forward(req, resp);
    	}
    	else
    		resp.sendRedirect("registro");
	}
    private void processResponse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	HttpSession objSesion = req.getSession();
    	req.setCharacterEncoding("UTF-8");
    	objSesion.setAttribute("paqueteelegido",req.getParameter("paquetes"));
		objSesion.setAttribute("plataformaelegida",req.getParameter("plataformas"));
		resp.sendRedirect("espectaculosdeplat");
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
