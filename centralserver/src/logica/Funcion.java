package logica;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
	private Premio premio;
	private boolean fueSorteado;
	private List<Usuario> premiados;
	
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
		this.fueSorteado = false;
	
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
	public Premio getPremio() {
		return premio;
	}
	public void setPremio(Premio premio) {
		this.premio = premio;
	}
	public boolean isFueSorteado() {
		return fueSorteado;
	}
	public void setFueSorteado(boolean fueSorteado) {
		this.fueSorteado = fueSorteado;
	}
	
	public boolean funcionFinalizo() {
		LocalDate fechaHoy = LocalDate.now();
		LocalTime hora = LocalTime.now();
		LocalTime fin = this.getHoraInicio().plusHours(this.espectaculo.getDuracion().getHour()).plusMinutes(this.espectaculo.getDuracion().getMinute());
		if(fechaHoy.isAfter(this.getFecha()) || (fechaHoy.equals(this.getFecha()) && !hora.isBefore(fin))) {
			return true;
		}
		return false;
	}
	
	public List<Usuario> getEspectadores(){
		List<Usuario> espectadores = new ArrayList<Usuario>();
		List<Registro> regs = this.registros;
		for(int i = 0; i < regs.size(); i++) {
			espectadores.add(regs.get(i).getUsuario());
		}
		return espectadores;
	}
	
	public void sortearPremios() {
		this.fueSorteado = true;
		List<Usuario> espectadores = this.getEspectadores();
		int cantPremios = this.espectaculo.getCantPremios();
		List<Usuario> elegidos = new ArrayList<Usuario>();
		Random rand = new Random();
		for (int i = 0; i < cantPremios; i++) {
	        int randomIndex = rand.nextInt(espectadores.size());
	        Usuario randomUser = espectadores.get(randomIndex);
	        elegidos.add(randomUser);
	        espectadores.remove(randomIndex);
	    }
		Premio nuevo = new Premio(LocalDate.now());
		nuevo.setDescripcion(this.espectaculo.getDescPremio());
		nuevo.setFuncion(this);
		this.premio = nuevo;
		this.premiados = elegidos;
		this.fueSorteado = true;
		for(int i = 0; i < elegidos.size(); i++) {
			elegidos.get(i).agregarPremio(nuevo);
		}
	}
	public List<Usuario> getPremiados() {
		return premiados;
	}
	public void setPremiados(List<Usuario> premiados) {
		this.premiados = premiados;
	}
	
}
