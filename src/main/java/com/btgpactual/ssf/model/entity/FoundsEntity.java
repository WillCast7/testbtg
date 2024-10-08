package com.btgpactual.ssf.model.entity;

import jakarta.annotation.Nullable;
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
@Table(name = "fondos")
public class FoundsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nullable
    private String nombre;

    @Nullable
    private int montomin;

    @Nullable
    private String categoria;

    @Column(updatable = false)
    private LocalDateTime fcreacion;

    @Nullable
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
