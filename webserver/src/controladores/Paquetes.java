package controladores;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logica.DataPaquete;
import logica.ListaPaquete;
import logica.Publicador;
import logica.PublicadorService;

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
		PublicadorService service = new PublicadorService();
	    Publicador port = service.getPublicadorPort();		
		ListaPaquete paquetes = port.listarPaquetes();
		
		
		Map<String, DataPaquete> mapPaq = new HashMap<String, DataPaquete>();
		
		for(DataPaquete p : paquetes.getPaquetes() ) {
			mapPaq.put(p.getNombre(), p);
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
