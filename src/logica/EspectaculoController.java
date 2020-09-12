package logica;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import datatypes.DtEspectaculo;
import datatypes.DtFuncion;
import datatypes.DtRegistro;
//import jdk.nashorn.internal.objects.IteratorResult;
//import sun.security.jca.GetInstance;

public class EspectaculoController implements IEspectaculo {
	private String nomPlataforma;
	private String nickArtista;
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
	
	
	public String getNomPlataforma() {
		return nomPlataforma;
	}
	public void setNomPlataforma(String nomPlataforma) {
		this.nomPlataforma = nomPlataforma;
	}
	public String getNickArtista() {
		return nickArtista;
	}
	public void setNickArtista(String nickArtista) {
		this.nickArtista = nickArtista;
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
		
	}
	@Override
	public void altaFuncion(String nombre, LocalDate fecha, LocalTime horaInicio, ArrayList<String> invitados,
			LocalDate fechaAlta) {
		// TODO Auto-generated method stub
		this.nomfuncion = nombre;
		this.fecha = fecha;
		this.horainicio = horaInicio;
		this.invitados = invitados;
		this.fechaAlta = fechaAlta;
		
		
		
		
	}
	@Override
	public void ConfirmarAltaFuncion() {
		// TODO Auto-generated method stub
		
		//chequeo que existan los artistas invitados
		HandlerUsuarios hu = HandlerUsuarios.getInstancia();
		HashMap<String, Usuario> usuarios = hu.getUsuarios();
		//Iterator<Entry<String, Usuario>> it = usuarios.entrySet().iterator();
		
		ArrayList<String> inv = this.invitados;
		Iterator<String> it2 = inv.iterator();
		
		ArrayList<Usuario> nuevosinv = new ArrayList<Usuario>();
		
		while(it2.hasNext()) {
			
			Usuario artista = usuarios.get(it2.next());
			if(artista != null && artista.esArtista()) {
				nuevosinv.add(artista);
			}
			
		}
		//creo la instancia nueva de funcion
		Funcion nuevafun = new Funcion(this.nomfuncion, this.fechaAlta, this.horainicio, this.fecha, nuevosinv, this.espectaculo);
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
		return null;
	}
	@Override
	public ArrayList<DtFuncion> mostrarFuncionesEspectaculo(String nomespec) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<String> mostrarEspectadores() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void ingresarDatosRegistro(String nickname, String nomfuncion, LocalDate fecha) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public ArrayList<DtRegistro> obtenerRegistrosPrevios() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void canjearRegistros(int id1, int id2, int id3) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean existeRegistroEspecAFun() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean funcionAlcanzoLimiteReg() {
		// TODO Auto-generated method stub
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
	public void confirmarRegistro() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public ArrayList<String> listarArtistas() {
		HandlerUsuarios huser = HandlerUsuarios.getInstancia();
		ArrayList<String> artlist= huser.getNombresArtistas();
		return artlist;
	}
	@Override
	public void altaEspectaculo(String nomPlataforma, String nickArtista, String nombre, String descripcion,
			LocalTime duracion,int minEspec, int maxEspec, String url, float costo, LocalDate fechaAlta) {
		this.nomPlataforma= nomPlataforma;
		this.nickArtista= nickArtista;
		this.nomespec= nombre;
		this.descripcion= descripcion;
		this.duracion= duracion;
		this.minEspect= minEspec;
		this.maxEspect= maxEspec;
		this.url= url;
		this.costo= costo;
		this.fechaAlta= fechaAlta;
		
	}
	
	@Override
	public void confirmarAltaEspectaculo() {
		HandlerUsuarios huser= HandlerUsuarios.getInstancia();
		HandlerPlataforma hplat= HandlerPlataforma.getInstance();
		HandlerEspectaculos hesp= HandlerEspectaculos.getInstance();
		Artista art= (Artista) huser.getUsuario(nickArtista);
		Plataforma plat= hplat.getPlataforma(nomPlataforma);
		Espectaculo esp= new Espectaculo(nomespec,duracion, descripcion, minEspect, maxEspect, url, fechaAlta, costo);		
		Fabrica f = Fabrica.getInstance();
		IPlataforma pc = f.getIPlataforma();
		esp.setPlataforma(plat);
		esp.setArtista(art);
		pc.agregarEspectaculoPlataforma(plat, esp);
		hesp.addEspectaculo(esp);
	}
	

}
