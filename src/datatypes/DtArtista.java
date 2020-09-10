package datatypes;

import java.util.Date;

public class DtArtista extends DtUsuario {
	private String descripcion;
	private String biografia;
	private String website;
	
	
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
	
	public DtArtista(String nickname, String nombre, String apellido, String email, Date fechaNacimiento,
			String descripcion, String biografia, String website) {
		super(nickname, nombre, apellido, email, fechaNacimiento);
		this.descripcion = descripcion;
		this.biografia = biografia;
		this.website = website;
	}
	
	
	
}
