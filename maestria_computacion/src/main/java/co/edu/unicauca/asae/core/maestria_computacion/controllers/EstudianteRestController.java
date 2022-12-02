package co.edu.unicauca.asae.core.maestria_computacion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asae.core.maestria_computacion.services.DTO.EstudianteDTO;
import co.edu.unicauca.asae.core.maestria_computacion.services.services.EstudianteService.IEstudianteService;

@RestController
@RequestMapping("/api")
@Validated
public class EstudianteRestController {
    
    @Autowired
    private IEstudianteService estudianteService;

    @GetMapping("/estudiantes/{id}")
    public EstudianteDTO show(@PathVariable Integer id){
        return estudianteService.getEstudianteById(id);
    }

    @PostMapping("/estudiantes")
    public EstudianteDTO create(@RequestBody EstudianteDTO estudiante){
        EstudianteDTO objEstudiante = null;
        objEstudiante = estudianteService.createEstudiante(estudiante);
        return objEstudiante;
    }

    @DeleteMapping("/estudiantes/{id}")
    public Boolean delete(@PathVariable Integer id){
        Boolean bandera=false;
        EstudianteDTO estudianteActual =  estudianteService.getEstudianteById(id);
        if (estudianteActual!=null) {
            bandera = estudianteService.deleteEstudiante(id);
        }
        return bandera;
    }
}
