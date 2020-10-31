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
    	Espectaculo e1 = new Espectaculo("harry potter", LocalTime.now(), "la historia de harry", 2,8, "xd", LocalDate.now(), 23 );
    	e1.setAceptado(true);
    	e1.setYaFueValuado(true);
    	Espectaculo e2 = new Espectaculo("la fabrica de chocolala", LocalTime.now(), "la historia de una fabrica", 2,8, "xd", LocalDate.now(), 23 );
    	e2.setAceptado(true);
    	e2.setYaFueValuado(true);
    	mapEspectaculos.put(e1.getNombre(), e1);
    	mapEspectaculos.put(e2.getNombre(), e2);
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

