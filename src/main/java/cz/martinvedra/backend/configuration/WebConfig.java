package cz.martinvedra.backend.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Apply to all endpoints under /api
                .allowedOrigins("http://localhost:3000") // Or your specific origins
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Or your specific methods
                .allowedHeaders("Authorization", "Content-Type"); // Specifikujeme hlavičky
//                .allowedHeaders("*"); // Or your specific headers (better practice)
    }
}
