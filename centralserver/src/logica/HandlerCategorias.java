package logica;

import java.util.HashMap;

public class HandlerCategorias {
	private HashMap<String, Categoria> categorias;
	private static HandlerCategorias instancia = null;
	
	private HandlerCategorias() {
    	setCategorias(new HashMap<String, Categoria>());
    };
	
    public static HandlerCategorias getInstance() {
        if (instancia == null) {
            instancia = new HandlerCategorias();
        }
        return instancia;
    }

	public HashMap<String, Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(HashMap<String, Categoria> categorias) {
		this.categorias = categorias;
	}
	
	public boolean existeCategoria(String nombre) {
		if(this.categorias.containsKey(nombre))
			return true;
		return false;
	}
	
	public void agregarCategoria(String nombre) {
		Categoria nuevacat = new Categoria(nombre);
		categorias.put(nombre, nuevacat);
	}

}
