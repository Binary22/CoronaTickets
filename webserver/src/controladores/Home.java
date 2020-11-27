package controladores;

import java.io.IOException;
import java.util.ArrayList;
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

import excepciones.NoExistePaqueteException;
import logica.DataEspectaculo;
import logica.DataPaquete;
import logica.Espectaculo;
import logica.HandlerEspectaculos;
import logica.HandlerPaquetes;
import logica.ListaPaquete;
import logica.Paquete;
import logica.Publicador;
import logica.PublicadorService;
import logica.ListaEspectaculo.Espectaculos.Entry;

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
		PublicadorService service = new PublicadorService();
	    Publicador port = service.getPublicadorPort();
	    logica.ListaEspectaculo lista = port.listarEspectaculos();
		List<DataEspectaculo> list = new ArrayList<DataEspectaculo>();
		
    	for(Entry e : lista.getEspectaculos().getEntry()) {
    		
    		if(e.getValue().isYaFueValuado() && !e.getValue().isFinalizado() && e.getValue().isAceptado())
    			list.add(e.getValue());
    	}
    	objSesion.setAttribute("espectaculos", list);
		
		ListaPaquete paquetes = port.listarPaquetes();		
		Map<String, DataPaquete> mapPaq = new HashMap<String, DataPaquete>();
		for(DataPaquete p : paquetes.getPaquetes() ) {
			mapPaq.put(p.getNombre(), p);
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
