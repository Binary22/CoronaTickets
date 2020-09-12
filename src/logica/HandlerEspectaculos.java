package logica;

import java.util.HashMap;

public class HandlerEspectaculos {
	
	private static HandlerEspectaculos instancia = null;
	private HashMap<String,Espectaculo> mapEspectaculos;

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
	public HashMap<String,Espectaculo> getEspectaculosPlataforma(String nomPlata) {
		return mapEspectaculos;
	}
}

