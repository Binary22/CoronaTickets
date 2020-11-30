package controladores;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logica.DataUsuario;
import logica.Publicador;
import logica.PublicadorService;

/**
 * Servlet implementation class Usuarios
 */
@WebServlet("/Usuarios")
public class Usuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Usuarios() {
        super();
        // TODO Auto-generated constructor stub
    }
	private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PublicadorService service = new PublicadorService();
	    Publicador port = service.getPublicadorPort();
		
		HttpSession objSesion = req.getSession();
		//HandlerUsuarios hu = HandlerUsuarios.getInstancia();
		//Map<String, Usuario> hm = hu.getUsuarios();
		
		
		logica.ListaUsuario lista = port.listarUsuarios();
		List<DataUsuario> list = lista.getUsuarios();
        Map<String, DataUsuario> m = new TreeMap<String, DataUsuario>();
        for (DataUsuario datau : list) {   
        	m.put(datau.getNickname(), datau);
        	}
    	//objSesion.setAttribute("espectaculosPlat", list);
		
		objSesion.setAttribute("usuarios", m);
		
		req.getRequestDispatcher("/WEB-INF/usuarios/usuarios.jsp").forward(req, resp);
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
		processRequest(request, response);
	}

}
