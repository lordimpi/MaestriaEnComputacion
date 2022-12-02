package co.edu.unicauca.asae.core.maestria_computacion.services.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DocenteDTO {
    private Integer id;
    private String noId;
    private String tipoIdentificacion;
    private String nombres;
    private String apellidos;
    private String universidad;
    private String tipoDocente;
    private float salario;

    private List<AsignaturaDTO> asignaturas;

}