package logica;

import java.util.ArrayList;
import java.util.HashMap;

public class Plataforma {
	private String nombre;
	private String descrip;
	private String url;
	private HashMap<String,Espectaculo> espectaculos;
	
	public Plataforma(String nombre, String descrip, String url) {
		super();
		this.nombre = nombre;
		this.descrip = descrip;
		this.url = url;
	}

	public ArrayList<Espectaculo> getEspectaculos(){
		return null;
	}
	
	public void addEspectaculo(Espectaculo espectaculo){
		espectaculos.put(espectaculo.getNombre(), espectaculo);
	}
}

	

