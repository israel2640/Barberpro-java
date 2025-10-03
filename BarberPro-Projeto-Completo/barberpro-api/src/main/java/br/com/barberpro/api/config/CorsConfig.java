package br.com.barberpro.api.config; 

import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull; // <-- 1. IMPORTAÇÃO ADICIONADA
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    // 2. ANOTAÇÃO @NonNull ADICIONADA AO PARÂMETRO "registry"
    public void addCorsMappings(@NonNull CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("https://barberpro-frontend.onrender.com")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");
    }
}