package co.edu.unicauca.asae.core.maestria_computacion.services.DTO;

import java.util.List;

import co.edu.unicauca.asae.core.maestria_computacion.models.Curso;
import co.edu.unicauca.asae.core.maestria_computacion.models.Docente;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AsignaturaDTO {

    private Integer id;
    
    @NotNull(message = "asignatura.name.empty")
    @Size(min = 3, max = 25, message = "{asignatura.name.length}")
    private String nombre;

    private List<Curso> cursos;
    private List<Docente> docentes;
}