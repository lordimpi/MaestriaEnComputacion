package co.edu.unicauca.asae.core.maestria_computacion.services.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @AllArgsConstructor @NoArgsConstructor
public class TelefonoDTO {
    
    private int id;

    
    @NotNull(message = "{telefono.tipo.empty}")
    private String tipo;

    @Pattern(message = "{telefono.numero.pattern}", regexp = "[8][0-9]{5,20}")
    @NotNull(message = "{telefono.numero.empty}")
    @NotEmpty(message = "{telefono.numero.empty}")
    private String numero;
    
}
