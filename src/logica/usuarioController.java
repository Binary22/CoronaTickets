package logica;

import java.util.ArrayList;
import java.util.Date;

import datatypes.DtUsuario;

public class usuarioController implements IUsuario{
	
	private String nickname;
	private String nombre;
	private String apellido;
	private String email;
	private Date fechaNacimiento;
	
	private Usuario usuario;
	private Artista artista;
	
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

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	@Override
	public void altaUsuario(String nickname, String nombre, String apellido, String mail, Date fechanac) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void altaArtista(String desc, String bio, String web) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void confirmarAltaUsuario() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<String> mostrarUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DtUsuario mostrarDatos(String nickname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUsuario(String nombre, String apellido, Date fechaNac) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateArtista(String nombre, String apellido, Date fechaNac, String desc, String bio, String web) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void confirmarUpdateUsuario() {
		// TODO Auto-generated method stub
		
	}

}
