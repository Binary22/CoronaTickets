package datatypesweb;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import logica.Artista;
import logica.Espectaculo;
import logica.Registro;
import logica.Usuario;
import logica.Vale;



@XmlAccessorType(XmlAccessType.FIELD)
public class dataUsuario {
	private String nickname;
	private String nombre;
	private String apellido;
	private String email;
	private String fechaNacimiento;
	private List<dataCompra> compraPaquete;
	private List<dataVale> vales;
	private List<dataRegistro> registros;
	private String password;
	private String imagen;
	private List<String> seguidos;
	
	private boolean esArtista;
	private String descripcion;
	private String biografia;
	private String website;
	
	private List<String> espectaculos;
	
	public dataUsuario(Usuario user) {
		this.setApellido(user.getApellido());
    	this.setEmail(user.getEmail());
    	this.setFechaNacimiento(user.getFechaNacimiento().toString());
    	this.setImagen(user.getImagen());
    	this.setNickname(user.getNickname());
    	this.setNombre(user.getNombre());
    	this.setPassword(user.getPassword());
    	
    	if (user.esArtista()) {
    		this.esArtista = true;
    		this.setDescripcion(((Artista) user).getDescripcion());
    		this.setBiografia(((Artista) user).getBiografia());
    		this.setWebsite(((Artista) user).getWebsite());
    		Artista artista = (Artista) user;
    		this.espectaculos = new ArrayList<String>();
    		for (Espectaculo e : artista.getEspectaculos()) {
    			this.espectaculos.add(e.getNombre());
    		}
    	} else {
    		this.esArtista = false;
    	}
    	
    	this.compraPaquete = new ArrayList<dataCompra>();
    	for(int i = 0; i < user.getCompraPaquete().size(); i++) {
    		this.compraPaquete.add(new dataCompra(user.getCompraPaquete().get(i)));
    	}
    	this.vales = new ArrayList<dataVale>();
    	List<Vale> vales = user.getVales();
    	for(int i = 0; i < vales.size(); i++) {
    		this.vales.add(new dataVale(vales.get(i)));
    	}
    	
    	this.registros = new ArrayList<dataRegistro>();
    	List<Registro> regs = user.getRegistros();
    	for(int i = 0; i < regs.size(); i++) {
    		this.registros.add(new dataRegistro(regs.get(i)));
    	}
    	
    	this.seguidos = new ArrayList<String>();
    	List<Usuario> segs = user.getSeguidos();
    	for(int i = 0; i < segs.size(); i++) {
    		this.seguidos.add(segs.get(i).getNickname());
    	}
    	
		
	}	
	
	public boolean esArtista() {
		return esArtista;
	}

	public void setEsArtista(boolean esArtista) {
		this.esArtista = esArtista;
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

	public List<String> getEspectaculos() {
		return espectaculos;
	}

	public void setEspectaculos(List<String> espectaculos) {
		this.espectaculos = espectaculos;
	}

	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(String string) {
		this.fechaNacimiento = string;
	}


	public List<dataCompra> getCompraPaquete() {
		return compraPaquete;
	}


	public void setCompraPaquete(List<dataCompra> compraPaquete) {
		this.compraPaquete = compraPaquete;
	}


	public List<dataVale> getVales() {
		return vales;
	}


	public void setVales(List<dataVale> vales) {
		this.vales = vales;
	}


	public List<dataRegistro> getRegistros() {
		return registros;
	}


	public void setRegistros(List<dataRegistro> registros) {
		this.registros = registros;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getImagen() {
		return imagen;
	}


	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


	public List<String> getSeguidos() {
		return seguidos;
	}


	public void setSeguidos(List<String> seguidos) {
		this.seguidos = seguidos;
	}


	public List<dataUsuario> getSiguiendo() {
		return siguiendo;
	}


	public void setSiguiendo(List<dataUsuario> siguiendo) {
		this.siguiendo = siguiendo;
	}


	private List<dataUsuario> siguiendo;
	
	
	public dataUsuario() {
		
	}
	
	
}
