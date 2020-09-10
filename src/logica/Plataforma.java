package logica;

import java.util.ArrayList;
import java.util.Map;

public class Plataforma {
	private String nombre;
	private String descrip;
	private String url;
	private Map<String,Espectaculo> espectaculos;
	
	public Plataforma(String nombre, String descrip, String url, Map<String, Espectaculo> espectaculos) {
		super();
		this.nombre = nombre;
		this.descrip = descrip;
		this.url = url;
		this.espectaculos = espectaculos;
		//a plataforma nunca se le agregan espectaculos??
	}

	public ArrayList<Espectaculo> getEspectaculos(){
		return null;
	}
}

	

