package AngelYMilton.FMDataAnalisis.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AngelYMilton.FMDataAnalisis.Model.Jugador;
import AngelYMilton.FMDataAnalisis.Repository.JugadorRepository;

@Service
public class JugadorService {

    @Autowired
    private JugadorRepository repository;

    // 🔹 Crear jugador
    public Jugador crearJugador(Jugador jugador) {

        if (repository.existsByIu(jugador.getIu())) {
            throw new RuntimeException("El jugador con ese IU ya existe");
        }

        return repository.save(jugador);
    }

    // 🔹 Listar todos
    public List<Jugador> listarJugadores() {
        return repository.findAll();
    }

    // 🔹 Buscar por IU
    public Jugador buscarPorIu(Long iu) {
        return repository.findByIu(iu)
                .orElseThrow(() -> new RuntimeException("Jugador no encontrado"));
    }

    // 🔹 Eliminar
    public void eliminarJugador(Long id) {
        repository.deleteById(id);
    }
}