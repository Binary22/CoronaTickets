package logica;

import java.time.LocalDate;

public class Registro {
	private LocalDate fecha;
	private boolean yaFueCanjeado;
	private int id;
	private Registro[] regsCanjeados;
	private float costo;
	private static int seed = 1;
	
	private Usuario usuario;
	private Funcion funcion;
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public boolean isCanjeado() {
		return yaFueCanjeado;
	}
	public void setCanjeado(boolean canjeado) {
		this.yaFueCanjeado = canjeado;
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
	public Registro(LocalDate fecha, boolean canjeado, Usuario usuario, Funcion funcion, float costo) {
		super();
		this.fecha = fecha;
		this.yaFueCanjeado = canjeado;
		this.id = seed++;
		this.usuario = usuario;
		this.funcion = funcion;
		this.regsCanjeados = new Registro[3];
		this.costo = costo;
	}
	public float getCosto() {
		return costo;
	}
	public void setCosto(float costo) {
		this.costo = costo;
	}
	public Registro[] getRegsCanjeados() {
		return regsCanjeados;
	}
	public void setRegsCanjeados(Registro[] regsCanjeados) {
		this.regsCanjeados = regsCanjeados;
	}
	
	

}
