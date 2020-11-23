package logica;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import datatypesweb.dataEspectaculo;
import datatypesweb.dataRegistro;
import datatypesweb.dataRegsPrevios;
import datatypesweb.dataUsuario;
import datatypesweb.dataVale;
import datatypesweb.dataValesCanje;
import excepciones.UsuarioConMismoMailException;
import excepciones.UsuarioConMismoNickException;
import excepciones.fechaPosterior;
import excepciones.noSeleccionoTres;

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
    public dataEspectaculo getEspectaculo(String espect) {
    	HandlerEspectaculos hEsp = HandlerEspectaculos.getInstance();
    	return new dataEspectaculo(hEsp.getEspectaculo(espect));
    }
    
    @WebMethod
    public dataRegsPrevios obtenerRegistrosPreviosWeb(String nickname){
    	Fabrica fabrica = Fabrica.getInstance();
        IEspectaculo ctrlE = fabrica.getIEspectaculo();
        List<dataRegistro> registrosCanjear = new ArrayList<dataRegistro>();
        List<Registro> regs = ctrlE.obtenerRegistrosPreviosWeb(nickname);
        for(int i = 0; i < regs.size(); i++) {
        	registrosCanjear.add(new dataRegistro(regs.get(i)));
        }
        dataRegsPrevios regsPrevios = new dataRegsPrevios();
        regsPrevios.setRegsPrevios(registrosCanjear);
        return regsPrevios;
    }
    
    @WebMethod
    public dataValesCanje valesACanjear(String nombreEspect, String nickname) {
    	HandlerUsuarios husers = HandlerUsuarios.getInstancia();
    	Usuario user = husers.getUsuario(nickname);
    	List<Vale> vales = user.getVales();
    	List<dataVale> valesCanjear = new ArrayList<dataVale>();
    	HandlerPaquetes hPaq = HandlerPaquetes.getInstance();
    	for (int i = 0; i < vales.size(); i++) {
    		if (vales.get(i).getEspectaculo().getNombre().compareTo(nombreEspect) == 0 && !vales.get(i).isUsado()) {
    			Paquete paq = vales.get(i).getPaquete();
    			if (LocalDate.now().isBefore(paq.getFechaF())) {
    				valesCanjear.add(new dataVale(vales.get(i)));
    					
    			}
    		}
    	}
    	dataValesCanje canjes = new dataValesCanje();
    	canjes.setVales(valesCanjear);
    	return canjes;
    	
    }
    
    @WebMethod
    public void ingresarNombreFuncion(String nomFuncion){
    	Fabrica fabrica = Fabrica.getInstance();
        IEspectaculo ctrlE = fabrica.getIEspectaculo();
        ctrlE.ingresarNombreFuncion(nomFuncion);
    }
    
    @WebMethod
    public void ingresarNombreEspectador(String nickname){
    	Fabrica fabrica = Fabrica.getInstance();
        IEspectaculo ctrlE = fabrica.getIEspectaculo();
        ctrlE.ingresarNombreEspectador(nickname);
    }
    
    @WebMethod
    public void esFechaInvalida(String nomEspect, String fecha) throws fechaPosterior{
    	Fabrica fabrica = Fabrica.getInstance();
        IEspectaculo ctrlE = fabrica.getIEspectaculo();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(fecha, formatter);
        ctrlE.esFechaInvalida(nomEspect, date);
    }
    
    @WebMethod
    public void canjearRegistros(dataRegsPrevios registros) throws noSeleccionoTres{
    	Fabrica fabrica = Fabrica.getInstance();
        IEspectaculo ctrlE = fabrica.getIEspectaculo();
        int[] regsCanj = new int[3];
        List<dataRegistro> regs = registros.getRegsPrevios();
        int i = 0;
        while(i < 3) {
        	regsCanj[i] = regs.get(i).getIdent();
        	i++;
        }
        
        ctrlE.canjearRegistros(regsCanj);
    }
    
    @WebMethod
    public boolean existeRegistroEspecFuncion() {
    	Fabrica fabrica = Fabrica.getInstance();
        IEspectaculo ctrlE = fabrica.getIEspectaculo();
    	return ctrlE.existeRegistroEspecAFun();
    }
    
    @WebMethod
    public boolean funcionAlcanzoLimiteReg(String nomEspect) {
    	Fabrica fabrica = Fabrica.getInstance();
        IEspectaculo ctrlE = fabrica.getIEspectaculo();
    	return ctrlE.funcionAlcanzoLimiteReg(nomEspect);
    }
    
    @WebMethod
    public void ingresarNombrePaquete(String nomPaquete) {
    	Fabrica fabrica = Fabrica.getInstance();
        IEspectaculo ctrlE = fabrica.getIEspectaculo();
    	ctrlE.ingresarNombrePaquete(nomPaquete);
    	ctrlE.canjePorVale();
    }
    
    @WebMethod
    public void confirmarRegistro(String nomEspect, String fecha) {
    	Fabrica fabrica = Fabrica.getInstance();
        IEspectaculo ctrlE = fabrica.getIEspectaculo();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(fecha, formatter);
        
    	ctrlE.confirmarRegistro(nomEspect, date);
    }
    
  
}
