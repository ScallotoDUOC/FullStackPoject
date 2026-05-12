package AngelYMilton.FMDataAnalisis.Model;

import AngelYMilton.FMDataAnalisis.Enums.Nacionalidad;
import AngelYMilton.FMDataAnalisis.Enums.Personalidad;
import AngelYMilton.FMDataAnalisis.Enums.PiernaHabil;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "informacion_personal")
@Getter
@Setter
public class InformacionPersonal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer edad;

    private Nacionalidad nacionalidad;

    private Double altura;

    private Double peso;

    private PiernaHabil piernaHabil;

    private Personalidad personalidad;

    private String mediaDescription;

    @OneToOne
    @JoinColumn(name = "jugador_id", nullable = false, unique = true)
    private Jugador jugador;
}
