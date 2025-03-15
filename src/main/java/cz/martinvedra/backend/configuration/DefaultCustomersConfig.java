package cz.martinvedra.backend.configuration;

import cz.martinvedra.backend.impl.entity.CustomerEntity;
import cz.martinvedra.backend.impl.repo.CustomerRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

/**
 * Configuration class for the application.
 * This class contains methods for initializing the database with default data
 * upon application startup.  It uses the {@link ApplicationReadyEvent} to ensure
 * that the database initialization is performed after the Spring application
 * context is fully initialized.
 */
@Slf4j
@Configuration
@RequiredArgsConstructor
public class DefaultCustomersConfig implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * Initializes the database with default customer data.
     * This method is triggered by the {@link ApplicationReadyEvent}, which is
     * published after the Spring application context has been fully initialized.
     * <p>
     * The method uses a builder pattern to create the {@link CustomerEntity}
     * and the {@link CustomerRepository} to persist it to the database.
     * </p>
     *
     * <p>
     * This method is an event listener for the {@link ApplicationReadyEvent}.
     * While the event object is received by the method, it is not directly
     * used in the method's logic.  The event serves as a trigger to execute
     * the database initialization.
     * </p>
     */
    @EventListener(ApplicationReadyEvent.class)
    public void createJohnEntity() {
        CustomerEntity customerEntity = CustomerEntity.builder()
                .firstName("John")
                .lastName("Doe")
                .address("London")
                .email("johndoe@doe.com")
                .phone("720111222")
                .username("johndoe")
                .password(passwordEncoder.encode("johndoe"))
                .role("USER")
//                .password("johndoe")
                .build();
        CustomerEntity customerEntitySaved = customerRepository.save(customerEntity);
        log.info("Saved customerEntity: {}", customerEntitySaved);
    }

    /**
     * Initializes the database with default customer data after the application
     * context is ready.  This method is annotated with {@link PostConstruct}, so it
     * is executed after dependency injection is complete.  It checks if any
     * customers exist in the database and, if not, adds a default customer
     * (John Doe).
     * <p>
     * The method uses a builder pattern to create the {@link CustomerEntity}
     * and the {@link CustomerRepository} to persist it to the database.
     * </p>
     * <p>
     *   **Important:** This method is annotated with {@link Transactional} to ensure
     *   that the database operations are performed within a transaction.
     * </p>
     */
    @PostConstruct
//    @Transactional  // Essential for database operations
    public void createJaneEntity() {
        CustomerEntity customerEntity = CustomerEntity.builder()
                .firstName("Jane")
                .lastName("Wayne")
                .address("Paris")
                .email("janewayne@wayne.com")
                .phone("733999666")
                .username("janewayne")
                .password(passwordEncoder.encode("janewayne"))
                .role("USER")
                .build();
        CustomerEntity customerEntitySaved = customerRepository.save(customerEntity);
        log.info("Saved customerEntity: {}", customerEntitySaved);
    }

    @Override
    public void run(String... args) throws Exception {
        CustomerEntity customerEntity = CustomerEntity.builder()
                .firstName("Obi-Wan")
                .lastName("Kenobi")
                .address("Stewjon")
                .email("obiwan@obiwan.com")
                .phone("728555666")
                .username("obiwan")
                .password(passwordEncoder.encode("obiwan"))
                .role("ADMIN")
                .build();
        CustomerEntity customerEntitySaved = customerRepository.save(customerEntity);
        log.info("Saved customerEntity: {}", customerEntitySaved);
    }
}
