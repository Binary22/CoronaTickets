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
	
	
	
}

	

