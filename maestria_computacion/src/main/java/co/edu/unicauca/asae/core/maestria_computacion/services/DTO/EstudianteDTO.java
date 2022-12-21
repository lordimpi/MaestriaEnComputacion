package co.edu.unicauca.asae.core.maestria_computacion.services.DTO;
import java.util.Date;
import java.util.List;

import co.edu.unicauca.asae.core.maestria_computacion.models.Direccion;
import co.edu.unicauca.asae.core.maestria_computacion.models.Telefono;
import jakarta.validation.constraints.Email;
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

    @NotNull(message = "NO DEBE SER NULO")
    @Email(message = "DEBE SER EMAIL")
    private String correoElectronico;

    @NotNull(message = "{estudiante.fechaingreso.empty}")
    @PastOrPresent(message = "{estudiante.date.past}")
    private Date fechaIngreso;

    private List<Telefono> telefonos;

    private Direccion objDireccion;
}
