package controladores;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		HttpSession objSesion = req.getSession();
		objSesion.setAttribute("escero",false);
		objSesion.setAttribute("nombreexiste",false);
		String nickname = (String)objSesion.getAttribute("usuario_logueado");
		HandlerUsuarios husers = HandlerUsuarios.getInstancia();
		List<String> artistas = husers.getNombresArtista();
		List<String> artistasinvi = new ArrayList<String>();
		for (int i=0; i< artistas.size(); i++) {
			if(!artistas.get(i).equals(nickname)){
				artistasinvi.add(artistas.get(i));
			}
		}	
		objSesion.setAttribute("artistas", artistasinvi);
		
		HandlerEspectaculos hesp = HandlerEspectaculos.getInstance();
		Map<String,Espectaculo> espectaculos = hesp.getEspectaculos();
		Map<String,Espectaculo> espectaculosorg = new HashMap<String,Espectaculo>();
		for (String key : espectaculos.keySet()) {
			if(espectaculos.get(key).getArtista().getNickname().equals(nickname)){
				espectaculosorg.put(key,espectaculos.get(key));
			}		
		}
		List<String> espectaculosorgreal = new ArrayList<String>();
		for(String key2 : espectaculosorg.keySet()) {
			espectaculosorgreal.add(key2);
		}
		objSesion.setAttribute("espectaculos", espectaculosorgreal);
		
		req.getRequestDispatcher("/WEB-INF/funciones/altafuncion.jsp").forward(req, resp);
	}
	
	private void processResponse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession objSesion = req.getSession();
		String nombre = req.getParameter("nombre");
		String fecha = req.getParameter("fecha");
		String horaInicio = req.getParameter("hora");
		String esp = req.getParameter("espectaculo");
		String[] invitados = req.getParameterValues("artistasinv");
		boolean entro = false;
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_TIME;
        LocalDate date = LocalDate.parse(fecha, formatter);
        LocalTime duracion = LocalTime.parse(horaInicio,dateTimeFormatter);
        LocalTime cero = LocalTime.of(00,00);
        
        if(!duracion.equals(cero)) {
	        Fabrica fabrica = Fabrica.getInstance();
	        IEspectaculo ctrlesp = fabrica.getIEspectaculo();
	        ArrayList<String> stringList = new ArrayList<String>();
	        if(invitados != null) {
		        for (int i=0; i< invitados.length; i++) {
		        	stringList.add(invitados[i]);
		        }
	        }
	        try {
				ctrlesp.elegirEspectaculo(esp);
			    ctrlesp.altaFuncion(nombre, date, duracion, stringList, LocalDate.now());
				ctrlesp.ConfirmarAltaFuncion();
			} catch (NombreFuncionexisteException e) {
				// TODO Auto-generated catch block
				objSesion.setAttribute("nombreexiste",true);
				req.getRequestDispatcher("/WEB-INF/funciones/altafuncion.jsp").forward(req, resp);
				entro = true;
			}
	        if(!entro)	
	        	resp.sendRedirect("home");
        }
        else {
        	objSesion.setAttribute("escero",true);
        	req.getRequestDispatcher("/WEB-INF/funciones/altafuncion.jsp").forward(req, resp);
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
		processResponse(request, response);
	}

}
