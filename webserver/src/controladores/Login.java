package controladores;

import logica.HandlerUsuarios;
import logica.Usuario;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
    }
    
 
void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession objSesion = request.getSession();
	String nickname = request.getParameter("nickname");
	String password = request.getParameter("password");
	String nuevoEstado;
        
	// chequea contraseña
	try {
		Usuario u = HandlerUsuarios.getInstancia().getUsuario(nickname);
		if(u.getPassword().equals(password)) {
			request.getSession().setAttribute("usuario_logueado", u.getNickname());
			nuevoEstado = "LOGIN_CORRECTO";
		}
		else {
			nuevoEstado = "LOGIN_INCORRECTO";
		}
	} catch(Exception ex){
		nuevoEstado = "LOGIN_INCORRECTO";
	}
	
    objSesion.setAttribute("estado_sesion", nuevoEstado);
	
	// redirige a la página principal para que luego rediriga a la página
	// que corresponde
    response.sendRedirect("home");
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
