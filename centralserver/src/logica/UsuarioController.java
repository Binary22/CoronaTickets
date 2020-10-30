package logica;

import java.util.ArrayList;
import java.time.LocalDate;

import datatypes.DtUsuario;
import excepciones.UsuarioConMismoMailException;
import excepciones.UsuarioConMismoNickException;

public class UsuarioController implements IUsuario{
	
	private String nickname;
	private String nombre;
	private String apellido;
	private String email;
	private LocalDate fechaNacimiento;
	private String descrip;
	private String biografia;
	private String web;
	
	private Usuario usuario;
	private Artista artista;
	private boolean esArtista;
	
	//getters and setters

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
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

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	@Override
	public void altaUsuario(String nickname, String nombre, String apellido, String mail, LocalDate fechanac) throws UsuarioConMismoNickException, UsuarioConMismoMailException {
		this.esArtista = false;
		HandlerUsuarios huser = HandlerUsuarios.getInstancia();
		boolean existemail= huser.existeMail(mail);
		if ((huser.getUsuario(nickname) == null) && (!existemail)) {
			this.esArtista = false;
			this.usuario = new Usuario(nickname, nombre, apellido, mail, fechanac);
		}
		else if(huser.getUsuario(nickname) != null)
			throw new UsuarioConMismoNickException("El nick del usuario " + nickname + " ya esta en uso");
		else if(existemail)
			throw new UsuarioConMismoMailException("El mail " + mail + " ya esta en uso");
	}
	
	public void altaUsuarioWeb(String nickname, String nombre, String apellido, String mail, LocalDate fechanac, String password, String imagen) throws UsuarioConMismoNickException, UsuarioConMismoMailException {
		this.esArtista = false;
		HandlerUsuarios huser = HandlerUsuarios.getInstancia();
		boolean existemail= huser.existeMail(mail);
		if ((huser.getUsuario(nickname) == null) && (!existemail)) {
			this.esArtista = false;
			this.usuario = new Usuario(nickname, nombre, apellido, mail, fechanac, password, imagen);
		}
		else if(huser.getUsuario(nickname) != null)
			throw new UsuarioConMismoNickException("El nick del usuario " + nickname + " ya esta en uso");
		else if(existemail)
			throw new UsuarioConMismoMailException("El mail " + mail + " ya esta en uso");
	}
	
	
	public void altaArtistaWeb(String nickname, String nombre, String apellido, String mail, LocalDate fechanac, String desc, String bio, String web, String password, String imagen)throws UsuarioConMismoNickException, UsuarioConMismoMailException {
		HandlerUsuarios huser = HandlerUsuarios.getInstancia();
		boolean existemail= huser.existeMail(mail);
		if ((huser.getUsuario(nickname) == null) && (!existemail)) {
			this.esArtista = true;
			this.artista = new Artista(nickname,nombre, apellido, mail, fechanac, desc, bio, web, password, imagen);
		}
		else if(huser.getUsuario(nickname) != null)
			throw new UsuarioConMismoNickException("El nick del usuario " + nickname + " ya esta en uso");
		else if(existemail)
			throw new UsuarioConMismoMailException("El mail " + mail + " ya esta en uso");
	}
	
	

	

	@Override
	public void altaArtista(String desc, String bio, String web) {
		
		this.esArtista = true;
		this.artista = new Artista(this.usuario, desc, bio, web);
	}

	@Override
	public void confirmarAltaUsuario() {
		HandlerUsuarios up = HandlerUsuarios.getInstancia();
		if (esArtista) {
			//up.agregarArtista(artista);
			up.agregarUsuario(artista);
		} else {
			up.agregarUsuario(usuario);
		}
	}

	@Override
	public ArrayList<String> mostrarUsuarios() {
		// TODO Auto-generated method stub
		HandlerUsuarios hu = HandlerUsuarios.getInstancia();
		return hu.getNombres();
	}

	public DtUsuario mostrarUsuario(String nomUsuario) {
		HandlerUsuarios hu = HandlerUsuarios.getInstancia();
		Usuario u = hu.getUsuario(nomUsuario);
		return u.getDt();
	}
	
	@Override
	public void updateUsuario(String nickviejo, String nombre, String apellido, String mail, LocalDate fechaNac) {
		// TODO Auto-generated method stub
		this.nickname = nickviejo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = mail;
		this.fechaNacimiento = fechaNac;
		this.esArtista = false;
		
	}

	@Override
	public void updateArtista(String desc, String bio, String web) {
		// TODO Auto-generated method stub
		this.esArtista = true;
		this.descrip = desc;
		this.biografia = bio;
		this.web = web;
	}

	@Override
	public void confirmarUpdateUsuario() {
		HandlerUsuarios hu = HandlerUsuarios.getInstancia();
		usuario = new Usuario(nickname, nombre, apellido, email, fechaNacimiento);
		if (esArtista) {
			artista = new Artista(usuario, descrip, biografia, web);
			hu.rempazar(nickname, artista);
		} else {
		hu.rempazar(nickname,usuario);
		};
	}

}
