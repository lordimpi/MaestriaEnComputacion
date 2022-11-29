package co.edu.unicauca.asae.core.maestria_computacion.services.services.CursoService;

import java.util.List;

import co.edu.unicauca.asae.core.maestria_computacion.services.DTO.CursoDTO;

public interface ICursoService {
    public CursoDTO createCurso(CursoDTO curso);

    public CursoDTO getCursoById(Integer id);

    public CursoDTO updateCurso(Integer id, CursoDTO curso);

    public boolean deleteCurso(Integer id);

    public List<CursoDTO> getAllCursos();
}
