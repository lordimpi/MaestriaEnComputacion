package co.edu.unicauca.asae.core.maestria_computacion.services.DTO;

import java.util.List;

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
public class DocenteDTO {
    private Integer id;
    private String noId;
    private String tipoIdentificacion;
    private String nombres;
    private String apellidos;
    
    @NotNull(message = "{docente.universidad.empty}")
    private String universidad;
    
    @NotNull(message = "{docente.tipodocente.empty}")
    private String tipoDocente;

    @PositiveOrZero(message = "{docente.salario.positive}")
    @NotNull(message = "{docente.salario.empty}")
    private float salario;

    private List<AsignaturaDTO> asignaturas;

}