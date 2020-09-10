package logica;

import java.util.ArrayList;

public class PlataformaController implements IPlataforma {
	private String nombre;
	private String descrip;
	private String url;

	public PlataformaController(String nombre, String descrip, String url) {
		this.setNombre(nombre);
		this.setDescrip(descrip);
		this.setUrl(descrip);
	}
	
	public PlataformaController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<String> listarPlataformas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> listarEspectaculosPlataforma(String nomEspectaculo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void altaPlataforma(String nombre, String descrip, String url) {
		// TODO Auto-generated method stub

	}

	@Override
	public void confirmarAltaPlataforma() {
		// TODO Auto-generated method stub

	}

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

}
