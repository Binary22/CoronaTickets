package logica;

import java.util.ArrayList;

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

}
