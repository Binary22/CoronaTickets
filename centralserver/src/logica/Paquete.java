package logica;
import java.time.LocalDate;
import java.util.HashMap;

import datatypes.DtPaquete;

public class Paquete {
	private String nombre;
	private LocalDate fechaI;
	private LocalDate fechaF;
	private LocalDate fechaAlta;
	private int descuento;
	private String descripcion;
	private HashMap<String, Espectaculo> espectaculos;
	private String imagen;
	
	public Paquete(String nombre, LocalDate fechaI, LocalDate fechaF, int descuento, String descripcion, LocalDate fechaalta) {
		super();
		this.nombre = nombre;
		this.fechaI = fechaI;
		this.fechaF = fechaF;
		this.descuento = descuento;
		this.descripcion = descripcion;
		this.fechaAlta = fechaalta;
		this.espectaculos = new HashMap<String, Espectaculo>();
		this.imagen = "resources/media/espectaculos/maracas.jpg";
	}
	
	public Paquete(String nombre2, LocalDate fechaini, LocalDate fechafin, int desc, String descrip,
			LocalDate fechaalta2, String imagen2) {
		super();
		this.nombre = nombre2;
		this.fechaI = fechaini;
		this.fechaF = fechafin;
		this.descuento = desc;
		this.descripcion = descrip;
		this.fechaAlta = fechaalta2;
		this.espectaculos = new HashMap<String, Espectaculo>();
		if (imagen != "" && imagen != null) {
			this.imagen = imagen2;
		} else {
			this.imagen = "resources/media/espectaculos/maracas.jpg";
		}
		
	}
	
	
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getImagen() {
		return imagen;
	}

	public void addEspectaculo(Espectaculo e) {
		espectaculos.put(e.getNombre(), e);
	}
	
	public DtPaquete getDt() {
		return null;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaI() {
		return fechaI;
	}

	public void setFechaI(LocalDate fechaI) {
		this.fechaI = fechaI;
	}

	public LocalDate getFechaF() {
		return fechaF;
	}

	public void setFechaF(LocalDate fechaF) {
		this.fechaF = fechaF;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public HashMap<String, Espectaculo> getEspectaculos() {
		return espectaculos;
	}

	public void setEspectaculos(HashMap<String, Espectaculo> espectaculos) {
		this.espectaculos = espectaculos;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}
	
	

}

	