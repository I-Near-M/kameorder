package org.doomtech.kameorder.establecimientos.model;

import jakarta.persistence.*;
import lombok.*;
import org.doomtech.kameorder.producto.model.Producto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "local_producto")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Catalogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "local_id", nullable = false)
    private Local local;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;

    @Column(nullable = false)
    private BigDecimal precio;

    @Column(nullable = false)
    private Integer stock;

    @Column(nullable = false)
    private Boolean activo;

    @Column(nullable = false)
    private LocalDateTime creadoEn;

    @Column
    private LocalDateTime actualizadoEn;
}
