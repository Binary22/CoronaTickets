
package logica;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "NombreEspectaculoExisteException", targetNamespace = "http://logica/")
public class NombreEspectaculoExisteException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private NombreEspectaculoExisteException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public NombreEspectaculoExisteException_Exception(String message, NombreEspectaculoExisteException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public NombreEspectaculoExisteException_Exception(String message, NombreEspectaculoExisteException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: logica.NombreEspectaculoExisteException
     */
    public NombreEspectaculoExisteException getFaultInfo() {
        return faultInfo;
    }

}
