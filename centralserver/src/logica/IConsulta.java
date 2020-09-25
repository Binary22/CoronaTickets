package logica;

import java.util.ArrayList;

import datatypes.DtArtista;
import datatypes.DtEspectaculo;
import datatypes.DtFuncion;
import datatypes.DtPaquete;
import datatypes.DtUsuario;
import excepciones.NoExistePaqueteException;
import excepciones.NoHayPaquetesException;

public interface IConsulta {
	public ArrayList<String> listarUsuarios();
	public DtUsuario mostrarDatos(String nickname);
	public ArrayList<DtEspectaculo> listarEspectaculosQueOrganiza();
	public ArrayList<String> listarFuncionesQueSeRegistro(String nickname);
	public void elegirEspectaculo(String nomespect);
	//public void elegirFuncion(String nomFuncion);
	public ArrayList<String> listarPaquetes() throws NoHayPaquetesException;
	public void seleccionarPaquete(String nompaquete) throws NoExistePaqueteException;
	public DtPaquete mostrarPaquete();
	public ArrayList<String> listarPlataformas();
	public ArrayList<String> listarEspectaculosPlataforma(String nomPlataforma);
	public DtEspectaculo mostrarEspectaculo();
	public ArrayList<String> listarFuncionesEspect(String nomEspectaculo);
	public DtFuncion mostrarFuncion();
	public boolean esArtista(String nickname);
	public DtArtista mostrarDatosArtista(String nickname);
	public void elegirFuncion(String espectaculo, String nomFuncion);
	public ArrayList<DtFuncion> listarFuncionesDtQueSeRegistro(String nickname);
	public ArrayList<String> listarPaquetesDeEspectaculo(String espec);
}
