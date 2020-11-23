package datatypesweb;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import logica.Paquete;

@XmlAccessorType(XmlAccessType.FIELD)
public class dataPaquete {
	private String nombre;
	private LocalDate fechaI;
	private LocalDate fechaF;
	private LocalDate fechaAlta;
	private int descuento;
	private String descripcion;
	private List<String> espectaculos;
	private String imagen;
	
	public dataPaquete(Paquete paq) {
		this.nombre = paq.getNombre();
		this.fechaI = paq.getFechaI();
		this.fechaF = paq.getFechaF();
		this.fechaAlta = paq.getFechaAlta();
		this.descuento = paq.getDescuento();
		this.descripcion = paq.getDescripcion();
		this.espectaculos = new ArrayList<String>(paq.getEspectaculos().keySet());
		this.imagen = paq.getImagen();
		
	}
	
	public dataPaquete() {
		
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

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
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

	public List<String> getEspectaculos() {
		return espectaculos;
	}

	public void setEspectaculos(List<String> espectaculos) {
		this.espectaculos = espectaculos;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	
}
