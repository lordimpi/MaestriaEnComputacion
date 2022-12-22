package co.edu.unicauca.asae.core.maestria_computacion.services.DTO;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class PersonaDTO {
    
    private Integer id;
    
    @NotEmpty(message = "{person.id.empty}")
    @PositiveOrZero(message = "{person.id.positive}")
    @NotNull(message = "{person.id.null}")
    private String noId;
    
    @NotEmpty(message = "{person.typeIdentification.empty}")
    @NotNull(message = "{person.typeIdentification.null}")
    private String tipoIdentificacion;

    @NotEmpty(message = "{person.name.empty}")
    @Size(min = 3, max = 50, message = "{person.name.length}")
    @NotNull(message = "{person.name.null}")
    private String nombres;

    @NotEmpty(message = "{person.lastname.empty}")
    @Size(min = 3, max = 50, message = "{person.lastname.length}")
    @NotNull(message = "{person.lastname.null}")
    private String apellidos;    
}
