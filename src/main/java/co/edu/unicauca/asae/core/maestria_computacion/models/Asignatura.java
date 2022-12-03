package co.edu.unicauca.asae.core.maestria_computacion.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "asignaturas")
public class Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asignatura")
    private Integer id;

    @Column(nullable = false)
    private String nombre;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "objAsignatura", cascade = CascadeType.ALL)
    private List<Curso> cursos;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "docentes_asignaturas", 
        joinColumns = @JoinColumn(name = "id_asignatura"), 
        inverseJoinColumns = @JoinColumn(name = "id_persona"))
    private List<Docente> docentes;
}
