package datatypesweb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import logica.Artista;

@XmlAccessorType(XmlAccessType.FIELD)
public class dataArtista extends dataUsuario {
	private String descripcion;
	private String biografia;
	private String website;
	
	public dataArtista() {
		super();
		// TODO Auto-generated constructor stub
	}
	public dataArtista(Artista user) {
		super(user);
		this.setDescripcion(user.getDescripcion());
		this.setBiografia(user.getBiografia());
		this.setWebsite(user.getWebsite());
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
}


