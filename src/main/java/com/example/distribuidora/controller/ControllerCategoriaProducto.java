package com.example.distribuidora.controller;

import com.example.distribuidora.model.CategoriaProducto;
import com.example.distribuidora.mapping.DTOS.registro.categoria_producto.RegistroCategoriaProducto;
import com.example.distribuidora.mapping.DTOS.respuesta.categoria_producto.RespuestaDtoCategoria;
import com.example.distribuidora.repositorys.RespositoryCategoriaProducto;
import com.example.distribuidora.service.CategoriaProductoService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/categoriasProductos")
@RestController
public class ControllerCategoriaProducto {

    @Autowired
    private RespositoryCategoriaProducto respositoryCategoriaProducto;

    @Autowired
    private CategoriaProductoService categoriaProductoService;



    //guarda categoria
    @PostMapping("/guardarCategoria")
    @Transactional
    public  ResponseEntity guardarCategoria_producto(@RequestBody @Valid RegistroCategoriaProducto registroCategoriaProducto, UriComponentsBuilder uriBuilder){
       return  categoriaProductoService.guardarCategoriaProducto(registroCategoriaProducto);
    }


    //listar categoria
    @GetMapping("/listarCategorias")
    @Transactional
    public ResponseEntity listarCategoria() {
        return  categoriaProductoService.listarCategorias();
    }

    //detallar categoria
    @GetMapping("/detallarCategoria/{id}")
    @Transactional
    public  ResponseEntity detallarCategoria(@PathVariable Long id){
        return  categoriaProductoService.detallarCategoria(id);

    }
    //eliminar categoria
    @DeleteMapping("/eliminarCategoria/{id}")
    @Transactional
    public ResponseEntity eliminarCategoria(@PathVariable Long id){
       return  categoriaProductoService.eliminarCategoria(id);
    }
    //modificar categoria
    @PutMapping("/modificarCategoria/{id}")
    @Transactional
    public ResponseEntity modificarCategoria(@PathVariable Long id, @RequestBody @Valid RegistroCategoriaProducto registroCategoriaProducto){
      return  categoriaProductoService.actualizarCategoria(id,registroCategoriaProducto);
    }



}
