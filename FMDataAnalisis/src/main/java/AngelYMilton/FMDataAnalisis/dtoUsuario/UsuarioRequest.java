package AngelYMilton.FMDataAnalisis.dtoUsuario;

import jakarta.validation.constraints.*;

public class UsuarioRequest {

    @NotBlank(message = "Username es obligatorio")
    @Size(min = 3, max = 20, message = "Username debe tener entre 3 y 20 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Username solo permite letras, numeros y guion bajo")
    private String username;

    @NotBlank(message = "Email es obligatorio")
    @Email(message = "Email debe ser valido")
    private String email;

    @NotBlank(message = "Password es obligatorio")
    @Size(min = 6, max = 100, message = "Password debe tener minimo 6 caracteres")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d).*$",
            message = "Password debe contener al menos una letra y un numero")
    private String password;

    @NotNull(message = "Rol es obligatorio")
    @Pattern(regexp = "USER|ADMIN|GUEST",
            message = "Rol debe ser: USER, ADMIN o GUEST")
    private String rol;

    public UsuarioRequest() {}

    public UsuarioRequest(String username, String email, String password, String rol) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.rol = rol;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "UsuarioRequest{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", rol='" + rol + '\'' +
                '}';
    }
}
