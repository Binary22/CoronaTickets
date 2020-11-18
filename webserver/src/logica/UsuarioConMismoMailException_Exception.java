
package logica;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "UsuarioConMismoMailException", targetNamespace = "http://logica/")
public class UsuarioConMismoMailException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private UsuarioConMismoMailException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public UsuarioConMismoMailException_Exception(String message, UsuarioConMismoMailException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public UsuarioConMismoMailException_Exception(String message, UsuarioConMismoMailException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: logica.UsuarioConMismoMailException
     */
    public UsuarioConMismoMailException getFaultInfo() {
        return faultInfo;
    }

}
