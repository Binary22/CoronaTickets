package logica;

import java.util.HashMap;

import datatypes.DtFuncion;

import java.time.LocalDate;
import java.util.ArrayList;


public class HandlerUsuarios {
	//SINGLETON
	private HashMap<String, Usuario> usuarios;
	private static HandlerUsuarios instancia = null;
	
	private HandlerUsuarios() {
		usuarios = new HashMap<String, Usuario>();
		Usuario u1 = new Usuario("carlos1", "Carlos", "Garcia", "carlosgarcia@gmail.com", LocalDate.now());
		Usuario u2 = new Usuario("waston", "Carlos2", "Garcia2", "carlosgarcia@gmail.com", LocalDate.now(), "mkji648", "hola");
		Usuario u3 = new Artista("lospimpi", "Carlos3", "Garcia3", "carlosgarcia@gmail.com", LocalDate.now(),"hola", "hola", "hola", "jhvf395", "hola");
		Usuario u4 = new Usuario("carlos4", "Carlos4", "Garcia4", "carlosgarcia@gmail.com", LocalDate.now());
		usuarios.put(u1.getNickname(), u1);
		usuarios.put(u2.getNickname(), u2);
		usuarios.put(u3.getNickname(), u3);
		usuarios.put(u4.getNickname(), u4);
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
		return new ArrayList<String>(usuarios.keySet());
	}
	
	public ArrayList<String> getNombresArtista(){
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

	public ArrayList<String> listarFuncionesQueSeRegistro(String nickname) {
		Usuario u = usuarios.get(nickname);
		ArrayList<Registro>  listareg = u.getRegistros();
		ArrayList<String> ret = new ArrayList<String>();
		for (int i = 0; i < listareg.size(); i++) {
			ret.add(listareg.get(i).getFuncion().getNombre());
		}
		return ret;
	}

	public ArrayList<DtFuncion> listarFuncionesDtQueSeRegistro(String nickname) {
		Usuario u = usuarios.get(nickname);
		ArrayList<Registro>  listareg = u.getRegistros();
		ArrayList<DtFuncion> ret = new ArrayList<DtFuncion>();
		for (int i = 0; i < listareg.size(); i++) {
			ret.add(listareg.get(i).getFuncion().getDt());
		}
		return ret;
	}
	
	public boolean existeMail(String mail){
		for (String key : usuarios.keySet()) {
			if(usuarios.get(key).getEmail().compareTo(mail) == 0) {
				return true;
			}
		}
		return false;
	}

	public void rempazar(String nick, Usuario u) {
		this.usuarios.put(nick, u);
	}
	
	

}

