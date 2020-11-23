package datatypesweb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;


@XmlAccessorType(XmlAccessType.FIELD)
public class dataListEspOrg {
	private List<String> espectaculosOrg = new ArrayList<String>();
	
	public dataListEspOrg() {
	}

	public List<String> getEspectaculosOrg() {
		return espectaculosOrg;
	}

	public void setEspectaculosOrg(List<String> espectaculosOrg) {
		this.espectaculosOrg = espectaculosOrg;
	}
}
