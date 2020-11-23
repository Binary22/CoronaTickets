package datatypesweb;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import logica.Registro;

@XmlAccessorType(XmlAccessType.FIELD)
public class dataRegistro {
	private LocalDate fecha;
	private boolean yaFueCanjeado;
	private int ident;
	private int[] regsCanjeados;
	private float costo;
	private String usuario;
	private String funcion;
	private String espectFuncion;
	
	public dataRegistro(Registro reg) {
		this.fecha = reg.getFecha();
		this.yaFueCanjeado = reg.isCanjeado();
		this.ident = reg.getId();
		this.costo = reg.getCosto();
		this.regsCanjeados = new int[3];
		if(this.yaFueCanjeado && this.costo == 0) {
			this.regsCanjeados[0] = reg.getRegsCanjeados()[0].getId();
			this.regsCanjeados[1] = reg.getRegsCanjeados()[1].getId();
			this.regsCanjeados[2] = reg.getRegsCanjeados()[2].getId();
		}
		
		this.usuario = reg.getUsuario().getNickname();
		this.funcion = reg.getFuncion().getNombre();
		this.espectFuncion = reg.getFuncion().getEspectaculo().getNombre();
	}
	
	public dataRegistro() {
		
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public boolean isYaFueCanjeado() {
		return yaFueCanjeado;
	}

	public void setYaFueCanjeado(boolean yaFueCanjeado) {
		this.yaFueCanjeado = yaFueCanjeado;
	}

	public int getIdent() {
		return ident;
	}

	public void setIdent(int ident) {
		this.ident = ident;
	}

	public int[] getRegsCanjeados() {
		return regsCanjeados;
	}

	public void setRegsCanjeados(int[] regsCanjeados) {
		this.regsCanjeados = regsCanjeados;
	}

	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}

	

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getFuncion() {
		return funcion;
	}

	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}

	public String getEspectFuncion() {
		return espectFuncion;
	}

	public void setEspectFuncion(String espectFuncion) {
		this.espectFuncion = espectFuncion;
	}

}
