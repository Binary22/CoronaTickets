package logica;

import java.util.ArrayList;

import datatypes.DtArtista;
import datatypes.DtEspectaculo;
import datatypes.DtFuncion;
import datatypes.DtPaquete;
import datatypes.DtUsuario;
import excepciones.NoExistePaqueteException;
import excepciones.NoHayPaquetesException;

public class ConsultaController implements IConsulta {
	private Funcion funcion;
	private Espectaculo espectaculo;
	public Espectaculo getEspectaculo() {
		return espectaculo;
	}

	public void setEspectaculo(Espectaculo espectaculo) {
		this.espectaculo = espectaculo;
	}

	private Paquete paquete;
	private Usuario usuario;
	
	public ConsultaController(Funcion f, Espectaculo e, Paquete p, Usuario u) {
		funcion = null;
		espectaculo = null;
		paquete = null;
		usuario = null;
	}
	
	public ConsultaController() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<String> listarUsuarios() {
		HandlerUsuarios hu = HandlerUsuarios.getInstancia();
		ArrayList<String> listanombres = hu.getNombres();
		
		return listanombres;
	}

	@Override
	public void elegirEspectaculo(String nomespect) {
		HandlerEspectaculos he = HandlerEspectaculos.getInstance();
		espectaculo = he.getEspectaculo(nomespect);
	}

	@Override
	public void elegirFuncion(String espectaculo, String nomFuncion) {
		HandlerEspectaculos he = HandlerEspectaculos.getInstance();
		Espectaculo espec = he.getEspectaculo(espectaculo);
		Funcion f = espec.getAllFunciones().get(nomFuncion);
		//aca quizas deberia tirar una exepcion o algo
		funcion = f;
	}

	@Override
	public ArrayList<String> listarPaquetes() throws NoHayPaquetesException {
		HandlerPaquetes hp = HandlerPaquetes.getInstance();
		ArrayList<String> res = hp.getNombresPaquete();
		if (res.isEmpty()) throw new NoHayPaquetesException("No hay paquetes en el sistema");
		return hp.getNombresPaquete();
	}
	
//	@Override
//	public ArrayList<String> listarPaquetes() {
//		HandlerPaquetes hpaq = HandlerPaquetes.getInstance();
//		return hpaq.getNombresPaquetesEspectaculo(espectaculo.getNombre());
//	}

	@Override
	public void seleccionarPaquete(String nompaquete) throws NoExistePaqueteException{
		HandlerPaquetes hp = HandlerPaquetes.getInstance();
		paquete = hp.getPaquete(nompaquete);
	}

	@Override
	public ArrayList<String> listarPlataformas() {
		HandlerPlataforma hplat= HandlerPlataforma.getInstance();
		ArrayList<String> platlist= hplat.getNombres();
		return platlist;
	}

	@Override
	public ArrayList<String> listarEspectaculosPlataforma(String nomPlataforma) {
		HandlerPlataforma hp = HandlerPlataforma.getInstance();
		Plataforma plat = hp.getPlataforma(nomPlataforma);
		return new ArrayList<String>(plat.getEspectaculos().keySet());
	}

	@Override
	public ArrayList<String> listarFuncionesEspect(String nomEspectaculo) {
		HandlerEspectaculos he = HandlerEspectaculos.getInstance();
		espectaculo = he.getEspectaculo(nomEspectaculo);
		return new ArrayList<String>(this.espectaculo.getAllFunciones().keySet());
	}

	@Override
	public DtUsuario mostrarDatos(String nickname) {
		HandlerUsuarios hu = HandlerUsuarios.getInstancia();
		Usuario u = hu.getUsuario(nickname);
		DtUsuario dtu = u.getDt();
		return dtu;
	}

	@Override
	public ArrayList<DtEspectaculo> listarEspectaculosQueOrganiza() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> listarFuncionesQueSeRegistro(String nickname) {
		HandlerUsuarios hu = HandlerUsuarios.getInstancia();
		return hu.listarFuncionesQueSeRegistro(nickname);
	}
	
	public ArrayList<DtFuncion> listarFuncionesDtQueSeRegistro(String nickname) {
		HandlerUsuarios hu = HandlerUsuarios.getInstancia();
		return hu.listarFuncionesDtQueSeRegistro(nickname);
	}

	@Override
	public DtPaquete mostrarPaquete() {
		return new DtPaquete(paquete);
	}

	@Override
	public DtEspectaculo mostrarEspectaculo() {
		return new DtEspectaculo(espectaculo);
	}

	@Override
	public DtFuncion mostrarFuncion() {
		return this.funcion.getDt();
	}
	
	public boolean esArtista(String nickname) {
		HandlerUsuarios hu = HandlerUsuarios.getInstancia();
		return hu.esArtista_(nickname);
	}
	public DtArtista mostrarDatosArtista(String nickname) {
		HandlerUsuarios hu = HandlerUsuarios.getInstancia();
		Usuario u = hu.getUsuario(nickname);
		DtArtista dta = u.getDtArtista();
		return dta;
	}
	
	public Funcion getFuncion() {
		return funcion;
	}

}
