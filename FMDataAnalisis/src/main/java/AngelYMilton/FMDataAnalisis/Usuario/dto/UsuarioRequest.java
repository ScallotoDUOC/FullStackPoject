package AngelYMilton.FMDataAnalisis.Usuario.dto;

import jakarta.validation.constraints.*;

/**
 * DTO Request para Usuarios
 *
 * Por que usar DTOs Request separados del modelo:
 * 1. El cliente NO debe enviar el ID (lo genera el sistema)
 * 2. El cliente NO debe controlar campos internos (activo, createdAt)
 * 3. Las validaciones son diferentes para crear vs consultar
 * 4. Podemos cambiar el modelo interno sin romper el API
 *
 * Validaciones Jakarta:
 * - @NotBlank: no acepta null, vacio, ni solo espacios
 * - @Email: valida formato de email
 * - @Size: longitud minima y maxima
 * - @Pattern: expresion regular personalizada
 *
 * Estas validaciones se activan con @Valid en el Controller.
 *
 * @author Prof. Sting Parra Silva
 */
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
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d).*$", message = "Password debe contener al menos una letra y un numero")
    private String password;

    @NotNull(message = "Rol es obligatorio")
    @Pattern(regexp = "USER|ADMIN|GUEST", message = "Rol debe ser: USER, ADMIN o GUEST")
    private String rol;

    // Constructor vacio (requerido por Jackson para deserializar JSON)
    public UsuarioRequest() {
    }

    // Constructor completo (opcional, util para tests)
    public UsuarioRequest(String username, String email, String password, String rol) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.rol = rol;
    }

    // Getters y Setters (requeridos por Jackson)

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
        // OJO: No incluir password en toString por seguridad
    }
}