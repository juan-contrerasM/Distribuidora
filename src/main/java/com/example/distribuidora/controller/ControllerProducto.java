package com.example.distribuidora.controller;

import com.example.distribuidora.mapping.DTOS.actualizacion.ActualizarStockProducto;
import com.example.distribuidora.mapping.DTOS.registro.producto.ActualizarProductoDto;
import com.example.distribuidora.mapping.DTOS.registro.producto.RegistroProductoDto;
import com.example.distribuidora.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/productos")
public class ControllerProducto {


    @Autowired
    ProductoService productoService;


    //listarProductos
    @GetMapping("/listarProducto/{id}")
    @Transactional
    public ResponseEntity listarProductos(@PathVariable Long id) {
        return productoService.listarProductos(id);

    }

    //guardar productos
    @PostMapping("/guardarProducto")
    @Transactional
    public ResponseEntity guardarProducto(@RequestBody @Valid RegistroProductoDto registroProductoDto, UriComponentsBuilder uriBuilder) {
        return  productoService.guardarProducto(registroProductoDto);
    }

    //actualiza stock
    @PutMapping("/actualizarStock/{id}")
    @Transactional
    public ResponseEntity actualizarProducto(@PathVariable Long id, @RequestBody  @Valid ActualizarStockProducto actualizarStockProducto){
      return productoService.actualizarProductoStock(id, actualizarStockProducto);

    }

    //eliminar producto
    @DeleteMapping("/eliminarProducto/{codigo}")
    @Transactional
    public ResponseEntity eliminarProducto(@PathVariable String codigo){
        return  productoService.eliminarProducto(codigo);
    }

    // actualizar productos
    @PutMapping("/actualizarProducto/{id}")
    @Transactional
    public  ResponseEntity actualizarProducto(@PathVariable Long id, @RequestBody ActualizarProductoDto actualizarProductoDto){
        return  productoService.actualizarProducto(id, actualizarProductoDto);
    }



}
