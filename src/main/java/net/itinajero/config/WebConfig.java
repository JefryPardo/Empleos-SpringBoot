package net.itinajero.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{

    @Value("${empleos.ruta.imagenes}")//Se trae de config/WebConfig
    private String rutaImg;

    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/logos/**").addResourceLocations("file:"+rutaImg);
        //registry.addResourceHandler("/logos/**").addResourceLocations("file:/empleos/img-vacantes/"); windows
    }
}
