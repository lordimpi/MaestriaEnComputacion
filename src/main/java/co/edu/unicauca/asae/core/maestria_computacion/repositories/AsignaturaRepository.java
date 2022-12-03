package co.edu.unicauca.asae.core.maestria_computacion.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.unicauca.asae.core.maestria_computacion.models.Asignatura;

@Repository
public interface AsignaturaRepository extends CrudRepository<Asignatura, Integer>{
    
}
