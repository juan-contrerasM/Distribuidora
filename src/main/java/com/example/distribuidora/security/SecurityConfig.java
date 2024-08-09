package com.example.distribuidora.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);

        http.authorizeHttpRequests(request -> {
            //Endpoints de empleado
            request.requestMatchers("/empleados/guardarEmpleado").authenticated();
            request.requestMatchers("/empleados/listarEmpleado").permitAll();
            request.requestMatchers("/empleados//obtenerEmpleado/{id}").authenticated();
            request.requestMatchers("/empleados/actualizarEmpleado/{id}").permitAll();
            request.requestMatchers("/empleados/estado/{id}").authenticated();

            // Endpoints  de categoríaProducto
            request.requestMatchers("/categoriasProductos/guardarCategoria").permitAll();
            request.requestMatchers("/categoriasProductos/listarCategorias").permitAll();
            request.requestMatchers("/categoriasProductos/detallarCategoria/{id}").authenticated();
            request.requestMatchers("/categoriasProductos/eliminarCategoria/{id}").authenticated();
            request.requestMatchers("/categoriasProductos/modificarCategoria/{id}").authenticated();

            // Endpoints de producto
            request.requestMatchers("/productos/guardarProducto").permitAll();
            request.requestMatchers("/productos/actualizarProducto/{id}").permitAll();
            request.requestMatchers("/productos/eliminarProducto/{codigo}").authenticated();
            request.requestMatchers("/productos/listarProducto/{id}").authenticated();
            request.requestMatchers("/productos/actualizarStock/{id}").authenticated();
            // endpoint del TRM
            request.requestMatchers("/TRM").permitAll();



        }).httpBasic(Customizer.withDefaults());

        return http.build();
    }



}