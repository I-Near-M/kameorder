package org.doomtech.kameorder.establecimientos.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ambientes")
public class Ambiente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private Integer nroPiso;
    private Integer cantidadMesas;

    @ManyToOne
    @JoinColumn(name = "local_id", nullable = false)
    private Local local;
    private String tipo;          // ej. SALA, BAR, TERRAZA
    private Integer capacidadMax;
    private String descripcion;
    private String estado;
    private LocalDateTime creadoEn;
}
