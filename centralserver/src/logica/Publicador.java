package logica;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import datatypesweb.dataArtista;
import datatypesweb.dataUsuario;
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
    public dataArtista getArtista(String nickname) {
    	HandlerUsuarios husers = HandlerUsuarios.getInstancia();
    	Artista user = (Artista) husers.getUsuario(nickname);
    	dataArtista dataA = new dataArtista(user);
    	return dataA;
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
    public void updateUsuarioWeb(String nickname, String nombre, String apellido, String mail, LocalDate date, String password, String imagen) {
    	IUsuario UController = Fabrica.getInstance().getIUsuario();
    	
    	UController.updateUsuarioWeb(nickname, nombre, apellido, mail, date, password, imagen);
    	UController.confirmarUpdateUsuarioWeb();
    }
    
    @WebMethod
    public void updateArtista(String descripcion, String biografia, String website) {
    	IUsuario UController = Fabrica.getInstance().getIUsuario();
    	
    	UController.updateArtista(descripcion,biografia,website);
    }
    
    @WebMethod
    public void altaFuncion(String esp, String nombre, LocalDate date, LocalTime duracion, ArrayList<String> stringList) throws NombreFuncionexisteException {
    	Fabrica fabrica = Fabrica.getInstance();
        IEspectaculo ctrlesp = fabrica.getIEspectaculo();
    	
        ctrlesp.elegirEspectaculo(esp);
	    ctrlesp.altaFuncion(nombre, date, duracion, stringList, LocalDate.now());
		ctrlesp.confirmarAltaFuncion();
    }
    
   
    /*public ArrayList<String> getArtistas(String artistaLog) {
    	HandlerUsuarios husers = HandlerUsuarios.getInstancia();
    	ArrayList<String> artistas = (ArrayList<String>) husers.getNombresArtistas();
    	ArrayList<String> artistasinvi = new ArrayList<String>();
		for (int i=0; i< artistas.size(); i++) {
			if(!artistas.get(i).equals(artistaLog)){
				artistasinvi.add(artistas.get(i));
			}
		}
		return artistasinvi;
    }*/
}
