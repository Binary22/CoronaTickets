package logica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import datatypes.DtPaquete;

public class HandlerPaquetes {
	private HashMap<String,Paquete> colPaquete;
	
	private static HandlerPaquetes instancia = null;

    private HandlerPaquetes() {
    };
	
    public static HandlerPaquetes getInstance() {
        if (instancia == null) {
            instancia = new HandlerPaquetes();
        }
        return instancia;
    }
	
	private void agregarPaquete(Paquete p) {
		colPaquete.put(p.getNombre(), p);
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
	