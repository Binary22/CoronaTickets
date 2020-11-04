package logica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import excepciones.NoExistePaqueteException;

public class HandlerPaquetes {
	private HashMap<String, Paquete> colPaquete;
	
	private static HandlerPaquetes instancia = null;

	private HandlerPaquetes() {
    	colPaquete = new HashMap<String, Paquete>();
    };
	
    public static HandlerPaquetes getInstance() {
        if (instancia == null) {
            instancia = new HandlerPaquetes();
        }
        return instancia;
    }
    
	public Paquete crearPaquete(String nombre, String descrip, LocalDate fechaini, LocalDate fechafin, int desc, LocalDate fechaalta) {
		Paquete paqueteNuevo= new Paquete(nombre, fechaini, fechafin, desc, descrip, fechaalta);
		return paqueteNuevo;
	}
	
	public Paquete crearPaqueteWeb(String nombre, String descrip, LocalDate fechaini, LocalDate fechafin, int desc, LocalDate fechaalta, String imagen) {
		Paquete paqueteNuevo= new Paquete(nombre, fechaini, fechafin, desc, descrip, fechaalta, imagen);
		return paqueteNuevo;
	}
//	public ArrayList<DtPaquete> getPaquetesDt(){
//		//TODO
//		return null;
//	}
	public Paquete getPaquete(String nomPaquete) throws NoExistePaqueteException {
		if (!colPaquete.containsKey(nomPaquete)) throw new NoExistePaqueteException("No se encontro el paquete");
		return colPaquete.get(nomPaquete);
	}
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
	public ArrayList<String> getNombresPaquete() {
		ArrayList<String> list = new ArrayList<String>(colPaquete.keySet());;
		return list;
	}

	public void agregarPaquete(Paquete p) {
		colPaquete.put(p.getNombre(), p);
	}
	
	public ArrayList<String> getPaquetesDeEspectaculo(String espec) {
		ArrayList<String> ret = new ArrayList<String>();
		ArrayList<Paquete> listapaq = new ArrayList<Paquete>(colPaquete.values());
		for (int i = 0; i < colPaquete.size(); i++) {
			if (listapaq.get(i).getEspectaculos().containsKey(espec)) {
				ret.add(listapaq.get(i).getNombre());
			}
		}
		return ret;
	}
	
	public ArrayList<Paquete> getPaquetesDeEspectaculoWeb(String espec) {
		ArrayList<Paquete> paquetes = new ArrayList<Paquete>();
		
		for (String key : this.colPaquete.keySet()) {
			if (colPaquete.get(key).getEspectaculos().containsKey(espec)) {
				paquetes.add(colPaquete.get(key));
			}
		}
		return paquetes;
	}
	
	public List<Paquete> buscarPaquetes(String search) {
		List<Paquete> ret = new ArrayList<Paquete>();
		for (Entry<String, Paquete> entry : colPaquete.entrySet()) {    
			if (entry.getValue().getNombre().toLowerCase().contains(search.toLowerCase()) || entry.getValue().getDescripcion().toLowerCase().contains(search.toLowerCase())) {
				ret.add(entry.getValue());
			}
		}
		return ret;
	}
	
	
}
	