package co.edu.unicauca.asae.core.maestria_computacion.services.services.DocenteService;

import java.util.List;

import co.edu.unicauca.asae.core.maestria_computacion.services.DTO.DocenteDTO;

public interface IDocenteService {
    public DocenteDTO createDocente(DocenteDTO docente);

    public List<DocenteDTO> getAllDocente();

    public DocenteDTO getDocenteById(Integer id);

    public DocenteDTO upDocenteDTO(Integer id, DocenteDTO docente);

    public boolean deleteDocente(int id);
}