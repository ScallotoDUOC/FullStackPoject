package AngelYMilton.FMDataAnalisis.Controller;

import AngelYMilton.FMDataAnalisis.Service.AtributosService;

@RestController
@RequestMapping("/api/atributos")
@RequiredArgsConstructor
public class AtributosController {

    private final AtributosService atributosService;

    @GetMapping("/{iu}")
    public ResponseEntity<atributos> buscarPorIU(@PathVariable Long IU) {
        return AtributosService.buscarPorIU(id)
    }

    @DeleteMapping("/{iu}")
    public ResponseEntity<Void> eliminar(@PathVariable Long IU) {
        if (AtributosService.buscarPorIU(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        AtributosService.eliminar(id);
        return ResponseEntity.noContent().build(); 
    }
}

