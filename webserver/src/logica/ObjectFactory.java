
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

    private final static QName _PaqueteConMismoNombreException_QNAME = new QName("http://logica/", "PaqueteConMismoNombreException");
    private final static QName _UsuarioPaqueteComprado_QNAME = new QName("http://logica/", "UsuarioPaqueteComprado");
    private final static QName _NoExistePaqueteException_QNAME = new QName("http://logica/", "NoExistePaqueteException");
    private final static QName _NombreFuncionexisteException_QNAME = new QName("http://logica/", "NombreFuncionexisteException");
    private final static QName _NombreEspectaculoExisteException_QNAME = new QName("http://logica/", "NombreEspectaculoExisteException");
    private final static QName _UsuarioConMismoMailException_QNAME = new QName("http://logica/", "UsuarioConMismoMailException");
    private final static QName _UsuarioConMismoNickException_QNAME = new QName("http://logica/", "UsuarioConMismoNickException");
    private final static QName _DataArtistaDescripcion_QNAME = new QName("", "descripcion");
    private final static QName _DataArtistaWebsite_QNAME = new QName("", "website");
    private final static QName _DataArtistaBiografia_QNAME = new QName("", "biografia");

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
     * Create an instance of {@link PaqueteConMismoNombreException }
     * 
     */
    public PaqueteConMismoNombreException createPaqueteConMismoNombreException() {
        return new PaqueteConMismoNombreException();
    }

    /**
     * Create an instance of {@link UsuarioPaqueteComprado }
     * 
     */
    public UsuarioPaqueteComprado createUsuarioPaqueteComprado() {
        return new UsuarioPaqueteComprado();
    }

    /**
     * Create an instance of {@link NombreFuncionexisteException }
     * 
     */
    public NombreFuncionexisteException createNombreFuncionexisteException() {
        return new NombreFuncionexisteException();
    }

    /**
     * Create an instance of {@link NoExistePaqueteException }
     * 
     */
    public NoExistePaqueteException createNoExistePaqueteException() {
        return new NoExistePaqueteException();
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
     * Create an instance of {@link DataListPaquetes }
     * 
     */
    public DataListPaquetes createDataListPaquetes() {
        return new DataListPaquetes();
    }

    /**
     * Create an instance of {@link DataListEspOrg }
     * 
     */
    public DataListEspOrg createDataListEspOrg() {
        return new DataListEspOrg();
    }

    /**
     * Create an instance of {@link DataRegistro }
     * 
     */
    public DataRegistro createDataRegistro() {
        return new DataRegistro();
    }

    /**
     * Create an instance of {@link ListaPaquete }
     * 
     */
    public ListaPaquete createListaPaquete() {
        return new ListaPaquete();
    }

    /**
     * Create an instance of {@link DataListArtInvi }
     * 
     */
    public DataListArtInvi createDataListArtInvi() {
        return new DataListArtInvi();
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
     * Create an instance of {@link DataListPlataformas }
     * 
     */
    public DataListPlataformas createDataListPlataformas() {
        return new DataListPlataformas();
    }

    /**
     * Create an instance of {@link LocalTime }
     * 
     */
    public LocalTime createLocalTime() {
        return new LocalTime();
    }

    /**
     * Create an instance of {@link DataPaquete }
     * 
     */
    public DataPaquete createDataPaquete() {
        return new DataPaquete();
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
     * Create an instance of {@link DataArtista }
     * 
     */
    public DataArtista createDataArtista() {
        return new DataArtista();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link PaqueteConMismoNombreException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://logica/", name = "PaqueteConMismoNombreException")
    public JAXBElement<PaqueteConMismoNombreException> createPaqueteConMismoNombreException(PaqueteConMismoNombreException value) {
        return new JAXBElement<PaqueteConMismoNombreException>(_PaqueteConMismoNombreException_QNAME, PaqueteConMismoNombreException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UsuarioPaqueteComprado }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://logica/", name = "UsuarioPaqueteComprado")
    public JAXBElement<UsuarioPaqueteComprado> createUsuarioPaqueteComprado(UsuarioPaqueteComprado value) {
        return new JAXBElement<UsuarioPaqueteComprado>(_UsuarioPaqueteComprado_QNAME, UsuarioPaqueteComprado.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NoExistePaqueteException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://logica/", name = "NoExistePaqueteException")
    public JAXBElement<NoExistePaqueteException> createNoExistePaqueteException(NoExistePaqueteException value) {
        return new JAXBElement<NoExistePaqueteException>(_NoExistePaqueteException_QNAME, NoExistePaqueteException.class, null, value);
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

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "descripcion", scope = DataArtista.class)
    public JAXBElement<String> createDataArtistaDescripcion(String value) {
        return new JAXBElement<String>(_DataArtistaDescripcion_QNAME, String.class, DataArtista.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "website", scope = DataArtista.class)
    public JAXBElement<String> createDataArtistaWebsite(String value) {
        return new JAXBElement<String>(_DataArtistaWebsite_QNAME, String.class, DataArtista.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "biografia", scope = DataArtista.class)
    public JAXBElement<String> createDataArtistaBiografia(String value) {
        return new JAXBElement<String>(_DataArtistaBiografia_QNAME, String.class, DataArtista.class, value);
    }

}
