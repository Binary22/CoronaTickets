package logica;

import java.time.LocalDate;
//import java.time.LocalDateTime;
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
	
	private String nomespec;
	private String nickname;
	private String nomfuncion;
	private LocalDate fecha;
	private LocalTime horainicio;
	private ArrayList<String> invitados;
	private LocalDate fechaAlta;
	private Espectaculo espectaculo;
	
	
	public String getNomespec() {
		return nomespec;
	}
	public void setNomespec(String nomespec) {
		this.nomespec = nomespec;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getNomfuncion() {
		return nomfuncion;
	}
	public void setNomfuncion(String nomfuncion) {
		this.nomfuncion = nomfuncion;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public LocalTime getHorainicio() {
		return horainicio;
	}
	public void setHorainicio(LocalTime horainicio) {
		this.horainicio = horainicio;
	}
	public ArrayList<String> getInvitados() {
		return invitados;
	}
	public void setInvitados(ArrayList<String> invitados) {
		this.invitados = invitados;
	}
	public LocalDate getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
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
			//hago downcast
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
		// TODO Auto-generated method stub
		HandlerPlataforma hp = HandlerPlataforma.getInstance();
		ArrayList<String> nombresPlat = hp.getNombres();
		return nombresPlat;
		
	}
	
	public ArrayList<String> listarEspectaculosPlataforma(String nomPlataforma){
		HandlerPlataforma hp = HandlerPlataforma.getInstance();
		Plataforma plataforma = hp.getPlataforma(nomPlataforma);
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
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void altaEspectaculo(String nomPlataforma, String nickArtista, String nombre, String descripcion,
			int duracion, int maxEspec, String url, float costo, LocalDate fechaAlta) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void confirmarAltaEspectaculo() {
		// TODO Auto-generated method stub
		
	}
	

	
	

}
