package logica;

import java.time.LocalDateTime;
import java.util.ArrayList;

import datatypes.DtPaquete;

public class HandlerPaquetes {
	private ArrayList<String> colNomPaquete;
	private ArrayList<Paquete> colPaquete;
	
	private void agregarPaquete(Paquete p) {
		this.colPaquete.add(p);
		this.colNomPaquete.add(p.getNombre());
	}
	private DtPaquete crearPaquete(String nombre, String descrip, LocalDateTime fechaini, LocalDateTime fechafin, int desc, LocalDateTime fechaalta) {
		//TODO
		return null;
	}
	private ArrayList<DtPaquete> getPaquetesDt(){
		//TODO
		return null;
	}
	private Paquete getPaquete(String nomPaquete) {
		int i = colNomPaquete.indexOf(nomPaquete);
		return colPaquete.get(i);
	}
	private ArrayList<String> getNombresPaquete() {
		return null;
	}
	
}
