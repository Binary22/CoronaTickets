package controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logica.DataEspectaculo;
import logica.DataFuncion;
import logica.Publicador;
import logica.PublicadorService;

public class ConsultaFuncion extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaFuncion() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
	private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession objSesion = req.getSession();
		objSesion.setAttribute("noEligioTres", false);
		objSesion.setAttribute("errorExisteRegFun", false);
		objSesion.setAttribute("errorFunAlcanzoLimite", false);
		objSesion.setAttribute("funciones_vacias", false);
		objSesion.setAttribute("fecha_invalida", false);
		objSesion.setAttribute("vale_vacio", false);
		
		if(objSesion.getAttribute("estado_sesion") == "LOGIN_CORRECTO") {
			String userNickname = (String) objSesion.getAttribute("usuario_logueado");
			String nombre = req.getParameter("name");
			int iend = nombre.indexOf(";");
			String nomEspect = null;
			String nomFun = null;
			if (iend != -1) 
			{
			    nomEspect = nombre.substring(0 , iend); 
			    nomFun = nombre.substring(iend + 1,  nombre.length());
			}
			
			objSesion.setAttribute("espectaculo_recordar", nomEspect);
			PublicadorService service = new PublicadorService();
		    Publicador port = service.getPublicadorPort();
			
	    	
	    	DataEspectaculo e = port.getEspectaculo(nomEspect);
	    	Map<String, DataFuncion> funs = new HashMap<String, DataFuncion>();
            for(DataEspectaculo.SetFunciones.Entry en : e.getSetFunciones().getEntry()) {
                funs.put(en.getKey(), en.getValue());
            }
            DataFuncion funPrimera = funs.get(nomFun);
	    	List<DataFuncion> funcionesEspect = new ArrayList<DataFuncion>(funs.values());
	    	int itemPos = funcionesEspect.indexOf(funPrimera);
	    	funcionesEspect.remove(itemPos);
	    	funcionesEspect.add(0, funPrimera);
	    	objSesion.setAttribute("espectaculo_fun", e);
	    	objSesion.setAttribute("funcionesEspectaculo", funcionesEspect);
				        
	    	
	    	req.getRequestDispatcher("/WEB-INF/funciones/consultaFuncion.jsp").forward(req, resp);
		} else {
			resp.sendRedirect("registro");
		}
	}
	
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
};