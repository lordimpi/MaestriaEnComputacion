package co.edu.unicauca.asae.core.maestria_computacion.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.edu.unicauca.asae.core.maestria_computacion.models.Docente;

public interface DocenteRepository extends CrudRepository<Docente, Integer>{
    @Query("SELECT u FROM Docente u WHERE u.noId = :numero and u.tipoIdentificacion = :tipo")
	public Docente buscarPorNumeroyTipoIdentificacion(			
			@Param("numero") String noIdentificacion,
            @Param("tipo") String tipoIdentificacion); 
}