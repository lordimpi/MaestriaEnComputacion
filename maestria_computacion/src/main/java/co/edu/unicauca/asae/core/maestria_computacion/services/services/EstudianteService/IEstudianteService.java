package co.edu.unicauca.asae.core.maestria_computacion.services.services.EstudianteService;

import java.util.Collection;
import java.util.List;

import org.springframework.http.ResponseEntity;

import co.edu.unicauca.asae.core.maestria_computacion.response.EstudianteResponse.EstudianteResponseRest;
import co.edu.unicauca.asae.core.maestria_computacion.services.DTO.EstudianteDTO;

public interface IEstudianteService {
    
    public EstudianteDTO createEstudiante(EstudianteDTO estudiante);

    public EstudianteDTO getEstudianteById(Integer id);

    public EstudianteDTO updateEstudiante(Integer id, EstudianteDTO estudianteConDatosNuevos);

    public boolean deleteEstudiante(Integer id);

    public List<EstudianteDTO> getAllEstudiante();

    public List<EstudianteDTO> getAllLazy();

    public EstudianteDTO getByIdLazy(Integer id);

    public List<EstudianteDTO> buscarPorPatron(String patron);

    public List<EstudianteDTO> findByIdPorRango(int id1, int id2);
    
    public ResponseEntity<EstudianteResponseRest> buscarPorNumeroyTipoIdentificacion(String numero, String tipo);

}
