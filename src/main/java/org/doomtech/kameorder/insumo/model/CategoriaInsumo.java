package org.doomtech.kameorder.insumo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tbl_categorias_insumo")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoriaInsumo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategoriaInsumo;
    private String nombre;
    private String descripcion;
    @OneToMany
    @JoinColumn(name = "categoria_insumo_id", referencedColumnName = "idCategoriaInsumo")
    private List<Insumo> insumos;

}