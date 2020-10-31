package controladores;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import excepciones.NombreFuncionexisteException;
import logica.Espectaculo;
import logica.Fabrica;
import logica.HandlerEspectaculos;
import logica.HandlerUsuarios;
import logica.IEspectaculo;
import logica.IUsuario;

/**
 * Servlet implementation class Altafuncion
 */
public class Altafuncion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Altafuncion() {
        super();
        // TODO Auto-generated constructor stub
    }

	private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HandlerUsuarios husers = HandlerUsuarios.getInstancia();
		List<String> artistas = husers.getNombresArtistas();
		req.setAttribute("artistas", artistas);
		
		HandlerEspectaculos hesp = HandlerEspectaculos.getInstance();
		Map<String,Espectaculo> espectaculos = hesp.getEspectaculos();
		List<String> keys = new ArrayList<>(espectaculos.keySet());
		req.setAttribute("espectaculos", keys);
		
		req.getRequestDispatcher("/WEB-INF/funciones/altafuncion.jsp").forward(req, resp);
	}
	
	private void processResponse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("nombre");
		String fecha = req.getParameter("fecha");
		String horaInicio = req.getParameter("hora");
		String esp = req.getParameter("espectaculo");
		String[] invitados = req.getParameterValues("artistas");
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_TIME;
        LocalDate date = LocalDate.parse(fecha, formatter);
        LocalTime duracion = LocalTime.parse(horaInicio,dateTimeFormatter);
        
        Fabrica fabrica = Fabrica.getInstance();
        IEspectaculo ctrlesp = fabrica.getIEspectaculo();
        
        ArrayList<String> stringList = new ArrayList<String>(Arrays.asList(invitados));
        try {
			ctrlesp.elegirEspectaculo(esp);
        	ctrlesp.altaFuncion(nombre, date, duracion, stringList, LocalDate.now());
			ctrlesp.ConfirmarAltaFuncion();
		} catch (NombreFuncionexisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
