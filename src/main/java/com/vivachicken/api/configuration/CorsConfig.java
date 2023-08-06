package com.vivachicken.api.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                .allowedOriginPatterns("*") // Permitir desde cualquier origen (cualquier dominio)
                .allowedMethods("*") // Permitir todos los métodos HTTP (GET, POST, PUT, DELETE, etc.)
                .allowedHeaders("*") // Permitir todos los encabezados
                .allowCredentials(true) // Permitir el envío de credenciales (cookies, autenticación básica, etc.)
                .maxAge(3600); // Tiempo máximo para que el navegador almacene en caché la configuración CORS
    }
}
