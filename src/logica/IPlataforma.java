package logica;

import java.util.ArrayList;

public interface IPlataforma {
	public ArrayList<String> listarPlataformas();
	public ArrayList<String> listarEspectaculosPlataforma(String nomPlataforma);
	public void altaPlataforma(String nombre, String descrip, String url);
	public void confirmarAltaPlataforma();
	public void agregarEspectaculoPlataforma(Plataforma p, Espectaculo e);
	}
