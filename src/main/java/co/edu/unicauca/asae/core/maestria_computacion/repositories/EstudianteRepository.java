package co.edu.unicauca.asae.core.maestria_computacion.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.unicauca.asae.core.maestria_computacion.models.Estudiante;

@Repository
public interface EstudianteRepository extends CrudRepository<Estudiante, Integer>{
    
}
