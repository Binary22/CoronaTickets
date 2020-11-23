package controladores;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logica.DataEspectaculo;
import logica.DataUsuario;
import logica.HandlerUsuarios;
import logica.Publicador;
import logica.PublicadorService;
import logica.Usuario;
import logica.ListaEspectaculo.Espectaculos.Entry;

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
		PublicadorService service = new PublicadorService();
	    Publicador port = service.getPublicadorPort();
		DataUsuario u = port.getUsuario(nomu);
		objSesion.setAttribute("usuario", u);
		if (objSesion.getAttribute("estado_sesion") == "LOGIN_CORRECTO") {
			DataUsuario userlogged = port.getUsuario((String) objSesion.getAttribute("usuario_logueado"));
			objSesion.setAttribute("userlogged", userlogged);
		}
		
		logica.ListaEspectaculo lista = port.listarEspectaculos();
		Map<String, DataEspectaculo> mapaespec = new HashMap<String, DataEspectaculo>();
		for(Entry e : lista.getEspectaculos().getEntry()) {
    		mapaespec.put(e.getKey(), e.getValue());
    	}
		objSesion.setAttribute("mapaespec", mapaespec);
	
		if (port.esArtista(nomu)) {
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
		/*if (accion.compareTo("seguir") == 0) {
			uloggueado.agregarSeguido(uaseguir);
			uaseguir.agregarSiguiendo(uloggueado);
		} else if (accion.compareTo("dejardeseguir") == 0) {
			uloggueado.quitarSeguido(uaseguir);
			uaseguir.quitarSiguiendo(uloggueado);
		}*/
		
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
