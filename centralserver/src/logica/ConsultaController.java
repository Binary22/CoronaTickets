package logica;

import java.util.ArrayList;
import java.util.List;

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
	
	public Paquete getPaquete() {
		return this.paquete;
	}
	
	public ConsultaController(Funcion fun, Espectaculo espect, Paquete paq, Usuario user) {
		funcion = null;
		espectaculo = null;
		paquete = null;
		usuario = null;
	}
	
	public ConsultaController() {
		// TODO Auto-generated constructor stub
	}

	public List<String> listarUsuarios() {
		HandlerUsuarios husers = HandlerUsuarios.getInstancia();
		List<String> listanombres = husers.getNombres();
		
		return listanombres;
	}

	@Override
	public void elegirEspectaculo(String nomespect) {
		HandlerEspectaculos hEspectaculos = HandlerEspectaculos.getInstance();
		espectaculo = hEspectaculos.getEspectaculo(nomespect);
	}

	@Override
	public void elegirFuncion(String espectaculo, String nomFuncion) {
		HandlerEspectaculos hEspectaculos = HandlerEspectaculos.getInstance();
		Espectaculo espec = hEspectaculos.getEspectaculo(espectaculo);
		Funcion fun = espec.getAllFunciones().get(nomFuncion);
		//aca quizas deberia tirar una exepcion o algo
		funcion = fun;
	}

	@Override
	public List<String> listarPaquetes() throws NoHayPaquetesException {
		HandlerPaquetes hpaq = HandlerPaquetes.getInstance();
		List<String> res = hpaq.getNombresPaquete();
		if (res.isEmpty()) throw new NoHayPaquetesException("No hay paquetes en el sistema");
		return hpaq.getNombresPaquete();
	}
	
//	@Override
//	public ArrayList<String> listarPaquetes() {
//		HandlerPaquetes hpaq = HandlerPaquetes.getInstance();
//		return hpaq.getNombresPaquetesEspectaculo(espectaculo.getNombre());
//	}

	@Override
	public void seleccionarPaquete(String nompaquete) throws NoExistePaqueteException{
		HandlerPaquetes hpaq = HandlerPaquetes.getInstance();
		paquete = hpaq.getPaquete(nompaquete);
	}

	@Override
	public List<String> listarPlataformas() {
		HandlerPlataforma hplat= HandlerPlataforma.getInstance();
		List<String> platlist= hplat.getNombres();
		return platlist;
	}

	@Override
	public List<String> listarEspectaculosPlataforma(String nomPlataforma) {
		HandlerPlataforma hplat = HandlerPlataforma.getInstance();
		Plataforma plat = hplat.getPlataforma(nomPlataforma);
		return new ArrayList<String>(plat.getEspectaculos().keySet());
	}

	@Override
	public List<String> listarFuncionesEspect(String nomEspectaculo) {
		HandlerEspectaculos hEspectaculos = HandlerEspectaculos.getInstance();
		espectaculo = hEspectaculos.getEspectaculo(nomEspectaculo);
		return new ArrayList<String>(this.espectaculo.getAllFunciones().keySet());
	}

	@Override
	public DtUsuario mostrarDatos(String nickname) {
		HandlerUsuarios husers = HandlerUsuarios.getInstancia();
		Usuario usuario = husers.getUsuario(nickname);
		DtUsuario dtu = usuario.getDt();
		return dtu;
	}

	@Override
	public List<DtEspectaculo> listarEspectaculosQueOrganiza() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> listarFuncionesQueSeRegistro(String nickname) {
		HandlerUsuarios husers = HandlerUsuarios.getInstancia();
		return husers.listarFuncionesQueSeRegistro(nickname);
	}
	
	public List<DtFuncion> listarFuncionesDtQueSeRegistro(String nickname) {
		HandlerUsuarios husers = HandlerUsuarios.getInstancia();
		return husers.listarFuncionesDtQueSeRegistro(nickname);
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
		HandlerUsuarios husers = HandlerUsuarios.getInstancia();
		return husers.esArtistaA(nickname);
	}
	public DtArtista mostrarDatosArtista(String nickname) {
		HandlerUsuarios husers = HandlerUsuarios.getInstancia();
		Usuario usuario = husers.getUsuario(nickname);
		DtArtista dta = usuario.getDtArtista();
		return dta;
	}
	
	public Funcion getFuncion() {
		return funcion;
	}
	
	public List<String> listarPaquetesDeEspectaculo(String espec) {
		HandlerPaquetes hpaq = HandlerPaquetes.getInstance();
		return hpaq.getPaquetesDeEspectaculo(espec);
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public DtUsuario mostrarDatosContra(String nickname) {
		HandlerUsuarios husers = HandlerUsuarios.getInstancia();
		Usuario usuario = husers.getUsuario(nickname);
		DtUsuario dtu = usuario.getDtContra();
		return dtu;
	}

}
