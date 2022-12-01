package co.edu.unicauca.asae.core.maestria_computacion.services.services.EstudianteService;

import java.util.List;

import co.edu.unicauca.asae.core.maestria_computacion.services.DTO.EstudianteDTO;

public interface IEstudianteService {
    
    public EstudianteDTO createEstudiante(EstudianteDTO estudiante);

    public EstudianteDTO getEstudianteById(Integer id);

    public EstudianteDTO updateEstudiante(Integer id, EstudianteDTO estudiante);

    public boolean deleteEstudiante(Integer id);

    public List<EstudianteDTO> getAllEstudiante();
    
}
