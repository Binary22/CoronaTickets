package controladores;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import excepciones.PaqueteConMismoNombreException;
import logica.Fabrica;
import logica.IEspectaculo;
import logica.IPaquete;

/**
 * Servlet implementation class CrearPaquete
 */
@WebServlet("/CrearPaquete")
public class CrearPaquete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearPaquete() {
        super();
        // TODO Auto-generated constructor stub
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	HttpSession objSesion = req.getSession();
    	if((objSesion.getAttribute("estado_sesion") == "LOGIN_CORRECTO") && ((boolean) objSesion.getAttribute("esArtista"))) {
	    	objSesion.setAttribute("nombreexiste",false);
			req.getRequestDispatcher("/WEB-INF/paquetes/crearPaquete.jsp").forward(req, resp);
    	}
    	else
    		resp.sendRedirect("registro");
	}
    
    private void processResponse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	HttpSession objSesion = req.getSession();
		String nombre = req.getParameter("nombre");
		String fechaini = req.getParameter("fechaini");
		String fechafin = req.getParameter("fechafin");
		String desc = req.getParameter("descripcion");
		String descuento = req.getParameter("descuento");
		boolean entro = false;
		
		int discount = Integer.parseInt(descuento); 
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dateini = LocalDate.parse(fechaini, formatter);
		LocalDate datefin = LocalDate.parse(fechafin, formatter);
		
		Fabrica fabrica = Fabrica.getInstance();
        IPaquete ctrlpaq = fabrica.getIPaquete();
        try {
			ctrlpaq.crearPaquete(nombre, desc, dateini, datefin, discount, LocalDate.now());
			ctrlpaq.confirmarCrearPaquete();
		} catch (PaqueteConMismoNombreException e) {
			objSesion.setAttribute("nombreexiste",true);
			entro = true;
			req.getRequestDispatcher("/WEB-INF/paquetes/crearPaquete.jsp").forward(req, resp);		
		}
        if(!entro)
        	resp.sendRedirect("home");
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
