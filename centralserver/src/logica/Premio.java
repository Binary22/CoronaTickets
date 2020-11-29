package logica;

import java.time.LocalDate;

public class Premio {
	private LocalDate fechaSorteado;
	private Funcion funcion;
	private String descripcion;
	
	public Premio(LocalDate fecha) {
		this.setFechaSorteado(fecha);
	}

	public LocalDate getFechaSorteado() {
		return fechaSorteado;
	}

	public void setFechaSorteado(LocalDate fechaSorteado) {
		this.fechaSorteado = fechaSorteado;
	}

	public Funcion getFuncion() {
		return funcion;
	}

	public void setFuncion(Funcion funcion) {
		this.funcion = funcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
