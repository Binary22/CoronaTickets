package controladores;
import logica.UsuarioController;
import logica.Fabrica;
import logica.IUsuario;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

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
		HashMap<String, String> form = new HashMap<String, String>();
		form.put("nickname", "");
		form.put("nombre", "");
		form.put("apellido", "");
		form.put("mail", "");
		form.put("fechanac", "");
		form.put("password", "");
		form.put("confipassword", "");
		form.put("imagen", "");
		form.put("esArtista", "");
		form.put("descrip", "");
		form.put("bio", "");
		form.put("website", "");
		
		
		HttpSession objSesion = req.getSession();
		objSesion.setAttribute("form", form);
		objSesion.setAttribute("contraNoCoincide", false);
		objSesion.setAttribute("fechaInvalida", false);
		objSesion.setAttribute("mismoMail", false);
		objSesion.setAttribute("mismoNick", false);
		req.getRequestDispatcher("/WEB-INF/usuarios/registro.jsp").forward(req, resp);
	}
	
	private void processResponse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		HttpSession objSesion = req.getSession();
		String nickname = req.getParameter("nickname");
		String nombre = req.getParameter("nombre");
		String apellido = req.getParameter("apellido");
		String mail = req.getParameter("mail");
		String fechanac = req.getParameter("fechaNac");
		String password = req.getParameter("password");
		String confipassword = req.getParameter("confPassword");
		String imagen = req.getParameter("imagen");
		String esArtista = req.getParameter("esArtista");
		
		Map<String, String> form = new HashMap<String, String>();
		form.put("nickname", nickname);
		form.put("nombre", nombre);
		form.put("apellido", apellido);
		form.put("mail", mail);
		form.put("fechanac", fechanac);
		form.put("password", password);
		form.put("confipassword", confipassword);
		form.put("imagen", imagen);
		form.put("descrip", "");
		form.put("bio", "");
		form.put("website", "");
		
		
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
				
				form.put("descrip", descrip);
				form.put("bio", bio);
				form.put("website", website);
				
				try {
					ctrlU.altaArtistaWeb(nickname, nombre, apellido, mail, date, descrip, bio, website, password, imagen);
					ctrlU.confirmarAltaUsuario();
					req.getSession().setAttribute("usuario_logueado", nickname);
					objSesion.setAttribute("estado_sesion", "LOGIN_CORRECTO");	
					objSesion.setAttribute("esArtista", true);
					resp.sendRedirect("home");
				} catch (UsuarioConMismoNickException e) {
					objSesion.setAttribute("mismoNick", true);
					objSesion.setAttribute("contraNoCoincide", false);
		    		objSesion.setAttribute("fechaInvalida", false);
		    		objSesion.setAttribute("mismoMail", false);
		    		objSesion.setAttribute("form", form);
					req.getRequestDispatcher("/WEB-INF/usuarios/registro.jsp").forward(req, resp);
				} catch (UsuarioConMismoMailException e) {
					objSesion.setAttribute("mismoMail", true);
					objSesion.setAttribute("contraNoCoincide", false);
		    		objSesion.setAttribute("fechaInvalida", false);
		    		objSesion.setAttribute("mismoNick", false);
		    		objSesion.setAttribute("form", form);
					req.getRequestDispatcher("/WEB-INF/usuarios/registro.jsp").forward(req, resp);
				}	
			}else{
				try {
					ctrlU.altaUsuarioWeb(nickname, nombre, apellido, mail, date, password, imagen);
					ctrlU.confirmarAltaUsuario();
					req.getSession().setAttribute("usuario_logueado", nickname);
					objSesion.setAttribute("estado_sesion", "LOGIN_CORRECTO");	
					objSesion.setAttribute("esArtista", false);
					resp.sendRedirect("home");
				} catch (UsuarioConMismoNickException e) {
					objSesion.setAttribute("mismoNick", true);
					objSesion.setAttribute("contraNoCoincide", false);
		    		objSesion.setAttribute("fechaInvalida", false);
		    		objSesion.setAttribute("mismoMail", false);
		    		objSesion.setAttribute("form", form);
					req.getRequestDispatcher("/WEB-INF/usuarios/registro.jsp").forward(req, resp);
				} catch (UsuarioConMismoMailException e) {
					objSesion.setAttribute("mismoMail", true);
					objSesion.setAttribute("contraNoCoincide", false);
		    		objSesion.setAttribute("fechaInvalida", false);
		    		objSesion.setAttribute("mismoNick", false);
		    		objSesion.setAttribute("form", form);
					req.getRequestDispatcher("/WEB-INF/usuarios/registro.jsp").forward(req, resp);
				}	
			}
        }else{
	        	if(!password.equals(confipassword)) {
		    		objSesion.setAttribute("contraNoCoincide", true);
		    		objSesion.setAttribute("fechaInvalida", false);
		    		objSesion.setAttribute("mismoMail", false);
		    		objSesion.setAttribute("mismoNick", false);
		    
	        	}else {
		    		objSesion.setAttribute("fechaInvalida", true);
		    		objSesion.setAttribute("contraNoCoincide", false);
		    		objSesion.setAttribute("mismoMail", false);
		    		objSesion.setAttribute("mismoNick", false);
	        	}
	        	objSesion.setAttribute("form", form);
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
