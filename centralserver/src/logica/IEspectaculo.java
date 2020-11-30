package logica;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import datatypes.DtEspectaculo;
import datatypes.DtFuncion;
import datatypes.DtRegistro;
import excepciones.NombreCategoriaExistente;
import excepciones.NombreEspectaculoExisteException;
import excepciones.NombreFuncionexisteException;
import excepciones.existeRegistroEspecException;
import excepciones.fechaPosterior;
import excepciones.funcionAlcanzoLimiteException;
import datatypes.DtUsuario;
import excepciones.noSeleccionoTres;
import excepciones.usuarioNoExiste;

public interface IEspectaculo {
	public void elegirEspectaculo(String nomEspectaculo);
	public void altaFuncion(String nombre, LocalDate fecha, LocalTime horaInicio, List<String> invitados, LocalDate fechaAlta) throws NombreFuncionexisteException;
	public void confirmarAltaFuncion();
	public List<String> listarPlataformas();
	public List<DtEspectaculo> mostrarEspectaculosPlataforma(String nomplat);
	public List<DtFuncion> mostrarFuncionesEspectaculo(String nomespec);
	public List<String> mostrarEspectadores();
	//public void ingresarDatosRegistro(String nickname, String nomfuncion);
	public void ingresarNombreFuncion(String nomfuncion);
	public void ingresarNombreEspectador(String nickname);
	public List<DtRegistro> obtenerRegistrosPrevios();
	public void canjearRegistros(int[] regsId) throws noSeleccionoTres;
	public boolean existeRegistroEspecAFun();
	public boolean funcionAlcanzoLimiteReg(String nomespect);
	public void elegirNuevaFuncion(String nomfuncion);
	public void elegirNuevoEspectador(String nickname);
	public void confirmarRegistro(String nomespect, LocalDate fecha);
	public void esFechaInvalida(String nomespect, LocalDate fecha) throws fechaPosterior;
	public List<String> listarArtistas();
	public void altaEspectaculo(String nomPlataforma, String nickArtista, String nombre, String descripcion, LocalTime duracion, int minEspec, int maxEspec, String url, float costo, LocalDate fechaAlta) throws NombreEspectaculoExisteException;
	public void confirmarAltaEspectaculo();
	public List<String> listarEspectaculosPlataforma(String nomPlataforma);
	public List<String> listarFuncionesEspectaculo(String nomespec);
	public void elegirFuncion(String selectedItem);
	public void setRegistroFueCanjeado(boolean canj);
		
	public List<String> listarCategoriasEspectaculo(String nomEspec);

	
	public DtUsuario[] listarUsuarios() throws usuarioNoExiste;
	public DtFuncion mostarFuncion(String nomFuncion);
	
	public List<String> listarCategorias();
	public void confirmarCategoria(String nombre)throws NombreCategoriaExistente;
	
	public void altaEspectaculoWeb(String nomPlataforma, String nickArtista, String nombre, String descripcion,
			LocalTime duracion, int minEspec, int maxEspec, String url, float costo, LocalDate fechaAlta, List<String> cat, String imagen, String video, String descPremio, int cantPremios) throws NombreEspectaculoExisteException;
	
	
	public List<String> listarEspectaculosIngresados();
	public void aceptarRechazar(String nombreEspect, boolean aceptado);
	
	public List<Registro> obtenerRegistrosPreviosWeb(String nickname);
	
	public void canjePorVale();
	public void ingresarNombrePaquete(String nomPaquete);
	
	public void existeRegistroEspecAFunWeb() throws existeRegistroEspecException;
	public void funcionAlcanzoLimiteRegWeb(String nomespect) throws funcionAlcanzoLimiteException;
}
