package logica;

import java.sql.Time;
import java.util.Date;

public class Funcion {
	private String nombre;
	private Date fecha;
	private Time horaInicio;
	private Date fechaReg;
	
	private ArrayList<Artista> artistasInvitados;
	private ArrayList<Registro> registros;
	private Espectaculo espectaculo;
	
	
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Time getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}
	public Date getFechaReg() {
		return fechaReg;
	}
	public void setFechaReg(Date fechaReg) {
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
		
	}
	public int getLimite() {
		
	}
	public void addEspectador(Registro reg) {
		
	}
	public Funcion(String nombre, Date fecha, Time horaInicio, Date fechaReg, ArrayList<Artista> artistasInvitados,
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
