package datatypes;

import java.time.LocalDate;

public class DtEspectaculo {
	
	private String nombre;
	private int duracion;
	private String descripcion;
	private int minEspectadores;
	private int maxEspectadores;
	private String url;
	private LocalDate fechaReg;
	private float costo;
	
	public DtEspectaculo(String nombre, int duracion, String descripcion, int minEspectadores, int maxEspectadores,
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
	public LocalDate getFechaReg() {
		return fechaReg;
	}
	public float getCosto() {
		return costo;
	}
	
	
	/* Sirve para mostrar textualmente la información del usuario, por ejemplo en un ComboBox
	    */
	   public String toString() {
	       return getNombre();
	   }
}
