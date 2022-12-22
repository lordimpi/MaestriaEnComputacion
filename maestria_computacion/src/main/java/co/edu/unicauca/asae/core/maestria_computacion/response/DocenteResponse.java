package co.edu.unicauca.asae.core.maestria_computacion.response;

import java.util.ArrayList;
import java.util.List;

import co.edu.unicauca.asae.core.maestria_computacion.models.Docente;

import lombok.Data;

@Data
public class DocenteResponse {
	List<Docente> docentes;
	
	public DocenteResponse() {
		this.docentes = new ArrayList<Docente>();
	}

}
