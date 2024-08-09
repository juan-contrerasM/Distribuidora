package com.example.distribuidora.service;

import com.example.distribuidora.mapping.DTOS.registro.empleado.EmpleadoActualizarDto;
import com.example.distribuidora.mapping.DTOS.registro.empleado.EmpleadoModificarEstado;
import com.example.distribuidora.mapping.DTOS.registro.empleado.EmpleadoRegistroDto;
import com.example.distribuidora.mapping.mapper.IDistruibuidoraMapper;
import com.example.distribuidora.model.Empleado;
import com.example.distribuidora.repositorys.RepositoryEmpleados;
import org.apache.coyote.Response;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class EmpleadoService {

    @Autowired
    RepositoryEmpleados repositoryEmpleados;

    IDistruibuidoraMapper distribuidoraMapper = Mappers.getMapper(IDistruibuidoraMapper.class);


    //Registra Empleado
    public ResponseEntity registrarEmpleado(EmpleadoRegistroDto empleadoRegistroDto){
        Empleado empleado= distribuidoraMapper.EmpleadoDtotoEmpleado(empleadoRegistroDto);
        repositoryEmpleados.save(empleado);
        return ResponseEntity.ok().body(distribuidoraMapper.EmpleadotoEmpleadoRespuestaDto(empleado));
    }

    //Alista los Empleado
    public ResponseEntity listarEmpleados(){
        List<Empleado>listaEmpleados= repositoryEmpleados.findAll();
        if(listaEmpleados.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No existen empleados registrados");
        }
        else {
            return ResponseEntity.ok().body(distribuidoraMapper.getEmpleadosRespuestaDto(listaEmpleados));
        }

    }
    // Detalla un empeado en espcifico
    public ResponseEntity detallarEmpleado(Long id) {
        if(repositoryEmpleados.existsById(id)){
            Empleado empleado= repositoryEmpleados.getReferenceById(id);
            return ResponseEntity.ok().body(distribuidoraMapper.EmpleadotoEmpleadoRespuestaDto(empleado));
        }
        else {
            return ResponseEntity.badRequest().body("No hay un empleado registrado con ese id");
        }
    }


    public ResponseEntity actualizarEmpleado(Long id, EmpleadoActualizarDto empleadoActualizarDto) {
        if(repositoryEmpleados.existsById(id)){
            Empleado empleado= repositoryEmpleados.getReferenceById(id);
            empleado.actualizarInformacion(empleadoActualizarDto);
            repositoryEmpleados.save(empleado);
            return ResponseEntity.ok().body(distribuidoraMapper.EmpleadotoEmpleadoRespuestaDto(empleado));
        }else {
            return  ResponseEntity.badRequest().body("No esta regitrado un empleado con ese id en la base de datos");
        }
    }

    public ResponseEntity actualizarEstadoEmpleado(Long id, EmpleadoModificarEstado empleadoModificarEstado) {
        if (repositoryEmpleados.existsById(id)){
            Empleado empleado= repositoryEmpleados.getReferenceById(id);
            empleado.setEstado(empleadoModificarEstado.estado());
            repositoryEmpleados.save(empleado);
            return ResponseEntity.ok().body(distribuidoraMapper.EmpleadotoEmpleadoRespuestaDto(empleado));
        }else {
            return ResponseEntity.badRequest().body("No esta regitrado un empleado con ese id en la base de datos");
        }
    }
}
