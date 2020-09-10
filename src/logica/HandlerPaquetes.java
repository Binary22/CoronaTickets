package logica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import datatypes.DtPaquete;

public class HandlerPaquetes {
	private Map<String,Paquete> colPaquete;
	
	private void agregarPaquete(Paquete p) {
		this.colPaquete.add(p.getNombre(), p);
	}
	private DtPaquete crearPaquete(String nombre, String descrip, LocalDate fechaini, LocalDate fechafin, int desc, LocalDate fechaalta) {
		//TODO
		return null;
	}
	private ArrayList<DtPaquete> getPaquetesDt(){
		//TODO
		return null;
	}
	private Paquete getPaquete(String nomPaquete) {
		return colPaquete.get(nomPaquete);
	}
	private ArrayList<String> getNombresPaquete() {
		ArrayList<String> list = new ArrayList<String>(colPaquete.keySet());;
		return list;
	}
	
}
	