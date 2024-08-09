package com.example.distribuidora.repositorys;

import com.example.distribuidora.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryEmpleados extends JpaRepository<Empleado,Long> {
}
