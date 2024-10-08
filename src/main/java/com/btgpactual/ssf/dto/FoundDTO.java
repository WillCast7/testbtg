package com.btgpactual.ssf.dto;

import com.btgpactual.ssf.model.entity.TransactionsEntity;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class FoundDTO {
    private Long id;

    private String nombre;

    private int montomin;

    private String categoria;

    private LocalDateTime fcreacion;

    private LocalDateTime fedicion;


}
