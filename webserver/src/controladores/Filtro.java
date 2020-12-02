package controladores;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import datatypesweb.dataInfo;
import logica.Publicador;
import logica.PublicadorService;

/**
 * Servlet Filter implementation class Filtro
 */
@WebFilter(
		servletNames = { 
				"AgregarEspectaculoaPaquete", 
				"Altaespectaculo", 
				"Altafuncion", 
				"Buscar", 
				"comprapaquete", 
				"consultaFuncion", 
				"CrearPaquete", 
				"DetallesArtista", 
				"DetallesEspectaculo", 
				"DetallesEspectaculoFinalizado", 
				"detallesPaquete", 
				"DetallesUsuario", 
				"Espectaculos", 
				"EspectaculosDePlat", 
				"EspectaculosFinalizados", 
				"Favoritos", 
				"FinalizarEspectaculo", 
				"Home", 
				"VerPremios", 
				"ValorarEspectaculo", 
				"Usuarios", 
				"Registroafuncion", 
				"Paquetes", 
				"SorteoPremios", 
				"CargarDatos"
		})
public class Filtro implements Filter {

    /**
     * Default constructor. 
     */
    public Filtro() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request;
		String ip = req.getLocalAddr();
		String url = req.getRequestURI();
		String os = "";
		String browser = "";
		String userAgent = req.getHeaders("User-Agent").nextElement();
		String user = req.getHeaders("user-agent").toString().toLowerCase();
		 if (userAgent.toLowerCase().indexOf("windows") >= 0 )
         {
             os = "Windows";
         } else if(userAgent.toLowerCase().indexOf("mac") >= 0)
         {
             os = "OS X";
         } else if(userAgent.toLowerCase().indexOf("x11") >= 0)
         {
             os = "Unix";
         } else if(userAgent.toLowerCase().indexOf("android") >= 0)
         {
             os = "Android";
         } else if(userAgent.toLowerCase().indexOf("iphone") >= 0)
         {
             os = "iOS";
         }else{
             os = "Unknown sistema operitivo sad";
         }
         //===============Browser===========================
		 if (userAgent.toLowerCase().indexOf("firefox") >= 0 )
         {
             browser = "Mozilla Firefox";
         } else if(userAgent.toLowerCase().indexOf("chrome") >= 0)
         {
        	 browser = "Google Chrome";
         } else if(userAgent.toLowerCase().indexOf("safari") >= 0)
         {
        	 browser = "Safari";
         } else if(userAgent.toLowerCase().indexOf("opera") >= 0)
         {
        	 browser = "Opera";
         } else if(userAgent.toLowerCase().indexOf("vivaldi") >= 0)
         {
        	 browser = "Vivaldi";
         }else{
        	 browser = "Unknown browser :(";
         }
		 
		PublicadorService service = new PublicadorService();
	    Publicador port = service.getPublicadorPort();
	    port.agregarInfo(ip,url,browser,os);
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}