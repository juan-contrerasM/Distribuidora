package com.example.distribuidora.model;

import com.example.distribuidora.mapping.DTOS.registro.producto.ActualizarProductoDto;
import com.example.distribuidora.mapping.DTOS.registro.producto.RegistroProductoDto;
import jakarta.persistence.*;
import lombok.*;


import java.math.BigDecimal;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")  // Relación con la columna "id"
    private Long id;

    @Column(name = "nombre")  // Relación con la columna "nombre"
    private String nombre;

    @Column(name = "descripcion")  // Relación con la columna "descripcion"
    private String descripcion;

    @Column(name = "clasificacion")  // Relación con la columna "clasificacion"
    private String clasificacion;

    @Column(name = "codigo")  // Relación con la columna "codigo"
    private String codigo;

    @Column(name = "precio", precision = 10, scale = 2)  // Relación con la columna "precio"
    private BigDecimal precio;

    @Column(name = "catidad_stock")  // Relación con la columna "cantidad_stock"
    private Integer cantidadStock;


    public Producto(RegistroProductoDto registroProductoDto) {
        this.nombre =registroProductoDto.nombre();
        this.descripcion =registroProductoDto.descripcion();
        this.clasificacion =registroProductoDto.clasificacion();
        this.codigo =registroProductoDto.codigo();
        this.precio =registroProductoDto.precio();
        this.cantidadStock =registroProductoDto.cantidadStock();
    }

    public void modificarStock(Integer cantidadStock) {
        this.cantidadStock=cantidadStock;
    }

    public void actualizarValores(ActualizarProductoDto actualizarProductoDto) {
        this.nombre =actualizarProductoDto.nombre();
        this.descripcion =actualizarProductoDto.descripcion();
        this.clasificacion =actualizarProductoDto.clasificacion();
        this.codigo =actualizarProductoDto.codigo();
        this.precio =actualizarProductoDto.precio();
    }
}
