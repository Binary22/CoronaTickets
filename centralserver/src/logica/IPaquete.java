package logica;

import java.time.LocalDate;
import java.util.ArrayList;

import excepciones.NoExistePaqueteException;
import excepciones.PaqueteConMismoNombreException;

public interface IPaquete {
	public void crearPaquete(String nombre, String descrip, LocalDate fechaini, LocalDate fechafin, int desc, LocalDate fechaalta) throws PaqueteConMismoNombreException;
	public void confirmarCrearPaquete();
	public ArrayList<String> listarPaquetes();
	public void seleccionarPaquete(String nombre) throws NoExistePaqueteException;
	public void elegirEspectaculo(String nomEspectaculo);
	public void confirmarAgregarEspectAPaquete();
	public void crearPaqueteWeb(String nombre, String descrip, LocalDate fechaini, LocalDate fechafin, int desc, LocalDate fechaalta, String imagen) throws PaqueteConMismoNombreException;
}