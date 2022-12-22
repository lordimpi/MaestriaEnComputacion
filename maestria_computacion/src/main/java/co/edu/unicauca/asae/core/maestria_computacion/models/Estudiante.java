package co.edu.unicauca.asae.core.maestria_computacion.models;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "estudiantes")
public class Estudiante extends Persona {
    @Column(nullable = false)
    private Date fechaIngreso;

    @Column(nullable = false)
    private String correoElectronico;
    
    @JsonIgnore
    @OneToOne(optional = false,fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "objEstudiante")
    private Direccion objDireccion;
    
    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "objEstudiante")
    private List<Telefono> telefonos;
    
}