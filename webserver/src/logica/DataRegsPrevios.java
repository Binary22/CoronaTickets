
package logica;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dataRegsPrevios complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dataRegsPrevios">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="regsPrevios" type="{http://logica/}dataRegistro" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dataRegsPrevios", propOrder = {
    "regsPrevios"
})
public class DataRegsPrevios {

    @XmlElement(nillable = true)
    protected List<DataRegistro> regsPrevios;

    /**
     * Gets the value of the regsPrevios property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the regsPrevios property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRegsPrevios().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataRegistro }
     * 
     * 
     */
    public List<DataRegistro> getRegsPrevios() {
        if (regsPrevios == null) {
            regsPrevios = new ArrayList<DataRegistro>();
        }
        return this.regsPrevios;
    }

}
