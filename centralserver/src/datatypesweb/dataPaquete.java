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
	private String fechaI;
	private String fechaF;
	private String fechaAlta;
	private int descuento;
	private String descripcion;
	private List<String> espectaculos;
	private String imagen;
	
	public dataPaquete(Paquete paq) {
		this.nombre = paq.getNombre();
		this.fechaI = paq.getFechaI().toString();
		this.fechaF = paq.getFechaF().toString();
		this.fechaAlta = paq.getFechaAlta().toString();
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

	public String getFechaI() {
		return fechaI;
	}

	public void setFechaI(String fechaI) {
		this.fechaI = fechaI;
	}

	public String getFechaF() {
		return fechaF;
	}

	public void setFechaF(String fechaF) {
		this.fechaF = fechaF;
	}

	public String getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(String fechaAlta) {
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
