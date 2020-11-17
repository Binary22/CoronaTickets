package logica;

import java.time.LocalDate;

public class Compra {
	private LocalDate fecha;
	private Paquete paquete;

	public Compra(LocalDate fecha, Paquete paq) {
		super();
		this.fecha = fecha;
		this.paquete = paq;
	}
	
	public Paquete getPaquete() {
		return paquete;
	}

	public LocalDate getFecha() {
		return fecha;
	}
}
