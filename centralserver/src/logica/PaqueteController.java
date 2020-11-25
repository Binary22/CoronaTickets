package logica;

import java.time.LocalDate;
import java.util.ArrayList;

import excepciones.NoExistePaqueteException;
import excepciones.PaqueteConMismoNombreException;

public class PaqueteController implements IPaquete {
	private Paquete paq;
	private Espectaculo espect;

	@Override
	public void crearPaquete(String nombre, String descrip, LocalDate fechaini, LocalDate fechafin, int desc, LocalDate fechaalta) throws PaqueteConMismoNombreException {
		HandlerPaquetes hpaq= HandlerPaquetes.getInstance();
		if (!hpaq.getNombresPaquete().contains(nombre))
			this.paq = hpaq.crearPaquete(nombre, descrip, fechaini, fechafin, desc, fechaalta);
		else
			throw new PaqueteConMismoNombreException("El paquete de nombre: " + nombre + " ya esta en uso");
	}
   
	@Override
	public void confirmarCrearPaquete() {
		HandlerPaquetes hpaq= HandlerPaquetes.getInstance();
		hpaq.agregarPaquete(paq);
	}

	@Override
	public ArrayList<String> listarPaquetes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void seleccionarPaquete(String nombre) throws NoExistePaqueteException {
		HandlerPaquetes hpaq = HandlerPaquetes.getInstance();
		this.paq = hpaq.getPaquete(nombre);

	}

	@Override
	public void elegirEspectaculo(String nomEspectaculo) {
		HandlerEspectaculos hEspectaculos = HandlerEspectaculos.getInstance();
		this.espect = hEspectaculos.getEspectaculo(nomEspectaculo);
	}

	@Override
	public void confirmarAgregarEspectAPaquete() {
		paq.addEspectaculo(espect);
	}
	
	@Override
	public void crearPaqueteWeb(String nombre, String descrip, LocalDate fechaini, LocalDate fechafin, int desc, LocalDate fechaalta, String imagen) throws PaqueteConMismoNombreException {
		HandlerPaquetes hpaq= HandlerPaquetes.getInstance();
		if (!hpaq.getNombresPaquete().contains(nombre))
			if(imagen != "" && imagen != null)	
				this.paq = hpaq.crearPaqueteWeb(nombre, descrip, fechaini, fechafin, desc, fechaalta, imagen);
			else
				this.paq = hpaq.crearPaqueteWeb(nombre, descrip, fechaini, fechafin, desc, fechaalta, "resources/media/espectaculos/maracas.jpg");
		else
			throw new PaqueteConMismoNombreException("El paquete de nombre: " + nombre + " ya esta en uso");
	}

	public Paquete getPaquete() {
		return paq;
	}


}
