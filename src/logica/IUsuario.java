package logica;

import datatypes.DtUsuario;
import excepciones.UsuarioConMismoMailException;
import excepciones.UsuarioConMismoNickException;

import java.time.LocalDate;
import java.util.ArrayList;

public interface IUsuario {
	
	public void altaUsuario(String nickname,String nombre,String apellido,String mail, LocalDate fechanac) throws UsuarioConMismoNickException, UsuarioConMismoMailException;
	
	public void altaArtista(String desc,String bio, String web) throws UsuarioConMismoNickException, UsuarioConMismoMailException;
	
	public void confirmarAltaUsuario();
	
	public ArrayList<String> mostrarUsuarios();
		
	public void updateUsuario(String nombre,String apellido,LocalDate fechaNac);
	
	public void updateArtista(String nombre,String apellido,LocalDate fechaNac,String desc,String bio,String web);

	public void confirmarUpdateUsuario();

}






