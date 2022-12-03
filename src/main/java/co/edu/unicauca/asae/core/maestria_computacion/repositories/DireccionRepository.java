package co.edu.unicauca.asae.core.maestria_computacion.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.unicauca.asae.core.maestria_computacion.models.Direccion;

@Repository
public interface DireccionRepository extends CrudRepository<Direccion, Integer>{
    
}
