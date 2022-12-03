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

    @Override
    public EstudianteDTO createEstudiante(EstudianteDTO estudiante) {
        EstudianteDTO  estudianteDTO = null;
        
            System.out.println("invocando al metodo crear estudiante");
            Estudiante objEstudiante = this.modelMapper.map(estudiante,Estudiante.class);
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
        }
        else
        {
            System.out.println("Estudiante No encontrado");   
        }
        return result;
    }

    @Override
    public List<EstudianteDTO> getAllEstudiante() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public EstudianteDTO getEstudianteById(Integer id) {
        Optional<Estudiante> estudiante = estudianteRepository.findById(id);        
        EstudianteDTO estudianteDTO = modelMapper.map(estudiante, EstudianteDTO.class);
        return estudianteDTO;
    }

    @Override
    @Transactional(readOnly = false)
    public EstudianteDTO updateEstudiante(Integer id, EstudianteDTO estudianteConDatosNuevos) {
        Optional<Estudiante> optional = this.estudianteRepository.findById(id);
		EstudianteDTO estudianteDTOActualizado = null;
		Estudiante objEstudianteAlmacenado = optional.get();
        if (objEstudianteAlmacenado != null) {			
			objEstudianteAlmacenado.setNombres(estudianteConDatosNuevos.getNombres());
			objEstudianteAlmacenado.setApellidos(estudianteConDatosNuevos.getApellidos());
			objEstudianteAlmacenado.setNoId(estudianteConDatosNuevos.getNoId());
            objEstudianteAlmacenado.setTipoIdentificacion(estudianteConDatosNuevos.getTipoIdentificacion());
			Direccion objDireccionAlmacenada = objEstudianteAlmacenado.getObjDireccion();
			objDireccionAlmacenada.setDireccionResidencia(estudianteConDatosNuevos.getObjDireccion().getDireccionResidencia());
			objDireccionAlmacenada.setCiudad(estudianteConDatosNuevos.getObjDireccion().getCiudad());
			objDireccionAlmacenada.setPais(estudianteConDatosNuevos.getObjDireccion().getPais());

            List<Telefono> Telefonos = modelMapper.map(estudianteConDatosNuevos.getTelefonos(), new TypeToken<List<Telefono>>() {
            }.getType());
            objEstudianteAlmacenado.setTelefonos(Telefonos);
            objEstudianteAlmacenado.getTelefonos().forEach(c -> c.setObjEstudiante(objEstudianteAlmacenado));

			Estudiante estudianteEntityActualizado = this.estudianteRepository.save(objEstudianteAlmacenado);
			estudianteDTOActualizado = this.modelMapper.map(estudianteEntityActualizado, EstudianteDTO.class);
		}
        else
        {
            System.out.println("Error Fatal: Estudiante No encontrado");
        }


        return estudianteDTOActualizado;
    }
    
}
