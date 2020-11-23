package datatypesweb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class ListaEspectaculo {
	private Map<String, dataEspectaculo> espectaculos;

	public Map<String, dataEspectaculo> getEspectaculos() {
		if (espectaculos == null) {
			this.espectaculos = new HashMap<String, dataEspectaculo>();
		}
		return espectaculos;
	}

	public void setEspectaculos(Map<String, dataEspectaculo> espectaculos) {
		this.espectaculos = espectaculos;
	}
}
