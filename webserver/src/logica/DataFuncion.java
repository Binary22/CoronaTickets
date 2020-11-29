
package logica;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dataFuncion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
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
    "fechaSorteo"
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

    /**
     * Obtiene el valor de la propiedad nombre.
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
     * Define el valor de la propiedad nombre.
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
     * Obtiene el valor de la propiedad fecha.
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
     * Define el valor de la propiedad fecha.
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
     * Obtiene el valor de la propiedad horaInicio.
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
     * Define el valor de la propiedad horaInicio.
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
     * Obtiene el valor de la propiedad fechaReg.
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
     * Define el valor de la propiedad fechaReg.
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
     * Obtiene el valor de la propiedad imagen.
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
     * Define el valor de la propiedad imagen.
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
     * Obtiene el valor de la propiedad fueSorteado.
     * 
     */
    public boolean isFueSorteado() {
        return fueSorteado;
    }

    /**
     * Define el valor de la propiedad fueSorteado.
     * 
     */
    public void setFueSorteado(boolean value) {
        this.fueSorteado = value;
    }

    /**
     * Obtiene el valor de la propiedad finalizo.
     * 
     */
    public boolean isFinalizo() {
        return finalizo;
    }

    /**
     * Define el valor de la propiedad finalizo.
     * 
     */
    public void setFinalizo(boolean value) {
        this.finalizo = value;
    }

    /**
     * Obtiene el valor de la propiedad descriPremio.
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
     * Define el valor de la propiedad descriPremio.
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
     * Obtiene el valor de la propiedad fechaSorteo.
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
     * Define el valor de la propiedad fechaSorteo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaSorteo(String value) {
        this.fechaSorteo = value;
    }

}
