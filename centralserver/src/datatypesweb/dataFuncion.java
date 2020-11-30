package datatypesweb;


import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import logica.Espectaculo;
import logica.Funcion;
import logica.Premio;
import logica.Registro;
import logica.Usuario;

@XmlAccessorType(XmlAccessType.FIELD)
public class dataFuncion {
	private String nombre;
	private String fecha;
	private String horaInicio;
	private String fechaReg;
	private List<String> artistasInvitados;
	private List<dataRegistro> registros;
	private String espectaculo;
	private String imagen;
	//private dataPremio premio;
	private boolean fueSorteado;
	private boolean finalizo;
	private String descriPremio;
	private String fechaSorteo;
	private int cantPremios;
	
	
	public boolean isFueSorteado() {
		return fueSorteado;
	}



	public void setFueSorteado(boolean fueSorteado) {
		this.fueSorteado = fueSorteado;
	}



	public dataFuncion(Funcion fun) {
		this.nombre = fun.getNombre();
		this.fecha = fun.getFecha().toString();
		this.horaInicio = fun.getHoraInicio().toString();
		this.fechaReg = fun.getFechaReg().toString();
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
    	this.finalizo = false;
    	this.fueSorteado = fun.isFueSorteado();
    	
    	this.descriPremio = fun.getEspectaculo().getDescPremio();
    	if(fun.getPremio() != null) {
    	this.fechaSorteo = fun.getPremio().getFechaSorteado().toString();
    	}
    	this.cantPremios = fun.getEspectaculo().getCantPremios();
		
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

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getFechaReg() {
		return fechaReg;
	}

	public void setFechaReg(String fechaReg) {
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



	public boolean isFinalizo() {
		return finalizo;
	}



	public void setFinalizo(boolean finalizo) {
		this.finalizo = finalizo;
	}



	public String getDescriPremio() {
		return descriPremio;
	}



	public void setDescriPremio(String descriPremio) {
		this.descriPremio = descriPremio;
	}



	public String getFechaSorteo() {
		return fechaSorteo;
	}



	public void setFechaSorteo(String fechaSorteo) {
		this.fechaSorteo = fechaSorteo;
	}



	public int getCantPremios() {
		return cantPremios;
	}



	public void setCantPremios(int cantPremios) {
		this.cantPremios = cantPremios;
	}
	
	
}
