package AngelYMilton.FMDataAnalisis.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import AngelYMilton.FMDataAnalisis.Model.Jugador;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Long> {

    Optional<Jugador> findByIu(Long iu);

    boolean existsByIu(Long iu);

    List<Jugador> findByLastName(String lastName);

    List<Jugador> findByFirstName(String firstName);
}