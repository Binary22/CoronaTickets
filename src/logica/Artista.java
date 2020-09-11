package logica;

import java.time.LocalDate;
import java.util.ArrayList;

import datatypes.DtArtista;
import datatypes.DtEspectaculo;

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
	
	public Artista(String nickname, String nombre, String apellido, String email, LocalDate fechaNacimiento,
			String descripcion, String biografia, String website) {
		super(nickname, nombre, apellido, email, fechaNacimiento);
		this.descripcion = descripcion;
		this.biografia = biografia;
		this.website = website;
	}
	
	public boolean esArtista_() {
		return true;
	}
	
	public DtArtista getDtArtista() {
		DtArtista dta = new DtArtista(getNickname(), getNombre(), getApellido(), getEmail(), getFechaNacimiento(), getDescripcion(), getBiografia(), getWebsite());
		return dta;
	}
	
}
