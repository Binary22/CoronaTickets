
package logica;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para espectaculo complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="espectaculo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="aceptado" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="artista" type="{http://logica/}artista" minOccurs="0"/>
 *         &lt;element name="costo" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="duracion" type="{http://logica/}localTime" minOccurs="0"/>
 *         &lt;element name="fechaReg" type="{http://logica/}localDate" minOccurs="0"/>
 *         &lt;element name="imagen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="maxEspectadores" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="minEspectadores" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="plataforma" type="{http://logica/}plataforma" minOccurs="0"/>
 *         &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="yaFueValuado" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "espectaculo", propOrder = {
    "aceptado",
    "artista",
    "costo",
    "descripcion",
    "duracion",
    "fechaReg",
    "imagen",
    "maxEspectadores",
    "minEspectadores",
    "nombre",
    "plataforma",
    "url",
    "yaFueValuado"
})
public class Espectaculo {

    protected boolean aceptado;
    protected Artista artista;
    protected float costo;
    protected String descripcion;
    protected LocalTime duracion;
    protected LocalDate fechaReg;
    protected String imagen;
    protected int maxEspectadores;
    protected int minEspectadores;
    protected String nombre;
    protected Plataforma plataforma;
    protected String url;
    protected boolean yaFueValuado;

    /**
     * Obtiene el valor de la propiedad aceptado.
     * 
     */
    public boolean isAceptado() {
        return aceptado;
    }

    /**
     * Define el valor de la propiedad aceptado.
     * 
     */
    public void setAceptado(boolean value) {
        this.aceptado = value;
    }

    /**
     * Obtiene el valor de la propiedad artista.
     * 
     * @return
     *     possible object is
     *     {@link Artista }
     *     
     */
    public Artista getArtista() {
        return artista;
    }

    /**
     * Define el valor de la propiedad artista.
     * 
     * @param value
     *     allowed object is
     *     {@link Artista }
     *     
     */
    public void setArtista(Artista value) {
        this.artista = value;
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
     * Obtiene el valor de la propiedad duracion.
     * 
     * @return
     *     possible object is
     *     {@link LocalTime }
     *     
     */
    public LocalTime getDuracion() {
        return duracion;
    }

    /**
     * Define el valor de la propiedad duracion.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalTime }
     *     
     */
    public void setDuracion(LocalTime value) {
        this.duracion = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaReg.
     * 
     * @return
     *     possible object is
     *     {@link LocalDate }
     *     
     */
    public LocalDate getFechaReg() {
        return fechaReg;
    }

    /**
     * Define el valor de la propiedad fechaReg.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalDate }
     *     
     */
    public void setFechaReg(LocalDate value) {
        this.fechaReg = value;
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
     * Obtiene el valor de la propiedad maxEspectadores.
     * 
     */
    public int getMaxEspectadores() {
        return maxEspectadores;
    }

    /**
     * Define el valor de la propiedad maxEspectadores.
     * 
     */
    public void setMaxEspectadores(int value) {
        this.maxEspectadores = value;
    }

    /**
     * Obtiene el valor de la propiedad minEspectadores.
     * 
     */
    public int getMinEspectadores() {
        return minEspectadores;
    }

    /**
     * Define el valor de la propiedad minEspectadores.
     * 
     */
    public void setMinEspectadores(int value) {
        this.minEspectadores = value;
    }

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
     * Obtiene el valor de la propiedad plataforma.
     * 
     * @return
     *     possible object is
     *     {@link Plataforma }
     *     
     */
    public Plataforma getPlataforma() {
        return plataforma;
    }

    /**
     * Define el valor de la propiedad plataforma.
     * 
     * @param value
     *     allowed object is
     *     {@link Plataforma }
     *     
     */
    public void setPlataforma(Plataforma value) {
        this.plataforma = value;
    }

    /**
     * Obtiene el valor de la propiedad url.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrl() {
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
    public void setUrl(String value) {
        this.url = value;
    }

    /**
     * Obtiene el valor de la propiedad yaFueValuado.
     * 
     */
    public boolean isYaFueValuado() {
        return yaFueValuado;
    }

    /**
     * Define el valor de la propiedad yaFueValuado.
     * 
     */
    public void setYaFueValuado(boolean value) {
        this.yaFueValuado = value;
    }

}
