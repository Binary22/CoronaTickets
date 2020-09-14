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
	
	private ArrayList<Usuario> artistasInvitados;
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
	public ArrayList<Usuario> getArtistasInvitados() {
		return artistasInvitados;
	}
	public void setArtistasInvitados(ArrayList<Usuario> artistasInvitados) {
		this.artistasInvitados = artistasInvitados;
	}
	public ArrayList<Registro> getRegistros() {
		return this.registros;
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
		DtFuncion ret = new DtFuncion(nombre, fecha, horaInicio, fechaReg);
		ret.setEspectaculo(getEspectaculo().getNombre());
		for (int i = 0; i < artistasInvitados.size(); i++) {
			ret.addArtista(artistasInvitados.get(i).getDtArtista());
		}
		return ret;
		
	}
	public int getLimite() {
		return 0;
		
	}
	public void addEspectador(Registro reg) {
		this.registros.add(reg);
	}
	public Funcion(String nombre, LocalDate fecha, LocalTime horaInicio, LocalDate fechaReg, ArrayList<Usuario> artistasInvitados, Espectaculo espectaculo) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
		this.horaInicio = horaInicio;
		this.fechaReg = fechaReg;
		this.artistasInvitados = artistasInvitados;
		this.espectaculo = espectaculo;
		this.registros = new ArrayList<Registro>();
	
	}
	
	
}
