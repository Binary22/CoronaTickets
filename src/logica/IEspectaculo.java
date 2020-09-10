package logica;

import java.time.LocalDateTime;
import java.util.ArrayList;

public interface IEspectaculo {
	public void elegirEspectaculo(String nomEspectaculo);
	// creo que hay un parametro fecha de más
	public void altaFuncion(String nombre, LocalDateTime fecha, LocalDateTime fechaInicio, ArrayList<String> invitados, LocalDateTime fechaAlta);
	public void ConfirmarAltaFuncion();
	public ArrayList<String> listarPlataformas();
	public ArrayList<DtEspectaculo> mostrarEspectaculosPlataforma(String nomplat);
	public ArrayList<DtFuncion> mostrarFuncionesEspectaculo(String nomespec);
	public ArrayList<String> mostrarEspectadores();
	public void ingresarDatosRegistro(String nickname, String nomfuncion, LocalDateTime fecha);
	public ArrayList<DtRegistro> obtenerRegistrosPrevios();
	public void canjearRegistros(int id1, int id2, int id3);
	public boolean existeRegistroEspecAFun();
	public boolean funcionAlcanzoLimiteReg();
	public void elegirNuevaFuncion(String nomfuncion);
	public void elegirNuevoEspectador(String nickname);
	public void confirmarRegistro();
	public ArrayList<String> listarArtistas();
	public void altaEspectaculo(String nomPlataforma, String nickArtista, String nombre, String descripcion, int duracion, int maxEspec, String url, float costo, LocalDateTime fechaAlta);
	public void confirmarAltaEspectaculo();
}
