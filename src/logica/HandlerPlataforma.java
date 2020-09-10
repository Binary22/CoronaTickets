package logica;

import java.util.ArrayList;

public class HandlerPlataforma {
	private ArrayList<String> colNomPlataforma;
	private ArrayList<Plataforma> colPlataforma;
	
	private ArrayList<String> getNombres() {
		return colNomPlataforma;
	}
	private Plataforma getPlataforma(String nomPlataforma) {
		int i = colNomPlataforma.indexOf(nomPlataforma);
		return colPlataforma.get(i);
	}
	private void agregarPlataforma(Plataforma p) {
		this.colNomPlataforma.add(p.getNombre());
		this.colPlataforma.add(p);
	}
}
