package controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datatypesweb.dataEspectaculo;
import logica.DataArtista;
import logica.DataEspectaculo;
import logica.DataFuncion;
import logica.DataListEspOrg;
import logica.DataListFunsEspect;
import logica.DataPaquete;
import logica.DataUsuario;
import logica.Publicador;
import logica.PublicadorService;

/**
 * Servlet implementation class DetallesEspectaculo
 */
@WebServlet("/DetallesEspectaculo")
public class DetallesEspectaculo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetallesEspectaculo() {
        super();
        // TODO Auto-generated constructor stub
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	HttpSession objSesion = req.getSession();
    	String nomEspect = req.getParameter("name");
    	PublicadorService service = new PublicadorService();
	    Publicador port = service.getPublicadorPort();
    	DataEspectaculo espect = port.getEspectaculo(nomEspect);
    	String userNickname = (String) objSesion.getAttribute("usuario_logueado");
		if (objSesion.getAttribute("estado_sesion") == "LOGIN_CORRECTO") {
			DataUsuario userlogged = port.getUsuario((String) objSesion.getAttribute("usuario_logueado"));
			objSesion.setAttribute("userlogged", userlogged);
		}
    	
    	if(objSesion.getAttribute("estado_sesion") == "LOGIN_CORRECTO") {
	    	if(port.esArtista(userNickname)) {
	    		List<String> espects = port.getEspectaculos(userNickname).getEspectaculosOrg();
	    		if(espects.contains(nomEspect)) {
	    			objSesion.setAttribute("esArtistaOrg", true);
	    		}else {
	    			objSesion.setAttribute("esArtistaOrg", false);
	    		}	
	    	}else {
	    		objSesion.setAttribute("esArtistaOrg", false);
	    	}
    	}else {
    		objSesion.setAttribute("esArtistaOrg", false);
    	}
    	logica.ListaPaquete lista = port.listarPaquetesEspectaculo(nomEspect);
		List<DataPaquete> paquetes = new ArrayList<DataPaquete>(lista.getPaquetes());
		Map<String, DataPaquete> paqs = new HashMap<String, DataPaquete>();
		for(int i = 0; i < paquetes.size(); i++) {
			paqs.put(paquetes.get(i).getNombre(), paquetes.get(i));
		}
		List<String> nombresPaq = new ArrayList<String>(paqs.keySet());
		nombresPaq.sort(String::compareToIgnoreCase);
		List<DataPaquete> paquetesEspect = new ArrayList<DataPaquete>();
		for(String key : nombresPaq) {
			paquetesEspect.add(paqs.get(key));
			}
		Map<String, DataFuncion> funciones = new HashMap<String, DataFuncion>();
        for(logica.DataListFunsEspect.FuncionesEspect.Entry e : port.funcionesEspectaculo(nomEspect).getFuncionesEspect().getEntry()) {
            funciones.put(e.getKey(),e.getValue());
        }
        objSesion.setAttribute("funciones_espectaculo", funciones);
		objSesion.setAttribute("paquetes", paquetesEspect);
    	objSesion.setAttribute("espectaculo_selected", espect);
    	
		req.getRequestDispatcher("/WEB-INF/espectaculos/detallesEspectaculo.jsp").forward(req, resp);
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
