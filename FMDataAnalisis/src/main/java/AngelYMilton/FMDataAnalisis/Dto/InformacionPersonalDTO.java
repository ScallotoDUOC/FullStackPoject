package AngelYMilton.FMDataAnalisis.Dto;

import AngelYMilton.FMDataAnalisis.Enums.Nacionalidad;
import AngelYMilton.FMDataAnalisis.Enums.Personalidad;
import AngelYMilton.FMDataAnalisis.Enums.PiernaHabil;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InformacionPersonalDTO {

    @NotNull(message = "El IU del jugador es obligatorio")
    private Long iu;

    @NotNull(message = "La edad es obligatoria")
    @Min(value = 14, message = "La edad mínima es 14")
    @Max(value = 99, message = "La edad máxima es 99")
    private Integer edad;

    @NotNull(message = "La nacionalidad es obligatoria")
    private Nacionalidad nacionalidad;

    @NotNull(message = "La personalidad es obligatoria")
    private Personalidad personalidad;

    @NotNull(message = "La pierna hábil es obligatoria")
    private PiernaHabil piernaHabil;

    @Min(value = 120, message = "La altura mínima es 120 cm")
    @Max(value = 240, message = "La altura máxima es 240 cm")
    private Integer alturaCm;

    @Min(value = 30, message = "El peso mínimo es 30 kg")
    @Max(value = 200, message = "El peso máximo es 200 kg")
    private Integer pesoKg;

    public InformacionPersonalDTO() {
    }
}