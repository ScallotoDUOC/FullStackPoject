package AngelYMilton.FMDataAnalisis.Exception;

public class CredencialesInvalidasException extends RuntimeException {
    public CredencialesInvalidasException() {
        super("Username o password incorrectos");
    }
}