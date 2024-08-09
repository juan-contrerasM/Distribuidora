package com.example.distribuidora.mapping.DTOS.respuesta.categoria_producto;

import com.example.distribuidora.model.CategoriaProducto;

public record RespuestaDtoCategoria (
       Long id,  String nombre, String descripcion
){
    public RespuestaDtoCategoria(CategoriaProducto categoriaProducto){
        this(categoriaProducto.getId(),categoriaProducto.getNombre(), categoriaProducto.getDescripcion());

    }
}
