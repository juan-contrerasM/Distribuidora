package com.example.distribuidora.mapping.DTOS.registro.empleado;

import com.example.distribuidora.service.BooleanCustomDeserializerService;
import com.example.distribuidora.service.BooleanCustomDeserializerService;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.validation.constraints.NotNull;

public record EmpleadoModificarEstado (
        @NotNull
        @JsonDeserialize(using = BooleanCustomDeserializerService.class)
        boolean estado
)
{
}
