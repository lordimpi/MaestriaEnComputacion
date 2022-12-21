package co.edu.unicauca.asae.core.maestria_computacion.services.DTO;

import co.edu.unicauca.asae.core.maestria_computacion.models.Asignatura;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CursoDTO {
    
    private int id;
    
    @NotNull(message = "{curso.name.empty}")
    @Size(min = 5, max = 25, message = "{curso.name.length}")
    private String nombre;

    @Pattern(message = "{curso.periodo.pattern}", regexp = "[1-2]{1}")
    @NotNull(message = "{curso.periodo.empty}")
    @PositiveOrZero(message = "{curso.periodo.positive}")
    private int periodo;

    private Asignatura objAsignatura;
}