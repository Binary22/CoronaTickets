package logica;

import java.util.HashMap;
import java.util.ArrayList;


public class handlerUsuarios {
	//SINGLETON
	private HashMap<Usuario, String> usuarios;
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

	public HashMap<Usuario, String> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(HashMap<Usuario, String> usuarios) {
		this.usuarios = usuarios;
	}
	
	

}

