package co.edu.unicauca.asae.core.maestria_computacion.services.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter@AllArgsConstructor@NoArgsConstructor
public class DireccionDTO {
    private Integer idDireccion;
    
    @NotNull(message = "{direccion.name.empty}")
    @Size(min = 5, max = 25, message = "{direccion.name.length}")
    private String direccionResidencia;

    @NotNull(message = "{direccion.ciudad.empty}")
    @Size(min = 5, max = 50, message = "{direccion.ciudad.length}")
    private String ciudad;

    @NotNull(message = "{direccion.pais.empty}")
    @Size(min = 5, max = 50, message = "{direccion.pais.length}")
    private String pais;
    
    // private EstudianteDTO objEstudiante;
    
}
