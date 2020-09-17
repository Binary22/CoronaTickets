package excepciones;

@SuppressWarnings("serial")
public class NoHayPaquetesException extends Exception {
    public NoHayPaquetesException(String string) {
        super(string);
    }
}