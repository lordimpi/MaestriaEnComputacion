package co.edu.unicauca.asae.core.maestria_computacion.services.DTO;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DocenteDTO extends PersonaDTO{
    
    @NotEmpty(message = "{docente.universidad.empty}")
    @NotNull(message = "{docente.universidad.null}")
    private String universidad;
    
    @NotEmpty(message = "{docente.tipodocente.empty}")
    @NotNull(message = "{docente.tipodocente.null}")
    private String tipoDocente;

    // @NotEmpty(message = "{docente.salario.empty}")
    @PositiveOrZero(message = "{docente.salario.positive}")
    @NotNull(message = "{docente.salario.null}")
    private float salario;

    private List<AsignaturaDTO> asignaturas;

}