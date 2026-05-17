package AngelYMilton.FMDataAnalisis.InformacionPersonal.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AngelYMilton.FMDataAnalisis.Enums.Nacionalidad;
import AngelYMilton.FMDataAnalisis.Enums.Personalidad;
import AngelYMilton.FMDataAnalisis.InformacionPersonal.Model.InformacionPersonal;
import AngelYMilton.FMDataAnalisis.InformacionPersonal.Repository.InformacionPersonalRepository;

import java.util.List;

@Service
public class InformacionPersonalService {

    @Autowired
    private InformacionPersonalRepository informacionPersonalRepository;

    // Listar todos
    public List<InformacionPersonal> listarTodos() {
        return informacionPersonalRepository.findAll();
    }

    // Buscar por ID
    public InformacionPersonal buscarPorId(Long id) {
        return informacionPersonalRepository.findById(id).orElse(null);
    }

    // Guardar o actualizar
    public InformacionPersonal guardar(InformacionPersonal informacionPersonal) {
        return informacionPersonalRepository.save(informacionPersonal);
    }

    // Eliminar por ID
    public void eliminar(Long id) {
        informacionPersonalRepository.deleteById(id);
    }

    // Buscar por nacionalidad
    public List<InformacionPersonal> buscarPorNacionalidad(Nacionalidad nacionalidad) {
        return informacionPersonalRepository.findByNacionalidad(nacionalidad);
    }

    // Buscar por personalidad
    public List<InformacionPersonal> buscarPorPersonalidad(Personalidad personalidad) {
        return informacionPersonalRepository.findByPersonalidad(personalidad);
    }
}