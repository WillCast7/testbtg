package com.btgpactual.ssf.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class TransactionDTO {

    @NotNull
    private int monto;

    @NotNull
    private String tipo;

    private int usuario;

    private int fondo;
}
