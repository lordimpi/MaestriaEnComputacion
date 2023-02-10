package co.edu.unicauca.asae.core.maestria_computacion.services.services.DocenteService;

import org.springframework.transaction.annotation.Transactional;

import co.edu.unicauca.asae.core.maestria_computacion.exceptionControllers.exceptions.EntidadNoExisteException;
import co.edu.unicauca.asae.core.maestria_computacion.exceptionControllers.exceptions.EntidadYaExisteException;
import co.edu.unicauca.asae.core.maestria_computacion.models.Docente;
import co.edu.unicauca.asae.core.maestria_computacion.models.Asignatura;
import co.edu.unicauca.asae.core.maestria_computacion.repositories.DocenteRepository;
import co.edu.unicauca.asae.core.maestria_computacion.response.DocenteResponseRest;
import co.edu.unicauca.asae.core.maestria_computacion.services.DTO.AsignaturaDTO;
import co.edu.unicauca.asae.core.maestria_computacion.services.DTO.DocenteDTO;
import java.util.List;
import org.modelmapper.TypeToken;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DocenteServiceImpl implements IDocenteService {

    @Autowired
    private DocenteRepository docenteRepository;

    @Autowired
    @Qualifier("docente")
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public DocenteDTO createDocente(DocenteDTO docente) {
        System.out.println("invocando al metodo crear docente");
        Docente qDocente = docenteRepository.buscarPorNumeroyTipoIdentificacion(docente.getNoId(), docente.getTipoIdentificacion());
        if (qDocente != null) {
            throw new EntidadYaExisteException("El docente ya existe");
        }
        Docente objDocente = modelMapper.map(docente, Docente.class);
        Docente docenteEntity = docenteRepository.save(objDocente);
        DocenteDTO docenteDTO = modelMapper.map(docenteEntity, DocenteDTO.class);

        return docenteDTO;
    }

    @Override
    @Transactional(readOnly = true)
    public List<DocenteDTO> getAllDocente() {
        Iterable<Docente> docentes = docenteRepository.findAll();
        System.out.println("invocando al metodo listar docentes");
        List<DocenteDTO> docenteDTOs = modelMapper.map(docentes,
                new TypeToken<List<DocenteDTO>>() {}.getType());
        return docenteDTOs;
    }

    @Override
    public DocenteDTO getDocenteById(Integer id) {
        System.out.println("Invocando al metodo buscar docente por id: " + id);
        Docente docente = docenteRepository.findById(id).orElse(null);
        if (docente == null) {
            System.out.println("No exisite el docente con id: "+id);
            throw new EntidadNoExisteException("No existe el docente con id: " + id);
        }
        DocenteDTO docenteDTO = modelMapper.map(docente, DocenteDTO.class);
        return docenteDTO;
    }

    @Override
    public DocenteDTO upDocenteDTO(Integer id, DocenteDTO docente) {
        System.out.println("Invocando al metodo actualizar docente");
        Docente objDocente = docenteRepository.findById(id).orElse(null);
        DocenteDTO docenteDTO = null;
        if (objDocente != null) {
            objDocente.setNombres(docente.getNombres());
            objDocente.setApellidos(docente.getApellidos());
            List<Asignatura> asignaturas = modelMapper.map(docente.getAsignaturas(),
                new TypeToken<List<Asignatura>>() {}.getType());
            objDocente.setAsignaturas(asignaturas);
            objDocente.setSalario(docente.getSalario());
            objDocente.setTipoIdentificacion(docente.getTipoIdentificacion());
            objDocente.setTipoDocente(docente.getTipoDocente());
            objDocente.setNoId(docente.getNoId());
            objDocente.setUniversidad(docente.getUniversidad());
        }

        return docenteDTO;
    }
    
    @Override
    public boolean deleteDocente(int id) {
        System.out.println("Invocando al metodo eliminar docente");
        Docente docente = docenteRepository.findById(id).orElse(null);
        if (docente != null) {
            docenteRepository.delete(docente);
            return true;
        }
        throw new EntidadNoExisteException("No existe el docente con id: " + id);
    }

    @Override
    public ResponseEntity<DocenteResponseRest> buscarPorNumeroyTipoIdentificacion(String numero, String tipo) {
        System.out.println("Invocando al metodo buscar por numero y tipo de identificación");
		Docente objEstudiante = this.docenteRepository.buscarPorNumeroyTipoIdentificacion(numero, tipo);  
        //TODO: construir respuesta si es null
        /*if(objEstudiante == null){
            
        }*/
       	System.out.println("Nombres: " + objEstudiante.getNombres());
		System.out.println("Apellidos: " + objEstudiante.getApellidos());
		DocenteResponseRest response = new DocenteResponseRest();
        response.getDocenteResponse().getDocentes().add(objEstudiante);
		return new ResponseEntity<DocenteResponseRest>(response, HttpStatus.OK); 
    }
}