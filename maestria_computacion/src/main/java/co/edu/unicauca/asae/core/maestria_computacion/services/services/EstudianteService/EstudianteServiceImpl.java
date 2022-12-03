package co.edu.unicauca.asae.core.maestria_computacion.services.services.EstudianteService;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicauca.asae.core.maestria_computacion.models.Direccion;
import co.edu.unicauca.asae.core.maestria_computacion.models.Estudiante;
import co.edu.unicauca.asae.core.maestria_computacion.models.Telefono;
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

    @Override
    public EstudianteDTO createEstudiante(EstudianteDTO estudiante) {
        EstudianteDTO estudianteDTO = null;

        System.out.println("invocando al metodo crear estudiante");
        Estudiante objEstudiante = this.modelMapper.map(estudiante, Estudiante.class);
        objEstudiante.getObjDireccion().setObjEstudiante(objEstudiante);
        objEstudiante.getTelefonos().forEach(telefono -> telefono.setObjEstudiante(objEstudiante));
        Estudiante estudianteEntity = this.estudianteRepository.save(objEstudiante);
        estudianteDTO = this.modelMapper.map(estudianteEntity, EstudianteDTO.class);
        System.out.println("Estudiante Creado!");
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
        } else {
            System.out.println("Estudiante No encontrado");
        }
        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public List<EstudianteDTO> getAllEstudiante() {
        System.out.println("Invocando al metodo obtener todos los estudiantes");
        Iterable<Estudiante> estudiante = this.estudianteRepository.findAll();
        List<EstudianteDTO> estudiantesDTO = modelMapper.map(estudiante,
                new TypeToken<List<EstudianteDTO>>() {
                }.getType());
        return estudiantesDTO;
    }

    @Override
    @Transactional(readOnly = true)
    public EstudianteDTO getEstudianteById(Integer id) {
        Estudiante estudiante = estudianteRepository.findById(id).orElse(null);
        if (estudiante == null) {
            System.out.println("No exisite el estudiante con id: "+id);
            return null;
        }
        EstudianteDTO estudianteDTO = modelMapper.map(estudiante, EstudianteDTO.class);
        return estudianteDTO;
    }

    @Override
    public EstudianteDTO updateEstudiante(Integer id, EstudianteDTO estudiante) {
        Estudiante objEstudianteAlmacenado = this.estudianteRepository.findById(id).orElse(null);
        EstudianteDTO estudianteDTOActualizado = null;
        if (objEstudianteAlmacenado != null) {
            objEstudianteAlmacenado.setNombres(estudiante.getNombres());
            objEstudianteAlmacenado.setApellidos(estudiante.getApellidos());
            objEstudianteAlmacenado.setNoId(estudiante.getNoId());
            objEstudianteAlmacenado.setTipoIdentificacion(estudiante.getTipoIdentificacion());
            Direccion objDireccionAlmacenada = objEstudianteAlmacenado.getObjDireccion();
            objDireccionAlmacenada
                    .setDireccionResidencia(estudiante.getObjDireccion().getDireccionResidencia());
            objDireccionAlmacenada.setCiudad(estudiante.getObjDireccion().getCiudad());
            objDireccionAlmacenada.setPais(estudiante.getObjDireccion().getPais());

            List<Telefono> Telefonos = modelMapper.map(estudiante.getTelefonos(),
                    new TypeToken<List<Telefono>>() {
                    }.getType());
            objEstudianteAlmacenado.setTelefonos(Telefonos);
            objEstudianteAlmacenado.getTelefonos().forEach(c -> c.setObjEstudiante(objEstudianteAlmacenado));

            Estudiante estudianteEntityActualizado = this.estudianteRepository.save(objEstudianteAlmacenado);
            estudianteDTOActualizado = this.modelMapper.map(estudianteEntityActualizado, EstudianteDTO.class);
        } else {
            System.out.println("Error Fatal: Estudiante No encontrado");
        }

        return estudianteDTOActualizado;
    }

    @Override
    @Transactional(readOnly = true)
    public List<EstudianteDTO> getAllLazy(){
        Iterable<Estudiante> estudiantes = estudianteRepository.findAll();
        List<EstudianteDTO> estudiantesDTO = mapperLazy.map(estudiantes, new TypeToken<List<EstudianteDTO>>(){}.getType());
        return estudiantesDTO;
    }

    @Override
    @Transactional(readOnly = true)
    public EstudianteDTO getByIdLazy(Integer id){
        Optional<Estudiante> estudiante = estudianteRepository.findById(id);
        if (estudiante == null) {
            System.out.println("No exisite el estudiante con id: "+id);
            return null;
        }
        EstudianteDTO estudianteDTO = mapperLazy.map(estudiante.get(), EstudianteDTO.class);
        return estudianteDTO;
    }
}
