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
import logica.HandlerPaquetes;
import logica.HandlerPlataforma;
import logica.IEspectaculo;
import logica.IPaquete;
import logica.Paquete;
import logica.Plataforma;

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
    
    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NoExistePaqueteException {
    	HttpSession objSesion = req.getSession();
    	if((objSesion.getAttribute("estado_sesion") == "LOGIN_CORRECTO") && ((boolean) objSesion.getAttribute("esArtista"))) {
	    	String nombPlatElegida = (String) objSesion.getAttribute("plataformaelegida");
	    	String nombPaqElegido = (String) objSesion.getAttribute("paqueteelegido");
	    	
	    	HandlerEspectaculos hesp = HandlerEspectaculos.getInstance();
			Map<String,Espectaculo> espectaculos = hesp.getEspectaculosDePlataforma(nombPlatElegida);
			List<String> espectaculosList = new ArrayList<String>();
			
			
			HandlerPaquetes hpaq = HandlerPaquetes.getInstance();
	    	Paquete paqElegido = hpaq.getPaquete(nombPaqElegido);
	    	Map<String,Espectaculo> espdelPaqElegido = (Map<String, Espectaculo>) paqElegido.getEspectaculos();
			
			for (String key : espectaculos.keySet()) {
				if( ( !espdelPaqElegido.containsKey(espectaculos.get(key).getNombre()) ) )
					espectaculosList.add(espectaculos.get(key).getNombre());
			}
			objSesion.setAttribute("espectaculos",espectaculosList);
			req.getRequestDispatcher("/WEB-INF/espectaculos/espectaculosdeplat.jsp").forward(req, resp);
    	}
    	else
    		resp.sendRedirect("registro");
    }
    
    private void processResponse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NoExistePaqueteException {
    	HttpSession objSesion = req.getSession();
    	req.setCharacterEncoding("UTF-8");
    	String nombPaqElegido =  (String) objSesion.getAttribute("paqueteelegido");
    	String[] espectaculos = req.getParameterValues("espectaculos");

    	Fabrica fabrica = Fabrica.getInstance();
        IPaquete ctrlpaq = fabrica.getIPaquete();
        
		ctrlpaq.seleccionarPaquete(nombPaqElegido);
	    if(espectaculos != null) {
	    	for (int i=0; i< espectaculos.length; i++) {
			   ctrlpaq.elegirEspectaculo(espectaculos[i]);
			   ctrlpaq.confirmarAgregarEspectAPaquete();
	    	}
	    }
        resp.sendRedirect("home");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			processRequest(request, response);
		} catch (ServletException | IOException | NoExistePaqueteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			try {
				processResponse(request, response);
			} catch (ServletException | IOException | NoExistePaqueteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
