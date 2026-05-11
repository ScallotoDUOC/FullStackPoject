package AngelYMilton.FMDataAnalisis.Controller;

import AngelYMilton.FMDataAnalisis.Service.AtributosService;

@RestController
@RequestMapping("/api/atributos")
@RequiredArgsConstructor
public class AtributosController {

    private final AtributosService atributosService;
    
    @GetMapping
}
