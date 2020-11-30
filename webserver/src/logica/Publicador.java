
package logica;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import net.java.dev.jaxb.array.StringArray;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Publicador", targetNamespace = "http://logica/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    logica.ObjectFactory.class,
    net.java.dev.jaxb.array.ObjectFactory.class
})
public interface Publicador {


    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://logica/Publicador/loginCorrectoRequest", output = "http://logica/Publicador/loginCorrectoResponse")
    public boolean loginCorrecto(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1);

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://logica/Publicador/esArtistaRequest", output = "http://logica/Publicador/esArtistaResponse")
    public boolean esArtista(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns logica.DataArtista
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://logica/Publicador/getArtistaRequest", output = "http://logica/Publicador/getArtistaResponse")
    public DataArtista getArtista(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns logica.DataListEspOrg
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://logica/Publicador/getEspectaculosOrgArtistaRequest", output = "http://logica/Publicador/getEspectaculosOrgArtistaResponse")
    public DataListEspOrg getEspectaculosOrgArtista(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns logica.DataListEspOrg
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://logica/Publicador/getEspectaculosRequest", output = "http://logica/Publicador/getEspectaculosResponse")
    public DataListEspOrg getEspectaculos(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns logica.DataListEspOrg
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://logica/Publicador/getEspectaculosDePlataformaRequest", output = "http://logica/Publicador/getEspectaculosDePlataformaResponse")
    public DataListEspOrg getEspectaculosDePlataforma(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://logica/Publicador/getMailUsuarioRequest", output = "http://logica/Publicador/getMailUsuarioResponse")
    public String getMailUsuario(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns logica.ListaPaquete
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://logica/Publicador/listarPaquetesEspectaculoRequest", output = "http://logica/Publicador/listarPaquetesEspectaculoResponse")
    public ListaPaquete listarPaquetesEspectaculo(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @return
     *     returns logica.ListaPaquete
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://logica/Publicador/listarPaquetesRequest", output = "http://logica/Publicador/listarPaquetesResponse")
    public ListaPaquete listarPaquetes();

    /**
     * 
     * @return
     *     returns logica.DataListPaquetes
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://logica/Publicador/getPaquetesRequest", output = "http://logica/Publicador/getPaquetesResponse")
    public DataListPaquetes getPaquetes();

    /**
     * 
     * @return
     *     returns logica.ListaEspectaculo
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://logica/Publicador/listarEspectaculosRequest", output = "http://logica/Publicador/listarEspectaculosResponse")
    public ListaEspectaculo listarEspectaculos();

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg5
     * @param arg4
     * @param arg1
     * @param arg0
     * @param arg6
     * @throws UsuarioConMismoMailException_Exception
     * @throws UsuarioConMismoNickException_Exception
     */
    @WebMethod
    @Action(input = "http://logica/Publicador/altaUsuarioWebRequest", output = "http://logica/Publicador/altaUsuarioWebResponse", fault = {
        @FaultAction(className = UsuarioConMismoNickException_Exception.class, value = "http://logica/Publicador/altaUsuarioWeb/Fault/UsuarioConMismoNickException"),
        @FaultAction(className = UsuarioConMismoMailException_Exception.class, value = "http://logica/Publicador/altaUsuarioWeb/Fault/UsuarioConMismoMailException")
    })
    public void altaUsuarioWeb(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2,
        @WebParam(name = "arg3", partName = "arg3")
        String arg3,
        @WebParam(name = "arg4", partName = "arg4")
        String arg4,
        @WebParam(name = "arg5", partName = "arg5")
        String arg5,
        @WebParam(name = "arg6", partName = "arg6")
        String arg6)
        throws UsuarioConMismoMailException_Exception, UsuarioConMismoNickException_Exception
    ;

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg5
     * @param arg4
     * @param arg1
     * @param arg0
     * @param arg7
     * @param arg6
     * @param arg9
     * @param arg8
     * @throws UsuarioConMismoMailException_Exception
     * @throws UsuarioConMismoNickException_Exception
     */
    @WebMethod
    @Action(input = "http://logica/Publicador/altaArtistaWebRequest", output = "http://logica/Publicador/altaArtistaWebResponse", fault = {
        @FaultAction(className = UsuarioConMismoNickException_Exception.class, value = "http://logica/Publicador/altaArtistaWeb/Fault/UsuarioConMismoNickException"),
        @FaultAction(className = UsuarioConMismoMailException_Exception.class, value = "http://logica/Publicador/altaArtistaWeb/Fault/UsuarioConMismoMailException")
    })
    public void altaArtistaWeb(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2,
        @WebParam(name = "arg3", partName = "arg3")
        String arg3,
        @WebParam(name = "arg4", partName = "arg4")
        String arg4,
        @WebParam(name = "arg5", partName = "arg5")
        String arg5,
        @WebParam(name = "arg6", partName = "arg6")
        String arg6,
        @WebParam(name = "arg7", partName = "arg7")
        String arg7,
        @WebParam(name = "arg8", partName = "arg8")
        String arg8,
        @WebParam(name = "arg9", partName = "arg9")
        String arg9)
        throws UsuarioConMismoMailException_Exception, UsuarioConMismoNickException_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns logica.DataRegsPrevios
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://logica/Publicador/obtenerRegistrosPreviosWebRequest", output = "http://logica/Publicador/obtenerRegistrosPreviosWebResponse")
    public DataRegsPrevios obtenerRegistrosPreviosWeb(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns logica.DataValesCanje
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://logica/Publicador/valesACanjearRequest", output = "http://logica/Publicador/valesACanjearResponse")
    public DataValesCanje valesACanjear(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg4
     * @param arg1
     * @param arg0
     * @throws FuncionAlcanzoLimiteException_Exception
     * @throws FechaPosterior_Exception
     * @throws ExisteRegistroEspecException_Exception
     * @throws NoSeleccionoTres_Exception
     */
    @WebMethod
    @Action(input = "http://logica/Publicador/confirmarRegistroPreviosRequest", output = "http://logica/Publicador/confirmarRegistroPreviosResponse", fault = {
        @FaultAction(className = FechaPosterior_Exception.class, value = "http://logica/Publicador/confirmarRegistroPrevios/Fault/fechaPosterior"),
        @FaultAction(className = NoSeleccionoTres_Exception.class, value = "http://logica/Publicador/confirmarRegistroPrevios/Fault/noSeleccionoTres"),
        @FaultAction(className = ExisteRegistroEspecException_Exception.class, value = "http://logica/Publicador/confirmarRegistroPrevios/Fault/existeRegistroEspecException"),
        @FaultAction(className = FuncionAlcanzoLimiteException_Exception.class, value = "http://logica/Publicador/confirmarRegistroPrevios/Fault/funcionAlcanzoLimiteException")
    })
    public void confirmarRegistroPrevios(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2,
        @WebParam(name = "arg3", partName = "arg3")
        String arg3,
        @WebParam(name = "arg4", partName = "arg4")
        DataRegsPrevios arg4)
        throws ExisteRegistroEspecException_Exception, FechaPosterior_Exception, FuncionAlcanzoLimiteException_Exception, NoSeleccionoTres_Exception
    ;

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg4
     * @param arg1
     * @param arg0
     * @throws FechaPosterior_Exception
     * @throws FuncionAlcanzoLimiteException_Exception
     * @throws ExisteRegistroEspecException_Exception
     */
    @WebMethod
    @Action(input = "http://logica/Publicador/confirmarRegistroValesRequest", output = "http://logica/Publicador/confirmarRegistroValesResponse", fault = {
        @FaultAction(className = FechaPosterior_Exception.class, value = "http://logica/Publicador/confirmarRegistroVales/Fault/fechaPosterior"),
        @FaultAction(className = ExisteRegistroEspecException_Exception.class, value = "http://logica/Publicador/confirmarRegistroVales/Fault/existeRegistroEspecException"),
        @FaultAction(className = FuncionAlcanzoLimiteException_Exception.class, value = "http://logica/Publicador/confirmarRegistroVales/Fault/funcionAlcanzoLimiteException")
    })
    public void confirmarRegistroVales(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2,
        @WebParam(name = "arg3", partName = "arg3")
        String arg3,
        @WebParam(name = "arg4", partName = "arg4")
        String arg4)
        throws ExisteRegistroEspecException_Exception, FechaPosterior_Exception, FuncionAlcanzoLimiteException_Exception
    ;

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @throws FuncionAlcanzoLimiteException_Exception
     * @throws FechaPosterior_Exception
     * @throws ExisteRegistroEspecException_Exception
     */
    @WebMethod
    @Action(input = "http://logica/Publicador/confirmarRegistroTradicionalRequest", output = "http://logica/Publicador/confirmarRegistroTradicionalResponse", fault = {
        @FaultAction(className = FechaPosterior_Exception.class, value = "http://logica/Publicador/confirmarRegistroTradicional/Fault/fechaPosterior"),
        @FaultAction(className = ExisteRegistroEspecException_Exception.class, value = "http://logica/Publicador/confirmarRegistroTradicional/Fault/existeRegistroEspecException"),
        @FaultAction(className = FuncionAlcanzoLimiteException_Exception.class, value = "http://logica/Publicador/confirmarRegistroTradicional/Fault/funcionAlcanzoLimiteException")
    })
    public void confirmarRegistroTradicional(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2,
        @WebParam(name = "arg3", partName = "arg3")
        String arg3)
        throws ExisteRegistroEspecException_Exception, FechaPosterior_Exception, FuncionAlcanzoLimiteException_Exception
    ;

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg5
     * @param arg4
     * @param arg1
     * @param arg0
     * @param arg6
     */
    @WebMethod
    @Action(input = "http://logica/Publicador/updateUsuarioWebRequest", output = "http://logica/Publicador/updateUsuarioWebResponse")
    public void updateUsuarioWeb(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2,
        @WebParam(name = "arg3", partName = "arg3")
        String arg3,
        @WebParam(name = "arg4", partName = "arg4")
        String arg4,
        @WebParam(name = "arg5", partName = "arg5")
        String arg5,
        @WebParam(name = "arg6", partName = "arg6")
        String arg6);

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://logica/Publicador/updateArtistaRequest", output = "http://logica/Publicador/updateArtistaResponse")
    public void updateArtista(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2);

    /**
     * 
     * @param arg1
     * @param arg0
     * @throws NoExistePaqueteException_Exception
     */
    @WebMethod
    @Action(input = "http://logica/Publicador/agregarEspAPaqueteRequest", output = "http://logica/Publicador/agregarEspAPaqueteResponse", fault = {
        @FaultAction(className = NoExistePaqueteException_Exception.class, value = "http://logica/Publicador/agregarEspAPaquete/Fault/NoExistePaqueteException")
    })
    public void agregarEspAPaquete(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        DataListEspOrg arg1)
        throws NoExistePaqueteException_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns logica.DataListArtInvi
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://logica/Publicador/getArtistasRequest", output = "http://logica/Publicador/getArtistasResponse")
    public DataListArtInvi getArtistas(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @return
     *     returns logica.DataListPlataformas
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://logica/Publicador/getPlataformasRequest", output = "http://logica/Publicador/getPlataformasResponse")
    public DataListPlataformas getPlataformas();

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg5
     * @param arg4
     * @param arg1
     * @param arg0
     * @throws NoExistePaqueteException_Exception
     * @throws PaqueteConMismoNombreException_Exception
     */
    @WebMethod
    @Action(input = "http://logica/Publicador/crearPaqueteRequest", output = "http://logica/Publicador/crearPaqueteResponse", fault = {
        @FaultAction(className = PaqueteConMismoNombreException_Exception.class, value = "http://logica/Publicador/crearPaquete/Fault/PaqueteConMismoNombreException"),
        @FaultAction(className = NoExistePaqueteException_Exception.class, value = "http://logica/Publicador/crearPaquete/Fault/NoExistePaqueteException")
    })
    public void crearPaquete(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2,
        @WebParam(name = "arg3", partName = "arg3")
        String arg3,
        @WebParam(name = "arg4", partName = "arg4")
        int arg4,
        @WebParam(name = "arg5", partName = "arg5")
        String arg5)
        throws NoExistePaqueteException_Exception, PaqueteConMismoNombreException_Exception
    ;

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @throws UsuarioPaqueteComprado_Exception
     * @throws NoExistePaqueteException_Exception
     */
    @WebMethod
    @Action(input = "http://logica/Publicador/agregarCompraRequest", output = "http://logica/Publicador/agregarCompraResponse", fault = {
        @FaultAction(className = NoExistePaqueteException_Exception.class, value = "http://logica/Publicador/agregarCompra/Fault/NoExistePaqueteException"),
        @FaultAction(className = UsuarioPaqueteComprado_Exception.class, value = "http://logica/Publicador/agregarCompra/Fault/UsuarioPaqueteComprado")
    })
    public void agregarCompra(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2)
        throws NoExistePaqueteException_Exception, UsuarioPaqueteComprado_Exception
    ;

    /**
     * 
     * @param arg0
     * @throws NombreEspectaculoExisteException_Exception
     */
    @WebMethod
    @Action(input = "http://logica/Publicador/altaEspectaculoWebRequest", output = "http://logica/Publicador/altaEspectaculoWebResponse", fault = {
        @FaultAction(className = NombreEspectaculoExisteException_Exception.class, value = "http://logica/Publicador/altaEspectaculoWeb/Fault/NombreEspectaculoExisteException")
    })
    public void altaEspectaculoWeb(
        @WebParam(name = "arg0", partName = "arg0")
        DataEspectaculo arg0)
        throws NombreEspectaculoExisteException_Exception
    ;

    /**
     * 
     * @return
     *     returns net.java.dev.jaxb.array.StringArray
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://logica/Publicador/listarCategoriasRequest", output = "http://logica/Publicador/listarCategoriasResponse")
    public StringArray listarCategorias();

    /**
     * 
     * @return
     *     returns logica.ListaUsuario
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://logica/Publicador/listarUsuariosRequest", output = "http://logica/Publicador/listarUsuariosResponse")
    public ListaUsuario listarUsuarios();

    /**
     * 
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://logica/Publicador/seguirRequest", output = "http://logica/Publicador/seguirResponse")
    public void seguir(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://logica/Publicador/finalizarEspectaculoRequest", output = "http://logica/Publicador/finalizarEspectaculoResponse")
    public void finalizarEspectaculo(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://logica/Publicador/dejardeseguirRequest", output = "http://logica/Publicador/dejardeseguirResponse")
    public void dejardeseguir(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1);

    /**
     * 
     * @param arg0
     * @return
     *     returns logica.ListaEspectaculo
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://logica/Publicador/buscarEspectaculosRequest", output = "http://logica/Publicador/buscarEspectaculosResponse")
    public ListaEspectaculo buscarEspectaculos(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns logica.ListaPaquete
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://logica/Publicador/buscarPaquetesRequest", output = "http://logica/Publicador/buscarPaquetesResponse")
    public ListaPaquete buscarPaquetes(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns logica.DataListFunsEspect
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://logica/Publicador/funcionesEspectaculoRequest", output = "http://logica/Publicador/funcionesEspectaculoResponse")
    public DataListFunsEspect funcionesEspectaculo(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns logica.ListaUsuario
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://logica/Publicador/espectadoresFuncionRequest", output = "http://logica/Publicador/espectadoresFuncionResponse")
    public ListaUsuario espectadoresFuncion(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns logica.DataFuncion
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://logica/Publicador/getFuncionRequest", output = "http://logica/Publicador/getFuncionResponse")
    public DataFuncion getFuncion(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns logica.ListaUsuario
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://logica/Publicador/espectadoresPremiadosRequest", output = "http://logica/Publicador/espectadoresPremiadosResponse")
    public ListaUsuario espectadoresPremiados(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1);

    /**
     * 
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://logica/Publicador/sortearPremiosFuncionRequest", output = "http://logica/Publicador/sortearPremiosFuncionResponse")
    public void sortearPremiosFuncion(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1);

    /**
     * 
     * @param arg0
     * @return
     *     returns logica.DataListPremio
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://logica/Publicador/getPremiosUsuariosRequest", output = "http://logica/Publicador/getPremiosUsuariosResponse")
    public DataListPremio getPremiosUsuarios(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg4
     * @param arg1
     * @param arg0
     * @throws NombreFuncionexisteException_Exception
     */
    @WebMethod
    @Action(input = "http://logica/Publicador/altaFuncionRequest", output = "http://logica/Publicador/altaFuncionResponse", fault = {
        @FaultAction(className = NombreFuncionexisteException_Exception.class, value = "http://logica/Publicador/altaFuncion/Fault/NombreFuncionexisteException")
    })
    public void altaFuncion(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2,
        @WebParam(name = "arg3", partName = "arg3")
        String arg3,
        @WebParam(name = "arg4", partName = "arg4")
        DataListArtInvi arg4)
        throws NombreFuncionexisteException_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns logica.DataUsuario
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://logica/Publicador/getUsuarioRequest", output = "http://logica/Publicador/getUsuarioResponse")
    public DataUsuario getUsuario(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns logica.DataEspectaculo
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://logica/Publicador/getEspectaculoRequest", output = "http://logica/Publicador/getEspectaculoResponse")
    public DataEspectaculo getEspectaculo(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns logica.DataPaquete
     * @throws NoExistePaqueteException_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://logica/Publicador/getPaqueteRequest", output = "http://logica/Publicador/getPaqueteResponse", fault = {
        @FaultAction(className = NoExistePaqueteException_Exception.class, value = "http://logica/Publicador/getPaquete/Fault/NoExistePaqueteException")
    })
    public DataPaquete getPaquete(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0)
        throws NoExistePaqueteException_Exception
    ;

    /**
     * 
     * @return
     *     returns net.java.dev.jaxb.array.StringArray
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://logica/Publicador/listarPlataformasRequest", output = "http://logica/Publicador/listarPlataformasResponse")
    public StringArray listarPlataformas();

    /**
     * 
     * @param arg0
     * @return
     *     returns logica.ListaEspectaculo
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://logica/Publicador/listarEspectaculosPlataformaRequest", output = "http://logica/Publicador/listarEspectaculosPlataformaResponse")
    public ListaEspectaculo listarEspectaculosPlataforma(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

}
