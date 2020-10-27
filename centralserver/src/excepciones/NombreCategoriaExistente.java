package excepciones;

@SuppressWarnings("serial")
public class NombreCategoriaExistente extends Exception{
	
	public NombreCategoriaExistente(String string) {
		super(string);
	}

}
