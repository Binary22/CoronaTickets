package logica;

import java.time.LocalDate;
import java.util.ArrayList;

import excepciones.PaqueteConMismoNombreException;

public interface IPaquete {
	public void crearPaquete(String nombre, String descrip, LocalDate fechaini, LocalDate fechafin, int desc, LocalDate fechaalta) throws PaqueteConMismoNombreException;
	public void confirmarCrearPaquete();
	public ArrayList<String> listarPaquetes();
	public void seleccionarPaquete(String nombre);
	public void elegirEspectaculo(String nomEspectaculo);
	public void confirmarAgregarEspectAPaquete();
}