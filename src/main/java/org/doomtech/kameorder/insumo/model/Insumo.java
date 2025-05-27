package org.doomtech.kameorder.insumo.model;


import jakarta.persistence.*;
import lombok.*;
import org.doomtech.kameorder.proveedor.model.Proveedor;

@Entity
@Getter
@Setter
@ToString
@Table(name = "tbl_insumos")
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class Insumo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String descripcion;
    private Double cantidad; // cantidad disponible

    @ManyToOne
    @JoinColumn(name = "unidad_medida_id", referencedColumnName = "id")
    private UnidadMedida unidadMedida; // kg, litros, etc.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_insumo_id", referencedColumnName = "idCategoriaInsumo")
    private CategoriaInsumo categoria; // categoria del insumo, por ejemplo: verduras, carnes, etc.
    @Column(nullable = true) //
    private Boolean disponible = true; // si el insumo está disponible

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proveedor_id", referencedColumnName = "id")
    private Proveedor proveedor; // proveedor del insumo
    private Double costoUnitario; // costo por unidad del insumo

}
