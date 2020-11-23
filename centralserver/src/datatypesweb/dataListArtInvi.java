package datatypesweb;



import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class dataListArtInvi {
	private List<String> artistasInvi = new ArrayList<String>();
	
	public dataListArtInvi() {
	}

	public List<String> getArtistasInvi() {
		return artistasInvi;
	}

	public void setArtistasInvi(List<String> artistasInvi) {
		this.artistasInvi = artistasInvi;
	}
}
