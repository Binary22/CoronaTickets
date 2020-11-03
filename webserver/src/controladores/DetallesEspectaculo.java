package controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logica.Espectaculo;
import logica.HandlerEspectaculos;
import logica.HandlerPaquetes;
import logica.Paquete;

/**
 * Servlet implementation class DetallesEspectaculo
 */
@WebServlet("/DetallesEspectaculo")
public class DetallesEspectaculo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetallesEspectaculo() {
        super();
        // TODO Auto-generated constructor stub
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	HttpSession objSesion = req.getSession();
    	String nomEspect = req.getParameter("name");
    	HandlerEspectaculos he = HandlerEspectaculos.getInstance();
    	Espectaculo espect = he.getEspectaculo(nomEspect);
    	
    	HandlerPaquetes hpaq = HandlerPaquetes.getInstance();
    	List<Paquete> paquetes = hpaq.getPaquetesDeEspectaculoWeb(nomEspect);
    	
    	objSesion.setAttribute("paquetes", paquetes);
    	objSesion.setAttribute("espectaculo_selected", espect);
    	
		req.getRequestDispatcher("/WEB-INF/espectaculos/detallesEspectaculo.jsp").forward(req, resp);
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
		processRequest(request, response);
	}

}
