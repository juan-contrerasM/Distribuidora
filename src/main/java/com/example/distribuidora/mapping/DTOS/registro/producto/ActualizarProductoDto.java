package com.example.distribuidora.mapping.DTOS.registro.producto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ActualizarProductoDto(
        @NotBlank
        String nombre,
        @NotBlank
        String descripcion,
        @NotBlank
        String clasificacion,
        @NotBlank
        String codigo,
        @NotNull
        BigDecimal precio) {
}
