package datatypesweb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
@XmlAccessorType(XmlAccessType.FIELD)
public class ListaInfo {
	public ListaInfo(){
		
	}
	private List<dataInfo> informacion;

	public List<dataInfo> getInformacion() {
		if (informacion == null) {
			this.informacion = new ArrayList<dataInfo>();
		}
		return informacion;
	}

	public void setinformacion(List<dataInfo> informacion) {
		this.informacion = informacion;
	}
}
