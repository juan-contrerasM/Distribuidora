package com.example.distribuidora.mapping.DTOS.registro.empleado;

import com.example.distribuidora.service.BooleanCustomDeserializerService;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record EmpleadoRegistroDto(
        @NotBlank
        String nombre,
        @NotBlank
        String apellido,
        @NotBlank
        String numero_vendedor,
        @NotBlank
        String cargo,

        @NotNull
        LocalDate fecha_contratacion,

        @NotNull
        @JsonDeserialize(using = BooleanCustomDeserializerService.class)
        Boolean estado


) {
}
