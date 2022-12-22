package co.edu.unicauca.asae.core.maestria_computacion.response.EstudianteResponse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstudianteResponseRest extends ResponseRest{
    private EstudianteResponse estudianteResponse;
	
	public EstudianteResponseRest() {
		this.estudianteResponse = new EstudianteResponse();
	}
}
