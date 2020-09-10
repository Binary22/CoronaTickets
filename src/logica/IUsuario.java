package logica;

import datatypes.DtUsuario;
import java.time.LocalDate;
import java.util.ArrayList;

public interface IUsuario {
	
	public void altaUsuario(String nickname,String nombre,String apellido,String mail, LocalDate fechanac);
	
	public void altaArtista(String desc,String bio, String web);
	
	public void confirmarAltaUsuario();
	
	public ArrayList<String> mostrarUsuarios();
	
	public DtUsuario mostrarDatos(String nickname);
	
	public void updateUsuario(String nombre,String apellido,LocalDate fechaNac);
	
	public void updateArtista(String nombre,String apellido,LocalDate fechaNac,String desc,String bio,String web);

	public void confirmarUpdateUsuario();

}






