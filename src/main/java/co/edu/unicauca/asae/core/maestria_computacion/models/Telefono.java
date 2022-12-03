package co.edu.unicauca.asae.core.maestria_computacion.models;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;


@Entity
@Table(name = "telefonos")
@Getter
@Setter
public class Telefono {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_telefono")
    private int id;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private String numero;

    @JsonIgnore
    @ManyToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "id_persona")
    private Estudiante objEstudiante;
}
