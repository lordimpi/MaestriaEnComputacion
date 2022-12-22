package co.edu.unicauca.asae.core.maestria_computacion.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import co.edu.unicauca.asae.core.maestria_computacion.models.Estudiante;

@Repository
public interface EstudianteRepository extends CrudRepository<Estudiante, Integer> {

    @Query(value = "SELECT COUNT(*) FROM estudiantes WHERE correoElectronico = :correoElectronico", nativeQuery = true)
    public Optional<Integer> existByEmail(@Param("correoElectronico") String correoElectronico);
}
