package co.edu.unicauca.asae.core.maestria_computacion.services.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.asae.core.maestria_computacion.models.Asignatura;
import co.edu.unicauca.asae.core.maestria_computacion.models.Curso;
import co.edu.unicauca.asae.core.maestria_computacion.services.DTO.AsignaturaDTO;
import co.edu.unicauca.asae.core.maestria_computacion.services.DTO.CursoDTO;

@Configuration
public class Mapper {
    @Bean(name = "asignatura")
    public ModelMapper asignaturaMapper(){
        ModelMapper objMapper = new ModelMapper();
        TypeMap<Asignatura,AsignaturaDTO> mapa = objMapper.emptyTypeMap(
              Asignatura.class, AsignaturaDTO.class);
        // mapa.addMappings(asg -> asg.skip(AsignaturaDTO::setId)).implicitMappings();
        // mapa.addMappings(asg -> asg.skip(AsignaturaDTO::setNombre)).implicitMappings();
        mapa.addMappings(asg -> asg.skip(AsignaturaDTO::setDocentes)).implicitMappings();
        // mapa.addMappings(asg -> asg.skip(AsignaturaDTO::setCursos)).implicitMappings();
        return objMapper;
    }    

    @Bean(name = "curso")
    public ModelMapper cursoMapper(){
        ModelMapper objMapper = new ModelMapper();
        // TypeMap<Curso,CursoDTO> mapa = objMapper.emptyTypeMap(Curso.class, CursoDTO.class);
        // mapa.addMappings(c -> c.skip(CursoDTO::setId)).implicitMappings();
        // mapa.addMappings(c -> c.skip(CursoDTO::setNombre)).implicitMappings();
        // mapa.addMappings(c -> c.skip(CursoDTO::setPeriodo)).implicitMappings();
        // mapa.addMappings(c -> c.skip(CursoDTO::setObjAsignaturaDTO)).implicitMappings();
        return objMapper;
    } 
}