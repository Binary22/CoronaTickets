package datatypesweb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class dataListFunsEspect {
	private Map<String,dataFuncion> funcionesEspect;

	public Map<String,dataFuncion> getFuncionesEspect() {
		return funcionesEspect;
	}

	public void setFuncionesEspect(Map<String,dataFuncion> funcionesEspect) {
		this.funcionesEspect = funcionesEspect;
	}
	
	public dataListFunsEspect() {
		this.funcionesEspect = new HashMap<String,dataFuncion>();
	}
}
