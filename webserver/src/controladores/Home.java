package controladores;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Provider;

import excepciones.NoExistePaqueteException;
import logica.Espectaculo;
import logica.HandlerEspectaculos;
import logica.HandlerPaquetes;
import logica.Paquete;

/**
 * Servlet implementation class Home
 */

public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Home() {
    	super();
    }
     
	private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession objSesion = req.getSession();
		
		String browserName = req.getHeaders("user-agent").nextElement();	
		if (browserName.contains("Mobile") ) {
			resp.sendRedirect("mobileHome");
    		return;
		}
		
		HandlerEspectaculos he = HandlerEspectaculos.getInstance();
		objSesion.setAttribute("espectaculos", he.getEspectaculos().values());
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
		objSesion.setAttribute("paquetes", mapPaq.values());
		
		req.getRequestDispatcher("/WEB-INF/home/home.jsp").forward(req, resp);
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
