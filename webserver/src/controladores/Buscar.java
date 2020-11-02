package controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logica.HandlerEspectaculos;
import logica.HandlerPaquetes;
import logica.Espectaculo;
import logica.Paquete;

/**
 * Servlet implementation class Buscar
 */
public class Buscar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Buscar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession objSesion = req.getSession();
		String search = req.getParameter("busqueda");
		HandlerEspectaculos he = HandlerEspectaculos.getInstance();
		HandlerPaquetes hp = HandlerPaquetes.getInstance();
		List<Espectaculo> le = he.buscarEspectaculos(search);
		List<Paquete> lp = hp.buscarPaquetes(search);
		objSesion.setAttribute("search", search);
		objSesion.setAttribute("espectaculos", le);
		objSesion.setAttribute("paquetes", lp);
		req.getRequestDispatcher("/WEB-INF/buscar/buscar.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
