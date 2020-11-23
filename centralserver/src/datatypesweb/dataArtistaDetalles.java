package datatypesweb;

import java.util.ArrayList;
import java.util.List;

import logica.Artista;
import logica.Espectaculo;
import logica.Usuario;

public class dataArtistaDetalles extends dataUsuario {
	private String descripcion;
	private String biografia;
	private String website;
	
	private List<String> espectaculos;

	public dataArtistaDetalles() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public dataArtistaDetalles(Artista artista) {
		super(artista);
		descripcion = artista.getDescripcion();
		biografia = artista.getBiografia();
		website = artista.getWebsite();
		List<String> lista = new ArrayList<String>();
		for (Espectaculo e : artista.getEspectaculos()) {
			lista.add(e.getNombre());
		}
		espectaculos = lista;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public List<String> getEspectaculos() {
		return espectaculos;
	}

	public void setEspectaculos(List<String> espectaculos) {
		this.espectaculos = espectaculos;
	}

	
	
}
