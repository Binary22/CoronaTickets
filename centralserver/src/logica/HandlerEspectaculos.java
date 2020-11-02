package logica;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HandlerEspectaculos {
	private HashMap<String,Espectaculo> mapEspectaculos;
	private static HandlerEspectaculos instancia = null;

    private HandlerEspectaculos() {
    	mapEspectaculos = new HashMap<String, Espectaculo>();
    	/*HandlerPlataforma hp = HandlerPlataforma.getInstance();
    	Espectaculo e1 = new Espectaculo("twitter1", LocalTime.now(), "la historia de harry", 2,8, "xd", LocalDate.now(), 23 );
    	e1.setAceptado(true);
    	e1.setYaFueValuado(true);
    	e1.setPlataforma(hp.getPlataforma("Twitter"));
    	Espectaculo e2 = new Espectaculo("twitter2", LocalTime.now(), "la historia de una fabrica", 2,8, "xd", LocalDate.now(), 23 );
    	e2.setAceptado(true);
    	e2.setYaFueValuado(true);
    	e2.setPlataforma(hp.getPlataforma("Twitter"));
    	Plataforma p1 = hp.getPlataforma("Twitter");
    	p1.addEspectaculo(e1);
    	p1.addEspectaculo(e2);
    	///////////////////////////
    	Espectaculo e3 = new Espectaculo("Facebook1", LocalTime.now(), "la historia de una fabrica", 2,8, "xd", LocalDate.now(), 23 );
    	e3.setAceptado(true);
    	e3.setYaFueValuado(true);
    	e3.setPlataforma(hp.getPlataforma("Facebook"));
    	Espectaculo e4 = new Espectaculo("Facebook2", LocalTime.now(), "la historia de una fabrica", 2,8, "xd", LocalDate.now(), 23 );
    	e4.setAceptado(true);
    	e4.setYaFueValuado(true);
    	e4.setPlataforma(hp.getPlataforma("Facebook"));
    	Espectaculo e5 = new Espectaculo("Facebook3", LocalTime.now(), "la historia de una fabrica", 2,8, "xd", LocalDate.now(), 23 );
    	e5.setAceptado(true);
    	e5.setYaFueValuado(true);
    	e5.setPlataforma(hp.getPlataforma("Facebook"));
    	Plataforma p2 = hp.getPlataforma("Facebook");
    	p2.addEspectaculo(e3);
    	p2.addEspectaculo(e4);
    	p2.addEspectaculo(e5);
    	///////////////////////////////////////
    	Espectaculo e9 = new Espectaculo("twitch1", LocalTime.now(), "la historia de una fabrica", 2,8, "xd", LocalDate.now(), 23 );
    	e9.setAceptado(true);
    	e9.setYaFueValuado(true);
    	e9.setPlataforma(hp.getPlataforma("Twitch"));
    	Espectaculo e6 = new Espectaculo("twitch2 ", LocalTime.now(), "la historia de una fabrica", 2,8, "xd", LocalDate.now(), 23 );
    	e6.setAceptado(true);
    	e6.setYaFueValuado(true);
    	e6.setPlataforma(hp.getPlataforma("Twitch"));
    	Plataforma p3 = hp.getPlataforma("Twitch");
    	p3.addEspectaculo(e9);
    	p3.addEspectaculo(e6);
    	///////////////////////////////////////
    	Espectaculo e7 = new Espectaculo("youtube1", LocalTime.now(), "la historia de una fabrica", 2,8, "xd", LocalDate.now(), 23 );
    	e7.setAceptado(true);
    	e7.setYaFueValuado(true);
    	e7.setPlataforma(hp.getPlataforma("YouTube"));
    	Espectaculo e8 = new Espectaculo("youtube2", LocalTime.now(), "la historia de una fabrica", 2,8, "xd", LocalDate.now(), 23 );
    	e8.setAceptado(true);
    	e8.setYaFueValuado(true);
    	e8.setPlataforma(hp.getPlataforma("YouTube"));
    	Plataforma p4 = hp.getPlataforma("YouTube");
    	p4.addEspectaculo(e7);
    	p4.addEspectaculo(e8);
    	
    	
    	
    	
    	mapEspectaculos.put(e1.getNombre(), e1);
    	mapEspectaculos.put(e2.getNombre(), e2);
    	mapEspectaculos.put(e3.getNombre(), e3);
    	mapEspectaculos.put(e4.getNombre(), e4);
    	mapEspectaculos.put(e5.getNombre(), e5);
    	mapEspectaculos.put(e6.getNombre(), e6);
    	mapEspectaculos.put(e7.getNombre(), e7);
    	mapEspectaculos.put(e8.getNombre(), e8);*/
    	//mapEspectaculos.put(e9.getNombre(), e9);
    	
    };
	
    public static HandlerEspectaculos getInstance() {
        if (instancia == null) {
            instancia = new HandlerEspectaculos();
        }
        return instancia;
    }
    
	
	public Espectaculo getEspectaculo(String nomEspectaculo) {
		return mapEspectaculos.get(nomEspectaculo);
	}
	
	public void addEspectaculo(Espectaculo espectaculo) {
		mapEspectaculos.put(espectaculo.getNombre(), espectaculo);
	}
	
	public HashMap<String,Espectaculo> getEspectaculosPlataforma(String nomPlata) {
		return mapEspectaculos;
	}
	
	public boolean existeNombreFuncion(String f) {
		for (String key : mapEspectaculos.keySet()) {
			HashMap<String,Funcion> funciones = mapEspectaculos.get(key).getAllFunciones();
			if(funciones.containsKey(f)) {
				return true;
			}	
		}
		return false;
		
	}
	
	public HashMap<String, Espectaculo> getEspectaculos(){
		return this.mapEspectaculos;
	}
	
	public Map<String,Espectaculo> listarEspectaculosAceptados(){
		Map<String, Espectaculo> aceptados = new HashMap<String, Espectaculo>();
		for (String key : this.mapEspectaculos.keySet()) {
			if(this.mapEspectaculos.get(key).isAceptado()) {
				aceptados.put(key, this.mapEspectaculos.get(key));
			}
		}
		return aceptados;
	}
}

