package co.edu.unicauca.asae.core.maestria_computacion.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DocenteResponseRest extends ResponseRest{
	private DocenteResponse docenteResponse;
	
	public DocenteResponseRest() {
		this.docenteResponse = new DocenteResponse();
	}
}
