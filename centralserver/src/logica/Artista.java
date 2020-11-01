package logica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import datatypes.DtArtista;
import datatypes.DtEspectaculo;
import datatypes.DtUsuario;

public class Artista extends Usuario {
	private String descripcion;
	private String biografia;
	private String website;
	
	private ArrayList<Espectaculo> espectaculos;
	
	
	public ArrayList<Espectaculo> getEspectaculos() {
		return espectaculos;
	}
	public void setEspectaculos(ArrayList<Espectaculo> espectaculos) {
		this.espectaculos = espectaculos;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getBiografia() {
		return biografia;
	}
	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	
	//operaciones de la clase
	
	public ArrayList<DtEspectaculo> obtenerEspectaculosOrganizados(){
		return null;
		
	}
	public void confirmarUpdateArtista(String nombre,String apellido,LocalDate fechaNac,String desc,String bio,String web) {
		
	}

	public Artista(Usuario usuario, String desc, String bio, String web) {
		super(usuario.getNickname(),usuario.getNombre(),usuario.getApellido(),usuario.getEmail(), usuario.getFechaNacimiento());
		this.descripcion = desc;
		this.biografia = bio;
		this.website = web;
	}
	
	public Artista(String nickname, String nombre, String apellido, String email, LocalDate fechaNacimiento,
			String descripcion, String biografia, String website) {
		super(nickname, nombre, apellido, email, fechaNacimiento);
		this.descripcion = descripcion;
		this.biografia = biografia;
		this.website = website;
	}
	
	public Artista(String nickname, String nombre, String apellido, String email, LocalDate fechaNacimiento,
			String descripcion, String biografia, String website, String password, String imagen) {
		super(nickname, nombre, apellido, email, fechaNacimiento, password, imagen);
		this.descripcion = descripcion;
		this.biografia = biografia;
		this.website = website;
	}
	
	public boolean esArtista_() {
		return true;
	}
	public boolean esArtista() {
		return true;
	}
	
	@Override
	public DtArtista getDtArtista() {
		DtArtista dta = new DtArtista(getNickname(), getNombre(), getApellido(), getEmail(), getFechaNacimiento(), getDescripcion(), getBiografia(), getWebsite());
		return dta;
	}
	
	public DtUsuario getDt() {
		DtArtista dta = new DtArtista(getNickname(), getNombre(), getApellido(), getEmail(), getFechaNacimiento(), getDescripcion(), getBiografia(), getWebsite());
		return dta;
	}

	public boolean tieneEspectaculosAceptados() {
		for (Espectaculo e : espectaculos) {
			if (e.isAceptado()) {
				return true;
			}
		}	
		return false;
	}
	
	public List<Espectaculo> espectaculosAceptados() {
		List lista = new ArrayList();
		for (Espectaculo e : espectaculos) {
			if (e.isAceptado()) {
				lista.add(e);
			}
		}
		return  lista;	
	}

	public boolean tieneEspectaculosIngresadosSinAceptar() {
		for (Espectaculo e : espectaculos) {
			if (!e.isYaFueValuado()) {
				return true;
			}
		}
		return false;
	}
	
	public List<Espectaculo> espectaculosIngresadosSinAceptar() {
		List lista = new ArrayList();
		for (Espectaculo e : espectaculos) {
			if (!e.isYaFueValuado()) {
				lista.add(e);
			}
		}
		return  lista;	
	}
	
	public boolean tieneEspectaculosRechazados() {
		for (Espectaculo e : espectaculos) {
			if (!e.isAceptado()) {
				return true;
			}
		}
		return false;
	}
	
	public List<Espectaculo> espectaculosRechazados() {
		List lista = new ArrayList();
		for (Espectaculo e : espectaculos) {
			if (!e.isAceptado()) {
				lista.add(e);
			}
		}
		return lista;	
	}

}


