package logica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import datatypes.DtPaquete;

public class HandlerPaquetes {
	private HashMap<String,Paquete> colPaquete;
	
	private static HandlerPaquetes instancia = null;

//    private HandlerPaquetes() {
//    	colPaquete = new HashMap<String,Paquete>();
//    };
//	
//    public static HandlerPaquetes getInstance() {
//        if (instancia == null) {
//            instancia = new HandlerPaquetes();
//        }
//        return instancia;
//    }
//	
//	public void agregarPaquete(Paquete p) {
//		colPaquete.put(p.getNombre(), p);
//	}
//	public DtPaquete crearPaquete(String nombre, String descrip, LocalDate fechaini, LocalDate fechafin, int desc, LocalDate fechaalta) {
//		//TODO
//		return null;
//	}
//	public ArrayList<DtPaquete> getPaquetesDt(){
//		//TODO
//		return null;
//	}
//	public Paquete getPaquete(String nomPaquete) {
//		return colPaquete.get(nomPaquete);
//	}
//	
//	public ArrayList<String> getNombresPaquetesEspectaculo(String nomEspectulo) {
//		ArrayList<String> list = new ArrayList<String>();
//		if (colPaquete != null) {
//		this.colPaquete.forEach((s, p) -> {
//			if (p.getEspectaculos().containsKey(nomEspectulo)) {
//				list.add(s);
//			}
//		});
//		}
//			return list;
//	}
//	
//	public ArrayList<String> getNombresPaquete() {
//		ArrayList<String> list = new ArrayList<String>(colPaquete.keySet());;
//		return list;
//	}
	
}
	