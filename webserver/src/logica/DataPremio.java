
package logica;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dataPremio complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dataPremio">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaSorteado" type="{http://logica/}localDate" minOccurs="0"/>
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
    protected LocalDate fechaSorteado;
    protected DataFuncion funcion;

    /**
     * Obtiene el valor de la propiedad descripcion.
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
     * Define el valor de la propiedad descripcion.
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
     * Obtiene el valor de la propiedad fechaSorteado.
     * 
     * @return
     *     possible object is
     *     {@link LocalDate }
     *     
     */
    public LocalDate getFechaSorteado() {
        return fechaSorteado;
    }

    /**
     * Define el valor de la propiedad fechaSorteado.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalDate }
     *     
     */
    public void setFechaSorteado(LocalDate value) {
        this.fechaSorteado = value;
    }

    /**
     * Obtiene el valor de la propiedad funcion.
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
     * Define el valor de la propiedad funcion.
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
