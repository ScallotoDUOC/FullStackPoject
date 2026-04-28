package AngelYMilton.FMDataAnalisis.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(
    name = "players",
    indexes = {
        @Index(name = "idx_player_iu", columnList = "iu")
    }
)
@Getter
@Setter
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // interno

    @Column(unique = true, nullable = false)
    private Long iu; // externo (del juego)

    @NotBlank
    @Column(nullable = false)
    private String firstName;

    @NotBlank
    @Column(nullable = false)
    private String lastName;

    public Jugador() {}

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
