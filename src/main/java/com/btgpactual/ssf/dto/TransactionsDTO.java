package com.btgpactual.ssf.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class TransactionsDTO {
    private Long id;

    @NotNull
    private int monto;

    @NotNull
    @Pattern(regexp = "^(apertura|cancelacion)$", message = "El tipo debe ser 'apertura' o 'cancelacion'.")
    private String tipo;
    private LocalDateTime fcreacion;
    private LocalDateTime fedicion;

    private UserDTO usuario;

    private FoundDTO fondo;

}
