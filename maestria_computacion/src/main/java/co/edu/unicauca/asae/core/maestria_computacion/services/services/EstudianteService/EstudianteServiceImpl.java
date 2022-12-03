package co.edu.unicauca.asae.core.maestria_computacion.services.services.EstudianteService;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicauca.asae.core.maestria_computacion.models.Estudiante;
import co.edu.unicauca.asae.core.maestria_computacion.repositories.EstudianteRepository;
import co.edu.unicauca.asae.core.maestria_computacion.services.DTO.EstudianteDTO;


@Service
public class EstudianteServiceImpl implements IEstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    @Qualifier("estudiante")
    private ModelMapper modelMapper;

    @Override
    public EstudianteDTO createEstudiante(EstudianteDTO estudiante) {
        EstudianteDTO  estudianteDTO = null;
        
            System.out.println("invocando al metodo crear estudiante");
            Estudiante objEstudiante = this.modelMapper.map(estudiante,Estudiante.class);
            objEstudiante.getObjDireccion().setObjEstudiante(objEstudiante);
            Estudiante estudianteEntity = this.estudianteRepository.save(objEstudiante);
            estudianteDTO = this.modelMapper.map(estudianteEntity, EstudianteDTO.class);
              
        return estudianteDTO;
    }

    @Override
    @Transactional()
    public boolean deleteEstudiante(Integer id) {      
        System.out.println("Invocando al metodo eliminar estudiante por id: " + id);
        boolean result = false;
        Estudiante estudiante = estudianteRepository.findById(id).orElse(null);
        if (estudiante != null) {
            estudianteRepository.deleteById(id);
            System.out.println("Estudiante eliminado");
            result = true;
        }
        else
        {
            System.out.println("Estudiante No encontrado");   
        }
        return result;
    }

    @Override
    public List<EstudianteDTO> getAllEstudiante() {
        System.out.println("Invocando al metodo obtener todos los estudiantes");
        Iterable<Estudiante> estudiante = this.estudianteRepository.findAll();
        List<EstudianteDTO> estudiantesDTO = modelMapper.map(estudiante,
                        new TypeToken<List<EstudianteDTO>>() {}.getType());
        return estudiantesDTO;
    }

    @Override
    public EstudianteDTO getEstudianteById(Integer id) {
        Estudiante estudiante = estudianteRepository.findById(id).orElse(null);        
        EstudianteDTO estudianteDTO = modelMapper.map(estudiante, EstudianteDTO.class);
        return estudianteDTO;
    }

    @Override
    public EstudianteDTO updateEstudiante(Integer id, EstudianteDTO estudianteConDatosNuevos) {
        
        return null;
    }
    
}
