package datatypes;

public class DtPlataforma {
	private String nombre;
	private String descrip;
	private String url;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDescrip() {
		return descrip;
	}
	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/* Sirve para mostrar textualmente la información del usuario, por ejemplo en un ComboBox
    */
   public String toString() {
       return getNombre();
   }
}
