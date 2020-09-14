package datatypes;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import logica.Funcion;
import logica.Usuario;

public class DtFuncion {
	private String nombre;
	private LocalDate fecha;
	private LocalTime horainicio;
	private LocalDate fechaReg;
	private String espectaculo;
	private ArrayList<DtArtista> artistas;
	
	public DtFuncion(String nombre, LocalDate fecha, LocalTime horainicio, LocalDate fechaReg) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
		this.horainicio = horainicio;
		this.fechaReg = fechaReg;
		this.artistas = new ArrayList<DtArtista>();
	}
	
	public void addArtista(DtArtista a) {
		artistas.add(a);
	}
	public ArrayList<DtArtista> getArtistas() {
		return artistas;
	}
	
	public DtFuncion(Funcion f) {
		this.espectaculo = f.getEspectaculo().getNombre();
		this.artistas = new ArrayList<DtArtista>();
		this.nombre = f.getNombre();
		this.fecha = f.getFecha();
		this.horainicio = f.getHoraInicio();
		this.fechaReg = f.getFechaReg();
		if (f.getArtistasInvitados() != null) {
			for(Usuario u : f.getArtistasInvitados()) {
				this.artistas.add(u.getDtArtista());
			}
		}
	}

	public String getEspectaculo() {
		return espectaculo;
	}

	public void setEspectaculo(String espectaculo) {
		this.espectaculo = espectaculo;
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
