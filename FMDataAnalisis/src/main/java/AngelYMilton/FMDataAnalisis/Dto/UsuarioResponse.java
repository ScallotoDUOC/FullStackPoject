package AngelYMilton.FMDataAnalisis.Dto;

import java.time.LocalDateTime;

/**
 * DTO Response para Usuarios
 *
 * CRITICO: Este DTO NO incluye el password.
 * Si retornaramos la entidad Usuario directamente, expondriaamos el password
 * hasheado,
 * lo cual es un problema de seguridad.
 *
 * Siempre usar DTOs Response para controlar exactamente
 * que informacion se envia al cliente.
 *
 * Otros campos que podrian omitirse en Response:
 * - Timestamps internos
 * - Flags de sistema
 * - Relaciones completas (solo IDs)
 *
 * @author Prof. Sting Parra Silva
 */
public class UsuarioResponse {

    private Long id;
    private String username;
    private String email;
    private String rol;
    private boolean activo;
    private LocalDateTime createdAt;

    // Constructor vacio
    public UsuarioResponse() {
    }

    // Constructor completo
    public UsuarioResponse(Long id, String username, String email, String rol, boolean activo,
            LocalDateTime createdAt) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.rol = rol;
        this.activo = activo;
        this.createdAt = createdAt;
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "UsuarioResponse{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", rol='" + rol + '\'' +
                ", activo=" + activo +
                ", createdAt=" + createdAt +
                '}';
    }
}