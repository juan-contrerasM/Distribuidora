package com.example.distribuidora.model;

import com.example.distribuidora.mapping.DTOS.registro.categoria_producto.RegistroCategoriaProducto;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity(name = "categorias_productos")
public class CategoriaProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    public CategoriaProducto(RegistroCategoriaProducto registroCategoriaProducto) {
        this.nombre=registroCategoriaProducto.nombre();
        this.descripcion=registroCategoriaProducto.descripcion();
    }
    public void modificarCategoria( RegistroCategoriaProducto registroCategoriaProducto){
        this.nombre=registroCategoriaProducto.nombre();
        this.descripcion=registroCategoriaProducto.descripcion();
    }
}
