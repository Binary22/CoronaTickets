package logica;
import java.time.LocalDate;
import java.util.Map;

public class Paquete {
	private String nombre;
	private LocalDate fechaI;
	private LocalDate fechaF;
	private int descuento;
	private String descripcion;
	private Map<String,Espectaculo> espectaculos;
	
	public Paquete(String nombre, LocalDate fechaI, LocalDate fechaF, int descuento, String descripcion) {
		super();
		this.nombre = nombre;
		this.fechaI = fechaI;
		this.fechaF = fechaF;
		this.descuento = descuento;
		this.descripcion = descripcion;
	}
	
	public void addEspectaculo(Espectaculo e) {
		
	}
	
	public DtPaquete getDt() {
		return null;
	}

}

	