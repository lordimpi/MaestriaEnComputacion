package co.edu.unicauca.asae.core.maestria_computacion.services.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @AllArgsConstructor @NoArgsConstructor
public class PersonaDTO {
    private int id;

    private String noId;

    private String nombres;

    private String apellidos;    
}
