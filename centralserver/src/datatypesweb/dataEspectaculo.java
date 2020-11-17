package datatypesweb;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import logica.Artista;
import logica.Plataforma;

public class dataEspectaculo {
	private String nombre;
	private String descripcion;
	private String url;
	private int minEspectadores;
	private int maxEspectadores;
	private float costo;
	private LocalTime duracion;
	private LocalDate fechaReg;
	private Plataforma plataforma;
	private Artista artista;
	private Map<String, dataFuncion> setFunciones;
	private boolean yaFueValuado;
	private boolean aceptado;
	private String imagen;
	private List<String> categorias;
	
	
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

	public LocalTime getDuracion() {
		return duracion;
	}

	public void setDuracion(LocalTime duracion) {
		this.duracion = duracion;
	}

	public LocalDate getFechaReg() {
		return fechaReg;
	}

	public void setFechaReg(LocalDate fechaReg) {
		this.fechaReg = fechaReg;
	}

	public Plataforma getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(Plataforma plataforma) {
		this.plataforma = plataforma;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
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
}
