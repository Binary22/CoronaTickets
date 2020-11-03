package controladores;

import logica.Fabrica;
import logica.IEspectaculo;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import excepciones.NombreEspectaculoExisteException;

/**
 * Servlet implementation class Altaespectaculo
 */
public class Altaespectaculo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Altaespectaculo() {
        super();
        // TODO Auto-generated constructor stub
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	HttpSession session = req.getSession();
    	session.setAttribute("error", "no");
		req.getRequestDispatcher("/WEB-INF/espectaculos/altaespectaculo.jsp").forward(req, resp);
	}
    
    private void processSubmit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.setAttribute("error", "no");
		String nick = (String) session.getAttribute("usuario_logueado");
    	String nomPlataforma = req.getParameter("nomPlataforma");
    	String nombre = req.getParameter("nombre");
    	String descripcion = req.getParameter("descripcion");
    	String horas = req.getParameter("horas");
    	String minutos = req.getParameter("minutos");
    	String maxEspectadores = req.getParameter("max");
    	String minEspectadores = req.getParameter("min");
    	String url = req.getParameter("url");
    	String costo = req.getParameter("costo");
    	String imagen = req.getParameter("imagen");
    	
    	System.out.print(nomPlataforma);
    	
    	LocalTime duracion = LocalTime.of(Integer.parseInt(horas), Integer.parseInt(minutos));
    	
    	LocalDate hoy = LocalDate.now();
    	
    	Fabrica fabrica = Fabrica.getInstance();
    	IEspectaculo ctrlE = fabrica.getIEspectaculo();
    	
    	
    	try {
    	ctrlE.altaEspectaculo(nomPlataforma, nick, nombre, descripcion, duracion, 
    							Integer.parseInt(minEspectadores), Integer.parseInt(maxEspectadores),
    							url, Integer.parseInt(costo), hoy);
    	ctrlE.confirmarAltaEspectaculo();
    	resp.sendRedirect("altafuncion");

    	} catch(NombreEspectaculoExisteException e) {
    		e.printStackTrace();
    		session.setAttribute("error", e.getMessage());
    		req.getRequestDispatcher("/WEB-INF/espectaculos/altaespectaculo.jsp").forward(req, resp);
    		//devolver algo al usuario de la web !!
    	}
    	    	
        

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
		processSubmit(request, response);
	}

}
