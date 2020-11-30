package controladores;

import java.io.IOException;
import java.time.LocalDate;
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
import logica.DataRegistro;
import logica.DataRegsPrevios;
import logica.DataUsuario;
import logica.DataVale;
import logica.ExisteRegistroEspecException_Exception;
import logica.FechaPosterior_Exception;
import logica.FuncionAlcanzoLimiteException_Exception;
import logica.NoSeleccionoTres_Exception;
import logica.Publicador;
import logica.PublicadorService;

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
			String browserName = req.getHeaders("user-agent").nextElement();	
			if (browserName.contains("Mobile") ) {
				String url = "consultafuncion?name=" + nomEspect + ";" + nomFun;
				resp.sendRedirect(url);
	    		return;
			}
			System.out.println("esto es una prueba de substring");
			System.out.println("espectaculo " + nomEspect);
			System.out.println("funcion " + nomFun);
			
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
			
	    	DataUsuario user = port.getUsuario(userNickname);
	    	List<DataVale> vales = port.valesACanjear(nomEspect, userNickname).getVales();
	    	List<DataRegistro> allRegs = user.getRegistros();
	    	objSesion.setAttribute("registros_usuario", allRegs);
	    	objSesion.setAttribute("vales_canjear", vales);
	    	
	    	
	        List<DataRegistro> registrosCanjear = port.obtenerRegistrosPreviosWeb(userNickname).getRegsPrevios();
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
        System.out.println("esto es el nombre del espectaculo " + espectaculo);
        System.out.println("esto es el nombre de la funcion " + nomFuncion);
       
        PublicadorService service = new PublicadorService();
	    Publicador port = service.getPublicadorPort();
	 
        
		if(req.getParameter("forma").compareTo("canjeregistros") == 0) {
			String[] regsSelected = req.getParameterValues("registros_previos");
			if(regsSelected != null) {
			
				DataRegsPrevios registrosCanjeados = new DataRegsPrevios();
				List<DataRegistro> ids = new ArrayList<DataRegistro>();
		        List<DataRegistro> registrosCanjear = port.obtenerRegistrosPreviosWeb(userNickname).getRegsPrevios();
		        int j = 0;
		        for(int i = 0; i < registrosCanjear.size(); i++) {
		        	String nombre = registrosCanjear.get(i).getFuncion();
		        	for(int t = 0; t < regsSelected.length; t++) {
			        	if(nombre.compareTo(regsSelected[t]) == 0){
			        		ids.add(registrosCanjear.get(i));
			        		j = j+1;
			        	}
		        	}	
		        }
		        for(int i = 0; i < ids.size(); i++) {
		        	registrosCanjeados.getRegsPrevios().add(ids.get(i));
		        }
		        
		        
		        try {
					port.confirmarRegistroPrevios(nomFuncion, userNickname, espectaculo, LocalDate.now().toString(), registrosCanjeados);
				} catch (ExisteRegistroEspecException_Exception e) {
					// TODO Auto-generated catch block
					objSesion.setAttribute("errorExisteRegFun", true);
					req.getRequestDispatcher("/WEB-INF/funciones/registroafuncion.jsp").forward(req, resp);
				} catch (FechaPosterior_Exception e) {
					// TODO Auto-generated catch block
					objSesion.setAttribute("fecha_invalida", true);
					req.getRequestDispatcher("/WEB-INF/funciones/registroafuncion.jsp").forward(req, resp);
				} catch (FuncionAlcanzoLimiteException_Exception e) {
					// TODO Auto-generated catch block
					objSesion.setAttribute("errorFunAlcanzoLimite", true);
					req.getRequestDispatcher("/WEB-INF/funciones/registroafuncion.jsp").forward(req, resp);
				
				} catch (NoSeleccionoTres_Exception e) {
					// TODO Auto-generated catch block
					objSesion.setAttribute("noEligioTres", true);
					req.getRequestDispatcher("/WEB-INF/funciones/registroafuncion.jsp").forward(req, resp);
				
				}
			        
			}else {
				objSesion.setAttribute("funciones_vacias", true);
				req.getRequestDispatcher("/WEB-INF/funciones/registroafuncion.jsp").forward(req, resp);
			}
		        
	        }else if(req.getParameter("forma").compareTo("tradicional")==0){
	        	
	        	try {
					port.confirmarRegistroTradicional(nomFuncion, userNickname,espectaculo , LocalDate.now().toString());
				} catch (ExisteRegistroEspecException_Exception e) {
					// TODO Auto-generated catch block
					objSesion.setAttribute("errorExisteRegFun", true);
					req.getRequestDispatcher("/WEB-INF/funciones/registroafuncion.jsp").forward(req, resp);
				} catch (FechaPosterior_Exception e) {
					// TODO Auto-generated catch block
					objSesion.setAttribute("fecha_invalida", true);
					req.getRequestDispatcher("/WEB-INF/funciones/registroafuncion.jsp").forward(req, resp);
				} catch (FuncionAlcanzoLimiteException_Exception e) {
					// TODO Auto-generated catch block
					objSesion.setAttribute("errorFunAlcanzoLimite", true);
					req.getRequestDispatcher("/WEB-INF/funciones/registroafuncion.jsp").forward(req, resp);
				}
	        	
	        }else {//caso de vales
	        	String valeSelected = req.getParameter("vale_seleccionado");
	        	if(valeSelected != null) {
		        	String nomPaquete = req.getParameter("vale_seleccionado");
		        	try {
						port.confirmarRegistroVales(nomFuncion, userNickname, espectaculo, LocalDate.now().toString(), nomPaquete);
					} catch (ExisteRegistroEspecException_Exception e) {
						// TODO Auto-generated catch block
						objSesion.setAttribute("errorExisteRegFun", true);
						req.getRequestDispatcher("/WEB-INF/funciones/registroafuncion.jsp").forward(req, resp);
					} catch (FechaPosterior_Exception e) {
						// TODO Auto-generated catch block
						objSesion.setAttribute("fecha_invalida", true);
						req.getRequestDispatcher("/WEB-INF/funciones/registroafuncion.jsp").forward(req, resp);
					} catch (FuncionAlcanzoLimiteException_Exception e) {
						// TODO Auto-generated catch block
						objSesion.setAttribute("errorFunAlcanzoLimite", true);
						req.getRequestDispatcher("/WEB-INF/funciones/registroafuncion.jsp").forward(req, resp);
					}
	        	}else {
	        		objSesion.setAttribute("vale_vacio", true);
					req.getRequestDispatcher("/WEB-INF/funciones/registroafuncion.jsp").forward(req, resp);
	        	}
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
