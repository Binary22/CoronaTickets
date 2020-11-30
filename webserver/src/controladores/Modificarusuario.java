package controladores;

import java.io.IOException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logica.DataArtista;
import logica.DataUsuario;
import logica.Publicador;
import logica.PublicadorService;

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
		objSesion.setAttribute("contraNoCoincide", false);
		objSesion.setAttribute("fechaInvalida", false);
		PublicadorService service = new PublicadorService();
	    Publicador port = service.getPublicadorPort();
		
		if((objSesion.getAttribute("estado_sesion") == "LOGIN_CORRECTO")){
			String nickname = (String)objSesion.getAttribute("usuario_logueado");
	        if(!port.esArtista(nickname)) {
	        	DataUsuario userlog = port.getUsuario(nickname);
	        	objSesion.setAttribute("esArtista", false);
	        	objSesion.setAttribute("usuariolog", userlog);
	        }else {
	        	DataArtista userArtlog = port.getArtista(nickname);
	        	objSesion.setAttribute("esArtista", true);
	        	objSesion.setAttribute("usuariolog", userArtlog);
	        }
	        	
			req.getRequestDispatcher("/WEB-INF/usuarios/modificarusuario.jsp").forward(req, resp);
		}
		else
			 resp.sendRedirect("registro");
	}
	
	private void processResponse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession objSesion = req.getSession();
		req.setCharacterEncoding("UTF-8");
		PublicadorService service = new PublicadorService();
	    Publicador port = service.getPublicadorPort();
        
		String nickname = (String)objSesion.getAttribute("usuario_logueado");
		String nombre = req.getParameter("nombre");
		String apellido = req.getParameter("apellido");
		String mail = port.getMailUsuario(nickname);
		String fechanac = req.getParameter("fechanac");
		String password = req.getParameter("password");
		String confipassword = req.getParameter("confirmpassword");
		String imagen = req.getParameter("avatar");
		
		
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(fechanac, formatter);
        
	    if( (password.equals(confipassword) ) && ( ( date.isEqual(LocalDate.now())) || ( date.isBefore(LocalDate.now()) ) ) ) {    
	    	port.updateUsuarioWeb(nickname, nombre, apellido, mail, fechanac, password, imagen);
	        if(port.esArtista(nickname)) {
	        	String descripcion = req.getParameter("descripcion");
	        	String biografia = req.getParameter("biografia");
	        	String website = req.getParameter("website");    
	        	port.updateArtista(descripcion, biografia, website);
	        }
	        resp.sendRedirect("home");
	    }
	    else {
	    	if(!password.equals(confipassword)) {
	    		objSesion.setAttribute("contraNoCoincide", true);
	    		objSesion.setAttribute("fechaInvalida", false);
	    
        	}else {
	    		objSesion.setAttribute("fechaInvalida", true);
	    		objSesion.setAttribute("contraNoCoincide", false);
        	}
	    	req.getRequestDispatcher("/WEB-INF/usuarios/modificarusuario.jsp").forward(req, resp);
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
		// TODO Auto-generated method stub
		processResponse(request, response);
	}

}
