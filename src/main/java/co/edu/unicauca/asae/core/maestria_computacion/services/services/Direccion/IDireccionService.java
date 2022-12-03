package co.edu.unicauca.asae.core.maestria_computacion.services.services.Direccion;

import java.util.List;

import co.edu.unicauca.asae.core.maestria_computacion.services.DTO.DireccionDTO;

public interface IDireccionService {
    public DireccionDTO createDireccion(DireccionDTO direccion);

    public DireccionDTO getDireccionById(Integer id);

    public DireccionDTO updateDireccion(Integer id, DireccionDTO estudiante);

    public boolean deleteDireccion(Integer id);

    public List<DireccionDTO> getAllDireccion();
}
