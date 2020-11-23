package datatypesweb;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import logica.Espectaculo;
import logica.Funcion;
import logica.Registro;
import logica.Usuario;

@XmlAccessorType(XmlAccessType.FIELD)
public class dataFuncion {
	private String nombre;
	private LocalDate fecha;
	private LocalTime horaInicio;
	private LocalDate fechaReg;
	private List<String> artistasInvitados;
	private List<dataRegistro> registros;
	private String espectaculo;
	private String imagen;
	
	public dataFuncion(Funcion fun) {
		this.nombre = fun.getNombre();
		this.fecha = fun.getFecha();
		this.horaInicio = fun.getHoraInicio();
		this.fechaReg = fun.getFechaReg();
		this.artistasInvitados = new ArrayList<String>();
		List<Usuario> invitados = fun.getArtistasInvitados();
		for(int i = 0; i < invitados.size(); i++) {
			this.artistasInvitados.add(invitados.get(i).getNickname());
		}
		this.registros = new ArrayList<dataRegistro>();
    	List<Registro> regs = fun.getRegistros();
    	for(int i = 0; i < regs.size(); i++) {
    		this.registros.add(new dataRegistro(regs.get(i)));
    	}
    	
    	this.espectaculo = fun.getEspectaculo().getNombre();
    	this.imagen = fun.getImagen();
		
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

	public List<String> getArtistasInvitados() {
		return artistasInvitados;
	}

	public void setArtistasInvitados(List<String> artistasInvitados) {
		this.artistasInvitados = artistasInvitados;
	}

	public List<dataRegistro> getRegistros() {
		return registros;
	}

	public void setRegistros(List<dataRegistro> registros) {
		this.registros = registros;
	}

	public String getEspectaculo() {
		return espectaculo;
	}

	public void setEspectaculo(String espectaculo) {
		this.espectaculo = espectaculo;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	
	public dataFuncion(){
		
	}
	
	
}
