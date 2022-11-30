package co.edu.unicauca.asae.core.maestria_computacion.services.DTO;

import java.util.List;

import co.edu.unicauca.asae.core.maestria_computacion.models.Curso;
import co.edu.unicauca.asae.core.maestria_computacion.models.Docente;
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
    private String nombre;

    private List<Curso> cursos;
    private List<Docente> docentes;
}