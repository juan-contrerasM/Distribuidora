package com.example.distribuidora.mapping.DTOS.actualizacion;

import jakarta.validation.constraints.NotNull;

public record ActualizarStockProducto(
        @NotNull
        Integer cantidadStock
) {
}
