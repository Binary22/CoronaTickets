package datatypesweb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ListaUsuario {
	private List<dataUsuario> usuarios;

	public List<dataUsuario> getUsuarios() {
		if (usuarios == null) {
			this.usuarios = new ArrayList<dataUsuario>();
		}
		return usuarios;
	}

	public void setUsuarios(List<dataUsuario> usuarios) {
		this.usuarios = usuarios;
	}
}
