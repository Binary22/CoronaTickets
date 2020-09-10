package datatypes;

import java.time.LocalDate;
import java.time.LocalTime;

public class DtFuncion {
	private String nombre;
	private LocalDate fecha;
	private LocalTime horainicio;
	private LocalDate fechaReg;
	public DtFuncion(String nombre, LocalDate fecha, LocalTime horainicio, LocalDate fechaReg) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
		this.horainicio = horainicio;
		this.fechaReg = fechaReg;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public LocalTime getHorainicio() {
		return horainicio;
	}
	public void setHorainicio(LocalTime horainicio) {
		this.horainicio = horainicio;
	}
	public LocalDate getFechaReg() {
		return fechaReg;
	}
	public void setFechaReg(LocalDate fechaReg) {
		this.fechaReg = fechaReg;
	}
	
	
}
