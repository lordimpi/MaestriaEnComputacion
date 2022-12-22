package co.edu.unicauca.asae.core.maestria_computacion.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

import co.edu.unicauca.asae.core.maestria_computacion.models.Estudiante;

@Repository
public interface EstudianteRepository extends CrudRepository<Estudiante, Integer>{
    
    //@Query("select d from estudiantes d where d.nombres like %?1")
	//public List<Estudiante> buscarEstudiantePorPatron(String patron);
    
    @Query("SELECT u FROM Estudiante u WHERE u.noId = :numero and u.tipoIdentificacion = :tipo")
	public Estudiante buscarPorNumeroyTipoIdentificacion(			
			@Param("numero") String noIdentificacion,
            @Param("tipo") String tipoIdentificacion);  
    

}
