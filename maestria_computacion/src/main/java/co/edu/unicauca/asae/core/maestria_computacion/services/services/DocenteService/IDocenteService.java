package co.edu.unicauca.asae.core.maestria_computacion.services.services.DocenteService;

import java.util.List;

import org.springframework.http.ResponseEntity;

import co.edu.unicauca.asae.core.maestria_computacion.response.DocenteResponseRest;
import co.edu.unicauca.asae.core.maestria_computacion.services.DTO.DocenteDTO;

public interface IDocenteService {
    public DocenteDTO createDocente(DocenteDTO docente);

    public List<DocenteDTO> getAllDocente();

    public DocenteDTO getDocenteById(Integer id);

    public DocenteDTO upDocenteDTO(Integer id, DocenteDTO docente);

    public boolean deleteDocente(int id);

    public ResponseEntity<DocenteResponseRest> buscarPorNumeroyTipoIdentificacion(String numero, String tipo);
}