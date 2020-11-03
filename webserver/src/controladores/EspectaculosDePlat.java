package controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import excepciones.NoExistePaqueteException;
import logica.Espectaculo;
import logica.Fabrica;
import logica.HandlerEspectaculos;
import logica.IEspectaculo;
import logica.IPaquete;

/**
 * Servlet implementation class EspectaculosDePlat
 */
@WebServlet("/EspectaculosDePlat")
public class EspectaculosDePlat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EspectaculosDePlat() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	HttpSession objSesion = req.getSession();
    	String platElegida = (String) objSesion.getAttribute("plataformaelegida");
    	
    	HandlerEspectaculos hesp = HandlerEspectaculos.getInstance();
		Map<String,Espectaculo> espectaculos = hesp.getEspectaculosPlataforma(platElegida);
		List<String> espectaculosList = new ArrayList<String>();
		for (String key : espectaculos.keySet()) {
			espectaculosList.add(espectaculos.get(key).getNombre());
		}
		objSesion.setAttribute("espectaculos",espectaculosList);
		req.getRequestDispatcher("/WEB-INF/espectaculos/espectaculosdeplat.jsp").forward(req, resp);
    }
    
    private void processResponse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	HttpSession objSesion = req.getSession();
    	String paqElegido =  (String) objSesion.getAttribute("paqueteelegido");
    	String[] espectaculos = req.getParameterValues("espectaculos");
    	
    	Fabrica fabrica = Fabrica.getInstance();
        IPaquete ctrlpaq = fabrica.getIPaquete();
        try {
			ctrlpaq.seleccionarPaquete(paqElegido);
	        if(espectaculos != null) {
		        for (int i=0; i< espectaculos.length; i++) {
		        	ctrlpaq.elegirEspectaculo(espectaculos[i]);
		        }
	        }	
		} catch (NoExistePaqueteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        resp.sendRedirect("home");
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
