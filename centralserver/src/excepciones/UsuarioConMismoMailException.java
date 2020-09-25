package excepciones;

@SuppressWarnings("serial")
public class UsuarioConMismoMailException extends Exception {
	
	public UsuarioConMismoMailException(String string) {
        super(string);
    }
}



