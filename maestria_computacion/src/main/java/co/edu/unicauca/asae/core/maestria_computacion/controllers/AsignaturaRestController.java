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

import co.edu.unicauca.asae.core.maestria_computacion.services.DTO.AsignaturaDTO;
import co.edu.unicauca.asae.core.maestria_computacion.services.services.AsignaturaService.IAsignturaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
@Validated
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AsignaturaRestController {

    @Autowired
    private IAsignturaService asignaturaService;

    @GetMapping("/asignaturas")
    public List<AsignaturaDTO> index() {
        List<AsignaturaDTO> asignaturas = asignaturaService.getAllAsignaturas();
        return asignaturas;
    }

    @GetMapping("/asignaturas/{id}")
    public AsignaturaDTO show(@PathVariable Integer id) {
        AsignaturaDTO asignatura = asignaturaService.getAsignaturaById(id);
        return asignatura;
    }

    @GetMapping("/asignaturas/likeName/{name}")
    public List<AsignaturaDTO> findByNombreIgnoreCaseContainsOrderByNombre(@PathVariable String name) {
        List<AsignaturaDTO> asignaturas = asignaturaService.findByNombreIgnoreCaseContainsOrderByNombre(name);
        return asignaturas;
    }

    @PostMapping("/asignaturas")
    public AsignaturaDTO create(@Valid @RequestBody AsignaturaDTO asignatura) {
        AsignaturaDTO asignaturaDTO = null;
        asignaturaDTO = asignaturaService.createAsignatura(asignatura);
        return asignaturaDTO;
    }

    @PutMapping("/asignaturas")
    public AsignaturaDTO update(@RequestBody AsignaturaDTO asignatura, @PathVariable Integer id) {
        AsignaturaDTO asignaturaDTO = null;
        AsignaturaDTO asignaturaActual = asignaturaService.getAsignaturaById(id);

        if (asignaturaActual != null) {
            asignaturaDTO = asignaturaService.updateAsignatura(id, asignaturaDTO);
        }

        return asignaturaDTO;
    }

    @DeleteMapping("/asignaturas/{id}")
    public boolean delete(@PathVariable Integer id) {
        boolean result = false;
        AsignaturaDTO asignaturaActual = asignaturaService.getAsignaturaById(id);
        if (asignaturaActual != null) {
            result = asignaturaService.deleteAsignatura(id);
        }
        return result;
    }

}
