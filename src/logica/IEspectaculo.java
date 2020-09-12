package logica;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import datatypes.DtEspectaculo;
import datatypes.DtFuncion;
import datatypes.DtRegistro;

public interface IEspectaculo {
	public void elegirEspectaculo(String nomEspectaculo);
	public void altaFuncion(String nombre, LocalDate fecha, LocalTime horaInicio, ArrayList<String> invitados, LocalDate fechaAlta);
	public void ConfirmarAltaFuncion();
	public ArrayList<String> listarPlataformas();
	public ArrayList<DtEspectaculo> mostrarEspectaculosPlataforma(String nomplat);
	public ArrayList<DtFuncion> mostrarFuncionesEspectaculo(String nomespec);
	public ArrayList<String> mostrarEspectadores();
	public void ingresarDatosRegistro(String nickname, String nomfuncion, LocalDate fecha);
	public ArrayList<DtRegistro> obtenerRegistrosPrevios();
	public void canjearRegistros(int id1, int id2, int id3);
	public boolean existeRegistroEspecAFun();
	public boolean funcionAlcanzoLimiteReg();
	public void elegirNuevaFuncion(String nomfuncion);
	public void elegirNuevoEspectador(String nickname);
	public void confirmarRegistro();
	public ArrayList<String> listarArtistas();
	public void altaEspectaculo(String nomPlataforma, String nickArtista, String nombre, String descripcion, LocalTime duracion, int minEspec, int maxEspec, String url, float costo, LocalDate fechaAlta);
	public void confirmarAltaEspectaculo();
	public ArrayList<String> listarEspectaculosPlataforma(String nomPlataforma);
}
