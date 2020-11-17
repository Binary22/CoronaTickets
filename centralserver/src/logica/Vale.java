package logica;

public class Vale {
	private int ident;
	private Paquete paquete;
	private Espectaculo espectaculo;
	private boolean usado;
	private static int seed = 0;

	public Vale() {
		super();
		this.ident = ++seed;
		this.usado = false;
	}

	public int getId() {
		return ident;
	}

	public void setId(int ident) {
		this.ident = ident;
	}

	public Paquete getPaquete() {
		return paquete;
	}

	public void setPaquete(Paquete paquete) {
		this.paquete = paquete;
	}

	public Espectaculo getEspectaculo() {
		return espectaculo;
	}

	public void setEspectaculo(Espectaculo espectaculo) {
		this.espectaculo = espectaculo;
	}

	public boolean isUsado() {
		return usado;
	}

	public void setUsado(boolean usado) {
		this.usado = usado;
	}

}
