package logica;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import datatypesweb.ListaEspectaculo;
import datatypesweb.ListaPaquete;
import datatypesweb.dataEspectaculo;
import datatypesweb.dataPaquete;
import datatypesweb.dataUsuario;
import excepciones.NombreEspectaculoExisteException;
import excepciones.UsuarioConMismoMailException;
import excepciones.UsuarioConMismoNickException;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class Publicador {
	
    private Endpoint endpoint = null;
    //Constructor
    public Publicador(){}

    //Operaciones las cuales quiero publicar

    @WebMethod(exclude = true)
    public void publicar(){
         endpoint = Endpoint.publish("http://localhost:9129/publicador", this);
    }

    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
            return endpoint;
    }
    
    @WebMethod
    public boolean loginCorrecto(String nickname, String password) {
    	HandlerUsuarios hUsers = HandlerUsuarios.getInstancia();
    	return hUsers.getUsuario(nickname).getPassword().equals(password);
    }
    @WebMethod
    public boolean esArtista(String nickname) {
    	HandlerUsuarios hUsers = HandlerUsuarios.getInstancia();
    	Usuario user = hUsers.getUsuario(nickname);
    	return user.esArtista();
    }
    @WebMethod
    public dataUsuario getUsuario(String nickname) {
    	HandlerUsuarios husers = HandlerUsuarios.getInstancia();
    	Usuario user = husers.getUsuario(nickname);
    	dataUsuario dataU = new dataUsuario(user);
    	return dataU;
    }
    
    @WebMethod
    public dataEspectaculo getEspectaculo(String nomEspectaculo) {
    	HandlerEspectaculos hespectaculos = HandlerEspectaculos.getInstance();
    	Espectaculo esp = hespectaculos.getEspectaculo(nomEspectaculo);
    	dataEspectaculo dataE = new dataEspectaculo(esp);
    	return dataE;
    }
    
    @WebMethod
    public ListaEspectaculo listarEspectaculos() {
    	HandlerEspectaculos hesp = HandlerEspectaculos.getInstance();
    	HashMap<String, dataEspectaculo> res = new HashMap<String, dataEspectaculo>();
    	for(Map.Entry<String, Espectaculo> entry : hesp.getEspectaculos().entrySet()) {
    		res.put(entry.getKey(), new dataEspectaculo(entry.getValue()));
    	}
    	ListaEspectaculo lista = new ListaEspectaculo();
		lista.setEspectaculos(res);
    	return lista;
    }
    
    @WebMethod
    public ListaEspectaculo listarEspectaculosPlataforma(String nomPlata) {
    	HandlerEspectaculos hesp = HandlerEspectaculos.getInstance();
    	HashMap<String, dataEspectaculo> res = new HashMap<String, dataEspectaculo>();
    	for(Map.Entry<String, Espectaculo> entry : hesp.getEspectaculosDePlataforma(nomPlata).entrySet()) {
    		res.put(entry.getKey(), new dataEspectaculo(entry.getValue()));
    	}
    	ListaEspectaculo lista = new ListaEspectaculo();
		lista.setEspectaculos(res);
    	return lista;
    }
    
    @WebMethod
    public ListaPaquete listarPaquetesEspectaculo(String nomEspec) {
    	HandlerPaquetes hpaq = HandlerPaquetes.getInstance();
    	List<Paquete> lista = hpaq.getPaquetesDeEspectaculoWeb(nomEspec);
    	ListaPaquete res = new ListaPaquete();
    	ArrayList<dataPaquete> resLista = new ArrayList<dataPaquete>();
    	for (Paquete paq : lista) {
    		resLista.add(new dataPaquete(paq));
    	}
    	res.setPaquetes(resLista);
    	return res;
    }
    
    @WebMethod
	public void altaUsuarioWeb(String nickname, String nombre, String apellido, String mail, String fechanac, String password, String imagen) throws UsuarioConMismoNickException, UsuarioConMismoMailException {
    	IUsuario UController = Fabrica.getInstance().getIUsuario();
    	
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date =  LocalDate.parse(fechanac, formatter);
    	
    	UController.altaUsuarioWeb(nickname, nombre, apellido, mail, date, password, imagen);
    	
    	UController.confirmarAltaUsuario();
    }
    
    @WebMethod
	public void altaArtistaWeb(String nickname, String nombre, String apellido, String mail, String fechanac, String desc, String bio, String web, String password, String imagen)throws UsuarioConMismoNickException, UsuarioConMismoMailException {
    	IUsuario UController = Fabrica.getInstance().getIUsuario();
    	
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date =  LocalDate.parse(fechanac, formatter);
    	
    	UController.altaArtistaWeb(nickname, nombre, apellido, mail, date, desc, bio, web, password, imagen);
    	UController.confirmarAltaUsuario();
    }
        
    @WebMethod
    public void altaEspectaculoWeb(dataEspectaculo dataEsp) throws NombreEspectaculoExisteException {
    	
    	String nomArtista = dataEsp.getArtista();
        String nomEspectaculo = dataEsp.getNombre();
        String nomPlataforma = dataEsp.getPlataforma();
        String descripcion = dataEsp.getDescripcion();
    	String duracion = dataEsp.getDuracion();
    	String minutos = dataEsp.getMinutos();
    	Integer maximo = dataEsp.getMaxEspectadores();
    	Integer minimo = dataEsp.getMinEspectadores();
    	String url = dataEsp.getUrl();
    	List<String> categorias = new ArrayList<String>();
    			
    	for(String cat : dataEsp.getCategorias()) {
    		categorias.add(cat);
    	}
    	
    	Float costo = dataEsp.getCosto();
    	String imagen = dataEsp.getImagen();
    	
    	IEspectaculo ctrlE = Fabrica.getInstance().getIEspectaculo();
    	
    	LocalDate hoy = LocalDate.now();
    	
    	LocalTime dur = LocalTime.of(Integer.parseInt(duracion), Integer.parseInt(minutos));
    	
    	ctrlE.altaEspectaculoWeb(nomPlataforma, nomArtista, nomEspectaculo, descripcion, dur,
				minimo, maximo,
				url, costo, hoy , categorias, imagen);
    }
    
    @WebMethod(operationName = "listarPlataformas")
    public String[] listarPlataformas() {
    	HandlerPlataforma handlerPlat = HandlerPlataforma.getInstance();
    	String[] arr = new String[handlerPlat.getNombres().size()];
    	arr = handlerPlat.getNombres().toArray(arr);
    	return arr;
    }
    
    @WebMethod
    public String[] listarCategorias() {
    	IEspectaculo IE = Fabrica.getInstance().getIEspectaculo();
    	String[] arr = new String[IE.listarCategorias().size()];
    	arr = IE.listarCategorias().toArray(arr);
    	return arr;
    }
}
