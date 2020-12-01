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
 * Servlet implementation class Favoritos
 */
public class Favoritos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Favoritos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession objSesion = request.getSession();
		request.setCharacterEncoding("UTF-8");
		
		String espec = request.getParameter("espec");
		String user = request.getParameter("user");
		String accion = request.getParameter("accion");
		
		PublicadorService service = new PublicadorService();
	    Publicador port = service.getPublicadorPort();
	    
	    if (accion.equals("quitar")) {
	    	port.quitarFavorito(espec, user);
	    } else if (accion.equals("agregar"))  {
	    	
	    	port.agregarFavorito(espec, user);
	    }
	    
	    response.sendRedirect("detallesEspectaculo?name=" + espec);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
