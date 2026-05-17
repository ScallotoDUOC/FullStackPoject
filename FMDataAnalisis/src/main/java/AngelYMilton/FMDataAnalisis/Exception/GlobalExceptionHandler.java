package AngelYMilton.FMDataAnalisis.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Manejador Global de Excepciones
 *
 * @RestControllerAdvice hace que este handler se aplique a TODOS los
 *                       controllers.
 *                       Centralizamos aqui el manejo de errores para tener
 *                       respuestas consistentes.
 *
 *                       Ventajas:
 *                       - No repetir try-catch en cada controller
 *                       - Formato de error uniforme en toda la API
 *                       - Facil de mantener (un solo lugar)
 *
 *                       Cada metodo con @ExceptionHandler captura un tipo de
 *                       excepcion especifico
 *                       y retorna un ResponseEntity con el codigo HTTP
 *                       apropiado.
 *
 * @author Prof. Sting Parra Silva
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Maneja errores de validacion Jakarta (@Valid en controller)
     *
     * Cuando el cliente envia datos invalidos (email mal formateado, campos vacios,
     * etc)
     * Spring lanza MethodArgumentNotValidException.
     *
     * Extraemos todos los errores de validacion y los retornamos en formato JSON
     * para que el cliente sepa exactamente que esta mal.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        // Recorre todos los errores de validacion
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.BAD_REQUEST.value());
        response.put("error", "Errores de validacion");
        response.put("errors", errors);

        return ResponseEntity.badRequest().body(response);
    }

    // Usuario no encontrado (404)
    @ExceptionHandler(UsuarioNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleUsuarioNotFound(UsuarioNotFoundException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.NOT_FOUND.value());
        response.put("error", "Recurso no encontrado");
        response.put("message", ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    // Email duplicado (400)
    @ExceptionHandler(EmailDuplicadoException.class)
    public ResponseEntity<Map<String, Object>> handleEmailDuplicado(EmailDuplicadoException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.BAD_REQUEST.value());
        response.put("error", "Email duplicado");
        response.put("message", ex.getMessage());

        return ResponseEntity.badRequest().body(response);
    }

    // Username duplicado (400)
    @ExceptionHandler(UsernameDuplicadoException.class)
    public ResponseEntity<Map<String, Object>> handleUsernameDuplicado(UsernameDuplicadoException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.BAD_REQUEST.value());
        response.put("error", "Username duplicado");
        response.put("message", ex.getMessage());

        return ResponseEntity.badRequest().body(response);
    }

    // Credenciales invalidas (401)
    @ExceptionHandler(CredencialesInvalidasException.class)
    public ResponseEntity<Map<String, Object>> handleCredencialesInvalidas(CredencialesInvalidasException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.UNAUTHORIZED.value());
        response.put("error", "Autenticacion fallida");
        response.put("message", ex.getMessage());

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

    /**
     * Captura cualquier excepcion no manejada especificamente
     *
     * Evita que se muestren stack traces al cliente.
     * En produccion se deberia loguear la excepcion completa para debugging.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGlobalException(Exception ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.put("error", "Error interno del servidor");
        response.put("message", ex.getMessage());

        // En desarrollo podrias agregar: response.put("trace", ex.getStackTrace());
        // NUNCA incluir stack trace en produccion

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    @ExceptionHandler(InformacionPersonalNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleInformacionPersonalNotFound(
            InformacionPersonalNotFoundException ex) {

        Map<String, String> response = new HashMap<>();
        response.put("error", ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}