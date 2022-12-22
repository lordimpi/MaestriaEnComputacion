package co.edu.unicauca.asae.core.maestria_computacion.response.EstudianteResponse;

import java.util.ArrayList;
import java.util.List;

import co.edu.unicauca.asae.core.maestria_computacion.models.Estudiante;
import lombok.Data;

@Data
public class EstudianteResponse {
    List<Estudiante> estudiantes;
	
	public EstudianteResponse() {
		this.estudiantes = new ArrayList<Estudiante>();
	}
}
