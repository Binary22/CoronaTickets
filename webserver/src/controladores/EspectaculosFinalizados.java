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


import logica.DataEspectaculo;
import logica.DataListEspOrg;
import logica.Publicador;
import logica.PublicadorService;
import logica.ListaEspectaculo.Espectaculos.Entry;

/**
 * Servlet implementation class EspectaculosFinalizados
 */
@WebServlet("/EspectaculosFinalizados")
public class EspectaculosFinalizados extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EspectaculosFinalizados() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	HttpSession objSesion = req.getSession();
    	PublicadorService service = new PublicadorService();
	    Publicador port = service.getPublicadorPort();
	    
	    if((objSesion.getAttribute("estado_sesion") == "LOGIN_CORRECTO") && ((boolean) objSesion.getAttribute("esArtista"))) {
	    	String nomArtista = (String) objSesion.getAttribute("usuario_logueado");
	    	logica.ListaEspectaculo lista = port.listarEspectaculos();
	    	List<DataEspectaculo> list = new ArrayList<DataEspectaculo>();
	    	DataListEspOrg listEspOrg = port.getEspectaculos(nomArtista);
		    for(Entry e : lista.getEspectaculos().getEntry()) {
		    	if( ( e.getValue().isYaFueValuado() ) && ( e.getValue().isFinalizado() ) && ( listEspOrg.getEspectaculosOrg().contains(e.getValue().getNombre()) ) )
		    		list.add(e.getValue());
		    }
		    objSesion.setAttribute("espectaculosPlat", list);
		    req.getRequestDispatcher("/WEB-INF/espectaculos/espectaculosFinalizados.jsp").forward(req, resp);
	    }
	    else
	    	resp.sendRedirect("registro");
		
	}
    
    private void processResponse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	req.getRequestDispatcher("/WEB-INF/espectaculos/espectaculosFinalizados.jsp").forward(req, resp);
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

