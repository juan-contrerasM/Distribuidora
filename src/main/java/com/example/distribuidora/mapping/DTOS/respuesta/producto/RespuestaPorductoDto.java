package com.example.distribuidora.mapping.DTOS.respuesta.producto;

import com.example.distribuidora.model.Producto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record RespuestaPorductoDto(Long id ,String nombre,String descripcion, String codigo, BigDecimal precio, Integer cantidadStock
) {



    public RespuestaPorductoDto (Producto producto){
        this(producto.getId(),producto.getNombre(),producto.getDescripcion(),producto.getCodigo(),producto.getPrecio(), producto.getCantidadStock());
    }
}
