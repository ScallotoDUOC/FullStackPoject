package AngelYMilton.FMDataAnalisis.Usuario.Exception;

public class CredencialesInvalidasException extends RuntimeException {
    public CredencialesInvalidasException() {
        super("Username o password incorrectos");
    }
}