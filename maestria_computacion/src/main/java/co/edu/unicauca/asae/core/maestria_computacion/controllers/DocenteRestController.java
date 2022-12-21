package co.edu.unicauca.asae.core.maestria_computacion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asae.core.maestria_computacion.services.DTO.DocenteDTO;
import co.edu.unicauca.asae.core.maestria_computacion.services.services.DocenteService.IDocenteService;
import jakarta.validation.*;

@RestController
@RequestMapping("/api")
@Validated
public class DocenteRestController {
    @Autowired
    private IDocenteService docenteService;

    @PostMapping("/docentes")
    public DocenteDTO create(@Valid @RequestBody DocenteDTO docente){
        DocenteDTO docenteDTO = null;
        docenteDTO = docenteService.createDocente(docente);
        return docenteDTO;
    }
    @GetMapping("/docentes")
	public List<DocenteDTO> index() {
		return docenteService.getAllDocente();
	}

}