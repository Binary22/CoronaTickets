package controladores;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
		if((objSesion.getAttribute("estado_sesion") == "LOGIN_CORRECTO")){
			String nickname = (String)objSesion.getAttribute("usuario_logueado");
			HandlerUsuarios husers = HandlerUsuarios.getInstancia();
	        Usuario userlog = husers.getUsuario(nickname);
	        if(!userlog.esArtista())
	        	objSesion.setAttribute("usuariolog", userlog);
	        else {
	        	Artista userArtlog = (Artista) husers.getUsuario(nickname);
	        	objSesion.setAttribute("usuariolog", userArtlog);
	        }
	        	
			req.getRequestDispatcher("/WEB-INF/usuarios/modificarusuario.jsp").forward(req, resp);
		}
		else
			 resp.sendRedirect("registro");
	}
	
	private void processResponse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession objSesion = req.getSession();
		String nickname = (String)objSesion.getAttribute("usuario_logueado");
		HandlerUsuarios husers = HandlerUsuarios.getInstancia();
        Usuario userlog = husers.getUsuario(nickname);
		
		
		String nombre = req.getParameter("nombre");
		String apellido = req.getParameter("apellido");
		String mail = userlog.getEmail();
		String fechanac = req.getParameter("fechanac");
		String password = req.getParameter("password");
		String confipassword = req.getParameter("confirmpassword");
		String imagen = req.getParameter("avatar");
		
		Fabrica fabrica = Fabrica.getInstance();
        IUsuario ctrlU = fabrica.getIUsuario();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(fechanac, formatter);
        
        ctrlU.updateUsuarioWeb(nickname, nombre, apellido, mail, date, password, imagen);
        if(userlog.esArtista()) {
        	String descripcion = req.getParameter("descripcion");
        	String biografia = req.getParameter("biografia");
        	String website = req.getParameter("website");    
        	ctrlU.updateArtista(descripcion, biografia, website);
        }
        ctrlU.confirmarUpdateUsuarioWeb();
        resp.sendRedirect("home");
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
