package controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logica.DataPremio;
import logica.Publicador;
import logica.PublicadorService;

/**
 * Servlet implementation class VerPremios
 */
@WebServlet("/VerPremios")
public class VerPremios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerPremios() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	HttpSession objSesion = req.getSession();
    	PublicadorService service = new PublicadorService();
	    Publicador port = service.getPublicadorPort();
	    String userNickname = (String) objSesion.getAttribute("usuario_logueado");
	    List<DataPremio> premios = port.getPremiosUsuarios(userNickname).getPremios();
	    objSesion.setAttribute("premios_usuario", premios);
	    
	    req.getRequestDispatcher("/WEB-INF/Premios/verPremios.jsp").forward(req, resp);
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
		processRequest(request, response);
	}

}
