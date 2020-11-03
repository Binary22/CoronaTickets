package logica;

import java.util.ArrayList;
import java.util.HashMap;

public class HandlerPlataforma {
	private HashMap<String, Plataforma> colPlataforma;
	
	private static HandlerPlataforma instancia = null;

    private HandlerPlataforma() {
    	colPlataforma = new HashMap<String, Plataforma>();
    	/*Plataforma p1 = new Plataforma("Twitter", "", "");
    	Plataforma p2 = new Plataforma("Facebook", "", "");
    	Plataforma p3 = new Plataforma("Twitch", "", "");
    	Plataforma p4 = new Plataforma("YouTube", "", "");
    	colPlataforma.put(p1.getNombre(), p1);
    	colPlataforma.put(p2.getNombre(), p2);
    	colPlataforma.put(p3.getNombre(), p3);
    	colPlataforma.put(p4.getNombre(), p4);*/
    };
	
    public static HandlerPlataforma getInstance() {
        if (instancia == null) {
            instancia = new HandlerPlataforma();
        }
        return instancia;
    }
	
	public ArrayList<String> getNombres() {
		ArrayList<String> list = new ArrayList<String>(colPlataforma.keySet());
		return list;
	}
	public  Plataforma getPlataforma(String nomPlataforma) {
		return colPlataforma.get(nomPlataforma);
	}
	public void agregarPlataforma(Plataforma p) {
		this.colPlataforma.put(p.getNombre(), p);
	}

	public HashMap<String, Plataforma> getColPlataforma() {
		return colPlataforma;
	}

	public void setColPlataforma(HashMap<String, Plataforma> colPlataforma) {
		this.colPlataforma = colPlataforma;
	}
	
	
}
