package datatypesweb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;



@XmlAccessorType(XmlAccessType.FIELD)
public class dataListPaquetes {
	private List<String> paquetes = new ArrayList<String>();
	
	public dataListPaquetes() {
	}

	public List<String> getPaquetes() {
		return paquetes;
	}

	public void setPaquetes(List<String> paquetes) {
		this.paquetes = paquetes;
	}
}
