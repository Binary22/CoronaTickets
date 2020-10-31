package controladores;
import logica.HandlerPlataforma;
import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logica.Espectaculo;
import logica.Fabrica;
import logica.HandlerEspectaculos;
import logica.IUsuario;
import logica.Plataforma;

/**
 * Servlet implementation class Espectaculos
 */
public class Espectaculos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Espectaculos() {
        super();
        // TODO Auto-generated constructor stub
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	HttpSession objSesion = req.getSession();
    	HandlerPlataforma hp = HandlerPlataforma.getInstance();
    	Map<String,Plataforma> plataformas = hp.getColPlataforma();
    	HandlerEspectaculos he = HandlerEspectaculos.getInstance();
    	Map<String,Espectaculo> espectaculos = (Map<String, Espectaculo>) he.listarEspectaculosAceptados();
    	
    	objSesion.setAttribute("espectaculos", espectaculos);
    	objSesion.setAttribute("plataformas", plataformas);
    	
        
		req.getRequestDispatcher("/WEB-INF/espectaculos/espectaculos.jsp").forward(req, resp);
		
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
		processRequest(request, response);
	}

}
