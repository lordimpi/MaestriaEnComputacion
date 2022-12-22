package co.edu.unicauca.asae.core.maestria_computacion.exceptionControllers.exceptions;

import lombok.Getter;

@Getter
public class ErrorAlmacenamientoDBException extends RuntimeException{
    
    private final String LLaveMensaje;
    private final String codigo;

    public ErrorAlmacenamientoDBException(final String llaveMensaje) {
        super(llaveMensaje);
        this.LLaveMensaje = CodigoError.VIOLACION_ALMACENAMIENTO_DB.getLlaveMensaje();
        this.codigo = CodigoError.VIOLACION_ALMACENAMIENTO_DB.getCodigo();
    }
}
