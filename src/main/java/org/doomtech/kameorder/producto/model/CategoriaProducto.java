package org.doomtech.kameorder.producto.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tbl_categorias_producto")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CategoriaProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCatergoriaProducto;
    private String nombreCatergoriaProducto;
    private String descripcionCatergoriaProducto;
    private boolean estadoCatergoriaProducto;
    private Date fechaCatergoriaProducto;
    @OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY)
    private List<Producto> productos;
}



