package logica;

import java.util.Map;

public class HandlerEspectaculos {
	private Map<String,Espectaculo> mapEspectaculos;
	public Espectaculo getEspectaculo(String nomEspectaculo) {
		return mapEspectaculos.get(nomEspectaculo);
	}
	public Map<String,Espectaculo> getEspectaculosPlataforma(String nomPlata) {
		return mapEspectaculos;
	}
}

