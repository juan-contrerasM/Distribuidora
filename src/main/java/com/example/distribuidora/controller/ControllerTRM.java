package com.example.distribuidora.controller;

import com.example.distribuidora.service.ConversionMonedaService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/TRM")
public class ControllerTRM {
    @Autowired
    ConversionMonedaService conversionMonedaService;

    @GetMapping
    public ResponseEntity obtenerValorMonedaExtranjera(){
        return conversionMonedaService.obtenerPrecioDollar();
    }
}
