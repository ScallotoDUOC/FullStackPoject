package AngelYMilton.FMDataAnalisis.Service;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import AngelYMilton.FMDataAnalisis.Model.Usuario;
import AngelYMilton.FMDataAnalisis.Repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import AngelYMilton.FMDataAnalisis.dtoUsuario.*;
import AngelYMilton.FMDataAnalisis.Exception.*;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UsuarioService {
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

public List<UsuarioResponse> listarTodos() {
        return repository.findAll().stream()
                .map(this::convertirAResponse)
                .collect(Collectors.toList());
    }

    public UsuarioResponse buscarPorId(Long id) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException(id));
        return convertirAResponse(usuario);
    }

    public UsuarioResponse crear(UsuarioRequest request) {
        // Validacion de negocio: email unico
        // Esto no lo puede validar Jakarta porque requiere consultar la BD
        if (repository.findByEmail(request.getEmail()).isPresent()) {
            throw new EmailDuplicadoException(request.getEmail());
        }

        // Validacion de negocio: username unico
        if (repository.findByUsername(request.getUsername()).isPresent()) {
            throw new UsernameDuplicadoException(request.getUsername());
        }

        // Convertir DTO Request a Modelo (entidad de dominio)
        Usuario usuario = new Usuario();
        usuario.setUsername(request.getUsername());
        usuario.setEmail(request.getEmail());
        usuario.setPassword(hashPassword(request.getPassword())); // Hash simulado
        usuario.setRol(request.getRol());
        // Nota: el ID lo genera el repository, activo=true por defecto en constructor

        // Guardar en el repositorio
        Usuario guardado = repository.save(usuario);

        // Convertir Modelo a DTO Response (SIN password por seguridad)
        return convertirAResponse(guardado);
    }

    public UsuarioResponse actualizar(Long id, UsuarioRequest request) {
        // Verificar que existe
        Usuario existente = repository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException(id));

        // Validacion: email unico (excepto el mismo usuario)
        repository.findByEmail(request.getEmail())
                .ifPresent(u -> {
                    if (!u.getId().equals(id)) {
                        throw new EmailDuplicadoException(request.getEmail());
                    }
                });

        // Validacion: username unico (excepto el mismo usuario)
        repository.findByUsername(request.getUsername())
                .ifPresent(u -> {
                    if (!u.getId().equals(id)) {
                        throw new UsernameDuplicadoException(request.getUsername());
                    }
                });

        // Actualizar campos
        existente.setUsername(request.getUsername());
        existente.setEmail(request.getEmail());
        existente.setPassword(hashPassword(request.getPassword()));
        existente.setRol(request.getRol());

        Usuario actualizado = repository.save(existente);
        return convertirAResponse(actualizado);
    }

    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new UsuarioNotFoundException(id);
        }
        repository.deleteById(id);
    }

    // Operaciones Especiales

    public UsuarioResponse login(LoginRequest request) {
        Usuario usuario = repository.findByUsernameAndPassword(
                request.getUsername(),
                hashPassword(request.getPassword())
        ).orElseThrow(() -> new CredencialesInvalidasException());

        if (!usuario.isActivo()) {
            throw new CredencialesInvalidasException();
        }

        return convertirAResponse(usuario);
    }

    public UsuarioResponse activarDesactivar(Long id) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException(id));

        usuario.setActivo(!usuario.isActivo());
        Usuario actualizado = repository.save(usuario);
        return convertirAResponse(actualizado);
    }

    public List<UsuarioResponse> listarActivos() {
        return repository.findByActivo(true).stream()
                .map(this::convertirAResponse)
                .collect(Collectors.toList());
    }

    public List<UsuarioResponse> buscarPorRol(String rol) {
        return repository.findByRol(rol).stream()
                .map(this::convertirAResponse)
                .collect(Collectors.toList());
    }

}