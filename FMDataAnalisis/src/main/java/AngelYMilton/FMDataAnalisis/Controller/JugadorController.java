package AngelYMilton.FMDataAnalisis.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import AngelYMilton.FMDataAnalisis.Model.Jugador;
import AngelYMilton.FMDataAnalisis.Service.JugadorService;

@RestController
@RequestMapping("/players")
public class JugadorController {

    @Autowired
    private JugadorService service;

    // 🔹 Crear jugador
    @PostMapping
    public ResponseEntity<Jugador> crear(@Valid @RequestBody Jugador jugador) {
        Jugador nuevo = service.crearJugador(jugador);
        return ResponseEntity.status(201).body(nuevo); // 201 CREATED
    }

    // 🔹 Listar todos los jugadores
    @GetMapping
    public ResponseEntity<List<Jugador>> listar() {
        return ResponseEntity.ok(service.listarJugadores());
    }

    // 🔹 Buscar por IU (clave principal de tu sistema)
    @GetMapping("/iu/{iu}")
    public ResponseEntity<Jugador> buscarPorIu(@PathVariable Long iu) {
        return ResponseEntity.ok(service.buscarPorIu(iu));
    }

    // 🔹 Eliminar jugador
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminarJugador(id);
        return ResponseEntity.noContent().build(); // 204
    }
}