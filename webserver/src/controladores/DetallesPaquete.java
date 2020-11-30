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
import logica.DataPaquete;
import logica.NoExistePaqueteException_Exception;
import logica.Publicador;
import logica.PublicadorService;

/**
 * Servlet implementation class DetallesPaquete
 */
@WebServlet("/DetallesPaquete")
public class DetallesPaquete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetallesPaquete() {
        super();
        // TODO Auto-generated constructor stub
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	HttpSession objSesion = req.getSession();
		String nomp = req.getParameter("name");
		PublicadorService service = new PublicadorService();
	    Publicador port = service.getPublicadorPort();
	    
		DataPaquete p;
		try {
			p = port.getPaquete(nomp);
			objSesion.setAttribute("paquete", p);
			List<DataEspectaculo> especs = new ArrayList<DataEspectaculo>();
			for (String esp : p.getEspectaculos()) {
				especs.add(port.getEspectaculo(esp));
			}
			objSesion.setAttribute("espectaculos", especs);
		} catch (NoExistePaqueteException_Exception e) {
			// TODO Auto-generated catch block
			objSesion.setAttribute("error", e.getMessage());
		}
		
		
		req.getRequestDispatcher("/WEB-INF/paquetes/detallesPaquete.jsp").forward(req, resp);

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
