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
	
	public ArrayList<String> getNombres() {
		ArrayList<String> list = new ArrayList<String>(colPlataforma.keySet());;
		return list;
	}
	public  Plataforma getPlataforma(String nomPlataforma) {
		return colPlataforma.get(nomPlataforma);
	}
	public void agregarPlataforma(Plataforma p) {
		this.colPlataforma.put(p.getNombre(), p);
	}

	public Map<String, Plataforma> getColPlataforma() {
		return colPlataforma;
	}

	public void setColPlataforma(Map<String, Plataforma> colPlataforma) {
		this.colPlataforma = colPlataforma;
	}
	
	
}
