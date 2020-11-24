package datatypesweb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ListaPaquete {
	private List<dataPaquete> paquete;
    private List<dataPaquete> paquetes;

	public List<dataPaquete> getPaquete() {
		if (paquete == null) {
			this.paquete = new ArrayList<dataPaquete>();
		}
		return paquete;
	}

	public void setPaquete(List<dataPaquete> paquete) {
		this.paquete = paquete;
	}
	

	public List<dataPaquete> getPaquetes() {
		if (paquetes == null) {
			paquetes = new ArrayList<dataPaquete>();
		}
		return paquetes;
	}

	public void setPaquetes(List<dataPaquete> paquetes) {
		this.paquetes = paquetes;
	}
}
