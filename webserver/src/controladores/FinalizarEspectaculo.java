package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logica.Publicador;
import logica.PublicadorService;

/**
 * Servlet implementation class FinalizarEspectaculo
 */
@WebServlet("/FinalizarEspectaculo")
public class FinalizarEspectaculo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinalizarEspectaculo() {
        super();
        // TODO Auto-generated constructor stub
    }
    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       	
    	
    }
    
    private void processResponse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	HttpSession objSesion = req.getSession();
    	String nombreEspFin = (String) req.getParameter("nombreEsp");
    	String nombreUser= (String) objSesion.getAttribute("usuario_logueado");
    	PublicadorService service = new PublicadorService();
	    Publicador port = service.getPublicadorPort();
	    port.finalizarEspectaculo(nombreEspFin);
	    resp.sendRedirect("detallesUsuario?name="+nombreUser);
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
		
		processResponse(request, response);
	}

}
