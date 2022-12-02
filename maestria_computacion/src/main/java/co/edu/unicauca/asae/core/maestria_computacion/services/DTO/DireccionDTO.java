package co.edu.unicauca.asae.core.maestria_computacion.services.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter@AllArgsConstructor@NoArgsConstructor
public class DireccionDTO {
    private Integer idDireccion;
    private String direccionResidencia;
    private String ciudad;
    private String pais;
    
    private EstudianteDTO objEstudiante;
    
}
