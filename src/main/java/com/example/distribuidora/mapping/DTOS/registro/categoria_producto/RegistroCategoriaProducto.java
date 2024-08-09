package com.example.distribuidora.mapping.DTOS.registro.categoria_producto;

import jakarta.validation.constraints.NotBlank;

public record RegistroCategoriaProducto(
        @NotBlank
        String nombre ,
        @NotBlank
        String descripcion
) {
}
