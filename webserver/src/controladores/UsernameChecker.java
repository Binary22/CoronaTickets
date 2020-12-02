package controladores;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logica.Publicador;
import logica.PublicadorService;

public class UsernameChecker extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsernameChecker() {
        super();
    }
    
 
void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession objSesion = request.getSession();
	request.setCharacterEncoding("UTF-8");
	String username = request.getParameter("nickname");
	PrintWriter out = response.getWriter();
	
	PublicadorService service = new PublicadorService();
    Publicador port = service.getPublicadorPort();
	
    if (port.existeUsuario(username)) {
	out.print("<span style=\"color:red;\">Username unavailable</span>");
    }
	
} 
	
    
    ////////////////////////////

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
