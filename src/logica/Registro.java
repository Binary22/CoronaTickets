package logica;

import java.util.Date;

public class Registro {
	private Date fecha;
	private boolean canjeado;
	private int id;
	
	private Usuario usuario;
	private Funcion funcion;
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public boolean isCanjeado() {
		return canjeado;
	}
	public void setCanjeado(boolean canjeado) {
		this.canjeado = canjeado;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Funcion getFuncion() {
		return funcion;
	}
	public void setFuncion(Funcion funcion) {
		this.funcion = funcion;
	}
	public Registro(Date fecha, boolean canjeado, int id, Usuario usuario, Funcion funcion) {
		super();
		this.fecha = fecha;
		this.canjeado = canjeado;
		this.id = id;
		this.usuario = usuario;
		this.funcion = funcion;
	}
	
	

}
