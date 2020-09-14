package logica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import datatypes.DtArtista;
import datatypes.DtEspectaculo;
import datatypes.DtFuncion;
import datatypes.DtRegistro;
import datatypes.DtUsuario;

public class Usuario {
	private String nickname;
	private String nombre;
	private String apellido;
	private String email;
	private LocalDate fechaNacimiento;
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
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	//operaciones de la clase
	
	public ArrayList<DtEspectaculo> obtenerEspectaculosOrganizados(){
		return null;
		
	}
	public ArrayList<DtFuncion> obtenerFuncionesRegistradas(){
		return null;
		
	}
	public Espectaculo obtenerEspectaculo(String nomespect) {
		return null;
		
	}
	public Funcion obtenerFuncion(String nomFuncion) {
		return null;
		
	}
	
	ArrayList<DtRegistro> getRegistrosPrevios(){
		ArrayList<DtRegistro> regsPrevios = new ArrayList<DtRegistro>();
		ArrayList<Registro> regs = this.registros;
		Iterator<Registro> it = regs.iterator();
		while(it.hasNext()) {
			Registro temp = it.next();
			if(!temp.isCanjeado()) {
				LocalDate fecha = temp.getFecha();
				int id = temp.getId();
				DtRegistro reg = new DtRegistro(fecha, id);
				regsPrevios.add(reg);
			}
			
		}
		return regsPrevios;
		
	}
	public void canjearRegistros(int id1,int id2,int id3) {
		
	}
	
	public boolean tieneRegistroAFuncion(String nomfuncion) {
		ArrayList<Registro> regs = this.registros;
		Iterator<Registro> it = regs.iterator();
		while(it.hasNext()) {
			String nombreFuncion = it.next().getFuncion().getNombre();
			if(nombreFuncion.compareTo(nomfuncion)== 0)
				return true;
		}
		return false;
	}
	
	public boolean llegoLimiteFuncion(String nomfuncion) {
		return false;
		
	}
	
	public void addFuncion(Registro reg) {
		this.registros.add(reg);
	}
	
	public void confirmarUpdateUsuario(String nombre,String apellido,LocalDate fechaNac) {
		
	}
	public Usuario(String nickname, String nombre, String apellido, String email, LocalDate fechaNacimiento) {
		super();
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.compraPaquete = new ArrayList<Compra>();
		this.vales = new ArrayList<Vale>();
		this.registros = new ArrayList<Registro>();		

	}
	public DtUsuario getDt() {
		DtUsuario ret;
		ret = new DtUsuario(getNickname(), getNombre(), getApellido(), getEmail(), getFechaNacimiento());
		return ret;
	}
	public boolean esArtista_() {
		return false;
		
	}
	
	public DtArtista getDtArtista() {
		return null;
	}
	
	//esta funcion es para saber si un usuario es artista o no
	public boolean esArtista() {
		return false;
	}
	

}
