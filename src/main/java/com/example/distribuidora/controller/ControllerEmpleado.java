package com.example.distribuidora.controller;

import com.example.distribuidora.mapping.DTOS.registro.empleado.EmpleadoActualizarDto;
import com.example.distribuidora.mapping.DTOS.registro.empleado.EmpleadoModificarEstado;
import com.example.distribuidora.mapping.DTOS.registro.empleado.EmpleadoRegistroDto;
import com.example.distribuidora.mapping.DTOS.respuesta.empleado.EmpleadoRespuestaDto;
import com.example.distribuidora.model.Empleado;
import com.example.distribuidora.repositorys.RepositoryEmpleados;
import com.example.distribuidora.service.EmpleadoService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/empleados")
@RestController
public class ControllerEmpleado {



    @Autowired
    EmpleadoService empleadoService;


    //Crea un empleado
    @PostMapping("/guardarEmpleado")
    @Transactional
    public ResponseEntity  crearEmpleado(@RequestBody  @Valid EmpleadoRegistroDto empleadoRegistroDto,UriComponentsBuilder uriBuilder){
        return empleadoService.registrarEmpleado(empleadoRegistroDto);
    }

    //Alista todos lo empleados de la base de datos
    @GetMapping("/listarEmpleado")
    @Transactional
    public ResponseEntity listarEmpleados(){
       return empleadoService.listarEmpleados();
    }

    //muestra un vendedor en especifico
    @GetMapping("/obtenerEmpleado/{id}")
    @Transactional
    public  ResponseEntity detallarEmpleado(@PathVariable Long id){
        return empleadoService.detallarEmpleado(id);
    }

    // actualiza los datos del empleado
    @PutMapping("/actualizarEmpleado/{id}")
    @Transactional
    public  ResponseEntity actualizarEmpleado(@PathVariable Long id, @RequestBody @Valid  EmpleadoActualizarDto empleadoActualizarDto){
       return  empleadoService.actualizarEmpleado(id, empleadoActualizarDto);
    }

    // cambia el estado de activo a inactivo

    @PutMapping("/estado/{id}")
    @Transactional
    @Operation(summary = "sirve para modficar un empelado ")
    public ResponseEntity modificarEstadoEmpleado(@PathVariable Long id, @RequestBody EmpleadoModificarEstado  empleadoModificarEstado){
        return  empleadoService.actualizarEstadoEmpleado(id,empleadoModificarEstado);
    }





}
