package com.example.distribuidora.repositorys;

import com.example.distribuidora.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface RepositoryProducto extends JpaRepository<Producto,Long> {
    @Query("SELECT CASE WHEN COUNT(e) > 0 THEN true ELSE false END FROM Producto e WHERE e.codigo = :codigo")
    boolean existsProductoByCodigo(String codigo);

    @Query("SELECT e FROM Producto e WHERE e.codigo = :codigo")
    Producto getProductoByCodigo(String codigo);

    @Modifying
    @Query("DELETE FROM Producto e WHERE e.codigo = :codigo")
    void deleteProductoByCodigo(String codigo);
}
