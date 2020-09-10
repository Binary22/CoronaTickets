package datatypes;

import java.time.LocalDateTime;

public class DtPaquete {
	private String nombre;
	private LocalDateTime fechaI;
	private LocalDateTime fechaF;
	private int descuento;
	private String descripcion;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDateTime getFechaI() {
		return fechaI;
	}
	public void setFechaI(LocalDateTime fechaI) {
		this.fechaI = fechaI;
	}
	public LocalDateTime getFechaF() {
		return fechaF;
	}
	public void setFechaF(LocalDateTime fechaF) {
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
}
