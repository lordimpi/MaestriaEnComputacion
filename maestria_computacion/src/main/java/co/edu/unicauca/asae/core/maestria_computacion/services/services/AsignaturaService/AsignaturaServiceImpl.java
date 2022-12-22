package co.edu.unicauca.asae.core.maestria_computacion.services.services.AsignaturaService;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicauca.asae.core.maestria_computacion.exceptionControllers.exceptions.EntidadNoExisteException;
import co.edu.unicauca.asae.core.maestria_computacion.exceptionControllers.exceptions.EntidadYaExisteException;
import co.edu.unicauca.asae.core.maestria_computacion.models.Asignatura;
import co.edu.unicauca.asae.core.maestria_computacion.models.Curso;
import co.edu.unicauca.asae.core.maestria_computacion.models.Docente;
import co.edu.unicauca.asae.core.maestria_computacion.repositories.AsignaturaRepository;
import co.edu.unicauca.asae.core.maestria_computacion.services.DTO.AsignaturaDTO;

@Service
public class AsignaturaServiceImpl implements IAsignturaService {

    @Autowired
    private AsignaturaRepository asignaturaRepository;

    @Autowired
    @Qualifier("asignatura")
    private ModelMapper modelMapper;

    @Autowired
    @Qualifier("asignaturaSinCursos")
    private ModelMapper modelMapper2;

    @Override
    @Transactional()
    public AsignaturaDTO createAsignatura(AsignaturaDTO asignatura) {
        System.out.println("Invocando al metodo crear asignatura");
        
        Asignatura objAsignatura = modelMapper.map(asignatura, Asignatura.class);
        objAsignatura.getCursos().forEach(c -> c.setObjAsignatura(objAsignatura));
        for (var item : objAsignatura.getDocentes()) {
            item.setAsignaturas(new ArrayList<Asignatura>());
            item.getAsignaturas().add(objAsignatura);
        }
        Asignatura asignatura2 = asignaturaRepository.save(objAsignatura);
        return modelMapper.map(asignatura2, AsignaturaDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AsignaturaDTO> getAllAsignaturas() {
        System.out.println("Invocando al metodo buscar todas las asignaturas");
        Iterable<Asignatura> asignaturas = asignaturaRepository.findAll();
        List<AsignaturaDTO> asignaturasDTO = modelMapper.map(
                asignaturas, new TypeToken<List<AsignaturaDTO>>() {
                }.getType());
        return asignaturasDTO;
    }

    @Override
    public AsignaturaDTO getAsignaturaById(Integer id) {
        System.out.println("Invocando al metodo buscar asignatura por id");
        Asignatura asignatura = asignaturaRepository.findById(id).orElse(null);
        if (asignatura == null) {
            System.out.println("No exisite el asignatura con id: "+id);
            throw new EntidadNoExisteException("No existe la asignatura con id: " + id);
        }
        AsignaturaDTO asignaturaDTO = modelMapper2.map(asignatura, AsignaturaDTO.class);
        return asignaturaDTO;
    }

    @Override
    public AsignaturaDTO updateAsignatura(Integer id, AsignaturaDTO asignatura) {
        System.out.println("Invocando al metodo actualizar asignatura");
        Asignatura objAsignatura = asignaturaRepository.findById(id).orElse(null);
        AsignaturaDTO asignaturaDTO = null;

        if (objAsignatura != null) {
            objAsignatura.setNombre(asignatura.getNombre());
            List<Curso> cursos = modelMapper.map(asignatura.getCursos(), new TypeToken<List<Curso>>() {
            }.getType());
            List<Docente> docentes = modelMapper.map(asignatura.getDocentes(), new TypeToken<List<Docente>>() {
            }.getType());
            objAsignatura.setCursos(cursos);
            objAsignatura.setDocentes(docentes);
            objAsignatura.getCursos().forEach(c -> c.setObjAsignatura(objAsignatura));
            objAsignatura.getDocentes().forEach(d -> d.getAsignaturas().add(objAsignatura));
            Asignatura asignaturaModificada = asignaturaRepository.save(objAsignatura);
            asignaturaDTO = modelMapper.map(asignaturaModificada, AsignaturaDTO.class);
        }

        return asignaturaDTO;
    }

    @Override
    public boolean deleteAsignatura(Integer id) {
        System.out.println("Invocando al metodo eliminar asignatura");
        Asignatura asignatura = asignaturaRepository.findById(id).orElse(null);
        if (asignatura != null) {
            asignaturaRepository.delete(asignatura);
            return true;
        }
        throw new EntidadNoExisteException("No existe la asignatura con id: " + id);
    }

}
