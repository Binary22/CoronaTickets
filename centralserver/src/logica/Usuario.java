package logica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import datatypes.DtArtista;
import datatypes.DtEspectaculo;
import datatypes.DtFuncion;
import datatypes.DtRegistro;
import datatypes.DtUsuario;
import excepciones.UsuarioPaqueteComprado;

public class Usuario {
	private String nickname;
	private String nombre;
	private String apellido;
	private String email;
	private LocalDate fechaNacimiento;
	private List<Compra> compraPaquete;
	private List<Vale> vales;
	private List<Registro> registros;
	private String password;
	private String imagen;
	private List<Usuario> seguidos; // usuarios a los que este usuario sigue
	private List<Usuario> siguiendo; // usuarios que siguen a este usuario
	
	public void agregarSeguido(Usuario usuario) {
		seguidos.add(usuario);
	}
	
	public void agregarSiguiendo(Usuario usuario) {
		siguiendo.add(usuario);
	}
	
	public void quitarSeguido(Usuario usuario) {
		seguidos.remove(usuario);
	}
	
	public void quitarSiguiendo(Usuario usuario) {
		siguiendo.remove(usuario);
	}
		
	public List<Usuario> getSeguidos() {
		return seguidos;
	}

	public List<Usuario> getSiguiendo() {
		return siguiendo;
	}
	
	public void setSeguidos(List<Usuario> seguidos) {
		this.seguidos = seguidos;
	}

	public void setSiguiendo(List<Usuario> siguiendo) {
		this.siguiendo = siguiendo;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public List<Compra> getCompraPaquete() {
		return compraPaquete;
	}
	public void setCompraPaquete(List<Compra> compraPaquete) {
		this.compraPaquete = compraPaquete;
	}
	public List<Vale> getVales() {
		return vales;
	}
	public void setVales(List<Vale> vales) {
		this.vales = vales;
	}
	public List<Registro> getRegistros() {
		return registros;
	}
	public void setRegistros(List<Registro> registros) {
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
	
	public List<DtEspectaculo> obtenerEspectaculosOrganizados(){
		return null;
		
	}
	public List<DtFuncion> obtenerFuncionesRegistradas(){
		return null;
		
	}
	public Espectaculo obtenerEspectaculo(String nomespect) {
		return null;
		
	}
	public Funcion obtenerFuncion(String nomFuncion) {
		return null;
		
	}
	
	List<DtRegistro> getRegistrosPrevios(){
		List<DtRegistro> regsPrevios = new ArrayList<DtRegistro>();
		List<Registro> regs = this.registros;
		//Iterator<Registro> it = regs.iterator();
		for (int i = 0; i < regs.size(); i++) {
			if (!regs.get(i).isCanjeado()) {
				LocalDate fecha = regs.get(i).getFecha();
				int ident = regs.get(i).getId();
				DtRegistro reg = new DtRegistro(fecha, ident);
				regsPrevios.add(reg);
			}
		}
		return regsPrevios;
		
	}
	
	public List<Registro> getRegistrosPreviosWeb(){
		List<Registro> regsPrevios = new ArrayList<Registro>();
		List<Registro> regs = this.registros;
		//Iterator<Registro> it = regs.iterator();
		for (int i = 0; i < regs.size(); i++) {
			if (!regs.get(i).isCanjeado()) {
				regsPrevios.add(regs.get(i));
			}
		}
		return regsPrevios;
		
	}
	public void canjearRegistros(int id1, int id2, int id3) {
		
	}
	
	public boolean tieneRegistroAFuncion(String nomfuncion) {
		List<Registro> regs = this.registros;
		Iterator<Registro> iter = regs.iterator();
		while (iter.hasNext()) {
			String nombreFuncion = iter.next().getFuncion().getNombre();
			if (nombreFuncion.compareTo(nomfuncion)== 0)
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
	
	public void confirmarUpdateUsuario(String nombre, String apellido, LocalDate fechaNac) {
		
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
		this.imagen = "resources/media/usuarios/userdefault.jpg";
		this.seguidos = new ArrayList<Usuario>();
		this.siguiendo = new ArrayList<Usuario>();
		

	}
	
	public Usuario(String nickname, String nombre, String apellido, String email, LocalDate fechaNacimiento, String password, String imagen) {
		super();
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.compraPaquete = new ArrayList<Compra>();
		this.vales = new ArrayList<Vale>();
		this.registros = new ArrayList<Registro>();
		this.password = password;
		if (imagen == "" || imagen == null) {
			imagen = "resources/media/usuarios/userdefault.jpg";
		}
		this.imagen = imagen;
		this.seguidos = new ArrayList<Usuario>();
		this.siguiendo = new ArrayList<Usuario>();
		

	}
	public DtUsuario getDt() {
		DtUsuario ret;
		ret = new DtUsuario(getNickname(), getNombre(), getApellido(), getEmail(), getFechaNacimiento());
		return ret;
	}
	public boolean esArtistaA() {
		return false;
		
	}
	
	public DtArtista getDtArtista() {
		return null;
	}
	
	//esta funcion es para saber si un usuario es artista o no
	public boolean esArtista() {
		return false;
	}
	
	public List<Vale> valesACanjear(String nombreEspect){
		List<Vale> vales = this.vales;
		List<Vale> valesCanjear = new ArrayList<Vale>();
    	for (int i = 0; i < vales.size(); i++) {
    		if (vales.get(i).getEspectaculo().getNombre().compareTo(nombreEspect) == 0 && !vales.get(i).isUsado()) {
    			Paquete paq = vales.get(i).getPaquete();
    			if (LocalDate.now().isBefore(paq.getFechaF())) {
    				valesCanjear.add(vales.get(i));
    					
    			}
    		}
    	}
    	return valesCanjear;
	}
	public void agregarcompra(Compra comprado) throws UsuarioPaqueteComprado {
		if (!this.compraPaquete.contains(comprado)) {
			this.compraPaquete.add(comprado);
			Paquete nuevoPaq = comprado.getPaquete();
			Map<String, Espectaculo> espectPaq = nuevoPaq.getEspectaculos();
			for(String key : espectPaq.keySet()) {
				Vale nuevoVale = new Vale();
				nuevoVale.setEspectaculo(espectPaq.get(key));
				nuevoVale.setPaquete(nuevoPaq);
				this.vales.add(nuevoVale);
			}
		}
		else
			throw new UsuarioPaqueteComprado("La compra " + comprado.getPaquete().getNombre() + " ya fue realizada"); 
	}
	

}
