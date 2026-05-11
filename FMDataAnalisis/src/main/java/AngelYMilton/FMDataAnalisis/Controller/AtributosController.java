package AngelYMilton.FMDataAnalisis.Controller;

import AngelYMilton.FMDataAnalisis.Service.AtributosService;
import AngelYMilton.FMDataAnalisis.Model.Atributos;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/atributos")
@RequiredArgsConstructor
public class AtributosController {

    private final AtributosService atributosService;

}