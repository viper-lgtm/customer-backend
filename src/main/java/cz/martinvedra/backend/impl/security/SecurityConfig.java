package cz.martinvedra.backend.impl.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
//@Order(2)
public class SecurityConfig {

    private static final Logger logger = LoggerFactory.getLogger(SecurityConfig.class);

    @Bean
    public SecurityFilterChain databaseFilterChain(HttpSecurity http) throws Exception {
        logger.info("Spouští se DatabaseSecurityFilterChain");

        http
                .csrf(csrf -> csrf.disable()) // Opravený řádek
                .authorizeHttpRequests((authz) -> authz.requestMatchers("/customer/save").permitAll())
                .authorizeHttpRequests((authz) -> authz.requestMatchers(HttpMethod.OPTIONS, "/customer/login").permitAll())
                .authorizeHttpRequests((authz) -> authz.requestMatchers("/customer/login").hasAuthority("USER"))
                .authorizeHttpRequests((authz) -> authz.requestMatchers("/customer").hasAuthority("USER"))
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}