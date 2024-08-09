package com.example.distribuidora.mapping.DTOS.registro.empleado;

import jakarta.validation.constraints.NotBlank;

public record EmpleadoActualizarDto (
        @NotBlank
        String nombre,
        @NotBlank
        String apellido,
        @NotBlank
        String numero_vendedor,
        @NotBlank
        String cargo
)
{
}
