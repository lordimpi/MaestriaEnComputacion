package co.edu.unicauca.asae.core.maestria_computacion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asae.core.maestria_computacion.services.DTO.CursoDTO;
import co.edu.unicauca.asae.core.maestria_computacion.services.services.CursoService.ICursoService;

@RestController
@RequestMapping("/api")
@Validated
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CursoRestController {

    @Autowired
    private ICursoService cursoService;

    @GetMapping("/cursos")
    public List<CursoDTO> index() {
        List<CursoDTO> cursos = cursoService.getAllCursos();
        return cursos;
    }

    @GetMapping("/cursos/{id}")
    public CursoDTO show(@PathVariable Integer id) {
        CursoDTO curso = cursoService.getCursoById(id);
        return curso;
    }

    @PostMapping("/cursos")
    public CursoDTO create(@RequestBody CursoDTO curso) {
        CursoDTO cursoDTO = null;
        cursoDTO = cursoService.createCurso(curso);
        return cursoDTO;
    }

    @PutMapping("/cursos")
    public CursoDTO update(@RequestBody CursoDTO curso, @PathVariable Integer id) {
        CursoDTO cursoDTO = null;
        CursoDTO cursoActual = cursoService.getCursoById(id);

        if (cursoActual != null) {
            cursoDTO = cursoService.updateCurso(id, cursoDTO);
        }

        return cursoDTO;
    }

    @DeleteMapping("/cursos/{id}")
    public boolean delete(@PathVariable Integer id) {
        boolean result = false;
        CursoDTO curso = cursoService.getCursoById(id);
        if (curso != null) {
            result = cursoService.deleteCurso(id);
        }
        return result;
    }
}
