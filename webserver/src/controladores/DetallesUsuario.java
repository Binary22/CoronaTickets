package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logica.HandlerUsuarios;
import logica.Usuario;

/**
 * Servlet implementation class DetallesUsuario
 */
@WebServlet("/DetallesUsuario")
public class DetallesUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetallesUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }
	private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession objSesion = req.getSession();
		String nomu = req.getParameter("name");
		HandlerUsuarios hu = HandlerUsuarios.getInstancia();
		Usuario u = hu.getUsuario(nomu);
		objSesion.setAttribute("usuario", u);
		if (objSesion.getAttribute("estado_sesion") == "LOGIN_CORRECTO") {
			Usuario userlogged = hu.getUsuario((String) objSesion.getAttribute("usuario_logueado"));
			objSesion.setAttribute("userlogged", userlogged);
		}
	
		if (u.esArtista()) {
			req.getRequestDispatcher("/WEB-INF/usuarios/detallesArtista.jsp").forward(req, resp);
		} else {
			req.getRequestDispatcher("/WEB-INF/usuarios/detallesUsuario.jsp").forward(req, resp);
		}
	}
	
	private void processResponse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession objSesion = req.getSession();
		req.setCharacterEncoding("UTF-8");
		HandlerUsuarios hu = HandlerUsuarios.getInstancia();
		String accion = req.getParameter("accion");
		String usuariologueado = req.getParameter("usuariologueado");
		String usuarioaseguir = req.getParameter("usuarioaseguir");
		Usuario uloggueado = hu.getUsuario(usuariologueado);
		Usuario uaseguir = hu.getUsuario(usuarioaseguir);
		if (accion.compareTo("seguir") == 0) {
			uloggueado.agregarSeguido(uaseguir);
			uaseguir.agregarSiguiendo(uloggueado);
		} else if (accion.compareTo("dejardeseguir") == 0) {
			uloggueado.quitarSeguido(uaseguir);
			uaseguir.quitarSiguiendo(uloggueado);
		}
		
		resp.sendRedirect("detallesUsuario?name=" + req.getParameter("usuarioaseguir"));
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
