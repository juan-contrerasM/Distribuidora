package com.example.distribuidora.service;

import com.example.distribuidora.mapping.DTOS.actualizacion.ActualizarStockProducto;
import com.example.distribuidora.mapping.DTOS.registro.producto.ActualizarProductoDto;
import com.example.distribuidora.mapping.DTOS.registro.producto.RegistroProductoDto;
import com.example.distribuidora.mapping.mapper.IDistruibuidoraMapper;
import com.example.distribuidora.model.Producto;
import com.example.distribuidora.repositorys.RepositoryProducto;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
    @Autowired
    RepositoryProducto repositoryProducto;
    IDistruibuidoraMapper distribuidoraMapper = Mappers.getMapper(IDistruibuidoraMapper.class);

    //listar producto
    public  ResponseEntity listarProductos(Long id) {
        if(repositoryProducto.existsById(id)){
            Producto producto= repositoryProducto.getReferenceById(id);
            return ResponseEntity.ok().body(distribuidoraMapper.ProductotoProductoDto(producto));
        }else {
            return  ResponseEntity.badRequest().body("No se encuentra registrado ese producto");
        }

    }

    // guardar producto
    public ResponseEntity guardarProducto(RegistroProductoDto registroProductoDto) {
        Producto producto=distribuidoraMapper.ProductoDtotoProducto(registroProductoDto);
        repositoryProducto.save(producto);
        return  ResponseEntity.ok().body(distribuidoraMapper.ProductotoProductoDto(producto));
    }
    //actualizarStock
    public ResponseEntity actualizarProductoStock(Long id, ActualizarStockProducto actualizarStockProducto) {
        if(repositoryProducto.existsById(id)){
            Producto producto= repositoryProducto.getReferenceById(id);
            producto.setCantidadStock(actualizarStockProducto.cantidadStock());
            repositoryProducto.save(producto);
            return  ResponseEntity.ok().body(distribuidoraMapper.ProductotoProductoDto(producto));
        }
        else {
            return ResponseEntity.badRequest().body("No se encuentra registrado ese producto");
        }

    }

    //elimina producto a  con el codigo
    public ResponseEntity eliminarProducto(String codigo) {
        if(repositoryProducto.existsProductoByCodigo(codigo)){
            Producto producto=repositoryProducto.getProductoByCodigo(codigo);
            repositoryProducto.deleteProductoByCodigo(codigo);
            return ResponseEntity.ok().body("el siguiente producto se ha eliminado "+producto);
        }
        else {
            return ResponseEntity.badRequest().body("no hay un producto con ese codigo registrado");
        }
    }
    //actualizar producto
    public ResponseEntity actualizarProducto(Long id, ActualizarProductoDto actualizarProductoDto) {
        if(repositoryProducto.existsById(id)){
            Producto producto=repositoryProducto.getReferenceById(id);
            producto.actualizarValores(actualizarProductoDto);
            repositoryProducto.save(producto);
            return ResponseEntity.ok().body(distribuidoraMapper.ProductotoProductoDto(producto));
        }
        else {
            return ResponseEntity.badRequest().body("No se encuentra registrado ese producto");
        }
    }
}
