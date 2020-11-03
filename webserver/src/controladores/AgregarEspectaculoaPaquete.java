package controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logica.Espectaculo;
import logica.Fabrica;
import logica.HandlerEspectaculos;
import logica.HandlerPaquetes;
import logica.HandlerPlataforma;
import logica.HandlerUsuarios;
import logica.IPaquete;

/**
 * Servlet implementation class AgregarEspectaculoaPaquete
 */
@WebServlet("/AgregarEspectaculoaPaquete")
public class AgregarEspectaculoaPaquete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarEspectaculoaPaquete() {
        super();
        // TODO Auto-generated constructor stub
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	HttpSession objSesion = req.getSession();
		objSesion.setAttribute("eligioplataforma",false);
    	HandlerPaquetes hp = HandlerPaquetes.getInstance();
    	
        
		List<String> paquetes = hp.getNombresPaquete();
		List<String> paqueteslist = new ArrayList<String>();
		for (int i=0; i< paquetes.size(); i++) {
			paqueteslist.add(paquetes.get(i));
		}	
		objSesion.setAttribute("paquetes",paqueteslist);	

		HandlerPlataforma hplat = HandlerPlataforma.getInstance();
		List<String> plataformas = hplat.getNombres();
		List<String> plataformaslist = new ArrayList<String>();
		for (int i=0; i< plataformas.size(); i++) {
			plataformaslist.add(plataformas.get(i));
		}
		objSesion.setAttribute("plataformas",plataformaslist);
		
		if(req.getParameter("plataformas") != null) {
			HandlerEspectaculos hesp = HandlerEspectaculos.getInstance();
			Map<String,Espectaculo> espectaculos = hesp.getEspectaculosPlataforma(req.getParameter("plataformas"));
			List<String> espectaculosList = new ArrayList<String>();
			for (String key : espectaculos.keySet()) {
				espectaculosList.add(espectaculos.get(key).getNombre());
			}
			objSesion.setAttribute("espectaculos",espectaculosList);
			objSesion.setAttribute("eligioplataforma",true);
		}	
    	req.getRequestDispatcher("/WEB-INF/espectaculos/agregarEspectaculoaPaquete.jsp").forward(req, resp);
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
