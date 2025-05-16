package org.doomtech.kameorder.reserva.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.doomtech.kameorder.mesa.model.Mesa;
import org.doomtech.kameorder.user.model.User;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "reservas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String clienteNombre;

    private String clienteTelefono;

    @Column(nullable = false)
    private LocalDateTime fechaReserva;

    @Enumerated(EnumType.STRING)
    private EstadoReserva estado = EstadoReserva.PENDIENTE;

    public enum EstadoReserva {
        PENDIENTE,
        CONFIRMADA,
        CANCELADA
    }

    @ManyToOne
    @JoinColumn(nullable = false)
    private Mesa mesa;

    @ManyToOne
    private User creadaPor;

    @CreationTimestamp
    private LocalDateTime creadoEn;
}
