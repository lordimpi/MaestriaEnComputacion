package co.edu.unicauca.asae.core.maestria_computacion.services.services.DocenteService;

import org.springframework.transaction.annotation.Transactional;

import co.edu.unicauca.asae.core.maestria_computacion.models.Docente;
import co.edu.unicauca.asae.core.maestria_computacion.repositories.DocenteRepository;
import co.edu.unicauca.asae.core.maestria_computacion.services.DTO.DocenteDTO;

import java.util.List;

import org.modelmapper.TypeToken;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class DocenteServiceImpl implements IDocenteService {

    @Autowired
    private DocenteRepository docenteRepository;

    @Autowired
    @Qualifier("docente")
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public DocenteDTO createDocente(DocenteDTO docente) {
        System.out.println("invocando al metodo crear docente");
        Docente objDocente = modelMapper.map(docente, Docente.class);
        Docente docenteEntity = docenteRepository.save(objDocente);
        DocenteDTO docenteDTO = modelMapper.map(docenteEntity, DocenteDTO.class);

        return docenteDTO;
    }

    @Override
    @Transactional(readOnly = true)
    public List<DocenteDTO> getAllDocente() {
        Iterable<Docente> docentes = docenteRepository.findAll();
        System.out.println("invocando al metodo listar docentes");
        List<DocenteDTO> docenteDTOs = modelMapper.map(docentes,
                new TypeToken<List<DocenteDTO>>() {}.getType());
        return docenteDTOs;
    }

    @Override
    public DocenteDTO getDocenteById(Integer id) {
        return null;
    }

    @Override
    public DocenteDTO upDocenteDTO(Integer id, DocenteDTO docente) {
        return null;
    }

    @Override
    public boolean deleteDocente(int id) {
        // TODO Auto-generated method stub
        return false;
    }

}