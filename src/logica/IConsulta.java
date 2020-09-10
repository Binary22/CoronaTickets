package logica;

import java.util.ArrayList;

import datatypes.DtEspectaculo;
import datatypes.DtFuncion;
import datatypes.DtUsuario;

public interface IConsulta {
	public ArrayList<String> listarUsuarios();
	public DtUsuario mostrarDatos(String nickname);
	public ArrayList<DtEspectaculo> listarEspectaculosQueOrganiza();
	public ArrayList<DtFuncion> mostrarFuncionesQueSeRegistro();
	public void elegirEspectaculo(String nomespect);
	public void elegirFuncion(String nomFuncion);
	public ArrayList<String> listarPaquetes();
	public void seleccionarPaquete(String nompaquete);
	public DtPaquete mostrarPaquete();
	public ArrayList<String> listarPlataformas();
	public ArrayList<String> listarEspectaculosPlataforma(String nomPlataforma);
	public DtEspectaculo mostrarEspectaculo();
	public ArrayList<String> listarFuncionesEspect(String nomEspectaculo);
	public DtFuncion mostrarFuncion();
}
