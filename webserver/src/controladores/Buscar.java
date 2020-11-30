package controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logica.ListaPaquete;
import logica.DataEspectaculo;
import logica.DataPaquete;
import logica.Publicador;
import logica.PublicadorService;
import logica.ListaEspectaculo.Espectaculos.Entry;
import net.java.dev.jaxb.array.StringArray;

/**
 * Servlet implementation class Buscar
 */
public class Buscar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Buscar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession objSesion = req.getSession();
		req.setCharacterEncoding("UTF-8");
		PublicadorService service = new PublicadorService();
	    Publicador port = service.getPublicadorPort();
		String search = req.getParameter("busqueda");
		
		StringArray lista = port.listarCategorias();
		Set<String> categorias = new TreeSet<String>();
		for (String a : lista.getItem()) {
			categorias.add(a);
		}
		
		logica.ListaEspectaculo listae = port.buscarEspectaculos(search);
		List<DataEspectaculo> le = new ArrayList<DataEspectaculo>();
		
    	for(Entry e : listae.getEspectaculos().getEntry()) { 
    		
    		if(e.getValue().isYaFueValuado() && !e.getValue().isFinalizado() && e.getValue().isAceptado())
    			le.add(e.getValue());
    	}
    	
    	// esto es para obtener un map que se usa para que las cards de paquetes recuperen data de sus espectaculos
    	logica.ListaEspectaculo listae2 = port.listarEspectaculos();
		Map<String, DataEspectaculo> mapatodoslosesp = new HashMap<String, DataEspectaculo>();
		
    	for(Entry e : listae2.getEspectaculos().getEntry()) { // aca en vez de get espectaculos habria que hacer busqueda
    		
    		if(e.getValue().isYaFueValuado() && !e.getValue().isFinalizado() && e.getValue().isAceptado())
    			mapatodoslosesp.put(e.getKey(),e.getValue());
    	}
		
		ListaPaquete paquetes = port.buscarPaquetes(search);	 	
		List<DataPaquete> mapPaq = new ArrayList<DataPaquete>();
		for(DataPaquete p : paquetes.getPaquetes() ) {
			mapPaq.add(p);
		}
		List<DataPaquete> lp = mapPaq;
		
		List<String> listaplat = port.listarPlataformas().getItem();
		Set<String> plataformas = new TreeSet<String>();
		for (String a : listaplat) {
			plataformas.add(a);
		}
		
		
		//HandlerEspectaculos he = HandlerEspectaculos.getInstance();
		//HandlerPaquetes hpaq = HandlerPaquetes.getInstance();
		//HandlerCategorias hc = HandlerCategorias.getInstance();
		//HandlerPlataforma hplat = HandlerPlataforma.getInstance();
		//List<Espectaculo> le = he.buscarEspectaculos(search); // esta funcion la tengo que hacer en el publicador
		//List<Paquete> lp = hpaq.buscarPaquetes(search); // esta funcion la tengo que hacer en el publicador
		//Set<String> categorias = hc.getCategorias().keySet();
		//Set<String> plataformas = hplat.getColPlataforma().keySet();
		
		
		objSesion.setAttribute("plataformas", plataformas);
		objSesion.setAttribute("categorias", categorias);
		objSesion.setAttribute("search", search);
		objSesion.setAttribute("espectaculos", le);
		objSesion.setAttribute("mapatodoslosesp", mapatodoslosesp);
		objSesion.setAttribute("paquetes", lp);
		req.getRequestDispatcher("/WEB-INF/buscar/buscar.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
