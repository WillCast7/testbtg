package com.btgpactual.ssf.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transacciones")
public class TransactionsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int monto;

    @Column(updatable = false)
    private String tipo;

    @Column(updatable = false)
    private LocalDateTime fcreacion;

    private LocalDateTime fedicion;

    @ManyToOne
    @JoinColumn(name = "usuario")
    private UserEntity usuario;

    @ManyToOne
    @JoinColumn(name = "fondo")
    private FoundsEntity fondo;

    @PrePersist
    protected void onCreate() {
        fcreacion = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        fedicion = LocalDateTime.now();
    }
}
