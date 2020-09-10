package logica;

import java.time.LocalDateTime;
import java.util.ArrayList;

public interface IPaquete {
	public void crearPaquete(String nombre, String descrip, LocalDateTime fechaini, LocalDateTime fechafin, int desc, LocalDateTime fechaalta);
	public void confirmarCrearPaquete();
	public ArrayList<String> listarPaquetes();
	public void seleccionarPaquete(String nombre);
	public void elegirEspectaculo(String nomEspectaculo);
	public void confirmarAgregarEspectAPaquete();
}