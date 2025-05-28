package org.doomtech.kameorder.pedidoplato.model;

    import jakarta.persistence.*;
    import lombok.*;
    import org.doomtech.kameorder.pedido.model.Pedido;
    import org.doomtech.kameorder.producto.model.Producto;

    @Entity
    @Table(name = "pedido_producto")
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public class PedidoProducto {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @ManyToOne(optional = false)
        @JoinColumn(name = "pedido_id", referencedColumnName = "id", nullable = false)
        private Pedido pedido;

        @ManyToOne(optional = false)
        @JoinColumn(name = "producto_id", referencedColumnName = "id", nullable = false)
        private Producto producto;

        private Integer cantidad;
        private String comentarios;
    }