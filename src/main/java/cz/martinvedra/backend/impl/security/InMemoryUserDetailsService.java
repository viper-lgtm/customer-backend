//package cz.martinvedra.backend.impl.security;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//public class InMemoryUserDetailsService implements UserDetailsService {
//
//    private static final Logger logger = LoggerFactory.getLogger(InMemoryUserDetailsService.class);
//
//    @Value("${spring.security.user.name}")
//    private String username;
//
//    @Value("${spring.security.user.password}")
//    private String password;
//
//    private final PasswordEncoder passwordEncoder;
//
//    public InMemoryUserDetailsService(PasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        logger.info("Načítání uživatele: {}", username);
//        if (this.username.equals(username)) {
//            logger.info("Uživatel nalezen, kódování hesla.");
//            return User.builder()
//                    .username(this.username)
//                    .password(passwordEncoder.encode(password))
//                    .roles("USER")
//                    .build();
//        } else {
//            logger.warn("Uživatel nenalezen: {}", username);
//            throw new UsernameNotFoundException("Uživatel nenalezen: " + username);
//        }
//    }
//}