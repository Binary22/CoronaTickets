package datatypesweb;

import java.time.LocalDate;

import logica.Compra;



public class dataCompra {
	private String fecha;
	private String paquete;
	
	public dataCompra(Compra comp) {
		this.fecha = comp.getFecha().toString();
		this.paquete = comp.getPaquete().getNombre();
	}
	
	public dataCompra() {
		
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getPaquete() {
		return paquete;
	}

	public void setPaquete(String paquete) {
		this.paquete = paquete;
	}
}
