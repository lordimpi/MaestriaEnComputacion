package co.edu.unicauca.asae.core.maestria_computacion.services.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.asae.core.maestria_computacion.models.Asignatura;
import co.edu.unicauca.asae.core.maestria_computacion.models.Curso;
import co.edu.unicauca.asae.core.maestria_computacion.models.Docente;
import co.edu.unicauca.asae.core.maestria_computacion.models.Estudiante;
import co.edu.unicauca.asae.core.maestria_computacion.services.DTO.AsignaturaDTO;
import co.edu.unicauca.asae.core.maestria_computacion.services.DTO.CursoDTO;
import co.edu.unicauca.asae.core.maestria_computacion.services.DTO.DocenteDTO;
import co.edu.unicauca.asae.core.maestria_computacion.services.DTO.EstudianteDTO;

@Configuration
public class Mapper {
    @Bean(name = "asignatura")
    public ModelMapper asignaturaMapper() {
        ModelMapper objMapper = new ModelMapper();
        TypeMap<Asignatura, AsignaturaDTO> mapa = objMapper.emptyTypeMap(
                Asignatura.class, AsignaturaDTO.class);
        // mapa.addMappings(asg -> asg.skip(AsignaturaDTO::setId)).implicitMappings();
        // mapa.addMappings(asg ->
        // asg.skip(AsignaturaDTO::setNombre)).implicitMappings();
        mapa.addMappings(asg -> asg.skip(AsignaturaDTO::setDocentes)).implicitMappings();
        // mapa.addMappings(asg ->
        // asg.skip(AsignaturaDTO::setCursos)).implicitMappings();
        return objMapper;
    }

    @Bean(name = "asignaturaSinCursos")
    public ModelMapper asignaturaSinCursosMapper() {
        ModelMapper objMapper = new ModelMapper();
        TypeMap<Asignatura, AsignaturaDTO> mapa = objMapper.emptyTypeMap(
                Asignatura.class, AsignaturaDTO.class);
        // mapa.addMappings(asg -> asg.skip(AsignaturaDTO::setId)).implicitMappings();
        // mapa.addMappings(asg ->
        // asg.skip(AsignaturaDTO::setNombre)).implicitMappings();
        // mapa.addMappings(asg -> asg.skip(AsignaturaDTO::setDocentes)).implicitMappings();
        mapa.addMappings(asg -> asg.skip(AsignaturaDTO::setCursos)).implicitMappings();
        return objMapper;
    }

    @Bean(name = "curso")
    public ModelMapper cursoMapper() {
        ModelMapper objMapper = new ModelMapper();
        // TypeMap<Curso,CursoDTO> mapa = objMapper.emptyTypeMap(Curso.class,
        // CursoDTO.class);
        // mapa.addMappings(c -> c.skip(CursoDTO::setId)).implicitMappings();
        // mapa.addMappings(c -> c.skip(CursoDTO::setNombre)).implicitMappings();
        // mapa.addMappings(c -> c.skip(CursoDTO::setPeriodo)).implicitMappings();
        // mapa.addMappings(c -> c.skip(CursoDTO::setObjAsignatura)).implicitMappings();
        return objMapper;
    }

    @Bean(name = "estudiante")
    public ModelMapper estudianteMapper() {
        ModelMapper objMapper = new ModelMapper();
        // TypeMap<Curso,CursoDTO> mapa = objMapper.emptyTypeMap(Curso.class,
        // CursoDTO.class);
        // mapa.addMappings(c -> c.skip(CursoDTO::setId)).implicitMappings();
        // mapa.addMappings(c -> c.skip(CursoDTO::setNombre)).implicitMappings();
        // mapa.addMappings(c -> c.skip(CursoDTO::setPeriodo)).implicitMappings();
        // mapa.addMappings(c ->
        // c.skip(CursoDTO::setObjAsignaturaDTO)).implicitMappings();
        return objMapper;
    }

    @Bean(name = "direccion")
    public ModelMapper direccionMapper() {
        ModelMapper objMapper = new ModelMapper();
        // TypeMap<Curso,CursoDTO> mapa = objMapper.emptyTypeMap(Curso.class,
        // CursoDTO.class);
        // mapa.addMappings(c -> c.skip(CursoDTO::setId)).implicitMappings();
        // mapa.addMappings(c -> c.skip(CursoDTO::setNombre)).implicitMappings();
        // mapa.addMappings(c -> c.skip(CursoDTO::setPeriodo)).implicitMappings();
        // mapa.addMappings(c ->
        // c.skip(CursoDTO::setObjAsignaturaDTO)).implicitMappings();
        return objMapper;
    }

    @Bean(name = "docente")
    public ModelMapper docenentMapper() {
        ModelMapper objMapper = new ModelMapper();
        TypeMap<Docente, DocenteDTO> mapa = objMapper.emptyTypeMap(
                Docente.class, DocenteDTO.class);
        // mapa.addMappings(doc -> doc.skip(DocenteDTO::setId)).implicitMappings();
        // mapa.addMappings(doc ->
        // doc.skip(DocenteDTO::setApellidos)).implicitMappings();
        mapa.addMappings(doc -> doc.skip(DocenteDTO::setAsignaturas)).implicitMappings();
        // mapa.addMappings(doc -> doc.skip(DocenteDTO::setNoId)).implicitMappings();
        // mapa.addMappings(doc -> doc.skip(DocenteDTO::setNombres)).implicitMappings();
        // mapa.addMappings(doc -> doc.skip(DocenteDTO::setSalario)).implicitMappings();
        // mapa.addMappings(doc ->
        // doc.skip(DocenteDTO::setTipoDocente)).implicitMappings();
        // mapa.addMappings(doc ->
        // doc.skip(DocenteDTO::setTipoIdentificacion)).implicitMappings();
        // mapa.addMappings(doc ->
        // doc.skip(DocenteDTO::setUniversidad)).implicitMappings();
        return objMapper;
    }

    @Bean(name="estudianteLazy")
    public ModelMapper modelMapperEstudianteLazy(){
        ModelMapper objMapper = new ModelMapper();
        TypeMap<Estudiante, EstudianteDTO> mapa = objMapper.emptyTypeMap(Estudiante.class, EstudianteDTO.class);
        mapa.addMappings(asg -> asg.skip(EstudianteDTO::setObjDireccion)).implicitMappings();
        mapa.addMappings(asg -> asg.skip(EstudianteDTO::setTelefonos)).implicitMappings();
        return objMapper;
    }
}