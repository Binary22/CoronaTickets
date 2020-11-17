package logica;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import datatypes.DtEspectaculo;
import datatypes.DtFuncion;
import datatypes.DtRegistro;
import datatypes.DtUsuario;
import excepciones.NombreCategoriaExistente;
//import jdk.nashorn.internal.objects.IteratorResult;
//import sun.security.jca.GetInstance;
import excepciones.NombreEspectaculoExisteException;
import excepciones.NombreFuncionexisteException;
import excepciones.UsuarioNoExisteException;
import excepciones.fechaPosterior;
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
	private List<String> invitados;
	private Espectaculo espectaculo;
	private Registro[] regsCanjeados;
	private boolean registroFueCanjeado = false;
	private String nomCategoria;
	private List<String> categorias;
	private String imagen;
	
	
	public void setRegistroFueCanjeado(boolean canj) {
		this.registroFueCanjeado = canj;
	}

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

	public List<String> getInvitados() {
		return invitados;
	}

	public void setInvitados(List<String> invitados) {
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
		this.nomespec = this.espectaculo.getNombre();
		if (this.espectaculo == null) {
			System.out.print("no existe el espectaculo " + nomEspectaculo);
		}
	}

	@Override
	public void altaFuncion(String nombre, LocalDate fecha, LocalTime horaInicio, List<String> invitados,
			LocalDate fechaAlta) throws NombreFuncionexisteException {
		HandlerEspectaculos hesp = HandlerEspectaculos.getInstance();
		if (!hesp.existeNombreFuncion(nombre)) {
			this.nomfuncion = nombre;
			this.fecha = fecha;
			this.horainicio = horaInicio;
			this.invitados = invitados;
			this.fechaAlta = fechaAlta;
		} else
			throw new NombreFuncionexisteException("El nombre " + nombre + " ya esta en uso");

	}
	
	

	@Override
	public void confirmarAltaFuncion() {
		// TODO Auto-generated method stub

		// chequeo que existan los artistas invitados
		HandlerUsuarios husers = HandlerUsuarios.getInstancia();
		List<Usuario> nuevosinv = new ArrayList<Usuario>();
		if (invitados != null) {
			invitados.forEach(el -> {
				Usuario nuevo = husers.getUsuarios().get(el);
				if (nuevo == null)
					try {
						throw new UsuarioNoExisteException("el usuario " + el + " no existe.");
					} catch (UsuarioNoExisteException e) {
						System.out.print(e.getMessage() + "\n");
						e.printStackTrace();
					}
					nuevosinv.add(nuevo);
			});
		}
		
		//creo la instancia nueva de funcion
		Funcion nuevafun = new Funcion(this.nomfuncion, this.fecha, this.horainicio, this.fechaAlta, nuevosinv, this.espectaculo);
		this.espectaculo.agregarFuncion(nuevafun);
	}
	
	@Override
	public List<String> listarPlataformas() {
		HandlerPlataforma hplat= HandlerPlataforma.getInstance();
		List<String> platlist= hplat.getNombres();
		return platlist;
	}
	
	public List<String> listarEspectaculosPlataforma(String nomPlataforma){
		HandlerPlataforma hplat = HandlerPlataforma.getInstance();
		Plataforma plataforma = hplat.getPlataforma(nomPlataforma);
		if (plataforma == null) {
			return null;
		}
		if (plataforma.getEspectaculos() == null) {
			return null;
		}
		List<String> nombresEspect = new ArrayList<String>(plataforma.getEspectaculos().keySet());
		return nombresEspect;
	}
	@Override
	public List<DtEspectaculo> mostrarEspectaculosPlataforma(String nomplat) {
		// TODO Auto-generated method stub
		HandlerPlataforma hPlat = HandlerPlataforma.getInstance();
		Plataforma plat = hPlat.getPlataforma(nomplat);
		Map<String, Espectaculo> espect = plat.getEspectaculos();
		
		List<DtEspectaculo> dtespect = new ArrayList<DtEspectaculo>();
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
	public void altaEspectaculoWeb(String nomPlataforma, String nickArtista, String nombre, String descripcion,
			LocalTime duracion, int minEspec, int maxEspec, String url, float costo, LocalDate fechaAlta, List<String> cat, String imagen)
			throws NombreEspectaculoExisteException {
		// TODO Auto-generated method stub
		
		HandlerEspectaculos hesp = HandlerEspectaculos.getInstance();
		if ( hesp.getEspectaculo(nombre) == null) {
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
			this.categorias= cat;
			this.imagen = imagen;
		}
		else throw new NombreEspectaculoExisteException("El nombre de espectaculo " + nombre + " ya esta en uso");
		
		HandlerUsuarios huser= HandlerUsuarios.getInstancia();
		HandlerPlataforma hplat= HandlerPlataforma.getInstance();
		Artista art= (Artista) huser.getUsuario(nickUsuario);
		Plataforma plat= hplat.getPlataforma(nomPlataforma);
		Espectaculo esp= new Espectaculo(nomespec, duracion, descripcion, minEspect, maxEspect, url, fechaAlta, costo, imagen, categorias);		
		Fabrica fabric = Fabrica.getInstance();
		IPlataforma iPlat = fabric.getIPlataforma();
		esp.setPlataforma(plat);
		esp.setArtista(art);
		iPlat.agregarEspectaculoPlataforma(plat, esp);
		hesp.addEspectaculo(esp);
	}
	
	
	@Override
	public List<DtFuncion> mostrarFuncionesEspectaculo(String nomespec) {
		// TODO Auto-generated method stub
		this.nomespec = nomespec;
		HandlerEspectaculos hEspectaculos = HandlerEspectaculos.getInstance();
		Espectaculo espect = hEspectaculos.getEspectaculo(nomespec);
		Map<String, Funcion> mpFunciones = espect.getAllFunciones();
		List<String> funciones = new ArrayList<String>(mpFunciones.keySet());
		List<DtFuncion> dtFunciones = new ArrayList<DtFuncion>();
		
		for (int i = 0; i < funciones.size(); i++) {
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
	public List<String> listarFuncionesEspectaculo(String nomespec) {
		HandlerEspectaculos hEspectaculos = HandlerEspectaculos.getInstance();
		Espectaculo espect = hEspectaculos.getEspectaculo(nomespec);
		List<String> nomfun = new ArrayList<String>(espect.getAllFunciones().keySet());
		return nomfun;
	}
	
	public DtFuncion mostarFuncion(String nomFuncion) {
		//Espectaculo e = this.espectaculo;
		HandlerEspectaculos hEspectaculos = HandlerEspectaculos.getInstance();
		Espectaculo espect = hEspectaculos.getEspectaculo(this.nomespec);
		Funcion fun = espect.getFuncion(nomFuncion);
		DtFuncion nueva = new DtFuncion(fun.getNombre(), fun.getFecha(), fun.getHoraInicio(), fun.getFechaReg());
		return nueva;
	}
	
	@Override
	public List<String> mostrarEspectadores() {
		// TODO Auto-generated method stub
		HandlerUsuarios husers = HandlerUsuarios.getInstancia();
		return husers.getNombres();
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
	public List<DtRegistro> obtenerRegistrosPrevios() {
		// TODO Auto-generated method stub
		HandlerUsuarios husers = HandlerUsuarios.getInstancia();
		Usuario espectador = husers.getUsuario(this.nickUsuario);
		return espectador.getRegistrosPrevios();
	}
	
	public List<Registro> obtenerRegistrosPreviosWeb(String nickname) {
		// TODO Auto-generated method stub
		this.nickUsuario = nickname;
		HandlerUsuarios husers = HandlerUsuarios.getInstancia();
		Usuario espectador = husers.getUsuario(this.nickUsuario);
		return espectador.getRegistrosPreviosWeb();
	}
	
	@Override
	public void canjearRegistros(int[] regsId) throws noSeleccionoTres {
		// TODO Auto-generated method stub
		this.regsCanjeados = new Registro[3];
		int id1 = regsId[0];
		int id2 =regsId[1];
		int id3 = regsId[2];
		HandlerUsuarios husers = HandlerUsuarios.getInstancia();
		Usuario espectador = husers.getUsuario(this.nickUsuario);
		List<Registro> regs = espectador.getRegistros();
		Registro[] regsTempo = new Registro[3];
		int cantSelected = 0;
		int jvar = 0;
		for (int i = 0; i < regs.size(); i++) {
			int idTemp = regs.get(i).getId();
			if (idTemp == id1 || idTemp == id2 || idTemp == id3) {
				regsTempo[jvar] = regs.get(i);
				jvar++;
				cantSelected++;
				}
			}
		
		if (cantSelected != 3) {
			throw new noSeleccionoTres("Se deben seleccionar 3 registros");
		}
			
		this.registroFueCanjeado = true;
		this.regsCanjeados = regsTempo;
	}
		
	
	@Override
	public boolean existeRegistroEspecAFun() {
		// TODO Auto-generated method stub
		HandlerUsuarios husers = HandlerUsuarios.getInstancia();
		Usuario espectador = husers.getUsuario(this.nickUsuario);
		System.out.println(this.nomfuncion);
		return espectador.tieneRegistroAFuncion(this.nomfuncion);
		
	}
	
	
	@Override
	public boolean funcionAlcanzoLimiteReg(String nomespect) {
		// TODO Auto-generated method stub
		this.nomespec = nomespect;
		HandlerEspectaculos hEspectaculos = HandlerEspectaculos.getInstance();
		Espectaculo espect = hEspectaculos.getEspectaculo(nomespect);
		Funcion fun = espect.getFuncion(this.nomfuncion);
		//System.out.println(fun.getNombre());
		List<Registro> regs = fun.getRegistros();
		int cant = 0;
		for (int i = 0; i < regs.size(); i++) {
			cant++;
		}
		if (cant == espect.getMaxEspectadores()) {
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
	public void confirmarRegistro(String nomespect, LocalDate fecha){
		// TODO Auto-generated method stub
		//obtengo la funcion
		HandlerEspectaculos hEspectaculos = HandlerEspectaculos.getInstance();
		Espectaculo espect = hEspectaculos.getEspectaculo(nomespect);
		Funcion fun = espect.getFuncion(this.nomfuncion);
		//obtengo al usuario
		HandlerUsuarios husers = HandlerUsuarios.getInstancia();
		Usuario espectador = husers.getUsuario(this.nickUsuario);
		Registro nuevo;
		if (!(fun == null) && !(espectador == null)) {
					
			if (this.registroFueCanjeado) {
				for (int i = 0; i < this.regsCanjeados.length; i++) {
					this.regsCanjeados[i].setCanjeado(true);
				}
				nuevo = new Registro(fecha, true, espectador, fun, 0);
				nuevo.setRegsCanjeados(this.regsCanjeados);
				
			}else {
				nuevo = new Registro(fecha, false, espectador, fun, espect.getCosto());
			}
				
			espectador.addFuncion(nuevo);
			fun.addEspectador(nuevo);
			
		}
		this.registroFueCanjeado = false;
		
	}
	
	
	//CONFIRMAR REGISTRO PARA INTERFAZ
	
	public void esFechaInvalida(String nomespect, LocalDate fecha) throws fechaPosterior {
		HandlerEspectaculos hEspectaculos = HandlerEspectaculos.getInstance();
		Espectaculo espect = hEspectaculos.getEspectaculo(nomespect);
		Funcion fun = espect.getFuncion(this.nomfuncion);
		LocalTime hora = LocalTime.now();
		LocalDate fechaHoy = LocalDate.now();
		if ((fecha.equals(fun.getFecha()) && !hora.isBefore(fun.getHoraInicio())) || fecha.isAfter(fun.getFecha()) || fecha.isBefore(fechaHoy)) {
				throw new fechaPosterior("Lo sentimos, la fecha introducida es invalida");
		}
	}
	
	@Override
	public List<String> listarArtistas() {
		HandlerUsuarios huser = HandlerUsuarios.getInstancia();
		List<String> artlist= huser.getNombresArtistas();
		return artlist;
	}
	
	public DtUsuario[] listarUsuarios() throws usuarioNoExiste{
		HandlerUsuarios husers = HandlerUsuarios.getInstancia();
		Collection<Usuario> usrs = husers.getUsuarios().values();
		Object[] obj = usrs.toArray();
        Usuario[] usuarios = new Usuario[obj.length];
        for (int i = 0; i < obj.length; i++) {
            usuarios[i] = (Usuario) obj[i];
        }
		

        if (usuarios != null) {
            DtUsuario[] duser = new DtUsuario[usuarios.length];
            Usuario user;

            // Para separar lógica de presentación, no se deben devolver los Usuario,
            // sino los DataUsuario
            for (int i = 0; i < usuarios.length; i++) {
                user = usuarios[i];
                duser[i] = new DtUsuario(user.getNickname(), user.getNombre(), user.getApellido(), user.getEmail(), user.getFechaNacimiento());
            }

            return duser;
        } else
            throw new usuarioNoExiste("No existen usuarios registrados");

    }
		
	
	@Override
	public void altaEspectaculo(String nomPlataforma, String nickArtista, String nombre, String descripcion,
			LocalTime duracion, int minEspec, int maxEspec, String url, float costo, LocalDate fechaAlta) throws NombreEspectaculoExisteException {
		
		HandlerEspectaculos hesp = HandlerEspectaculos.getInstance();
		if (hesp.getEspectaculo(nombre) == null) {
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
		HandlerUsuarios huser = HandlerUsuarios.getInstancia();
		HandlerPlataforma hplat = HandlerPlataforma.getInstance();
		HandlerEspectaculos hesp = HandlerEspectaculos.getInstance();
		Artista art = (Artista) huser.getUsuario(nickUsuario);
		Plataforma plat = hplat.getPlataforma(nomPlataforma);
		Espectaculo esp = new Espectaculo(nomespec, duracion, descripcion, minEspect, maxEspect, url, fechaAlta, costo);		
		Fabrica fabric = Fabrica.getInstance();
		IPlataforma iPlat = fabric.getIPlataforma();
		esp.setPlataforma(plat);
		esp.setArtista(art);
		iPlat.agregarEspectaculoPlataforma(plat, esp);
		hesp.addEspectaculo(esp);
	}
	@Override
	public void elegirFuncion(String selectedItem) {
		this.nomfuncion = selectedItem;
		
	}
	
	public List<String> listarCategorias(){
		HandlerCategorias hCats = HandlerCategorias.getInstance();
		ArrayList<String> nomCategorias = new ArrayList<String>(hCats.getCategorias().keySet());
		return nomCategorias;
	}
	
	public List<String> listarCategoriasEspectaculo(String nomEspec) {
		HandlerEspectaculos handler = HandlerEspectaculos.getInstance();
		return handler.getEspectaculo(nomEspec).listarCategorias();
	}
	
	public void confirmarCategoria(String nombre)throws NombreCategoriaExistente {
		HandlerCategorias hcats = HandlerCategorias.getInstance();
		if (!hcats.existeCategoria(nombre)) {
			Categoria cat = new Categoria(nombre);
			hcats.getCategorias().put(nombre, cat);
		}else {
			throw new NombreCategoriaExistente("El nombre de la categoria " + nombre + " ya existe");
		}
		
	}
	
	public List<String> listarEspectaculosIngresados(){
		HandlerEspectaculos hEspectaculos = HandlerEspectaculos.getInstance();
		List<String> ingresados = new ArrayList<String>();
		for (String key : hEspectaculos.getEspectaculos().keySet()) {
			if (!hEspectaculos.getEspectaculos().get(key).isYaFueValuado()) {
				ingresados.add(key);
			}
		}
		return ingresados;
	}
	
	
	
	public void aceptarRechazar(String nombreEspect, boolean aceptado) {
		HandlerEspectaculos hEspectaculos = HandlerEspectaculos.getInstance();
		Espectaculo espect = hEspectaculos.getEspectaculo(nombreEspect);
		espect.setYaFueValuado(true);
		if (aceptado)
			espect.setAceptado(aceptado);
	}

	public String getNomCategoria() {
		return nomCategoria;
	}

	public String getImagen() {
		return imagen;
	}


}
