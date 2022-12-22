package co.edu.unicauca.asae.core.maestria_computacion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asae.core.maestria_computacion.response.DocenteResponseRest;
import co.edu.unicauca.asae.core.maestria_computacion.services.DTO.DocenteDTO;
import co.edu.unicauca.asae.core.maestria_computacion.services.services.DocenteService.IDocenteService;
import jakarta.validation.Valid;

@Validated
@RestController
@RequestMapping("/api")
public class DocenteRestController {
    @Autowired
    private IDocenteService docenteService;

    @PostMapping("/docentes")
    public DocenteDTO create(@Valid @RequestBody DocenteDTO docente) {
        DocenteDTO docenteDTO = null;
        docenteDTO = docenteService.createDocente(docente);
        return docenteDTO;
    }

    @GetMapping("/docentes")
    public List<DocenteDTO> index() {
        return docenteService.getAllDocente();
    }

    @GetMapping("/docentes/buscarpornumeroytipo/{numero}/{tipo}")
	public ResponseEntity<DocenteResponseRest> buscarPorNumeroyTipo(@PathVariable String numero, @PathVariable String tipo) {
		ResponseEntity<DocenteResponseRest> response = this.docenteService.buscarPorNumeroyTipoIdentificacion(numero, tipo);
		return response;
	}

}