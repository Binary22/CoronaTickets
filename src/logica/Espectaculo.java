package logica;

import java.time.LocalDate;
import java.util.ArrayList;

public class Espectaculo {
	private String nombre;
	private int duracion;
	private String descripcion;
	private int minEspectadores;
	private int maxEspectadores;
	private String url;
	private LocalDate fechaReg;
	private float costo;
	private ArrayList<Funcion> setFunciones;
	private Plataforma plataforma;
	private Artista artista;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
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
	public float getCosto() {
		return costo;
	}
	public void setCosto(float costo) {
		this.costo = costo;
	}
	public void setMaxEspectadores(int maxEspectadores) {
		this.maxEspectadores = maxEspectadores;
	}
	public Espectaculo(String nombre, int duracion, String descripcion, int minEspectadores, int maxEspectadores,
			String url, LocalDate fechaReg, float costo) {
		super();
		this.nombre = nombre;
		this.duracion = duracion;
		this.descripcion = descripcion;
		this.minEspectadores = minEspectadores;
		this.maxEspectadores = maxEspectadores;
		this.url = url;
		this.fechaReg = fechaReg;
		this.costo = costo;
	}
	
	
	
	public ArrayList<Funcion> getAllFunciones() {
		return null;
	}
	public Funcion getFuncion(String nomfuncion) {
		return null;
	}
	public void agregarFuncion(Funcion f) {
		this.setFunciones.add(f);
	}
	public int getMaxEspectadores() {
		return 0;
	}
}
