package org.doomtech.kameorder.pedidoplato.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.doomtech.kameorder.pedido.model.Pedido;
import org.doomtech.kameorder.plato.model.Plato;

@Entity
@Table(name = "pedido_plato")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PedidoPlato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Plato plato;

    private Integer cantidad;

    private String comentarios;
}
