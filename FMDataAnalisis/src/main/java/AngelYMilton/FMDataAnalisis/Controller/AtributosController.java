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

    
}
