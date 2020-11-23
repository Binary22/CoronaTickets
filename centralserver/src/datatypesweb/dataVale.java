package datatypesweb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import logica.Vale;
@XmlAccessorType(XmlAccessType.FIELD)
public class dataVale {
	private int ident;
	private String paquete;
	private int dtoPaquete;
	private String espectaculo;
	private boolean usado;
	
	
	public dataVale(Vale vale) {
		super();
		this.usado = vale.isUsado();
		this.paquete = vale.getPaquete().getNombre();
		this.espectaculo = vale.getEspectaculo().getNombre();
		this.ident = vale.getId();
		this.dtoPaquete = vale.getPaquete().getDescuento();
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

	public int getDtoPaquete() {
		return dtoPaquete;
	}

	public void setDtoPaquete(int dtoPaquete) {
		this.dtoPaquete = dtoPaquete;
	}

	

	
	
	
}
