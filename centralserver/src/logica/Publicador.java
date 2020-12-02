package logica;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.UUID;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import datatypesweb.dataEspectaculo;
import datatypesweb.dataFuncion;
import datatypesweb.dataInfo;
import datatypesweb.dataRegistro;
import datatypesweb.dataRegsPrevios;
import datatypesweb.ListaEspectaculo;
import datatypesweb.ListaInfo;
import datatypesweb.ListaPaquete;
import datatypesweb.ListaUsuario;
import datatypesweb.dataPaquete;
import datatypesweb.dataPremio;
import datatypesweb.dataArtista;
import datatypesweb.dataListArtInvi;
import datatypesweb.dataListEspOrg;
import datatypesweb.dataListFunsEspect;
import datatypesweb.dataListPaquetes;
import datatypesweb.dataListPlataformas;
import datatypesweb.dataListPremio;
import datatypesweb.dataUsuario;
import datatypesweb.dataVale;
import datatypesweb.dataValesCanje;
import excepciones.NoExistePaqueteException;
import excepciones.NombreFuncionexisteException;
import excepciones.PaqueteConMismoNombreException;
import excepciones.NombreEspectaculoExisteException;
import excepciones.UsuarioConMismoMailException;
import excepciones.UsuarioConMismoNickException;
import excepciones.fechaPosterior;
import excepciones.funcionAlcanzoLimiteException;
import excepciones.noSeleccionoTres;
import excepciones.UsuarioPaqueteComprado;
import excepciones.YaVotoException;
import excepciones.existeRegistroEspecException;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class Publicador {
	
    private Endpoint endpoint = null;
    //Constructor
    public Publicador(){}

    //Operaciones las cuales quiero publicar

    @WebMethod(exclude = true)
    public void publicar(){
    	
		InputStream input;
		try {
			
			input = new FileInputStream(System.getProperty("user.home") + "/.coronaTickets/config.properties");
	
			Properties prop = new Properties();	
			try {
				prop.load(input);
			} catch (IOException e) {
				e.printStackTrace();
			}	
			String url = prop.getProperty("URL");
	        endpoint = Endpoint.publish(url, this);
		
		} catch (FileNotFoundException e) {
			
			File theDir = new File(System.getProperty("user.home") + "/.coronaTickets");
			if (!theDir.exists()){
			    theDir.mkdirs();
			}
			
			File nuevaconf = new File(System.getProperty("user.home") + "/.coronaTickets/config.properties");
			try {
				nuevaconf.createNewFile();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			try {
				FileWriter myWriter = new FileWriter(System.getProperty("user.home") + "/.coronaTickets/config.properties");
				myWriter.write("URL=http://localhost:9129/publicador");
				myWriter.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			try {
				input = new FileInputStream(System.getProperty("user.home") + "/.coronaTickets/config.properties");
		
				Properties prop = new Properties();	
				try {
					prop.load(input);
				} catch (IOException e1) {
					e1.printStackTrace();
				}	
				String url = prop.getProperty("URL");
		        endpoint = Endpoint.publish(url, this);
			} catch (FileNotFoundException e2) {
				e2.printStackTrace();
			}
		}
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
    public dataListEspOrg getEspectaculosOrgArtista(String nickname) {
    	HandlerUsuarios husers = HandlerUsuarios.getInstancia();
    	Artista user = (Artista) husers.getUsuario(nickname);
    	dataListEspOrg espectaculosRetornar = new dataListEspOrg();
    	for (int i=0; i < user.getEspectaculos().size(); i++) {
    		espectaculosRetornar.getEspectaculosOrg().add(user.getEspectaculos().get(i).getNombre());
    	}	
    	return espectaculosRetornar;
    }
    
    @WebMethod
    public dataListEspOrg getEspectaculosDePlataforma(String nombrePlataforma) {
    
    	HandlerEspectaculos hesp = HandlerEspectaculos.getInstance();
		Map<String, Espectaculo> espectaculos = hesp.getEspectaculosDePlataforma(nombrePlataforma);
    	
		HashMap<String,Espectaculo> espectaculosPlat = new HashMap<String,Espectaculo>();
		for (String key : espectaculos.keySet()) {
			if (espectaculos.get(key).getPlataforma().getNombre().equals(nombrePlataforma)){
				espectaculosPlat.put(key, espectaculos.get(key));
			}		
		}
		
		dataListEspOrg espectaculosPlatReal = new dataListEspOrg();
		for (String key2 : espectaculosPlat.keySet()) {
			espectaculosPlatReal.getEspectaculosOrg().add(key2);
		}
		return espectaculosPlatReal;
		
    }
    
    @WebMethod
    public String getMailUsuario(String nickname) {
    	HandlerUsuarios husers = HandlerUsuarios.getInstancia();
    	Usuario user = husers.getUsuario(nickname);
    	String mail = user.getEmail();
    	return mail;
    }
    
    @WebMethod
    public ListaPaquete listarPaquetesEspectaculo(String nomEspec) {
    	HandlerPaquetes hpaq = HandlerPaquetes.getInstance();
    	List<Paquete> lista = hpaq.getPaquetesDeEspectaculoWeb(nomEspec);
    	ListaPaquete res = new ListaPaquete();
		List<dataPaquete> resLista = new ArrayList<dataPaquete>();
		for (Paquete paq : lista) {
			res.setPaquetes(resLista);
	    	resLista.add(new dataPaquete(paq));
		}
		return res;
    }
    
    @WebMethod
    public ListaPaquete listarPaquetes() {
    	HandlerPaquetes hpaq = HandlerPaquetes.getInstance();
    	Map<String, Paquete> lista = hpaq.getPaquetes();
    	ListaPaquete res = new ListaPaquete();
    	List<dataPaquete> resLista = new ArrayList<dataPaquete>();
    	for (Map.Entry<String, Paquete> paq : lista.entrySet()) {
    		resLista.add(new dataPaquete(paq.getValue()));
    	}
    	res.setPaquetes(resLista);
    	
    	// esta turrada la hice porque implementamos la clase dos veces pero usamos metodos diferentes en diferentes lugares, y asi funciona todo 
    	HandlerPaquetes hpaquetes = HandlerPaquetes.getInstance();
    	Map<String, Paquete> mapapaquetes =  hpaquetes.getPaquetes();

    	List<dataPaquete> result = new ArrayList<dataPaquete>();
    	for (Paquete entry : mapapaquetes.values()) {
    		result.add(new dataPaquete(entry));
    	}
    	
		res.setPaquete(result);
        	
    	return res;
    }
    
    @WebMethod
    public dataListFunsEspect funcionesEspectaculo(String nomEspect) {
    	HandlerEspectaculos hEsp = HandlerEspectaculos.getInstance();
    	Espectaculo esp = hEsp.getEspectaculo(nomEspect);
    	Map<String,Funcion> funs = esp.getAllFunciones();
    	Map<String,dataFuncion> funsResp = new HashMap<String,dataFuncion>();
    	dataFuncion nueva;
    	for(String key : funs.keySet()) {
    		nueva = new dataFuncion(funs.get(key));
    		if(funs.get(key).funcionFinalizo()) {
    			nueva.setFinalizo(true);
    		}
    		funsResp.put(key,nueva);
    	}
    	dataListFunsEspect ret = new dataListFunsEspect();
    	ret.setFuncionesEspect(funsResp);
    	return ret;
    }
    
    
    @WebMethod
    public dataPaquete getPaquete(String nomPaquete) throws NoExistePaqueteException {
    	HandlerPaquetes hpaq = HandlerPaquetes.getInstance();
    	return new dataPaquete(hpaq.getPaquete(nomPaquete));
    }
    
    @WebMethod
    public ListaEspectaculo listarEspectaculosPlataforma(String nomPlata) {
    	HandlerEspectaculos hesp = HandlerEspectaculos.getInstance();
    	HashMap<String, dataEspectaculo> res = new HashMap<String, dataEspectaculo>();
    	for (Map.Entry<String, Espectaculo> entry : hesp.getEspectaculosDePlataforma(nomPlata).entrySet()) {
    		res.put(entry.getKey(), new dataEspectaculo(entry.getValue()));
    	}
    	ListaEspectaculo lista = new ListaEspectaculo();
		lista.setEspectaculos(res);
    	return lista;
    }
    
    @WebMethod
    public ListaEspectaculo listarEspectaculos() {
    	HandlerEspectaculos hesp = HandlerEspectaculos.getInstance();
    	HashMap<String, dataEspectaculo> res = new HashMap<String, dataEspectaculo>();
    	for (Map.Entry<String, Espectaculo> entry : hesp.getEspectaculos().entrySet()) {
    		res.put(entry.getKey(), new dataEspectaculo(entry.getValue()));
    	}
    	ListaEspectaculo lista = new ListaEspectaculo();
		lista.setEspectaculos(res);
    	return lista;
    }
    
    @WebMethod
    public dataEspectaculo getEspectaculo(String nomEspectaculo) {
    	HandlerEspectaculos hespectaculos = HandlerEspectaculos.getInstance();
    	Espectaculo esp = hespectaculos.getEspectaculo(nomEspectaculo);
    	dataEspectaculo dataE = new dataEspectaculo(esp);
    	return dataE;
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
    
   /* @WebMethod
    public dataEspectaculo getEspectaculo(String espect) {
    	HandlerEspectaculos hEsp = HandlerEspectaculos.getInstance();
    	return new dataEspectaculo(hEsp.getEspectaculo(espect));
    }*/
    
    @WebMethod
    public dataRegsPrevios obtenerRegistrosPreviosWeb(String nickname){
    	Fabrica fabrica = Fabrica.getInstance();
        IEspectaculo ctrlE = fabrica.getIEspectaculo();
        List<dataRegistro> registrosCanjear = new ArrayList<dataRegistro>();
        List<Registro> regs = ctrlE.obtenerRegistrosPreviosWeb(nickname);
        for (int i = 0; i < regs.size(); i++) {
        	
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
    public void confirmarRegistroPrevios(String nomFuncion, String nickname, String nomEspect, String fecha, dataRegsPrevios registros) throws fechaPosterior, noSeleccionoTres, existeRegistroEspecException, funcionAlcanzoLimiteException{
    	Fabrica fabrica = Fabrica.getInstance();
        IEspectaculo ctrlE = fabrica.getIEspectaculo();
        
        ctrlE.ingresarNombreFuncion(nomFuncion);
        ctrlE.ingresarNombreEspectador(nickname);
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(fecha, formatter);
        ctrlE.esFechaInvalida(nomEspect, date);
        
        int[] regsCanj = new int[3];
        List<dataRegistro> regs = registros.getRegsPrevios();
        int iter = 0;
        while (iter < 3 && iter < regs.size()) {
        	regsCanj[iter] = regs.get(iter).getIdent();
        	iter++;
        }
        ctrlE.canjearRegistros(regsCanj);
        
        ctrlE.existeRegistroEspecAFunWeb();
        ctrlE.funcionAlcanzoLimiteRegWeb(nomEspect);
        
    	ctrlE.confirmarRegistro(nomEspect, date);
       
    }
    
    public void confirmarRegistroVales(String nomFuncion, String nickname, String nomEspect, String fecha, String nomPaquete) throws fechaPosterior, existeRegistroEspecException, funcionAlcanzoLimiteException {
    	Fabrica fabrica = Fabrica.getInstance();
        IEspectaculo ctrlE = fabrica.getIEspectaculo();
        
        ctrlE.ingresarNombreFuncion(nomFuncion);
        ctrlE.ingresarNombreEspectador(nickname);
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(fecha, formatter);
        ctrlE.esFechaInvalida(nomEspect, date);
        ctrlE.existeRegistroEspecAFunWeb();
        ctrlE.funcionAlcanzoLimiteRegWeb(nomEspect);
        
        ctrlE.ingresarNombrePaquete(nomPaquete);
    	ctrlE.canjePorVale();
    	
    	ctrlE.confirmarRegistro(nomEspect, date);
    }
    
    
    
    
    @WebMethod
    public void confirmarRegistroTradicional(String nomFuncion, String nickname, String nomEspect, String fecha) throws fechaPosterior, existeRegistroEspecException, funcionAlcanzoLimiteException {
    	Fabrica fabrica = Fabrica.getInstance();
        IEspectaculo ctrlE = fabrica.getIEspectaculo();
        
        ctrlE.ingresarNombreFuncion(nomFuncion);
        ctrlE.ingresarNombreEspectador(nickname);
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(fecha, formatter);
        ctrlE.esFechaInvalida(nomEspect, date);
        ctrlE.existeRegistroEspecAFunWeb();
        ctrlE.funcionAlcanzoLimiteRegWeb(nomEspect);
        
    	ctrlE.confirmarRegistro(nomEspect, date);
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
    public void updateArtista(String nickname, String nombre, String apellido, String mail, String fechanac, String password, String imagen, String descripcion, String biografia, String website) {
    	IUsuario UController = Fabrica.getInstance().getIUsuario();
    	
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(fechanac, formatter);
        
    	UController.updateUsuarioWeb(nickname, nombre, apellido, mail, date, password, imagen);
    	UController.updateArtista(descripcion, biografia, website);
    	UController.confirmarUpdateUsuarioWeb();
    }
    
    
    @WebMethod
    public void altaFuncion(String esp, String nombre, String fecha, String horaInicio, dataListArtInvi invis) throws NombreFuncionexisteException {
    	Fabrica fabrica = Fabrica.getInstance();
        IEspectaculo ctrlesp = fabrica.getIEspectaculo();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_TIME;
        LocalDate date = LocalDate.parse(fecha, formatter);
        LocalTime duracion = LocalTime.parse(horaInicio, dateTimeFormatter);
        
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
        if (espectaculos != null) {
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
			if (!artistas.get(i).equals(artistaLog)){
				artistasinvi.getArtistasInvi().add(artistas.get(i));
			}
		}
		return artistasinvi;
    }
    
    @WebMethod
    public dataListEspOrg getEspectaculos(String artistaLog) {
    	HandlerEspectaculos hesp = HandlerEspectaculos.getInstance();
		HashMap<String, Espectaculo> espectaculos = (HashMap<String, Espectaculo>) hesp.getEspectaculos();
		HashMap<String, Espectaculo> espectaculosorg = new HashMap<String, Espectaculo>();
		for (String key : espectaculos.keySet()) {
			if (espectaculos.get(key).getArtista().getNickname().equals(artistaLog)){
				espectaculosorg.put(key, espectaculos.get(key));
			}		
		}
		dataListEspOrg espectaculosorgreal = new dataListEspOrg();
		for (String key2 : espectaculosorg.keySet()) {
			espectaculosorgreal.getEspectaculosOrg().add(key2);
		}
		return espectaculosorgreal;
    }
    
    @WebMethod
    public dataListPaquetes getPaquetes() {
    	HandlerPaquetes hpaq = HandlerPaquetes.getInstance();
    	List<String> paquetes = hpaq.getNombresPaquete();
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
    
    @WebMethod
    public void crearPaquete(String nombre, String desc, String fechaini, String fechafin, int discount, String imagen) throws PaqueteConMismoNombreException, NoExistePaqueteException {
    	Fabrica fabrica = Fabrica.getInstance();
        IPaquete ctrlpaq = fabrica.getIPaquete();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dateini = LocalDate.parse(fechaini, formatter);
		LocalDate datefin = LocalDate.parse(fechafin, formatter);
		
		ctrlpaq.crearPaqueteWeb(nombre, desc, dateini, datefin, discount, LocalDate.now(), imagen);
		ctrlpaq.confirmarCrearPaquete();

    }
    
    @WebMethod
    public void agregarCompra(String user, String paqComprado, String fechaActual) throws NoExistePaqueteException, UsuarioPaqueteComprado {
    	HandlerUsuarios husers = HandlerUsuarios.getInstancia();
    	HandlerPaquetes hpaq = HandlerPaquetes.getInstance();
    	
    	Paquete paqueteReal = hpaq.getPaquete(paqComprado);
    	Usuario userReal = husers.getUsuario(user);
    	
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate fechaCompra = LocalDate.parse(fechaActual, formatter);
		
    	Compra paqueteComprado = new Compra(fechaCompra, paqueteReal);
    	userReal.agregarcompra(paqueteComprado);
        
        
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
    	String video = dataEsp.getVideo();
    	String descPremio = dataEsp.getDescPremio();
    	Integer cantPremios = dataEsp.getCantPremios();
    	List<String> categorias = new ArrayList<String>();
    	
    	if(dataEsp.getCategorias() != null) {
	    	for(String cat : dataEsp.getCategorias()) {
	    		categorias.add(cat);
	    	}
        }
    			
    	
    	
    	Float costo = dataEsp.getCosto();
    	String imagen = dataEsp.getImagen();
    	
    	IEspectaculo ctrlE = Fabrica.getInstance().getIEspectaculo();
    	
    	LocalDate hoy = LocalDate.now();
    	
    	LocalTime dur = LocalTime.of(Integer.parseInt(duracion), Integer.parseInt(minutos));
    	
    	ctrlE.altaEspectaculoWeb(nomPlataforma, nomArtista, nomEspectaculo, descripcion, dur,
				minimo, maximo,
				url, costo, hoy , categorias, imagen, video, descPremio, cantPremios);
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
    	IEspectaculo IEesp = Fabrica.getInstance().getIEspectaculo();
    	String[] arr = new String[IEesp.listarCategorias().size()];
    	arr = IEesp.listarCategorias().toArray(arr);
    	return arr;
    }
    
    @WebMethod
    public ListaUsuario listarUsuarios() {
    	HandlerUsuarios husuarios = HandlerUsuarios.getInstancia();
    	Map<String, Usuario> mapausuarios =  husuarios.getUsuarios();


    	List<dataUsuario> res = new ArrayList<dataUsuario>();
    	for (Usuario entry : mapausuarios.values()) {
    		if (entry.esArtista()) {
    			res.add(new dataUsuario(entry));
    		} else {
    			res.add(new dataUsuario(entry));
    		}
    	}
    	ListaUsuario lista = new ListaUsuario();
		lista.setUsuarios(res);
    	return lista;
    }
    
    @WebMethod
    public void seguir(String uaseguir, String uloggueado) {
    	HandlerUsuarios husuarios = HandlerUsuarios.getInstancia();
    	Usuario Usuarioaseguir = husuarios.getUsuario(uaseguir);
    	Usuario Usuariologgueado = husuarios.getUsuario(uloggueado);
    	Usuariologgueado.agregarSeguido(Usuarioaseguir);
    	Usuarioaseguir.agregarSiguiendo(Usuariologgueado);
    	
    }
    @WebMethod
    public void finalizarEspectaculo(String nombreEspectaculo) {
    	HandlerEspectaculos hespectaculos = HandlerEspectaculos.getInstance();
    	Espectaculo espFinalizar = hespectaculos.getEspectaculo(nombreEspectaculo);
    	espFinalizar.setFinalizado(true);
    }
    @WebMethod
    public void dejardeseguir(String uaseguir, String uloggueado) {
    	HandlerUsuarios husuarios = HandlerUsuarios.getInstancia();
    	Usuario Usuarioaseguir = husuarios.getUsuario(uaseguir);
    	Usuario Usuariologgueado = husuarios.getUsuario(uloggueado);
    	Usuariologgueado.quitarSeguido(Usuarioaseguir);
    	Usuarioaseguir.quitarSiguiendo(Usuariologgueado);	

    }
    @WebMethod
    public void agregarInfo(String ip, String url, String browser, String os) {
    	dataInfo info = new dataInfo(ip,url,browser,os);
    	HandlerInformacion handlerinfo = HandlerInformacion.getInstancia();
    	if (!handlerinfo.obtenerInformacion().contains(info)) {
        	handlerinfo.agregarInformacion(info);
    	}

    }
    @WebMethod
    public ListaInfo listarInfo() {
    	HandlerInformacion hinfo = HandlerInformacion.getInstancia();
    	List<dataInfo> listaInformacion =  hinfo.obtenerInformacion();
    	
    	List<dataInfo> res = new ArrayList<dataInfo>();
    	for(int i = 0; i < listaInformacion.size(); i++) {
    		dataInfo respaldo = new dataInfo(listaInformacion.get(i).getIp(),listaInformacion.get(i).getURL(),listaInformacion.get(i).getNavegador(),listaInformacion.get(i).getSO());
    		res.add(respaldo);
    	}
    	ListaInfo listaRetornar = new ListaInfo();
    	listaRetornar.setinformacion(res);
    	return listaRetornar;
    }
    
    @WebMethod
    public boolean consultaAccesosValida(String id) {
    	HandlerInformacion hinfo = HandlerInformacion.getInstancia();
    	LocalTime guardado = hinfo.getAhora().plusMinutes(3);
    	
    	if (id.equals(hinfo.getAcceso()) && (LocalTime.now().isBefore(guardado) || LocalTime.now().equals(guardado))) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    @WebMethod
	public ListaEspectaculo buscarEspectaculos(String search) {
    	ListaEspectaculo listaesp = new ListaEspectaculo();
		Map<String, dataEspectaculo> ret = new HashMap<String, dataEspectaculo>();
		HandlerEspectaculos handleresp = HandlerEspectaculos.getInstance();
		for (Entry<String, Espectaculo> entry : handleresp.getEspectaculos().entrySet()) {   
			if (entry.getValue().getNombre().toLowerCase().contains(search.toLowerCase()) || entry.getValue().getDescripcion().toLowerCase().contains(search.toLowerCase())) {
				ret.put(entry.getValue().getNombre() , new dataEspectaculo(entry.getValue()));
			}
		}
		listaesp.setEspectaculos(ret);
		return listaesp;
	}
	@WebMethod
	public ListaPaquete buscarPaquetes(String search) {
		ListaPaquete listapaq = new ListaPaquete();
		List<dataPaquete> ret = new ArrayList<dataPaquete>();
		HandlerPaquetes handlerpaq = HandlerPaquetes.getInstance();
		for (Entry<String, Paquete> entry : handlerpaq.getPaquetes().entrySet()) {    
			if (entry.getValue().getNombre().toLowerCase().contains(search.toLowerCase()) || entry.getValue().getDescripcion().toLowerCase().contains(search.toLowerCase())) {
				ret.add(new dataPaquete(entry.getValue()));
			}
		}
		listapaq.setPaquetes(ret);
		return listapaq;
	}
	
	@WebMethod
    public ListaUsuario espectadoresFuncion(String nomEspect, String nomFuncion) {
    	HandlerEspectaculos hEsp = HandlerEspectaculos.getInstance();
    	Espectaculo esp = hEsp.getEspectaculo(nomEspect);
    	Funcion fun = esp.getFuncion(nomFuncion);
    	List<Usuario> users = fun.getEspectadores();
    	List<dataUsuario> espectadores = new ArrayList<dataUsuario>();
    	for(int i = 0; i < users.size(); i++) {
    		espectadores.add(new dataUsuario(users.get(i)));
    	}
    	ListaUsuario usuarios = new ListaUsuario();
    	usuarios.setUsuarios(espectadores);
    	return usuarios;
    }
    
    @WebMethod
    public ListaUsuario espectadoresPremiados(String nomEspect, String nomFuncion) {
    	HandlerEspectaculos hEsp = HandlerEspectaculos.getInstance();
    	Espectaculo esp = hEsp.getEspectaculo(nomEspect);
    	Funcion fun = esp.getFuncion(nomFuncion);
    	List<Usuario> users = fun.getPremiados();
    	List<dataUsuario> espectadores = new ArrayList<dataUsuario>();
    	for(int i = 0; i < users.size(); i++) {
    		espectadores.add(new dataUsuario(users.get(i)));
    	}
    	ListaUsuario usuarios = new ListaUsuario();
    	usuarios.setUsuarios(espectadores);
    	return usuarios;
    }
    
    @WebMethod
    public void sortearPremiosFuncion(String nomEspect, String nomFuncion) {
    	HandlerEspectaculos hEsp = HandlerEspectaculos.getInstance();
    	Espectaculo esp = hEsp.getEspectaculo(nomEspect);
    	Funcion fun = esp.getFuncion(nomFuncion);
    	fun.sortearPremios();
    }
    
    @WebMethod
    public dataFuncion getFuncion(String nomEspect, String nomFuncion) {
    	HandlerEspectaculos hEsp = HandlerEspectaculos.getInstance();
    	Espectaculo esp = hEsp.getEspectaculo(nomEspect);
    	Funcion fun = esp.getFuncion(nomFuncion);
    	return new dataFuncion(fun);
    }
    public static int masAlta(List<Premio> premios) {
    	LocalDate fechaMax = premios.get(0).getFechaSorteado();
    	int res = 0;
    	for(int i = 1; i < premios.size(); i++) {
    		if(premios.get(i).getFechaSorteado().isAfter(fechaMax));
    		fechaMax = premios.get(i).getFechaSorteado();
    		res = i;
    	}
    	return res;
    }
    
    @WebMethod
    public void valorarEspectaculo(String espect,String user,int puntaje) throws YaVotoException {
    	HandlerEspectaculos he = HandlerEspectaculos.getInstance();
    	Espectaculo espe = he.getEspectaculo(espect);
    	espe.agregarValoracion(puntaje, user);
    }
    
    @WebMethod
    public dataListPremio getPremiosUsuarios(String nickname) {
    	HandlerUsuarios hUsers = HandlerUsuarios.getInstancia();
    	Usuario user = hUsers.getUsuario(nickname);
    	List<dataPremio> premios = new ArrayList<dataPremio>();
    	List<Premio> premiosUser = new ArrayList<Premio>(user.getPremios());
    	List<Premio> nuevos = new ArrayList<Premio>();
    	int n = premiosUser.size();
    	for(int i = 0; i < n; i++) {
    		int masTarde = masAlta(premiosUser);
    		nuevos.add(premiosUser.get(masTarde));
    		premiosUser.remove(masTarde);
    	}
    	for(int i = 0; i < nuevos.size(); i++) {
    		premios.add(new dataPremio(nuevos.get(i)));
    	}
    	dataListPremio premiosResp = new dataListPremio();
    	premiosResp.setPremios(premios);
    	return premiosResp;
    }
    
    @WebMethod
    public void quitarFavorito(String espec, String user) {
    	HandlerEspectaculos hespec = HandlerEspectaculos.getInstance();
    	Espectaculo espectaculo = hespec.getEspectaculo(espec);
    	espectaculo.setFavoritos(espectaculo.getFavoritos() - 1);
    	HandlerUsuarios husuarios = HandlerUsuarios.getInstancia();
    	Usuario usuario = husuarios.getUsuario(user);
    	usuario.quitarFavorito(espectaculo);
    }
    
    @WebMethod
    public void agregarFavorito(String espec, String user) {
    	HandlerEspectaculos hespec = HandlerEspectaculos.getInstance();
    	Espectaculo espectaculo = hespec.getEspectaculo(espec);
    	espectaculo.setFavoritos(espectaculo.getFavoritos() + 1);
    	HandlerUsuarios husuarios = HandlerUsuarios.getInstancia();
    	Usuario usuario = husuarios.getUsuario(user);
    	usuario.agregarFavorito(espectaculo);
    }
    
    @WebMethod
    public boolean existeUsuario(String username) {
    	HandlerUsuarios husuarios = HandlerUsuarios.getInstancia();
    	return husuarios.getNombres().contains(username);
    }
}
