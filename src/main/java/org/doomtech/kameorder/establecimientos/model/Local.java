package org.doomtech.kameorder.establecimientos.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "locales")
public class Local {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String direccion;
    private String ciudad;
    private String estado;
    // Atributos adicionales recomendados
    private String telefono;
    private String email;
    private Integer capacidad;
    private LocalDateTime creado;

    @OneToMany(mappedBy = "local", cascade = CascadeType.ALL)
    private List<Ambiente> ambientes;
}
