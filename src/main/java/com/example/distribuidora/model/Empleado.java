package com.example.distribuidora.model;

import com.example.distribuidora.mapping.DTOS.registro.empleado.EmpleadoActualizarDto;
import com.example.distribuidora.mapping.DTOS.registro.empleado.EmpleadoRegistroDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "empleados")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")  // Relación con la columna "id"
    private Long id;

    @Column(name = "nombre")  // Relación con la columna "nombre"
    private String nombre;

    @Column(name = "apellido")  // Relación con la columna "apellido"
    private String apellido;

    @Column(name = "numero_vendedor")  // Relación con la columna "numero_vendedor"
    private String numero_vendedor;

    @Column(name = "cargo")  // Relación con la columna "cargo"
    private String cargo;

    @Column(name = "fecha_contratacion")  // Relación con la columna "fecha_contratacion"
    private LocalDate fecha_contratacion;

    @Column(name = "estado")  // Relación con la columna "estado"
    private Boolean estado;


    // creamos un empleado con los datos del Dto
    public Empleado(EmpleadoRegistroDto empleadoRegistroDto){
        this.nombre=empleadoRegistroDto.nombre();
        this.apellido=empleadoRegistroDto.apellido();
        this.numero_vendedor=empleadoRegistroDto.numero_vendedor();
        this.cargo=empleadoRegistroDto.cargo();
        this.fecha_contratacion= empleadoRegistroDto.fecha_contratacion();
        this.estado= empleadoRegistroDto.estado();
    }

    public void actualizarInformacion(EmpleadoActualizarDto empleadoActualizarDto) {
        this.nombre=empleadoActualizarDto.nombre();
        this.apellido=empleadoActualizarDto.apellido();
        this.numero_vendedor=empleadoActualizarDto.numero_vendedor();
        this.cargo= empleadoActualizarDto.cargo();
    }


}
