package AngelYMilton.FMDataAnalisis.InformacionPersonal.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import AngelYMilton.FMDataAnalisis.Enums.Nacionalidad;
import AngelYMilton.FMDataAnalisis.Enums.Personalidad;
import AngelYMilton.FMDataAnalisis.InformacionPersonal.Model.InformacionPersonal;

public interface InformacionPersonalRepository extends JpaRepository<InformacionPersonal, Long> {
    List<InformacionPersonal> findByNacionalidad(Nacionalidad nacionalidad);

    List<InformacionPersonal> findByPersonalidad(Personalidad personalidad);
}
