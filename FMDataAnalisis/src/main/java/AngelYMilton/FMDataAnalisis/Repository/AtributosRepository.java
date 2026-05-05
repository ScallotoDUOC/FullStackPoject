package AngelYMilton.FMDataAnalisis.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import AngelYMilton.FMDataAnalisis.Model.Atributos;

public interface AtributosRepository extends  JpaRepository<Atributos, Long> {
    Optional<Atributos>findByJugadorId(Long jugadorId);

    Optional<Atributos>findByJugadorIu(Long iu);

    boolean existsByJugadorId(Long jugadorId);
}
