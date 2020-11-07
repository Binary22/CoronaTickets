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
import logica.Fabrica;
import logica.HandlerPaquetes;
import logica.HandlerUsuarios;
import logica.IUsuario;
import logica.Paquete;
import logica.Usuario;

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
    	if((objSesion.getAttribute("estado_sesion") == "LOGIN_CORRECTO")){
	    	String nickname = (String) objSesion.getAttribute("usuario_logueado");
	    	
	    	HandlerPaquetes hp = HandlerPaquetes.getInstance();
	    	HandlerUsuarios hs = HandlerUsuarios.getInstancia();
	    	Usuario user = hs.getUsuario(nickname);
	    	
	    	List<Compra> comprados = user.getCompraPaquete();
	    	List<String> compradospaq = new ArrayList<String>();
	    	for(int i=0; i< comprados.size(); i++) {
	    		compradospaq.add(comprados.get(i).getPaquete().getNombre());
	    	}
	    	
	    	List<String> paquetes = hp.getNombresPaquete();
			List<String> paqueteslist = new ArrayList<String>();
			for (int i=0; i< paquetes.size(); i++) {
				if(!compradospaq.contains(paquetes.get(i)))	
					paqueteslist.add(paquetes.get(i));
			}	
			objSesion.setAttribute("paquetes",paqueteslist);
	    	req.getRequestDispatcher("/WEB-INF/paquetes/comprapaquete.jsp").forward(req, resp);
    	}
    	else
    		resp.sendRedirect("registro");
	}
    
    private void processResponse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	HttpSession objSesion = req.getSession();
    	req.setCharacterEncoding("UTF-8");
    	String nickname = (String) objSesion.getAttribute("usuario_logueado");
    	String nombrepaqcomp = (String) req.getParameter("paquetes");
    	
    	HandlerPaquetes hp = HandlerPaquetes.getInstance();
    	Paquete paqcomp;
		try {
			paqcomp = hp.getPaquete(nombrepaqcomp);
	    	HandlerUsuarios hs = HandlerUsuarios.getInstancia();
	    	Usuario user = hs.getUsuario(nickname);
	    	Compra comprado = new Compra(LocalDate.now(),paqcomp);
	    	try {
				user.agregarcompra(comprado);
			} catch (UsuarioPaqueteComprado e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoExistePaqueteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
