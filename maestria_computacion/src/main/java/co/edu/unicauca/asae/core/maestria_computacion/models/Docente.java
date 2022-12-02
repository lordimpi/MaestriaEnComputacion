package co.edu.unicauca.asae.core.maestria_computacion.models;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "docentes")
public class Docente extends Persona{
    @Column(nullable = false)
    private String universidad;

    @Column(name = "tipo_docente",nullable = false)
    private String tipoDocente;

    @Column(nullable = false)
    private float salario;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "docentes_asignaturas", 
        joinColumns = @JoinColumn(name = "id_persona"), 
        inverseJoinColumns = @JoinColumn(name = "id_asignatura"))
    private List<Asignatura> asignaturas;
}