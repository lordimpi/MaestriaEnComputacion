package co.edu.unicauca.asae.core.maestria_computacion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asae.core.maestria_computacion.response.EstudianteResponse.EstudianteResponseRest;
import co.edu.unicauca.asae.core.maestria_computacion.services.DTO.EstudianteDTO;
import co.edu.unicauca.asae.core.maestria_computacion.services.services.EstudianteService.IEstudianteService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;


@RestController
@RequestMapping("/api")
@Validated
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EstudianteRestController {

    @Autowired
    private IEstudianteService estudianteService;

    @GetMapping("/estudiantes")
    public List<EstudianteDTO> index() {
        return estudianteService.getAllEstudiante();
    }

    @GetMapping("/estudiantes/{id}")
    public ResponseEntity<EstudianteDTO> show(@PathVariable Integer id) {
        EstudianteDTO estudianteActual = estudianteService.getEstudianteById(id);
        if (estudianteActual != null)
        {
            return new ResponseEntity<EstudianteDTO>(estudianteActual,HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<EstudianteDTO>(estudianteActual, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/estudiantes")
    public ResponseEntity<EstudianteDTO> create(@Valid @RequestBody EstudianteDTO estudiante) {
        EstudianteDTO objEstudiante = null;
        objEstudiante = estudianteService.createEstudiante(estudiante);
        ResponseEntity<EstudianteDTO> objRespuesta = new ResponseEntity<EstudianteDTO>(objEstudiante,
                HttpStatus.CREATED);
        return objRespuesta;
    }

    @DeleteMapping("/estudiantes/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
        Boolean bandera = false;
        EstudianteDTO estudianteActual = estudianteService.getEstudianteById(id);
        if (estudianteActual != null) {
            bandera = estudianteService.deleteEstudiante(id);
            return new ResponseEntity<Boolean>(bandera,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<Boolean>(bandera, HttpStatus.NOT_FOUND);
        }
        
    }

    @PutMapping("/estudiantes/{id}")
    public ResponseEntity<EstudianteDTO> update(@RequestBody EstudianteDTO estudiante, @PathVariable Integer id) {
        EstudianteDTO objEstudiante = null;
        EstudianteDTO estudianteActual = estudianteService.getEstudianteById(id);
        if (estudianteActual != null) {
            objEstudiante = estudianteService.updateEstudiante(id, estudiante);
            return new ResponseEntity<EstudianteDTO>(objEstudiante,HttpStatus.OK);
        }
        else
        {           
            return new ResponseEntity<EstudianteDTO>(objEstudiante, HttpStatus.NOT_FOUND);
            
        }
    }

    @GetMapping("/estudiantes/lazy")
    public List<EstudianteDTO> indexLazy() {
        return estudianteService.getAllLazy();
    }

    @GetMapping("/estudiantes/lazy/{id}")
    public EstudianteDTO showLazy(@PathVariable Integer id) {
        return estudianteService.getByIdLazy(id);
    }

    @GetMapping("/estudiantes/existByEmail/{email}")
    public boolean existByEmail(
            @PathVariable @NotEmpty(message = "{estudiante.correoelectronico.empty}") @Email(message = "{estudiante.correoelectronico.email}") String email) {
        return estudianteService.existByEmail(email);
    }

    @GetMapping("/estudiantes/buscarporpatron/{patron}")
    public List<EstudianteDTO> buscarPorPatron(@PathVariable String patron) {
        System.out.println(patron);
        return estudianteService.buscarPorPatron(patron);
    }

    @GetMapping("/estudiantes/{id1}/{id2}")
    public ResponseEntity<List<EstudianteDTO>> showRangoEstudiantes(@PathVariable Integer id1, @PathVariable Integer id2) {
        List<EstudianteDTO> lista = null;
        System.out.println("Buscando en el rango: " + id1 + " y " + id2);        
        lista = estudianteService.findByIdPorRango(id1, id2);
        if(lista.isEmpty())
        {
            return new ResponseEntity<List<EstudianteDTO>>(lista,HttpStatus.NOT_FOUND); 
        }
        else
        {
            return new ResponseEntity<List<EstudianteDTO>>(lista,HttpStatus.OK);
        }
        
    }

    @GetMapping("/estudiantes/buscarpornumeroytipo/{numero}/{tipo}")
	public ResponseEntity<EstudianteResponseRest> buscarPorNumeroyTipo(@PathVariable String numero, @PathVariable String tipo) {
		ResponseEntity<EstudianteResponseRest> response = this.estudianteService.buscarPorNumeroyTipoIdentificacion(numero, tipo);
		return response;
	}

    @GetMapping("/estudiantes/ids")    
    public ResponseEntity<List<EstudianteDTO>> encontrarestudiantesporids(@PathVariable @RequestParam("ids") @RequestBody List<Integer> ids){
        ids.forEach(System.out::println);
        List<EstudianteDTO> estudiantes = this.estudianteService.findAllporids(ids);
        if(estudiantes.isEmpty()){
            return new ResponseEntity<List<EstudianteDTO>>(estudiantes, HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<List<EstudianteDTO>>(estudiantes,HttpStatus.OK);
        }        
    }

    @GetMapping("/estudiantes/ids2/{ids}")
    public ResponseEntity<List<EstudianteDTO>> encontrarporids(@PathVariable List<Integer> ids){
        ids.forEach(System.out::println);        
        List<EstudianteDTO> estudiantes = this.estudianteService.findAllporids(ids);
        if(estudiantes.isEmpty())
        {
            return new ResponseEntity<List<EstudianteDTO>>(estudiantes, HttpStatus.NOT_FOUND);
        } 
        else
        {
            return new ResponseEntity<List<EstudianteDTO>>(estudiantes,HttpStatus.OK);
        }
    }
    
}
