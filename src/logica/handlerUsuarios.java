package logica;

import java.util.ArrayList;

public class handlerUsuarios {
	//SINGLETON
	private ArrayLista<Usuario> usuarios;
	private static handlerUsuarios instancia = null;
	
	private handlerUsuarios() {
		
	}
	
	public static handlerUsuarios getInstancia() {
		if(instancia == null)
			instancia = new handlerUsuarios();
		return instancia;
	}
	public ArrayList<String> getNombres(){
		return null;
	}
	public Usuario getUsuario(String nickname) {
		return null;
	}
	public ArrayList<Artista> getArtistasInvitados(ArrayList<String> invitados){
		return null;
	}
	public void agregarUsuario(Usuario u) {
		
	}

	public ArrayLista<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayLista<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	

}

