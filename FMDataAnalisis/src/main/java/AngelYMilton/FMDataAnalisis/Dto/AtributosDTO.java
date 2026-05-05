package AngelYMilton.FMDataAnalisis.Dto;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AtributosDTO {
    @NotNull(message = "El IU del jugador es obligatorio")
    private Long iu;
    //Fisicos
    @Min(1)
    @Max(20)
    private Integer aceleracion;
    @Min(1)
    @Max(20)
    private Integer agilidad;
    @Min(1)
    @Max(20)
    private Integer alcanceDeSalto;
    @Min(1)
    @Max(20)
    private Integer equilibrio;
    @Min(1)
    @Max(20)
    private Integer fuerza;
    @Min(1)
    @Max(20)
    private Integer recuperacionFisica;
    @Min(1)
    @Max(20)
    private Integer resistencia;
    @Min(1)
    @Max(20)
    private Integer velocidad;
    //Mental
    @Min(1)
    @Max(20)
    private Integer agresividad;
    @Min(1)
    @Max(20)
    private Integer anticipacion;
    @Min(1)
    @Max(20)
    private Integer colocacion;
    @Min(1)
    @Max(20)
    private Integer concentracion;
    @Min(1)
    @Max(20)
    private Integer decisiones;
    @Min(1)
    @Max(20)
    private Integer desmarques;
    @Min(1)
    @Max(20)
    private Integer determinacion;
    @Min(1)
    @Max(20)
    private Integer juegoEnEquipo;
    @Min(1)
    @Max(20)
    private Integer liderazgo;
    @Min(1)
    @Max(20)
    private Integer sacrificio;
    @Min(1)
    @Max(20)
    private Integer serenidad;
    @Min(1)
    @Max(20)
    private Integer talento;
    @Min(1)
    @Max(20)
    private Integer valentia;
    @Min(1)
    @Max(20)
    private Integer vision;
    //Tecnico
    @Min(1)
    @Max(20)
    private Integer cabeceo;
    @Min(1)
    @Max(20)
    private Integer centro;
    @Min(1)
    @Max(20)
    private Integer entradas;
    @Min(1)
    @Max(20)
    private Integer marcaje;
    @Min(1)
    @Max(20)
    private Integer pases;
    @Min(1)
    @Max(20)
    private Integer penaltis;
    @Min(1)
    @Max(20)
    private Integer regate;
    @Min(1)
    @Max(20)
    private Integer remate;
    @Min(1)
    @Max(20)
    private Integer saquesDeEsquina;
    @Min(1)
    @Max(20)
    private Integer saquesLargos;
    @Min(1)
    @Max(20)
    private Integer tecnica;
    @Min(1)
    @Max(20)
    private Integer tirosLejanos;
    @Min(1)
    @Max(20)
    private Integer tirosLibres;

    public AtributosDTO(){}
}
