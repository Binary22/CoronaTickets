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

	

	@Override
	public void altaArtista(String desc, String bio, String web) {
		HandlerUsuarios huser = HandlerUsuarios.getInstancia();
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
		return null;
	}


	@Override
	public void updateUsuario(String nombre, String apellido, LocalDate fechaNac) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateArtista(String nombre, String apellido, LocalDate fechaNac, String desc, String bio, String web) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void confirmarUpdateUsuario() {
		// TODO Auto-generated method stub
		
	}

}
