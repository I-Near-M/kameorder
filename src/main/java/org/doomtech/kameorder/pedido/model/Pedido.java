package org.doomtech.kameorder.pedido.model;

        import jakarta.persistence.*;
        import lombok.*;
        import org.doomtech.kameorder.establecimientos.model.Ambiente;
        import org.doomtech.kameorder.mesa.model.Mesa;
        import org.doomtech.kameorder.pedidoplato.model.PedidoProducto;
        import org.doomtech.kameorder.user.model.User;
        import org.hibernate.annotations.CreationTimestamp;

        import java.time.LocalDateTime;
        import java.util.List;

        @Entity
        @Table(name = "pedidos")
        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        @Builder
        public class Pedido {

            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Integer id;

            @ManyToOne
            @JoinColumn(nullable = false)
            private Mesa mesa;

            @ManyToOne
            @JoinColumn(nullable = false)
            private User usuario;

            @Enumerated(EnumType.STRING)
            private EstadoPedido estado = EstadoPedido.EN_CURSO;

            private Double total;

            @CreationTimestamp
            private LocalDateTime creadoEn;
            private LocalDateTime cerradoEn;

            @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
            private List<PedidoProducto> productos;

            @ManyToOne(fetch = FetchType.LAZY)
            @JoinColumn(name = "ambiente_id", nullable = false)
            private Ambiente ambiente;
        }