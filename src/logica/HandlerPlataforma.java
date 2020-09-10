package logica;

import java.util.ArrayList;
import java.util.Map;

public class HandlerPlataforma {
	private Map<String, Plataforma> colPlataforma;
	
	private static HandlerPlataforma instancia = null;

    private HandlerPlataforma() {
    };
	
    public static HandlerPlataforma getInstance() {
        if (instancia == null) {
            instancia = new HandlerPlataforma();
        }
        return instancia;
    }
	
	private ArrayList<String> getNombres() {
		ArrayList<String> list = new ArrayList<String>(colPlataforma.keySet());;
		return list;
	}
	private Plataforma getPlataforma(String nomPlataforma) {
		return colPlataforma.get(nomPlataforma);
	}
	private void agregarPlataforma(Plataforma p) {
		this.colPlataforma.put(p.getNombre(), p);
	}
}
