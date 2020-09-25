package logica;

import java.util.HashMap;

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
}

