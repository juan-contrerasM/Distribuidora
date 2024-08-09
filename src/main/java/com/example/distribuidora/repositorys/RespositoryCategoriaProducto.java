package com.example.distribuidora.repositorys;

import com.example.distribuidora.model.CategoriaProducto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RespositoryCategoriaProducto extends JpaRepository<CategoriaProducto,Long> {
}
