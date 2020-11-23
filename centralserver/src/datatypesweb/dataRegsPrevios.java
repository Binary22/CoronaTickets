package datatypesweb;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
@XmlAccessorType(XmlAccessType.FIELD)
public class dataRegsPrevios {
	private List<dataRegistro> regsPrevios;

	public List<dataRegistro> getRegsPrevios() {
		return regsPrevios;
	}

	public void setRegsPrevios(List<dataRegistro> regsPrevios) {
		this.regsPrevios = regsPrevios;
	}
	
	public dataRegsPrevios() {
		
	}
}
