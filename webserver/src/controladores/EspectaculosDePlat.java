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
import logica.DataListEspOrg;
import logica.DataPaquete;
import logica.Espectaculo;
import logica.Fabrica;
import logica.HandlerEspectaculos;
import logica.HandlerPaquetes;
import logica.HandlerPlataforma;
import logica.IEspectaculo;
import logica.IPaquete;
import logica.NoExistePaqueteException_Exception;
import logica.Paquete;
import logica.Plataforma;
import logica.Publicador;
import logica.PublicadorService;

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
    	PublicadorService service = new PublicadorService();
	    Publicador port = service.getPublicadorPort();
	    
    	if((objSesion.getAttribute("estado_sesion") == "LOGIN_CORRECTO") && ((boolean) objSesion.getAttribute("esArtista"))) {
	    	String nombPlatElegida = (String) objSesion.getAttribute("plataformaelegida");
	    	String nombPaqElegido = (String) objSesion.getAttribute("paqueteelegido");
	    	
	    	List<String> espectaculosPlatElegida = port.getEspectaculosDePlataforma(nombPlatElegida).getEspectaculosOrg();
			List<String> espectaculosList = new ArrayList<String>();
			
			
			DataPaquete paqElegido = port.getPaquete(nombPaqElegido);
	    	List<String> espdelPaqElegido = paqElegido.getEspectaculos();

	    	
	    	
	    	for (int i=0; i< espectaculosPlatElegida.size(); i++) {
				if(!espdelPaqElegido.contains(espectaculosPlatElegida.get(i)))
					espectaculosList.add(espectaculosPlatElegida.get(i));
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
    	PublicadorService service = new PublicadorService();
	    Publicador port = service.getPublicadorPort();
	    
    	String nombPaqElegido =  (String) objSesion.getAttribute("paqueteelegido");
    	String[] espectaculos = req.getParameterValues("espectaculos");

		DataListEspOrg esp = new DataListEspOrg();
	    if(espectaculos != null) {
	    	for (int i=0; i< espectaculos.length; i++) {
			   esp.getEspectaculosOrg().add(espectaculos[i]);
	    	}
	    }
	    
	    try {
			port.agregarEspAPaquete(nombPaqElegido,esp);
		} catch (NoExistePaqueteException_Exception e) {
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
