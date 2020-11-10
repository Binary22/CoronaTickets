package logica;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import datatypes.DtFuncion;

import java.time.LocalDate;

public class Funcion {
	private String nombre;
	private LocalDate fecha;
	private LocalTime horaInicio;
	private LocalDate fechaReg;
	
	private List<Usuario> artistasInvitados;
	private List<Registro> registros;
	private Espectaculo espectaculo;
	private String imagen;
	
	
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
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
	public List<Usuario> getArtistasInvitados() {
		return artistasInvitados;
	}
	public void setArtistasInvitados(List<Usuario> artistasInvitados) {
		this.artistasInvitados = artistasInvitados;
	}
	public List<Registro> getRegistros() {
		return this.registros;
	}
	public void setRegistros(List<Registro> registros) {
		this.registros = registros;
	}
	public Espectaculo getEspectaculo() {
		return espectaculo;
	}
	public void setEspectaculo(Espectaculo espectaculo) {
		this.espectaculo = espectaculo;
	}
	public DtFuncion getDt() {
		return new DtFuncion(this);
	}
	public int getLimite() {
		return 0;
		
	}
	public List<String> listarArtistas() {
		List<String> lista = new ArrayList<String>();
		for (Usuario a : artistasInvitados) {
			lista.add(a.getNickname());
		}
		return lista;
	}
	
	public void addEspectador(Registro reg) {
		this.registros.add(reg);
	}
	public Funcion(String nombre, LocalDate fecha, LocalTime horaInicio, LocalDate fechaReg, List<Usuario> artistasInvitados, Espectaculo espectaculo) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
		this.horaInicio = horaInicio;
		this.fechaReg = fechaReg;
		this.artistasInvitados = artistasInvitados;
		this.espectaculo = espectaculo;
		this.registros = new ArrayList<Registro>();
	
	}
	
	public List<String> getArtistasInvitadosWeb() {
		List<Usuario> artistas = this.artistasInvitados;
		if (artistas != null) {
			List<String> nombres = new ArrayList<String>();
			for (int i = 0; i < artistas.size(); i++) {
				nombres.add(artistas.get(i).getNickname());
			}
		return nombres;
		}
	return null;
	}
	
}
