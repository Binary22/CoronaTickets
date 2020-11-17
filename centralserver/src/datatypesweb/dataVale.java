package datatypesweb;

import logica.Vale;

public class dataVale {
	private int ident;
	private String paquete;
	private String espectaculo;
	private boolean usado;
	
	
	public dataVale(Vale vale) {
		super();
		this.usado = vale.isUsado();
		this.paquete = vale.getPaquete().getNombre();
		this.espectaculo = vale.getEspectaculo().getNombre();
		this.ident = vale.getId();
	}
	
	public dataVale() {
		
	}
	
	public int getIdent() {
		return ident;
	}

	public void setIdent(int ident) {
		this.ident = ident;
	}

	public String getPaquete() {
		return paquete;
	}

	public void setPaquete(String paquete) {
		this.paquete = paquete;
	}

	public String getEspectaculo() {
		return espectaculo;
	}

	public void setEspectaculo(String espectaculo) {
		this.espectaculo = espectaculo;
	}

	public boolean isUsado() {
		return usado;
	}

	public void setUsado(boolean usado) {
		this.usado = usado;
	}

	

	
	
	
}
