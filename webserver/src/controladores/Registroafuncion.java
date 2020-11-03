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

import logica.Espectaculo;
import logica.Fabrica;
import logica.Funcion;
import logica.HandlerEspectaculos;
import logica.HandlerUsuarios;
import logica.IEspectaculo;
import logica.IUsuario;
import logica.Usuario;
import logica.Vale;
import logica.Registro;

/**
 * Servlet implementation class Registroafuncion
 */
public class Registroafuncion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registroafuncion() {
        super();
        // TODO Auto-generated constructor stub
    }

	private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession objSesion = req.getSession();
		if(objSesion.getAttribute("estado_sesion") == "LOGIN_CORRECTO") {
			String userNickname = (String) objSesion.getAttribute("usuario_logueado");
			String nomEspect = req.getParameter("name");
	    	HandlerEspectaculos he = HandlerEspectaculos.getInstance();
	    	Espectaculo e = he.getEspectaculo(nomEspect);
	    	List<Funcion> funcionesEspect = new ArrayList<Funcion>(e.getAllFunciones().values());
	    	objSesion.setAttribute("funcionesEspectaculo", funcionesEspect);
			
	    	HandlerUsuarios hu = HandlerUsuarios.getInstancia();
	    	Usuario user = hu.getUsuario(userNickname);
	    	List<Vale> vales = user.valesACanjear(nomEspect);
	    	objSesion.setAttribute("vales_canjear", vales);
	    	
	    	Fabrica fabrica = Fabrica.getInstance();
	        IEspectaculo ctrlE = fabrica.getIEspectaculo();
	        List<Registro> registrosCanjear = ctrlE.obtenerRegistrosPreviosWeb(userNickname);
	        objSesion.setAttribute("registros_canjear", registrosCanjear);
	        
	    	
	    	req.getRequestDispatcher("/WEB-INF/funciones/registroafuncion.jsp").forward(req, resp);
		}else {
			resp.sendRedirect("registro");
		}
    	
    	
    	
		
	}
	
	private void processResponse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
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
