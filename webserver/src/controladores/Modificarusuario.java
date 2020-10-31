package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logica.Artista;
import logica.Fabrica;
import logica.HandlerUsuarios;
import logica.IUsuario;
import logica.Usuario;

/**
 * Servlet implementation class Modificarusuario
 */
public class Modificarusuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Modificarusuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession objSesion = req.getSession();
		String nickname = (String)objSesion.getAttribute("usuario_logueado");
		HandlerUsuarios husers = HandlerUsuarios.getInstancia();
		System.out.print(nickname);
        Usuario userlog = husers.getUsuario(nickname);
        
        objSesion.setAttribute("usuariolog", userlog);
		req.getRequestDispatcher("/WEB-INF/usuarios/modificarusuario.jsp").forward(req, resp);
	}
	
	private void processResponse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
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
