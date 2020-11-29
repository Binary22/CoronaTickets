package datatypesweb;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import logica.Artista;
import logica.Espectaculo;
import logica.Funcion;
import logica.Plataforma;

public class dataEspectaculo {
	private String nombre;
	private String descripcion;
	private String url;
	private int minEspectadores;
	private int maxEspectadores;
	private float costo;
	private String duracion;
	private String minutos;
	private String fechaReg;
	private String plataforma;
	private String artista;
	private Map<String, dataFuncion> setFunciones;
	private boolean yaFueValuado;
	private boolean aceptado;
	private boolean finalizado;
	private String imagen;
	private String video;
	private List<String> categorias;
	private String descPremio;
	private int cantPremios;
	private String videoUrl;
	
	public String getDescPremio() {
		return descPremio;
	}


	public void setDescPremio(String descPremio) {
		this.descPremio = descPremio;
	}


	public int getCantPremios() {
		return cantPremios;
	}


	public void setCantPremios(int cantPremios) {
		this.cantPremios = cantPremios;
	}


	public String getVideoUrl() {
		return videoUrl;
	}


	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}


	public dataEspectaculo(Espectaculo espect) {
		this.nombre = espect.getNombre();
		this.descripcion = espect.getDescripcion();
		this.url = espect.getUrl();
		this.minEspectadores = espect.getMinEspectadores();
		this.maxEspectadores = espect.getMaxEspectadores();
		this.costo = espect.getCosto();
		this.duracion = espect.getDuracion().toString();
		this.fechaReg = espect.getFechaReg().toString();
		this.plataforma = espect.getPlataforma().getNombre();
		this.artista = espect.getArtista().getNickname();
		
		this.setFunciones = new HashMap<String, dataFuncion>();
		Map<String,Funcion> funs = espect.getAllFunciones();
		for(String key : funs.keySet()) {
			this.setFunciones.put(key, new dataFuncion(funs.get(key)));
		}
		this.yaFueValuado = espect.isYaFueValuado();
		this.aceptado = espect.isAceptado();
		this.finalizado = espect.isFinalizado();
		this.imagen = espect.getImagen();
		this.categorias = new ArrayList<String>(espect.listarCategorias());
		this.setVideo(espect.getVideo());
		
		
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getMinEspectadores() {
		return minEspectadores;
	}

	public void setMinEspectadores(int minEspectadores) {
		this.minEspectadores = minEspectadores;
	}

	public int getMaxEspectadores() {
		return maxEspectadores;
	}

	public void setMaxEspectadores(int maxEspectadores) {
		this.maxEspectadores = maxEspectadores;
	}

	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public String getFechaReg() {
		return fechaReg;
	}

	public void setFechaReg(String fechaReg) {
		this.fechaReg = fechaReg;
	}
	
	public void setFechaReg(LocalDate fechaReg) {
		this.fechaReg = fechaReg.toString();
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public Map<String, dataFuncion> getSetFunciones() {
		return setFunciones;
	}

	public void setSetFunciones(Map<String, dataFuncion> setFunciones) {
		this.setFunciones = setFunciones;
	}

	public boolean isYaFueValuado() {
		return yaFueValuado;
	}

	public void setYaFueValuado(boolean yaFueValuado) {
		this.yaFueValuado = yaFueValuado;
	}

	public boolean isAceptado() {
		return aceptado;
	}

	public void setAceptado(boolean aceptado) {
		this.aceptado = aceptado;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public List<String> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<String> categorias) {
		this.categorias = categorias;
	}

	
	
	public dataEspectaculo() {
		
	}


	public String getMinutos() {
		return minutos;
	}


	public void setMinutos(String minutos) {
		this.minutos = minutos;
	}


	public boolean isFinalizado() {
		return finalizado;
	}


	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}
}
