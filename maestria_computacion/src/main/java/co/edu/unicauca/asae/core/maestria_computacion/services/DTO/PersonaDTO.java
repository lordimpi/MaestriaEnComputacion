package co.edu.unicauca.asae.core.maestria_computacion.services.DTO;
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
    
    @PositiveOrZero(message = "DEBE SER POSITIVOOOOO")
    @NotNull(message = "NO DEBE SER NULO")
    private String noId;
    
    @NotNull(message = "{person.typeIdentification.empty}")
    private String tipoIdentificacion;

    @Size(min = 3, max = 50, message = "{person.name.length}")
    @NotNull(message = "{person.name.empty}")
    private String nombres;

    @Size(min = 3, max = 50, message = "{person.lastname.length}")
    @NotNull(message = "{person.lastname.empty}")
    private String apellidos;    
}
