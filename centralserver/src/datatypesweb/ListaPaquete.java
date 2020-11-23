package datatypesweb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ListaPaquete {
	private List<dataPaquete> paquete;

	public List<dataPaquete> getPaquete() {
		if (paquete == null) {
			this.paquete = new ArrayList<dataPaquete>();
		}
		return paquete;
	}

	public void setPaquete(List<dataPaquete> paquete) {
		this.paquete = paquete;
	}
}
