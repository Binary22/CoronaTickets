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

import excepciones.fechaPosterior;
import excepciones.noSeleccionoTres;
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
		objSesion.setAttribute("noEligioTres", false);
		objSesion.setAttribute("errorExisteRegFun", false);
		objSesion.setAttribute("errorFunAlcanzoLimite", false);
		objSesion.setAttribute("funciones_vacias", false);
		objSesion.setAttribute("fecha_invalida", false);
		
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
			System.out.println("esto es una prueba de substring");
			System.out.println("espectaculo " + nomEspect);
			System.out.println("funcion " + nomFun);
			
			objSesion.setAttribute("espectaculo_recordar", nomEspect);
			
	    	HandlerEspectaculos he = HandlerEspectaculos.getInstance();
	    	Espectaculo e = he.getEspectaculo(nomEspect);
	    	Funcion funPrimera = e.getAllFunciones().get(nomFun);
	    	List<Funcion> funcionesEspect = new ArrayList<Funcion>(e.getAllFunciones().values());
	    	int itemPos = funcionesEspect.indexOf(funPrimera);
	    	funcionesEspect.remove(itemPos);
	    	funcionesEspect.add(0, funPrimera);
	    	objSesion.setAttribute("espectaculo_fun", e);
	    	objSesion.setAttribute("funcionesEspectaculo", funcionesEspect);
			
	    	HandlerUsuarios hu = HandlerUsuarios.getInstancia();
	    	Usuario user = hu.getUsuario(userNickname);
	    	List<Vale> vales = user.valesACanjear(nomEspect);
	    	List<Registro> allRegs = user.getRegistros();
	    	objSesion.setAttribute("registros_usuario", allRegs);
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
		HttpSession objSesion = req.getSession();
		req.setCharacterEncoding("UTF-8");
		
		String userNickname = (String) objSesion.getAttribute("usuario_logueado");
		String espectaculo = (String) objSesion.getAttribute("espectaculo_recordar");
		String nomFuncion = req.getParameter("funcion_seleccionada");
		Fabrica fabrica = Fabrica.getInstance();
        IEspectaculo ctrlE = fabrica.getIEspectaculo();
        System.out.println("esto es el nombre del espectaculo " + espectaculo);
        System.out.println("esto es el nombre de la funcion " + nomFuncion);
       
        ctrlE.ingresarNombreEspectador(userNickname);
        ctrlE.ingresarNombreFuncion(nomFuncion);
        
        try {
			ctrlE.esFechaInvalida(espectaculo, LocalDate.now());
		} catch (fechaPosterior e1) {
			// TODO Auto-generated catch block
			ctrlE.ingresarNombreFuncion(null);
			objSesion.setAttribute("fecha_invalida", true);
			req.getRequestDispatcher("/WEB-INF/funciones/registroafuncion.jsp").forward(req, resp);
		}
        
		if(req.getParameter("forma").compareTo("canjeregistros") == 0) {
			String[] regsSelected = req.getParameterValues("registros_previos");
			if(regsSelected != null) {
			
				int[] ids = new int[3];
				
			        List<Registro> registrosCanjear = ctrlE.obtenerRegistrosPreviosWeb(userNickname);
			        int j = 0;
			        for(int i = 0; i < registrosCanjear.size(); i++) {
			        	String nombre = registrosCanjear.get(i).getFuncion().getNombre();
			        	for(int t = 0; t < regsSelected.length; t++) {
				        	if(nombre.compareTo(regsSelected[t]) == 0){
				        		ids[j] = registrosCanjear.get(i).getId();
				        		System.out.println(j+"numeros for");
				        		j = j+1;
				        	}
			        	
			        	}
			        	
			        }
			        for(int i = 0; i < ids.length; i++) {
			        	System.out.print(ids[i]);
			        	System.out.println("prueba numeros");
			        }
			       
			        try {
						ctrlE.canjearRegistros(ids);
					} catch (noSeleccionoTres e) {
						// TODO Auto-generated catch block
						ctrlE.ingresarNombreFuncion(null);
						objSesion.setAttribute("noEligioTres", true);
						req.getRequestDispatcher("/WEB-INF/funciones/registroafuncion.jsp").forward(req, resp);
					}
			        
			        if(ctrlE.existeRegistroEspecAFun()){
			        	ctrlE.ingresarNombreFuncion(null);
						objSesion.setAttribute("errorExisteRegFun", true);
						req.getRequestDispatcher("/WEB-INF/funciones/registroafuncion.jsp").forward(req, resp);
						
					}
			        if(ctrlE.funcionAlcanzoLimiteReg(espectaculo)){
			        	ctrlE.ingresarNombreFuncion(null);
						objSesion.setAttribute("errorFunAlcanzoLimite", true);
						req.getRequestDispatcher("/WEB-INF/funciones/registroafuncion.jsp").forward(req, resp);
					}
			        
			      if(!ctrlE.existeRegistroEspecAFun() && !ctrlE.funcionAlcanzoLimiteReg(espectaculo)) {
					ctrlE.confirmarRegistro(espectaculo, LocalDate.now());
					ctrlE.ingresarNombreFuncion(null);
			      }
					
			        
			}else {
				objSesion.setAttribute("funciones_vacias", true);
				req.getRequestDispatcher("/WEB-INF/funciones/registroafuncion.jsp").forward(req, resp);
			}
		        
	        }else if(req.getParameter("forma").compareTo("tradicional")==0){
	        	if(ctrlE.existeRegistroEspecAFun()){
	        		ctrlE.ingresarNombreFuncion(null);
					objSesion.setAttribute("errorExisteRegFun", true);
					req.getRequestDispatcher("/WEB-INF/funciones/registroafuncion.jsp").forward(req, resp);
				}
		        if(ctrlE.funcionAlcanzoLimiteReg(espectaculo)){
		        	ctrlE.ingresarNombreFuncion(null);
					objSesion.setAttribute("errorFunAlcanzoLimite", true);
					req.getRequestDispatcher("/WEB-INF/funciones/registroafuncion.jsp").forward(req, resp);
				}
		        if(!ctrlE.existeRegistroEspecAFun() && !ctrlE.funcionAlcanzoLimiteReg(espectaculo)) {
	    			ctrlE.confirmarRegistro(espectaculo, LocalDate.now());
	    			ctrlE.ingresarNombreFuncion(null);
		        }
	    		
	        	
	        	
	        }else {//caso de vales
	        	String nomPaquete = req.getParameter("vale_seleccionado");
	        	HandlerUsuarios hu = HandlerUsuarios.getInstancia();
	        	HandlerEspectaculos hesp = HandlerEspectaculos.getInstance();
	        	Espectaculo espect = hesp.getEspectaculo(espectaculo);
	        	Funcion fun = espect.getFuncion(nomFuncion);
	        	Usuario user = hu.getUsuario(userNickname);
	        	List<Vale> vales = user.getVales();
	        	int i = 0;
	        	boolean actualizo = false;
	        	while(i < vales.size() && !actualizo){
	        		if(vales.get(i).getPaquete().getNombre().compareTo(nomPaquete) == 0) {
	        			if(vales.get(i).getEspectaculo().getNombre().compareTo(espectaculo) == 0) {
	        				vales.get(i).setUsado(true);
	        				actualizo = true;
	        			}
	        		}
	        		i++;
	        	}
	        	Registro nuevo = new Registro(LocalDate.now(), false, user, fun, espect.getCosto());
	        	user.addFuncion(nuevo);
	        	fun.addEspectador(nuevo);
	        	
	        }
		ctrlE.ingresarNombreFuncion(null);
		
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
