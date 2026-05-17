package AngelYMilton.FMDataAnalisis.Exception;

public class UsernameDuplicadoException extends RuntimeException {
    public UsernameDuplicadoException(String username) {
        super("Username " + username + " ya existe");
    }
}