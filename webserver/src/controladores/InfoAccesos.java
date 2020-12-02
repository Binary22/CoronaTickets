package controladores;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datatypesweb.ListaInfo;
import datatypesweb.dataInfo;
import logica.DataInfo;
import logica.DataUsuario;
import logica.Publicador;
import logica.PublicadorService;

/**
 * Servlet implementation class InfoAccesos
 */
public class InfoAccesos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoAccesos() {
        super();
        // TODO Auto-generated constructor stub
    }
    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PublicadorService service = new PublicadorService();
	    Publicador port = service.getPublicadorPort();
		
		HttpSession objSesion = req.getSession();
		String id = req.getParameter("id");
		System.out.print(id);
		if (port.consultaAccesosValida(id)) {
			logica.ListaInfo listaInformacion = port.listarInfo();
			List<DataInfo> listaInformacionReal = listaInformacion.getInformacion();
			objSesion.setAttribute("dataInformacion", listaInformacionReal );
			
			req.getRequestDispatcher("/WEB-INF/Accesos/infoAccesos.jsp").forward(req, resp);
		} else {
			resp.sendRedirect("home");
		}
		
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
