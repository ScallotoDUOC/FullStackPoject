package AngelYMilton.FMDataAnalisis.dtoUsuario;

import java.time.LocalDateTime;

public class UsuarioResponse {

    private Long id;
    private String username;
    private String email;
    private String rol;
    private boolean activo;
    private LocalDateTime createdAt;

    public UsuarioResponse() {}

    public UsuarioResponse(Long id, String username, String email, String rol, boolean activo, LocalDateTime createdAt) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.rol = rol;
        this.activo = activo;
        this.createdAt = createdAt;
    }

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
