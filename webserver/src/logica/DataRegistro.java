
package logica;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dataRegistro complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dataRegistro">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fecha" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="yaFueCanjeado" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ident" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="regsCanjeados" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="costo" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="usuario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="funcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaFuncion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="espectFuncion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dataRegistro", propOrder = {
    "fecha",
    "yaFueCanjeado",
    "ident",
    "regsCanjeados",
    "costo",
    "usuario",
    "funcion",
    "fechaFuncion",
    "espectFuncion"
})
public class DataRegistro {

    protected String fecha;
    protected boolean yaFueCanjeado;
    protected int ident;
    @XmlElement(nillable = true)
    protected List<Integer> regsCanjeados;
    protected float costo;
    protected String usuario;
    protected String funcion;
    protected String fechaFuncion;
    protected String espectFuncion;

    /**
     * Gets the value of the fecha property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Sets the value of the fecha property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFecha(String value) {
        this.fecha = value;
    }

    /**
     * Gets the value of the yaFueCanjeado property.
     * 
     */
    public boolean isYaFueCanjeado() {
        return yaFueCanjeado;
    }

    /**
     * Sets the value of the yaFueCanjeado property.
     * 
     */
    public void setYaFueCanjeado(boolean value) {
        this.yaFueCanjeado = value;
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
     * Gets the value of the regsCanjeados property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the regsCanjeados property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRegsCanjeados().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getRegsCanjeados() {
        if (regsCanjeados == null) {
            regsCanjeados = new ArrayList<Integer>();
        }
        return this.regsCanjeados;
    }

    /**
     * Gets the value of the costo property.
     * 
     */
    public float getCosto() {
        return costo;
    }

    /**
     * Sets the value of the costo property.
     * 
     */
    public void setCosto(float value) {
        this.costo = value;
    }

    /**
     * Gets the value of the usuario property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Sets the value of the usuario property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsuario(String value) {
        this.usuario = value;
    }

    /**
     * Gets the value of the funcion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFuncion() {
        return funcion;
    }

    /**
     * Sets the value of the funcion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFuncion(String value) {
        this.funcion = value;
    }

    /**
     * Gets the value of the fechaFuncion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaFuncion() {
        return fechaFuncion;
    }

    /**
     * Sets the value of the fechaFuncion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaFuncion(String value) {
        this.fechaFuncion = value;
    }

    /**
     * Gets the value of the espectFuncion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEspectFuncion() {
        return espectFuncion;
    }

    /**
     * Sets the value of the espectFuncion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEspectFuncion(String value) {
        this.espectFuncion = value;
    }

}
