package logica;

public class Fabrica {

    private static Fabrica instancia;

    private Fabrica() {
    };

    public static Fabrica getInstance() {
        if (instancia == null) {
            instancia = new Fabrica();
        }
        return instancia;
    }

    public IUsuario getIUsuario() {
        return new UsuarioController();
    }
    public IConsulta getIConsulta() {
        return new ConsultaController();
    }
    public IPaquete getIPaquete() {
        return new PaqueteController();
    }
    public IEspectaculo getIEspectaculo() {
        return new EspectaculoController();
    }
    public IPlataforma getIPlataforma() {
        return new PlataformaController();
    }
    
}
