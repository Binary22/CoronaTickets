package logica;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import excepciones.YaVotoException;

public class Espectaculo {
	private String nombre;
	private String descripcion;
	private String url;
	private int minEspectadores;
	private int maxEspectadores;
	private float costo;
	private LocalTime duracion;
	private LocalDate fechaReg;
	private Plataforma plataforma;
	private Artista artista;
	private Map<String, Funcion> setFunciones;
	private boolean yaFueValuado;
	private boolean aceptado;
	private boolean finalizado;
	private String imagen;
	private String video;
	private List<String> categorias;
	private List<Integer> puntajes;
	private List<String> votantes;
	private String descPremio;
	private int cantPremios;
	private String videoUrl;
	
	public String getImagen() {
		return imagen;
	}

	public void setYaFueValuado(boolean yaFueValuado) {
		this.yaFueValuado = yaFueValuado;
	}
	
	public int getPromedio() {
		if (puntajes.isEmpty() || puntajes == null) {
			return -1;
		} else {
			int res = 0;
			for (int i : puntajes) {
				res += i;
			}
			return (res / puntajes.size());
		}
	}
	
	public void agregarValoracion(int valoracion, String user) throws YaVotoException {
		if (puntajes == null) {
			puntajes = new ArrayList<Integer>();
		}
		if (getVotantes().contains(user)) {
			throw new YaVotoException("El usuario ya valoro este espectaculo");
		}
		votantes.add(user);
		puntajes.add(valoracion);
	}

	public void setAceptado(boolean aceptado) {
		this.aceptado = aceptado;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	public List<String> listarCategorias() {
		if (this.categorias == null) {
			this.categorias = new ArrayList<String>();
		}
		
		return this.categorias;
	}
	
	public Espectaculo(String nombre, LocalTime duracion, String descripcion, int minEspectadores, int maxEspectadores,
			String url, LocalDate fechaReg, float costo) {
		this.nombre = nombre;
		this.duracion = duracion;
		this.descripcion = descripcion;
		this.minEspectadores = minEspectadores;
		this.maxEspectadores = maxEspectadores;
		this.url = url;
		this.fechaReg = fechaReg;
		this.costo = costo;
		this.setFunciones = new HashMap<String, Funcion>();
		this.yaFueValuado = false;
		this.aceptado = false;
		this.categorias = new ArrayList<String>();
		this.imagen = "resources/media/espectaculos/rock.jpg";
		HandlerUsuarios husers = HandlerUsuarios.getInstancia();
	}
	
	public Espectaculo(String nombre, LocalTime duracion, String descripcion, int minEspectadores, int maxEspectadores,
			String url, LocalDate fechaReg, float costo, String imagen, List<String> categs) {
		this.nombre = nombre;
		this.duracion = duracion;
		this.descripcion = descripcion;
		this.minEspectadores = minEspectadores;
		this.maxEspectadores = maxEspectadores;
		this.url = url;
		this.fechaReg = fechaReg;
		this.costo = costo;
		this.setFunciones = new HashMap<String, Funcion>();
		this.yaFueValuado = false;
		this.aceptado = false;
		if (imagen == "" || imagen == null) {
			this.imagen = "resources/media/espectaculos/rock.jpg";
		} else {
			this.imagen = imagen;
		}
		this.categorias = categs;
	}
	
	public Espectaculo(String nombre, LocalTime duracion, String descripcion, int minEspectadores, int maxEspectadores,
			String url, LocalDate fechaReg, float costo, String imagen, List<String> categs, String video, String descPremio, int cantPremios) {
		this.nombre = nombre;
		this.duracion = duracion;
		this.descripcion = descripcion;
		this.minEspectadores = minEspectadores;
		this.maxEspectadores = maxEspectadores;
		this.url = url;
		this.fechaReg = fechaReg;
		this.costo = costo;
		this.setFunciones = new HashMap<String, Funcion>();
		this.yaFueValuado = false;
		this.aceptado = false;
		if (imagen == "" || imagen == null) {
			this.imagen = "resources/media/espectaculos/rock.jpg";
		} else {
			this.imagen = imagen;
		}
		this.categorias = categs;
		this.video = video;
		this.descPremio = descPremio;
		this.cantPremios = cantPremios;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalTime getDuracion() {
		return duracion;
	}
	public void setDuracion(LocalTime duracion) {
		this.duracion = duracion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getMinEspectadores() {
		return minEspectadores;
	}
	public void setMinEspectadores(int minEspectadores) {
		this.minEspectadores = minEspectadores;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public LocalDate getFechaReg() {
		return fechaReg;
	}
	public void setFechaReg(LocalDate fechaReg) {
		this.fechaReg = fechaReg;
	}
	public Plataforma getPlataforma() {
		return plataforma;
	}
	public void setPlataforma(Plataforma plataforma) {
		this.plataforma = plataforma;
	}
	public Artista getArtista() {
		return artista;
	}
	public void setArtista(Artista artista) {
		artista.agregarEspectaculo(this);
		this.artista = artista;

	}
	public float getCosto() {
		return costo;
	}
	public void setCosto(float costo) {
		this.costo = costo;
	}
	public void setMaxEspectadores(int maxEspectadores) {
		this.maxEspectadores = maxEspectadores;
	}
	
	public Map<String, Funcion> getAllFunciones() {
		return setFunciones;
	}
	public Funcion getFuncion(String nomfuncion) {
		return setFunciones.get(nomfuncion);
	}
	public void agregarFuncion(Funcion fun) {
		this.setFunciones.put(fun.getNombre(), fun);
	}
	public int getMaxEspectadores() {
		return this.maxEspectadores;
	}

	public boolean isYaFueValuado() {
		return yaFueValuado;
	}

	public boolean isAceptado() {
		return aceptado;
	}
	
	public void addCategoria(String cat) {
		categorias.add(cat);
	}

	public boolean isFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public String getDescPremio() {
		return descPremio;
	}

	public void setDescPremio(String descPremio) {
		this.descPremio = descPremio;
	}

	public int getCantPremios() {
		return cantPremios;
	}

	public void setCantPremios(int cantPremios) {
		this.cantPremios = cantPremios;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public List<Integer> getPuntajes() {
		if (puntajes == null) {
			return new ArrayList<Integer>();
		}
		return puntajes;
	}

	public List<String> getVotantes() {
		if (votantes == null) {
			votantes = new ArrayList<String>();
		}
		return votantes;
	}
	
	public void setVotantes(List<String> votantes) {
		this.votantes = votantes;
	}
}
