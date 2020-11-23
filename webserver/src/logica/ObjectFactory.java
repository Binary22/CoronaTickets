
package logica;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the logica package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _NombreEspectaculoExisteException_QNAME = new QName("http://logica/", "NombreEspectaculoExisteException");
    private final static QName _UsuarioConMismoMailException_QNAME = new QName("http://logica/", "UsuarioConMismoMailException");
    private final static QName _UsuarioConMismoNickException_QNAME = new QName("http://logica/", "UsuarioConMismoNickException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: logica
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ListaEspectaculo }
     * 
     */
    public ListaEspectaculo createListaEspectaculo() {
        return new ListaEspectaculo();
    }

    /**
     * Create an instance of {@link ListaEspectaculo.Espectaculos }
     * 
     */
    public ListaEspectaculo.Espectaculos createListaEspectaculoEspectaculos() {
        return new ListaEspectaculo.Espectaculos();
    }

    /**
     * Create an instance of {@link DataEspectaculo }
     * 
     */
    public DataEspectaculo createDataEspectaculo() {
        return new DataEspectaculo();
    }

    /**
     * Create an instance of {@link DataEspectaculo.SetFunciones }
     * 
     */
    public DataEspectaculo.SetFunciones createDataEspectaculoSetFunciones() {
        return new DataEspectaculo.SetFunciones();
    }

    /**
     * Create an instance of {@link UsuarioConMismoMailException }
     * 
     */
    public UsuarioConMismoMailException createUsuarioConMismoMailException() {
        return new UsuarioConMismoMailException();
    }

    /**
     * Create an instance of {@link UsuarioConMismoNickException }
     * 
     */
    public UsuarioConMismoNickException createUsuarioConMismoNickException() {
        return new UsuarioConMismoNickException();
    }

    /**
     * Create an instance of {@link NombreEspectaculoExisteException }
     * 
     */
    public NombreEspectaculoExisteException createNombreEspectaculoExisteException() {
        return new NombreEspectaculoExisteException();
    }

    /**
     * Create an instance of {@link DataRegistro }
     * 
     */
    public DataRegistro createDataRegistro() {
        return new DataRegistro();
    }

    /**
     * Create an instance of {@link DataVale }
     * 
     */
    public DataVale createDataVale() {
        return new DataVale();
    }

    /**
     * Create an instance of {@link DataFuncion }
     * 
     */
    public DataFuncion createDataFuncion() {
        return new DataFuncion();
    }

    /**
     * Create an instance of {@link DataUsuario }
     * 
     */
    public DataUsuario createDataUsuario() {
        return new DataUsuario();
    }

    /**
     * Create an instance of {@link DataCompra }
     * 
     */
    public DataCompra createDataCompra() {
        return new DataCompra();
    }

    /**
     * Create an instance of {@link LocalTime }
     * 
     */
    public LocalTime createLocalTime() {
        return new LocalTime();
    }

    /**
     * Create an instance of {@link ListaUsuario }
     * 
     */
    public ListaUsuario createListaUsuario() {
        return new ListaUsuario();
    }

    /**
     * Create an instance of {@link LocalDate }
     * 
     */
    public LocalDate createLocalDate() {
        return new LocalDate();
    }

    /**
     * Create an instance of {@link ListaEspectaculo.Espectaculos.Entry }
     * 
     */
    public ListaEspectaculo.Espectaculos.Entry createListaEspectaculoEspectaculosEntry() {
        return new ListaEspectaculo.Espectaculos.Entry();
    }

    /**
     * Create an instance of {@link DataEspectaculo.SetFunciones.Entry }
     * 
     */
    public DataEspectaculo.SetFunciones.Entry createDataEspectaculoSetFuncionesEntry() {
        return new DataEspectaculo.SetFunciones.Entry();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NombreEspectaculoExisteException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://logica/", name = "NombreEspectaculoExisteException")
    public JAXBElement<NombreEspectaculoExisteException> createNombreEspectaculoExisteException(NombreEspectaculoExisteException value) {
        return new JAXBElement<NombreEspectaculoExisteException>(_NombreEspectaculoExisteException_QNAME, NombreEspectaculoExisteException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UsuarioConMismoMailException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://logica/", name = "UsuarioConMismoMailException")
    public JAXBElement<UsuarioConMismoMailException> createUsuarioConMismoMailException(UsuarioConMismoMailException value) {
        return new JAXBElement<UsuarioConMismoMailException>(_UsuarioConMismoMailException_QNAME, UsuarioConMismoMailException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UsuarioConMismoNickException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://logica/", name = "UsuarioConMismoNickException")
    public JAXBElement<UsuarioConMismoNickException> createUsuarioConMismoNickException(UsuarioConMismoNickException value) {
        return new JAXBElement<UsuarioConMismoNickException>(_UsuarioConMismoNickException_QNAME, UsuarioConMismoNickException.class, null, value);
    }

}
