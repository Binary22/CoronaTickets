
package logica;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dataInfo complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dataInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ip" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="navegador" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="URL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dataInfo", propOrder = {
    "ip",
    "navegador",
    "so",
    "url"
})
public class DataInfo {

    protected String ip;
    protected String navegador;
    @XmlElement(name = "SO")
    protected String so;
    @XmlElement(name = "URL")
    protected String url;

    /**
     * Obtiene el valor de la propiedad ip.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIp() {
        return ip;
    }

    /**
     * Define el valor de la propiedad ip.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIp(String value) {
        this.ip = value;
    }

    /**
     * Obtiene el valor de la propiedad navegador.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNavegador() {
        return navegador;
    }

    /**
     * Define el valor de la propiedad navegador.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNavegador(String value) {
        this.navegador = value;
    }

    /**
     * Obtiene el valor de la propiedad so.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSO() {
        return so;
    }

    /**
     * Define el valor de la propiedad so.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSO(String value) {
        this.so = value;
    }

    /**
     * Obtiene el valor de la propiedad url.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getURL() {
        return url;
    }

    /**
     * Define el valor de la propiedad url.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setURL(String value) {
        this.url = value;
    }

}
