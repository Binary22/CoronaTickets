package logica;

import java.util.ArrayList;

import datatypes.DtEspectaculo;
import datatypes.DtFuncion;
import datatypes.DtPaquete;
import datatypes.DtUsuario;

public class ConsultaController implements IConsulta {
	private Funcion funcion;
	private Espectaculo espectaculo;
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

	@Override
	public ArrayList<String> listarUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void elegirEspectaculo(String nomespect) {
		// TODO Auto-generated method stub

	}

	@Override
	public void elegirFuncion(String nomFuncion) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<String> listarPaquetes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void seleccionarPaquete(String nompaquete) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<String> listarPlataformas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> listarEspectaculosPlataforma(String nomPlataforma) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> listarFuncionesEspect(String nomEspectaculo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DtUsuario mostrarDatos(String nickname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DtEspectaculo> listarEspectaculosQueOrganiza() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DtFuncion> mostrarFuncionesQueSeRegistro() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DtPaquete mostrarPaquete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DtEspectaculo mostrarEspectaculo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DtFuncion mostrarFuncion() {
		// TODO Auto-generated method stub
		return null;
	}

}
