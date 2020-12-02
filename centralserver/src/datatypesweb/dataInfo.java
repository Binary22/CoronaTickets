package datatypesweb;

public class dataInfo {
	String Ip;
	String URL;
	String Navegador;
	String SO;
	
	public dataInfo(String ip, String url, String navegador, String so){
		this.Ip = ip;
		this.URL = url;
		this.Navegador = navegador;
		this.SO = so;
	}

	public String getIp() {
		return Ip;
	}

	public void setIp(String ip) {
		Ip = ip;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public String getNavegador() {
		return Navegador;
	}

	public void setNavegador(String navegador) {
		Navegador = navegador;
	}

	public String getSO() {
		return SO;
	}

	public void setSO(String sO) {
		SO = sO;
	}
}
