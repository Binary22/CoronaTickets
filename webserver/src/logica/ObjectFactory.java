
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

    private final static QName _NombreFuncionexisteException_QNAME = new QName("http://logica/", "NombreFuncionexisteException");
    private final static QName _UsuarioConMismoMailException_QNAME = new QName("http://logica/", "UsuarioConMismoMailException");
    private final static QName _UsuarioConMismoNickException_QNAME = new QName("http://logica/", "UsuarioConMismoNickException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: logica
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link NombreFuncionexisteException }
     * 
     */
    public NombreFuncionexisteException createNombreFuncionexisteException() {
        return new NombreFuncionexisteException();
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
     * Create an instance of {@link DataRegistro }
     * 
     */
    public DataRegistro createDataRegistro() {
        return new DataRegistro();
    }

    /**
     * Create an instance of {@link DataListEspOrg }
     * 
     */
    public DataListEspOrg createDataListEspOrg() {
        return new DataListEspOrg();
    }

    /**
     * Create an instance of {@link DataListArtInvi }
     * 
     */
    public DataListArtInvi createDataListArtInvi() {
        return new DataListArtInvi();
    }

    /**
     * Create an instance of {@link LocalDate }
     * 
     */
    public LocalDate createLocalDate() {
        return new LocalDate();
    }

    /**
     * Create an instance of {@link DataVale }
     * 
     */
    public DataVale createDataVale() {
        return new DataVale();
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
     * Create an instance of {@link DataArtista }
     * 
     */
    public DataArtista createDataArtista() {
        return new DataArtista();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NombreFuncionexisteException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://logica/", name = "NombreFuncionexisteException")
    public JAXBElement<NombreFuncionexisteException> createNombreFuncionexisteException(NombreFuncionexisteException value) {
        return new JAXBElement<NombreFuncionexisteException>(_NombreFuncionexisteException_QNAME, NombreFuncionexisteException.class, null, value);
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
