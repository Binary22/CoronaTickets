package datatypes;

import java.time.LocalDate;

public class DtRegistro {
	private LocalDate fecha;
	private boolean canjeado;
	private int id;
	
	public DtRegistro(LocalDate fecha, int id) {
		super();
		this.fecha = fecha;
		this.id = id;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public boolean isCanjeado() {
		return canjeado;
	}
	public void setCanjeado(boolean canjeado) {
		this.canjeado = canjeado;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
}
