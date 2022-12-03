package co.edu.unicauca.asae.core.maestria_computacion.services.services.CursoService;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicauca.asae.core.maestria_computacion.models.Curso;
import co.edu.unicauca.asae.core.maestria_computacion.repositories.CursoRepository;
import co.edu.unicauca.asae.core.maestria_computacion.services.DTO.CursoDTO;



@Service
public class CursoServiceImpl implements ICursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    @Qualifier("curso")
    private ModelMapper modelMapper;

    @Override
    @Transactional(readOnly = true)
    public List<CursoDTO> getAllCursos() {
        modelMapper.getConfiguration().setPreferNestedProperties(false);
        System.out.println("Invocando a listar cursos");
        Iterable<Curso> cursos = cursoRepository.findAll();
        List<CursoDTO> cursosDTO = modelMapper.map(cursos, new TypeToken<List<CursoDTO>>() {
        }.getType());
        return cursosDTO;
    }
    @Override
    
    @Transactional()
    public CursoDTO createCurso(CursoDTO curso) {
        System.out.println("Invocando al metodo crear curso");
        Curso objCurso = modelMapper.map(curso, Curso.class);
        CursoDTO cursoDTO = null;
        Curso cursoAlmacenado = cursoRepository.save(objCurso);
        cursoDTO = modelMapper.map(cursoAlmacenado, CursoDTO.class);
        return cursoDTO;
    }

    @Override
    @Transactional(readOnly = true)
    public CursoDTO getCursoById(Integer id) {
        System.out.println("Invocando al metodo buscar curso por id: " + id);
        Curso curso = cursoRepository.findById(id).orElse(null);
        if (curso == null) {
            System.out.println("No exisite el curso con id: "+id);
            return null;
        }
        CursoDTO cursoDTO = modelMapper.map(curso, CursoDTO.class);
        return cursoDTO;
    }
    
    @Override
    @Transactional(readOnly = false)
    public CursoDTO updateCurso(Integer id, CursoDTO curso) {
        System.out.println("Invocando al metodo actualizar curso");
        Curso objCurso = cursoRepository.findById(id).orElse(null);
        CursoDTO cursoDTO = null;
        if (objCurso != null) {
            objCurso.setNombre(curso.getNombre());
            objCurso.setPeriodo(curso.getPeriodo());
            objCurso.setObjAsignatura(objCurso.getObjAsignatura());
            objCurso = cursoRepository.save(objCurso);
            cursoDTO = modelMapper.map(objCurso, CursoDTO.class);
        }

        return cursoDTO;
    }

    @Override
    @Transactional(readOnly = false)
    public boolean deleteCurso(Integer id) {
        System.out.println("Invocando al metodo eliminar curso por id: " + id);
        boolean result = false;
        Curso curso = cursoRepository.findById(id).orElse(null);
        if (curso != null) {
            cursoRepository.delete(curso);
            result = true;
        }
        return result;
    }


}
