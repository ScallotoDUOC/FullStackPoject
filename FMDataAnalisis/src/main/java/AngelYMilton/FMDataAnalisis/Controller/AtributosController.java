package AngelYMilton.FMDataAnalisis.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import AngelYMilton.FMDataAnalisis.Dto.AtributosDTO;
import AngelYMilton.FMDataAnalisis.Model.Atributos;
import AngelYMilton.FMDataAnalisis.Service.AtributosService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/atributos")
@RequiredArgsConstructor
@Validated
public class AtributosController {

    private final AtributosService atributosService;

    // =========================================
    // CREAR ATRIBUTOS
    // POST /api/atributos
    // =========================================
    @PostMapping
    public ResponseEntity<Atributos> crear(@Valid @RequestBody AtributosDTO dto) {

        Atributos nuevo = atributosService.crearAtributos(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    // =========================================
    // BUSCAR POR IU
    // GET /api/atributos/iu/29108066
    // =========================================
    @GetMapping("/iu/{iu}")
    public ResponseEntity<Atributos> buscarPorIU(@PathVariable Long iu) {

        Atributos atributos = atributosService.buscarPorIU(iu);

        return ResponseEntity.ok(atributos);
    }

    // =========================================
    // ACTUALIZAR
    // PUT /api/atributos/1
    // =========================================
    @PutMapping("/{id}")
    public ResponseEntity<Atributos> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody AtributosDTO dto) {

        Atributos actualizado = atributosService.actualizar(id, dto);

        return ResponseEntity.ok(actualizado);
    }

    // =========================================
    // ELIMINAR
    // DELETE /api/atributos/1
    // =========================================
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {

        atributosService.eliminar(id);

        return ResponseEntity.ok("Atributos eliminados correctamente");
    }
}