package logica;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class EspectaculoController implements IEspectaculo {
	
	private String nomespec;
	private String nickname;
	private String nomfuncion;
	private LocalDateTime fecha;
	private LocalDateTime fincio;
	private ArrayList<String> invitados;
	private LocalDateTime fechaAlta;

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

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public LocalDateTime getFincio() {
		return fincio;
	}

	public void setFincio(LocalDateTime fincio) {
		this.fincio = fincio;
	}

	public ArrayList<String> getInvitados() {
		return invitados;
	}

	public void setInvitados(ArrayList<String> invitados) {
		this.invitados = invitados;
	}

	public LocalDateTime getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDateTime fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public EspectaculoController() {
		super();
	}
	

	@Override
	public void elegirEspectaculo(String nomEspectaculo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void altaFuncion(String nombre, LocalDateTime fecha, LocalDateTime fechaInicio, ArrayList<String> invitados,
			LocalDateTime fechaAlta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void ConfirmarAltaFuncion() {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<String> listarPlataformas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> mostrarEspectadores() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ingresarDatosRegistro(String nickname, String nomfuncion, LocalDateTime fecha) {
		// TODO Auto-generated method stub

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
			int duracion, int maxEspec, String url, float costo, LocalDateTime fechaAlta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void confirmarAltaEspectaculo() {
		// TODO Auto-generated method stub

	}

}
