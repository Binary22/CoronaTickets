package logica;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.HashMap;

public class Espectaculo {
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
	private HashMap<String, Funcion> setFunciones;
	private boolean yaFueValuado;
	private boolean aceptado;
	private String imagen;
	private ArrayList<String> categorias;
	
	public String getImagen() {
		return imagen;
	}

	public void setYaFueValuado(boolean yaFueValuado) {
		this.yaFueValuado = yaFueValuado;
	}

	public void setAceptado(boolean aceptado) {
		this.aceptado = aceptado;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	public ArrayList<String> listarCategorias() {
		if (this.categorias == null) {
			this.categorias = new ArrayList<String>();
		}
		
		return this.categorias;
	}
	
	public Espectaculo(String nombre, LocalTime duracion, String descripcion, int minEspectadores, int maxEspectadores,
			String url, LocalDate fechaReg, float costo) {
		this.nombre = nombre;
		this.duracion = duracion;
		this.descripcion = descripcion;
		this.minEspectadores = minEspectadores;
		this.maxEspectadores = maxEspectadores;
		this.url = url;
		this.fechaReg = fechaReg;
		this.costo = costo;
		this.setFunciones = new HashMap<String,Funcion>();
		this.yaFueValuado = false;
		this.aceptado = false;
		this.categorias = new ArrayList<String>();
		this.imagen = "resources/media/espectaculos/rock.jpg";
	}
	
	public Espectaculo(String nombre, LocalTime duracion, String descripcion, int minEspectadores, int maxEspectadores,
			String url, LocalDate fechaReg, float costo, String imagen, ArrayList<String> categs) {
		this.nombre = nombre;
		this.duracion = duracion;
		this.descripcion = descripcion;
		this.minEspectadores = minEspectadores;
		this.maxEspectadores = maxEspectadores;
		this.url = url;
		this.fechaReg = fechaReg;
		this.costo = costo;
		this.setFunciones = new HashMap<String,Funcion>();
		this.yaFueValuado = false;
		this.aceptado = false;
		this.imagen = imagen;
		this.categorias = categs;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalTime getDuracion() {
		return duracion;
	}
	public void setDuracion(LocalTime duracion) {
		this.duracion = duracion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getMinEspectadores() {
		return minEspectadores;
	}
	public void setMinEspectadores(int minEspectadores) {
		this.minEspectadores = minEspectadores;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
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
	public float getCosto() {
		return costo;
	}
	public void setCosto(float costo) {
		this.costo = costo;
	}
	public void setMaxEspectadores(int maxEspectadores) {
		this.maxEspectadores = maxEspectadores;
	}
	
	public HashMap<String,Funcion> getAllFunciones() {
		return setFunciones;
	}
	public Funcion getFuncion(String nomfuncion) {
		return setFunciones.get(nomfuncion);
	}
	public void agregarFuncion(Funcion f) {
		this.setFunciones.put(f.getNombre(), f);
	}
	public int getMaxEspectadores() {
		return this.maxEspectadores;
	}

	public boolean isYaFueValuado() {
		return yaFueValuado;
	}

	public boolean isAceptado() {
		return aceptado;
	}
	
	public void addCategoria(String cat) {
		categorias.add(cat);
	}
}
