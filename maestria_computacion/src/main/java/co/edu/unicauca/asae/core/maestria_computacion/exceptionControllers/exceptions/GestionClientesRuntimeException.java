package co.edu.unicauca.asae.core.maestria_computacion.exceptionControllers.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public abstract class GestionClientesRuntimeException extends RuntimeException {

  protected CodigoError codigoError;

  public abstract String formatException();
}
