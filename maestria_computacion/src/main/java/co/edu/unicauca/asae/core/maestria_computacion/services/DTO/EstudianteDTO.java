package co.edu.unicauca.asae.core.maestria_computacion.services.DTO;
import java.util.Date;
import java.util.List;

import co.edu.unicauca.asae.core.maestria_computacion.models.Direccion;
import co.edu.unicauca.asae.core.maestria_computacion.models.Telefono;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonInclude;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EstudianteDTO extends PersonaDTO {

    @NotEmpty(message = "{estudiante.correoelectronico.empty}")
    @NotNull(message = "{estudiante.correoelectronico.nulo}")
    @Email(message = "{estudiante.correoelectronico.email}")
    private String correoElectronico;

    @NotNull(message = "{estudiante.fechaingreso.nulo}")
    //NOTA: la notacion NotEmpty, no es soportada para formato de fecha
    @PastOrPresent(message = "{estudiante.date.past}")
    private Date fechaIngreso;

    @Valid
    private List<Telefono> telefonos;

    @Valid
    private Direccion objDireccion;
}
