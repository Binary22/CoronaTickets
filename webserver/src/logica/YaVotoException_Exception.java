
package logica;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "YaVotoException", targetNamespace = "http://logica/")
public class YaVotoException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private YaVotoException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public YaVotoException_Exception(String message, YaVotoException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public YaVotoException_Exception(String message, YaVotoException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: logica.YaVotoException
     */
    public YaVotoException getFaultInfo() {
        return faultInfo;
    }

}
