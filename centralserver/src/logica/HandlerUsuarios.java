package logica;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import datatypes.DtFuncion;

import java.util.ArrayList;


public class HandlerUsuarios {
	//SINGLETON
	private Map<String, Usuario> usuarios;
	private static HandlerUsuarios instancia = null;
	
	private HandlerUsuarios() {
		usuarios = new HashMap<String, Usuario>();
	}
	
	public Boolean existeUsuario(String nick) {
		return usuarios.containsKey(nick);
	}
	
	public static HandlerUsuarios getInstancia() {
		if (instancia == null)
			instancia = new HandlerUsuarios();
		return instancia;
	}
	
	public List<String> getNombres(){
		return new ArrayList<String>(usuarios.keySet());
	}
	
	public List<String> getNombresArtista(){
		List<String> list= new ArrayList<String>(usuarios.size());
		for (String key : usuarios.keySet()) {
			list.add(usuarios.get(key).getNickname());
			}
		return list;
	}
	
	public List<String> getNombresArtistas(){
		List<String> list= new ArrayList<String>(usuarios.size());
		for (String key : usuarios.keySet()) {
			if (usuarios.get(key).esArtista()) {
				list.add(usuarios.get(key).getNickname());
			}
		}
		return list;
	}
	
	public Usuario getUsuario(String nickname) {
		return usuarios.get(nickname);
	}
	public List<Artista> getArtistasInvitados(List<String> invitados){
		return null;
	}
	public void agregarUsuario(Usuario user) {
		usuarios.put(user.getNickname(), user);
	}

	public Map<String, Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Map<String, Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public boolean esArtistaA(String nickname) {
		Usuario user = usuarios.get(nickname);
		return user.esArtistaA();
	}

	public List<String> listarFuncionesQueSeRegistro(String nickname) {
		Usuario user = usuarios.get(nickname);
		List<Registro>  listareg = user.getRegistros();
		List<String> ret = new ArrayList<String>();
		for (int i = 0; i < listareg.size(); i++) {
			ret.add(listareg.get(i).getFuncion().getNombre());
		}
		return ret;
	}

	public List<DtFuncion> listarFuncionesDtQueSeRegistro(String nickname) {
		Usuario user = usuarios.get(nickname);
		List<Registro>  listareg = user.getRegistros();
		List<DtFuncion> ret = new ArrayList<DtFuncion>();
		for (int i = 0; i < listareg.size(); i++) {
			ret.add(listareg.get(i).getFuncion().getDt());
		}
		return ret;
	}
	
	public boolean existeMail(String mail){
		for (String key : usuarios.keySet()) {
			if (usuarios.get(key).getEmail().compareTo(mail) == 0) {
				return true;
			}
		}
		return false;
	}

	public void rempazar(String nick, Usuario user) {
		if(user.getImagen().equals("resources/media/usuarios/userdefault.jpg") || user.getImagen().equals("resources/media/usuarios/artistadefault.jpg") ) {
			
		}
		
	}
	
	

}

