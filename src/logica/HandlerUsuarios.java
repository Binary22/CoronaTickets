package logica;

import java.util.HashMap;
import java.util.ArrayList;


public class HandlerUsuarios {
	//SINGLETON
	private HashMap<String, Usuario> usuarios;
	private HashMap<String, Usuario> artistas; //por ende se crea esto
	private static HandlerUsuarios instancia = null;
	
	private HandlerUsuarios() {
		
	}
	
	public static HandlerUsuarios getInstancia() {
		if(instancia == null)
			instancia = new HandlerUsuarios();
		return instancia;
	}
	public ArrayList<String> getNombres(){
		ArrayList<String> list = new ArrayList<String>(artistas.keySet());; //Necesito esto, ya que si tengo usuarios, como distingo cuales son artistas en el mapa?
		return list;
	}
	public Usuario getUsuario(String nickname) {
		return usuarios.get(nickname);
	}
	public ArrayList<Artista> getArtistasInvitados(ArrayList<String> invitados){
		return null;
	}
	public void agregarUsuario(Usuario u) {
		
	}
	
	public void agregarArtista(Artista a) {
		
	}
	
	public HashMap<String, Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(HashMap<String, Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	

}

