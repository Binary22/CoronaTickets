package controladores;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import excepciones.NoExistePaqueteException;
import logica.Fabrica;
import logica.HandlerPaquetes;
import logica.HandlerUsuarios;
import logica.IConsulta;
import logica.IEspectaculo;
import logica.IPaquete;
import logica.Paquete;
import logica.Usuario;

/**
 * Servlet implementation class Paquetes
 */
public class Paquetes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Paquetes() {
        super();
        // TODO Auto-generated constructor stub
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession objSesion = req.getSession();
		HandlerPaquetes hp = HandlerPaquetes.getInstance();
		List<String> paquetes = hp.getNombresPaquete();
		
		Map<String, Paquete> mapPaq = new HashMap<String, Paquete>();
		
		for(String p : paquetes ) {
			try {
			Paquete paq = hp.getPaquete(p);
			mapPaq.put(p, paq);
			} catch (NoExistePaqueteException e) {
				e.printStackTrace();
			}
		}
		
		
		
		objSesion.setAttribute("paquetes", mapPaq);
		
		req.getRequestDispatcher("/WEB-INF/paquetes/paquetes.jsp").forward(req, resp);
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
