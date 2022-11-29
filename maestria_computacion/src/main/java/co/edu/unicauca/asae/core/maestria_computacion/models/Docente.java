package co.edu.unicauca.asae.core.maestria_computacion.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "docente")
public class Docente extends Persona{
    @Column(nullable = false)
    private String universidad;

    @Column(name = "tipo_docente",nullable = false)
    private String tipoDocente;

    @Column(nullable = false)
    private float salario;

    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinTable(
            name = "docentes_asignaturas",
            joinColumns = @JoinColumn(name = "id_persona"),
            inverseJoinColumns = @JoinColumn(name = "id_asignatura"))
    // @ManyToMany(fetch = FetchType.EAGER)
    // @JoinTable(name = "docentes_asignaturas", 
    //     joinColumns = @JoinColumn(name = "id_asignatura"), 
    //     inverseJoinColumns = @JoinColumn(name = "id_persona"))
    private List<Asignatura> asignaturas;
}