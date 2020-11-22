package logica;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import datatypesweb.dataArtista;
import datatypesweb.dataListArtInvi;
import datatypesweb.dataListEspOrg;
import datatypesweb.dataListPaquetes;
import datatypesweb.dataListPlataformas;
import datatypesweb.dataPaquete;
import datatypesweb.dataUsuario;
import excepciones.NoExistePaqueteException;
import excepciones.NombreFuncionexisteException;
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
    	return hUsers.esArtistaA(nickname);
    }
    @WebMethod
    public dataUsuario getUsuario(String nickname) {
    	HandlerUsuarios husers = HandlerUsuarios.getInstancia();
    	Usuario user = husers.getUsuario(nickname);
    	dataUsuario dataU = new dataUsuario(user);
    	return dataU;
    }
    
    @WebMethod
    public dataArtista getArtista(String nickname) {
    	HandlerUsuarios husers = HandlerUsuarios.getInstancia();
    	Artista user = (Artista) husers.getUsuario(nickname);
    	dataArtista dataArt = new dataArtista(user);
    	return dataArt;
    }
    
    @WebMethod
    public dataListEspOrg getEspectaculosDePlataforma(String nombrePlataforma) {
    	HandlerEspectaculos hesp = HandlerEspectaculos.getInstance();
		Map<String,Espectaculo> espectaculos = hesp.getEspectaculosDePlataforma(nombrePlataforma);
    	
		HashMap<String,Espectaculo> espectaculosPlat = new HashMap<String,Espectaculo>();
		for (String key : espectaculos.keySet()) {
			if(espectaculos.get(key).getPlataforma().getNombre().equals(nombrePlataforma)){
				espectaculosPlat.put(key,espectaculos.get(key));
			}		
		}
		
		dataListEspOrg espectaculosPlatReal = new dataListEspOrg();
		for(String key2 : espectaculosPlat.keySet()) {
			espectaculosPlatReal.getEspectaculosOrg().add(key2);
		}
		
		return espectaculosPlatReal;
    }
    
    @WebMethod
    public dataPaquete getPaquete(String nombrePaquete) throws NoExistePaqueteException {
    	HandlerPaquetes hpaq = HandlerPaquetes.getInstance();
    	Paquete paqElegido = hpaq.getPaquete(nombrePaquete);
    	dataPaquete dataPack = new dataPaquete(paqElegido);
    	return dataPack;
    }
    
    
    @WebMethod
    public String getMailUsuario(String nickname) {
    	HandlerUsuarios husers = HandlerUsuarios.getInstancia();
    	Usuario user = husers.getUsuario(nickname);
    	String mail = user.getEmail();
    	return mail;
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
    public void updateUsuarioWeb(String nickname, String nombre, String apellido, String mail, String fechanac, String password, String imagen) {
    	IUsuario UController = Fabrica.getInstance().getIUsuario();
    	
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(fechanac, formatter);
    	
    	UController.updateUsuarioWeb(nickname, nombre, apellido, mail, date, password, imagen);
    	UController.confirmarUpdateUsuarioWeb();
    }
    
    @WebMethod
    public void updateArtista(String descripcion, String biografia, String website) {
    	IUsuario UController = Fabrica.getInstance().getIUsuario();
    	
    	UController.updateArtista(descripcion,biografia,website);
    }
    
    
    @WebMethod
    public void altaFuncion(String esp, String nombre, String fecha, String horaInicio, dataListArtInvi invis) throws NombreFuncionexisteException {
    	Fabrica fabrica = Fabrica.getInstance();
        IEspectaculo ctrlesp = fabrica.getIEspectaculo();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_TIME;
        LocalDate date = LocalDate.parse(fecha, formatter);
        LocalTime duracion = LocalTime.parse(horaInicio,dateTimeFormatter);
        
        ArrayList<String> invitados = (ArrayList<String>) invis.getArtistasInvi();

    	
        ctrlesp.elegirEspectaculo(esp);
	    ctrlesp.altaFuncion(nombre, date, duracion, invitados, LocalDate.now());
		ctrlesp.confirmarAltaFuncion();
    }
    
    public void agregarEspAPaquete(String nombPaqElegido, dataListEspOrg espectaculosElegidos) throws NoExistePaqueteException {
    	Fabrica fabrica = Fabrica.getInstance();
        IPaquete ctrlpaq = fabrica.getIPaquete();
        
        ArrayList<String> espectaculos = (ArrayList<String>) espectaculosElegidos.getEspectaculosOrg();
        
        ctrlpaq.seleccionarPaquete(nombPaqElegido);
        if(espectaculos != null) {
	    	for (int i=0; i< espectaculos.size(); i++) {
			   ctrlpaq.elegirEspectaculo(espectaculos.get(i));
			   ctrlpaq.confirmarAgregarEspectAPaquete();
	    	}
	    }
    }
    
    @WebMethod
    public dataListArtInvi getArtistas(String artistaLog) {
    	HandlerUsuarios husers = HandlerUsuarios.getInstancia();
    	ArrayList<String> artistas = (ArrayList<String>) husers.getNombresArtistas();
    	dataListArtInvi artistasinvi = new dataListArtInvi();
		for (int i=0; i< artistas.size(); i++) {
			if(!artistas.get(i).equals(artistaLog)){
				artistasinvi.getArtistasInvi().add(artistas.get(i));
			}
		}
		return artistasinvi;
    }
    
    @WebMethod
    public dataListEspOrg getEspectaculos(String artistaLog) {
    	HandlerEspectaculos hesp = HandlerEspectaculos.getInstance();
		HashMap<String,Espectaculo> espectaculos = (HashMap<String, Espectaculo>) hesp.getEspectaculos();
		HashMap<String,Espectaculo> espectaculosorg = new HashMap<String,Espectaculo>();
		for (String key : espectaculos.keySet()) {
			if(espectaculos.get(key).getArtista().getNickname().equals(artistaLog)){
				espectaculosorg.put(key,espectaculos.get(key));
			}		
		}
		dataListEspOrg espectaculosorgreal = new dataListEspOrg();
		for(String key2 : espectaculosorg.keySet()) {
			espectaculosorgreal.getEspectaculosOrg().add(key2);
		}
		return espectaculosorgreal;
    }
    
    @WebMethod
    public dataListPaquetes getPaquetes() {
    	HandlerPaquetes hp = HandlerPaquetes.getInstance();
    	List<String> paquetes = hp.getNombresPaquete();
		List<String> paquetesList = new ArrayList<String>();
		for (int i=0; i< paquetes.size(); i++) {
			paquetesList.add(paquetes.get(i));
		}
		
		dataListPaquetes paquetesListReal = new dataListPaquetes();
		for (int i=0; i< paquetesList.size(); i++) {
			paquetesListReal.getPaquetes().add(paquetesList.get(i));
		}
			
		return paquetesListReal;
    }
    
    @WebMethod
    public dataListPlataformas getPlataformas() {
    	HandlerPlataforma hplat = HandlerPlataforma.getInstance();
    	List<String> plataformas = hplat.getNombres();
    	List<String> plataformasList = new ArrayList<String>();
    	for (int i=0; i< plataformas.size(); i++) {
    		plataformasList.add(plataformas.get(i));
		}
		
    	dataListPlataformas plataformasListReal = new dataListPlataformas();
		for (int i=0; i< plataformasList.size(); i++) {
			plataformasListReal.getPlataformas().add(plataformasList.get(i));
		}
			
		return plataformasListReal;
    }
}
