package logica;

import java.util.Date;

public class Usuario {
	private String nickname;
	private String nombre;
	private String apellido;
	private String email;
	private Date fechaNacimiento;
	
	private ArrayList<Compra> compraPaquete;
	private ArrayList<Vale> vales;
	private ArrayList<Registro> registros;
	
	
	
	public ArrayList<Compra> getCompraPaquete() {
		return compraPaquete;
	}
	public void setCompraPaquete(ArrayList<Compra> compraPaquete) {
		this.compraPaquete = compraPaquete;
	}
	public ArrayList<Vale> getVales() {
		return vales;
	}
	public void setVales(ArrayList<Vale> vales) {
		this.vales = vales;
	}
	public ArrayList<Registro> getRegistros() {
		return registros;
	}
	public void setRegistros(ArrayList<Registro> registros) {
		this.registros = registros;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	//operaciones de la clase
	
	public ArrayLista<DtEspectaculo> obtenerEspectaculosOrganizados(){
		
	}
	public ArrayLista<DtFuncion> obtenerFuncionesRegistradas(){
		
	}
	public Espectaculo obtenerEspectaculo(String nomespect) {
		
	}
	public Funcion obtenerFuncion(String nomFuncion) {
		
	}
	
	ArrayLista<DtRegistro> getRegistrosPrevios(){
		
	}
	public void canjearRegistros(int id1,int id2,int id3) {
		
	}
	
	public boolean tieneRegistroAFuncion(String nomfuncion) {
		
	}
	
	public boolean llegoLimiteFuncion(String nomfuncion) {
		
	}
	
	public void addFuncion(Registro reg) {
		
	}
	
	public void confirmarUpdateUsuario(String nombre,String apellido,Date fechaNac) {
		
	}
	public Usuario(String nickname, String nombre, String apellido, String email, Date fechaNacimiento) {
		super();
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
	}
	

}
