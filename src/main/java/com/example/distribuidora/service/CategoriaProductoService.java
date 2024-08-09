package com.example.distribuidora.service;

import com.example.distribuidora.mapping.DTOS.registro.categoria_producto.RegistroCategoriaProducto;
import com.example.distribuidora.mapping.mapper.IDistruibuidoraMapper;
import com.example.distribuidora.model.CategoriaProducto;
import com.example.distribuidora.repositorys.RespositoryCategoriaProducto;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaProductoService {
    @Autowired
    RespositoryCategoriaProducto respositoryCategoriaProducto;

    IDistruibuidoraMapper distribuidoraMapper = Mappers.getMapper(IDistruibuidoraMapper.class);


    //guarda la categoria
    public ResponseEntity guardarCategoriaProducto(RegistroCategoriaProducto registroCategoriaProducto) {
        CategoriaProducto categoriaProducto= distribuidoraMapper.RegistroCategoriaProductotoCategoriaProducto(registroCategoriaProducto);
        respositoryCategoriaProducto.save(categoriaProducto);
        System.out.println(categoriaProducto.getDescripcion());
        return  ResponseEntity.ok().body(distribuidoraMapper.CategoriaProductotoRespuestaDtoCategoria(categoriaProducto));
    }
    //lista la scategorias
    public ResponseEntity listarCategorias() {
        List<CategoriaProducto>listaCategorias= respositoryCategoriaProducto.findAll();
        if(listaCategorias.isEmpty()){
            return ResponseEntity.badRequest().body("No hay categorias registradas");
        }
        else {
            return ResponseEntity.ok().body(distribuidoraMapper.getRespuestaDtoCategoria(listaCategorias));
        }
    }
    // detallar categoria
    public ResponseEntity detallarCategoria(Long id) {
        if(respositoryCategoriaProducto.existsById(id)){
            return ResponseEntity.ok().body(distribuidoraMapper.CategoriaProductotoRespuestaDtoCategoria(respositoryCategoriaProducto.getReferenceById(id)));
        }
        else {
            return  ResponseEntity.badRequest().body("no hay una categoria con ese id");
        }
    }

    //eliminar categoria
    public ResponseEntity eliminarCategoria(Long id) {
        if(respositoryCategoriaProducto.existsById(id)){
            CategoriaProducto categoriaProducto= respositoryCategoriaProducto.getReferenceById(id);
            respositoryCategoriaProducto.deleteById(id);
            return  ResponseEntity.ok().body(" se ha eliminado correctamente la categoria "+ distribuidoraMapper.CategoriaProductotoRespuestaDtoCategoria(categoriaProducto));
        }
        else {
            return  ResponseEntity.badRequest().body("No hay una categoria registrada con ese id ");
        }
    }


    public ResponseEntity actualizarCategoria(Long id, RegistroCategoriaProducto registroCategoriaProducto) {
        if(respositoryCategoriaProducto.existsById(id)){
            CategoriaProducto categoriaProducto= respositoryCategoriaProducto.getReferenceById(id);
            categoriaProducto.modificarCategoria(registroCategoriaProducto);
            respositoryCategoriaProducto.save(categoriaProducto);
            return ResponseEntity.ok().body(distribuidoraMapper.CategoriaProductotoRespuestaDtoCategoria(categoriaProducto));
        }else {
            return   ResponseEntity.badRequest().body("No hay una categoria registrada con ese id ");
        }
    }
}
