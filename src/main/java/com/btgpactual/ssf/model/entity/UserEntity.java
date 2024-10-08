package com.btgpactual.ssf.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombres;

    @Column(unique = true)
    private String telefono;

    @Column(unique = true)
    private String correo;

    private int monto;

    @Column(updatable = false)
    private LocalDateTime fcreacion;

    private LocalDateTime fedicion;

    @OneToMany
    @JoinColumn(name= "id")
    private List<TransactionsEntity> transacciones;

    @PrePersist
    protected void onCreate() {
        fcreacion = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        fedicion = LocalDateTime.now();
    }
}
