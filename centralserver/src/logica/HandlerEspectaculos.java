package logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HandlerEspectaculos {
	private HashMap<String,Espectaculo> mapEspectaculos;
	private static HandlerEspectaculos instancia = null;

    private HandlerEspectaculos() {
    	mapEspectaculos = new HashMap<String, Espectaculo>();
    };
	
    public static HandlerEspectaculos getInstance() {
        if (instancia == null) {
            instancia = new HandlerEspectaculos();
        }
        return instancia;
    }
    
	
	public Espectaculo getEspectaculo(String nomEspectaculo) {
		return mapEspectaculos.get(nomEspectaculo);
	}
	
	public void addEspectaculo(Espectaculo espectaculo) {
		mapEspectaculos.put(espectaculo.getNombre(), espectaculo);
	}
	
	public HashMap<String,Espectaculo> getEspectaculosPlataforma(String nomPlata) {
		return mapEspectaculos;
	}
	
	public boolean existeNombreFuncion(String f) {
		for (String key : mapEspectaculos.keySet()) {
			HashMap<String,Funcion> funciones = mapEspectaculos.get(key).getAllFunciones();
			if(funciones.containsKey(f)) {
				return true;
			}	
		}
		return false;
		
	}
	
	public HashMap<String, Espectaculo> getEspectaculos(){
		return this.mapEspectaculos;
	}
	
	public List<Espectaculo> buscarEspectaculos(String search) {
		List<Espectaculo> ret = new ArrayList<Espectaculo>();
		for (Entry<String, Espectaculo> entry : mapEspectaculos.entrySet()) {   
			if (entry.getValue().getNombre().toLowerCase().contains(search.toLowerCase()) || entry.getValue().getDescripcion().toLowerCase().contains(search.toLowerCase())) {
				ret.add(entry.getValue());
			}
		}
		return ret;
	}
}

