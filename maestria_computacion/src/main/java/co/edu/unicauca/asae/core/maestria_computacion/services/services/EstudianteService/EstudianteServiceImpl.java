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

    @Autowired
    @Qualifier("estudianteLazy")
    private ModelMapper mapperLazy;

    @Autowired
    @Qualifier("estudianteEager")
    private ModelMapper mapperEager;

    @Override
    public EstudianteDTO createEstudiante(EstudianteDTO estudiante) {
        // TODO Auto-generated method stub
        return null;
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
    public EstudianteDTO getEstudianteById(Integer id) {
        Optional<Estudiante> estudiante = estudianteRepository.findById(id);     
        EstudianteDTO estudianteDTO = modelMapper.map(estudiante, EstudianteDTO.class);
        return estudianteDTO;
        /*Optional<Estudiante> estudiante = estudianteRepository.findById(id);
        System.out.println(estudiante.get().getNombres());
        EstudianteDTO estudianteDTO = mapperEager.map(estudiante, EstudianteDTO.class);
        return estudianteDTO;*/
    }

    @Override
    public EstudianteDTO updateEstudiante(Integer id, EstudianteDTO estudiante) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public List<EstudianteDTO> getAllEstudiante(){
        Iterable<Estudiante> estudiantes = estudianteRepository.findAll();
        List<EstudianteDTO> estudiantesDTO = mapperEager.map(estudiantes, new TypeToken<List<EstudianteDTO>>(){}.getType());
        return estudiantesDTO;
    }

    @Override
    public EstudianteDTO getById(Integer id){
        Optional<Estudiante> estudiante = estudianteRepository.findById(id);
        EstudianteDTO estudianteDTO = mapperEager.map(estudiante.get(),EstudianteDTO.class);
        return estudianteDTO;
    }

    public List<EstudianteDTO> getAllLazy(){
        Iterable<Estudiante> estudiantes = estudianteRepository.findAll();
        List<EstudianteDTO> estudiantesDTO = mapperLazy.map(estudiantes, new TypeToken<List<EstudianteDTO>>(){}.getType());
        return estudiantesDTO;
    }
    public EstudianteDTO getByIdLazy(Integer id){
        Optional<Estudiante> estudiante = estudianteRepository.findById(id);
        EstudianteDTO estudianteDTO = mapperLazy.map(estudiante.get(), EstudianteDTO.class);
        return estudianteDTO;
    }
}
