package org.doomtech.kameorder.recetario.model;

import jakarta.persistence.*;
import lombok.*;
import org.doomtech.kameorder.insumo.model.Insumo;
import org.doomtech.kameorder.producto.model.Producto;

import java.util.Date;

@Entity
@Table(name = "tbl_recetas_insumos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Receta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "insumo_id", nullable = false)
    private Insumo insumo;

    @Column(nullable = false)
    private Double cantidad;

    // unidad según Insumo.unidadMedida
    private Date creadoEn;
    private Date actualizadoEn;
    @Column(nullable = true)
    private Boolean estado; // Indica si la receta está activa o no
}
