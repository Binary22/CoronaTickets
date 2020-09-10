package logica;

import datatypes.DtUsuario;
import java.util.Date;
import java.util.ArrayList;

public interface IUsuario {
	
	public abstract void altaUsuario(String nickname,String nombre,String apellido,String mail, Date fechanac);
	
	public abstract void altaArtista(String desc,String bio, String web);
	
	public abstract void confirmarAltaUsuario();
	
	public abstract ArrayList<String> mostrarUsuarios();
	
	public abstract DtUsuario mostrarDatos(String nickname);
	
	public abstract void updateUsuario(String nombre,String apellido,Date fechaNac);
	
	public abstract void updateArtista(String nombre,String apellido,Date fechaNac,String desc,String bio,String web);

	public abstract void confirmarUpdateUsuario();

}






