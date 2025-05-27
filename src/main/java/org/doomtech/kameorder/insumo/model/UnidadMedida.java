package org.doomtech.kameorder.insumo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;


@Entity
@Table(name = "tbl_unidades_medida")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UnidadMedida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre; // nombre de la unidad de medida (ej. kg, litros, etc.)
    private String descripcion; // descripción de la unidad de medida
    private String simbolo; // símbolo de la unidad de medida (ej. kg, L, etc.)
    private Boolean activa = true; // si la unidad de medida está activa o no
    private Date fechaCreacion;
    @OneToMany(mappedBy = "unidadMedida")
    private List<Insumo> insumos;
}
