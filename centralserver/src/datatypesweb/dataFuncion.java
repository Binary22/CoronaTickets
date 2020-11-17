package datatypesweb;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import logica.Espectaculo;


public class dataFuncion {
	private String nombre;
	private LocalDate fecha;
	private LocalTime horaInicio;
	private LocalDate fechaReg;
	
	private List<dataUsuario> artistasInvitados;
	private List<dataRegistro> registros;
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

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalDate getFechaReg() {
		return fechaReg;
	}

	public void setFechaReg(LocalDate fechaReg) {
		this.fechaReg = fechaReg;
	}

	public List<dataUsuario> getArtistasInvitados() {
		return artistasInvitados;
	}

	public void setArtistasInvitados(List<dataUsuario> artistasInvitados) {
		this.artistasInvitados = artistasInvitados;
	}

	public List<dataRegistro> getRegistros() {
		return registros;
	}

	public void setRegistros(List<dataRegistro> registros) {
		this.registros = registros;
	}

	public Espectaculo getEspectaculo() {
		return espectaculo;
	}

	public void setEspectaculo(Espectaculo espectaculo) {
		this.espectaculo = espectaculo;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	private Espectaculo espectaculo;
	private String imagen;
	
	public dataFuncion(){
		
	}
	
	
}
