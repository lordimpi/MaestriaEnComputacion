package co.edu.unicauca.asae.core.maestria_computacion.services.DTO;
import java.util.Date;
import java.util.List;

import co.edu.unicauca.asae.core.maestria_computacion.models.Direccion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class EstudianteDTO extends PersonaDTO {
    private Date fechaIngreso;

    private List<TelefonoDTO> telefonos;

    private Direccion objDireccion;
}
