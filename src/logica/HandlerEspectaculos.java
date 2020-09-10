package logica;

import java.util.HashMap;

public class HandlerEspectaculos {
	private HashMap<String,Espectaculo> mapEspectaculos;
	public Espectaculo getEspectaculo(String nomEspectaculo) {
		return mapEspectaculos.get(nomEspectaculo);
	}
	public HashMap<String,Espectaculo> getEspectaculosPlataforma(String nomPlata) {
		return mapEspectaculos;
	}
}

