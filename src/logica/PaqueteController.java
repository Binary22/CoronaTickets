package logica;

import java.time.LocalDate;
import java.util.ArrayList;

import excepciones.PaqueteConMismoNombreException;

public class PaqueteController implements IPaquete {
	private Paquete p;

	@Override
	public void crearPaquete(String nombre, String descrip, LocalDate fechaini, LocalDate fechafin, int desc, LocalDate fechaalta) throws PaqueteConMismoNombreException {
		HandlerPaquetes hq= HandlerPaquetes.getInstance();
		if(!hq.getNombresPaquete().contains(nombre))
			this.p = hq.crearPaquete(nombre,descrip,fechaini,fechafin,desc,fechaalta);
		else
			throw new PaqueteConMismoNombreException("El paquete de nombre:" + nombre + "ya esta en uso");
	}

	@Override
	public void confirmarCrearPaquete() {
		HandlerPaquetes hq= HandlerPaquetes.getInstance();
		hq.agregarPaquete(p);
	}

	@Override
	public ArrayList<String> listarPaquetes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void seleccionarPaquete(String nombre) {
		// TODO Auto-generated method stub

	}

	@Override
	public void elegirEspectaculo(String nomEspectaculo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void confirmarAgregarEspectAPaquete() {
		// TODO Auto-generated method stub

	}

}
