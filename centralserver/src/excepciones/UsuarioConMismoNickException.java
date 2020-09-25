package excepciones;

@SuppressWarnings("serial")
public class UsuarioConMismoNickException extends Exception {
	
	public UsuarioConMismoNickException(String string) {
        super(string);
    }
}
