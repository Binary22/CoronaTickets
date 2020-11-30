package datatypesweb;

import java.time.LocalDate;

import logica.Funcion;
import logica.Premio;

public class dataPremio {
	private String fechaSorteado;
	private dataFuncion funcion;
	private String descripcion;
	
	
	public dataPremio(Premio premio) {
			this.fechaSorteado = premio.getFechaSorteado().toString();
			this.funcion = new dataFuncion(premio.getFuncion());
			this.descripcion = premio.getDescripcion();
			
		}
	
	public dataPremio() {
		
		
	}
	public String getFechaSorteado() {
		return fechaSorteado;
	}
	public void setFechaSorteado(String fechaSorteado) {
		this.fechaSorteado = fechaSorteado;
	}
	public dataFuncion getFuncion() {
		return funcion;
	}
	public void setFuncion(dataFuncion funcion) {
		this.funcion = funcion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
