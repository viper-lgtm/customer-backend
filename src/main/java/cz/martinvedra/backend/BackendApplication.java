package cz.martinvedra.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main entry point for the Spring Boot backend application.
 * This class is annotated with {@link SpringBootApplication}, which combines
 * {@code @Configuration}, {@code @EnableAutoConfiguration}, and {@code @ComponentScan}.
 * It bootstraps the application and starts the embedded Tomcat server.
 * <p>
 * This class contains the {@code main} method, which is the starting point
 * for the Java application.  It uses {@link SpringApplication#run(Class, String...)}
 * to launch the Spring application context.
 * </p>
 * @author Marty
 * @version 0.0.1-SNAPSHOT
 * @since 2024-02-08
 */
@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

}
