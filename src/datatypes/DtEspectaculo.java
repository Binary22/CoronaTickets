package datatypes;

import java.time.LocalDateTime;

public class DtEspectaculo {
	public DtEspectaculo(String nombre, int duracion, String descripcion, int minEspectadores, int maxEspectadores,
			String url, LocalDateTime fechaReg, float costo) {
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
	public String getNombre() {
		return nombre;
	}
	public int getDuracion() {
		return duracion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public int getMinEspectadores() {
		return minEspectadores;
	}
	public int getMaxEspectadores() {
		return maxEspectadores;
	}
	public String getUrl() {
		return url;
	}
	public LocalDateTime getFechaReg() {
		return fechaReg;
	}
	public float getCosto() {
		return costo;
	}
	private String nombre;
	private int duracion;
	private String descripcion;
	private int minEspectadores;
	private int maxEspectadores;
	private String url;
	private LocalDateTime fechaReg;
	private float costo;
}
