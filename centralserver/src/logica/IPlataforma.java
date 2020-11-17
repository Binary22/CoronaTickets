package logica;

import java.util.ArrayList;
import java.util.List;



public interface IPlataforma {
	public List<String> listarPlataformas();
	public List<String> listarEspectaculosPlataforma(String nomPlataforma);
	public void altaPlataforma(String nombre, String descrip, String url);
	public void confirmarAltaPlataforma();
	public void agregarEspectaculoPlataforma(Plataforma paq, Espectaculo espect);
	}
