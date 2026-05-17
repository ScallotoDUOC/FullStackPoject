package AngelYMilton.FMDataAnalisis.Service;

import AngelYMilton.FMDataAnalisis.Dto.LoginRequest;
import AngelYMilton.FMDataAnalisis.Dto.UsuarioRequest;
import AngelYMilton.FMDataAnalisis.Dto.UsuarioResponse;
import AngelYMilton.FMDataAnalisis.Exception.*;
import AngelYMilton.FMDataAnalisis.Repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import AngelYMilton.FMDataAnalisis.Model.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service - Logica de negocio de Usuarios
 *
 * IMPORTANTE: El Service es donde va la logica de negocio.
 * Aqui validamos reglas como "el email debe ser unico" o "el username no puede
 * repetirse".
 * Tambien convertimos entre DTOs y Entidades para proteger el modelo interno.
 *
 * El Controller solo recibe peticiones HTTP y delega al Service.
 * El Repository solo accede a datos, sin logica.
 *
 * Nota sobre passwords:
 * En este ejemplo simulamos el hash con un prefijo "HASH_".
 * En produccion se debe usar BCryptPasswordEncoder de Spring Security.
 *
 * @author Prof. Sting Parra Silva
 */
@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    // CRUD Basico

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
                hashPassword(request.getPassword())).orElseThrow(() -> new CredencialesInvalidasException());

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

    // Metodos auxiliares privados

    /**
     * Convierte Modelo a DTO Response
     *
     * OJO: Nunca incluir el password en la respuesta.
     * El cliente no necesita verlo y seria un problema de seguridad.
     * Por eso usamos DTOs en lugar de retornar la entidad directamente.
     */
    private UsuarioResponse convertirAResponse(Usuario usuario) {
        UsuarioResponse response = new UsuarioResponse();
        response.setId(usuario.getId());
        response.setUsername(usuario.getUsername());
        response.setEmail(usuario.getEmail());
        response.setRol(usuario.getRol());
        response.setActivo(usuario.isActivo());
        response.setCreatedAt(usuario.getCreatedAt());
        // NO incluir password - esto es lo importante de usar DTOs
        return response;
    }

    /**
     * Simula el hash de password
     *
     * En produccion real se debe usar:
     * BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
     * return encoder.encode(password);
     *
     * Aca solo agregamos un prefijo para demostrar el concepto.
     */
    private String hashPassword(String password) {
        return "HASH_" + password;
    }
}