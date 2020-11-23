package datatypesweb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;


@XmlAccessorType(XmlAccessType.FIELD)
public class dataListPlataformas {
	private List<String> plataformas = new ArrayList<String>();
	
	public dataListPlataformas() {
	}

	public List<String> getPlataformas() {
		return plataformas;
	}

	public void setPlataformas(List<String> plataformas) {
		this.plataformas = plataformas;
	}
}

