package logica;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import datatypes.DtEspectaculo;
import datatypes.DtFuncion;
import datatypes.DtRegistro;
import excepciones.NombreCategoriaExistente;
import excepciones.NombreEspectaculoExisteException;
import excepciones.NombreFuncionexisteException;
import excepciones.fechaPosterior;
import datatypes.DtUsuario;
import excepciones.noSeleccionoTres;
import excepciones.usuarioNoExiste;

public interface IEspectaculo {
	public void elegirEspectaculo(String nomEspectaculo);
	public void altaFuncion(String nombre, LocalDate fecha, LocalTime horaInicio, ArrayList<String> invitados, LocalDate fechaAlta) throws NombreFuncionexisteException;
	public void confirmarAltaFuncion();
	public ArrayList<String> listarPlataformas();
	public ArrayList<DtEspectaculo> mostrarEspectaculosPlataforma(String nomplat);
	public ArrayList<DtFuncion> mostrarFuncionesEspectaculo(String nomespec);
	public ArrayList<String> mostrarEspectadores();
	//public void ingresarDatosRegistro(String nickname, String nomfuncion);
	public void ingresarNombreFuncion(String nomfuncion);
	public void ingresarNombreEspectador(String nickname);
	public ArrayList<DtRegistro> obtenerRegistrosPrevios();
	public void canjearRegistros(int[] regsId) throws noSeleccionoTres;
	public boolean existeRegistroEspecAFun();
	public boolean funcionAlcanzoLimiteReg(String nomespect);
	public void elegirNuevaFuncion(String nomfuncion);
	public void elegirNuevoEspectador(String nickname);
	public void confirmarRegistro(String nomespect, LocalDate fecha);
	public void esFechaInvalida(String nomespect, LocalDate fecha) throws fechaPosterior;
	public ArrayList<String> listarArtistas();
	public void altaEspectaculo(String nomPlataforma, String nickArtista, String nombre, String descripcion, LocalTime duracion, int minEspec, int maxEspec, String url, float costo, LocalDate fechaAlta) throws NombreEspectaculoExisteException;
	public void confirmarAltaEspectaculo();
	public ArrayList<String> listarEspectaculosPlataforma(String nomPlataforma);
	public ArrayList<String> listarFuncionesEspectaculo(String nomespec);
	public void elegirFuncion(String selectedItem);
	public void setRegistroFueCanjeado(boolean canj);
		
	public ArrayList<String> listarCategoriasEspectaculo(String nomEspec);

	
	public DtUsuario[] listarUsuarios() throws usuarioNoExiste;
	public DtFuncion mostarFuncion(String nomFuncion);
	
	public ArrayList<String> listarCategorias();
	public void confirmarCategoria(String nombre)throws NombreCategoriaExistente;
	
	public void altaEspectaculoWeb(String nomPlataforma, String nickArtista, String nombre, String descripcion,
			LocalTime duracion, int minEspec, int maxEspec, String url, float costo, LocalDate fechaAlta, ArrayList<String> cat, String imagen) throws NombreEspectaculoExisteException;
	
	
	public ArrayList<String> listarEspectaculosIngresados();
	public void aceptarRechazar(String nombreEspect, boolean aceptado);
	
	public ArrayList<Registro> obtenerRegistrosPreviosWeb(String nickname);
}
