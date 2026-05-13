package AngelYMilton.FMDataAnalisis.Model;


import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(
    name = "users",
    indexes = {
        @Index(name = "idx_User_id", columnList = "id")
    }
)

@Getter
@Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String username;

    @NotBlank
    @Column(nullable = false)
    private String email;

    @NotBlank
    @Column(nullable = false)
    private String password;  // SENSIBLE - nunca debe salir en respuestas

    @NotBlank
    @Column(nullable = false)
    private String rol;       // USER, ADMIN, GUEST

    @NotBlank
    @Column(nullable = false)
    private String PartidaName;

    @NotBlank
    @Column(nullable = false)
    private boolean activo;

    @NotBlank
    @Column(nullable = false)
    private LocalDateTime createdAt;

    // Constructor vacio (requerido)
    public Usuario() {
        this.activo = true;
        this.createdAt = LocalDateTime.now();
    }

    
    // Constructor con parametros (util para crear usuarios en repository)
    public Usuario(Long id, String username, String email, String password, String rol, String PartidaName) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.rol = rol;
        this.PartidaName = PartidaName;
        this.activo = true;
        this.createdAt = LocalDateTime.now();
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

    public String getPartidaName() {
        return PartidaName;
    }

    public void setPartidaName() {
        
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

    // equals y hashCode basados en ID (importante para colecciones)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // toString SIN password por seguridad (incluso en logs)
    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", rol='" + rol + '\'' +
                ", activo=" + activo +
                ", createdAt=" + createdAt +
                '}';
    }
}

