package co.edu.unicauca.asae.core.maestria_computacion.services.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @AllArgsConstructor @NoArgsConstructor
public class TelefonoDTO {

    private int id;

    private String tipo;

    private String numero;
}
