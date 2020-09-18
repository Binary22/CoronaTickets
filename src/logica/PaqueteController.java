package logica;

import java.time.LocalDate;
import java.util.ArrayList;

import excepciones.NoExistePaqueteException;
import excepciones.PaqueteConMismoNombreException;

public class PaqueteController implements IPaquete {
	private Paquete p;
	private Espectaculo e;

	@Override
	public void crearPaquete(String nombre, String descrip, LocalDate fechaini, LocalDate fechafin, int desc, LocalDate fechaalta) throws PaqueteConMismoNombreException {
		HandlerPaquetes hq= HandlerPaquetes.getInstance();
		if(!hq.getNombresPaquete().contains(nombre))
			this.p = hq.crearPaquete(nombre,descrip,fechaini,fechafin,desc,fechaalta);
		else
			throw new PaqueteConMismoNombreException("El paquete de nombre: " + nombre + " ya esta en uso");
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
	public void seleccionarPaquete(String nombre) throws NoExistePaqueteException {
		HandlerPaquetes hp = HandlerPaquetes.getInstance();
		this.p = hp.getPaquete(nombre);

	}

	@Override
	public void elegirEspectaculo(String nomEspectaculo) {
		HandlerEspectaculos he = HandlerEspectaculos.getInstance();
		this.e = he.getEspectaculo(nomEspectaculo);
	}

	@Override
	public void confirmarAgregarEspectAPaquete() {
		p.addEspectaculo(e);
	}

}
