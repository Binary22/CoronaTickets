package datatypes;

import java.time.LocalDate;
import java.util.ArrayList;

import logica.Paquete;

public class DtPaquete {
	private String nombre;
	private LocalDate fechaI;
	private LocalDate fechaF;
	private int descuento;
	private String descripcion;
	private ArrayList<String> espectaculos;

	public DtPaquete(Paquete paquete) {
		nombre = paquete.getNombre();
		fechaI = paquete.getFechaI();
		fechaF = paquete.getFechaF();
		descripcion = paquete.getDescripcion();
		descuento = paquete.getDescuento();
		if (paquete.getEspectaculos().isEmpty()){
			espectaculos = new ArrayList<String>();
		}
		else{
			espectaculos = new ArrayList<String>(paquete.getEspectaculos().keySet());
		}

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

	public ArrayList<String> getEspectaculos() {
		return espectaculos;
	}

}
