package org.doomtech.kameorder.proveedor.model;

import jakarta.persistence.*;
import lombok.*;
import org.doomtech.kameorder.insumo.model.Insumo;

import java.util.List;

@Entity
@Table(name = "tbl_proveedores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    private String contacto; // Persona de contacto en el proveedor
    private String descripcion; // Descripción del proveedor
    private boolean activo; // Indica si el proveedor está activo o no

    @OneToMany()
    @JoinColumn(name = "proveedor_id", referencedColumnName = "id")
    private List<Insumo> insumos; // Lista de insumos asociados a este proveedor
}
