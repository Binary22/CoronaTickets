package controladores;

import logica.Publicador;
import logica.PublicadorService;
import java.io.IOException;

import javax.servlet.ServletException;
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
	request.setCharacterEncoding("UTF-8");
	String nickname = request.getParameter("nickname");
	String password = request.getParameter("password");
	String nuevoEstado;
	
	PublicadorService service = new PublicadorService();
    Publicador port = service.getPublicadorPort();
    String browserName = request.getHeaders("user-agent").nextElement();
    if (browserName.contains("Mobile")) {
    	objSesion.setAttribute("Mobile", true);
    	if (request.getParameter("recordar") != null) {
    		objSesion.setMaxInactiveInterval(-1); // no expira la sesion
    	} else {
    		objSesion.setMaxInactiveInterval(5); // la sesion expira 5 segundos despues de la ultima request.
    	}
    }
	// chequea contraseña
	try {
		//Usuario u = HandlerUsuarios.getInstancia().getUsuario(nickname);
		
		
		if(port.loginCorrecto(nickname, password)) {
			request.getSession().setAttribute("usuario_logueado", nickname);
			nuevoEstado = "LOGIN_CORRECTO";
			if(port.esArtista(nickname)) {			
				if (browserName.contains("Mobile")) {
					nuevoEstado = "LOGIN_INCORRECTO";
				} else {
				objSesion.setAttribute("esArtista", true);
				}
			}else {
				objSesion.setAttribute("esArtista", false);
			}
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
