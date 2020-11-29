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
import logica.DataFuncion;
import logica.DataPaquete;
import logica.DataUsuario;
import logica.Publicador;
import logica.PublicadorService;

/**
 * Servlet implementation class SorteoPremios
 */
@WebServlet("/SorteoPremios")
public class SorteoPremios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SorteoPremios() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	HttpSession objSesion = req.getSession();
    	PublicadorService service = new PublicadorService();
	    Publicador port = service.getPublicadorPort();
    	String nombre = req.getParameter("name");
		int iend = nombre.indexOf(";");
		String nomEspect = null;
		String nomFun = null;
		if (iend != -1) 
		{
		    nomEspect = nombre.substring(0 , iend); 
		    nomFun = nombre.substring(iend + 1,  nombre.length());
		}
		objSesion.setAttribute("espectaculo_premio", nomEspect);
		objSesion.setAttribute("funcion_premio", nomFun);
		DataFuncion fun = port.getFuncion(nomEspect, nomFun);
		objSesion.setAttribute("funcion_sorteada", fun);
		List<DataUsuario> espectadores = port.espectadoresFuncion(nomEspect, nomFun).getUsuarios();
		objSesion.setAttribute("espectadores_premios", espectadores);
    	
		req.getRequestDispatcher("/WEB-INF/Premios/sorteoPremios.jsp").forward(req, resp);
	}
    
    private void processResponse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
    	HttpSession objSesion = req.getSession();
    	PublicadorService service = new PublicadorService();
	    Publicador port = service.getPublicadorPort();
	    String nomEspect = (String)objSesion.getAttribute("espectaculo_premio");
		String nomFun = (String)objSesion.getAttribute("funcion_premio");
		port.sortearPremiosFuncion(nomEspect, nomFun);
		resp.sendRedirect("detallesEspectaculo?name="+nomEspect);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		processResponse(request, response);
	}

}
