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

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class EstudianteDTO extends PersonaDTO {

    @NotNull(message = "{estudiante.email.empty}")
    @Email(message = "{estudiante.email.mask}")
    private String correoElectronico;

    @NotNull(message = "{estudiante.fechaingreso.empty}")
    @PastOrPresent(message = "{estudiante.date.past}")
    private Date fechaIngreso;

    private List<Telefono> telefonos;

    private Direccion objDireccion;
}
