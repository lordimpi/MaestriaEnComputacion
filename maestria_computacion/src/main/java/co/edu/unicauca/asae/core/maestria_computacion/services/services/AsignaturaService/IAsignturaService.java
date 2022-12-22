package co.edu.unicauca.asae.core.maestria_computacion.services.services.AsignaturaService;

import java.util.List;

import co.edu.unicauca.asae.core.maestria_computacion.services.DTO.AsignaturaDTO;

public interface IAsignturaService {
    public AsignaturaDTO createAsignatura(AsignaturaDTO asignatura);

    public List<AsignaturaDTO> getAllAsignaturas();

    public AsignaturaDTO getAsignaturaById(Integer id);

    public AsignaturaDTO updateAsignatura(Integer id, AsignaturaDTO asignatura);

    public boolean deleteAsignatura(Integer id);

    public List<AsignaturaDTO> findByNombreIgnoreCaseContainsOrderByNombre(String name);
}
