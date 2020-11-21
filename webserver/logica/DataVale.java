
package logica;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dataVale complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dataVale">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="espectaculo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ident" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="paquete" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="usado" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dataVale", propOrder = {
    "espectaculo",
    "ident",
    "paquete",
    "usado"
})
public class DataVale {

    protected String espectaculo;
    protected int ident;
    protected String paquete;
    protected boolean usado;

    /**
     * Gets the value of the espectaculo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEspectaculo() {
        return espectaculo;
    }

    /**
     * Sets the value of the espectaculo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEspectaculo(String value) {
        this.espectaculo = value;
    }

    /**
     * Gets the value of the ident property.
     * 
     */
    public int getIdent() {
        return ident;
    }

    /**
     * Sets the value of the ident property.
     * 
     */
    public void setIdent(int value) {
        this.ident = value;
    }

    /**
     * Gets the value of the paquete property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaquete() {
        return paquete;
    }

    /**
     * Sets the value of the paquete property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaquete(String value) {
        this.paquete = value;
    }

    /**
     * Gets the value of the usado property.
     * 
     */
    public boolean isUsado() {
        return usado;
    }

    /**
     * Sets the value of the usado property.
     * 
     */
    public void setUsado(boolean value) {
        this.usado = value;
    }

}
