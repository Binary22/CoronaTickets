
package logica;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dataPremio complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dataPremio">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaSorteado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="funcion" type="{http://logica/}dataFuncion" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dataPremio", propOrder = {
    "descripcion",
    "fechaSorteado",
    "funcion"
})
public class DataPremio {

    protected String descripcion;
    protected String fechaSorteado;
    protected DataFuncion funcion;

    /**
     * Gets the value of the descripcion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Sets the value of the descripcion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcion(String value) {
        this.descripcion = value;
    }

    /**
     * Gets the value of the fechaSorteado property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaSorteado() {
        return fechaSorteado;
    }

    /**
     * Sets the value of the fechaSorteado property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaSorteado(String value) {
        this.fechaSorteado = value;
    }

    /**
     * Gets the value of the funcion property.
     * 
     * @return
     *     possible object is
     *     {@link DataFuncion }
     *     
     */
    public DataFuncion getFuncion() {
        return funcion;
    }

    /**
     * Sets the value of the funcion property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataFuncion }
     *     
     */
    public void setFuncion(DataFuncion value) {
        this.funcion = value;
    }

}
