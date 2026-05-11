package AngelYMilton.FMDataAnalisis.Service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import AngelYMilton.FMDataAnalisis.Dto.AtributosDTO;
import AngelYMilton.FMDataAnalisis.Model.Atributos;
import AngelYMilton.FMDataAnalisis.Model.Jugador;
import AngelYMilton.FMDataAnalisis.Repository.AtributosRepository;
import AngelYMilton.FMDataAnalisis.Repository.JugadorRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AtributosService {

    private final AtributosRepository atributosRepository;
    private final JugadorRepository jugadorRepository;

    // =========================================
    // CREAR ATRIBUTOS
    // =========================================
    public Atributos crearAtributos(AtributosDTO dto) {

        Jugador jugador = jugadorRepository.findByIu(dto.getIu())
                .orElseThrow(() -> new RuntimeException("Jugador no encontrado"));

        if (atributosRepository.existsByJugadorId(jugador.getId())) {
            throw new RuntimeException("El jugador ya tiene atributos registrados");
        }

        Atributos atributos = new Atributos();

        atributos.setJugador(jugador);

        // FISICOS
        atributos.setAceleracion(dto.getAceleracion());
        atributos.setAgilidad(dto.getAgilidad());
        atributos.setAlcanceDeSalto(dto.getAlcanceDeSalto());
        atributos.setEquilibrio(dto.getEquilibrio());
        atributos.setFuerza(dto.getFuerza());
        atributos.setRecuperacionFisica(dto.getRecuperacionFisica());
        atributos.setResistencia(dto.getResistencia());
        atributos.setVelocidad(dto.getVelocidad());

        // MENTALES
        atributos.setAgresividad(dto.getAgresividad());
        atributos.setAnticipacion(dto.getAnticipacion());
        atributos.setColocacion(dto.getColocacion());
        atributos.setConcentracion(dto.getConcentracion());
        atributos.setDecisiones(dto.getDecisiones());
        atributos.setDesmarques(dto.getDesmarques());
        atributos.setDeterminacion(dto.getDeterminacion());
        atributos.setJuegoEnEquipo(dto.getJuegoEnEquipo());
        atributos.setLiderazgo(dto.getLiderazgo());
        atributos.setSacrificio(dto.getSacrificio());
        atributos.setSerenidad(dto.getSerenidad());
        atributos.setTalento(dto.getTalento());
        atributos.setValentia(dto.getValentia());
        atributos.setVision(dto.getVision());

        // TECNICOS
        atributos.setCabeceo(dto.getCabeceo());
        atributos.setCentro(dto.getCentro());
        atributos.setEntradas(dto.getEntradas());
        atributos.setMarcaje(dto.getMarcaje());
        atributos.setPases(dto.getPases());
        atributos.setPenaltis(dto.getPenaltis());
        atributos.setRegate(dto.getRegate());
        atributos.setRemate(dto.getRemate());
        atributos.setSaquesDeEsquina(dto.getSaquesDeEsquina());
        atributos.setSaquesLargos(dto.getSaquesLargos());
        atributos.setTecnica(dto.getTecnica());
        atributos.setTirosLejanos(dto.getTirosLejanos());
        atributos.setTirosLibres(dto.getTirosLibres());

        return atributosRepository.save(atributos);
    }

    // BUSCAR POR IU
    public Atributos buscarPorIU(Long iu) {
        return atributosRepository.findByJugadorIu(iu)
                .orElseThrow(() -> new RuntimeException("Atributos no encontrados"));
    }

    // ELIMINAR
    public void eliminar(Long id) {
        atributosRepository.deleteById(id);
    }

    // ACTUALIZAR
    public Atributos actualizar(Long id, AtributosDTO dto) {

        Atributos atributos = atributosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro no encontrado"));

        atributos.setAceleracion(dto.getAceleracion());
        atributos.setAgilidad(dto.getAgilidad());
        atributos.setVelocidad(dto.getVelocidad());
        atributos.setPases(dto.getPases());
        atributos.setRemate(dto.getRemate());
        atributos.setTecnica(dto.getTecnica());
        atributos.setVision(dto.getVision());
        atributos.setDecisiones(dto.getDecisiones());

        return atributosRepository.save(atributos);
    }
}