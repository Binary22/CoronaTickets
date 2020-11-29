
package logica;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dataVale complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dataVale">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ident" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="paquete" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dtoPaquete" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="espectaculo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "ident",
    "paquete",
    "dtoPaquete",
    "espectaculo",
    "usado"
})
public class DataVale {

    protected int ident;
    protected String paquete;
    protected int dtoPaquete;
    protected String espectaculo;
    protected boolean usado;

    /**
     * Obtiene el valor de la propiedad ident.
     * 
     */
    public int getIdent() {
        return ident;
    }

    /**
     * Define el valor de la propiedad ident.
     * 
     */
    public void setIdent(int value) {
        this.ident = value;
    }

    /**
     * Obtiene el valor de la propiedad paquete.
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
     * Define el valor de la propiedad paquete.
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
     * Obtiene el valor de la propiedad dtoPaquete.
     * 
     */
    public int getDtoPaquete() {
        return dtoPaquete;
    }

    /**
     * Define el valor de la propiedad dtoPaquete.
     * 
     */
    public void setDtoPaquete(int value) {
        this.dtoPaquete = value;
    }

    /**
     * Obtiene el valor de la propiedad espectaculo.
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
     * Define el valor de la propiedad espectaculo.
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
     * Obtiene el valor de la propiedad usado.
     * 
     */
    public boolean isUsado() {
        return usado;
    }

    /**
     * Define el valor de la propiedad usado.
     * 
     */
    public void setUsado(boolean value) {
        this.usado = value;
    }

}
