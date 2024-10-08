package com.btgpactual.ssf.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserDTO {

    private Long id;

    @NotBlank(message = "El correo no puede estar vacío.")
    private String nombres;

    @Size(max = 10, message = "El numero telefonico debe tener 10 numeros")
    private String telefono;

    @Email(message = "El correo electrónico debe ser válido.")
    @NotBlank(message = "El correo no puede estar vacío.")
    private String correo;

    private int monto;

    private LocalDateTime fcreacion;

    private LocalDateTime fedicion;

    private List<TransactionsDTO> transacciones;

}
