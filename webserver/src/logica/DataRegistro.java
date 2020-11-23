
package logica;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dataRegistro complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dataRegistro">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fecha" type="{http://logica/}localDate" minOccurs="0"/>
 *         &lt;element name="yaFueCanjeado" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ident" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="regsCanjeados" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="costo" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="usuario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="funcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "espectFuncion"
})
public class DataRegistro {

    protected LocalDate fecha;
    protected boolean yaFueCanjeado;
    protected int ident;
    @XmlElement(nillable = true)
    protected List<Integer> regsCanjeados;
    protected float costo;
    protected String usuario;
    protected String funcion;
    protected String espectFuncion;

    /**
     * Obtiene el valor de la propiedad fecha.
     * 
     * @return
     *     possible object is
     *     {@link LocalDate }
     *     
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Define el valor de la propiedad fecha.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalDate }
     *     
     */
    public void setFecha(LocalDate value) {
        this.fecha = value;
    }

    /**
     * Obtiene el valor de la propiedad yaFueCanjeado.
     * 
     */
    public boolean isYaFueCanjeado() {
        return yaFueCanjeado;
    }

    /**
     * Define el valor de la propiedad yaFueCanjeado.
     * 
     */
    public void setYaFueCanjeado(boolean value) {
        this.yaFueCanjeado = value;
    }

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
     * Obtiene el valor de la propiedad costo.
     * 
     */
    public float getCosto() {
        return costo;
    }

    /**
     * Define el valor de la propiedad costo.
     * 
     */
    public void setCosto(float value) {
        this.costo = value;
    }

    /**
     * Obtiene el valor de la propiedad usuario.
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
     * Define el valor de la propiedad usuario.
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
     * Obtiene el valor de la propiedad funcion.
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
     * Define el valor de la propiedad funcion.
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
     * Obtiene el valor de la propiedad espectFuncion.
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
     * Define el valor de la propiedad espectFuncion.
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
