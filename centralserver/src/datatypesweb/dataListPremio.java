package datatypesweb;

import java.util.ArrayList;
import java.util.List;

public class dataListPremio {
	private List<dataPremio> premios;

	public List<dataPremio> getPremios() {
		return premios;
	}

	public void setPremios(List<dataPremio> premios) {
		this.premios = premios;
	}
	
	public dataListPremio() {
		this.premios = new ArrayList<dataPremio>();
	}

}
