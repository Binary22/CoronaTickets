package excepciones;

@SuppressWarnings("serial")
public class NoExistePaqueteException extends Exception{
    public NoExistePaqueteException(String string) {
        super(string);
    }
}
