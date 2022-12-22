package co.edu.unicauca.asae.core.maestria_computacion.services.services.DocenteService;

import org.springframework.transaction.annotation.Transactional;

import co.edu.unicauca.asae.core.maestria_computacion.models.Docente;
import co.edu.unicauca.asae.core.maestria_computacion.repositories.DocenteRepository;
import co.edu.unicauca.asae.core.maestria_computacion.response.DocenteResponseRest;
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
        return null;
    }

    @Override
    public DocenteDTO upDocenteDTO(Integer id, DocenteDTO docente) {
        return null;
    }
    
    @Override
    public boolean deleteDocente(int id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public ResponseEntity<DocenteResponseRest> buscarPorNumeroyTipoIdentificacion(String numero, String tipo) {
        System.out.println("Invocando al metodo buscar por numero y tipo de identificación");
		Docente objEstudiante = this.docenteRepository.buscarPorNumeroyTipoIdentificacion(numero, tipo);  
       	System.out.println("Nombres: " + objEstudiante.getNombres());
		System.out.println("Apellidos: " + objEstudiante.getApellidos());
		DocenteResponseRest response = new DocenteResponseRest();
        response.getDocenteResponse().getDocentes().add(objEstudiante);
		return new ResponseEntity<DocenteResponseRest>(response, HttpStatus.OK); 
    }
}