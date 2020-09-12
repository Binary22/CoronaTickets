package logica;

import java.util.HashMap;

public class HandlerEspectaculos {
	private HashMap<String,Espectaculo> mapEspectaculos;
	private static HandlerEspectaculos instancia = null;

    private HandlerEspectaculos() {
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
}

