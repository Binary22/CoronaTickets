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

public interface IConsulta {
	public List<String> listarUsuarios();
	public DtUsuario mostrarDatos(String nickname);
	public List<DtEspectaculo> listarEspectaculosQueOrganiza();
	public List<String> listarFuncionesQueSeRegistro(String nickname);
	public void elegirEspectaculo(String nomespect);
	//public void elegirFuncion(String nomFuncion);
	public List<String> listarPaquetes() throws NoHayPaquetesException;
	public void seleccionarPaquete(String nompaquete) throws NoExistePaqueteException;
	public DtPaquete mostrarPaquete();
	public List<String> listarPlataformas();
	public List<String> listarEspectaculosPlataforma(String nomPlataforma);
	public DtEspectaculo mostrarEspectaculo();
	public List<String> listarFuncionesEspect(String nomEspectaculo);
	public DtFuncion mostrarFuncion();
	public boolean esArtista(String nickname);
	public DtArtista mostrarDatosArtista(String nickname);
	public void elegirFuncion(String espectaculo, String nomFuncion);
	public List<DtFuncion> listarFuncionesDtQueSeRegistro(String nickname);
	public List<String> listarPaquetesDeEspectaculo(String espec);
}
