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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescrip() {
		return descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setEspectaculos(Map<String, Espectaculo> espectaculos) {
		this.espectaculos = espectaculos;
	}
	
	public void addEspectaculo(Espectaculo espectaculo){
		espectaculos.put(espectaculo.getNombre(), espectaculo);
	}
}

	

