package controladores;
import logica.HandlerPlataforma;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logica.DataEspectaculo;
import logica.HandlerEspectaculos;
import logica.ListaEspectaculo.Espectaculos.Entry;
import logica.Plataforma;
import logica.Publicador;
import logica.PublicadorService;

/**
 * Servlet implementation class Espectaculos
 */
public class Espectaculos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Espectaculos() {
        super();
        // TODO Auto-generated constructor stub
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	HttpSession objSesion = req.getSession();
    	HandlerPlataforma hp = HandlerPlataforma.getInstance();
    	HandlerEspectaculos he = HandlerEspectaculos.getInstance();
    	PublicadorService service = new PublicadorService();
	    Publicador port = service.getPublicadorPort();
    	
    	
    	String nomPlat = (String) objSesion.getAttribute("nombrePlat");
    	if(nomPlat != null) {
    		Plataforma plat = hp.getPlataforma(nomPlat);
    		logica.ListaEspectaculo lista = port.listarEspectaculosPlataforma(nomPlat);
    		List<DataEspectaculo> list = new ArrayList<DataEspectaculo>();
	    	for(Entry e : lista.getEspectaculos().getEntry()) {
	    		list.add(e.getValue());
	    	}
	    	objSesion.setAttribute("espectaculosPlat", list);
	    	objSesion.setAttribute("nombrePlat", null);
    	}else {
    		logica.ListaEspectaculo lista = port.listarEspectaculos();
    		List<DataEspectaculo> list = new ArrayList<DataEspectaculo>();
    		
	    	for(Entry e : lista.getEspectaculos().getEntry()) {
	    		
	    		if(e.getValue().isYaFueValuado() && !e.getValue().isFinalizado() && e.getValue().isAceptado())
	    			list.add(e.getValue());
	    	}
	    	objSesion.setAttribute("espectaculosPlat", list);
    	}
    	
    	objSesion.setAttribute("plataformas", port.listarPlataformas().getItem());
    	
        
		req.getRequestDispatcher("/WEB-INF/espectaculos/espectaculos.jsp").forward(req, resp);
		
	}
    
    private void processResponse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	HttpSession objSesion = req.getSession();
    	HandlerPlataforma hp = HandlerPlataforma.getInstance();
    	String nomPlat = req.getParameter("opcionesPlat");
    	if(nomPlat != null) {
	    	
	    	objSesion.setAttribute("nombrePlat", nomPlat);
	    
    	}
	    	resp.sendRedirect("espectaculos");
    	
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
		processResponse(request, response);
	}

}
