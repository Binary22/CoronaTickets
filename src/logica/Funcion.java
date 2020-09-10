package logica;

import java.time.LocalTime;
import java.util.ArrayList;

import datatypes.DtFuncion;

import java.time.LocalDate;

public class Funcion {
	private String nombre;
	private LocalDate fecha;
	private LocalTime horaInicio;
	private LocalDate fechaReg;
	
	private ArrayList<Artista> artistasInvitados;
	private ArrayList<Registro> registros;
	private Espectaculo espectaculo;
	
	
	
	
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
	public ArrayList<Artista> getArtistasInvitados() {
		return artistasInvitados;
	}
	public void setArtistasInvitados(ArrayList<Artista> artistasInvitados) {
		this.artistasInvitados = artistasInvitados;
	}
	public ArrayList<Registro> getRegistros() {
		return registros;
	}
	public void setRegistros(ArrayList<Registro> registros) {
		this.registros = registros;
	}
	public Espectaculo getEspectaculo() {
		return espectaculo;
	}
	public void setEspectaculo(Espectaculo espectaculo) {
		this.espectaculo = espectaculo;
	}
	public DtFuncion getDt() {
		return null;
		
	}
	public int getLimite() {
		return 0;
		
	}
	public void addEspectador(Registro reg) {
		
	}
	public Funcion(String nombre, LocalDate fecha, LocalTime horaInicio, LocalDate fechaReg, ArrayList<Artista> artistasInvitados,
			ArrayList<Registro> registros, Espectaculo espectaculo) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
		this.horaInicio = horaInicio;
		this.fechaReg = fechaReg;
		this.artistasInvitados = artistasInvitados;
		this.registros = registros;
		this.espectaculo = espectaculo;
	}
	
	
}
