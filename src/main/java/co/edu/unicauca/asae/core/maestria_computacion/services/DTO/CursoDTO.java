package co.edu.unicauca.asae.core.maestria_computacion.services.DTO;

import co.edu.unicauca.asae.core.maestria_computacion.models.Asignatura;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CursoDTO {
    
    private int id;
    private String nombre;
    private int periodo;

    private Asignatura objAsignatura;
}