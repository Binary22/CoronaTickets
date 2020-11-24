package controladores;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import excepciones.NoExistePaqueteException;
import excepciones.UsuarioPaqueteComprado;
import logica.Compra;
import logica.DataCompra;
import logica.DataListPaquetes;
import logica.DataPaquete;
import logica.DataUsuario;
import logica.Fabrica;
import logica.HandlerPaquetes;
import logica.HandlerUsuarios;
import logica.IUsuario;
import logica.NoExistePaqueteException_Exception;
import logica.Paquete;
import logica.Publicador;
import logica.PublicadorService;
import logica.Usuario;
import logica.UsuarioPaqueteComprado_Exception;

/**
 * Servlet implementation class Comprapaquete
 */
public class Comprapaquete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Comprapaquete() {
        super();
        // TODO Auto-generated constructor stub
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	HttpSession objSesion = req.getSession();
    	PublicadorService service = new PublicadorService();
	    Publicador port = service.getPublicadorPort();
	    
    	if((objSesion.getAttribute("estado_sesion") == "LOGIN_CORRECTO")){
	    	String nickname = (String) objSesion.getAttribute("usuario_logueado");
	    	
	    	DataUsuario user = port.getUsuario(nickname);
	    	List<String> paquetes = port.getPaquetes().getPaquetes();
	    	
	    	
	    	List<DataCompra> comprados = user.getCompraPaquete();
	    	List<String> compradosPack = new ArrayList<String>();
	    	for(int i=0; i< comprados.size(); i++) {
	    		compradosPack.add(comprados.get(i).getPaquete());
	    	}
	    	
			List<String> paquetesList = new ArrayList<String>();
			for (int i=0; i< paquetes.size(); i++) {
				if(!compradosPack.contains(paquetes.get(i)))	
					paquetesList.add(paquetes.get(i));
			}	
			objSesion.setAttribute("paquetes",paquetesList);
	    	req.getRequestDispatcher("/WEB-INF/paquetes/comprapaquete.jsp").forward(req, resp);
    	}
    	else
    		resp.sendRedirect("registro");
	}
    
    private void processResponse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	HttpSession objSesion = req.getSession();
    	req.setCharacterEncoding("UTF-8");
    	PublicadorService service = new PublicadorService();
	    Publicador port = service.getPublicadorPort();
	    
    	String nickname = (String) objSesion.getAttribute("usuario_logueado");
    	String nombrepaqcomp = (String) req.getParameter("paquetes");
			try {
		    	String fechaActual = LocalDate.now().toString();
					try {
						port.agregarCompra(nickname,nombrepaqcomp,fechaActual);
					} catch (UsuarioPaqueteComprado_Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			} catch (NoExistePaqueteException_Exception e) {
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
