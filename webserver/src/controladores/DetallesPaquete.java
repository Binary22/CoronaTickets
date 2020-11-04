package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import excepciones.NoExistePaqueteException;
import logica.HandlerPaquetes;
import logica.HandlerUsuarios;
import logica.Paquete;
import logica.Usuario;

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
		HandlerPaquetes hp = HandlerPaquetes.getInstance();
		try {
			Paquete p = hp.getPaquete(nomp);
			objSesion.setAttribute("paquete", p);
		} catch (NoExistePaqueteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
