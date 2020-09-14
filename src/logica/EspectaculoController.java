package logica;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import datatypes.DtEspectaculo;
import datatypes.DtFuncion;
import datatypes.DtRegistro;
//import jdk.nashorn.internal.objects.IteratorResult;
//import sun.security.jca.GetInstance;
import excepciones.NombreEspectaculoExisteException;
import excepciones.NombreFuncionexisteException;
import excepciones.UsuarioConMismoMailException;
import datatypes.DtUsuario;
import excepciones.noSeleccionoTres;
import excepciones.usuarioNoExiste;

public class EspectaculoController implements IEspectaculo {
	private String nomPlataforma;
	private String nickUsuario;
	private String nomespec;
	private String descripcion;
	private String nomfuncion;
	private String url;
	private int minEspect;
	private int maxEspect;
	private float costo;
	private LocalTime horainicio;
	private LocalDate fechaAlta;
	private LocalTime duracion;
	private LocalDate fecha;
	private ArrayList<String> invitados;
	private Espectaculo espectaculo;
	private Registro[] regsCanjeados;
	private boolean registroFueCanjeado = false;
	
	public String getNomPlataforma() {
		return nomPlataforma;
	}
	public void setNomPlataforma(String nomPlataforma) {
		this.nomPlataforma = nomPlataforma;
	}
	public String getNickArtista() {
		return nickUsuario;
	}
	public void setNickArtista(String nickArtista) {
		this.nickUsuario = nickArtista;
	}
	public String getNomespec() {
		return nomespec;
	}
	public void setNomespec(String nomespec) {
		this.nomespec = nomespec;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getNomfuncion() {
		return nomfuncion;
	}
	public void setNomfuncion(String nomfuncion) {
		this.nomfuncion = nomfuncion;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getMinEspect() {
		return minEspect;
	}
	public void setMinEspect(int minEspect) {
		this.minEspect = minEspect;
	}
	public int getMaxEspect() {
		return maxEspect;
	}
	public void setMaxEspect(int maxEspect) {
		this.maxEspect = maxEspect;
	}
	public float getCosto() {
		return costo;
	}
	public void setCosto(float costo) {
		this.costo = costo;
	}
	public LocalTime getHorainicio() {
		return horainicio;
	}
	public void setHorainicio(LocalTime horainicio) {
		this.horainicio = horainicio;
	}
	public LocalDate getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public LocalTime getDuracion() {
		return duracion;
	}
	public void setDuracion(LocalTime duracion) {
		this.duracion = duracion;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public ArrayList<String> getInvitados() {
		return invitados;
	}
	public void setInvitados(ArrayList<String> invitados) {
		this.invitados = invitados;
	}
	public Espectaculo getEspectaculo() {
		return espectaculo;
	}
	public void setEspectaculo(Espectaculo espectaculo) {
		this.espectaculo = espectaculo;
	}
	
	
	@Override
	public void elegirEspectaculo(String nomEspectaculo) {
		// TODO Auto-generated method stub
		HandlerEspectaculos espect = HandlerEspectaculos.getInstance();
		this.espectaculo = espect.getEspectaculo(nomEspectaculo);
		if (this.espectaculo == null) {
			System.out.print("no existe el espectaculo " + nomEspectaculo);
		}
	}
	@Override
	public void altaFuncion(String nombre, LocalDate fecha, LocalTime horaInicio, ArrayList<String> invitados,LocalDate fechaAlta) throws NombreFuncionexisteException{
		HandlerEspectaculos hesp = HandlerEspectaculos.getInstance();
		if(!hesp.existeNombreFuncion(nombre)) {
			this.nomfuncion = nombre;
			this.fecha = fecha;
			this.horainicio = horaInicio;
			this.invitados = invitados;
			this.fechaAlta = fechaAlta;
		}
		else
			throw new NombreFuncionexisteException("El nombre " + nombre + " ya esta en uso");
		
	}
	@Override
	public void ConfirmarAltaFuncion() {
		// TODO Auto-generated method stub
	
		//chequeo que existan los artistas invitados
		HandlerUsuarios hu = HandlerUsuarios.getInstancia();
		ArrayList<Usuario> nuevosinv = new ArrayList<Usuario>();
		if (invitados != null) {
		invitados.forEach(el -> {
			if (!hu.getUsuarios().containsKey(el)) {
				System.out.print("No existe el artista:" + el);
			} else {
				nuevosinv.add(hu.getUsuarios().get(el));
			}
		});
		}
		
		//creo la instancia nueva de funcion
		Funcion nuevafun = new Funcion(this.nomfuncion, this.fecha, this.horainicio, this.fechaAlta, nuevosinv, this.espectaculo);
		this.espectaculo.agregarFuncion(nuevafun);
	}
	
	@Override
	public ArrayList<String> listarPlataformas() {
		HandlerPlataforma hplat= HandlerPlataforma.getInstance();
		ArrayList<String> platlist= hplat.getNombres();
		return platlist;
	}
	
	public ArrayList<String> listarEspectaculosPlataforma(String nomPlataforma){
		HandlerPlataforma hp = HandlerPlataforma.getInstance();
		Plataforma plataforma = hp.getPlataforma(nomPlataforma);
		if (plataforma == null) {
			return null;
		}
		if (plataforma.getEspectaculos() == null) {
			return null;
		}
		ArrayList<String> nombresEspect = new ArrayList<String>(plataforma.getEspectaculos().keySet());
		return nombresEspect;
	}
	@Override
	public ArrayList<DtEspectaculo> mostrarEspectaculosPlataforma(String nomplat) {
		// TODO Auto-generated method stub
		HandlerPlataforma hp = HandlerPlataforma.getInstance();
		Plataforma p = hp.getPlataforma(nomplat);
		HashMap<String, Espectaculo> espect = p.getEspectaculos();
		
		ArrayList<DtEspectaculo> dtespect = new ArrayList<DtEspectaculo>();
		for (String value : espect.keySet()) {
			String nombre = espect.get(value).getNombre();
			LocalTime duracion = espect.get(value).getDuracion();
			String descrip = espect.get(value).getDescripcion();
			int minEspect = espect.get(value).getMinEspectadores();
			int maxEspect = espect.get(value).getMaxEspectadores();
			String url = espect.get(value).getUrl();
			LocalDate fechaReg = espect.get(value).getFechaReg();
			float costo = espect.get(value).getCosto();
			DtEspectaculo nuevo = new DtEspectaculo(nombre, duracion, descrip, minEspect, maxEspect, url, fechaReg, costo);
			dtespect.add(nuevo);
		}
		return dtespect;
	}
	@Override
	public ArrayList<DtFuncion> mostrarFuncionesEspectaculo(String nomespec) {
		// TODO Auto-generated method stub
		this.nomespec = nomespec;
		HandlerEspectaculos he = HandlerEspectaculos.getInstance();
		Espectaculo e = he.getEspectaculo(nomespec);
		HashMap<String,Funcion> mpFunciones = e.getAllFunciones();
		ArrayList<String> funciones = new ArrayList<String>(mpFunciones.keySet());
		ArrayList<DtFuncion> dtFunciones = new ArrayList<DtFuncion>();
		
		for(int i = 1; i<funciones.size(); i++) {
			Funcion fun = mpFunciones.get(funciones.get(i));
			String nombre = fun.getNombre();
			LocalDate fecha = fun.getFecha();
			LocalTime horainicio = fun.getHoraInicio();
			LocalDate fechaReg = fun.getFechaReg();
			DtFuncion nueva = new DtFuncion(nombre, fecha, horainicio, fechaReg);
			dtFunciones.add(nueva);
		}

		return dtFunciones;
		
	}
	public ArrayList<String> listarFuncionesEspectaculo(String nomespec) {
		HandlerEspectaculos he = HandlerEspectaculos.getInstance();
		Espectaculo e = he.getEspectaculo(nomespec);
		ArrayList<String> nomfun = new ArrayList<String>(e.getAllFunciones().keySet());
		return nomfun;
	}
	
	public DtFuncion mostarFuncion(String nomFuncion) {
		HandlerEspectaculos he = HandlerEspectaculos.getInstance();
		Espectaculo e = he.getEspectaculo(this.nomespec);
		Funcion f = e.getFuncion(nomFuncion);
		DtFuncion nueva = new DtFuncion(f.getNombre(), f.getFecha(), f.getHoraInicio(), f.getFechaReg());
		return nueva;
	}
	
	@Override
	public ArrayList<String> mostrarEspectadores() {
		// TODO Auto-generated method stub
		HandlerUsuarios hu = HandlerUsuarios.getInstancia();
		return hu.getNombres();
	}
	@Override
	public void ingresarNombreFuncion(String nomfuncion) {
		// TODO Auto-generated method stub
		//this.nickUsuario = nickname;
		this.nomfuncion = nomfuncion;
		
	}
	
	public void ingresarNombreEspectador(String nickname) {
		// TODO Auto-generated method stub
		this.nickUsuario = nickname;
		//this.nomfuncion = nomfuncion;
		
	}
	
	@Override
	public ArrayList<DtRegistro> obtenerRegistrosPrevios() {
		// TODO Auto-generated method stub
		HandlerUsuarios hu = HandlerUsuarios.getInstancia();
		Usuario espectador = hu.getUsuario(this.nickUsuario);
		return espectador.getRegistrosPrevios();
	}
	@Override
	public void canjearRegistros(DtRegistro[] dtRegs) throws noSeleccionoTres {
		// TODO Auto-generated method stub
		if(dtRegs.length != 3) {
			throw new noSeleccionoTres("Se deben seleccionar 3 registros");
		}
		int id1 = dtRegs[0].getId();
		int id2 =dtRegs[1].getId();
		int id3 = dtRegs[2].getId();
		HandlerUsuarios hu = HandlerUsuarios.getInstancia();
		Usuario espectador = hu.getUsuario(this.nickUsuario);
		ArrayList<Registro> regs = espectador.getRegistros();
		Iterator<Registro> it = regs.iterator();
		int i = 0;
		while(it.hasNext()) {
			Registro temp = it.next();
			int idTemp = temp.getId();
			if(idTemp == id1 || idTemp == id2 ||idTemp == id3) {
				this.regsCanjeados[i] = temp;
				i++;
			}
		}
		this.registroFueCanjeado = true;
	}
	@Override
	public boolean existeRegistroEspecAFun() {
		// TODO Auto-generated method stub
		HandlerUsuarios hu = HandlerUsuarios.getInstancia();
		Usuario espectador = hu.getUsuario(this.nickUsuario);
		System.out.println(espectador.getNickname());
		return espectador.tieneRegistroAFuncion(this.nomfuncion);
		
	}
	@Override
	public boolean funcionAlcanzoLimiteReg(String nomespect) {
		// TODO Auto-generated method stub
		HandlerEspectaculos he = HandlerEspectaculos.getInstance();
		Espectaculo e = he.getEspectaculo(nomespect);
		Funcion fun = e.getFuncion(this.nomfuncion);
		System.out.println(fun.getNombre());
		ArrayList<Registro> regs = fun.getRegistros();
		int cant = 0;
		for(int i = 0; i < regs.size(); i++) {
			cant++;
		}
		if(cant >= e.getMaxEspectadores()) {
			return true;
		}
			
		return false;
	}
	@Override
	public void elegirNuevaFuncion(String nomfuncion) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void elegirNuevoEspectador(String nickname) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void confirmarRegistro(String nomespect, LocalDate fecha) {
		// TODO Auto-generated method stub
		//obtengo la funcion
		HandlerEspectaculos he = HandlerEspectaculos.getInstance();
		Espectaculo e = he.getEspectaculo(nomespect);
		Funcion fun = e.getFuncion(this.nomfuncion);
		//obtengo al usuario
		HandlerUsuarios hu = HandlerUsuarios.getInstancia();
		Usuario espectador = hu.getUsuario(this.nickUsuario);
		LocalDate fechahoy = LocalDate.now();
		Registro nuevo;
		if(this.registroFueCanjeado) {
			nuevo = new Registro(fechahoy, false, espectador, fun, 0);
			nuevo.setRegsCanjeados(this.regsCanjeados);
			this.registroFueCanjeado = false;
		}else {
			nuevo = new Registro(fechahoy, false, espectador, fun, e.getCosto());
		}
		nuevo.setFecha(fecha);
		espectador.addFuncion(nuevo);
		fun.addEspectador(nuevo);
		
	}
	@Override
	public ArrayList<String> listarArtistas() {
		HandlerUsuarios huser = HandlerUsuarios.getInstancia();
		ArrayList<String> artlist= huser.getNombresArtistas();
		return artlist;
	}
	
	public DtUsuario[] listarUsuarios() throws usuarioNoExiste{
		HandlerUsuarios hu = HandlerUsuarios.getInstancia();
		Collection<Usuario> usrs = hu.getUsuarios().values();
		Object[] o = usrs.toArray();
        Usuario[] usuarios = new Usuario[o.length];
        for (int i = 0; i < o.length; i++) {
            usuarios[i] = (Usuario) o[i];
        }
		

        if (usuarios != null) {
            DtUsuario[] du = new DtUsuario[usuarios.length];
            Usuario user;

            // Para separar lógica de presentación, no se deben devolver los Usuario,
            // sino los DataUsuario
            for (int i = 0; i < usuarios.length; i++) {
                user = usuarios[i];
                du[i] = new DtUsuario(user.getNickname(), user.getNombre(), user.getApellido(), user.getEmail(), user.getFechaNacimiento());
            }

            return du;
        } else
            throw new usuarioNoExiste("No existen usuarios registrados");

    }
		
	
	@Override
	public void altaEspectaculo(String nomPlataforma, String nickArtista, String nombre, String descripcion,
			LocalTime duracion,int minEspec, int maxEspec, String url, float costo, LocalDate fechaAlta) throws NombreEspectaculoExisteException {
		
		HandlerEspectaculos hesp = HandlerEspectaculos.getInstance();
		if( hesp.getEspectaculo(nombre) == null) {
			this.nomespec= nombre;
			this.nomPlataforma= nomPlataforma;
			this.nickUsuario = nickArtista;
			this.descripcion= descripcion;
			this.duracion= duracion;
			this.minEspect= minEspec;
			this.maxEspect= maxEspec;
			this.url= url;
			this.costo= costo;
			this.fechaAlta= fechaAlta;
		}
		else
			throw new NombreEspectaculoExisteException("El nombre de espectaculo " + nombre + " ya esta en uso");	
	}
	
	@Override
	public void confirmarAltaEspectaculo() {
		HandlerUsuarios huser= HandlerUsuarios.getInstancia();
		HandlerPlataforma hplat= HandlerPlataforma.getInstance();
		HandlerEspectaculos hesp= HandlerEspectaculos.getInstance();
		Artista art= (Artista) huser.getUsuario(nickUsuario);
		Plataforma plat= hplat.getPlataforma(nomPlataforma);
		Espectaculo esp= new Espectaculo(nomespec,duracion, descripcion, minEspect, maxEspect, url, fechaAlta, costo);		
		Fabrica f = Fabrica.getInstance();
		IPlataforma pc = f.getIPlataforma();
		esp.setPlataforma(plat);
		esp.setArtista(art);
		pc.agregarEspectaculoPlataforma(plat, esp);
		hesp.addEspectaculo(esp);
	}
	@Override
	public void elegirFuncion(String selectedItem) {
		// TODO Auto-generated method stub
		
	}
	

}
