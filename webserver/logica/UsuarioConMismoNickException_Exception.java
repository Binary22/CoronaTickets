
package logica;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "UsuarioConMismoNickException", targetNamespace = "http://logica/")
public class UsuarioConMismoNickException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private UsuarioConMismoNickException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public UsuarioConMismoNickException_Exception(String message, UsuarioConMismoNickException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public UsuarioConMismoNickException_Exception(String message, UsuarioConMismoNickException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: logica.UsuarioConMismoNickException
     */
    public UsuarioConMismoNickException getFaultInfo() {
        return faultInfo;
    }

}
