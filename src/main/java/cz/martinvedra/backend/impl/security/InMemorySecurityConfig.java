//package cz.martinvedra.backend.impl.security;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity
//@Order(1)
//public class InMemorySecurityConfig {
//
//    private static final Logger logger = LoggerFactory.getLogger(InMemorySecurityConfig.class);
//
//    @Value("${spring.security.user.name}")
//    private String username;
//
//    @Value("${spring.security.user.password}")
//    private String password;
//
//
//    @Bean
//    public SecurityFilterChain inMemoryFilterChain(HttpSecurity http) throws Exception {
//        logger.info("Spouští se SecurityFilterChain");
//
//        http
////                .headers(header -> header.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
////                .csrf(AbstractHttpConfigurer::disable)
////                .formLogin(AbstractHttpConfigurer::disable)
////                .authorizeHttpRequests(req -> req.requestMatchers("/public/**","/auth/**").permitAll())
////                .authorizeHttpRequests(req -> req.requestMatchers("/private/user/**").hasRole("USER"))
////                .authorizeHttpRequests(req -> req.requestMatchers("/customer").hasAuthority("USER"))
////                .authorizeHttpRequests(req -> req.requestMatchers("/customer").hasRole("USER"))
////                .authorizeHttpRequests(req -> req.requestMatchers("/private/admin/**").hasRole("ADMIN"))
////                .authorizeHttpRequests(req -> req.anyRequest().authenticated())
////                .httpBasic(Customizer.withDefaults());
////                .authorizeHttpRequests((authz) -> authz.requestMatchers("/customer").authenticated())
//                .authorizeHttpRequests((authz) -> authz.requestMatchers("/customer").hasRole("USER"))
//                .httpBasic(Customizer.withDefaults());
//        return http.build();
//    }
//
//    @Bean
//    public UserDetailsService users(PasswordEncoder passwordEncoder) {
//        logger.info("Načtené uživatelské jméno: {}", username);
//        logger.info("Načtené heslo: {}", password);
//
//        String encodedPassword = passwordEncoder.encode(password);
//        logger.info("Zakódované heslo: {}", encodedPassword);
//
//        UserDetails user = User.builder()
//                .username(username)
//                .password(encodedPassword)
//                .roles("USER")
//                .build();
//
////                UserDetails user = users.
////                .username("user")
////                .password("password")
////                .roles("USER")
////                .build();
//
//        return new InMemoryUserDetailsManager(user);
//    }
//
////    @Bean
////    public UserDetailsService users() {
////        // The builder will ensure the passwords are encoded before saving in memory
////        User.UserBuilder users = User.withDefaultPasswordEncoder();
////        UserDetails user = users
////                .username("user")
////                .password("password")
////                .roles("USER")
////                .build();
////        return new InMemoryUserDetailsManager(user);
////    }
//}