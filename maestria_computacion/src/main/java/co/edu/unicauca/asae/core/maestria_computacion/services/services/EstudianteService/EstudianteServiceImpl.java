package co.edu.unicauca.asae.core.maestria_computacion.services.services.EstudianteService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicauca.asae.core.maestria_computacion.exceptionControllers.exceptions.EntidadYaExisteException;
import co.edu.unicauca.asae.core.maestria_computacion.models.Direccion;
import co.edu.unicauca.asae.core.maestria_computacion.models.Estudiante;
import co.edu.unicauca.asae.core.maestria_computacion.models.Telefono;
import co.edu.unicauca.asae.core.maestria_computacion.repositories.EstudianteRepository;
import co.edu.unicauca.asae.core.maestria_computacion.response.EstudianteResponse.EstudianteResponseRest;
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
    @Qualifier("messageResourceSB")
    MessageSource messageSource;

    @Override
    @Transactional()
    public EstudianteDTO createEstudiante(EstudianteDTO estudiante) {
        EstudianteDTO estudianteDTO = null;
        if (estudiante.getId() != null) {
            final Boolean bandera = this.estudianteRepository.existsById(estudiante.getId());
            if (bandera) {
                EntidadYaExisteException objException = new EntidadYaExisteException(
                        "Cliente con id " + estudiante.getId() + " existe en la BD");
                throw objException;

            }
        }

        System.out.println("invocando al metodo crear estudiante");
        Estudiante objEstudiante = this.modelMapper.map(estudiante, Estudiante.class);
        objEstudiante.getObjDireccion().setObjEstudiante(objEstudiante);
        objEstudiante.getTelefonos().forEach(telefono -> telefono.setObjEstudiante(objEstudiante));
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
            System.out.println("No exisite el estudiante con id: " + id);
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
    public List<EstudianteDTO> getAllLazy() {
        Iterable<Estudiante> estudiantes = estudianteRepository.findAll();
        List<EstudianteDTO> estudiantesDTO = mapperLazy.map(estudiantes, new TypeToken<List<EstudianteDTO>>() {
        }.getType());
        return estudiantesDTO;
    }

    @Override
    @Transactional(readOnly = true)
    public EstudianteDTO getByIdLazy(Integer id) {
        Optional<Estudiante> estudiante = estudianteRepository.findById(id);
        if (estudiante == null) {
            System.out.println("No exisite el estudiante con id: " + id);
            return null;
        }
        EstudianteDTO estudianteDTO = mapperLazy.map(estudiante.get(), EstudianteDTO.class);
        return estudianteDTO;
    }

    @Override
    @Transactional(readOnly = true)
    public List<EstudianteDTO> buscarPorPatron(String patron) {
        System.out.println("Invocando al metodo buscar estudiantes por patron");
        
        List<Estudiante> estudiantes = estudianteRepository.buscarEstudiantePorPatron(patron);
        System.out.println(estudiantes.size());
        List<EstudianteDTO> estudiantesDTO = mapperLazy.map(estudiantes,new TypeToken<List<EstudianteDTO>>() {}.getType());
        return estudiantesDTO;
    }

    @Override
    public boolean existByEmail(String email) {
        return (estudianteRepository.existByEmail(email).orElse(0) == 1) ? true : false;
    }

    @Override
	public List<EstudianteDTO> findByIdPorRango(int id1, int id2) {

		List<Estudiante> lista = this.estudianteRepository.findByIdBetween(id1, id2);
		System.out.println("Registros encontrados:" + lista.size());
		for (Estudiante c : lista) {
			System.out.println(c.getId() + ":" + c.getNombres() + ":" + c.getApellidos());
		}
        List<EstudianteDTO> listas = modelMapper.map(lista,new TypeToken<List<EstudianteDTO>>() {
                }.getType());
		return listas;
	}

    public ResponseEntity<EstudianteResponseRest> buscarPorNumeroyTipoIdentificacion(String numero, String tipo) {
        System.out.println("Invocando al metodo buscar por numero y tipo de identificación");
		Estudiante objEstudiante = this.estudianteRepository.buscarPorNumeroyTipoIdentificacion(numero, tipo);  
       	System.out.println("Nombres: " + objEstudiante.getNombres());
		System.out.println("Apellidos: " + objEstudiante.getApellidos());
		EstudianteResponseRest response = new EstudianteResponseRest();
        response.getEstudianteResponse().getEstudiantes().add(objEstudiante);
		return new ResponseEntity<EstudianteResponseRest>(response, HttpStatus.OK); 
    }    
}
