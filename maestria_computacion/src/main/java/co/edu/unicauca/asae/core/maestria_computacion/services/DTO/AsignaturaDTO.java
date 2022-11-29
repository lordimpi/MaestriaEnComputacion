package co.edu.unicauca.asae.core.maestria_computacion.services.DTO;

import java.util.List;

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

    private List<CursoDTO> cursos;
    private List<DocenteDTO> docentes;
}