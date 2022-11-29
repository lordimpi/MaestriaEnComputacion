package co.edu.unicauca.asae.core.maestria_computacion.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "asignatura")
public class Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asignatura")
    private Integer id;

    @Column(nullable = false)
    private String nombre;

    @OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY, mappedBy = "objAsignatura")
    private List<Curso> cursos;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "asignaturas")
    private List<Docente> docentes;
}
