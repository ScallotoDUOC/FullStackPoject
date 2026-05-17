package AngelYMilton.FMDataAnalisis.Usuario.Repository;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import AngelYMilton.FMDataAnalisis.Usuario.Model.Usuario;

@Repository
public class UsuarioRepository {

    private final ConcurrentHashMap<Long, Usuario> usuarios = new ConcurrentHashMap<>();

    private final AtomicLong idGenerator = new AtomicLong(1);

    public Usuario save(Usuario usuario) {
        if (usuario.getId() == null) {
            usuario.setId(idGenerator.getAndIncrement());
        }
        usuarios.put(usuario.getId(), usuario);
        return usuario;
    }

    public List<Usuario> findAll() {
        return new ArrayList<>(usuarios.values());
    }

    public Optional<Usuario> findById(Long id) {
        return Optional.ofNullable(usuarios.get(id));
    }

    public void deleteById(Long id) {
        usuarios.remove(id);
    }

    public boolean existsById(Long id) {
        return usuarios.containsKey(id);
    }

    // Búsquedas personalizadas (simulan queries SQL)

    public Optional<Usuario> findByEmail(String email) {
        return usuarios.values().stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }

    public Optional<Usuario> findByUsername(String username) {
        return usuarios.values().stream()
                .filter(u -> u.getUsername().equalsIgnoreCase(username))
                .findFirst();
    }

    public List<Usuario> findByActivo(boolean activo) {
        return usuarios.values().stream()
                .filter(u -> u.isActivo() == activo)
                .collect(Collectors.toList());
    }

    public List<Usuario> findByRol(String rol) {
        return usuarios.values().stream()
                .filter(u -> u.getRol().equalsIgnoreCase(rol))
                .collect(Collectors.toList());
    }

    public Optional<Usuario> findByUsernameAndPassword(String username, String password) {
        return usuarios.values().stream()
                .filter(u -> u.getUsername().equalsIgnoreCase(username))
                .filter(u -> u.getPassword().equals(password))
                .findFirst();
    }
}
