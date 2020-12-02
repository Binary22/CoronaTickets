package logica;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import datatypesweb.dataInfo;

public class HandlerInformacion {
	//SINGLETON
	private List<dataInfo> informacion;
	private String acceso;
	private LocalTime ahora;
	private static HandlerInformacion instancia = null;
	
	private HandlerInformacion() {
		informacion = new ArrayList<dataInfo>();
		acceso = "";
	}
	
	public static HandlerInformacion getInstancia() {
		if (instancia == null)
			instancia = new HandlerInformacion();
		return instancia;
	}


	public void agregarInformacion(dataInfo info) {
		if(!informacion.contains(info))
			informacion.add(info);
	}
	
	public List<dataInfo> obtenerInformacion() {
		return informacion;
	}

	public String getAcceso() {
		return acceso;
	}

	public void setAcceso(String acceso) {
		
		this.acceso = acceso;
	}

	public LocalTime getAhora() {
		return ahora;
	}

	public void setAhora(LocalTime ahora) {
		this.ahora = ahora;
	}
}