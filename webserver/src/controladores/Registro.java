package controladores;
import logica.UsuarioController;
import logica.Fabrica;
import logica.IUsuario;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import excepciones.UsuarioConMismoMailException;
import excepciones.UsuarioConMismoNickException;

/**
 * Servlet implementation class Registro
 */
public class Registro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registro() {
        super();
        // TODO Auto-generated constructor stub
    }

	private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession objSesion = req.getSession();
		objSesion.setAttribute("contraNoCoincide", false);
		objSesion.setAttribute("fechaInvalida", false);
		objSesion.setAttribute("mismoMail", false);
		objSesion.setAttribute("mismoNick", false);
		req.getRequestDispatcher("/WEB-INF/usuarios/registro.jsp").forward(req, resp);
	}
	
	private void processResponse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		HttpSession objSesion = req.getSession();
		boolean entro = false;
		String nickname = req.getParameter("nickname");
		String nombre = req.getParameter("nombre");
		String apellido = req.getParameter("apellido");
		String mail = req.getParameter("mail");
		String fechanac = req.getParameter("fechaNac");
		String password = req.getParameter("password");
		String confipassword = req.getParameter("confPassword");
		String imagen = req.getParameter("imagen");
		String esArtista = req.getParameter("esArtista");
		
		
		
		Fabrica fabrica = Fabrica.getInstance();
        IUsuario ctrlU = fabrica.getIUsuario();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(fechanac, formatter);
		//si es artista
        if( (password.equals(confipassword) ) && ( ( date.isEqual(LocalDate.now())) || ( date.isBefore(LocalDate.now()) ) ) ) {
			if(esArtista != null) {
				String descrip = req.getParameter("descripcion");
				String bio = req.getParameter("biografia");
				String website = req.getParameter("website");
				try {
					ctrlU.altaArtistaWeb(nickname, nombre, apellido, mail, date, descrip, bio, website, password, imagen);
				} catch (UsuarioConMismoNickException e) {
					objSesion.setAttribute("mismoNick", true);
					objSesion.setAttribute("contraNoCoincide", false);
		    		objSesion.setAttribute("fechaInvalida", false);
		    		objSesion.setAttribute("mismoMail", false);
					entro = true;
				} catch (UsuarioConMismoMailException e) {
					objSesion.setAttribute("mismoMail", true);
					objSesion.setAttribute("contraNoCoincide", false);
		    		objSesion.setAttribute("fechaInvalida", false);
		    		objSesion.setAttribute("mismoNick", false);
					entro = true;
				}
				if(entro) {
					req.getRequestDispatcher("/WEB-INF/usuarios/registro.jsp").forward(req, resp);
				}
				
			}else {
				try {
					ctrlU.altaUsuarioWeb(nickname, nombre, apellido, mail, date, password, imagen);
				} catch (UsuarioConMismoNickException e) {
					objSesion.setAttribute("mismoNick", true);
					objSesion.setAttribute("contraNoCoincide", false);
		    		objSesion.setAttribute("fechaInvalida", false);
		    		objSesion.setAttribute("mismoMail", false);
		    		entro = true;
				} catch (UsuarioConMismoMailException e) {
					objSesion.setAttribute("mismoMail", true);
					objSesion.setAttribute("contraNoCoincide", false);
		    		objSesion.setAttribute("fechaInvalida", false);
		    		objSesion.setAttribute("mismoNick", false);
		    		entro = true;
				}
				if(entro) {
					req.getRequestDispatcher("/WEB-INF/usuarios/registro.jsp").forward(req, resp);
				}
					
			}
			if(!entro) {
					ctrlU.confirmarAltaUsuario();
		
					req.getSession().setAttribute("usuario_logueado", nickname);
					
					if(esArtista != null) {
						objSesion.setAttribute("esArtista", true);
					}else {
						objSesion.setAttribute("esArtista", false);
					}	
				objSesion.setAttribute("estado_sesion", "LOGIN_CORRECTO");	
				resp.sendRedirect("home"); 	
			}
			
        }else {
	        	if(!password.equals(confipassword)) {
		    		objSesion.setAttribute("contraNoCoincide", true);
		    		objSesion.setAttribute("fechaInvalida", false);
		    
	        	}else {
		    		objSesion.setAttribute("fechaInvalida", true);
		    		objSesion.setAttribute("contraNoCoincide", false);
	        	}
	        	req.getRequestDispatcher("/WEB-INF/usuarios/registro.jsp").forward(req, resp);
        }
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
		processResponse(request, response);

	}

}
