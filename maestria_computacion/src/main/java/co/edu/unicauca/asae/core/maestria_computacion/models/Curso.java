package co.edu.unicauca.asae.core.maestria_computacion.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cursos")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private Integer id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private Integer periodo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_asignatura",nullable = false)
    @JsonIgnore
    private Asignatura objAsignatura;
}