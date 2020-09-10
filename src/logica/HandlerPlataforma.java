package logica;

import java.util.ArrayList;
import java.util.Map;

public class HandlerPlataforma {
	private Map<String, Plataforma> colPlataforma;
	
	private ArrayList<String> getNombres() {
		ArrayList<String> list = new ArrayList<String>(colPlataforma.keySet());;
		return list;
	}
	private Plataforma getPlataforma(String nomPlataforma) {
		return colPlataforma.get(nomPlataforma);
	}
	private void agregarPlataforma(Plataforma p) {
		this.colPlataforma.add(p.getNombre(), p);
	}
}
