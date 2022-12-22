package co.edu.unicauca.asae.core.maestria_computacion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asae.core.maestria_computacion.response.EstudianteResponse.EstudianteResponseRest;
import co.edu.unicauca.asae.core.maestria_computacion.services.DTO.EstudianteDTO;
import co.edu.unicauca.asae.core.maestria_computacion.services.services.EstudianteService.IEstudianteService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
@Validated
public class EstudianteRestController {

    @Autowired
    private IEstudianteService estudianteService;

    @GetMapping("/estudiantes")
    public List<EstudianteDTO> index() {
        return estudianteService.getAllEstudiante();
    }

    @GetMapping("/estudiantes/{id}")
    public EstudianteDTO show(@PathVariable Integer id) {
        return estudianteService.getEstudianteById(id);
    }


    @PostMapping("/estudiantes")
    public ResponseEntity<EstudianteDTO> create(@Valid @RequestBody EstudianteDTO estudiante) {
        EstudianteDTO objEstudiante = null;
        objEstudiante = estudianteService.createEstudiante(estudiante);
        ResponseEntity<EstudianteDTO> objRespuesta = new ResponseEntity<EstudianteDTO>(objEstudiante, HttpStatus.CREATED);
		return objRespuesta;
    }

    @DeleteMapping("/estudiantes/{id}")
    public Boolean delete(@PathVariable Integer id) {
        Boolean bandera = false;
        EstudianteDTO estudianteActual = estudianteService.getEstudianteById(id);
        if (estudianteActual != null) {
            bandera = estudianteService.deleteEstudiante(id);
        }
        return bandera;
    }

    @PutMapping("/estudiantes/{id}")
    public EstudianteDTO update(@RequestBody EstudianteDTO estudiante, @PathVariable Integer id) {
        EstudianteDTO objEstudiante = null;
        EstudianteDTO estudianteActual = estudianteService.getEstudianteById(id);
        if (estudianteActual != null) {
            objEstudiante = estudianteService.updateEstudiante(id, estudiante);
        }
        return objEstudiante;
    }

    @GetMapping("/estudiantes/lazy")
    public List<EstudianteDTO> indexLazy(){
        return estudianteService.getAllLazy();
    }

    @GetMapping("/estudiantes/lazy/{id}")
    public EstudianteDTO showLazy(@PathVariable Integer id){
        return estudianteService.getByIdLazy(id);
    }

    @GetMapping("/estudiantes/buscarporpatron/{patron}")
    public List<EstudianteDTO> buscarPorPatron(@PathVariable String patron){
        System.out.println(patron);
        return estudianteService.buscarPorPatron(patron);
    }

    @GetMapping("/estudiantes/buscarpornumeroytipo/{numero}/{tipo}")
	public ResponseEntity<EstudianteResponseRest> buscarPorNumeroyTipo(@PathVariable String numero, @PathVariable String tipo) {
		ResponseEntity<EstudianteResponseRest> response = this.estudianteService.buscarPorNumeroyTipoIdentificacion(numero, tipo);
		return response;
	}
}
