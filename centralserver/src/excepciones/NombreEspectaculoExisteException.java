package excepciones;

@SuppressWarnings("serial")
public class NombreEspectaculoExisteException extends Exception {
	
	public NombreEspectaculoExisteException(String string) {
        super(string);
    }
}
