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
	private HashMap<String,Espectaculo> espectaculos;
	
	public Paquete(String nombre, LocalDate fechaI, LocalDate fechaF, int descuento, String descripcion, LocalDate fechaalta) {
		super();
		this.nombre = nombre;
		this.fechaI = fechaI;
		this.fechaF = fechaF;
		this.descuento = descuento;
		this.descripcion = descripcion;
		this.fechaAlta = fechaalta;
	}
	
	public void addEspectaculo(Espectaculo e) {
		espectaculos.put(e.getNombre(), e);
		
	}
	
	public DtPaquete getDt() {
		return null;
	}

	public String getNombre() {
		return this.nombre;
	}

//	public String getNombre() {
//		return nombre;
//	}
//
//	public void setNombre(String nombre) {
//		this.nombre = nombre;
//	}
//
//	public LocalDate getFechaI() {
//		return fechaI;
//	}
//
//	public void setFechaI(LocalDate fechaI) {
//		this.fechaI = fechaI;
//	}
//
//	public LocalDate getFechaF() {
//		return fechaF;
//	}
//
//	public void setFechaF(LocalDate fechaF) {
//		this.fechaF = fechaF;
//	}
//
//	public int getDescuento() {
//		return descuento;
//	}
//
//	public void setDescuento(int descuento) {
//		this.descuento = descuento;
//	}
//
//	public String getDescripcion() {
//		return descripcion;
//	}
//
//	public void setDescripcion(String descripcion) {
//		this.descripcion = descripcion;
//	}
//
//	public HashMap<String, Espectaculo> getEspectaculos() {
//		return espectaculos;
//	}
//
//	public void setEspectaculos(HashMap<String, Espectaculo> espectaculos) {
//		this.espectaculos = espectaculos;
//	}
	
	

}

	