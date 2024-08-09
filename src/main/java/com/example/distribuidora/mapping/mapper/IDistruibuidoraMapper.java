package com.example.distribuidora.mapping.mapper;


import com.example.distribuidora.mapping.DTOS.registro.categoria_producto.RegistroCategoriaProducto;
import com.example.distribuidora.mapping.DTOS.registro.empleado.EmpleadoRegistroDto;
import com.example.distribuidora.mapping.DTOS.registro.producto.RegistroProductoDto;
import com.example.distribuidora.mapping.DTOS.respuesta.categoria_producto.RespuestaDtoCategoria;
import com.example.distribuidora.mapping.DTOS.respuesta.empleado.EmpleadoRespuestaDto;
import com.example.distribuidora.mapping.DTOS.respuesta.producto.RespuestaPorductoDto;
import com.example.distribuidora.model.CategoriaProducto;
import com.example.distribuidora.model.Empleado;
import com.example.distribuidora.model.Producto;
import org.springframework.stereotype.Component;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface IDistruibuidoraMapper {

    //empelado
    @IterableMapping(qualifiedByName = "EmpleadotoEmpleadoRespuestaDto")
    List<EmpleadoRespuestaDto> getEmpleadosRespuestaDto(List<Empleado> lista);
    @Named("EmpleadotoEmpleadoRespuestaDto")
    EmpleadoRespuestaDto EmpleadotoEmpleadoRespuestaDto(Empleado empleado);

    @Named("EmpleadoDtotoEmpleado")
    Empleado EmpleadoDtotoEmpleado(EmpleadoRegistroDto empleadoDto);

    // categoria producto
    @IterableMapping(qualifiedByName = "CategoriaProductotoRespuestaDtoCategoria")
    List<RespuestaDtoCategoria> getRespuestaDtoCategoria(List<CategoriaProducto> lista);

    @Named("CategoriaProductotoRespuestaDtoCategoria")
    RespuestaDtoCategoria CategoriaProductotoRespuestaDtoCategoria(CategoriaProducto categoriaProducto);

    @Named("RegistroCategoriaProductotoCategoriaProducto")
    CategoriaProducto RegistroCategoriaProductotoCategoriaProducto(RegistroCategoriaProducto registroCategoriaProducto);



    // ´prodcuto

    @Named("ProductotoProductoDto")
    RespuestaPorductoDto ProductotoProductoDto(Producto producto);
    @Named("ProductoDtotoProducto")
    Producto ProductoDtotoProducto(RegistroProductoDto registroProductoDto);




}
