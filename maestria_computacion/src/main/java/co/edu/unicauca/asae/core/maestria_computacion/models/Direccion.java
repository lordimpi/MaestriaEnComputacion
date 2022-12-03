package co.edu.unicauca.asae.core.maestria_computacion.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "direcciones")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Direccion {
    @Id      
    private Integer idDireccion;
    @Column(nullable=false,length = 30)
    private String direccionResidencia;
    @Column(nullable=false,length = 30)
    private String ciudad;
    @Column(nullable=false,length = 30)
    private String pais;
    
    @MapsId
    @JsonIgnore
    @OneToOne(optional = false)
    @JoinColumn(name = "idDireccion", nullable = false)
    private Estudiante objEstudiante; 
    
}
