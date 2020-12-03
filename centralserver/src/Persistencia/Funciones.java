package Persistencia;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity
public class Funciones implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	private String nombre;
	private String fecha;
	private String fechaAlta;
	@OneToOne(mappedBy = "funciones")
	private Espectaculos espect;
	@OneToMany
	private Collection<Registros> regsF;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public Espectaculos getEspect() {
		return espect;
	}
	public void setEspect(Espectaculos espect) {
		this.espect = espect;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Collection<Registros> getRegs() {
		return regsF;
	}
	public void setRegs(Collection<Registros> regs) {
		this.regsF = regs;
	}

}
