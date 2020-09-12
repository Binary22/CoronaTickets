package logica;

import java.util.HashMap;
import java.util.ArrayList;


public class HandlerUsuarios {
	//SINGLETON
	private HashMap<String, Usuario> usuarios;
	private static HandlerUsuarios instancia = null;
	
	private HandlerUsuarios() {
		usuarios = new HashMap<String, Usuario>();
	}
	
	public Boolean existeUsuario(String nick) {
		return usuarios.containsKey(nick);
	}
	
	public static HandlerUsuarios getInstancia() {
		if(instancia == null)
			instancia = new HandlerUsuarios();
		return instancia;
	}
	public ArrayList<String> getNombres(){
		ArrayList<String> list= new ArrayList<String>(usuarios.size());
		for (String key : usuarios.keySet()) {
			list.add(usuarios.get(key).getNickname());
			}
		return list;
	}
	
	public ArrayList<String> getNombresArtistas(){
		ArrayList<String> list= new ArrayList<String>(usuarios.size());
		for (String key : usuarios.keySet()) {
			if(usuarios.get(key).esArtista()) {
				list.add(usuarios.get(key).getNickname());
			}
		}
		return list;
	}
	public Usuario getUsuario(String nickname) {
		return usuarios.get(nickname);
	}
	public ArrayList<Artista> getArtistasInvitados(ArrayList<String> invitados){
		return null;
	}
	public void agregarUsuario(Usuario u) {
		usuarios.put(u.getNickname(), u);
	}

	public HashMap<String, Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(HashMap<String, Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public boolean esArtista_(String nickname) {
		Usuario u = usuarios.get(nickname);
		return u.esArtista_();
	}
	
	

}

