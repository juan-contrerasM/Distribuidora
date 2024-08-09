package com.example.distribuidora.mapping.DTOS.respuesta.empleado;

import com.example.distribuidora.model.Empleado;

public record EmpleadoRespuestaDto (
        Long id, String nombre,String cargo, boolean estado
)
{
    public EmpleadoRespuestaDto(Empleado empleado) {
        this(empleado.getId(), empleado.getNombre(), empleado.getCargo(),empleado.getEstado());
    }
}
