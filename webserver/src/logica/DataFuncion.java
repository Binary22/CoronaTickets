
package logica;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dataFuncion complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dataFuncion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fecha" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="horaInicio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaReg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="artistasInvitados" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="registros" type="{http://logica/}dataRegistro" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="espectaculo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="imagen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fueSorteado" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="finalizo" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="descriPremio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaSorteo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cantPremios" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dataFuncion", propOrder = {
    "nombre",
    "fecha",
    "horaInicio",
    "fechaReg",
    "artistasInvitados",
    "registros",
    "espectaculo",
    "imagen",
    "fueSorteado",
    "finalizo",
    "descriPremio",
    "fechaSorteo",
    "cantPremios"
})
public class DataFuncion {

    protected String nombre;
    protected String fecha;
    protected String horaInicio;
    protected String fechaReg;
    @XmlElement(nillable = true)
    protected List<String> artistasInvitados;
    @XmlElement(nillable = true)
    protected List<DataRegistro> registros;
    protected String espectaculo;
    protected String imagen;
    protected boolean fueSorteado;
    protected boolean finalizo;
    protected String descriPremio;
    protected String fechaSorteo;
    protected int cantPremios;

    /**
     * Gets the value of the nombre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets the value of the nombre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

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
     * Gets the value of the horaInicio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHoraInicio() {
        return horaInicio;
    }

    /**
     * Sets the value of the horaInicio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHoraInicio(String value) {
        this.horaInicio = value;
    }

    /**
     * Gets the value of the fechaReg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaReg() {
        return fechaReg;
    }

    /**
     * Sets the value of the fechaReg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaReg(String value) {
        this.fechaReg = value;
    }

    /**
     * Gets the value of the artistasInvitados property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the artistasInvitados property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArtistasInvitados().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getArtistasInvitados() {
        if (artistasInvitados == null) {
            artistasInvitados = new ArrayList<String>();
        }
        return this.artistasInvitados;
    }

    /**
     * Gets the value of the registros property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the registros property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRegistros().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataRegistro }
     * 
     * 
     */
    public List<DataRegistro> getRegistros() {
        if (registros == null) {
            registros = new ArrayList<DataRegistro>();
        }
        return this.registros;
    }

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
     * Gets the value of the imagen property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * Sets the value of the imagen property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImagen(String value) {
        this.imagen = value;
    }

    /**
     * Gets the value of the fueSorteado property.
     * 
     */
    public boolean isFueSorteado() {
        return fueSorteado;
    }

    /**
     * Sets the value of the fueSorteado property.
     * 
     */
    public void setFueSorteado(boolean value) {
        this.fueSorteado = value;
    }

    /**
     * Gets the value of the finalizo property.
     * 
     */
    public boolean isFinalizo() {
        return finalizo;
    }

    /**
     * Sets the value of the finalizo property.
     * 
     */
    public void setFinalizo(boolean value) {
        this.finalizo = value;
    }

    /**
     * Gets the value of the descriPremio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescriPremio() {
        return descriPremio;
    }

    /**
     * Sets the value of the descriPremio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescriPremio(String value) {
        this.descriPremio = value;
    }

    /**
     * Gets the value of the fechaSorteo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaSorteo() {
        return fechaSorteo;
    }

    /**
     * Sets the value of the fechaSorteo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaSorteo(String value) {
        this.fechaSorteo = value;
    }

    /**
     * Gets the value of the cantPremios property.
     * 
     */
    public int getCantPremios() {
        return cantPremios;
    }

    /**
     * Sets the value of the cantPremios property.
     * 
     */
    public void setCantPremios(int value) {
        this.cantPremios = value;
    }

}
