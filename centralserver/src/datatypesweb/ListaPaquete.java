package datatypesweb;

import java.util.ArrayList;
import java.util.List;

public class ListaPaquete {
	private List<dataPaquete> paquetes;

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
