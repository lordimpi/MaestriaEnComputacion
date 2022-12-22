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
    
    //Like no permite hacer unos de la concatenacion con mas y agrupar todo con '' evita que tome el valor de la variable, por tanto hay que usar concat obligatoriamente
    @Query(value = "select * from estudiantes where nombres like CONCAT('%', :patron , '%') or apellidos like CONCAT('%', :patron , '%') or correoElectronico like CONCAT('%', :patron , '%');", nativeQuery = true)
    public List<Estudiante> buscarEstudiantePorPatron(
        @Param("patron") String nombre
    );

}
