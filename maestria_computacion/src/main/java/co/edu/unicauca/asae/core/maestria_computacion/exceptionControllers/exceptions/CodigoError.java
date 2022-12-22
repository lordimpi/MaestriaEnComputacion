package co.edu.unicauca.asae.core.maestria_computacion.exceptionControllers.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum CodigoError {

        ERROR_GENERICO("GC-0001", "ERROR GENERICO"),
        ENTIDAD_YA_EXISTE("GC-0002", "ERROR ENTIDAD YA EXISTE"),
        ENTIDAD_NO_ENCONTRADA("GC-0003", "Entidad no encontrada"),
        VIOLACION_REGLA_DE_NEGOCIO("GC-0004", "Regla de negocio violada"),
        CREDENCIALES_INVALIDAS("GC-0005", "Error al iniciar sesión, compruebe sus credenciales y vuelva a intentarlo"),
        USUARIO_DESHABILITADO("GC-0006",
                        "El usuario no ha sido verificado, por favor revise su correo para verificar su cuenta"),
        VIOLACION_ALMACENAMIENTO_DB("GC-0007",
                        "Error al almacenar el estudiante, por favor verifique los datos e intente nuevamente");

        private final String codigo;
        private final String llaveMensaje;
}
